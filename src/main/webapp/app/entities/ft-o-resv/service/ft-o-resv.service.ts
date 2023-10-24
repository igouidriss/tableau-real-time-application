import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

import dayjs from 'dayjs/esm';

import { isPresent } from 'app/core/util/operators';
import { DATE_FORMAT } from 'app/config/input.constants';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IFtOResv, NewFtOResv } from '../ft-o-resv.model';

export type PartialUpdateFtOResv = Partial<IFtOResv> & Pick<IFtOResv, 'id'>;

type RestOf<T extends IFtOResv | NewFtOResv> = Omit<
  T,
  'businessDate' | 'dateDebutLigne' | 'dateFinLigne' | 'dateFinOrigine' | 'dateAnn' | 'techCreateDate' | 'techUpdateDate'
> & {
  businessDate?: string | null;
  dateDebutLigne?: string | null;
  dateFinLigne?: string | null;
  dateFinOrigine?: string | null;
  dateAnn?: string | null;
  techCreateDate?: string | null;
  techUpdateDate?: string | null;
};

export type RestFtOResv = RestOf<IFtOResv>;

export type NewRestFtOResv = RestOf<NewFtOResv>;

export type PartialUpdateRestFtOResv = RestOf<PartialUpdateFtOResv>;

export type EntityResponseType = HttpResponse<IFtOResv>;
export type EntityArrayResponseType = HttpResponse<IFtOResv[]>;

@Injectable({ providedIn: 'root' })
export class FtOResvService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/ft-o-resvs');

  constructor(
    protected http: HttpClient,
    protected applicationConfigService: ApplicationConfigService,
  ) {}

  create(ftOResv: NewFtOResv): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(ftOResv);
    return this.http
      .post<RestFtOResv>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  update(ftOResv: IFtOResv): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(ftOResv);
    return this.http
      .put<RestFtOResv>(`${this.resourceUrl}/${this.getFtOResvIdentifier(ftOResv)}`, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  partialUpdate(ftOResv: PartialUpdateFtOResv): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(ftOResv);
    return this.http
      .patch<RestFtOResv>(`${this.resourceUrl}/${this.getFtOResvIdentifier(ftOResv)}`, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<RestFtOResv>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<RestFtOResv[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map(res => this.convertResponseArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  getFtOResvIdentifier(ftOResv: Pick<IFtOResv, 'id'>): number {
    return ftOResv.id;
  }

  compareFtOResv(o1: Pick<IFtOResv, 'id'> | null, o2: Pick<IFtOResv, 'id'> | null): boolean {
    return o1 && o2 ? this.getFtOResvIdentifier(o1) === this.getFtOResvIdentifier(o2) : o1 === o2;
  }

  addFtOResvToCollectionIfMissing<Type extends Pick<IFtOResv, 'id'>>(
    ftOResvCollection: Type[],
    ...ftOResvsToCheck: (Type | null | undefined)[]
  ): Type[] {
    const ftOResvs: Type[] = ftOResvsToCheck.filter(isPresent);
    if (ftOResvs.length > 0) {
      const ftOResvCollectionIdentifiers = ftOResvCollection.map(ftOResvItem => this.getFtOResvIdentifier(ftOResvItem)!);
      const ftOResvsToAdd = ftOResvs.filter(ftOResvItem => {
        const ftOResvIdentifier = this.getFtOResvIdentifier(ftOResvItem);
        if (ftOResvCollectionIdentifiers.includes(ftOResvIdentifier)) {
          return false;
        }
        ftOResvCollectionIdentifiers.push(ftOResvIdentifier);
        return true;
      });
      return [...ftOResvsToAdd, ...ftOResvCollection];
    }
    return ftOResvCollection;
  }

  protected convertDateFromClient<T extends IFtOResv | NewFtOResv | PartialUpdateFtOResv>(ftOResv: T): RestOf<T> {
    return {
      ...ftOResv,
      businessDate: ftOResv.businessDate?.format(DATE_FORMAT) ?? null,
      dateDebutLigne: ftOResv.dateDebutLigne?.format(DATE_FORMAT) ?? null,
      dateFinLigne: ftOResv.dateFinLigne?.format(DATE_FORMAT) ?? null,
      dateFinOrigine: ftOResv.dateFinOrigine?.format(DATE_FORMAT) ?? null,
      dateAnn: ftOResv.dateAnn?.format(DATE_FORMAT) ?? null,
      techCreateDate: ftOResv.techCreateDate?.format(DATE_FORMAT) ?? null,
      techUpdateDate: ftOResv.techUpdateDate?.format(DATE_FORMAT) ?? null,
    };
  }

  protected convertDateFromServer(restFtOResv: RestFtOResv): IFtOResv {
    return {
      ...restFtOResv,
      businessDate: restFtOResv.businessDate ? dayjs(restFtOResv.businessDate) : undefined,
      dateDebutLigne: restFtOResv.dateDebutLigne ? dayjs(restFtOResv.dateDebutLigne) : undefined,
      dateFinLigne: restFtOResv.dateFinLigne ? dayjs(restFtOResv.dateFinLigne) : undefined,
      dateFinOrigine: restFtOResv.dateFinOrigine ? dayjs(restFtOResv.dateFinOrigine) : undefined,
      dateAnn: restFtOResv.dateAnn ? dayjs(restFtOResv.dateAnn) : undefined,
      techCreateDate: restFtOResv.techCreateDate ? dayjs(restFtOResv.techCreateDate) : undefined,
      techUpdateDate: restFtOResv.techUpdateDate ? dayjs(restFtOResv.techUpdateDate) : undefined,
    };
  }

  protected convertResponseFromServer(res: HttpResponse<RestFtOResv>): HttpResponse<IFtOResv> {
    return res.clone({
      body: res.body ? this.convertDateFromServer(res.body) : null,
    });
  }

  protected convertResponseArrayFromServer(res: HttpResponse<RestFtOResv[]>): HttpResponse<IFtOResv[]> {
    return res.clone({
      body: res.body ? res.body.map(item => this.convertDateFromServer(item)) : null,
    });
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

import dayjs from 'dayjs/esm';

import { isPresent } from 'app/core/util/operators';
import { DATE_FORMAT } from 'app/config/input.constants';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IDmOResv, NewDmOResv } from '../dm-o-resv.model';

export type PartialUpdateDmOResv = Partial<IDmOResv> & Pick<IDmOResv, 'id'>;

type RestOf<T extends IDmOResv | NewDmOResv> = Omit<
  T,
  | 'dateDebutResv'
  | 'dateFinResv'
  | 'truncDateDebutResv'
  | 'truncDateFinResv'
  | 'dateAnnResv'
  | 'crsInsertDate'
  | 'dateCreaResv'
  | 'datePremier'
  | 'dateDernier'
  | 'dateDernierPseudo'
  | 'techCreateDate'
  | 'techUpdateDate'
> & {
  dateDebutResv?: string | null;
  dateFinResv?: string | null;
  truncDateDebutResv?: string | null;
  truncDateFinResv?: string | null;
  dateAnnResv?: string | null;
  crsInsertDate?: string | null;
  dateCreaResv?: string | null;
  datePremier?: string | null;
  dateDernier?: string | null;
  dateDernierPseudo?: string | null;
  techCreateDate?: string | null;
  techUpdateDate?: string | null;
};

export type RestDmOResv = RestOf<IDmOResv>;

export type NewRestDmOResv = RestOf<NewDmOResv>;

export type PartialUpdateRestDmOResv = RestOf<PartialUpdateDmOResv>;

export type EntityResponseType = HttpResponse<IDmOResv>;
export type EntityArrayResponseType = HttpResponse<IDmOResv[]>;

@Injectable({ providedIn: 'root' })
export class DmOResvService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/dm-o-resvs');

  constructor(
    protected http: HttpClient,
    protected applicationConfigService: ApplicationConfigService,
  ) {}

  create(dmOResv: NewDmOResv): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(dmOResv);
    return this.http
      .post<RestDmOResv>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  update(dmOResv: IDmOResv): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(dmOResv);
    return this.http
      .put<RestDmOResv>(`${this.resourceUrl}/${this.getDmOResvIdentifier(dmOResv)}`, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  partialUpdate(dmOResv: PartialUpdateDmOResv): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(dmOResv);
    return this.http
      .patch<RestDmOResv>(`${this.resourceUrl}/${this.getDmOResvIdentifier(dmOResv)}`, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<RestDmOResv>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<RestDmOResv[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map(res => this.convertResponseArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  getDmOResvIdentifier(dmOResv: Pick<IDmOResv, 'id'>): number {
    return dmOResv.id;
  }

  compareDmOResv(o1: Pick<IDmOResv, 'id'> | null, o2: Pick<IDmOResv, 'id'> | null): boolean {
    return o1 && o2 ? this.getDmOResvIdentifier(o1) === this.getDmOResvIdentifier(o2) : o1 === o2;
  }

  addDmOResvToCollectionIfMissing<Type extends Pick<IDmOResv, 'id'>>(
    dmOResvCollection: Type[],
    ...dmOResvsToCheck: (Type | null | undefined)[]
  ): Type[] {
    const dmOResvs: Type[] = dmOResvsToCheck.filter(isPresent);
    if (dmOResvs.length > 0) {
      const dmOResvCollectionIdentifiers = dmOResvCollection.map(dmOResvItem => this.getDmOResvIdentifier(dmOResvItem)!);
      const dmOResvsToAdd = dmOResvs.filter(dmOResvItem => {
        const dmOResvIdentifier = this.getDmOResvIdentifier(dmOResvItem);
        if (dmOResvCollectionIdentifiers.includes(dmOResvIdentifier)) {
          return false;
        }
        dmOResvCollectionIdentifiers.push(dmOResvIdentifier);
        return true;
      });
      return [...dmOResvsToAdd, ...dmOResvCollection];
    }
    return dmOResvCollection;
  }

  protected convertDateFromClient<T extends IDmOResv | NewDmOResv | PartialUpdateDmOResv>(dmOResv: T): RestOf<T> {
    return {
      ...dmOResv,
      dateDebutResv: dmOResv.dateDebutResv?.format(DATE_FORMAT) ?? null,
      dateFinResv: dmOResv.dateFinResv?.format(DATE_FORMAT) ?? null,
      truncDateDebutResv: dmOResv.truncDateDebutResv?.format(DATE_FORMAT) ?? null,
      truncDateFinResv: dmOResv.truncDateFinResv?.format(DATE_FORMAT) ?? null,
      dateAnnResv: dmOResv.dateAnnResv?.format(DATE_FORMAT) ?? null,
      crsInsertDate: dmOResv.crsInsertDate?.format(DATE_FORMAT) ?? null,
      dateCreaResv: dmOResv.dateCreaResv?.format(DATE_FORMAT) ?? null,
      datePremier: dmOResv.datePremier?.format(DATE_FORMAT) ?? null,
      dateDernier: dmOResv.dateDernier?.format(DATE_FORMAT) ?? null,
      dateDernierPseudo: dmOResv.dateDernierPseudo?.format(DATE_FORMAT) ?? null,
      techCreateDate: dmOResv.techCreateDate?.format(DATE_FORMAT) ?? null,
      techUpdateDate: dmOResv.techUpdateDate?.format(DATE_FORMAT) ?? null,
    };
  }

  protected convertDateFromServer(restDmOResv: RestDmOResv): IDmOResv {
    return {
      ...restDmOResv,
      dateDebutResv: restDmOResv.dateDebutResv ? dayjs(restDmOResv.dateDebutResv) : undefined,
      dateFinResv: restDmOResv.dateFinResv ? dayjs(restDmOResv.dateFinResv) : undefined,
      truncDateDebutResv: restDmOResv.truncDateDebutResv ? dayjs(restDmOResv.truncDateDebutResv) : undefined,
      truncDateFinResv: restDmOResv.truncDateFinResv ? dayjs(restDmOResv.truncDateFinResv) : undefined,
      dateAnnResv: restDmOResv.dateAnnResv ? dayjs(restDmOResv.dateAnnResv) : undefined,
      crsInsertDate: restDmOResv.crsInsertDate ? dayjs(restDmOResv.crsInsertDate) : undefined,
      dateCreaResv: restDmOResv.dateCreaResv ? dayjs(restDmOResv.dateCreaResv) : undefined,
      datePremier: restDmOResv.datePremier ? dayjs(restDmOResv.datePremier) : undefined,
      dateDernier: restDmOResv.dateDernier ? dayjs(restDmOResv.dateDernier) : undefined,
      dateDernierPseudo: restDmOResv.dateDernierPseudo ? dayjs(restDmOResv.dateDernierPseudo) : undefined,
      techCreateDate: restDmOResv.techCreateDate ? dayjs(restDmOResv.techCreateDate) : undefined,
      techUpdateDate: restDmOResv.techUpdateDate ? dayjs(restDmOResv.techUpdateDate) : undefined,
    };
  }

  protected convertResponseFromServer(res: HttpResponse<RestDmOResv>): HttpResponse<IDmOResv> {
    return res.clone({
      body: res.body ? this.convertDateFromServer(res.body) : null,
    });
  }

  protected convertResponseArrayFromServer(res: HttpResponse<RestDmOResv[]>): HttpResponse<IDmOResv[]> {
    return res.clone({
      body: res.body ? res.body.map(item => this.convertDateFromServer(item)) : null,
    });
  }
}

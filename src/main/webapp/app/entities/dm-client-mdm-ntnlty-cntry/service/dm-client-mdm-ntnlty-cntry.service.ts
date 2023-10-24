import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

import dayjs from 'dayjs/esm';

import { isPresent } from 'app/core/util/operators';
import { DATE_FORMAT } from 'app/config/input.constants';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IDmClientMdmNtnltyCntry, NewDmClientMdmNtnltyCntry } from '../dm-client-mdm-ntnlty-cntry.model';

export type PartialUpdateDmClientMdmNtnltyCntry = Partial<IDmClientMdmNtnltyCntry> & Pick<IDmClientMdmNtnltyCntry, 'id'>;

type RestOf<T extends IDmClientMdmNtnltyCntry | NewDmClientMdmNtnltyCntry> = Omit<T, 'techCreatedDate' | 'techUpdatedDate'> & {
  techCreatedDate?: string | null;
  techUpdatedDate?: string | null;
};

export type RestDmClientMdmNtnltyCntry = RestOf<IDmClientMdmNtnltyCntry>;

export type NewRestDmClientMdmNtnltyCntry = RestOf<NewDmClientMdmNtnltyCntry>;

export type PartialUpdateRestDmClientMdmNtnltyCntry = RestOf<PartialUpdateDmClientMdmNtnltyCntry>;

export type EntityResponseType = HttpResponse<IDmClientMdmNtnltyCntry>;
export type EntityArrayResponseType = HttpResponse<IDmClientMdmNtnltyCntry[]>;

@Injectable({ providedIn: 'root' })
export class DmClientMdmNtnltyCntryService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/dm-client-mdm-ntnlty-cntries');

  constructor(
    protected http: HttpClient,
    protected applicationConfigService: ApplicationConfigService,
  ) {}

  create(dmClientMdmNtnltyCntry: NewDmClientMdmNtnltyCntry): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(dmClientMdmNtnltyCntry);
    return this.http
      .post<RestDmClientMdmNtnltyCntry>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  update(dmClientMdmNtnltyCntry: IDmClientMdmNtnltyCntry): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(dmClientMdmNtnltyCntry);
    return this.http
      .put<RestDmClientMdmNtnltyCntry>(`${this.resourceUrl}/${this.getDmClientMdmNtnltyCntryIdentifier(dmClientMdmNtnltyCntry)}`, copy, {
        observe: 'response',
      })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  partialUpdate(dmClientMdmNtnltyCntry: PartialUpdateDmClientMdmNtnltyCntry): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(dmClientMdmNtnltyCntry);
    return this.http
      .patch<RestDmClientMdmNtnltyCntry>(`${this.resourceUrl}/${this.getDmClientMdmNtnltyCntryIdentifier(dmClientMdmNtnltyCntry)}`, copy, {
        observe: 'response',
      })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<RestDmClientMdmNtnltyCntry>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<RestDmClientMdmNtnltyCntry[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map(res => this.convertResponseArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  getDmClientMdmNtnltyCntryIdentifier(dmClientMdmNtnltyCntry: Pick<IDmClientMdmNtnltyCntry, 'id'>): number {
    return dmClientMdmNtnltyCntry.id;
  }

  compareDmClientMdmNtnltyCntry(o1: Pick<IDmClientMdmNtnltyCntry, 'id'> | null, o2: Pick<IDmClientMdmNtnltyCntry, 'id'> | null): boolean {
    return o1 && o2 ? this.getDmClientMdmNtnltyCntryIdentifier(o1) === this.getDmClientMdmNtnltyCntryIdentifier(o2) : o1 === o2;
  }

  addDmClientMdmNtnltyCntryToCollectionIfMissing<Type extends Pick<IDmClientMdmNtnltyCntry, 'id'>>(
    dmClientMdmNtnltyCntryCollection: Type[],
    ...dmClientMdmNtnltyCntriesToCheck: (Type | null | undefined)[]
  ): Type[] {
    const dmClientMdmNtnltyCntries: Type[] = dmClientMdmNtnltyCntriesToCheck.filter(isPresent);
    if (dmClientMdmNtnltyCntries.length > 0) {
      const dmClientMdmNtnltyCntryCollectionIdentifiers = dmClientMdmNtnltyCntryCollection.map(
        dmClientMdmNtnltyCntryItem => this.getDmClientMdmNtnltyCntryIdentifier(dmClientMdmNtnltyCntryItem)!,
      );
      const dmClientMdmNtnltyCntriesToAdd = dmClientMdmNtnltyCntries.filter(dmClientMdmNtnltyCntryItem => {
        const dmClientMdmNtnltyCntryIdentifier = this.getDmClientMdmNtnltyCntryIdentifier(dmClientMdmNtnltyCntryItem);
        if (dmClientMdmNtnltyCntryCollectionIdentifiers.includes(dmClientMdmNtnltyCntryIdentifier)) {
          return false;
        }
        dmClientMdmNtnltyCntryCollectionIdentifiers.push(dmClientMdmNtnltyCntryIdentifier);
        return true;
      });
      return [...dmClientMdmNtnltyCntriesToAdd, ...dmClientMdmNtnltyCntryCollection];
    }
    return dmClientMdmNtnltyCntryCollection;
  }

  protected convertDateFromClient<T extends IDmClientMdmNtnltyCntry | NewDmClientMdmNtnltyCntry | PartialUpdateDmClientMdmNtnltyCntry>(
    dmClientMdmNtnltyCntry: T,
  ): RestOf<T> {
    return {
      ...dmClientMdmNtnltyCntry,
      techCreatedDate: dmClientMdmNtnltyCntry.techCreatedDate?.format(DATE_FORMAT) ?? null,
      techUpdatedDate: dmClientMdmNtnltyCntry.techUpdatedDate?.format(DATE_FORMAT) ?? null,
    };
  }

  protected convertDateFromServer(restDmClientMdmNtnltyCntry: RestDmClientMdmNtnltyCntry): IDmClientMdmNtnltyCntry {
    return {
      ...restDmClientMdmNtnltyCntry,
      techCreatedDate: restDmClientMdmNtnltyCntry.techCreatedDate ? dayjs(restDmClientMdmNtnltyCntry.techCreatedDate) : undefined,
      techUpdatedDate: restDmClientMdmNtnltyCntry.techUpdatedDate ? dayjs(restDmClientMdmNtnltyCntry.techUpdatedDate) : undefined,
    };
  }

  protected convertResponseFromServer(res: HttpResponse<RestDmClientMdmNtnltyCntry>): HttpResponse<IDmClientMdmNtnltyCntry> {
    return res.clone({
      body: res.body ? this.convertDateFromServer(res.body) : null,
    });
  }

  protected convertResponseArrayFromServer(res: HttpResponse<RestDmClientMdmNtnltyCntry[]>): HttpResponse<IDmClientMdmNtnltyCntry[]> {
    return res.clone({
      body: res.body ? res.body.map(item => this.convertDateFromServer(item)) : null,
    });
  }
}

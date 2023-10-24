import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

import dayjs from 'dayjs/esm';

import { isPresent } from 'app/core/util/operators';
import { DATE_FORMAT } from 'app/config/input.constants';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IDmClientMdmAddrCntry, NewDmClientMdmAddrCntry } from '../dm-client-mdm-addr-cntry.model';

export type PartialUpdateDmClientMdmAddrCntry = Partial<IDmClientMdmAddrCntry> & Pick<IDmClientMdmAddrCntry, 'id'>;

type RestOf<T extends IDmClientMdmAddrCntry | NewDmClientMdmAddrCntry> = Omit<T, 'techCreatedDate' | 'techUpdatedDate'> & {
  techCreatedDate?: string | null;
  techUpdatedDate?: string | null;
};

export type RestDmClientMdmAddrCntry = RestOf<IDmClientMdmAddrCntry>;

export type NewRestDmClientMdmAddrCntry = RestOf<NewDmClientMdmAddrCntry>;

export type PartialUpdateRestDmClientMdmAddrCntry = RestOf<PartialUpdateDmClientMdmAddrCntry>;

export type EntityResponseType = HttpResponse<IDmClientMdmAddrCntry>;
export type EntityArrayResponseType = HttpResponse<IDmClientMdmAddrCntry[]>;

@Injectable({ providedIn: 'root' })
export class DmClientMdmAddrCntryService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/dm-client-mdm-addr-cntries');

  constructor(
    protected http: HttpClient,
    protected applicationConfigService: ApplicationConfigService,
  ) {}

  create(dmClientMdmAddrCntry: NewDmClientMdmAddrCntry): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(dmClientMdmAddrCntry);
    return this.http
      .post<RestDmClientMdmAddrCntry>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  update(dmClientMdmAddrCntry: IDmClientMdmAddrCntry): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(dmClientMdmAddrCntry);
    return this.http
      .put<RestDmClientMdmAddrCntry>(`${this.resourceUrl}/${this.getDmClientMdmAddrCntryIdentifier(dmClientMdmAddrCntry)}`, copy, {
        observe: 'response',
      })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  partialUpdate(dmClientMdmAddrCntry: PartialUpdateDmClientMdmAddrCntry): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(dmClientMdmAddrCntry);
    return this.http
      .patch<RestDmClientMdmAddrCntry>(`${this.resourceUrl}/${this.getDmClientMdmAddrCntryIdentifier(dmClientMdmAddrCntry)}`, copy, {
        observe: 'response',
      })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<RestDmClientMdmAddrCntry>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<RestDmClientMdmAddrCntry[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map(res => this.convertResponseArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  getDmClientMdmAddrCntryIdentifier(dmClientMdmAddrCntry: Pick<IDmClientMdmAddrCntry, 'id'>): number {
    return dmClientMdmAddrCntry.id;
  }

  compareDmClientMdmAddrCntry(o1: Pick<IDmClientMdmAddrCntry, 'id'> | null, o2: Pick<IDmClientMdmAddrCntry, 'id'> | null): boolean {
    return o1 && o2 ? this.getDmClientMdmAddrCntryIdentifier(o1) === this.getDmClientMdmAddrCntryIdentifier(o2) : o1 === o2;
  }

  addDmClientMdmAddrCntryToCollectionIfMissing<Type extends Pick<IDmClientMdmAddrCntry, 'id'>>(
    dmClientMdmAddrCntryCollection: Type[],
    ...dmClientMdmAddrCntriesToCheck: (Type | null | undefined)[]
  ): Type[] {
    const dmClientMdmAddrCntries: Type[] = dmClientMdmAddrCntriesToCheck.filter(isPresent);
    if (dmClientMdmAddrCntries.length > 0) {
      const dmClientMdmAddrCntryCollectionIdentifiers = dmClientMdmAddrCntryCollection.map(
        dmClientMdmAddrCntryItem => this.getDmClientMdmAddrCntryIdentifier(dmClientMdmAddrCntryItem)!,
      );
      const dmClientMdmAddrCntriesToAdd = dmClientMdmAddrCntries.filter(dmClientMdmAddrCntryItem => {
        const dmClientMdmAddrCntryIdentifier = this.getDmClientMdmAddrCntryIdentifier(dmClientMdmAddrCntryItem);
        if (dmClientMdmAddrCntryCollectionIdentifiers.includes(dmClientMdmAddrCntryIdentifier)) {
          return false;
        }
        dmClientMdmAddrCntryCollectionIdentifiers.push(dmClientMdmAddrCntryIdentifier);
        return true;
      });
      return [...dmClientMdmAddrCntriesToAdd, ...dmClientMdmAddrCntryCollection];
    }
    return dmClientMdmAddrCntryCollection;
  }

  protected convertDateFromClient<T extends IDmClientMdmAddrCntry | NewDmClientMdmAddrCntry | PartialUpdateDmClientMdmAddrCntry>(
    dmClientMdmAddrCntry: T,
  ): RestOf<T> {
    return {
      ...dmClientMdmAddrCntry,
      techCreatedDate: dmClientMdmAddrCntry.techCreatedDate?.format(DATE_FORMAT) ?? null,
      techUpdatedDate: dmClientMdmAddrCntry.techUpdatedDate?.format(DATE_FORMAT) ?? null,
    };
  }

  protected convertDateFromServer(restDmClientMdmAddrCntry: RestDmClientMdmAddrCntry): IDmClientMdmAddrCntry {
    return {
      ...restDmClientMdmAddrCntry,
      techCreatedDate: restDmClientMdmAddrCntry.techCreatedDate ? dayjs(restDmClientMdmAddrCntry.techCreatedDate) : undefined,
      techUpdatedDate: restDmClientMdmAddrCntry.techUpdatedDate ? dayjs(restDmClientMdmAddrCntry.techUpdatedDate) : undefined,
    };
  }

  protected convertResponseFromServer(res: HttpResponse<RestDmClientMdmAddrCntry>): HttpResponse<IDmClientMdmAddrCntry> {
    return res.clone({
      body: res.body ? this.convertDateFromServer(res.body) : null,
    });
  }

  protected convertResponseArrayFromServer(res: HttpResponse<RestDmClientMdmAddrCntry[]>): HttpResponse<IDmClientMdmAddrCntry[]> {
    return res.clone({
      body: res.body ? res.body.map(item => this.convertDateFromServer(item)) : null,
    });
  }
}

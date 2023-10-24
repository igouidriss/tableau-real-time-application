import { inject } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { of, EMPTY, Observable } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IDmClientMdmAddrCntry } from '../dm-client-mdm-addr-cntry.model';
import { DmClientMdmAddrCntryService } from '../service/dm-client-mdm-addr-cntry.service';

export const dmClientMdmAddrCntryResolve = (route: ActivatedRouteSnapshot): Observable<null | IDmClientMdmAddrCntry> => {
  const id = route.params['id'];
  if (id) {
    return inject(DmClientMdmAddrCntryService)
      .find(id)
      .pipe(
        mergeMap((dmClientMdmAddrCntry: HttpResponse<IDmClientMdmAddrCntry>) => {
          if (dmClientMdmAddrCntry.body) {
            return of(dmClientMdmAddrCntry.body);
          } else {
            inject(Router).navigate(['404']);
            return EMPTY;
          }
        }),
      );
  }
  return of(null);
};

export default dmClientMdmAddrCntryResolve;

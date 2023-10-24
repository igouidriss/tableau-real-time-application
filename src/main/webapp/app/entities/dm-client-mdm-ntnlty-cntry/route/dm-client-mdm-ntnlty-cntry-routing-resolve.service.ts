import { inject } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { of, EMPTY, Observable } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IDmClientMdmNtnltyCntry } from '../dm-client-mdm-ntnlty-cntry.model';
import { DmClientMdmNtnltyCntryService } from '../service/dm-client-mdm-ntnlty-cntry.service';

export const dmClientMdmNtnltyCntryResolve = (route: ActivatedRouteSnapshot): Observable<null | IDmClientMdmNtnltyCntry> => {
  const id = route.params['id'];
  if (id) {
    return inject(DmClientMdmNtnltyCntryService)
      .find(id)
      .pipe(
        mergeMap((dmClientMdmNtnltyCntry: HttpResponse<IDmClientMdmNtnltyCntry>) => {
          if (dmClientMdmNtnltyCntry.body) {
            return of(dmClientMdmNtnltyCntry.body);
          } else {
            inject(Router).navigate(['404']);
            return EMPTY;
          }
        }),
      );
  }
  return of(null);
};

export default dmClientMdmNtnltyCntryResolve;

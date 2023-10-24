import { inject } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { of, EMPTY, Observable } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IDmOResv } from '../dm-o-resv.model';
import { DmOResvService } from '../service/dm-o-resv.service';

export const dmOResvResolve = (route: ActivatedRouteSnapshot): Observable<null | IDmOResv> => {
  const id = route.params['id'];
  if (id) {
    return inject(DmOResvService)
      .find(id)
      .pipe(
        mergeMap((dmOResv: HttpResponse<IDmOResv>) => {
          if (dmOResv.body) {
            return of(dmOResv.body);
          } else {
            inject(Router).navigate(['404']);
            return EMPTY;
          }
        }),
      );
  }
  return of(null);
};

export default dmOResvResolve;

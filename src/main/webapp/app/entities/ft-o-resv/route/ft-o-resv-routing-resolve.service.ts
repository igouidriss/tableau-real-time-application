import { inject } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { of, EMPTY, Observable } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IFtOResv } from '../ft-o-resv.model';
import { FtOResvService } from '../service/ft-o-resv.service';

export const ftOResvResolve = (route: ActivatedRouteSnapshot): Observable<null | IFtOResv> => {
  const id = route.params['id'];
  if (id) {
    return inject(FtOResvService)
      .find(id)
      .pipe(
        mergeMap((ftOResv: HttpResponse<IFtOResv>) => {
          if (ftOResv.body) {
            return of(ftOResv.body);
          } else {
            inject(Router).navigate(['404']);
            return EMPTY;
          }
        }),
      );
  }
  return of(null);
};

export default ftOResvResolve;

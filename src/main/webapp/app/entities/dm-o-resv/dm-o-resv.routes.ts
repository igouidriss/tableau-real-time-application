import { Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { ASC } from 'app/config/navigation.constants';
import { DmOResvComponent } from './list/dm-o-resv.component';
import { DmOResvDetailComponent } from './detail/dm-o-resv-detail.component';
import { DmOResvUpdateComponent } from './update/dm-o-resv-update.component';
import DmOResvResolve from './route/dm-o-resv-routing-resolve.service';

const dmOResvRoute: Routes = [
  {
    path: '',
    component: DmOResvComponent,
    data: {
      defaultSort: 'id,' + ASC,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: DmOResvDetailComponent,
    resolve: {
      dmOResv: DmOResvResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: DmOResvUpdateComponent,
    resolve: {
      dmOResv: DmOResvResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: DmOResvUpdateComponent,
    resolve: {
      dmOResv: DmOResvResolve,
    },
    canActivate: [UserRouteAccessService],
  },
];

export default dmOResvRoute;

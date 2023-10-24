import { Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { ASC } from 'app/config/navigation.constants';
import { FtOResvComponent } from './list/ft-o-resv.component';
import { FtOResvDetailComponent } from './detail/ft-o-resv-detail.component';
import { FtOResvUpdateComponent } from './update/ft-o-resv-update.component';
import FtOResvResolve from './route/ft-o-resv-routing-resolve.service';

const ftOResvRoute: Routes = [
  {
    path: '',
    component: FtOResvComponent,
    data: {
      defaultSort: 'id,' + ASC,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: FtOResvDetailComponent,
    resolve: {
      ftOResv: FtOResvResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: FtOResvUpdateComponent,
    resolve: {
      ftOResv: FtOResvResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: FtOResvUpdateComponent,
    resolve: {
      ftOResv: FtOResvResolve,
    },
    canActivate: [UserRouteAccessService],
  },
];

export default ftOResvRoute;

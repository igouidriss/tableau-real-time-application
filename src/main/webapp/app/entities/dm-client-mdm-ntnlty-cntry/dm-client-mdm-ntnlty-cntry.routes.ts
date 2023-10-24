import { Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { ASC } from 'app/config/navigation.constants';
import { DmClientMdmNtnltyCntryComponent } from './list/dm-client-mdm-ntnlty-cntry.component';
import { DmClientMdmNtnltyCntryDetailComponent } from './detail/dm-client-mdm-ntnlty-cntry-detail.component';
import { DmClientMdmNtnltyCntryUpdateComponent } from './update/dm-client-mdm-ntnlty-cntry-update.component';
import DmClientMdmNtnltyCntryResolve from './route/dm-client-mdm-ntnlty-cntry-routing-resolve.service';

const dmClientMdmNtnltyCntryRoute: Routes = [
  {
    path: '',
    component: DmClientMdmNtnltyCntryComponent,
    data: {
      defaultSort: 'id,' + ASC,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: DmClientMdmNtnltyCntryDetailComponent,
    resolve: {
      dmClientMdmNtnltyCntry: DmClientMdmNtnltyCntryResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: DmClientMdmNtnltyCntryUpdateComponent,
    resolve: {
      dmClientMdmNtnltyCntry: DmClientMdmNtnltyCntryResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: DmClientMdmNtnltyCntryUpdateComponent,
    resolve: {
      dmClientMdmNtnltyCntry: DmClientMdmNtnltyCntryResolve,
    },
    canActivate: [UserRouteAccessService],
  },
];

export default dmClientMdmNtnltyCntryRoute;

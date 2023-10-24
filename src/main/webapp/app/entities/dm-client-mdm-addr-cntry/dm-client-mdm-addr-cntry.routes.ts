import { Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { ASC } from 'app/config/navigation.constants';
import { DmClientMdmAddrCntryComponent } from './list/dm-client-mdm-addr-cntry.component';
import { DmClientMdmAddrCntryDetailComponent } from './detail/dm-client-mdm-addr-cntry-detail.component';
import { DmClientMdmAddrCntryUpdateComponent } from './update/dm-client-mdm-addr-cntry-update.component';
import DmClientMdmAddrCntryResolve from './route/dm-client-mdm-addr-cntry-routing-resolve.service';

const dmClientMdmAddrCntryRoute: Routes = [
  {
    path: '',
    component: DmClientMdmAddrCntryComponent,
    data: {
      defaultSort: 'id,' + ASC,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: DmClientMdmAddrCntryDetailComponent,
    resolve: {
      dmClientMdmAddrCntry: DmClientMdmAddrCntryResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: DmClientMdmAddrCntryUpdateComponent,
    resolve: {
      dmClientMdmAddrCntry: DmClientMdmAddrCntryResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: DmClientMdmAddrCntryUpdateComponent,
    resolve: {
      dmClientMdmAddrCntry: DmClientMdmAddrCntryResolve,
    },
    canActivate: [UserRouteAccessService],
  },
];

export default dmClientMdmAddrCntryRoute;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'dm-client-mdm-addr-cntry',
        data: { pageTitle: 'tableauRealTimeApplicationApp.dmClientMdmAddrCntry.home.title' },
        loadChildren: () => import('./dm-client-mdm-addr-cntry/dm-client-mdm-addr-cntry.routes'),
      },
      {
        path: 'dm-client-mdm-ntnlty-cntry',
        data: { pageTitle: 'tableauRealTimeApplicationApp.dmClientMdmNtnltyCntry.home.title' },
        loadChildren: () => import('./dm-client-mdm-ntnlty-cntry/dm-client-mdm-ntnlty-cntry.routes'),
      },
      {
        path: 'ft-o-resv',
        data: { pageTitle: 'tableauRealTimeApplicationApp.ftOResv.home.title' },
        loadChildren: () => import('./ft-o-resv/ft-o-resv.routes'),
      },
      {
        path: 'dm-o-resv',
        data: { pageTitle: 'tableauRealTimeApplicationApp.dmOResv.home.title' },
        loadChildren: () => import('./dm-o-resv/dm-o-resv.routes'),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}

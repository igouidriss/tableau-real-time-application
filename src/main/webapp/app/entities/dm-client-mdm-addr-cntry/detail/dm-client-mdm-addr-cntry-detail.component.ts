import { Component, Input } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';

import SharedModule from 'app/shared/shared.module';
import { DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe } from 'app/shared/date';
import { IDmClientMdmAddrCntry } from '../dm-client-mdm-addr-cntry.model';

@Component({
  standalone: true,
  selector: 'jhi-dm-client-mdm-addr-cntry-detail',
  templateUrl: './dm-client-mdm-addr-cntry-detail.component.html',
  imports: [SharedModule, RouterModule, DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe],
})
export class DmClientMdmAddrCntryDetailComponent {
  @Input() dmClientMdmAddrCntry: IDmClientMdmAddrCntry | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  previousState(): void {
    window.history.back();
  }
}

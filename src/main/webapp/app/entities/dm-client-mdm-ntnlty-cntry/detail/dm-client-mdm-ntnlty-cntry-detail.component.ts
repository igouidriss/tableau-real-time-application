import { Component, Input } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';

import SharedModule from 'app/shared/shared.module';
import { DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe } from 'app/shared/date';
import { IDmClientMdmNtnltyCntry } from '../dm-client-mdm-ntnlty-cntry.model';

@Component({
  standalone: true,
  selector: 'jhi-dm-client-mdm-ntnlty-cntry-detail',
  templateUrl: './dm-client-mdm-ntnlty-cntry-detail.component.html',
  imports: [SharedModule, RouterModule, DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe],
})
export class DmClientMdmNtnltyCntryDetailComponent {
  @Input() dmClientMdmNtnltyCntry: IDmClientMdmNtnltyCntry | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  previousState(): void {
    window.history.back();
  }
}

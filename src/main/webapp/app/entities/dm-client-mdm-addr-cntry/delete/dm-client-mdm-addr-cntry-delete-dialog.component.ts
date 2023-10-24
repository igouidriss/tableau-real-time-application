import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import SharedModule from 'app/shared/shared.module';
import { ITEM_DELETED_EVENT } from 'app/config/navigation.constants';
import { IDmClientMdmAddrCntry } from '../dm-client-mdm-addr-cntry.model';
import { DmClientMdmAddrCntryService } from '../service/dm-client-mdm-addr-cntry.service';

@Component({
  standalone: true,
  templateUrl: './dm-client-mdm-addr-cntry-delete-dialog.component.html',
  imports: [SharedModule, FormsModule],
})
export class DmClientMdmAddrCntryDeleteDialogComponent {
  dmClientMdmAddrCntry?: IDmClientMdmAddrCntry;

  constructor(
    protected dmClientMdmAddrCntryService: DmClientMdmAddrCntryService,
    protected activeModal: NgbActiveModal,
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.dmClientMdmAddrCntryService.delete(id).subscribe(() => {
      this.activeModal.close(ITEM_DELETED_EVENT);
    });
  }
}

import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import SharedModule from 'app/shared/shared.module';
import { ITEM_DELETED_EVENT } from 'app/config/navigation.constants';
import { IDmClientMdmNtnltyCntry } from '../dm-client-mdm-ntnlty-cntry.model';
import { DmClientMdmNtnltyCntryService } from '../service/dm-client-mdm-ntnlty-cntry.service';

@Component({
  standalone: true,
  templateUrl: './dm-client-mdm-ntnlty-cntry-delete-dialog.component.html',
  imports: [SharedModule, FormsModule],
})
export class DmClientMdmNtnltyCntryDeleteDialogComponent {
  dmClientMdmNtnltyCntry?: IDmClientMdmNtnltyCntry;

  constructor(
    protected dmClientMdmNtnltyCntryService: DmClientMdmNtnltyCntryService,
    protected activeModal: NgbActiveModal,
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.dmClientMdmNtnltyCntryService.delete(id).subscribe(() => {
      this.activeModal.close(ITEM_DELETED_EVENT);
    });
  }
}

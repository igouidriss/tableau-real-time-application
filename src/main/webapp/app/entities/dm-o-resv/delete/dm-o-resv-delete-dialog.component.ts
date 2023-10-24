import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import SharedModule from 'app/shared/shared.module';
import { ITEM_DELETED_EVENT } from 'app/config/navigation.constants';
import { IDmOResv } from '../dm-o-resv.model';
import { DmOResvService } from '../service/dm-o-resv.service';

@Component({
  standalone: true,
  templateUrl: './dm-o-resv-delete-dialog.component.html',
  imports: [SharedModule, FormsModule],
})
export class DmOResvDeleteDialogComponent {
  dmOResv?: IDmOResv;

  constructor(
    protected dmOResvService: DmOResvService,
    protected activeModal: NgbActiveModal,
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.dmOResvService.delete(id).subscribe(() => {
      this.activeModal.close(ITEM_DELETED_EVENT);
    });
  }
}

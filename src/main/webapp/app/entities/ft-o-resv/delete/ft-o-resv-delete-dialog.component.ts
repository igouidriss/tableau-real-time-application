import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import SharedModule from 'app/shared/shared.module';
import { ITEM_DELETED_EVENT } from 'app/config/navigation.constants';
import { IFtOResv } from '../ft-o-resv.model';
import { FtOResvService } from '../service/ft-o-resv.service';

@Component({
  standalone: true,
  templateUrl: './ft-o-resv-delete-dialog.component.html',
  imports: [SharedModule, FormsModule],
})
export class FtOResvDeleteDialogComponent {
  ftOResv?: IFtOResv;

  constructor(
    protected ftOResvService: FtOResvService,
    protected activeModal: NgbActiveModal,
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.ftOResvService.delete(id).subscribe(() => {
      this.activeModal.close(ITEM_DELETED_EVENT);
    });
  }
}

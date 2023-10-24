import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import SharedModule from 'app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IDmClientMdmAddrCntry } from '../dm-client-mdm-addr-cntry.model';
import { DmClientMdmAddrCntryService } from '../service/dm-client-mdm-addr-cntry.service';
import { DmClientMdmAddrCntryFormService, DmClientMdmAddrCntryFormGroup } from './dm-client-mdm-addr-cntry-form.service';

@Component({
  standalone: true,
  selector: 'jhi-dm-client-mdm-addr-cntry-update',
  templateUrl: './dm-client-mdm-addr-cntry-update.component.html',
  imports: [SharedModule, FormsModule, ReactiveFormsModule],
})
export class DmClientMdmAddrCntryUpdateComponent implements OnInit {
  isSaving = false;
  dmClientMdmAddrCntry: IDmClientMdmAddrCntry | null = null;

  editForm: DmClientMdmAddrCntryFormGroup = this.dmClientMdmAddrCntryFormService.createDmClientMdmAddrCntryFormGroup();

  constructor(
    protected dmClientMdmAddrCntryService: DmClientMdmAddrCntryService,
    protected dmClientMdmAddrCntryFormService: DmClientMdmAddrCntryFormService,
    protected activatedRoute: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dmClientMdmAddrCntry }) => {
      this.dmClientMdmAddrCntry = dmClientMdmAddrCntry;
      if (dmClientMdmAddrCntry) {
        this.updateForm(dmClientMdmAddrCntry);
      }
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const dmClientMdmAddrCntry = this.dmClientMdmAddrCntryFormService.getDmClientMdmAddrCntry(this.editForm);
    if (dmClientMdmAddrCntry.id !== null) {
      this.subscribeToSaveResponse(this.dmClientMdmAddrCntryService.update(dmClientMdmAddrCntry));
    } else {
      this.subscribeToSaveResponse(this.dmClientMdmAddrCntryService.create(dmClientMdmAddrCntry));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDmClientMdmAddrCntry>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(dmClientMdmAddrCntry: IDmClientMdmAddrCntry): void {
    this.dmClientMdmAddrCntry = dmClientMdmAddrCntry;
    this.dmClientMdmAddrCntryFormService.resetForm(this.editForm, dmClientMdmAddrCntry);
  }
}

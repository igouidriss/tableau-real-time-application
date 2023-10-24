import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import SharedModule from 'app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IDmClientMdmNtnltyCntry } from '../dm-client-mdm-ntnlty-cntry.model';
import { DmClientMdmNtnltyCntryService } from '../service/dm-client-mdm-ntnlty-cntry.service';
import { DmClientMdmNtnltyCntryFormService, DmClientMdmNtnltyCntryFormGroup } from './dm-client-mdm-ntnlty-cntry-form.service';

@Component({
  standalone: true,
  selector: 'jhi-dm-client-mdm-ntnlty-cntry-update',
  templateUrl: './dm-client-mdm-ntnlty-cntry-update.component.html',
  imports: [SharedModule, FormsModule, ReactiveFormsModule],
})
export class DmClientMdmNtnltyCntryUpdateComponent implements OnInit {
  isSaving = false;
  dmClientMdmNtnltyCntry: IDmClientMdmNtnltyCntry | null = null;

  editForm: DmClientMdmNtnltyCntryFormGroup = this.dmClientMdmNtnltyCntryFormService.createDmClientMdmNtnltyCntryFormGroup();

  constructor(
    protected dmClientMdmNtnltyCntryService: DmClientMdmNtnltyCntryService,
    protected dmClientMdmNtnltyCntryFormService: DmClientMdmNtnltyCntryFormService,
    protected activatedRoute: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dmClientMdmNtnltyCntry }) => {
      this.dmClientMdmNtnltyCntry = dmClientMdmNtnltyCntry;
      if (dmClientMdmNtnltyCntry) {
        this.updateForm(dmClientMdmNtnltyCntry);
      }
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const dmClientMdmNtnltyCntry = this.dmClientMdmNtnltyCntryFormService.getDmClientMdmNtnltyCntry(this.editForm);
    if (dmClientMdmNtnltyCntry.id !== null) {
      this.subscribeToSaveResponse(this.dmClientMdmNtnltyCntryService.update(dmClientMdmNtnltyCntry));
    } else {
      this.subscribeToSaveResponse(this.dmClientMdmNtnltyCntryService.create(dmClientMdmNtnltyCntry));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDmClientMdmNtnltyCntry>>): void {
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

  protected updateForm(dmClientMdmNtnltyCntry: IDmClientMdmNtnltyCntry): void {
    this.dmClientMdmNtnltyCntry = dmClientMdmNtnltyCntry;
    this.dmClientMdmNtnltyCntryFormService.resetForm(this.editForm, dmClientMdmNtnltyCntry);
  }
}

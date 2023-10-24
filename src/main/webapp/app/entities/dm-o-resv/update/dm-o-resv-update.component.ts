import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import SharedModule from 'app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IDmOResv } from '../dm-o-resv.model';
import { DmOResvService } from '../service/dm-o-resv.service';
import { DmOResvFormService, DmOResvFormGroup } from './dm-o-resv-form.service';

@Component({
  standalone: true,
  selector: 'jhi-dm-o-resv-update',
  templateUrl: './dm-o-resv-update.component.html',
  imports: [SharedModule, FormsModule, ReactiveFormsModule],
})
export class DmOResvUpdateComponent implements OnInit {
  isSaving = false;
  dmOResv: IDmOResv | null = null;

  editForm: DmOResvFormGroup = this.dmOResvFormService.createDmOResvFormGroup();

  constructor(
    protected dmOResvService: DmOResvService,
    protected dmOResvFormService: DmOResvFormService,
    protected activatedRoute: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dmOResv }) => {
      this.dmOResv = dmOResv;
      if (dmOResv) {
        this.updateForm(dmOResv);
      }
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const dmOResv = this.dmOResvFormService.getDmOResv(this.editForm);
    if (dmOResv.id !== null) {
      this.subscribeToSaveResponse(this.dmOResvService.update(dmOResv));
    } else {
      this.subscribeToSaveResponse(this.dmOResvService.create(dmOResv));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDmOResv>>): void {
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

  protected updateForm(dmOResv: IDmOResv): void {
    this.dmOResv = dmOResv;
    this.dmOResvFormService.resetForm(this.editForm, dmOResv);
  }
}

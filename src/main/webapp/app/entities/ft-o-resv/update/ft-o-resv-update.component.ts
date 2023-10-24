import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import SharedModule from 'app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IFtOResv } from '../ft-o-resv.model';
import { FtOResvService } from '../service/ft-o-resv.service';
import { FtOResvFormService, FtOResvFormGroup } from './ft-o-resv-form.service';

@Component({
  standalone: true,
  selector: 'jhi-ft-o-resv-update',
  templateUrl: './ft-o-resv-update.component.html',
  imports: [SharedModule, FormsModule, ReactiveFormsModule],
})
export class FtOResvUpdateComponent implements OnInit {
  isSaving = false;
  ftOResv: IFtOResv | null = null;

  editForm: FtOResvFormGroup = this.ftOResvFormService.createFtOResvFormGroup();

  constructor(
    protected ftOResvService: FtOResvService,
    protected ftOResvFormService: FtOResvFormService,
    protected activatedRoute: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ ftOResv }) => {
      this.ftOResv = ftOResv;
      if (ftOResv) {
        this.updateForm(ftOResv);
      }
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const ftOResv = this.ftOResvFormService.getFtOResv(this.editForm);
    if (ftOResv.id !== null) {
      this.subscribeToSaveResponse(this.ftOResvService.update(ftOResv));
    } else {
      this.subscribeToSaveResponse(this.ftOResvService.create(ftOResv));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IFtOResv>>): void {
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

  protected updateForm(ftOResv: IFtOResv): void {
    this.ftOResv = ftOResv;
    this.ftOResvFormService.resetForm(this.editForm, ftOResv);
  }
}

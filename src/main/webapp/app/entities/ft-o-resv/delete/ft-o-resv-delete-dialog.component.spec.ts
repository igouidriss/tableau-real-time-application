jest.mock('@ng-bootstrap/ng-bootstrap');

import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { FtOResvService } from '../service/ft-o-resv.service';

import { FtOResvDeleteDialogComponent } from './ft-o-resv-delete-dialog.component';

describe('FtOResv Management Delete Component', () => {
  let comp: FtOResvDeleteDialogComponent;
  let fixture: ComponentFixture<FtOResvDeleteDialogComponent>;
  let service: FtOResvService;
  let mockActiveModal: NgbActiveModal;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, FtOResvDeleteDialogComponent],
      providers: [NgbActiveModal],
    })
      .overrideTemplate(FtOResvDeleteDialogComponent, '')
      .compileComponents();
    fixture = TestBed.createComponent(FtOResvDeleteDialogComponent);
    comp = fixture.componentInstance;
    service = TestBed.inject(FtOResvService);
    mockActiveModal = TestBed.inject(NgbActiveModal);
  });

  describe('confirmDelete', () => {
    it('Should call delete service on confirmDelete', inject(
      [],
      fakeAsync(() => {
        // GIVEN
        jest.spyOn(service, 'delete').mockReturnValue(of(new HttpResponse({ body: {} })));

        // WHEN
        comp.confirmDelete(123);
        tick();

        // THEN
        expect(service.delete).toHaveBeenCalledWith(123);
        expect(mockActiveModal.close).toHaveBeenCalledWith('deleted');
      }),
    ));

    it('Should not call delete service on clear', () => {
      // GIVEN
      jest.spyOn(service, 'delete');

      // WHEN
      comp.cancel();

      // THEN
      expect(service.delete).not.toHaveBeenCalled();
      expect(mockActiveModal.close).not.toHaveBeenCalled();
      expect(mockActiveModal.dismiss).toHaveBeenCalled();
    });
  });
});

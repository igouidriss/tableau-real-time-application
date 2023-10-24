jest.mock('@ng-bootstrap/ng-bootstrap');

import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { DmOResvService } from '../service/dm-o-resv.service';

import { DmOResvDeleteDialogComponent } from './dm-o-resv-delete-dialog.component';

describe('DmOResv Management Delete Component', () => {
  let comp: DmOResvDeleteDialogComponent;
  let fixture: ComponentFixture<DmOResvDeleteDialogComponent>;
  let service: DmOResvService;
  let mockActiveModal: NgbActiveModal;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, DmOResvDeleteDialogComponent],
      providers: [NgbActiveModal],
    })
      .overrideTemplate(DmOResvDeleteDialogComponent, '')
      .compileComponents();
    fixture = TestBed.createComponent(DmOResvDeleteDialogComponent);
    comp = fixture.componentInstance;
    service = TestBed.inject(DmOResvService);
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

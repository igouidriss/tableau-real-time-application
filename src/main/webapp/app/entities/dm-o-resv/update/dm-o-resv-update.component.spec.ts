import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { DmOResvService } from '../service/dm-o-resv.service';
import { IDmOResv } from '../dm-o-resv.model';
import { DmOResvFormService } from './dm-o-resv-form.service';

import { DmOResvUpdateComponent } from './dm-o-resv-update.component';

describe('DmOResv Management Update Component', () => {
  let comp: DmOResvUpdateComponent;
  let fixture: ComponentFixture<DmOResvUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let dmOResvFormService: DmOResvFormService;
  let dmOResvService: DmOResvService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([]), DmOResvUpdateComponent],
      providers: [
        FormBuilder,
        {
          provide: ActivatedRoute,
          useValue: {
            params: from([{}]),
          },
        },
      ],
    })
      .overrideTemplate(DmOResvUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(DmOResvUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    dmOResvFormService = TestBed.inject(DmOResvFormService);
    dmOResvService = TestBed.inject(DmOResvService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should update editForm', () => {
      const dmOResv: IDmOResv = { id: 456 };

      activatedRoute.data = of({ dmOResv });
      comp.ngOnInit();

      expect(comp.dmOResv).toEqual(dmOResv);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IDmOResv>>();
      const dmOResv = { id: 123 };
      jest.spyOn(dmOResvFormService, 'getDmOResv').mockReturnValue(dmOResv);
      jest.spyOn(dmOResvService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ dmOResv });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: dmOResv }));
      saveSubject.complete();

      // THEN
      expect(dmOResvFormService.getDmOResv).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(dmOResvService.update).toHaveBeenCalledWith(expect.objectContaining(dmOResv));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IDmOResv>>();
      const dmOResv = { id: 123 };
      jest.spyOn(dmOResvFormService, 'getDmOResv').mockReturnValue({ id: null });
      jest.spyOn(dmOResvService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ dmOResv: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: dmOResv }));
      saveSubject.complete();

      // THEN
      expect(dmOResvFormService.getDmOResv).toHaveBeenCalled();
      expect(dmOResvService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IDmOResv>>();
      const dmOResv = { id: 123 };
      jest.spyOn(dmOResvService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ dmOResv });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(dmOResvService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });
});

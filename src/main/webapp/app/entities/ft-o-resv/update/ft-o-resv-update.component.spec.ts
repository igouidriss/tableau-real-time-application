import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { FtOResvService } from '../service/ft-o-resv.service';
import { IFtOResv } from '../ft-o-resv.model';
import { FtOResvFormService } from './ft-o-resv-form.service';

import { FtOResvUpdateComponent } from './ft-o-resv-update.component';

describe('FtOResv Management Update Component', () => {
  let comp: FtOResvUpdateComponent;
  let fixture: ComponentFixture<FtOResvUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let ftOResvFormService: FtOResvFormService;
  let ftOResvService: FtOResvService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([]), FtOResvUpdateComponent],
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
      .overrideTemplate(FtOResvUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(FtOResvUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    ftOResvFormService = TestBed.inject(FtOResvFormService);
    ftOResvService = TestBed.inject(FtOResvService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should update editForm', () => {
      const ftOResv: IFtOResv = { id: 456 };

      activatedRoute.data = of({ ftOResv });
      comp.ngOnInit();

      expect(comp.ftOResv).toEqual(ftOResv);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IFtOResv>>();
      const ftOResv = { id: 123 };
      jest.spyOn(ftOResvFormService, 'getFtOResv').mockReturnValue(ftOResv);
      jest.spyOn(ftOResvService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ ftOResv });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: ftOResv }));
      saveSubject.complete();

      // THEN
      expect(ftOResvFormService.getFtOResv).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(ftOResvService.update).toHaveBeenCalledWith(expect.objectContaining(ftOResv));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IFtOResv>>();
      const ftOResv = { id: 123 };
      jest.spyOn(ftOResvFormService, 'getFtOResv').mockReturnValue({ id: null });
      jest.spyOn(ftOResvService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ ftOResv: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: ftOResv }));
      saveSubject.complete();

      // THEN
      expect(ftOResvFormService.getFtOResv).toHaveBeenCalled();
      expect(ftOResvService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IFtOResv>>();
      const ftOResv = { id: 123 };
      jest.spyOn(ftOResvService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ ftOResv });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(ftOResvService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });
});

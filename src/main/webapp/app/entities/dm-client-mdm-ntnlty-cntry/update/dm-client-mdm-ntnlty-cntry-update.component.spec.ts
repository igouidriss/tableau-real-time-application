import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { DmClientMdmNtnltyCntryService } from '../service/dm-client-mdm-ntnlty-cntry.service';
import { IDmClientMdmNtnltyCntry } from '../dm-client-mdm-ntnlty-cntry.model';
import { DmClientMdmNtnltyCntryFormService } from './dm-client-mdm-ntnlty-cntry-form.service';

import { DmClientMdmNtnltyCntryUpdateComponent } from './dm-client-mdm-ntnlty-cntry-update.component';

describe('DmClientMdmNtnltyCntry Management Update Component', () => {
  let comp: DmClientMdmNtnltyCntryUpdateComponent;
  let fixture: ComponentFixture<DmClientMdmNtnltyCntryUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let dmClientMdmNtnltyCntryFormService: DmClientMdmNtnltyCntryFormService;
  let dmClientMdmNtnltyCntryService: DmClientMdmNtnltyCntryService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([]), DmClientMdmNtnltyCntryUpdateComponent],
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
      .overrideTemplate(DmClientMdmNtnltyCntryUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(DmClientMdmNtnltyCntryUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    dmClientMdmNtnltyCntryFormService = TestBed.inject(DmClientMdmNtnltyCntryFormService);
    dmClientMdmNtnltyCntryService = TestBed.inject(DmClientMdmNtnltyCntryService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should update editForm', () => {
      const dmClientMdmNtnltyCntry: IDmClientMdmNtnltyCntry = { id: 456 };

      activatedRoute.data = of({ dmClientMdmNtnltyCntry });
      comp.ngOnInit();

      expect(comp.dmClientMdmNtnltyCntry).toEqual(dmClientMdmNtnltyCntry);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IDmClientMdmNtnltyCntry>>();
      const dmClientMdmNtnltyCntry = { id: 123 };
      jest.spyOn(dmClientMdmNtnltyCntryFormService, 'getDmClientMdmNtnltyCntry').mockReturnValue(dmClientMdmNtnltyCntry);
      jest.spyOn(dmClientMdmNtnltyCntryService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ dmClientMdmNtnltyCntry });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: dmClientMdmNtnltyCntry }));
      saveSubject.complete();

      // THEN
      expect(dmClientMdmNtnltyCntryFormService.getDmClientMdmNtnltyCntry).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(dmClientMdmNtnltyCntryService.update).toHaveBeenCalledWith(expect.objectContaining(dmClientMdmNtnltyCntry));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IDmClientMdmNtnltyCntry>>();
      const dmClientMdmNtnltyCntry = { id: 123 };
      jest.spyOn(dmClientMdmNtnltyCntryFormService, 'getDmClientMdmNtnltyCntry').mockReturnValue({ id: null });
      jest.spyOn(dmClientMdmNtnltyCntryService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ dmClientMdmNtnltyCntry: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: dmClientMdmNtnltyCntry }));
      saveSubject.complete();

      // THEN
      expect(dmClientMdmNtnltyCntryFormService.getDmClientMdmNtnltyCntry).toHaveBeenCalled();
      expect(dmClientMdmNtnltyCntryService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IDmClientMdmNtnltyCntry>>();
      const dmClientMdmNtnltyCntry = { id: 123 };
      jest.spyOn(dmClientMdmNtnltyCntryService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ dmClientMdmNtnltyCntry });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(dmClientMdmNtnltyCntryService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });
});

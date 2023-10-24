import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { DmClientMdmAddrCntryService } from '../service/dm-client-mdm-addr-cntry.service';
import { IDmClientMdmAddrCntry } from '../dm-client-mdm-addr-cntry.model';
import { DmClientMdmAddrCntryFormService } from './dm-client-mdm-addr-cntry-form.service';

import { DmClientMdmAddrCntryUpdateComponent } from './dm-client-mdm-addr-cntry-update.component';

describe('DmClientMdmAddrCntry Management Update Component', () => {
  let comp: DmClientMdmAddrCntryUpdateComponent;
  let fixture: ComponentFixture<DmClientMdmAddrCntryUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let dmClientMdmAddrCntryFormService: DmClientMdmAddrCntryFormService;
  let dmClientMdmAddrCntryService: DmClientMdmAddrCntryService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([]), DmClientMdmAddrCntryUpdateComponent],
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
      .overrideTemplate(DmClientMdmAddrCntryUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(DmClientMdmAddrCntryUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    dmClientMdmAddrCntryFormService = TestBed.inject(DmClientMdmAddrCntryFormService);
    dmClientMdmAddrCntryService = TestBed.inject(DmClientMdmAddrCntryService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should update editForm', () => {
      const dmClientMdmAddrCntry: IDmClientMdmAddrCntry = { id: 456 };

      activatedRoute.data = of({ dmClientMdmAddrCntry });
      comp.ngOnInit();

      expect(comp.dmClientMdmAddrCntry).toEqual(dmClientMdmAddrCntry);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IDmClientMdmAddrCntry>>();
      const dmClientMdmAddrCntry = { id: 123 };
      jest.spyOn(dmClientMdmAddrCntryFormService, 'getDmClientMdmAddrCntry').mockReturnValue(dmClientMdmAddrCntry);
      jest.spyOn(dmClientMdmAddrCntryService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ dmClientMdmAddrCntry });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: dmClientMdmAddrCntry }));
      saveSubject.complete();

      // THEN
      expect(dmClientMdmAddrCntryFormService.getDmClientMdmAddrCntry).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(dmClientMdmAddrCntryService.update).toHaveBeenCalledWith(expect.objectContaining(dmClientMdmAddrCntry));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IDmClientMdmAddrCntry>>();
      const dmClientMdmAddrCntry = { id: 123 };
      jest.spyOn(dmClientMdmAddrCntryFormService, 'getDmClientMdmAddrCntry').mockReturnValue({ id: null });
      jest.spyOn(dmClientMdmAddrCntryService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ dmClientMdmAddrCntry: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: dmClientMdmAddrCntry }));
      saveSubject.complete();

      // THEN
      expect(dmClientMdmAddrCntryFormService.getDmClientMdmAddrCntry).toHaveBeenCalled();
      expect(dmClientMdmAddrCntryService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IDmClientMdmAddrCntry>>();
      const dmClientMdmAddrCntry = { id: 123 };
      jest.spyOn(dmClientMdmAddrCntryService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ dmClientMdmAddrCntry });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(dmClientMdmAddrCntryService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });
});

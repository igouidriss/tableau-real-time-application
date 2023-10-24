import { TestBed } from '@angular/core/testing';

import { sampleWithRequiredData, sampleWithNewData } from '../dm-client-mdm-ntnlty-cntry.test-samples';

import { DmClientMdmNtnltyCntryFormService } from './dm-client-mdm-ntnlty-cntry-form.service';

describe('DmClientMdmNtnltyCntry Form Service', () => {
  let service: DmClientMdmNtnltyCntryFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DmClientMdmNtnltyCntryFormService);
  });

  describe('Service methods', () => {
    describe('createDmClientMdmNtnltyCntryFormGroup', () => {
      it('should create a new form with FormControl', () => {
        const formGroup = service.createDmClientMdmNtnltyCntryFormGroup();

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            prtyFk: expect.any(Object),
            frstNtnltFrmt: expect.any(Object),
            frstContinent: expect.any(Object),
            scndNtnltFrmt: expect.any(Object),
            scndContinent: expect.any(Object),
            thrdNtnltFrmt: expect.any(Object),
            thrdContinent: expect.any(Object),
            frthNtnltFrmt: expect.any(Object),
            frthContinent: expect.any(Object),
            techLineage: expect.any(Object),
            techCreatedDate: expect.any(Object),
            techUpdatedDate: expect.any(Object),
            techMapping: expect.any(Object),
            techComment: expect.any(Object),
          }),
        );
      });

      it('passing IDmClientMdmNtnltyCntry should create a new form with FormGroup', () => {
        const formGroup = service.createDmClientMdmNtnltyCntryFormGroup(sampleWithRequiredData);

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            prtyFk: expect.any(Object),
            frstNtnltFrmt: expect.any(Object),
            frstContinent: expect.any(Object),
            scndNtnltFrmt: expect.any(Object),
            scndContinent: expect.any(Object),
            thrdNtnltFrmt: expect.any(Object),
            thrdContinent: expect.any(Object),
            frthNtnltFrmt: expect.any(Object),
            frthContinent: expect.any(Object),
            techLineage: expect.any(Object),
            techCreatedDate: expect.any(Object),
            techUpdatedDate: expect.any(Object),
            techMapping: expect.any(Object),
            techComment: expect.any(Object),
          }),
        );
      });
    });

    describe('getDmClientMdmNtnltyCntry', () => {
      it('should return NewDmClientMdmNtnltyCntry for default DmClientMdmNtnltyCntry initial value', () => {
        const formGroup = service.createDmClientMdmNtnltyCntryFormGroup(sampleWithNewData);

        const dmClientMdmNtnltyCntry = service.getDmClientMdmNtnltyCntry(formGroup) as any;

        expect(dmClientMdmNtnltyCntry).toMatchObject(sampleWithNewData);
      });

      it('should return NewDmClientMdmNtnltyCntry for empty DmClientMdmNtnltyCntry initial value', () => {
        const formGroup = service.createDmClientMdmNtnltyCntryFormGroup();

        const dmClientMdmNtnltyCntry = service.getDmClientMdmNtnltyCntry(formGroup) as any;

        expect(dmClientMdmNtnltyCntry).toMatchObject({});
      });

      it('should return IDmClientMdmNtnltyCntry', () => {
        const formGroup = service.createDmClientMdmNtnltyCntryFormGroup(sampleWithRequiredData);

        const dmClientMdmNtnltyCntry = service.getDmClientMdmNtnltyCntry(formGroup) as any;

        expect(dmClientMdmNtnltyCntry).toMatchObject(sampleWithRequiredData);
      });
    });

    describe('resetForm', () => {
      it('passing IDmClientMdmNtnltyCntry should not enable id FormControl', () => {
        const formGroup = service.createDmClientMdmNtnltyCntryFormGroup();
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, sampleWithRequiredData);

        expect(formGroup.controls.id.disabled).toBe(true);
      });

      it('passing NewDmClientMdmNtnltyCntry should disable id FormControl', () => {
        const formGroup = service.createDmClientMdmNtnltyCntryFormGroup(sampleWithRequiredData);
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, { id: null });

        expect(formGroup.controls.id.disabled).toBe(true);
      });
    });
  });
});

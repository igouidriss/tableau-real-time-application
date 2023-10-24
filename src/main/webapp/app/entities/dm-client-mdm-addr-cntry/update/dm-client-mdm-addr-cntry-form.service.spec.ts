import { TestBed } from '@angular/core/testing';

import { sampleWithRequiredData, sampleWithNewData } from '../dm-client-mdm-addr-cntry.test-samples';

import { DmClientMdmAddrCntryFormService } from './dm-client-mdm-addr-cntry-form.service';

describe('DmClientMdmAddrCntry Form Service', () => {
  let service: DmClientMdmAddrCntryFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DmClientMdmAddrCntryFormService);
  });

  describe('Service methods', () => {
    describe('createDmClientMdmAddrCntryFormGroup', () => {
      it('should create a new form with FormControl', () => {
        const formGroup = service.createDmClientMdmAddrCntryFormGroup();

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            prtyFk: expect.any(Object),
            frstCntryFrmt: expect.any(Object),
            frstContinent: expect.any(Object),
            scndCntryFrmt: expect.any(Object),
            scndContinent: expect.any(Object),
            thrdCntryFrmt: expect.any(Object),
            thrdContinent: expect.any(Object),
            frthCntryFrmt: expect.any(Object),
            frthContinent: expect.any(Object),
            techLineage: expect.any(Object),
            techCreatedDate: expect.any(Object),
            techUpdatedDate: expect.any(Object),
            techMapping: expect.any(Object),
            techComment: expect.any(Object),
          }),
        );
      });

      it('passing IDmClientMdmAddrCntry should create a new form with FormGroup', () => {
        const formGroup = service.createDmClientMdmAddrCntryFormGroup(sampleWithRequiredData);

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            prtyFk: expect.any(Object),
            frstCntryFrmt: expect.any(Object),
            frstContinent: expect.any(Object),
            scndCntryFrmt: expect.any(Object),
            scndContinent: expect.any(Object),
            thrdCntryFrmt: expect.any(Object),
            thrdContinent: expect.any(Object),
            frthCntryFrmt: expect.any(Object),
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

    describe('getDmClientMdmAddrCntry', () => {
      it('should return NewDmClientMdmAddrCntry for default DmClientMdmAddrCntry initial value', () => {
        const formGroup = service.createDmClientMdmAddrCntryFormGroup(sampleWithNewData);

        const dmClientMdmAddrCntry = service.getDmClientMdmAddrCntry(formGroup) as any;

        expect(dmClientMdmAddrCntry).toMatchObject(sampleWithNewData);
      });

      it('should return NewDmClientMdmAddrCntry for empty DmClientMdmAddrCntry initial value', () => {
        const formGroup = service.createDmClientMdmAddrCntryFormGroup();

        const dmClientMdmAddrCntry = service.getDmClientMdmAddrCntry(formGroup) as any;

        expect(dmClientMdmAddrCntry).toMatchObject({});
      });

      it('should return IDmClientMdmAddrCntry', () => {
        const formGroup = service.createDmClientMdmAddrCntryFormGroup(sampleWithRequiredData);

        const dmClientMdmAddrCntry = service.getDmClientMdmAddrCntry(formGroup) as any;

        expect(dmClientMdmAddrCntry).toMatchObject(sampleWithRequiredData);
      });
    });

    describe('resetForm', () => {
      it('passing IDmClientMdmAddrCntry should not enable id FormControl', () => {
        const formGroup = service.createDmClientMdmAddrCntryFormGroup();
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, sampleWithRequiredData);

        expect(formGroup.controls.id.disabled).toBe(true);
      });

      it('passing NewDmClientMdmAddrCntry should disable id FormControl', () => {
        const formGroup = service.createDmClientMdmAddrCntryFormGroup(sampleWithRequiredData);
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, { id: null });

        expect(formGroup.controls.id.disabled).toBe(true);
      });
    });
  });
});

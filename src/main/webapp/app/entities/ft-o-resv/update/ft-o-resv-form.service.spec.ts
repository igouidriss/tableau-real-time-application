import { TestBed } from '@angular/core/testing';

import { sampleWithRequiredData, sampleWithNewData } from '../ft-o-resv.test-samples';

import { FtOResvFormService } from './ft-o-resv-form.service';

describe('FtOResv Form Service', () => {
  let service: FtOResvFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FtOResvFormService);
  });

  describe('Service methods', () => {
    describe('createFtOResvFormGroup', () => {
      it('should create a new form with FormControl', () => {
        const formGroup = service.createFtOResvFormGroup();

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            numLigne: expect.any(Object),
            resort: expect.any(Object),
            resvNameId: expect.any(Object),
            clientOId: expect.any(Object),
            typeChb: expect.any(Object),
            businessDate: expect.any(Object),
            numOrdre: expect.any(Object),
            confirmationNo: expect.any(Object),
            clientMdmId: expect.any(Object),
            nameId: expect.any(Object),
            nameIdLigne: expect.any(Object),
            contactId: expect.any(Object),
            agenceId: expect.any(Object),
            agenceNom: expect.any(Object),
            societeId: expect.any(Object),
            groupeId: expect.any(Object),
            membreId: expect.any(Object),
            sourceProfileId: expect.any(Object),
            numBloc: expect.any(Object),
            statutResv: expect.any(Object),
            statutVip: expect.any(Object),
            dateDebutLigne: expect.any(Object),
            dateFinLigne: expect.any(Object),
            dateFinOrigine: expect.any(Object),
            dateAnn: expect.any(Object),
            pseudoRoomYn: expect.any(Object),
            complementaireYn: expect.any(Object),
            interneYn: expect.any(Object),
            walkinYn: expect.any(Object),
            createurResv: expect.any(Object),
            nomCreateurResv: expect.any(Object),
            codePays: expect.any(Object),
            libPays: expect.any(Object),
            codeNationalite: expect.any(Object),
            libNationalite: expect.any(Object),
            codeSource: expect.any(Object),
            libSource: expect.any(Object),
            codeGrandSource: expect.any(Object),
            codeOrigine: expect.any(Object),
            libOrigine: expect.any(Object),
            codeMarche: expect.any(Object),
            libMarche: expect.any(Object),
            codeGrandMarche: expect.any(Object),
            libGrandMarche: expect.any(Object),
            codePrix: expect.any(Object),
            categPrix: expect.any(Object),
            libPrix: expect.any(Object),
            numChb: expect.any(Object),
            typeChbLigne: expect.any(Object),
            descriptionTypeChb: expect.any(Object),
            codeTypeChb: expect.any(Object),
            classChb: expect.any(Object),
            statutChbResv: expect.any(Object),
            typeChbDeReservation: expect.any(Object),
            descriptionTypeChbDeResv: expect.any(Object),
            codeTypeChbDeResv: expect.any(Object),
            circuitDistribution: expect.any(Object),
            circuitDistribUserRegroup: expect.any(Object),
            nbResvAnn: expect.any(Object),
            nbNuitee: expect.any(Object),
            nbNuiteeNnDed: expect.any(Object),
            nbNuiteeGlobal: expect.any(Object),
            nbOccupationMultiple: expect.any(Object),
            nbAduGlobal: expect.any(Object),
            nbEnfGlobal: expect.any(Object),
            nbPersDayUGlobal: expect.any(Object),
            nbPersArrGlobal: expect.any(Object),
            nbPersDepGlobal: expect.any(Object),
            nbPersAnn: expect.any(Object),
            nbPersNoshow: expect.any(Object),
            nbChbDayUGlobal: expect.any(Object),
            nbChbArrGlobal: expect.any(Object),
            nbChbDepGlobal: expect.any(Object),
            nbChbAnn: expect.any(Object),
            nbChbNoshow: expect.any(Object),
            revenuNetChambreGlobal: expect.any(Object),
            revenuTaxeChambreGlobal: expect.any(Object),
            revenuNetBqGlobal: expect.any(Object),
            revenuTaxeBqGlobal: expect.any(Object),
            revenuNetExtraGlobal: expect.any(Object),
            revenuTaxeExtraGlobal: expect.any(Object),
            revenuNetTotalGlobal: expect.any(Object),
            revenuTaxeTotalGlobal: expect.any(Object),
            prodRevenuChambre: expect.any(Object),
            prodRevenuBq: expect.any(Object),
            prodRevenuExtra: expect.any(Object),
            prodRevenuTotal: expect.any(Object),
            prodChambreNbNuitees: expect.any(Object),
            datesSejourRensYn: expect.any(Object),
            techEventType: expect.any(Object),
            techResvInvType: expect.any(Object),
            techOrigine: expect.any(Object),
            techGrpNumOrdre: expect.any(Object),
            techCreateDate: expect.any(Object),
            techUpdateDate: expect.any(Object),
            resvNameIdPrincipal: expect.any(Object),
          }),
        );
      });

      it('passing IFtOResv should create a new form with FormGroup', () => {
        const formGroup = service.createFtOResvFormGroup(sampleWithRequiredData);

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            numLigne: expect.any(Object),
            resort: expect.any(Object),
            resvNameId: expect.any(Object),
            clientOId: expect.any(Object),
            typeChb: expect.any(Object),
            businessDate: expect.any(Object),
            numOrdre: expect.any(Object),
            confirmationNo: expect.any(Object),
            clientMdmId: expect.any(Object),
            nameId: expect.any(Object),
            nameIdLigne: expect.any(Object),
            contactId: expect.any(Object),
            agenceId: expect.any(Object),
            agenceNom: expect.any(Object),
            societeId: expect.any(Object),
            groupeId: expect.any(Object),
            membreId: expect.any(Object),
            sourceProfileId: expect.any(Object),
            numBloc: expect.any(Object),
            statutResv: expect.any(Object),
            statutVip: expect.any(Object),
            dateDebutLigne: expect.any(Object),
            dateFinLigne: expect.any(Object),
            dateFinOrigine: expect.any(Object),
            dateAnn: expect.any(Object),
            pseudoRoomYn: expect.any(Object),
            complementaireYn: expect.any(Object),
            interneYn: expect.any(Object),
            walkinYn: expect.any(Object),
            createurResv: expect.any(Object),
            nomCreateurResv: expect.any(Object),
            codePays: expect.any(Object),
            libPays: expect.any(Object),
            codeNationalite: expect.any(Object),
            libNationalite: expect.any(Object),
            codeSource: expect.any(Object),
            libSource: expect.any(Object),
            codeGrandSource: expect.any(Object),
            codeOrigine: expect.any(Object),
            libOrigine: expect.any(Object),
            codeMarche: expect.any(Object),
            libMarche: expect.any(Object),
            codeGrandMarche: expect.any(Object),
            libGrandMarche: expect.any(Object),
            codePrix: expect.any(Object),
            categPrix: expect.any(Object),
            libPrix: expect.any(Object),
            numChb: expect.any(Object),
            typeChbLigne: expect.any(Object),
            descriptionTypeChb: expect.any(Object),
            codeTypeChb: expect.any(Object),
            classChb: expect.any(Object),
            statutChbResv: expect.any(Object),
            typeChbDeReservation: expect.any(Object),
            descriptionTypeChbDeResv: expect.any(Object),
            codeTypeChbDeResv: expect.any(Object),
            circuitDistribution: expect.any(Object),
            circuitDistribUserRegroup: expect.any(Object),
            nbResvAnn: expect.any(Object),
            nbNuitee: expect.any(Object),
            nbNuiteeNnDed: expect.any(Object),
            nbNuiteeGlobal: expect.any(Object),
            nbOccupationMultiple: expect.any(Object),
            nbAduGlobal: expect.any(Object),
            nbEnfGlobal: expect.any(Object),
            nbPersDayUGlobal: expect.any(Object),
            nbPersArrGlobal: expect.any(Object),
            nbPersDepGlobal: expect.any(Object),
            nbPersAnn: expect.any(Object),
            nbPersNoshow: expect.any(Object),
            nbChbDayUGlobal: expect.any(Object),
            nbChbArrGlobal: expect.any(Object),
            nbChbDepGlobal: expect.any(Object),
            nbChbAnn: expect.any(Object),
            nbChbNoshow: expect.any(Object),
            revenuNetChambreGlobal: expect.any(Object),
            revenuTaxeChambreGlobal: expect.any(Object),
            revenuNetBqGlobal: expect.any(Object),
            revenuTaxeBqGlobal: expect.any(Object),
            revenuNetExtraGlobal: expect.any(Object),
            revenuTaxeExtraGlobal: expect.any(Object),
            revenuNetTotalGlobal: expect.any(Object),
            revenuTaxeTotalGlobal: expect.any(Object),
            prodRevenuChambre: expect.any(Object),
            prodRevenuBq: expect.any(Object),
            prodRevenuExtra: expect.any(Object),
            prodRevenuTotal: expect.any(Object),
            prodChambreNbNuitees: expect.any(Object),
            datesSejourRensYn: expect.any(Object),
            techEventType: expect.any(Object),
            techResvInvType: expect.any(Object),
            techOrigine: expect.any(Object),
            techGrpNumOrdre: expect.any(Object),
            techCreateDate: expect.any(Object),
            techUpdateDate: expect.any(Object),
            resvNameIdPrincipal: expect.any(Object),
          }),
        );
      });
    });

    describe('getFtOResv', () => {
      it('should return NewFtOResv for default FtOResv initial value', () => {
        const formGroup = service.createFtOResvFormGroup(sampleWithNewData);

        const ftOResv = service.getFtOResv(formGroup) as any;

        expect(ftOResv).toMatchObject(sampleWithNewData);
      });

      it('should return NewFtOResv for empty FtOResv initial value', () => {
        const formGroup = service.createFtOResvFormGroup();

        const ftOResv = service.getFtOResv(formGroup) as any;

        expect(ftOResv).toMatchObject({});
      });

      it('should return IFtOResv', () => {
        const formGroup = service.createFtOResvFormGroup(sampleWithRequiredData);

        const ftOResv = service.getFtOResv(formGroup) as any;

        expect(ftOResv).toMatchObject(sampleWithRequiredData);
      });
    });

    describe('resetForm', () => {
      it('passing IFtOResv should not enable id FormControl', () => {
        const formGroup = service.createFtOResvFormGroup();
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, sampleWithRequiredData);

        expect(formGroup.controls.id.disabled).toBe(true);
      });

      it('passing NewFtOResv should disable id FormControl', () => {
        const formGroup = service.createFtOResvFormGroup(sampleWithRequiredData);
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, { id: null });

        expect(formGroup.controls.id.disabled).toBe(true);
      });
    });
  });
});

import { TestBed } from '@angular/core/testing';

import { sampleWithRequiredData, sampleWithNewData } from '../dm-o-resv.test-samples';

import { DmOResvFormService } from './dm-o-resv-form.service';

describe('DmOResv Form Service', () => {
  let service: DmOResvFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DmOResvFormService);
  });

  describe('Service methods', () => {
    describe('createDmOResvFormGroup', () => {
      it('should create a new form with FormControl', () => {
        const formGroup = service.createDmOResvFormGroup();

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            numLigne: expect.any(Object),
            resort: expect.any(Object),
            resvNameId: expect.any(Object),
            clientOId: expect.any(Object),
            typeChb: expect.any(Object),
            confirmationNo: expect.any(Object),
            clientMdmId: expect.any(Object),
            nameId: expect.any(Object),
            parentResvNameId: expect.any(Object),
            contactId: expect.any(Object),
            agenceId: expect.any(Object),
            agenceNom: expect.any(Object),
            societeId: expect.any(Object),
            groupeId: expect.any(Object),
            numBloc: expect.any(Object),
            typeResv: expect.any(Object),
            statutResv: expect.any(Object),
            dateDebutResv: expect.any(Object),
            dateFinResv: expect.any(Object),
            truncDateDebutResv: expect.any(Object),
            truncDateFinResv: expect.any(Object),
            dateAnnResv: expect.any(Object),
            pseudoRoomYn: expect.any(Object),
            createurResv: expect.any(Object),
            nomCreateurResv: expect.any(Object),
            codeGarantie: expect.any(Object),
            flgDed: expect.any(Object),
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
            descriptionTypeChb: expect.any(Object),
            codeTypeChb: expect.any(Object),
            classChb: expect.any(Object),
            caractChb: expect.any(Object),
            typeChbDeReservation: expect.any(Object),
            descriptionTypeChbDeResv: expect.any(Object),
            codeTypeChbDeResv: expect.any(Object),
            statutDeReservation: expect.any(Object),
            circuitDistribution: expect.any(Object),
            circuitDistribUserRegroup: expect.any(Object),
            numCrs: expect.any(Object),
            typeRefCrs: expect.any(Object),
            crsInsertDate: expect.any(Object),
            dateCreaResv: expect.any(Object),
            datePremier: expect.any(Object),
            statutPremier: expect.any(Object),
            dateDernier: expect.any(Object),
            statutDernier: expect.any(Object),
            dateDernierPseudo: expect.any(Object),
            statutDernierPseudo: expect.any(Object),
            diffDtCreaAnn: expect.any(Object),
            diffDtArrAnn: expect.any(Object),
            leadtime: expect.any(Object),
            los: expect.any(Object),
            occupantsGroupe: expect.any(Object),
            nbNuitee: expect.any(Object),
            nbNuiteeNnDed: expect.any(Object),
            nbResvAnn: expect.any(Object),
            nbAdu: expect.any(Object),
            nbEnf: expect.any(Object),
            nbPersDayU: expect.any(Object),
            nbPersArr: expect.any(Object),
            nbPersDep: expect.any(Object),
            nbPersAnn: expect.any(Object),
            nbPersNoshow: expect.any(Object),
            nbChbDayU: expect.any(Object),
            nbChbArr: expect.any(Object),
            nbChbDep: expect.any(Object),
            nbChbAnn: expect.any(Object),
            nbChbNoshow: expect.any(Object),
            revenuNetChambre: expect.any(Object),
            revenuTaxeChambre: expect.any(Object),
            revenuNetChambreGlobal: expect.any(Object),
            revenuTaxeChambreGlobal: expect.any(Object),
            revenuNetBq: expect.any(Object),
            revenuTaxeBq: expect.any(Object),
            revenuNetBqGlobal: expect.any(Object),
            revenuTaxeBqGlobal: expect.any(Object),
            revenuNetExtra: expect.any(Object),
            revenuTaxeExtra: expect.any(Object),
            revenuNetExtraGlobal: expect.any(Object),
            revenuTaxeExtraGlobal: expect.any(Object),
            revenuNetTotal: expect.any(Object),
            revenuTaxeTotal: expect.any(Object),
            revenuNetTotalGlobal: expect.any(Object),
            revenuTaxeTotalGlobal: expect.any(Object),
            prodRevenuChambre: expect.any(Object),
            prodRevenuBq: expect.any(Object),
            prodRevenuExtra: expect.any(Object),
            prodRevenuTotal: expect.any(Object),
            prodChambreNbNuitees: expect.any(Object),
            techCreateDate: expect.any(Object),
            techUpdateDate: expect.any(Object),
          }),
        );
      });

      it('passing IDmOResv should create a new form with FormGroup', () => {
        const formGroup = service.createDmOResvFormGroup(sampleWithRequiredData);

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            numLigne: expect.any(Object),
            resort: expect.any(Object),
            resvNameId: expect.any(Object),
            clientOId: expect.any(Object),
            typeChb: expect.any(Object),
            confirmationNo: expect.any(Object),
            clientMdmId: expect.any(Object),
            nameId: expect.any(Object),
            parentResvNameId: expect.any(Object),
            contactId: expect.any(Object),
            agenceId: expect.any(Object),
            agenceNom: expect.any(Object),
            societeId: expect.any(Object),
            groupeId: expect.any(Object),
            numBloc: expect.any(Object),
            typeResv: expect.any(Object),
            statutResv: expect.any(Object),
            dateDebutResv: expect.any(Object),
            dateFinResv: expect.any(Object),
            truncDateDebutResv: expect.any(Object),
            truncDateFinResv: expect.any(Object),
            dateAnnResv: expect.any(Object),
            pseudoRoomYn: expect.any(Object),
            createurResv: expect.any(Object),
            nomCreateurResv: expect.any(Object),
            codeGarantie: expect.any(Object),
            flgDed: expect.any(Object),
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
            descriptionTypeChb: expect.any(Object),
            codeTypeChb: expect.any(Object),
            classChb: expect.any(Object),
            caractChb: expect.any(Object),
            typeChbDeReservation: expect.any(Object),
            descriptionTypeChbDeResv: expect.any(Object),
            codeTypeChbDeResv: expect.any(Object),
            statutDeReservation: expect.any(Object),
            circuitDistribution: expect.any(Object),
            circuitDistribUserRegroup: expect.any(Object),
            numCrs: expect.any(Object),
            typeRefCrs: expect.any(Object),
            crsInsertDate: expect.any(Object),
            dateCreaResv: expect.any(Object),
            datePremier: expect.any(Object),
            statutPremier: expect.any(Object),
            dateDernier: expect.any(Object),
            statutDernier: expect.any(Object),
            dateDernierPseudo: expect.any(Object),
            statutDernierPseudo: expect.any(Object),
            diffDtCreaAnn: expect.any(Object),
            diffDtArrAnn: expect.any(Object),
            leadtime: expect.any(Object),
            los: expect.any(Object),
            occupantsGroupe: expect.any(Object),
            nbNuitee: expect.any(Object),
            nbNuiteeNnDed: expect.any(Object),
            nbResvAnn: expect.any(Object),
            nbAdu: expect.any(Object),
            nbEnf: expect.any(Object),
            nbPersDayU: expect.any(Object),
            nbPersArr: expect.any(Object),
            nbPersDep: expect.any(Object),
            nbPersAnn: expect.any(Object),
            nbPersNoshow: expect.any(Object),
            nbChbDayU: expect.any(Object),
            nbChbArr: expect.any(Object),
            nbChbDep: expect.any(Object),
            nbChbAnn: expect.any(Object),
            nbChbNoshow: expect.any(Object),
            revenuNetChambre: expect.any(Object),
            revenuTaxeChambre: expect.any(Object),
            revenuNetChambreGlobal: expect.any(Object),
            revenuTaxeChambreGlobal: expect.any(Object),
            revenuNetBq: expect.any(Object),
            revenuTaxeBq: expect.any(Object),
            revenuNetBqGlobal: expect.any(Object),
            revenuTaxeBqGlobal: expect.any(Object),
            revenuNetExtra: expect.any(Object),
            revenuTaxeExtra: expect.any(Object),
            revenuNetExtraGlobal: expect.any(Object),
            revenuTaxeExtraGlobal: expect.any(Object),
            revenuNetTotal: expect.any(Object),
            revenuTaxeTotal: expect.any(Object),
            revenuNetTotalGlobal: expect.any(Object),
            revenuTaxeTotalGlobal: expect.any(Object),
            prodRevenuChambre: expect.any(Object),
            prodRevenuBq: expect.any(Object),
            prodRevenuExtra: expect.any(Object),
            prodRevenuTotal: expect.any(Object),
            prodChambreNbNuitees: expect.any(Object),
            techCreateDate: expect.any(Object),
            techUpdateDate: expect.any(Object),
          }),
        );
      });
    });

    describe('getDmOResv', () => {
      it('should return NewDmOResv for default DmOResv initial value', () => {
        const formGroup = service.createDmOResvFormGroup(sampleWithNewData);

        const dmOResv = service.getDmOResv(formGroup) as any;

        expect(dmOResv).toMatchObject(sampleWithNewData);
      });

      it('should return NewDmOResv for empty DmOResv initial value', () => {
        const formGroup = service.createDmOResvFormGroup();

        const dmOResv = service.getDmOResv(formGroup) as any;

        expect(dmOResv).toMatchObject({});
      });

      it('should return IDmOResv', () => {
        const formGroup = service.createDmOResvFormGroup(sampleWithRequiredData);

        const dmOResv = service.getDmOResv(formGroup) as any;

        expect(dmOResv).toMatchObject(sampleWithRequiredData);
      });
    });

    describe('resetForm', () => {
      it('passing IDmOResv should not enable id FormControl', () => {
        const formGroup = service.createDmOResvFormGroup();
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, sampleWithRequiredData);

        expect(formGroup.controls.id.disabled).toBe(true);
      });

      it('passing NewDmOResv should disable id FormControl', () => {
        const formGroup = service.createDmOResvFormGroup(sampleWithRequiredData);
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, { id: null });

        expect(formGroup.controls.id.disabled).toBe(true);
      });
    });
  });
});

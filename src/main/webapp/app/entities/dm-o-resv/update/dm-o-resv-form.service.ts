import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IDmOResv, NewDmOResv } from '../dm-o-resv.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IDmOResv for edit and NewDmOResvFormGroupInput for create.
 */
type DmOResvFormGroupInput = IDmOResv | PartialWithRequiredKeyOf<NewDmOResv>;

type DmOResvFormDefaults = Pick<NewDmOResv, 'id'>;

type DmOResvFormGroupContent = {
  id: FormControl<IDmOResv['id'] | NewDmOResv['id']>;
  numLigne: FormControl<IDmOResv['numLigne']>;
  resort: FormControl<IDmOResv['resort']>;
  resvNameId: FormControl<IDmOResv['resvNameId']>;
  clientOId: FormControl<IDmOResv['clientOId']>;
  typeChb: FormControl<IDmOResv['typeChb']>;
  confirmationNo: FormControl<IDmOResv['confirmationNo']>;
  clientMdmId: FormControl<IDmOResv['clientMdmId']>;
  nameId: FormControl<IDmOResv['nameId']>;
  parentResvNameId: FormControl<IDmOResv['parentResvNameId']>;
  contactId: FormControl<IDmOResv['contactId']>;
  agenceId: FormControl<IDmOResv['agenceId']>;
  agenceNom: FormControl<IDmOResv['agenceNom']>;
  societeId: FormControl<IDmOResv['societeId']>;
  groupeId: FormControl<IDmOResv['groupeId']>;
  numBloc: FormControl<IDmOResv['numBloc']>;
  typeResv: FormControl<IDmOResv['typeResv']>;
  statutResv: FormControl<IDmOResv['statutResv']>;
  dateDebutResv: FormControl<IDmOResv['dateDebutResv']>;
  dateFinResv: FormControl<IDmOResv['dateFinResv']>;
  truncDateDebutResv: FormControl<IDmOResv['truncDateDebutResv']>;
  truncDateFinResv: FormControl<IDmOResv['truncDateFinResv']>;
  dateAnnResv: FormControl<IDmOResv['dateAnnResv']>;
  pseudoRoomYn: FormControl<IDmOResv['pseudoRoomYn']>;
  createurResv: FormControl<IDmOResv['createurResv']>;
  nomCreateurResv: FormControl<IDmOResv['nomCreateurResv']>;
  codeGarantie: FormControl<IDmOResv['codeGarantie']>;
  flgDed: FormControl<IDmOResv['flgDed']>;
  codePays: FormControl<IDmOResv['codePays']>;
  libPays: FormControl<IDmOResv['libPays']>;
  codeNationalite: FormControl<IDmOResv['codeNationalite']>;
  libNationalite: FormControl<IDmOResv['libNationalite']>;
  codeSource: FormControl<IDmOResv['codeSource']>;
  libSource: FormControl<IDmOResv['libSource']>;
  codeGrandSource: FormControl<IDmOResv['codeGrandSource']>;
  codeOrigine: FormControl<IDmOResv['codeOrigine']>;
  libOrigine: FormControl<IDmOResv['libOrigine']>;
  codeMarche: FormControl<IDmOResv['codeMarche']>;
  libMarche: FormControl<IDmOResv['libMarche']>;
  codeGrandMarche: FormControl<IDmOResv['codeGrandMarche']>;
  libGrandMarche: FormControl<IDmOResv['libGrandMarche']>;
  codePrix: FormControl<IDmOResv['codePrix']>;
  categPrix: FormControl<IDmOResv['categPrix']>;
  libPrix: FormControl<IDmOResv['libPrix']>;
  numChb: FormControl<IDmOResv['numChb']>;
  descriptionTypeChb: FormControl<IDmOResv['descriptionTypeChb']>;
  codeTypeChb: FormControl<IDmOResv['codeTypeChb']>;
  classChb: FormControl<IDmOResv['classChb']>;
  caractChb: FormControl<IDmOResv['caractChb']>;
  typeChbDeReservation: FormControl<IDmOResv['typeChbDeReservation']>;
  descriptionTypeChbDeResv: FormControl<IDmOResv['descriptionTypeChbDeResv']>;
  codeTypeChbDeResv: FormControl<IDmOResv['codeTypeChbDeResv']>;
  statutDeReservation: FormControl<IDmOResv['statutDeReservation']>;
  circuitDistribution: FormControl<IDmOResv['circuitDistribution']>;
  circuitDistribUserRegroup: FormControl<IDmOResv['circuitDistribUserRegroup']>;
  numCrs: FormControl<IDmOResv['numCrs']>;
  typeRefCrs: FormControl<IDmOResv['typeRefCrs']>;
  crsInsertDate: FormControl<IDmOResv['crsInsertDate']>;
  dateCreaResv: FormControl<IDmOResv['dateCreaResv']>;
  datePremier: FormControl<IDmOResv['datePremier']>;
  statutPremier: FormControl<IDmOResv['statutPremier']>;
  dateDernier: FormControl<IDmOResv['dateDernier']>;
  statutDernier: FormControl<IDmOResv['statutDernier']>;
  dateDernierPseudo: FormControl<IDmOResv['dateDernierPseudo']>;
  statutDernierPseudo: FormControl<IDmOResv['statutDernierPseudo']>;
  diffDtCreaAnn: FormControl<IDmOResv['diffDtCreaAnn']>;
  diffDtArrAnn: FormControl<IDmOResv['diffDtArrAnn']>;
  leadtime: FormControl<IDmOResv['leadtime']>;
  los: FormControl<IDmOResv['los']>;
  occupantsGroupe: FormControl<IDmOResv['occupantsGroupe']>;
  nbNuitee: FormControl<IDmOResv['nbNuitee']>;
  nbNuiteeNnDed: FormControl<IDmOResv['nbNuiteeNnDed']>;
  nbResvAnn: FormControl<IDmOResv['nbResvAnn']>;
  nbAdu: FormControl<IDmOResv['nbAdu']>;
  nbEnf: FormControl<IDmOResv['nbEnf']>;
  nbPersDayU: FormControl<IDmOResv['nbPersDayU']>;
  nbPersArr: FormControl<IDmOResv['nbPersArr']>;
  nbPersDep: FormControl<IDmOResv['nbPersDep']>;
  nbPersAnn: FormControl<IDmOResv['nbPersAnn']>;
  nbPersNoshow: FormControl<IDmOResv['nbPersNoshow']>;
  nbChbDayU: FormControl<IDmOResv['nbChbDayU']>;
  nbChbArr: FormControl<IDmOResv['nbChbArr']>;
  nbChbDep: FormControl<IDmOResv['nbChbDep']>;
  nbChbAnn: FormControl<IDmOResv['nbChbAnn']>;
  nbChbNoshow: FormControl<IDmOResv['nbChbNoshow']>;
  revenuNetChambre: FormControl<IDmOResv['revenuNetChambre']>;
  revenuTaxeChambre: FormControl<IDmOResv['revenuTaxeChambre']>;
  revenuNetChambreGlobal: FormControl<IDmOResv['revenuNetChambreGlobal']>;
  revenuTaxeChambreGlobal: FormControl<IDmOResv['revenuTaxeChambreGlobal']>;
  revenuNetBq: FormControl<IDmOResv['revenuNetBq']>;
  revenuTaxeBq: FormControl<IDmOResv['revenuTaxeBq']>;
  revenuNetBqGlobal: FormControl<IDmOResv['revenuNetBqGlobal']>;
  revenuTaxeBqGlobal: FormControl<IDmOResv['revenuTaxeBqGlobal']>;
  revenuNetExtra: FormControl<IDmOResv['revenuNetExtra']>;
  revenuTaxeExtra: FormControl<IDmOResv['revenuTaxeExtra']>;
  revenuNetExtraGlobal: FormControl<IDmOResv['revenuNetExtraGlobal']>;
  revenuTaxeExtraGlobal: FormControl<IDmOResv['revenuTaxeExtraGlobal']>;
  revenuNetTotal: FormControl<IDmOResv['revenuNetTotal']>;
  revenuTaxeTotal: FormControl<IDmOResv['revenuTaxeTotal']>;
  revenuNetTotalGlobal: FormControl<IDmOResv['revenuNetTotalGlobal']>;
  revenuTaxeTotalGlobal: FormControl<IDmOResv['revenuTaxeTotalGlobal']>;
  prodRevenuChambre: FormControl<IDmOResv['prodRevenuChambre']>;
  prodRevenuBq: FormControl<IDmOResv['prodRevenuBq']>;
  prodRevenuExtra: FormControl<IDmOResv['prodRevenuExtra']>;
  prodRevenuTotal: FormControl<IDmOResv['prodRevenuTotal']>;
  prodChambreNbNuitees: FormControl<IDmOResv['prodChambreNbNuitees']>;
  techCreateDate: FormControl<IDmOResv['techCreateDate']>;
  techUpdateDate: FormControl<IDmOResv['techUpdateDate']>;
};

export type DmOResvFormGroup = FormGroup<DmOResvFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class DmOResvFormService {
  createDmOResvFormGroup(dmOResv: DmOResvFormGroupInput = { id: null }): DmOResvFormGroup {
    const dmOResvRawValue = {
      ...this.getFormDefaults(),
      ...dmOResv,
    };
    return new FormGroup<DmOResvFormGroupContent>({
      id: new FormControl(
        { value: dmOResvRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      numLigne: new FormControl(dmOResvRawValue.numLigne),
      resort: new FormControl(dmOResvRawValue.resort),
      resvNameId: new FormControl(dmOResvRawValue.resvNameId),
      clientOId: new FormControl(dmOResvRawValue.clientOId),
      typeChb: new FormControl(dmOResvRawValue.typeChb),
      confirmationNo: new FormControl(dmOResvRawValue.confirmationNo),
      clientMdmId: new FormControl(dmOResvRawValue.clientMdmId),
      nameId: new FormControl(dmOResvRawValue.nameId),
      parentResvNameId: new FormControl(dmOResvRawValue.parentResvNameId),
      contactId: new FormControl(dmOResvRawValue.contactId),
      agenceId: new FormControl(dmOResvRawValue.agenceId),
      agenceNom: new FormControl(dmOResvRawValue.agenceNom),
      societeId: new FormControl(dmOResvRawValue.societeId),
      groupeId: new FormControl(dmOResvRawValue.groupeId),
      numBloc: new FormControl(dmOResvRawValue.numBloc),
      typeResv: new FormControl(dmOResvRawValue.typeResv),
      statutResv: new FormControl(dmOResvRawValue.statutResv),
      dateDebutResv: new FormControl(dmOResvRawValue.dateDebutResv),
      dateFinResv: new FormControl(dmOResvRawValue.dateFinResv),
      truncDateDebutResv: new FormControl(dmOResvRawValue.truncDateDebutResv),
      truncDateFinResv: new FormControl(dmOResvRawValue.truncDateFinResv),
      dateAnnResv: new FormControl(dmOResvRawValue.dateAnnResv),
      pseudoRoomYn: new FormControl(dmOResvRawValue.pseudoRoomYn),
      createurResv: new FormControl(dmOResvRawValue.createurResv),
      nomCreateurResv: new FormControl(dmOResvRawValue.nomCreateurResv),
      codeGarantie: new FormControl(dmOResvRawValue.codeGarantie),
      flgDed: new FormControl(dmOResvRawValue.flgDed),
      codePays: new FormControl(dmOResvRawValue.codePays),
      libPays: new FormControl(dmOResvRawValue.libPays),
      codeNationalite: new FormControl(dmOResvRawValue.codeNationalite),
      libNationalite: new FormControl(dmOResvRawValue.libNationalite),
      codeSource: new FormControl(dmOResvRawValue.codeSource),
      libSource: new FormControl(dmOResvRawValue.libSource),
      codeGrandSource: new FormControl(dmOResvRawValue.codeGrandSource),
      codeOrigine: new FormControl(dmOResvRawValue.codeOrigine),
      libOrigine: new FormControl(dmOResvRawValue.libOrigine),
      codeMarche: new FormControl(dmOResvRawValue.codeMarche),
      libMarche: new FormControl(dmOResvRawValue.libMarche),
      codeGrandMarche: new FormControl(dmOResvRawValue.codeGrandMarche),
      libGrandMarche: new FormControl(dmOResvRawValue.libGrandMarche),
      codePrix: new FormControl(dmOResvRawValue.codePrix),
      categPrix: new FormControl(dmOResvRawValue.categPrix),
      libPrix: new FormControl(dmOResvRawValue.libPrix),
      numChb: new FormControl(dmOResvRawValue.numChb),
      descriptionTypeChb: new FormControl(dmOResvRawValue.descriptionTypeChb),
      codeTypeChb: new FormControl(dmOResvRawValue.codeTypeChb),
      classChb: new FormControl(dmOResvRawValue.classChb),
      caractChb: new FormControl(dmOResvRawValue.caractChb),
      typeChbDeReservation: new FormControl(dmOResvRawValue.typeChbDeReservation),
      descriptionTypeChbDeResv: new FormControl(dmOResvRawValue.descriptionTypeChbDeResv),
      codeTypeChbDeResv: new FormControl(dmOResvRawValue.codeTypeChbDeResv),
      statutDeReservation: new FormControl(dmOResvRawValue.statutDeReservation),
      circuitDistribution: new FormControl(dmOResvRawValue.circuitDistribution),
      circuitDistribUserRegroup: new FormControl(dmOResvRawValue.circuitDistribUserRegroup),
      numCrs: new FormControl(dmOResvRawValue.numCrs),
      typeRefCrs: new FormControl(dmOResvRawValue.typeRefCrs),
      crsInsertDate: new FormControl(dmOResvRawValue.crsInsertDate),
      dateCreaResv: new FormControl(dmOResvRawValue.dateCreaResv),
      datePremier: new FormControl(dmOResvRawValue.datePremier),
      statutPremier: new FormControl(dmOResvRawValue.statutPremier),
      dateDernier: new FormControl(dmOResvRawValue.dateDernier),
      statutDernier: new FormControl(dmOResvRawValue.statutDernier),
      dateDernierPseudo: new FormControl(dmOResvRawValue.dateDernierPseudo),
      statutDernierPseudo: new FormControl(dmOResvRawValue.statutDernierPseudo),
      diffDtCreaAnn: new FormControl(dmOResvRawValue.diffDtCreaAnn),
      diffDtArrAnn: new FormControl(dmOResvRawValue.diffDtArrAnn),
      leadtime: new FormControl(dmOResvRawValue.leadtime),
      los: new FormControl(dmOResvRawValue.los),
      occupantsGroupe: new FormControl(dmOResvRawValue.occupantsGroupe),
      nbNuitee: new FormControl(dmOResvRawValue.nbNuitee),
      nbNuiteeNnDed: new FormControl(dmOResvRawValue.nbNuiteeNnDed),
      nbResvAnn: new FormControl(dmOResvRawValue.nbResvAnn),
      nbAdu: new FormControl(dmOResvRawValue.nbAdu),
      nbEnf: new FormControl(dmOResvRawValue.nbEnf),
      nbPersDayU: new FormControl(dmOResvRawValue.nbPersDayU),
      nbPersArr: new FormControl(dmOResvRawValue.nbPersArr),
      nbPersDep: new FormControl(dmOResvRawValue.nbPersDep),
      nbPersAnn: new FormControl(dmOResvRawValue.nbPersAnn),
      nbPersNoshow: new FormControl(dmOResvRawValue.nbPersNoshow),
      nbChbDayU: new FormControl(dmOResvRawValue.nbChbDayU),
      nbChbArr: new FormControl(dmOResvRawValue.nbChbArr),
      nbChbDep: new FormControl(dmOResvRawValue.nbChbDep),
      nbChbAnn: new FormControl(dmOResvRawValue.nbChbAnn),
      nbChbNoshow: new FormControl(dmOResvRawValue.nbChbNoshow),
      revenuNetChambre: new FormControl(dmOResvRawValue.revenuNetChambre),
      revenuTaxeChambre: new FormControl(dmOResvRawValue.revenuTaxeChambre),
      revenuNetChambreGlobal: new FormControl(dmOResvRawValue.revenuNetChambreGlobal),
      revenuTaxeChambreGlobal: new FormControl(dmOResvRawValue.revenuTaxeChambreGlobal),
      revenuNetBq: new FormControl(dmOResvRawValue.revenuNetBq),
      revenuTaxeBq: new FormControl(dmOResvRawValue.revenuTaxeBq),
      revenuNetBqGlobal: new FormControl(dmOResvRawValue.revenuNetBqGlobal),
      revenuTaxeBqGlobal: new FormControl(dmOResvRawValue.revenuTaxeBqGlobal),
      revenuNetExtra: new FormControl(dmOResvRawValue.revenuNetExtra),
      revenuTaxeExtra: new FormControl(dmOResvRawValue.revenuTaxeExtra),
      revenuNetExtraGlobal: new FormControl(dmOResvRawValue.revenuNetExtraGlobal),
      revenuTaxeExtraGlobal: new FormControl(dmOResvRawValue.revenuTaxeExtraGlobal),
      revenuNetTotal: new FormControl(dmOResvRawValue.revenuNetTotal),
      revenuTaxeTotal: new FormControl(dmOResvRawValue.revenuTaxeTotal),
      revenuNetTotalGlobal: new FormControl(dmOResvRawValue.revenuNetTotalGlobal),
      revenuTaxeTotalGlobal: new FormControl(dmOResvRawValue.revenuTaxeTotalGlobal),
      prodRevenuChambre: new FormControl(dmOResvRawValue.prodRevenuChambre),
      prodRevenuBq: new FormControl(dmOResvRawValue.prodRevenuBq),
      prodRevenuExtra: new FormControl(dmOResvRawValue.prodRevenuExtra),
      prodRevenuTotal: new FormControl(dmOResvRawValue.prodRevenuTotal),
      prodChambreNbNuitees: new FormControl(dmOResvRawValue.prodChambreNbNuitees),
      techCreateDate: new FormControl(dmOResvRawValue.techCreateDate),
      techUpdateDate: new FormControl(dmOResvRawValue.techUpdateDate),
    });
  }

  getDmOResv(form: DmOResvFormGroup): IDmOResv | NewDmOResv {
    return form.getRawValue() as IDmOResv | NewDmOResv;
  }

  resetForm(form: DmOResvFormGroup, dmOResv: DmOResvFormGroupInput): void {
    const dmOResvRawValue = { ...this.getFormDefaults(), ...dmOResv };
    form.reset(
      {
        ...dmOResvRawValue,
        id: { value: dmOResvRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): DmOResvFormDefaults {
    return {
      id: null,
    };
  }
}

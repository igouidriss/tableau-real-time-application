import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IFtOResv, NewFtOResv } from '../ft-o-resv.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IFtOResv for edit and NewFtOResvFormGroupInput for create.
 */
type FtOResvFormGroupInput = IFtOResv | PartialWithRequiredKeyOf<NewFtOResv>;

type FtOResvFormDefaults = Pick<NewFtOResv, 'id'>;

type FtOResvFormGroupContent = {
  id: FormControl<IFtOResv['id'] | NewFtOResv['id']>;
  numLigne: FormControl<IFtOResv['numLigne']>;
  resort: FormControl<IFtOResv['resort']>;
  resvNameId: FormControl<IFtOResv['resvNameId']>;
  clientOId: FormControl<IFtOResv['clientOId']>;
  typeChb: FormControl<IFtOResv['typeChb']>;
  businessDate: FormControl<IFtOResv['businessDate']>;
  numOrdre: FormControl<IFtOResv['numOrdre']>;
  confirmationNo: FormControl<IFtOResv['confirmationNo']>;
  clientMdmId: FormControl<IFtOResv['clientMdmId']>;
  nameId: FormControl<IFtOResv['nameId']>;
  nameIdLigne: FormControl<IFtOResv['nameIdLigne']>;
  contactId: FormControl<IFtOResv['contactId']>;
  agenceId: FormControl<IFtOResv['agenceId']>;
  agenceNom: FormControl<IFtOResv['agenceNom']>;
  societeId: FormControl<IFtOResv['societeId']>;
  groupeId: FormControl<IFtOResv['groupeId']>;
  membreId: FormControl<IFtOResv['membreId']>;
  sourceProfileId: FormControl<IFtOResv['sourceProfileId']>;
  numBloc: FormControl<IFtOResv['numBloc']>;
  statutResv: FormControl<IFtOResv['statutResv']>;
  statutVip: FormControl<IFtOResv['statutVip']>;
  dateDebutLigne: FormControl<IFtOResv['dateDebutLigne']>;
  dateFinLigne: FormControl<IFtOResv['dateFinLigne']>;
  dateFinOrigine: FormControl<IFtOResv['dateFinOrigine']>;
  dateAnn: FormControl<IFtOResv['dateAnn']>;
  pseudoRoomYn: FormControl<IFtOResv['pseudoRoomYn']>;
  complementaireYn: FormControl<IFtOResv['complementaireYn']>;
  interneYn: FormControl<IFtOResv['interneYn']>;
  walkinYn: FormControl<IFtOResv['walkinYn']>;
  createurResv: FormControl<IFtOResv['createurResv']>;
  nomCreateurResv: FormControl<IFtOResv['nomCreateurResv']>;
  codePays: FormControl<IFtOResv['codePays']>;
  libPays: FormControl<IFtOResv['libPays']>;
  codeNationalite: FormControl<IFtOResv['codeNationalite']>;
  libNationalite: FormControl<IFtOResv['libNationalite']>;
  codeSource: FormControl<IFtOResv['codeSource']>;
  libSource: FormControl<IFtOResv['libSource']>;
  codeGrandSource: FormControl<IFtOResv['codeGrandSource']>;
  codeOrigine: FormControl<IFtOResv['codeOrigine']>;
  libOrigine: FormControl<IFtOResv['libOrigine']>;
  codeMarche: FormControl<IFtOResv['codeMarche']>;
  libMarche: FormControl<IFtOResv['libMarche']>;
  codeGrandMarche: FormControl<IFtOResv['codeGrandMarche']>;
  libGrandMarche: FormControl<IFtOResv['libGrandMarche']>;
  codePrix: FormControl<IFtOResv['codePrix']>;
  categPrix: FormControl<IFtOResv['categPrix']>;
  libPrix: FormControl<IFtOResv['libPrix']>;
  numChb: FormControl<IFtOResv['numChb']>;
  typeChbLigne: FormControl<IFtOResv['typeChbLigne']>;
  descriptionTypeChb: FormControl<IFtOResv['descriptionTypeChb']>;
  codeTypeChb: FormControl<IFtOResv['codeTypeChb']>;
  classChb: FormControl<IFtOResv['classChb']>;
  statutChbResv: FormControl<IFtOResv['statutChbResv']>;
  typeChbDeReservation: FormControl<IFtOResv['typeChbDeReservation']>;
  descriptionTypeChbDeResv: FormControl<IFtOResv['descriptionTypeChbDeResv']>;
  codeTypeChbDeResv: FormControl<IFtOResv['codeTypeChbDeResv']>;
  circuitDistribution: FormControl<IFtOResv['circuitDistribution']>;
  circuitDistribUserRegroup: FormControl<IFtOResv['circuitDistribUserRegroup']>;
  nbResvAnn: FormControl<IFtOResv['nbResvAnn']>;
  nbNuitee: FormControl<IFtOResv['nbNuitee']>;
  nbNuiteeNnDed: FormControl<IFtOResv['nbNuiteeNnDed']>;
  nbNuiteeGlobal: FormControl<IFtOResv['nbNuiteeGlobal']>;
  nbOccupationMultiple: FormControl<IFtOResv['nbOccupationMultiple']>;
  nbAduGlobal: FormControl<IFtOResv['nbAduGlobal']>;
  nbEnfGlobal: FormControl<IFtOResv['nbEnfGlobal']>;
  nbPersDayUGlobal: FormControl<IFtOResv['nbPersDayUGlobal']>;
  nbPersArrGlobal: FormControl<IFtOResv['nbPersArrGlobal']>;
  nbPersDepGlobal: FormControl<IFtOResv['nbPersDepGlobal']>;
  nbPersAnn: FormControl<IFtOResv['nbPersAnn']>;
  nbPersNoshow: FormControl<IFtOResv['nbPersNoshow']>;
  nbChbDayUGlobal: FormControl<IFtOResv['nbChbDayUGlobal']>;
  nbChbArrGlobal: FormControl<IFtOResv['nbChbArrGlobal']>;
  nbChbDepGlobal: FormControl<IFtOResv['nbChbDepGlobal']>;
  nbChbAnn: FormControl<IFtOResv['nbChbAnn']>;
  nbChbNoshow: FormControl<IFtOResv['nbChbNoshow']>;
  revenuNetChambreGlobal: FormControl<IFtOResv['revenuNetChambreGlobal']>;
  revenuTaxeChambreGlobal: FormControl<IFtOResv['revenuTaxeChambreGlobal']>;
  revenuNetBqGlobal: FormControl<IFtOResv['revenuNetBqGlobal']>;
  revenuTaxeBqGlobal: FormControl<IFtOResv['revenuTaxeBqGlobal']>;
  revenuNetExtraGlobal: FormControl<IFtOResv['revenuNetExtraGlobal']>;
  revenuTaxeExtraGlobal: FormControl<IFtOResv['revenuTaxeExtraGlobal']>;
  revenuNetTotalGlobal: FormControl<IFtOResv['revenuNetTotalGlobal']>;
  revenuTaxeTotalGlobal: FormControl<IFtOResv['revenuTaxeTotalGlobal']>;
  prodRevenuChambre: FormControl<IFtOResv['prodRevenuChambre']>;
  prodRevenuBq: FormControl<IFtOResv['prodRevenuBq']>;
  prodRevenuExtra: FormControl<IFtOResv['prodRevenuExtra']>;
  prodRevenuTotal: FormControl<IFtOResv['prodRevenuTotal']>;
  prodChambreNbNuitees: FormControl<IFtOResv['prodChambreNbNuitees']>;
  datesSejourRensYn: FormControl<IFtOResv['datesSejourRensYn']>;
  techEventType: FormControl<IFtOResv['techEventType']>;
  techResvInvType: FormControl<IFtOResv['techResvInvType']>;
  techOrigine: FormControl<IFtOResv['techOrigine']>;
  techGrpNumOrdre: FormControl<IFtOResv['techGrpNumOrdre']>;
  techCreateDate: FormControl<IFtOResv['techCreateDate']>;
  techUpdateDate: FormControl<IFtOResv['techUpdateDate']>;
  resvNameIdPrincipal: FormControl<IFtOResv['resvNameIdPrincipal']>;
};

export type FtOResvFormGroup = FormGroup<FtOResvFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class FtOResvFormService {
  createFtOResvFormGroup(ftOResv: FtOResvFormGroupInput = { id: null }): FtOResvFormGroup {
    const ftOResvRawValue = {
      ...this.getFormDefaults(),
      ...ftOResv,
    };
    return new FormGroup<FtOResvFormGroupContent>({
      id: new FormControl(
        { value: ftOResvRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      numLigne: new FormControl(ftOResvRawValue.numLigne),
      resort: new FormControl(ftOResvRawValue.resort),
      resvNameId: new FormControl(ftOResvRawValue.resvNameId),
      clientOId: new FormControl(ftOResvRawValue.clientOId),
      typeChb: new FormControl(ftOResvRawValue.typeChb),
      businessDate: new FormControl(ftOResvRawValue.businessDate),
      numOrdre: new FormControl(ftOResvRawValue.numOrdre),
      confirmationNo: new FormControl(ftOResvRawValue.confirmationNo),
      clientMdmId: new FormControl(ftOResvRawValue.clientMdmId),
      nameId: new FormControl(ftOResvRawValue.nameId),
      nameIdLigne: new FormControl(ftOResvRawValue.nameIdLigne),
      contactId: new FormControl(ftOResvRawValue.contactId),
      agenceId: new FormControl(ftOResvRawValue.agenceId),
      agenceNom: new FormControl(ftOResvRawValue.agenceNom),
      societeId: new FormControl(ftOResvRawValue.societeId),
      groupeId: new FormControl(ftOResvRawValue.groupeId),
      membreId: new FormControl(ftOResvRawValue.membreId),
      sourceProfileId: new FormControl(ftOResvRawValue.sourceProfileId),
      numBloc: new FormControl(ftOResvRawValue.numBloc),
      statutResv: new FormControl(ftOResvRawValue.statutResv),
      statutVip: new FormControl(ftOResvRawValue.statutVip),
      dateDebutLigne: new FormControl(ftOResvRawValue.dateDebutLigne),
      dateFinLigne: new FormControl(ftOResvRawValue.dateFinLigne),
      dateFinOrigine: new FormControl(ftOResvRawValue.dateFinOrigine),
      dateAnn: new FormControl(ftOResvRawValue.dateAnn),
      pseudoRoomYn: new FormControl(ftOResvRawValue.pseudoRoomYn),
      complementaireYn: new FormControl(ftOResvRawValue.complementaireYn),
      interneYn: new FormControl(ftOResvRawValue.interneYn),
      walkinYn: new FormControl(ftOResvRawValue.walkinYn),
      createurResv: new FormControl(ftOResvRawValue.createurResv),
      nomCreateurResv: new FormControl(ftOResvRawValue.nomCreateurResv),
      codePays: new FormControl(ftOResvRawValue.codePays),
      libPays: new FormControl(ftOResvRawValue.libPays),
      codeNationalite: new FormControl(ftOResvRawValue.codeNationalite),
      libNationalite: new FormControl(ftOResvRawValue.libNationalite),
      codeSource: new FormControl(ftOResvRawValue.codeSource),
      libSource: new FormControl(ftOResvRawValue.libSource),
      codeGrandSource: new FormControl(ftOResvRawValue.codeGrandSource),
      codeOrigine: new FormControl(ftOResvRawValue.codeOrigine),
      libOrigine: new FormControl(ftOResvRawValue.libOrigine),
      codeMarche: new FormControl(ftOResvRawValue.codeMarche),
      libMarche: new FormControl(ftOResvRawValue.libMarche),
      codeGrandMarche: new FormControl(ftOResvRawValue.codeGrandMarche),
      libGrandMarche: new FormControl(ftOResvRawValue.libGrandMarche),
      codePrix: new FormControl(ftOResvRawValue.codePrix),
      categPrix: new FormControl(ftOResvRawValue.categPrix),
      libPrix: new FormControl(ftOResvRawValue.libPrix),
      numChb: new FormControl(ftOResvRawValue.numChb),
      typeChbLigne: new FormControl(ftOResvRawValue.typeChbLigne),
      descriptionTypeChb: new FormControl(ftOResvRawValue.descriptionTypeChb),
      codeTypeChb: new FormControl(ftOResvRawValue.codeTypeChb),
      classChb: new FormControl(ftOResvRawValue.classChb),
      statutChbResv: new FormControl(ftOResvRawValue.statutChbResv),
      typeChbDeReservation: new FormControl(ftOResvRawValue.typeChbDeReservation),
      descriptionTypeChbDeResv: new FormControl(ftOResvRawValue.descriptionTypeChbDeResv),
      codeTypeChbDeResv: new FormControl(ftOResvRawValue.codeTypeChbDeResv),
      circuitDistribution: new FormControl(ftOResvRawValue.circuitDistribution),
      circuitDistribUserRegroup: new FormControl(ftOResvRawValue.circuitDistribUserRegroup),
      nbResvAnn: new FormControl(ftOResvRawValue.nbResvAnn),
      nbNuitee: new FormControl(ftOResvRawValue.nbNuitee),
      nbNuiteeNnDed: new FormControl(ftOResvRawValue.nbNuiteeNnDed),
      nbNuiteeGlobal: new FormControl(ftOResvRawValue.nbNuiteeGlobal),
      nbOccupationMultiple: new FormControl(ftOResvRawValue.nbOccupationMultiple),
      nbAduGlobal: new FormControl(ftOResvRawValue.nbAduGlobal),
      nbEnfGlobal: new FormControl(ftOResvRawValue.nbEnfGlobal),
      nbPersDayUGlobal: new FormControl(ftOResvRawValue.nbPersDayUGlobal),
      nbPersArrGlobal: new FormControl(ftOResvRawValue.nbPersArrGlobal),
      nbPersDepGlobal: new FormControl(ftOResvRawValue.nbPersDepGlobal),
      nbPersAnn: new FormControl(ftOResvRawValue.nbPersAnn),
      nbPersNoshow: new FormControl(ftOResvRawValue.nbPersNoshow),
      nbChbDayUGlobal: new FormControl(ftOResvRawValue.nbChbDayUGlobal),
      nbChbArrGlobal: new FormControl(ftOResvRawValue.nbChbArrGlobal),
      nbChbDepGlobal: new FormControl(ftOResvRawValue.nbChbDepGlobal),
      nbChbAnn: new FormControl(ftOResvRawValue.nbChbAnn),
      nbChbNoshow: new FormControl(ftOResvRawValue.nbChbNoshow),
      revenuNetChambreGlobal: new FormControl(ftOResvRawValue.revenuNetChambreGlobal),
      revenuTaxeChambreGlobal: new FormControl(ftOResvRawValue.revenuTaxeChambreGlobal),
      revenuNetBqGlobal: new FormControl(ftOResvRawValue.revenuNetBqGlobal),
      revenuTaxeBqGlobal: new FormControl(ftOResvRawValue.revenuTaxeBqGlobal),
      revenuNetExtraGlobal: new FormControl(ftOResvRawValue.revenuNetExtraGlobal),
      revenuTaxeExtraGlobal: new FormControl(ftOResvRawValue.revenuTaxeExtraGlobal),
      revenuNetTotalGlobal: new FormControl(ftOResvRawValue.revenuNetTotalGlobal),
      revenuTaxeTotalGlobal: new FormControl(ftOResvRawValue.revenuTaxeTotalGlobal),
      prodRevenuChambre: new FormControl(ftOResvRawValue.prodRevenuChambre),
      prodRevenuBq: new FormControl(ftOResvRawValue.prodRevenuBq),
      prodRevenuExtra: new FormControl(ftOResvRawValue.prodRevenuExtra),
      prodRevenuTotal: new FormControl(ftOResvRawValue.prodRevenuTotal),
      prodChambreNbNuitees: new FormControl(ftOResvRawValue.prodChambreNbNuitees),
      datesSejourRensYn: new FormControl(ftOResvRawValue.datesSejourRensYn),
      techEventType: new FormControl(ftOResvRawValue.techEventType),
      techResvInvType: new FormControl(ftOResvRawValue.techResvInvType),
      techOrigine: new FormControl(ftOResvRawValue.techOrigine),
      techGrpNumOrdre: new FormControl(ftOResvRawValue.techGrpNumOrdre),
      techCreateDate: new FormControl(ftOResvRawValue.techCreateDate),
      techUpdateDate: new FormControl(ftOResvRawValue.techUpdateDate),
      resvNameIdPrincipal: new FormControl(ftOResvRawValue.resvNameIdPrincipal),
    });
  }

  getFtOResv(form: FtOResvFormGroup): IFtOResv | NewFtOResv {
    return form.getRawValue() as IFtOResv | NewFtOResv;
  }

  resetForm(form: FtOResvFormGroup, ftOResv: FtOResvFormGroupInput): void {
    const ftOResvRawValue = { ...this.getFormDefaults(), ...ftOResv };
    form.reset(
      {
        ...ftOResvRawValue,
        id: { value: ftOResvRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): FtOResvFormDefaults {
    return {
      id: null,
    };
  }
}

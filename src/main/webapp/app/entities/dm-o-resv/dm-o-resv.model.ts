import dayjs from 'dayjs/esm';

export interface IDmOResv {
  id: number;
  numLigne?: number | null;
  resort?: string | null;
  resvNameId?: number | null;
  clientOId?: string | null;
  typeChb?: string | null;
  confirmationNo?: string | null;
  clientMdmId?: string | null;
  nameId?: number | null;
  parentResvNameId?: number | null;
  contactId?: number | null;
  agenceId?: number | null;
  agenceNom?: string | null;
  societeId?: number | null;
  groupeId?: number | null;
  numBloc?: number | null;
  typeResv?: string | null;
  statutResv?: string | null;
  dateDebutResv?: dayjs.Dayjs | null;
  dateFinResv?: dayjs.Dayjs | null;
  truncDateDebutResv?: dayjs.Dayjs | null;
  truncDateFinResv?: dayjs.Dayjs | null;
  dateAnnResv?: dayjs.Dayjs | null;
  pseudoRoomYn?: string | null;
  createurResv?: number | null;
  nomCreateurResv?: string | null;
  codeGarantie?: string | null;
  flgDed?: string | null;
  codePays?: string | null;
  libPays?: string | null;
  codeNationalite?: string | null;
  libNationalite?: string | null;
  codeSource?: string | null;
  libSource?: string | null;
  codeGrandSource?: string | null;
  codeOrigine?: string | null;
  libOrigine?: string | null;
  codeMarche?: string | null;
  libMarche?: string | null;
  codeGrandMarche?: string | null;
  libGrandMarche?: string | null;
  codePrix?: string | null;
  categPrix?: string | null;
  libPrix?: string | null;
  numChb?: string | null;
  descriptionTypeChb?: string | null;
  codeTypeChb?: string | null;
  classChb?: string | null;
  caractChb?: string | null;
  typeChbDeReservation?: string | null;
  descriptionTypeChbDeResv?: string | null;
  codeTypeChbDeResv?: string | null;
  statutDeReservation?: string | null;
  circuitDistribution?: string | null;
  circuitDistribUserRegroup?: string | null;
  numCrs?: string | null;
  typeRefCrs?: string | null;
  crsInsertDate?: dayjs.Dayjs | null;
  dateCreaResv?: dayjs.Dayjs | null;
  datePremier?: dayjs.Dayjs | null;
  statutPremier?: string | null;
  dateDernier?: dayjs.Dayjs | null;
  statutDernier?: string | null;
  dateDernierPseudo?: dayjs.Dayjs | null;
  statutDernierPseudo?: string | null;
  diffDtCreaAnn?: number | null;
  diffDtArrAnn?: number | null;
  leadtime?: number | null;
  los?: number | null;
  occupantsGroupe?: string | null;
  nbNuitee?: number | null;
  nbNuiteeNnDed?: number | null;
  nbResvAnn?: number | null;
  nbAdu?: number | null;
  nbEnf?: number | null;
  nbPersDayU?: number | null;
  nbPersArr?: number | null;
  nbPersDep?: number | null;
  nbPersAnn?: number | null;
  nbPersNoshow?: number | null;
  nbChbDayU?: number | null;
  nbChbArr?: number | null;
  nbChbDep?: number | null;
  nbChbAnn?: number | null;
  nbChbNoshow?: number | null;
  revenuNetChambre?: number | null;
  revenuTaxeChambre?: number | null;
  revenuNetChambreGlobal?: number | null;
  revenuTaxeChambreGlobal?: number | null;
  revenuNetBq?: number | null;
  revenuTaxeBq?: number | null;
  revenuNetBqGlobal?: number | null;
  revenuTaxeBqGlobal?: number | null;
  revenuNetExtra?: number | null;
  revenuTaxeExtra?: number | null;
  revenuNetExtraGlobal?: number | null;
  revenuTaxeExtraGlobal?: number | null;
  revenuNetTotal?: number | null;
  revenuTaxeTotal?: number | null;
  revenuNetTotalGlobal?: number | null;
  revenuTaxeTotalGlobal?: number | null;
  prodRevenuChambre?: number | null;
  prodRevenuBq?: number | null;
  prodRevenuExtra?: number | null;
  prodRevenuTotal?: number | null;
  prodChambreNbNuitees?: number | null;
  techCreateDate?: dayjs.Dayjs | null;
  techUpdateDate?: dayjs.Dayjs | null;
}

export type NewDmOResv = Omit<IDmOResv, 'id'> & { id: null };
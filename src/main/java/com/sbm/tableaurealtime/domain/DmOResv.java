package com.sbm.tableaurealtime.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A DmOResv.
 */
@Entity
@Table(name = "dm_o_resv")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DmOResv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "num_ligne")
    private Integer numLigne;

    @Column(name = "resort")
    private String resort;

    @Column(name = "resv_name_id")
    private Integer resvNameId;

    @Column(name = "client_o_id")
    private String clientOId;

    @Column(name = "type_chb")
    private String typeChb;

    @Column(name = "confirmation_no")
    private String confirmationNo;

    @Column(name = "client_mdm_id")
    private String clientMdmId;

    @Column(name = "name_id")
    private Integer nameId;

    @Column(name = "parent_resv_name_id")
    private Integer parentResvNameId;

    @Column(name = "contact_id")
    private Integer contactId;

    @Column(name = "agence_id")
    private Integer agenceId;

    @Column(name = "agence_nom")
    private String agenceNom;

    @Column(name = "societe_id")
    private Integer societeId;

    @Column(name = "groupe_id")
    private Integer groupeId;

    @Column(name = "num_bloc")
    private Integer numBloc;

    @Column(name = "type_resv")
    private String typeResv;

    @Column(name = "statut_resv")
    private String statutResv;

    @Column(name = "date_debut_resv")
    private LocalDate dateDebutResv;

    @Column(name = "date_fin_resv")
    private LocalDate dateFinResv;

    @Column(name = "trunc_date_debut_resv")
    private LocalDate truncDateDebutResv;

    @Column(name = "trunc_date_fin_resv")
    private LocalDate truncDateFinResv;

    @Column(name = "date_ann_resv")
    private LocalDate dateAnnResv;

    @Column(name = "pseudo_room_yn")
    private String pseudoRoomYn;

    @Column(name = "createur_resv")
    private Integer createurResv;

    @Column(name = "nom_createur_resv")
    private String nomCreateurResv;

    @Column(name = "code_garantie")
    private String codeGarantie;

    @Column(name = "flg_ded")
    private String flgDed;

    @Column(name = "code_pays")
    private String codePays;

    @Column(name = "lib_pays")
    private String libPays;

    @Column(name = "code_nationalite")
    private String codeNationalite;

    @Column(name = "lib_nationalite")
    private String libNationalite;

    @Column(name = "code_source")
    private String codeSource;

    @Column(name = "lib_source")
    private String libSource;

    @Column(name = "code_grand_source")
    private String codeGrandSource;

    @Column(name = "code_origine")
    private String codeOrigine;

    @Column(name = "lib_origine")
    private String libOrigine;

    @Column(name = "code_marche")
    private String codeMarche;

    @Column(name = "lib_marche")
    private String libMarche;

    @Column(name = "code_grand_marche")
    private String codeGrandMarche;

    @Column(name = "lib_grand_marche")
    private String libGrandMarche;

    @Column(name = "code_prix")
    private String codePrix;

    @Column(name = "categ_prix")
    private String categPrix;

    @Column(name = "lib_prix")
    private String libPrix;

    @Column(name = "num_chb")
    private String numChb;

    @Column(name = "description_type_chb")
    private String descriptionTypeChb;

    @Column(name = "code_type_chb")
    private String codeTypeChb;

    @Column(name = "class_chb")
    private String classChb;

    @Column(name = "caract_chb")
    private String caractChb;

    @Column(name = "type_chb_de_reservation")
    private String typeChbDeReservation;

    @Column(name = "description_type_chb_de_resv")
    private String descriptionTypeChbDeResv;

    @Column(name = "code_type_chb_de_resv")
    private String codeTypeChbDeResv;

    @Column(name = "statut_de_reservation")
    private String statutDeReservation;

    @Column(name = "circuit_distribution")
    private String circuitDistribution;

    @Column(name = "circuit_distrib_user_regroup")
    private String circuitDistribUserRegroup;

    @Column(name = "num_crs")
    private String numCrs;

    @Column(name = "type_ref_crs")
    private String typeRefCrs;

    @Column(name = "crs_insert_date")
    private LocalDate crsInsertDate;

    @Column(name = "date_crea_resv")
    private LocalDate dateCreaResv;

    @Column(name = "date_premier")
    private LocalDate datePremier;

    @Column(name = "statut_premier")
    private String statutPremier;

    @Column(name = "date_dernier")
    private LocalDate dateDernier;

    @Column(name = "statut_dernier")
    private String statutDernier;

    @Column(name = "date_dernier_pseudo")
    private LocalDate dateDernierPseudo;

    @Column(name = "statut_dernier_pseudo")
    private String statutDernierPseudo;

    @Column(name = "diff_dt_crea_ann")
    private Integer diffDtCreaAnn;

    @Column(name = "diff_dt_arr_ann")
    private Integer diffDtArrAnn;

    @Column(name = "leadtime")
    private Integer leadtime;

    @Column(name = "los")
    private Integer los;

    @Column(name = "occupants_groupe")
    private String occupantsGroupe;

    @Column(name = "nb_nuitee")
    private Integer nbNuitee;

    @Column(name = "nb_nuitee_nn_ded")
    private Integer nbNuiteeNnDed;

    @Column(name = "nb_resv_ann")
    private Integer nbResvAnn;

    @Column(name = "nb_adu")
    private Integer nbAdu;

    @Column(name = "nb_enf")
    private Integer nbEnf;

    @Column(name = "nb_pers_day_u")
    private Integer nbPersDayU;

    @Column(name = "nb_pers_arr")
    private Integer nbPersArr;

    @Column(name = "nb_pers_dep")
    private Integer nbPersDep;

    @Column(name = "nb_pers_ann")
    private Integer nbPersAnn;

    @Column(name = "nb_pers_noshow")
    private Integer nbPersNoshow;

    @Column(name = "nb_chb_day_u")
    private Integer nbChbDayU;

    @Column(name = "nb_chb_arr")
    private Integer nbChbArr;

    @Column(name = "nb_chb_dep")
    private Integer nbChbDep;

    @Column(name = "nb_chb_ann")
    private Integer nbChbAnn;

    @Column(name = "nb_chb_noshow")
    private Integer nbChbNoshow;

    @Column(name = "revenu_net_chambre")
    private Long revenuNetChambre;

    @Column(name = "revenu_taxe_chambre")
    private Long revenuTaxeChambre;

    @Column(name = "revenu_net_chambre_global")
    private Long revenuNetChambreGlobal;

    @Column(name = "revenu_taxe_chambre_global")
    private Long revenuTaxeChambreGlobal;

    @Column(name = "revenu_net_bq")
    private Long revenuNetBq;

    @Column(name = "revenu_taxe_bq")
    private Long revenuTaxeBq;

    @Column(name = "revenu_net_bq_global")
    private Long revenuNetBqGlobal;

    @Column(name = "revenu_taxe_bq_global")
    private Long revenuTaxeBqGlobal;

    @Column(name = "revenu_net_extra")
    private Long revenuNetExtra;

    @Column(name = "revenu_taxe_extra")
    private Long revenuTaxeExtra;

    @Column(name = "revenu_net_extra_global")
    private Long revenuNetExtraGlobal;

    @Column(name = "revenu_taxe_extra_global")
    private Long revenuTaxeExtraGlobal;

    @Column(name = "revenu_net_total")
    private Long revenuNetTotal;

    @Column(name = "revenu_taxe_total")
    private Long revenuTaxeTotal;

    @Column(name = "revenu_net_total_global")
    private Long revenuNetTotalGlobal;

    @Column(name = "revenu_taxe_total_global")
    private Long revenuTaxeTotalGlobal;

    @Column(name = "prod_revenu_chambre")
    private Long prodRevenuChambre;

    @Column(name = "prod_revenu_bq")
    private Long prodRevenuBq;

    @Column(name = "prod_revenu_extra")
    private Long prodRevenuExtra;

    @Column(name = "prod_revenu_total")
    private Long prodRevenuTotal;

    @Column(name = "prod_chambre_nb_nuitees")
    private Long prodChambreNbNuitees;

    @Column(name = "tech_create_date")
    private LocalDate techCreateDate;

    @Column(name = "tech_update_date")
    private LocalDate techUpdateDate;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public DmOResv id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumLigne() {
        return this.numLigne;
    }

    public DmOResv numLigne(Integer numLigne) {
        this.setNumLigne(numLigne);
        return this;
    }

    public void setNumLigne(Integer numLigne) {
        this.numLigne = numLigne;
    }

    public String getResort() {
        return this.resort;
    }

    public DmOResv resort(String resort) {
        this.setResort(resort);
        return this;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public Integer getResvNameId() {
        return this.resvNameId;
    }

    public DmOResv resvNameId(Integer resvNameId) {
        this.setResvNameId(resvNameId);
        return this;
    }

    public void setResvNameId(Integer resvNameId) {
        this.resvNameId = resvNameId;
    }

    public String getClientOId() {
        return this.clientOId;
    }

    public DmOResv clientOId(String clientOId) {
        this.setClientOId(clientOId);
        return this;
    }

    public void setClientOId(String clientOId) {
        this.clientOId = clientOId;
    }

    public String getTypeChb() {
        return this.typeChb;
    }

    public DmOResv typeChb(String typeChb) {
        this.setTypeChb(typeChb);
        return this;
    }

    public void setTypeChb(String typeChb) {
        this.typeChb = typeChb;
    }

    public String getConfirmationNo() {
        return this.confirmationNo;
    }

    public DmOResv confirmationNo(String confirmationNo) {
        this.setConfirmationNo(confirmationNo);
        return this;
    }

    public void setConfirmationNo(String confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    public String getClientMdmId() {
        return this.clientMdmId;
    }

    public DmOResv clientMdmId(String clientMdmId) {
        this.setClientMdmId(clientMdmId);
        return this;
    }

    public void setClientMdmId(String clientMdmId) {
        this.clientMdmId = clientMdmId;
    }

    public Integer getNameId() {
        return this.nameId;
    }

    public DmOResv nameId(Integer nameId) {
        this.setNameId(nameId);
        return this;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public Integer getParentResvNameId() {
        return this.parentResvNameId;
    }

    public DmOResv parentResvNameId(Integer parentResvNameId) {
        this.setParentResvNameId(parentResvNameId);
        return this;
    }

    public void setParentResvNameId(Integer parentResvNameId) {
        this.parentResvNameId = parentResvNameId;
    }

    public Integer getContactId() {
        return this.contactId;
    }

    public DmOResv contactId(Integer contactId) {
        this.setContactId(contactId);
        return this;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getAgenceId() {
        return this.agenceId;
    }

    public DmOResv agenceId(Integer agenceId) {
        this.setAgenceId(agenceId);
        return this;
    }

    public void setAgenceId(Integer agenceId) {
        this.agenceId = agenceId;
    }

    public String getAgenceNom() {
        return this.agenceNom;
    }

    public DmOResv agenceNom(String agenceNom) {
        this.setAgenceNom(agenceNom);
        return this;
    }

    public void setAgenceNom(String agenceNom) {
        this.agenceNom = agenceNom;
    }

    public Integer getSocieteId() {
        return this.societeId;
    }

    public DmOResv societeId(Integer societeId) {
        this.setSocieteId(societeId);
        return this;
    }

    public void setSocieteId(Integer societeId) {
        this.societeId = societeId;
    }

    public Integer getGroupeId() {
        return this.groupeId;
    }

    public DmOResv groupeId(Integer groupeId) {
        this.setGroupeId(groupeId);
        return this;
    }

    public void setGroupeId(Integer groupeId) {
        this.groupeId = groupeId;
    }

    public Integer getNumBloc() {
        return this.numBloc;
    }

    public DmOResv numBloc(Integer numBloc) {
        this.setNumBloc(numBloc);
        return this;
    }

    public void setNumBloc(Integer numBloc) {
        this.numBloc = numBloc;
    }

    public String getTypeResv() {
        return this.typeResv;
    }

    public DmOResv typeResv(String typeResv) {
        this.setTypeResv(typeResv);
        return this;
    }

    public void setTypeResv(String typeResv) {
        this.typeResv = typeResv;
    }

    public String getStatutResv() {
        return this.statutResv;
    }

    public DmOResv statutResv(String statutResv) {
        this.setStatutResv(statutResv);
        return this;
    }

    public void setStatutResv(String statutResv) {
        this.statutResv = statutResv;
    }

    public LocalDate getDateDebutResv() {
        return this.dateDebutResv;
    }

    public DmOResv dateDebutResv(LocalDate dateDebutResv) {
        this.setDateDebutResv(dateDebutResv);
        return this;
    }

    public void setDateDebutResv(LocalDate dateDebutResv) {
        this.dateDebutResv = dateDebutResv;
    }

    public LocalDate getDateFinResv() {
        return this.dateFinResv;
    }

    public DmOResv dateFinResv(LocalDate dateFinResv) {
        this.setDateFinResv(dateFinResv);
        return this;
    }

    public void setDateFinResv(LocalDate dateFinResv) {
        this.dateFinResv = dateFinResv;
    }

    public LocalDate getTruncDateDebutResv() {
        return this.truncDateDebutResv;
    }

    public DmOResv truncDateDebutResv(LocalDate truncDateDebutResv) {
        this.setTruncDateDebutResv(truncDateDebutResv);
        return this;
    }

    public void setTruncDateDebutResv(LocalDate truncDateDebutResv) {
        this.truncDateDebutResv = truncDateDebutResv;
    }

    public LocalDate getTruncDateFinResv() {
        return this.truncDateFinResv;
    }

    public DmOResv truncDateFinResv(LocalDate truncDateFinResv) {
        this.setTruncDateFinResv(truncDateFinResv);
        return this;
    }

    public void setTruncDateFinResv(LocalDate truncDateFinResv) {
        this.truncDateFinResv = truncDateFinResv;
    }

    public LocalDate getDateAnnResv() {
        return this.dateAnnResv;
    }

    public DmOResv dateAnnResv(LocalDate dateAnnResv) {
        this.setDateAnnResv(dateAnnResv);
        return this;
    }

    public void setDateAnnResv(LocalDate dateAnnResv) {
        this.dateAnnResv = dateAnnResv;
    }

    public String getPseudoRoomYn() {
        return this.pseudoRoomYn;
    }

    public DmOResv pseudoRoomYn(String pseudoRoomYn) {
        this.setPseudoRoomYn(pseudoRoomYn);
        return this;
    }

    public void setPseudoRoomYn(String pseudoRoomYn) {
        this.pseudoRoomYn = pseudoRoomYn;
    }

    public Integer getCreateurResv() {
        return this.createurResv;
    }

    public DmOResv createurResv(Integer createurResv) {
        this.setCreateurResv(createurResv);
        return this;
    }

    public void setCreateurResv(Integer createurResv) {
        this.createurResv = createurResv;
    }

    public String getNomCreateurResv() {
        return this.nomCreateurResv;
    }

    public DmOResv nomCreateurResv(String nomCreateurResv) {
        this.setNomCreateurResv(nomCreateurResv);
        return this;
    }

    public void setNomCreateurResv(String nomCreateurResv) {
        this.nomCreateurResv = nomCreateurResv;
    }

    public String getCodeGarantie() {
        return this.codeGarantie;
    }

    public DmOResv codeGarantie(String codeGarantie) {
        this.setCodeGarantie(codeGarantie);
        return this;
    }

    public void setCodeGarantie(String codeGarantie) {
        this.codeGarantie = codeGarantie;
    }

    public String getFlgDed() {
        return this.flgDed;
    }

    public DmOResv flgDed(String flgDed) {
        this.setFlgDed(flgDed);
        return this;
    }

    public void setFlgDed(String flgDed) {
        this.flgDed = flgDed;
    }

    public String getCodePays() {
        return this.codePays;
    }

    public DmOResv codePays(String codePays) {
        this.setCodePays(codePays);
        return this;
    }

    public void setCodePays(String codePays) {
        this.codePays = codePays;
    }

    public String getLibPays() {
        return this.libPays;
    }

    public DmOResv libPays(String libPays) {
        this.setLibPays(libPays);
        return this;
    }

    public void setLibPays(String libPays) {
        this.libPays = libPays;
    }

    public String getCodeNationalite() {
        return this.codeNationalite;
    }

    public DmOResv codeNationalite(String codeNationalite) {
        this.setCodeNationalite(codeNationalite);
        return this;
    }

    public void setCodeNationalite(String codeNationalite) {
        this.codeNationalite = codeNationalite;
    }

    public String getLibNationalite() {
        return this.libNationalite;
    }

    public DmOResv libNationalite(String libNationalite) {
        this.setLibNationalite(libNationalite);
        return this;
    }

    public void setLibNationalite(String libNationalite) {
        this.libNationalite = libNationalite;
    }

    public String getCodeSource() {
        return this.codeSource;
    }

    public DmOResv codeSource(String codeSource) {
        this.setCodeSource(codeSource);
        return this;
    }

    public void setCodeSource(String codeSource) {
        this.codeSource = codeSource;
    }

    public String getLibSource() {
        return this.libSource;
    }

    public DmOResv libSource(String libSource) {
        this.setLibSource(libSource);
        return this;
    }

    public void setLibSource(String libSource) {
        this.libSource = libSource;
    }

    public String getCodeGrandSource() {
        return this.codeGrandSource;
    }

    public DmOResv codeGrandSource(String codeGrandSource) {
        this.setCodeGrandSource(codeGrandSource);
        return this;
    }

    public void setCodeGrandSource(String codeGrandSource) {
        this.codeGrandSource = codeGrandSource;
    }

    public String getCodeOrigine() {
        return this.codeOrigine;
    }

    public DmOResv codeOrigine(String codeOrigine) {
        this.setCodeOrigine(codeOrigine);
        return this;
    }

    public void setCodeOrigine(String codeOrigine) {
        this.codeOrigine = codeOrigine;
    }

    public String getLibOrigine() {
        return this.libOrigine;
    }

    public DmOResv libOrigine(String libOrigine) {
        this.setLibOrigine(libOrigine);
        return this;
    }

    public void setLibOrigine(String libOrigine) {
        this.libOrigine = libOrigine;
    }

    public String getCodeMarche() {
        return this.codeMarche;
    }

    public DmOResv codeMarche(String codeMarche) {
        this.setCodeMarche(codeMarche);
        return this;
    }

    public void setCodeMarche(String codeMarche) {
        this.codeMarche = codeMarche;
    }

    public String getLibMarche() {
        return this.libMarche;
    }

    public DmOResv libMarche(String libMarche) {
        this.setLibMarche(libMarche);
        return this;
    }

    public void setLibMarche(String libMarche) {
        this.libMarche = libMarche;
    }

    public String getCodeGrandMarche() {
        return this.codeGrandMarche;
    }

    public DmOResv codeGrandMarche(String codeGrandMarche) {
        this.setCodeGrandMarche(codeGrandMarche);
        return this;
    }

    public void setCodeGrandMarche(String codeGrandMarche) {
        this.codeGrandMarche = codeGrandMarche;
    }

    public String getLibGrandMarche() {
        return this.libGrandMarche;
    }

    public DmOResv libGrandMarche(String libGrandMarche) {
        this.setLibGrandMarche(libGrandMarche);
        return this;
    }

    public void setLibGrandMarche(String libGrandMarche) {
        this.libGrandMarche = libGrandMarche;
    }

    public String getCodePrix() {
        return this.codePrix;
    }

    public DmOResv codePrix(String codePrix) {
        this.setCodePrix(codePrix);
        return this;
    }

    public void setCodePrix(String codePrix) {
        this.codePrix = codePrix;
    }

    public String getCategPrix() {
        return this.categPrix;
    }

    public DmOResv categPrix(String categPrix) {
        this.setCategPrix(categPrix);
        return this;
    }

    public void setCategPrix(String categPrix) {
        this.categPrix = categPrix;
    }

    public String getLibPrix() {
        return this.libPrix;
    }

    public DmOResv libPrix(String libPrix) {
        this.setLibPrix(libPrix);
        return this;
    }

    public void setLibPrix(String libPrix) {
        this.libPrix = libPrix;
    }

    public String getNumChb() {
        return this.numChb;
    }

    public DmOResv numChb(String numChb) {
        this.setNumChb(numChb);
        return this;
    }

    public void setNumChb(String numChb) {
        this.numChb = numChb;
    }

    public String getDescriptionTypeChb() {
        return this.descriptionTypeChb;
    }

    public DmOResv descriptionTypeChb(String descriptionTypeChb) {
        this.setDescriptionTypeChb(descriptionTypeChb);
        return this;
    }

    public void setDescriptionTypeChb(String descriptionTypeChb) {
        this.descriptionTypeChb = descriptionTypeChb;
    }

    public String getCodeTypeChb() {
        return this.codeTypeChb;
    }

    public DmOResv codeTypeChb(String codeTypeChb) {
        this.setCodeTypeChb(codeTypeChb);
        return this;
    }

    public void setCodeTypeChb(String codeTypeChb) {
        this.codeTypeChb = codeTypeChb;
    }

    public String getClassChb() {
        return this.classChb;
    }

    public DmOResv classChb(String classChb) {
        this.setClassChb(classChb);
        return this;
    }

    public void setClassChb(String classChb) {
        this.classChb = classChb;
    }

    public String getCaractChb() {
        return this.caractChb;
    }

    public DmOResv caractChb(String caractChb) {
        this.setCaractChb(caractChb);
        return this;
    }

    public void setCaractChb(String caractChb) {
        this.caractChb = caractChb;
    }

    public String getTypeChbDeReservation() {
        return this.typeChbDeReservation;
    }

    public DmOResv typeChbDeReservation(String typeChbDeReservation) {
        this.setTypeChbDeReservation(typeChbDeReservation);
        return this;
    }

    public void setTypeChbDeReservation(String typeChbDeReservation) {
        this.typeChbDeReservation = typeChbDeReservation;
    }

    public String getDescriptionTypeChbDeResv() {
        return this.descriptionTypeChbDeResv;
    }

    public DmOResv descriptionTypeChbDeResv(String descriptionTypeChbDeResv) {
        this.setDescriptionTypeChbDeResv(descriptionTypeChbDeResv);
        return this;
    }

    public void setDescriptionTypeChbDeResv(String descriptionTypeChbDeResv) {
        this.descriptionTypeChbDeResv = descriptionTypeChbDeResv;
    }

    public String getCodeTypeChbDeResv() {
        return this.codeTypeChbDeResv;
    }

    public DmOResv codeTypeChbDeResv(String codeTypeChbDeResv) {
        this.setCodeTypeChbDeResv(codeTypeChbDeResv);
        return this;
    }

    public void setCodeTypeChbDeResv(String codeTypeChbDeResv) {
        this.codeTypeChbDeResv = codeTypeChbDeResv;
    }

    public String getStatutDeReservation() {
        return this.statutDeReservation;
    }

    public DmOResv statutDeReservation(String statutDeReservation) {
        this.setStatutDeReservation(statutDeReservation);
        return this;
    }

    public void setStatutDeReservation(String statutDeReservation) {
        this.statutDeReservation = statutDeReservation;
    }

    public String getCircuitDistribution() {
        return this.circuitDistribution;
    }

    public DmOResv circuitDistribution(String circuitDistribution) {
        this.setCircuitDistribution(circuitDistribution);
        return this;
    }

    public void setCircuitDistribution(String circuitDistribution) {
        this.circuitDistribution = circuitDistribution;
    }

    public String getCircuitDistribUserRegroup() {
        return this.circuitDistribUserRegroup;
    }

    public DmOResv circuitDistribUserRegroup(String circuitDistribUserRegroup) {
        this.setCircuitDistribUserRegroup(circuitDistribUserRegroup);
        return this;
    }

    public void setCircuitDistribUserRegroup(String circuitDistribUserRegroup) {
        this.circuitDistribUserRegroup = circuitDistribUserRegroup;
    }

    public String getNumCrs() {
        return this.numCrs;
    }

    public DmOResv numCrs(String numCrs) {
        this.setNumCrs(numCrs);
        return this;
    }

    public void setNumCrs(String numCrs) {
        this.numCrs = numCrs;
    }

    public String getTypeRefCrs() {
        return this.typeRefCrs;
    }

    public DmOResv typeRefCrs(String typeRefCrs) {
        this.setTypeRefCrs(typeRefCrs);
        return this;
    }

    public void setTypeRefCrs(String typeRefCrs) {
        this.typeRefCrs = typeRefCrs;
    }

    public LocalDate getCrsInsertDate() {
        return this.crsInsertDate;
    }

    public DmOResv crsInsertDate(LocalDate crsInsertDate) {
        this.setCrsInsertDate(crsInsertDate);
        return this;
    }

    public void setCrsInsertDate(LocalDate crsInsertDate) {
        this.crsInsertDate = crsInsertDate;
    }

    public LocalDate getDateCreaResv() {
        return this.dateCreaResv;
    }

    public DmOResv dateCreaResv(LocalDate dateCreaResv) {
        this.setDateCreaResv(dateCreaResv);
        return this;
    }

    public void setDateCreaResv(LocalDate dateCreaResv) {
        this.dateCreaResv = dateCreaResv;
    }

    public LocalDate getDatePremier() {
        return this.datePremier;
    }

    public DmOResv datePremier(LocalDate datePremier) {
        this.setDatePremier(datePremier);
        return this;
    }

    public void setDatePremier(LocalDate datePremier) {
        this.datePremier = datePremier;
    }

    public String getStatutPremier() {
        return this.statutPremier;
    }

    public DmOResv statutPremier(String statutPremier) {
        this.setStatutPremier(statutPremier);
        return this;
    }

    public void setStatutPremier(String statutPremier) {
        this.statutPremier = statutPremier;
    }

    public LocalDate getDateDernier() {
        return this.dateDernier;
    }

    public DmOResv dateDernier(LocalDate dateDernier) {
        this.setDateDernier(dateDernier);
        return this;
    }

    public void setDateDernier(LocalDate dateDernier) {
        this.dateDernier = dateDernier;
    }

    public String getStatutDernier() {
        return this.statutDernier;
    }

    public DmOResv statutDernier(String statutDernier) {
        this.setStatutDernier(statutDernier);
        return this;
    }

    public void setStatutDernier(String statutDernier) {
        this.statutDernier = statutDernier;
    }

    public LocalDate getDateDernierPseudo() {
        return this.dateDernierPseudo;
    }

    public DmOResv dateDernierPseudo(LocalDate dateDernierPseudo) {
        this.setDateDernierPseudo(dateDernierPseudo);
        return this;
    }

    public void setDateDernierPseudo(LocalDate dateDernierPseudo) {
        this.dateDernierPseudo = dateDernierPseudo;
    }

    public String getStatutDernierPseudo() {
        return this.statutDernierPseudo;
    }

    public DmOResv statutDernierPseudo(String statutDernierPseudo) {
        this.setStatutDernierPseudo(statutDernierPseudo);
        return this;
    }

    public void setStatutDernierPseudo(String statutDernierPseudo) {
        this.statutDernierPseudo = statutDernierPseudo;
    }

    public Integer getDiffDtCreaAnn() {
        return this.diffDtCreaAnn;
    }

    public DmOResv diffDtCreaAnn(Integer diffDtCreaAnn) {
        this.setDiffDtCreaAnn(diffDtCreaAnn);
        return this;
    }

    public void setDiffDtCreaAnn(Integer diffDtCreaAnn) {
        this.diffDtCreaAnn = diffDtCreaAnn;
    }

    public Integer getDiffDtArrAnn() {
        return this.diffDtArrAnn;
    }

    public DmOResv diffDtArrAnn(Integer diffDtArrAnn) {
        this.setDiffDtArrAnn(diffDtArrAnn);
        return this;
    }

    public void setDiffDtArrAnn(Integer diffDtArrAnn) {
        this.diffDtArrAnn = diffDtArrAnn;
    }

    public Integer getLeadtime() {
        return this.leadtime;
    }

    public DmOResv leadtime(Integer leadtime) {
        this.setLeadtime(leadtime);
        return this;
    }

    public void setLeadtime(Integer leadtime) {
        this.leadtime = leadtime;
    }

    public Integer getLos() {
        return this.los;
    }

    public DmOResv los(Integer los) {
        this.setLos(los);
        return this;
    }

    public void setLos(Integer los) {
        this.los = los;
    }

    public String getOccupantsGroupe() {
        return this.occupantsGroupe;
    }

    public DmOResv occupantsGroupe(String occupantsGroupe) {
        this.setOccupantsGroupe(occupantsGroupe);
        return this;
    }

    public void setOccupantsGroupe(String occupantsGroupe) {
        this.occupantsGroupe = occupantsGroupe;
    }

    public Integer getNbNuitee() {
        return this.nbNuitee;
    }

    public DmOResv nbNuitee(Integer nbNuitee) {
        this.setNbNuitee(nbNuitee);
        return this;
    }

    public void setNbNuitee(Integer nbNuitee) {
        this.nbNuitee = nbNuitee;
    }

    public Integer getNbNuiteeNnDed() {
        return this.nbNuiteeNnDed;
    }

    public DmOResv nbNuiteeNnDed(Integer nbNuiteeNnDed) {
        this.setNbNuiteeNnDed(nbNuiteeNnDed);
        return this;
    }

    public void setNbNuiteeNnDed(Integer nbNuiteeNnDed) {
        this.nbNuiteeNnDed = nbNuiteeNnDed;
    }

    public Integer getNbResvAnn() {
        return this.nbResvAnn;
    }

    public DmOResv nbResvAnn(Integer nbResvAnn) {
        this.setNbResvAnn(nbResvAnn);
        return this;
    }

    public void setNbResvAnn(Integer nbResvAnn) {
        this.nbResvAnn = nbResvAnn;
    }

    public Integer getNbAdu() {
        return this.nbAdu;
    }

    public DmOResv nbAdu(Integer nbAdu) {
        this.setNbAdu(nbAdu);
        return this;
    }

    public void setNbAdu(Integer nbAdu) {
        this.nbAdu = nbAdu;
    }

    public Integer getNbEnf() {
        return this.nbEnf;
    }

    public DmOResv nbEnf(Integer nbEnf) {
        this.setNbEnf(nbEnf);
        return this;
    }

    public void setNbEnf(Integer nbEnf) {
        this.nbEnf = nbEnf;
    }

    public Integer getNbPersDayU() {
        return this.nbPersDayU;
    }

    public DmOResv nbPersDayU(Integer nbPersDayU) {
        this.setNbPersDayU(nbPersDayU);
        return this;
    }

    public void setNbPersDayU(Integer nbPersDayU) {
        this.nbPersDayU = nbPersDayU;
    }

    public Integer getNbPersArr() {
        return this.nbPersArr;
    }

    public DmOResv nbPersArr(Integer nbPersArr) {
        this.setNbPersArr(nbPersArr);
        return this;
    }

    public void setNbPersArr(Integer nbPersArr) {
        this.nbPersArr = nbPersArr;
    }

    public Integer getNbPersDep() {
        return this.nbPersDep;
    }

    public DmOResv nbPersDep(Integer nbPersDep) {
        this.setNbPersDep(nbPersDep);
        return this;
    }

    public void setNbPersDep(Integer nbPersDep) {
        this.nbPersDep = nbPersDep;
    }

    public Integer getNbPersAnn() {
        return this.nbPersAnn;
    }

    public DmOResv nbPersAnn(Integer nbPersAnn) {
        this.setNbPersAnn(nbPersAnn);
        return this;
    }

    public void setNbPersAnn(Integer nbPersAnn) {
        this.nbPersAnn = nbPersAnn;
    }

    public Integer getNbPersNoshow() {
        return this.nbPersNoshow;
    }

    public DmOResv nbPersNoshow(Integer nbPersNoshow) {
        this.setNbPersNoshow(nbPersNoshow);
        return this;
    }

    public void setNbPersNoshow(Integer nbPersNoshow) {
        this.nbPersNoshow = nbPersNoshow;
    }

    public Integer getNbChbDayU() {
        return this.nbChbDayU;
    }

    public DmOResv nbChbDayU(Integer nbChbDayU) {
        this.setNbChbDayU(nbChbDayU);
        return this;
    }

    public void setNbChbDayU(Integer nbChbDayU) {
        this.nbChbDayU = nbChbDayU;
    }

    public Integer getNbChbArr() {
        return this.nbChbArr;
    }

    public DmOResv nbChbArr(Integer nbChbArr) {
        this.setNbChbArr(nbChbArr);
        return this;
    }

    public void setNbChbArr(Integer nbChbArr) {
        this.nbChbArr = nbChbArr;
    }

    public Integer getNbChbDep() {
        return this.nbChbDep;
    }

    public DmOResv nbChbDep(Integer nbChbDep) {
        this.setNbChbDep(nbChbDep);
        return this;
    }

    public void setNbChbDep(Integer nbChbDep) {
        this.nbChbDep = nbChbDep;
    }

    public Integer getNbChbAnn() {
        return this.nbChbAnn;
    }

    public DmOResv nbChbAnn(Integer nbChbAnn) {
        this.setNbChbAnn(nbChbAnn);
        return this;
    }

    public void setNbChbAnn(Integer nbChbAnn) {
        this.nbChbAnn = nbChbAnn;
    }

    public Integer getNbChbNoshow() {
        return this.nbChbNoshow;
    }

    public DmOResv nbChbNoshow(Integer nbChbNoshow) {
        this.setNbChbNoshow(nbChbNoshow);
        return this;
    }

    public void setNbChbNoshow(Integer nbChbNoshow) {
        this.nbChbNoshow = nbChbNoshow;
    }

    public Long getRevenuNetChambre() {
        return this.revenuNetChambre;
    }

    public DmOResv revenuNetChambre(Long revenuNetChambre) {
        this.setRevenuNetChambre(revenuNetChambre);
        return this;
    }

    public void setRevenuNetChambre(Long revenuNetChambre) {
        this.revenuNetChambre = revenuNetChambre;
    }

    public Long getRevenuTaxeChambre() {
        return this.revenuTaxeChambre;
    }

    public DmOResv revenuTaxeChambre(Long revenuTaxeChambre) {
        this.setRevenuTaxeChambre(revenuTaxeChambre);
        return this;
    }

    public void setRevenuTaxeChambre(Long revenuTaxeChambre) {
        this.revenuTaxeChambre = revenuTaxeChambre;
    }

    public Long getRevenuNetChambreGlobal() {
        return this.revenuNetChambreGlobal;
    }

    public DmOResv revenuNetChambreGlobal(Long revenuNetChambreGlobal) {
        this.setRevenuNetChambreGlobal(revenuNetChambreGlobal);
        return this;
    }

    public void setRevenuNetChambreGlobal(Long revenuNetChambreGlobal) {
        this.revenuNetChambreGlobal = revenuNetChambreGlobal;
    }

    public Long getRevenuTaxeChambreGlobal() {
        return this.revenuTaxeChambreGlobal;
    }

    public DmOResv revenuTaxeChambreGlobal(Long revenuTaxeChambreGlobal) {
        this.setRevenuTaxeChambreGlobal(revenuTaxeChambreGlobal);
        return this;
    }

    public void setRevenuTaxeChambreGlobal(Long revenuTaxeChambreGlobal) {
        this.revenuTaxeChambreGlobal = revenuTaxeChambreGlobal;
    }

    public Long getRevenuNetBq() {
        return this.revenuNetBq;
    }

    public DmOResv revenuNetBq(Long revenuNetBq) {
        this.setRevenuNetBq(revenuNetBq);
        return this;
    }

    public void setRevenuNetBq(Long revenuNetBq) {
        this.revenuNetBq = revenuNetBq;
    }

    public Long getRevenuTaxeBq() {
        return this.revenuTaxeBq;
    }

    public DmOResv revenuTaxeBq(Long revenuTaxeBq) {
        this.setRevenuTaxeBq(revenuTaxeBq);
        return this;
    }

    public void setRevenuTaxeBq(Long revenuTaxeBq) {
        this.revenuTaxeBq = revenuTaxeBq;
    }

    public Long getRevenuNetBqGlobal() {
        return this.revenuNetBqGlobal;
    }

    public DmOResv revenuNetBqGlobal(Long revenuNetBqGlobal) {
        this.setRevenuNetBqGlobal(revenuNetBqGlobal);
        return this;
    }

    public void setRevenuNetBqGlobal(Long revenuNetBqGlobal) {
        this.revenuNetBqGlobal = revenuNetBqGlobal;
    }

    public Long getRevenuTaxeBqGlobal() {
        return this.revenuTaxeBqGlobal;
    }

    public DmOResv revenuTaxeBqGlobal(Long revenuTaxeBqGlobal) {
        this.setRevenuTaxeBqGlobal(revenuTaxeBqGlobal);
        return this;
    }

    public void setRevenuTaxeBqGlobal(Long revenuTaxeBqGlobal) {
        this.revenuTaxeBqGlobal = revenuTaxeBqGlobal;
    }

    public Long getRevenuNetExtra() {
        return this.revenuNetExtra;
    }

    public DmOResv revenuNetExtra(Long revenuNetExtra) {
        this.setRevenuNetExtra(revenuNetExtra);
        return this;
    }

    public void setRevenuNetExtra(Long revenuNetExtra) {
        this.revenuNetExtra = revenuNetExtra;
    }

    public Long getRevenuTaxeExtra() {
        return this.revenuTaxeExtra;
    }

    public DmOResv revenuTaxeExtra(Long revenuTaxeExtra) {
        this.setRevenuTaxeExtra(revenuTaxeExtra);
        return this;
    }

    public void setRevenuTaxeExtra(Long revenuTaxeExtra) {
        this.revenuTaxeExtra = revenuTaxeExtra;
    }

    public Long getRevenuNetExtraGlobal() {
        return this.revenuNetExtraGlobal;
    }

    public DmOResv revenuNetExtraGlobal(Long revenuNetExtraGlobal) {
        this.setRevenuNetExtraGlobal(revenuNetExtraGlobal);
        return this;
    }

    public void setRevenuNetExtraGlobal(Long revenuNetExtraGlobal) {
        this.revenuNetExtraGlobal = revenuNetExtraGlobal;
    }

    public Long getRevenuTaxeExtraGlobal() {
        return this.revenuTaxeExtraGlobal;
    }

    public DmOResv revenuTaxeExtraGlobal(Long revenuTaxeExtraGlobal) {
        this.setRevenuTaxeExtraGlobal(revenuTaxeExtraGlobal);
        return this;
    }

    public void setRevenuTaxeExtraGlobal(Long revenuTaxeExtraGlobal) {
        this.revenuTaxeExtraGlobal = revenuTaxeExtraGlobal;
    }

    public Long getRevenuNetTotal() {
        return this.revenuNetTotal;
    }

    public DmOResv revenuNetTotal(Long revenuNetTotal) {
        this.setRevenuNetTotal(revenuNetTotal);
        return this;
    }

    public void setRevenuNetTotal(Long revenuNetTotal) {
        this.revenuNetTotal = revenuNetTotal;
    }

    public Long getRevenuTaxeTotal() {
        return this.revenuTaxeTotal;
    }

    public DmOResv revenuTaxeTotal(Long revenuTaxeTotal) {
        this.setRevenuTaxeTotal(revenuTaxeTotal);
        return this;
    }

    public void setRevenuTaxeTotal(Long revenuTaxeTotal) {
        this.revenuTaxeTotal = revenuTaxeTotal;
    }

    public Long getRevenuNetTotalGlobal() {
        return this.revenuNetTotalGlobal;
    }

    public DmOResv revenuNetTotalGlobal(Long revenuNetTotalGlobal) {
        this.setRevenuNetTotalGlobal(revenuNetTotalGlobal);
        return this;
    }

    public void setRevenuNetTotalGlobal(Long revenuNetTotalGlobal) {
        this.revenuNetTotalGlobal = revenuNetTotalGlobal;
    }

    public Long getRevenuTaxeTotalGlobal() {
        return this.revenuTaxeTotalGlobal;
    }

    public DmOResv revenuTaxeTotalGlobal(Long revenuTaxeTotalGlobal) {
        this.setRevenuTaxeTotalGlobal(revenuTaxeTotalGlobal);
        return this;
    }

    public void setRevenuTaxeTotalGlobal(Long revenuTaxeTotalGlobal) {
        this.revenuTaxeTotalGlobal = revenuTaxeTotalGlobal;
    }

    public Long getProdRevenuChambre() {
        return this.prodRevenuChambre;
    }

    public DmOResv prodRevenuChambre(Long prodRevenuChambre) {
        this.setProdRevenuChambre(prodRevenuChambre);
        return this;
    }

    public void setProdRevenuChambre(Long prodRevenuChambre) {
        this.prodRevenuChambre = prodRevenuChambre;
    }

    public Long getProdRevenuBq() {
        return this.prodRevenuBq;
    }

    public DmOResv prodRevenuBq(Long prodRevenuBq) {
        this.setProdRevenuBq(prodRevenuBq);
        return this;
    }

    public void setProdRevenuBq(Long prodRevenuBq) {
        this.prodRevenuBq = prodRevenuBq;
    }

    public Long getProdRevenuExtra() {
        return this.prodRevenuExtra;
    }

    public DmOResv prodRevenuExtra(Long prodRevenuExtra) {
        this.setProdRevenuExtra(prodRevenuExtra);
        return this;
    }

    public void setProdRevenuExtra(Long prodRevenuExtra) {
        this.prodRevenuExtra = prodRevenuExtra;
    }

    public Long getProdRevenuTotal() {
        return this.prodRevenuTotal;
    }

    public DmOResv prodRevenuTotal(Long prodRevenuTotal) {
        this.setProdRevenuTotal(prodRevenuTotal);
        return this;
    }

    public void setProdRevenuTotal(Long prodRevenuTotal) {
        this.prodRevenuTotal = prodRevenuTotal;
    }

    public Long getProdChambreNbNuitees() {
        return this.prodChambreNbNuitees;
    }

    public DmOResv prodChambreNbNuitees(Long prodChambreNbNuitees) {
        this.setProdChambreNbNuitees(prodChambreNbNuitees);
        return this;
    }

    public void setProdChambreNbNuitees(Long prodChambreNbNuitees) {
        this.prodChambreNbNuitees = prodChambreNbNuitees;
    }

    public LocalDate getTechCreateDate() {
        return this.techCreateDate;
    }

    public DmOResv techCreateDate(LocalDate techCreateDate) {
        this.setTechCreateDate(techCreateDate);
        return this;
    }

    public void setTechCreateDate(LocalDate techCreateDate) {
        this.techCreateDate = techCreateDate;
    }

    public LocalDate getTechUpdateDate() {
        return this.techUpdateDate;
    }

    public DmOResv techUpdateDate(LocalDate techUpdateDate) {
        this.setTechUpdateDate(techUpdateDate);
        return this;
    }

    public void setTechUpdateDate(LocalDate techUpdateDate) {
        this.techUpdateDate = techUpdateDate;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DmOResv)) {
            return false;
        }
        return getId() != null && getId().equals(((DmOResv) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmOResv{" +
            "id=" + getId() +
            ", numLigne=" + getNumLigne() +
            ", resort='" + getResort() + "'" +
            ", resvNameId=" + getResvNameId() +
            ", clientOId='" + getClientOId() + "'" +
            ", typeChb='" + getTypeChb() + "'" +
            ", confirmationNo='" + getConfirmationNo() + "'" +
            ", clientMdmId='" + getClientMdmId() + "'" +
            ", nameId=" + getNameId() +
            ", parentResvNameId=" + getParentResvNameId() +
            ", contactId=" + getContactId() +
            ", agenceId=" + getAgenceId() +
            ", agenceNom='" + getAgenceNom() + "'" +
            ", societeId=" + getSocieteId() +
            ", groupeId=" + getGroupeId() +
            ", numBloc=" + getNumBloc() +
            ", typeResv='" + getTypeResv() + "'" +
            ", statutResv='" + getStatutResv() + "'" +
            ", dateDebutResv='" + getDateDebutResv() + "'" +
            ", dateFinResv='" + getDateFinResv() + "'" +
            ", truncDateDebutResv='" + getTruncDateDebutResv() + "'" +
            ", truncDateFinResv='" + getTruncDateFinResv() + "'" +
            ", dateAnnResv='" + getDateAnnResv() + "'" +
            ", pseudoRoomYn='" + getPseudoRoomYn() + "'" +
            ", createurResv=" + getCreateurResv() +
            ", nomCreateurResv='" + getNomCreateurResv() + "'" +
            ", codeGarantie='" + getCodeGarantie() + "'" +
            ", flgDed='" + getFlgDed() + "'" +
            ", codePays='" + getCodePays() + "'" +
            ", libPays='" + getLibPays() + "'" +
            ", codeNationalite='" + getCodeNationalite() + "'" +
            ", libNationalite='" + getLibNationalite() + "'" +
            ", codeSource='" + getCodeSource() + "'" +
            ", libSource='" + getLibSource() + "'" +
            ", codeGrandSource='" + getCodeGrandSource() + "'" +
            ", codeOrigine='" + getCodeOrigine() + "'" +
            ", libOrigine='" + getLibOrigine() + "'" +
            ", codeMarche='" + getCodeMarche() + "'" +
            ", libMarche='" + getLibMarche() + "'" +
            ", codeGrandMarche='" + getCodeGrandMarche() + "'" +
            ", libGrandMarche='" + getLibGrandMarche() + "'" +
            ", codePrix='" + getCodePrix() + "'" +
            ", categPrix='" + getCategPrix() + "'" +
            ", libPrix='" + getLibPrix() + "'" +
            ", numChb='" + getNumChb() + "'" +
            ", descriptionTypeChb='" + getDescriptionTypeChb() + "'" +
            ", codeTypeChb='" + getCodeTypeChb() + "'" +
            ", classChb='" + getClassChb() + "'" +
            ", caractChb='" + getCaractChb() + "'" +
            ", typeChbDeReservation='" + getTypeChbDeReservation() + "'" +
            ", descriptionTypeChbDeResv='" + getDescriptionTypeChbDeResv() + "'" +
            ", codeTypeChbDeResv='" + getCodeTypeChbDeResv() + "'" +
            ", statutDeReservation='" + getStatutDeReservation() + "'" +
            ", circuitDistribution='" + getCircuitDistribution() + "'" +
            ", circuitDistribUserRegroup='" + getCircuitDistribUserRegroup() + "'" +
            ", numCrs='" + getNumCrs() + "'" +
            ", typeRefCrs='" + getTypeRefCrs() + "'" +
            ", crsInsertDate='" + getCrsInsertDate() + "'" +
            ", dateCreaResv='" + getDateCreaResv() + "'" +
            ", datePremier='" + getDatePremier() + "'" +
            ", statutPremier='" + getStatutPremier() + "'" +
            ", dateDernier='" + getDateDernier() + "'" +
            ", statutDernier='" + getStatutDernier() + "'" +
            ", dateDernierPseudo='" + getDateDernierPseudo() + "'" +
            ", statutDernierPseudo='" + getStatutDernierPseudo() + "'" +
            ", diffDtCreaAnn=" + getDiffDtCreaAnn() +
            ", diffDtArrAnn=" + getDiffDtArrAnn() +
            ", leadtime=" + getLeadtime() +
            ", los=" + getLos() +
            ", occupantsGroupe='" + getOccupantsGroupe() + "'" +
            ", nbNuitee=" + getNbNuitee() +
            ", nbNuiteeNnDed=" + getNbNuiteeNnDed() +
            ", nbResvAnn=" + getNbResvAnn() +
            ", nbAdu=" + getNbAdu() +
            ", nbEnf=" + getNbEnf() +
            ", nbPersDayU=" + getNbPersDayU() +
            ", nbPersArr=" + getNbPersArr() +
            ", nbPersDep=" + getNbPersDep() +
            ", nbPersAnn=" + getNbPersAnn() +
            ", nbPersNoshow=" + getNbPersNoshow() +
            ", nbChbDayU=" + getNbChbDayU() +
            ", nbChbArr=" + getNbChbArr() +
            ", nbChbDep=" + getNbChbDep() +
            ", nbChbAnn=" + getNbChbAnn() +
            ", nbChbNoshow=" + getNbChbNoshow() +
            ", revenuNetChambre=" + getRevenuNetChambre() +
            ", revenuTaxeChambre=" + getRevenuTaxeChambre() +
            ", revenuNetChambreGlobal=" + getRevenuNetChambreGlobal() +
            ", revenuTaxeChambreGlobal=" + getRevenuTaxeChambreGlobal() +
            ", revenuNetBq=" + getRevenuNetBq() +
            ", revenuTaxeBq=" + getRevenuTaxeBq() +
            ", revenuNetBqGlobal=" + getRevenuNetBqGlobal() +
            ", revenuTaxeBqGlobal=" + getRevenuTaxeBqGlobal() +
            ", revenuNetExtra=" + getRevenuNetExtra() +
            ", revenuTaxeExtra=" + getRevenuTaxeExtra() +
            ", revenuNetExtraGlobal=" + getRevenuNetExtraGlobal() +
            ", revenuTaxeExtraGlobal=" + getRevenuTaxeExtraGlobal() +
            ", revenuNetTotal=" + getRevenuNetTotal() +
            ", revenuTaxeTotal=" + getRevenuTaxeTotal() +
            ", revenuNetTotalGlobal=" + getRevenuNetTotalGlobal() +
            ", revenuTaxeTotalGlobal=" + getRevenuTaxeTotalGlobal() +
            ", prodRevenuChambre=" + getProdRevenuChambre() +
            ", prodRevenuBq=" + getProdRevenuBq() +
            ", prodRevenuExtra=" + getProdRevenuExtra() +
            ", prodRevenuTotal=" + getProdRevenuTotal() +
            ", prodChambreNbNuitees=" + getProdChambreNbNuitees() +
            ", techCreateDate='" + getTechCreateDate() + "'" +
            ", techUpdateDate='" + getTechUpdateDate() + "'" +
            "}";
    }
}

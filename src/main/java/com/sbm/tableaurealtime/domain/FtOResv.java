package com.sbm.tableaurealtime.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A FtOResv.
 */
@Entity
@Table(name = "ft_o_resv")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class FtOResv implements Serializable {

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

    @Column(name = "business_date")
    private LocalDate businessDate;

    @Column(name = "num_ordre")
    private Integer numOrdre;

    @Column(name = "confirmation_no")
    private String confirmationNo;

    @Column(name = "client_mdm_id")
    private String clientMdmId;

    @Column(name = "name_id")
    private Integer nameId;

    @Column(name = "name_id_ligne")
    private Integer nameIdLigne;

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

    @Column(name = "membre_id")
    private Integer membreId;

    @Column(name = "source_profile_id")
    private Integer sourceProfileId;

    @Column(name = "num_bloc")
    private Integer numBloc;

    @Column(name = "statut_resv")
    private String statutResv;

    @Column(name = "statut_vip")
    private String statutVip;

    @Column(name = "date_debut_ligne")
    private LocalDate dateDebutLigne;

    @Column(name = "date_fin_ligne")
    private LocalDate dateFinLigne;

    @Column(name = "date_fin_origine")
    private LocalDate dateFinOrigine;

    @Column(name = "date_ann")
    private LocalDate dateAnn;

    @Column(name = "pseudo_room_yn")
    private String pseudoRoomYn;

    @Column(name = "complementaire_yn")
    private String complementaireYn;

    @Column(name = "interne_yn")
    private String interneYn;

    @Column(name = "walkin_yn")
    private String walkinYn;

    @Column(name = "createur_resv")
    private Integer createurResv;

    @Column(name = "nom_createur_resv")
    private String nomCreateurResv;

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

    @Column(name = "type_chb_ligne")
    private String typeChbLigne;

    @Column(name = "description_type_chb")
    private String descriptionTypeChb;

    @Column(name = "code_type_chb")
    private String codeTypeChb;

    @Column(name = "class_chb")
    private String classChb;

    @Column(name = "statut_chb_resv")
    private String statutChbResv;

    @Column(name = "type_chb_de_reservation")
    private String typeChbDeReservation;

    @Column(name = "description_type_chb_de_resv")
    private String descriptionTypeChbDeResv;

    @Column(name = "code_type_chb_de_resv")
    private String codeTypeChbDeResv;

    @Column(name = "circuit_distribution")
    private String circuitDistribution;

    @Column(name = "circuit_distrib_user_regroup")
    private String circuitDistribUserRegroup;

    @Column(name = "nb_resv_ann")
    private Integer nbResvAnn;

    @Column(name = "nb_nuitee")
    private Integer nbNuitee;

    @Column(name = "nb_nuitee_nn_ded")
    private Integer nbNuiteeNnDed;

    @Column(name = "nb_nuitee_global")
    private Integer nbNuiteeGlobal;

    @Column(name = "nb_occupation_multiple")
    private Integer nbOccupationMultiple;

    @Column(name = "nb_adu_global")
    private Integer nbAduGlobal;

    @Column(name = "nb_enf_global")
    private Integer nbEnfGlobal;

    @Column(name = "nb_pers_day_u_global")
    private Integer nbPersDayUGlobal;

    @Column(name = "nb_pers_arr_global")
    private Integer nbPersArrGlobal;

    @Column(name = "nb_pers_dep_global")
    private Integer nbPersDepGlobal;

    @Column(name = "nb_pers_ann")
    private Integer nbPersAnn;

    @Column(name = "nb_pers_noshow")
    private Integer nbPersNoshow;

    @Column(name = "nb_chb_day_u_global")
    private Integer nbChbDayUGlobal;

    @Column(name = "nb_chb_arr_global")
    private Integer nbChbArrGlobal;

    @Column(name = "nb_chb_dep_global")
    private Integer nbChbDepGlobal;

    @Column(name = "nb_chb_ann")
    private Integer nbChbAnn;

    @Column(name = "nb_chb_noshow")
    private Integer nbChbNoshow;

    @Column(name = "revenu_net_chambre_global")
    private Long revenuNetChambreGlobal;

    @Column(name = "revenu_taxe_chambre_global")
    private Long revenuTaxeChambreGlobal;

    @Column(name = "revenu_net_bq_global")
    private Long revenuNetBqGlobal;

    @Column(name = "revenu_taxe_bq_global")
    private Long revenuTaxeBqGlobal;

    @Column(name = "revenu_net_extra_global")
    private Long revenuNetExtraGlobal;

    @Column(name = "revenu_taxe_extra_global")
    private Long revenuTaxeExtraGlobal;

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

    @Column(name = "dates_sejour_rens_yn")
    private String datesSejourRensYn;

    @Column(name = "tech_event_type")
    private String techEventType;

    @Column(name = "tech_resv_inv_type")
    private String techResvInvType;

    @Column(name = "tech_origine")
    private String techOrigine;

    @Column(name = "tech_grp_num_ordre")
    private Integer techGrpNumOrdre;

    @Column(name = "tech_create_date")
    private LocalDate techCreateDate;

    @Column(name = "tech_update_date")
    private LocalDate techUpdateDate;

    @Column(name = "resv_name_id_principal")
    private Integer resvNameIdPrincipal;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public FtOResv id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumLigne() {
        return this.numLigne;
    }

    public FtOResv numLigne(Integer numLigne) {
        this.setNumLigne(numLigne);
        return this;
    }

    public void setNumLigne(Integer numLigne) {
        this.numLigne = numLigne;
    }

    public String getResort() {
        return this.resort;
    }

    public FtOResv resort(String resort) {
        this.setResort(resort);
        return this;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public Integer getResvNameId() {
        return this.resvNameId;
    }

    public FtOResv resvNameId(Integer resvNameId) {
        this.setResvNameId(resvNameId);
        return this;
    }

    public void setResvNameId(Integer resvNameId) {
        this.resvNameId = resvNameId;
    }

    public String getClientOId() {
        return this.clientOId;
    }

    public FtOResv clientOId(String clientOId) {
        this.setClientOId(clientOId);
        return this;
    }

    public void setClientOId(String clientOId) {
        this.clientOId = clientOId;
    }

    public String getTypeChb() {
        return this.typeChb;
    }

    public FtOResv typeChb(String typeChb) {
        this.setTypeChb(typeChb);
        return this;
    }

    public void setTypeChb(String typeChb) {
        this.typeChb = typeChb;
    }

    public LocalDate getBusinessDate() {
        return this.businessDate;
    }

    public FtOResv businessDate(LocalDate businessDate) {
        this.setBusinessDate(businessDate);
        return this;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public Integer getNumOrdre() {
        return this.numOrdre;
    }

    public FtOResv numOrdre(Integer numOrdre) {
        this.setNumOrdre(numOrdre);
        return this;
    }

    public void setNumOrdre(Integer numOrdre) {
        this.numOrdre = numOrdre;
    }

    public String getConfirmationNo() {
        return this.confirmationNo;
    }

    public FtOResv confirmationNo(String confirmationNo) {
        this.setConfirmationNo(confirmationNo);
        return this;
    }

    public void setConfirmationNo(String confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    public String getClientMdmId() {
        return this.clientMdmId;
    }

    public FtOResv clientMdmId(String clientMdmId) {
        this.setClientMdmId(clientMdmId);
        return this;
    }

    public void setClientMdmId(String clientMdmId) {
        this.clientMdmId = clientMdmId;
    }

    public Integer getNameId() {
        return this.nameId;
    }

    public FtOResv nameId(Integer nameId) {
        this.setNameId(nameId);
        return this;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public Integer getNameIdLigne() {
        return this.nameIdLigne;
    }

    public FtOResv nameIdLigne(Integer nameIdLigne) {
        this.setNameIdLigne(nameIdLigne);
        return this;
    }

    public void setNameIdLigne(Integer nameIdLigne) {
        this.nameIdLigne = nameIdLigne;
    }

    public Integer getContactId() {
        return this.contactId;
    }

    public FtOResv contactId(Integer contactId) {
        this.setContactId(contactId);
        return this;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getAgenceId() {
        return this.agenceId;
    }

    public FtOResv agenceId(Integer agenceId) {
        this.setAgenceId(agenceId);
        return this;
    }

    public void setAgenceId(Integer agenceId) {
        this.agenceId = agenceId;
    }

    public String getAgenceNom() {
        return this.agenceNom;
    }

    public FtOResv agenceNom(String agenceNom) {
        this.setAgenceNom(agenceNom);
        return this;
    }

    public void setAgenceNom(String agenceNom) {
        this.agenceNom = agenceNom;
    }

    public Integer getSocieteId() {
        return this.societeId;
    }

    public FtOResv societeId(Integer societeId) {
        this.setSocieteId(societeId);
        return this;
    }

    public void setSocieteId(Integer societeId) {
        this.societeId = societeId;
    }

    public Integer getGroupeId() {
        return this.groupeId;
    }

    public FtOResv groupeId(Integer groupeId) {
        this.setGroupeId(groupeId);
        return this;
    }

    public void setGroupeId(Integer groupeId) {
        this.groupeId = groupeId;
    }

    public Integer getMembreId() {
        return this.membreId;
    }

    public FtOResv membreId(Integer membreId) {
        this.setMembreId(membreId);
        return this;
    }

    public void setMembreId(Integer membreId) {
        this.membreId = membreId;
    }

    public Integer getSourceProfileId() {
        return this.sourceProfileId;
    }

    public FtOResv sourceProfileId(Integer sourceProfileId) {
        this.setSourceProfileId(sourceProfileId);
        return this;
    }

    public void setSourceProfileId(Integer sourceProfileId) {
        this.sourceProfileId = sourceProfileId;
    }

    public Integer getNumBloc() {
        return this.numBloc;
    }

    public FtOResv numBloc(Integer numBloc) {
        this.setNumBloc(numBloc);
        return this;
    }

    public void setNumBloc(Integer numBloc) {
        this.numBloc = numBloc;
    }

    public String getStatutResv() {
        return this.statutResv;
    }

    public FtOResv statutResv(String statutResv) {
        this.setStatutResv(statutResv);
        return this;
    }

    public void setStatutResv(String statutResv) {
        this.statutResv = statutResv;
    }

    public String getStatutVip() {
        return this.statutVip;
    }

    public FtOResv statutVip(String statutVip) {
        this.setStatutVip(statutVip);
        return this;
    }

    public void setStatutVip(String statutVip) {
        this.statutVip = statutVip;
    }

    public LocalDate getDateDebutLigne() {
        return this.dateDebutLigne;
    }

    public FtOResv dateDebutLigne(LocalDate dateDebutLigne) {
        this.setDateDebutLigne(dateDebutLigne);
        return this;
    }

    public void setDateDebutLigne(LocalDate dateDebutLigne) {
        this.dateDebutLigne = dateDebutLigne;
    }

    public LocalDate getDateFinLigne() {
        return this.dateFinLigne;
    }

    public FtOResv dateFinLigne(LocalDate dateFinLigne) {
        this.setDateFinLigne(dateFinLigne);
        return this;
    }

    public void setDateFinLigne(LocalDate dateFinLigne) {
        this.dateFinLigne = dateFinLigne;
    }

    public LocalDate getDateFinOrigine() {
        return this.dateFinOrigine;
    }

    public FtOResv dateFinOrigine(LocalDate dateFinOrigine) {
        this.setDateFinOrigine(dateFinOrigine);
        return this;
    }

    public void setDateFinOrigine(LocalDate dateFinOrigine) {
        this.dateFinOrigine = dateFinOrigine;
    }

    public LocalDate getDateAnn() {
        return this.dateAnn;
    }

    public FtOResv dateAnn(LocalDate dateAnn) {
        this.setDateAnn(dateAnn);
        return this;
    }

    public void setDateAnn(LocalDate dateAnn) {
        this.dateAnn = dateAnn;
    }

    public String getPseudoRoomYn() {
        return this.pseudoRoomYn;
    }

    public FtOResv pseudoRoomYn(String pseudoRoomYn) {
        this.setPseudoRoomYn(pseudoRoomYn);
        return this;
    }

    public void setPseudoRoomYn(String pseudoRoomYn) {
        this.pseudoRoomYn = pseudoRoomYn;
    }

    public String getComplementaireYn() {
        return this.complementaireYn;
    }

    public FtOResv complementaireYn(String complementaireYn) {
        this.setComplementaireYn(complementaireYn);
        return this;
    }

    public void setComplementaireYn(String complementaireYn) {
        this.complementaireYn = complementaireYn;
    }

    public String getInterneYn() {
        return this.interneYn;
    }

    public FtOResv interneYn(String interneYn) {
        this.setInterneYn(interneYn);
        return this;
    }

    public void setInterneYn(String interneYn) {
        this.interneYn = interneYn;
    }

    public String getWalkinYn() {
        return this.walkinYn;
    }

    public FtOResv walkinYn(String walkinYn) {
        this.setWalkinYn(walkinYn);
        return this;
    }

    public void setWalkinYn(String walkinYn) {
        this.walkinYn = walkinYn;
    }

    public Integer getCreateurResv() {
        return this.createurResv;
    }

    public FtOResv createurResv(Integer createurResv) {
        this.setCreateurResv(createurResv);
        return this;
    }

    public void setCreateurResv(Integer createurResv) {
        this.createurResv = createurResv;
    }

    public String getNomCreateurResv() {
        return this.nomCreateurResv;
    }

    public FtOResv nomCreateurResv(String nomCreateurResv) {
        this.setNomCreateurResv(nomCreateurResv);
        return this;
    }

    public void setNomCreateurResv(String nomCreateurResv) {
        this.nomCreateurResv = nomCreateurResv;
    }

    public String getCodePays() {
        return this.codePays;
    }

    public FtOResv codePays(String codePays) {
        this.setCodePays(codePays);
        return this;
    }

    public void setCodePays(String codePays) {
        this.codePays = codePays;
    }

    public String getLibPays() {
        return this.libPays;
    }

    public FtOResv libPays(String libPays) {
        this.setLibPays(libPays);
        return this;
    }

    public void setLibPays(String libPays) {
        this.libPays = libPays;
    }

    public String getCodeNationalite() {
        return this.codeNationalite;
    }

    public FtOResv codeNationalite(String codeNationalite) {
        this.setCodeNationalite(codeNationalite);
        return this;
    }

    public void setCodeNationalite(String codeNationalite) {
        this.codeNationalite = codeNationalite;
    }

    public String getLibNationalite() {
        return this.libNationalite;
    }

    public FtOResv libNationalite(String libNationalite) {
        this.setLibNationalite(libNationalite);
        return this;
    }

    public void setLibNationalite(String libNationalite) {
        this.libNationalite = libNationalite;
    }

    public String getCodeSource() {
        return this.codeSource;
    }

    public FtOResv codeSource(String codeSource) {
        this.setCodeSource(codeSource);
        return this;
    }

    public void setCodeSource(String codeSource) {
        this.codeSource = codeSource;
    }

    public String getLibSource() {
        return this.libSource;
    }

    public FtOResv libSource(String libSource) {
        this.setLibSource(libSource);
        return this;
    }

    public void setLibSource(String libSource) {
        this.libSource = libSource;
    }

    public String getCodeGrandSource() {
        return this.codeGrandSource;
    }

    public FtOResv codeGrandSource(String codeGrandSource) {
        this.setCodeGrandSource(codeGrandSource);
        return this;
    }

    public void setCodeGrandSource(String codeGrandSource) {
        this.codeGrandSource = codeGrandSource;
    }

    public String getCodeOrigine() {
        return this.codeOrigine;
    }

    public FtOResv codeOrigine(String codeOrigine) {
        this.setCodeOrigine(codeOrigine);
        return this;
    }

    public void setCodeOrigine(String codeOrigine) {
        this.codeOrigine = codeOrigine;
    }

    public String getLibOrigine() {
        return this.libOrigine;
    }

    public FtOResv libOrigine(String libOrigine) {
        this.setLibOrigine(libOrigine);
        return this;
    }

    public void setLibOrigine(String libOrigine) {
        this.libOrigine = libOrigine;
    }

    public String getCodeMarche() {
        return this.codeMarche;
    }

    public FtOResv codeMarche(String codeMarche) {
        this.setCodeMarche(codeMarche);
        return this;
    }

    public void setCodeMarche(String codeMarche) {
        this.codeMarche = codeMarche;
    }

    public String getLibMarche() {
        return this.libMarche;
    }

    public FtOResv libMarche(String libMarche) {
        this.setLibMarche(libMarche);
        return this;
    }

    public void setLibMarche(String libMarche) {
        this.libMarche = libMarche;
    }

    public String getCodeGrandMarche() {
        return this.codeGrandMarche;
    }

    public FtOResv codeGrandMarche(String codeGrandMarche) {
        this.setCodeGrandMarche(codeGrandMarche);
        return this;
    }

    public void setCodeGrandMarche(String codeGrandMarche) {
        this.codeGrandMarche = codeGrandMarche;
    }

    public String getLibGrandMarche() {
        return this.libGrandMarche;
    }

    public FtOResv libGrandMarche(String libGrandMarche) {
        this.setLibGrandMarche(libGrandMarche);
        return this;
    }

    public void setLibGrandMarche(String libGrandMarche) {
        this.libGrandMarche = libGrandMarche;
    }

    public String getCodePrix() {
        return this.codePrix;
    }

    public FtOResv codePrix(String codePrix) {
        this.setCodePrix(codePrix);
        return this;
    }

    public void setCodePrix(String codePrix) {
        this.codePrix = codePrix;
    }

    public String getCategPrix() {
        return this.categPrix;
    }

    public FtOResv categPrix(String categPrix) {
        this.setCategPrix(categPrix);
        return this;
    }

    public void setCategPrix(String categPrix) {
        this.categPrix = categPrix;
    }

    public String getLibPrix() {
        return this.libPrix;
    }

    public FtOResv libPrix(String libPrix) {
        this.setLibPrix(libPrix);
        return this;
    }

    public void setLibPrix(String libPrix) {
        this.libPrix = libPrix;
    }

    public String getNumChb() {
        return this.numChb;
    }

    public FtOResv numChb(String numChb) {
        this.setNumChb(numChb);
        return this;
    }

    public void setNumChb(String numChb) {
        this.numChb = numChb;
    }

    public String getTypeChbLigne() {
        return this.typeChbLigne;
    }

    public FtOResv typeChbLigne(String typeChbLigne) {
        this.setTypeChbLigne(typeChbLigne);
        return this;
    }

    public void setTypeChbLigne(String typeChbLigne) {
        this.typeChbLigne = typeChbLigne;
    }

    public String getDescriptionTypeChb() {
        return this.descriptionTypeChb;
    }

    public FtOResv descriptionTypeChb(String descriptionTypeChb) {
        this.setDescriptionTypeChb(descriptionTypeChb);
        return this;
    }

    public void setDescriptionTypeChb(String descriptionTypeChb) {
        this.descriptionTypeChb = descriptionTypeChb;
    }

    public String getCodeTypeChb() {
        return this.codeTypeChb;
    }

    public FtOResv codeTypeChb(String codeTypeChb) {
        this.setCodeTypeChb(codeTypeChb);
        return this;
    }

    public void setCodeTypeChb(String codeTypeChb) {
        this.codeTypeChb = codeTypeChb;
    }

    public String getClassChb() {
        return this.classChb;
    }

    public FtOResv classChb(String classChb) {
        this.setClassChb(classChb);
        return this;
    }

    public void setClassChb(String classChb) {
        this.classChb = classChb;
    }

    public String getStatutChbResv() {
        return this.statutChbResv;
    }

    public FtOResv statutChbResv(String statutChbResv) {
        this.setStatutChbResv(statutChbResv);
        return this;
    }

    public void setStatutChbResv(String statutChbResv) {
        this.statutChbResv = statutChbResv;
    }

    public String getTypeChbDeReservation() {
        return this.typeChbDeReservation;
    }

    public FtOResv typeChbDeReservation(String typeChbDeReservation) {
        this.setTypeChbDeReservation(typeChbDeReservation);
        return this;
    }

    public void setTypeChbDeReservation(String typeChbDeReservation) {
        this.typeChbDeReservation = typeChbDeReservation;
    }

    public String getDescriptionTypeChbDeResv() {
        return this.descriptionTypeChbDeResv;
    }

    public FtOResv descriptionTypeChbDeResv(String descriptionTypeChbDeResv) {
        this.setDescriptionTypeChbDeResv(descriptionTypeChbDeResv);
        return this;
    }

    public void setDescriptionTypeChbDeResv(String descriptionTypeChbDeResv) {
        this.descriptionTypeChbDeResv = descriptionTypeChbDeResv;
    }

    public String getCodeTypeChbDeResv() {
        return this.codeTypeChbDeResv;
    }

    public FtOResv codeTypeChbDeResv(String codeTypeChbDeResv) {
        this.setCodeTypeChbDeResv(codeTypeChbDeResv);
        return this;
    }

    public void setCodeTypeChbDeResv(String codeTypeChbDeResv) {
        this.codeTypeChbDeResv = codeTypeChbDeResv;
    }

    public String getCircuitDistribution() {
        return this.circuitDistribution;
    }

    public FtOResv circuitDistribution(String circuitDistribution) {
        this.setCircuitDistribution(circuitDistribution);
        return this;
    }

    public void setCircuitDistribution(String circuitDistribution) {
        this.circuitDistribution = circuitDistribution;
    }

    public String getCircuitDistribUserRegroup() {
        return this.circuitDistribUserRegroup;
    }

    public FtOResv circuitDistribUserRegroup(String circuitDistribUserRegroup) {
        this.setCircuitDistribUserRegroup(circuitDistribUserRegroup);
        return this;
    }

    public void setCircuitDistribUserRegroup(String circuitDistribUserRegroup) {
        this.circuitDistribUserRegroup = circuitDistribUserRegroup;
    }

    public Integer getNbResvAnn() {
        return this.nbResvAnn;
    }

    public FtOResv nbResvAnn(Integer nbResvAnn) {
        this.setNbResvAnn(nbResvAnn);
        return this;
    }

    public void setNbResvAnn(Integer nbResvAnn) {
        this.nbResvAnn = nbResvAnn;
    }

    public Integer getNbNuitee() {
        return this.nbNuitee;
    }

    public FtOResv nbNuitee(Integer nbNuitee) {
        this.setNbNuitee(nbNuitee);
        return this;
    }

    public void setNbNuitee(Integer nbNuitee) {
        this.nbNuitee = nbNuitee;
    }

    public Integer getNbNuiteeNnDed() {
        return this.nbNuiteeNnDed;
    }

    public FtOResv nbNuiteeNnDed(Integer nbNuiteeNnDed) {
        this.setNbNuiteeNnDed(nbNuiteeNnDed);
        return this;
    }

    public void setNbNuiteeNnDed(Integer nbNuiteeNnDed) {
        this.nbNuiteeNnDed = nbNuiteeNnDed;
    }

    public Integer getNbNuiteeGlobal() {
        return this.nbNuiteeGlobal;
    }

    public FtOResv nbNuiteeGlobal(Integer nbNuiteeGlobal) {
        this.setNbNuiteeGlobal(nbNuiteeGlobal);
        return this;
    }

    public void setNbNuiteeGlobal(Integer nbNuiteeGlobal) {
        this.nbNuiteeGlobal = nbNuiteeGlobal;
    }

    public Integer getNbOccupationMultiple() {
        return this.nbOccupationMultiple;
    }

    public FtOResv nbOccupationMultiple(Integer nbOccupationMultiple) {
        this.setNbOccupationMultiple(nbOccupationMultiple);
        return this;
    }

    public void setNbOccupationMultiple(Integer nbOccupationMultiple) {
        this.nbOccupationMultiple = nbOccupationMultiple;
    }

    public Integer getNbAduGlobal() {
        return this.nbAduGlobal;
    }

    public FtOResv nbAduGlobal(Integer nbAduGlobal) {
        this.setNbAduGlobal(nbAduGlobal);
        return this;
    }

    public void setNbAduGlobal(Integer nbAduGlobal) {
        this.nbAduGlobal = nbAduGlobal;
    }

    public Integer getNbEnfGlobal() {
        return this.nbEnfGlobal;
    }

    public FtOResv nbEnfGlobal(Integer nbEnfGlobal) {
        this.setNbEnfGlobal(nbEnfGlobal);
        return this;
    }

    public void setNbEnfGlobal(Integer nbEnfGlobal) {
        this.nbEnfGlobal = nbEnfGlobal;
    }

    public Integer getNbPersDayUGlobal() {
        return this.nbPersDayUGlobal;
    }

    public FtOResv nbPersDayUGlobal(Integer nbPersDayUGlobal) {
        this.setNbPersDayUGlobal(nbPersDayUGlobal);
        return this;
    }

    public void setNbPersDayUGlobal(Integer nbPersDayUGlobal) {
        this.nbPersDayUGlobal = nbPersDayUGlobal;
    }

    public Integer getNbPersArrGlobal() {
        return this.nbPersArrGlobal;
    }

    public FtOResv nbPersArrGlobal(Integer nbPersArrGlobal) {
        this.setNbPersArrGlobal(nbPersArrGlobal);
        return this;
    }

    public void setNbPersArrGlobal(Integer nbPersArrGlobal) {
        this.nbPersArrGlobal = nbPersArrGlobal;
    }

    public Integer getNbPersDepGlobal() {
        return this.nbPersDepGlobal;
    }

    public FtOResv nbPersDepGlobal(Integer nbPersDepGlobal) {
        this.setNbPersDepGlobal(nbPersDepGlobal);
        return this;
    }

    public void setNbPersDepGlobal(Integer nbPersDepGlobal) {
        this.nbPersDepGlobal = nbPersDepGlobal;
    }

    public Integer getNbPersAnn() {
        return this.nbPersAnn;
    }

    public FtOResv nbPersAnn(Integer nbPersAnn) {
        this.setNbPersAnn(nbPersAnn);
        return this;
    }

    public void setNbPersAnn(Integer nbPersAnn) {
        this.nbPersAnn = nbPersAnn;
    }

    public Integer getNbPersNoshow() {
        return this.nbPersNoshow;
    }

    public FtOResv nbPersNoshow(Integer nbPersNoshow) {
        this.setNbPersNoshow(nbPersNoshow);
        return this;
    }

    public void setNbPersNoshow(Integer nbPersNoshow) {
        this.nbPersNoshow = nbPersNoshow;
    }

    public Integer getNbChbDayUGlobal() {
        return this.nbChbDayUGlobal;
    }

    public FtOResv nbChbDayUGlobal(Integer nbChbDayUGlobal) {
        this.setNbChbDayUGlobal(nbChbDayUGlobal);
        return this;
    }

    public void setNbChbDayUGlobal(Integer nbChbDayUGlobal) {
        this.nbChbDayUGlobal = nbChbDayUGlobal;
    }

    public Integer getNbChbArrGlobal() {
        return this.nbChbArrGlobal;
    }

    public FtOResv nbChbArrGlobal(Integer nbChbArrGlobal) {
        this.setNbChbArrGlobal(nbChbArrGlobal);
        return this;
    }

    public void setNbChbArrGlobal(Integer nbChbArrGlobal) {
        this.nbChbArrGlobal = nbChbArrGlobal;
    }

    public Integer getNbChbDepGlobal() {
        return this.nbChbDepGlobal;
    }

    public FtOResv nbChbDepGlobal(Integer nbChbDepGlobal) {
        this.setNbChbDepGlobal(nbChbDepGlobal);
        return this;
    }

    public void setNbChbDepGlobal(Integer nbChbDepGlobal) {
        this.nbChbDepGlobal = nbChbDepGlobal;
    }

    public Integer getNbChbAnn() {
        return this.nbChbAnn;
    }

    public FtOResv nbChbAnn(Integer nbChbAnn) {
        this.setNbChbAnn(nbChbAnn);
        return this;
    }

    public void setNbChbAnn(Integer nbChbAnn) {
        this.nbChbAnn = nbChbAnn;
    }

    public Integer getNbChbNoshow() {
        return this.nbChbNoshow;
    }

    public FtOResv nbChbNoshow(Integer nbChbNoshow) {
        this.setNbChbNoshow(nbChbNoshow);
        return this;
    }

    public void setNbChbNoshow(Integer nbChbNoshow) {
        this.nbChbNoshow = nbChbNoshow;
    }

    public Long getRevenuNetChambreGlobal() {
        return this.revenuNetChambreGlobal;
    }

    public FtOResv revenuNetChambreGlobal(Long revenuNetChambreGlobal) {
        this.setRevenuNetChambreGlobal(revenuNetChambreGlobal);
        return this;
    }

    public void setRevenuNetChambreGlobal(Long revenuNetChambreGlobal) {
        this.revenuNetChambreGlobal = revenuNetChambreGlobal;
    }

    public Long getRevenuTaxeChambreGlobal() {
        return this.revenuTaxeChambreGlobal;
    }

    public FtOResv revenuTaxeChambreGlobal(Long revenuTaxeChambreGlobal) {
        this.setRevenuTaxeChambreGlobal(revenuTaxeChambreGlobal);
        return this;
    }

    public void setRevenuTaxeChambreGlobal(Long revenuTaxeChambreGlobal) {
        this.revenuTaxeChambreGlobal = revenuTaxeChambreGlobal;
    }

    public Long getRevenuNetBqGlobal() {
        return this.revenuNetBqGlobal;
    }

    public FtOResv revenuNetBqGlobal(Long revenuNetBqGlobal) {
        this.setRevenuNetBqGlobal(revenuNetBqGlobal);
        return this;
    }

    public void setRevenuNetBqGlobal(Long revenuNetBqGlobal) {
        this.revenuNetBqGlobal = revenuNetBqGlobal;
    }

    public Long getRevenuTaxeBqGlobal() {
        return this.revenuTaxeBqGlobal;
    }

    public FtOResv revenuTaxeBqGlobal(Long revenuTaxeBqGlobal) {
        this.setRevenuTaxeBqGlobal(revenuTaxeBqGlobal);
        return this;
    }

    public void setRevenuTaxeBqGlobal(Long revenuTaxeBqGlobal) {
        this.revenuTaxeBqGlobal = revenuTaxeBqGlobal;
    }

    public Long getRevenuNetExtraGlobal() {
        return this.revenuNetExtraGlobal;
    }

    public FtOResv revenuNetExtraGlobal(Long revenuNetExtraGlobal) {
        this.setRevenuNetExtraGlobal(revenuNetExtraGlobal);
        return this;
    }

    public void setRevenuNetExtraGlobal(Long revenuNetExtraGlobal) {
        this.revenuNetExtraGlobal = revenuNetExtraGlobal;
    }

    public Long getRevenuTaxeExtraGlobal() {
        return this.revenuTaxeExtraGlobal;
    }

    public FtOResv revenuTaxeExtraGlobal(Long revenuTaxeExtraGlobal) {
        this.setRevenuTaxeExtraGlobal(revenuTaxeExtraGlobal);
        return this;
    }

    public void setRevenuTaxeExtraGlobal(Long revenuTaxeExtraGlobal) {
        this.revenuTaxeExtraGlobal = revenuTaxeExtraGlobal;
    }

    public Long getRevenuNetTotalGlobal() {
        return this.revenuNetTotalGlobal;
    }

    public FtOResv revenuNetTotalGlobal(Long revenuNetTotalGlobal) {
        this.setRevenuNetTotalGlobal(revenuNetTotalGlobal);
        return this;
    }

    public void setRevenuNetTotalGlobal(Long revenuNetTotalGlobal) {
        this.revenuNetTotalGlobal = revenuNetTotalGlobal;
    }

    public Long getRevenuTaxeTotalGlobal() {
        return this.revenuTaxeTotalGlobal;
    }

    public FtOResv revenuTaxeTotalGlobal(Long revenuTaxeTotalGlobal) {
        this.setRevenuTaxeTotalGlobal(revenuTaxeTotalGlobal);
        return this;
    }

    public void setRevenuTaxeTotalGlobal(Long revenuTaxeTotalGlobal) {
        this.revenuTaxeTotalGlobal = revenuTaxeTotalGlobal;
    }

    public Long getProdRevenuChambre() {
        return this.prodRevenuChambre;
    }

    public FtOResv prodRevenuChambre(Long prodRevenuChambre) {
        this.setProdRevenuChambre(prodRevenuChambre);
        return this;
    }

    public void setProdRevenuChambre(Long prodRevenuChambre) {
        this.prodRevenuChambre = prodRevenuChambre;
    }

    public Long getProdRevenuBq() {
        return this.prodRevenuBq;
    }

    public FtOResv prodRevenuBq(Long prodRevenuBq) {
        this.setProdRevenuBq(prodRevenuBq);
        return this;
    }

    public void setProdRevenuBq(Long prodRevenuBq) {
        this.prodRevenuBq = prodRevenuBq;
    }

    public Long getProdRevenuExtra() {
        return this.prodRevenuExtra;
    }

    public FtOResv prodRevenuExtra(Long prodRevenuExtra) {
        this.setProdRevenuExtra(prodRevenuExtra);
        return this;
    }

    public void setProdRevenuExtra(Long prodRevenuExtra) {
        this.prodRevenuExtra = prodRevenuExtra;
    }

    public Long getProdRevenuTotal() {
        return this.prodRevenuTotal;
    }

    public FtOResv prodRevenuTotal(Long prodRevenuTotal) {
        this.setProdRevenuTotal(prodRevenuTotal);
        return this;
    }

    public void setProdRevenuTotal(Long prodRevenuTotal) {
        this.prodRevenuTotal = prodRevenuTotal;
    }

    public Long getProdChambreNbNuitees() {
        return this.prodChambreNbNuitees;
    }

    public FtOResv prodChambreNbNuitees(Long prodChambreNbNuitees) {
        this.setProdChambreNbNuitees(prodChambreNbNuitees);
        return this;
    }

    public void setProdChambreNbNuitees(Long prodChambreNbNuitees) {
        this.prodChambreNbNuitees = prodChambreNbNuitees;
    }

    public String getDatesSejourRensYn() {
        return this.datesSejourRensYn;
    }

    public FtOResv datesSejourRensYn(String datesSejourRensYn) {
        this.setDatesSejourRensYn(datesSejourRensYn);
        return this;
    }

    public void setDatesSejourRensYn(String datesSejourRensYn) {
        this.datesSejourRensYn = datesSejourRensYn;
    }

    public String getTechEventType() {
        return this.techEventType;
    }

    public FtOResv techEventType(String techEventType) {
        this.setTechEventType(techEventType);
        return this;
    }

    public void setTechEventType(String techEventType) {
        this.techEventType = techEventType;
    }

    public String getTechResvInvType() {
        return this.techResvInvType;
    }

    public FtOResv techResvInvType(String techResvInvType) {
        this.setTechResvInvType(techResvInvType);
        return this;
    }

    public void setTechResvInvType(String techResvInvType) {
        this.techResvInvType = techResvInvType;
    }

    public String getTechOrigine() {
        return this.techOrigine;
    }

    public FtOResv techOrigine(String techOrigine) {
        this.setTechOrigine(techOrigine);
        return this;
    }

    public void setTechOrigine(String techOrigine) {
        this.techOrigine = techOrigine;
    }

    public Integer getTechGrpNumOrdre() {
        return this.techGrpNumOrdre;
    }

    public FtOResv techGrpNumOrdre(Integer techGrpNumOrdre) {
        this.setTechGrpNumOrdre(techGrpNumOrdre);
        return this;
    }

    public void setTechGrpNumOrdre(Integer techGrpNumOrdre) {
        this.techGrpNumOrdre = techGrpNumOrdre;
    }

    public LocalDate getTechCreateDate() {
        return this.techCreateDate;
    }

    public FtOResv techCreateDate(LocalDate techCreateDate) {
        this.setTechCreateDate(techCreateDate);
        return this;
    }

    public void setTechCreateDate(LocalDate techCreateDate) {
        this.techCreateDate = techCreateDate;
    }

    public LocalDate getTechUpdateDate() {
        return this.techUpdateDate;
    }

    public FtOResv techUpdateDate(LocalDate techUpdateDate) {
        this.setTechUpdateDate(techUpdateDate);
        return this;
    }

    public void setTechUpdateDate(LocalDate techUpdateDate) {
        this.techUpdateDate = techUpdateDate;
    }

    public Integer getResvNameIdPrincipal() {
        return this.resvNameIdPrincipal;
    }

    public FtOResv resvNameIdPrincipal(Integer resvNameIdPrincipal) {
        this.setResvNameIdPrincipal(resvNameIdPrincipal);
        return this;
    }

    public void setResvNameIdPrincipal(Integer resvNameIdPrincipal) {
        this.resvNameIdPrincipal = resvNameIdPrincipal;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FtOResv)) {
            return false;
        }
        return getId() != null && getId().equals(((FtOResv) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FtOResv{" +
            "id=" + getId() +
            ", numLigne=" + getNumLigne() +
            ", resort='" + getResort() + "'" +
            ", resvNameId=" + getResvNameId() +
            ", clientOId='" + getClientOId() + "'" +
            ", typeChb='" + getTypeChb() + "'" +
            ", businessDate='" + getBusinessDate() + "'" +
            ", numOrdre=" + getNumOrdre() +
            ", confirmationNo='" + getConfirmationNo() + "'" +
            ", clientMdmId='" + getClientMdmId() + "'" +
            ", nameId=" + getNameId() +
            ", nameIdLigne=" + getNameIdLigne() +
            ", contactId=" + getContactId() +
            ", agenceId=" + getAgenceId() +
            ", agenceNom='" + getAgenceNom() + "'" +
            ", societeId=" + getSocieteId() +
            ", groupeId=" + getGroupeId() +
            ", membreId=" + getMembreId() +
            ", sourceProfileId=" + getSourceProfileId() +
            ", numBloc=" + getNumBloc() +
            ", statutResv='" + getStatutResv() + "'" +
            ", statutVip='" + getStatutVip() + "'" +
            ", dateDebutLigne='" + getDateDebutLigne() + "'" +
            ", dateFinLigne='" + getDateFinLigne() + "'" +
            ", dateFinOrigine='" + getDateFinOrigine() + "'" +
            ", dateAnn='" + getDateAnn() + "'" +
            ", pseudoRoomYn='" + getPseudoRoomYn() + "'" +
            ", complementaireYn='" + getComplementaireYn() + "'" +
            ", interneYn='" + getInterneYn() + "'" +
            ", walkinYn='" + getWalkinYn() + "'" +
            ", createurResv=" + getCreateurResv() +
            ", nomCreateurResv='" + getNomCreateurResv() + "'" +
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
            ", typeChbLigne='" + getTypeChbLigne() + "'" +
            ", descriptionTypeChb='" + getDescriptionTypeChb() + "'" +
            ", codeTypeChb='" + getCodeTypeChb() + "'" +
            ", classChb='" + getClassChb() + "'" +
            ", statutChbResv='" + getStatutChbResv() + "'" +
            ", typeChbDeReservation='" + getTypeChbDeReservation() + "'" +
            ", descriptionTypeChbDeResv='" + getDescriptionTypeChbDeResv() + "'" +
            ", codeTypeChbDeResv='" + getCodeTypeChbDeResv() + "'" +
            ", circuitDistribution='" + getCircuitDistribution() + "'" +
            ", circuitDistribUserRegroup='" + getCircuitDistribUserRegroup() + "'" +
            ", nbResvAnn=" + getNbResvAnn() +
            ", nbNuitee=" + getNbNuitee() +
            ", nbNuiteeNnDed=" + getNbNuiteeNnDed() +
            ", nbNuiteeGlobal=" + getNbNuiteeGlobal() +
            ", nbOccupationMultiple=" + getNbOccupationMultiple() +
            ", nbAduGlobal=" + getNbAduGlobal() +
            ", nbEnfGlobal=" + getNbEnfGlobal() +
            ", nbPersDayUGlobal=" + getNbPersDayUGlobal() +
            ", nbPersArrGlobal=" + getNbPersArrGlobal() +
            ", nbPersDepGlobal=" + getNbPersDepGlobal() +
            ", nbPersAnn=" + getNbPersAnn() +
            ", nbPersNoshow=" + getNbPersNoshow() +
            ", nbChbDayUGlobal=" + getNbChbDayUGlobal() +
            ", nbChbArrGlobal=" + getNbChbArrGlobal() +
            ", nbChbDepGlobal=" + getNbChbDepGlobal() +
            ", nbChbAnn=" + getNbChbAnn() +
            ", nbChbNoshow=" + getNbChbNoshow() +
            ", revenuNetChambreGlobal=" + getRevenuNetChambreGlobal() +
            ", revenuTaxeChambreGlobal=" + getRevenuTaxeChambreGlobal() +
            ", revenuNetBqGlobal=" + getRevenuNetBqGlobal() +
            ", revenuTaxeBqGlobal=" + getRevenuTaxeBqGlobal() +
            ", revenuNetExtraGlobal=" + getRevenuNetExtraGlobal() +
            ", revenuTaxeExtraGlobal=" + getRevenuTaxeExtraGlobal() +
            ", revenuNetTotalGlobal=" + getRevenuNetTotalGlobal() +
            ", revenuTaxeTotalGlobal=" + getRevenuTaxeTotalGlobal() +
            ", prodRevenuChambre=" + getProdRevenuChambre() +
            ", prodRevenuBq=" + getProdRevenuBq() +
            ", prodRevenuExtra=" + getProdRevenuExtra() +
            ", prodRevenuTotal=" + getProdRevenuTotal() +
            ", prodChambreNbNuitees=" + getProdChambreNbNuitees() +
            ", datesSejourRensYn='" + getDatesSejourRensYn() + "'" +
            ", techEventType='" + getTechEventType() + "'" +
            ", techResvInvType='" + getTechResvInvType() + "'" +
            ", techOrigine='" + getTechOrigine() + "'" +
            ", techGrpNumOrdre=" + getTechGrpNumOrdre() +
            ", techCreateDate='" + getTechCreateDate() + "'" +
            ", techUpdateDate='" + getTechUpdateDate() + "'" +
            ", resvNameIdPrincipal=" + getResvNameIdPrincipal() +
            "}";
    }
}

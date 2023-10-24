package com.sbm.tableaurealtime.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.sbm.tableaurealtime.domain.FtOResv} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class FtOResvDTO implements Serializable {

    private Long id;

    private Integer numLigne;

    private String resort;

    private Integer resvNameId;

    private String clientOId;

    private String typeChb;

    private LocalDate businessDate;

    private Integer numOrdre;

    private String confirmationNo;

    private String clientMdmId;

    private Integer nameId;

    private Integer nameIdLigne;

    private Integer contactId;

    private Integer agenceId;

    private String agenceNom;

    private Integer societeId;

    private Integer groupeId;

    private Integer membreId;

    private Integer sourceProfileId;

    private Integer numBloc;

    private String statutResv;

    private String statutVip;

    private LocalDate dateDebutLigne;

    private LocalDate dateFinLigne;

    private LocalDate dateFinOrigine;

    private LocalDate dateAnn;

    private String pseudoRoomYn;

    private String complementaireYn;

    private String interneYn;

    private String walkinYn;

    private Integer createurResv;

    private String nomCreateurResv;

    private String codePays;

    private String libPays;

    private String codeNationalite;

    private String libNationalite;

    private String codeSource;

    private String libSource;

    private String codeGrandSource;

    private String codeOrigine;

    private String libOrigine;

    private String codeMarche;

    private String libMarche;

    private String codeGrandMarche;

    private String libGrandMarche;

    private String codePrix;

    private String categPrix;

    private String libPrix;

    private String numChb;

    private String typeChbLigne;

    private String descriptionTypeChb;

    private String codeTypeChb;

    private String classChb;

    private String statutChbResv;

    private String typeChbDeReservation;

    private String descriptionTypeChbDeResv;

    private String codeTypeChbDeResv;

    private String circuitDistribution;

    private String circuitDistribUserRegroup;

    private Integer nbResvAnn;

    private Integer nbNuitee;

    private Integer nbNuiteeNnDed;

    private Integer nbNuiteeGlobal;

    private Integer nbOccupationMultiple;

    private Integer nbAduGlobal;

    private Integer nbEnfGlobal;

    private Integer nbPersDayUGlobal;

    private Integer nbPersArrGlobal;

    private Integer nbPersDepGlobal;

    private Integer nbPersAnn;

    private Integer nbPersNoshow;

    private Integer nbChbDayUGlobal;

    private Integer nbChbArrGlobal;

    private Integer nbChbDepGlobal;

    private Integer nbChbAnn;

    private Integer nbChbNoshow;

    private Long revenuNetChambreGlobal;

    private Long revenuTaxeChambreGlobal;

    private Long revenuNetBqGlobal;

    private Long revenuTaxeBqGlobal;

    private Long revenuNetExtraGlobal;

    private Long revenuTaxeExtraGlobal;

    private Long revenuNetTotalGlobal;

    private Long revenuTaxeTotalGlobal;

    private Long prodRevenuChambre;

    private Long prodRevenuBq;

    private Long prodRevenuExtra;

    private Long prodRevenuTotal;

    private Long prodChambreNbNuitees;

    private String datesSejourRensYn;

    private String techEventType;

    private String techResvInvType;

    private String techOrigine;

    private Integer techGrpNumOrdre;

    private LocalDate techCreateDate;

    private LocalDate techUpdateDate;

    private Integer resvNameIdPrincipal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumLigne() {
        return numLigne;
    }

    public void setNumLigne(Integer numLigne) {
        this.numLigne = numLigne;
    }

    public String getResort() {
        return resort;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public Integer getResvNameId() {
        return resvNameId;
    }

    public void setResvNameId(Integer resvNameId) {
        this.resvNameId = resvNameId;
    }

    public String getClientOId() {
        return clientOId;
    }

    public void setClientOId(String clientOId) {
        this.clientOId = clientOId;
    }

    public String getTypeChb() {
        return typeChb;
    }

    public void setTypeChb(String typeChb) {
        this.typeChb = typeChb;
    }

    public LocalDate getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public Integer getNumOrdre() {
        return numOrdre;
    }

    public void setNumOrdre(Integer numOrdre) {
        this.numOrdre = numOrdre;
    }

    public String getConfirmationNo() {
        return confirmationNo;
    }

    public void setConfirmationNo(String confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    public String getClientMdmId() {
        return clientMdmId;
    }

    public void setClientMdmId(String clientMdmId) {
        this.clientMdmId = clientMdmId;
    }

    public Integer getNameId() {
        return nameId;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public Integer getNameIdLigne() {
        return nameIdLigne;
    }

    public void setNameIdLigne(Integer nameIdLigne) {
        this.nameIdLigne = nameIdLigne;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(Integer agenceId) {
        this.agenceId = agenceId;
    }

    public String getAgenceNom() {
        return agenceNom;
    }

    public void setAgenceNom(String agenceNom) {
        this.agenceNom = agenceNom;
    }

    public Integer getSocieteId() {
        return societeId;
    }

    public void setSocieteId(Integer societeId) {
        this.societeId = societeId;
    }

    public Integer getGroupeId() {
        return groupeId;
    }

    public void setGroupeId(Integer groupeId) {
        this.groupeId = groupeId;
    }

    public Integer getMembreId() {
        return membreId;
    }

    public void setMembreId(Integer membreId) {
        this.membreId = membreId;
    }

    public Integer getSourceProfileId() {
        return sourceProfileId;
    }

    public void setSourceProfileId(Integer sourceProfileId) {
        this.sourceProfileId = sourceProfileId;
    }

    public Integer getNumBloc() {
        return numBloc;
    }

    public void setNumBloc(Integer numBloc) {
        this.numBloc = numBloc;
    }

    public String getStatutResv() {
        return statutResv;
    }

    public void setStatutResv(String statutResv) {
        this.statutResv = statutResv;
    }

    public String getStatutVip() {
        return statutVip;
    }

    public void setStatutVip(String statutVip) {
        this.statutVip = statutVip;
    }

    public LocalDate getDateDebutLigne() {
        return dateDebutLigne;
    }

    public void setDateDebutLigne(LocalDate dateDebutLigne) {
        this.dateDebutLigne = dateDebutLigne;
    }

    public LocalDate getDateFinLigne() {
        return dateFinLigne;
    }

    public void setDateFinLigne(LocalDate dateFinLigne) {
        this.dateFinLigne = dateFinLigne;
    }

    public LocalDate getDateFinOrigine() {
        return dateFinOrigine;
    }

    public void setDateFinOrigine(LocalDate dateFinOrigine) {
        this.dateFinOrigine = dateFinOrigine;
    }

    public LocalDate getDateAnn() {
        return dateAnn;
    }

    public void setDateAnn(LocalDate dateAnn) {
        this.dateAnn = dateAnn;
    }

    public String getPseudoRoomYn() {
        return pseudoRoomYn;
    }

    public void setPseudoRoomYn(String pseudoRoomYn) {
        this.pseudoRoomYn = pseudoRoomYn;
    }

    public String getComplementaireYn() {
        return complementaireYn;
    }

    public void setComplementaireYn(String complementaireYn) {
        this.complementaireYn = complementaireYn;
    }

    public String getInterneYn() {
        return interneYn;
    }

    public void setInterneYn(String interneYn) {
        this.interneYn = interneYn;
    }

    public String getWalkinYn() {
        return walkinYn;
    }

    public void setWalkinYn(String walkinYn) {
        this.walkinYn = walkinYn;
    }

    public Integer getCreateurResv() {
        return createurResv;
    }

    public void setCreateurResv(Integer createurResv) {
        this.createurResv = createurResv;
    }

    public String getNomCreateurResv() {
        return nomCreateurResv;
    }

    public void setNomCreateurResv(String nomCreateurResv) {
        this.nomCreateurResv = nomCreateurResv;
    }

    public String getCodePays() {
        return codePays;
    }

    public void setCodePays(String codePays) {
        this.codePays = codePays;
    }

    public String getLibPays() {
        return libPays;
    }

    public void setLibPays(String libPays) {
        this.libPays = libPays;
    }

    public String getCodeNationalite() {
        return codeNationalite;
    }

    public void setCodeNationalite(String codeNationalite) {
        this.codeNationalite = codeNationalite;
    }

    public String getLibNationalite() {
        return libNationalite;
    }

    public void setLibNationalite(String libNationalite) {
        this.libNationalite = libNationalite;
    }

    public String getCodeSource() {
        return codeSource;
    }

    public void setCodeSource(String codeSource) {
        this.codeSource = codeSource;
    }

    public String getLibSource() {
        return libSource;
    }

    public void setLibSource(String libSource) {
        this.libSource = libSource;
    }

    public String getCodeGrandSource() {
        return codeGrandSource;
    }

    public void setCodeGrandSource(String codeGrandSource) {
        this.codeGrandSource = codeGrandSource;
    }

    public String getCodeOrigine() {
        return codeOrigine;
    }

    public void setCodeOrigine(String codeOrigine) {
        this.codeOrigine = codeOrigine;
    }

    public String getLibOrigine() {
        return libOrigine;
    }

    public void setLibOrigine(String libOrigine) {
        this.libOrigine = libOrigine;
    }

    public String getCodeMarche() {
        return codeMarche;
    }

    public void setCodeMarche(String codeMarche) {
        this.codeMarche = codeMarche;
    }

    public String getLibMarche() {
        return libMarche;
    }

    public void setLibMarche(String libMarche) {
        this.libMarche = libMarche;
    }

    public String getCodeGrandMarche() {
        return codeGrandMarche;
    }

    public void setCodeGrandMarche(String codeGrandMarche) {
        this.codeGrandMarche = codeGrandMarche;
    }

    public String getLibGrandMarche() {
        return libGrandMarche;
    }

    public void setLibGrandMarche(String libGrandMarche) {
        this.libGrandMarche = libGrandMarche;
    }

    public String getCodePrix() {
        return codePrix;
    }

    public void setCodePrix(String codePrix) {
        this.codePrix = codePrix;
    }

    public String getCategPrix() {
        return categPrix;
    }

    public void setCategPrix(String categPrix) {
        this.categPrix = categPrix;
    }

    public String getLibPrix() {
        return libPrix;
    }

    public void setLibPrix(String libPrix) {
        this.libPrix = libPrix;
    }

    public String getNumChb() {
        return numChb;
    }

    public void setNumChb(String numChb) {
        this.numChb = numChb;
    }

    public String getTypeChbLigne() {
        return typeChbLigne;
    }

    public void setTypeChbLigne(String typeChbLigne) {
        this.typeChbLigne = typeChbLigne;
    }

    public String getDescriptionTypeChb() {
        return descriptionTypeChb;
    }

    public void setDescriptionTypeChb(String descriptionTypeChb) {
        this.descriptionTypeChb = descriptionTypeChb;
    }

    public String getCodeTypeChb() {
        return codeTypeChb;
    }

    public void setCodeTypeChb(String codeTypeChb) {
        this.codeTypeChb = codeTypeChb;
    }

    public String getClassChb() {
        return classChb;
    }

    public void setClassChb(String classChb) {
        this.classChb = classChb;
    }

    public String getStatutChbResv() {
        return statutChbResv;
    }

    public void setStatutChbResv(String statutChbResv) {
        this.statutChbResv = statutChbResv;
    }

    public String getTypeChbDeReservation() {
        return typeChbDeReservation;
    }

    public void setTypeChbDeReservation(String typeChbDeReservation) {
        this.typeChbDeReservation = typeChbDeReservation;
    }

    public String getDescriptionTypeChbDeResv() {
        return descriptionTypeChbDeResv;
    }

    public void setDescriptionTypeChbDeResv(String descriptionTypeChbDeResv) {
        this.descriptionTypeChbDeResv = descriptionTypeChbDeResv;
    }

    public String getCodeTypeChbDeResv() {
        return codeTypeChbDeResv;
    }

    public void setCodeTypeChbDeResv(String codeTypeChbDeResv) {
        this.codeTypeChbDeResv = codeTypeChbDeResv;
    }

    public String getCircuitDistribution() {
        return circuitDistribution;
    }

    public void setCircuitDistribution(String circuitDistribution) {
        this.circuitDistribution = circuitDistribution;
    }

    public String getCircuitDistribUserRegroup() {
        return circuitDistribUserRegroup;
    }

    public void setCircuitDistribUserRegroup(String circuitDistribUserRegroup) {
        this.circuitDistribUserRegroup = circuitDistribUserRegroup;
    }

    public Integer getNbResvAnn() {
        return nbResvAnn;
    }

    public void setNbResvAnn(Integer nbResvAnn) {
        this.nbResvAnn = nbResvAnn;
    }

    public Integer getNbNuitee() {
        return nbNuitee;
    }

    public void setNbNuitee(Integer nbNuitee) {
        this.nbNuitee = nbNuitee;
    }

    public Integer getNbNuiteeNnDed() {
        return nbNuiteeNnDed;
    }

    public void setNbNuiteeNnDed(Integer nbNuiteeNnDed) {
        this.nbNuiteeNnDed = nbNuiteeNnDed;
    }

    public Integer getNbNuiteeGlobal() {
        return nbNuiteeGlobal;
    }

    public void setNbNuiteeGlobal(Integer nbNuiteeGlobal) {
        this.nbNuiteeGlobal = nbNuiteeGlobal;
    }

    public Integer getNbOccupationMultiple() {
        return nbOccupationMultiple;
    }

    public void setNbOccupationMultiple(Integer nbOccupationMultiple) {
        this.nbOccupationMultiple = nbOccupationMultiple;
    }

    public Integer getNbAduGlobal() {
        return nbAduGlobal;
    }

    public void setNbAduGlobal(Integer nbAduGlobal) {
        this.nbAduGlobal = nbAduGlobal;
    }

    public Integer getNbEnfGlobal() {
        return nbEnfGlobal;
    }

    public void setNbEnfGlobal(Integer nbEnfGlobal) {
        this.nbEnfGlobal = nbEnfGlobal;
    }

    public Integer getNbPersDayUGlobal() {
        return nbPersDayUGlobal;
    }

    public void setNbPersDayUGlobal(Integer nbPersDayUGlobal) {
        this.nbPersDayUGlobal = nbPersDayUGlobal;
    }

    public Integer getNbPersArrGlobal() {
        return nbPersArrGlobal;
    }

    public void setNbPersArrGlobal(Integer nbPersArrGlobal) {
        this.nbPersArrGlobal = nbPersArrGlobal;
    }

    public Integer getNbPersDepGlobal() {
        return nbPersDepGlobal;
    }

    public void setNbPersDepGlobal(Integer nbPersDepGlobal) {
        this.nbPersDepGlobal = nbPersDepGlobal;
    }

    public Integer getNbPersAnn() {
        return nbPersAnn;
    }

    public void setNbPersAnn(Integer nbPersAnn) {
        this.nbPersAnn = nbPersAnn;
    }

    public Integer getNbPersNoshow() {
        return nbPersNoshow;
    }

    public void setNbPersNoshow(Integer nbPersNoshow) {
        this.nbPersNoshow = nbPersNoshow;
    }

    public Integer getNbChbDayUGlobal() {
        return nbChbDayUGlobal;
    }

    public void setNbChbDayUGlobal(Integer nbChbDayUGlobal) {
        this.nbChbDayUGlobal = nbChbDayUGlobal;
    }

    public Integer getNbChbArrGlobal() {
        return nbChbArrGlobal;
    }

    public void setNbChbArrGlobal(Integer nbChbArrGlobal) {
        this.nbChbArrGlobal = nbChbArrGlobal;
    }

    public Integer getNbChbDepGlobal() {
        return nbChbDepGlobal;
    }

    public void setNbChbDepGlobal(Integer nbChbDepGlobal) {
        this.nbChbDepGlobal = nbChbDepGlobal;
    }

    public Integer getNbChbAnn() {
        return nbChbAnn;
    }

    public void setNbChbAnn(Integer nbChbAnn) {
        this.nbChbAnn = nbChbAnn;
    }

    public Integer getNbChbNoshow() {
        return nbChbNoshow;
    }

    public void setNbChbNoshow(Integer nbChbNoshow) {
        this.nbChbNoshow = nbChbNoshow;
    }

    public Long getRevenuNetChambreGlobal() {
        return revenuNetChambreGlobal;
    }

    public void setRevenuNetChambreGlobal(Long revenuNetChambreGlobal) {
        this.revenuNetChambreGlobal = revenuNetChambreGlobal;
    }

    public Long getRevenuTaxeChambreGlobal() {
        return revenuTaxeChambreGlobal;
    }

    public void setRevenuTaxeChambreGlobal(Long revenuTaxeChambreGlobal) {
        this.revenuTaxeChambreGlobal = revenuTaxeChambreGlobal;
    }

    public Long getRevenuNetBqGlobal() {
        return revenuNetBqGlobal;
    }

    public void setRevenuNetBqGlobal(Long revenuNetBqGlobal) {
        this.revenuNetBqGlobal = revenuNetBqGlobal;
    }

    public Long getRevenuTaxeBqGlobal() {
        return revenuTaxeBqGlobal;
    }

    public void setRevenuTaxeBqGlobal(Long revenuTaxeBqGlobal) {
        this.revenuTaxeBqGlobal = revenuTaxeBqGlobal;
    }

    public Long getRevenuNetExtraGlobal() {
        return revenuNetExtraGlobal;
    }

    public void setRevenuNetExtraGlobal(Long revenuNetExtraGlobal) {
        this.revenuNetExtraGlobal = revenuNetExtraGlobal;
    }

    public Long getRevenuTaxeExtraGlobal() {
        return revenuTaxeExtraGlobal;
    }

    public void setRevenuTaxeExtraGlobal(Long revenuTaxeExtraGlobal) {
        this.revenuTaxeExtraGlobal = revenuTaxeExtraGlobal;
    }

    public Long getRevenuNetTotalGlobal() {
        return revenuNetTotalGlobal;
    }

    public void setRevenuNetTotalGlobal(Long revenuNetTotalGlobal) {
        this.revenuNetTotalGlobal = revenuNetTotalGlobal;
    }

    public Long getRevenuTaxeTotalGlobal() {
        return revenuTaxeTotalGlobal;
    }

    public void setRevenuTaxeTotalGlobal(Long revenuTaxeTotalGlobal) {
        this.revenuTaxeTotalGlobal = revenuTaxeTotalGlobal;
    }

    public Long getProdRevenuChambre() {
        return prodRevenuChambre;
    }

    public void setProdRevenuChambre(Long prodRevenuChambre) {
        this.prodRevenuChambre = prodRevenuChambre;
    }

    public Long getProdRevenuBq() {
        return prodRevenuBq;
    }

    public void setProdRevenuBq(Long prodRevenuBq) {
        this.prodRevenuBq = prodRevenuBq;
    }

    public Long getProdRevenuExtra() {
        return prodRevenuExtra;
    }

    public void setProdRevenuExtra(Long prodRevenuExtra) {
        this.prodRevenuExtra = prodRevenuExtra;
    }

    public Long getProdRevenuTotal() {
        return prodRevenuTotal;
    }

    public void setProdRevenuTotal(Long prodRevenuTotal) {
        this.prodRevenuTotal = prodRevenuTotal;
    }

    public Long getProdChambreNbNuitees() {
        return prodChambreNbNuitees;
    }

    public void setProdChambreNbNuitees(Long prodChambreNbNuitees) {
        this.prodChambreNbNuitees = prodChambreNbNuitees;
    }

    public String getDatesSejourRensYn() {
        return datesSejourRensYn;
    }

    public void setDatesSejourRensYn(String datesSejourRensYn) {
        this.datesSejourRensYn = datesSejourRensYn;
    }

    public String getTechEventType() {
        return techEventType;
    }

    public void setTechEventType(String techEventType) {
        this.techEventType = techEventType;
    }

    public String getTechResvInvType() {
        return techResvInvType;
    }

    public void setTechResvInvType(String techResvInvType) {
        this.techResvInvType = techResvInvType;
    }

    public String getTechOrigine() {
        return techOrigine;
    }

    public void setTechOrigine(String techOrigine) {
        this.techOrigine = techOrigine;
    }

    public Integer getTechGrpNumOrdre() {
        return techGrpNumOrdre;
    }

    public void setTechGrpNumOrdre(Integer techGrpNumOrdre) {
        this.techGrpNumOrdre = techGrpNumOrdre;
    }

    public LocalDate getTechCreateDate() {
        return techCreateDate;
    }

    public void setTechCreateDate(LocalDate techCreateDate) {
        this.techCreateDate = techCreateDate;
    }

    public LocalDate getTechUpdateDate() {
        return techUpdateDate;
    }

    public void setTechUpdateDate(LocalDate techUpdateDate) {
        this.techUpdateDate = techUpdateDate;
    }

    public Integer getResvNameIdPrincipal() {
        return resvNameIdPrincipal;
    }

    public void setResvNameIdPrincipal(Integer resvNameIdPrincipal) {
        this.resvNameIdPrincipal = resvNameIdPrincipal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FtOResvDTO)) {
            return false;
        }

        FtOResvDTO ftOResvDTO = (FtOResvDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, ftOResvDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FtOResvDTO{" +
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

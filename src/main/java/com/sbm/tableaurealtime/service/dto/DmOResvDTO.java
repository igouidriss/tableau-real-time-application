package com.sbm.tableaurealtime.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.sbm.tableaurealtime.domain.DmOResv} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DmOResvDTO implements Serializable {

    private Long id;

    private Integer numLigne;

    private String resort;

    private Integer resvNameId;

    private String clientOId;

    private String typeChb;

    private String confirmationNo;

    private String clientMdmId;

    private Integer nameId;

    private Integer parentResvNameId;

    private Integer contactId;

    private Integer agenceId;

    private String agenceNom;

    private Integer societeId;

    private Integer groupeId;

    private Integer numBloc;

    private String typeResv;

    private String statutResv;

    private LocalDate dateDebutResv;

    private LocalDate dateFinResv;

    private LocalDate truncDateDebutResv;

    private LocalDate truncDateFinResv;

    private LocalDate dateAnnResv;

    private String pseudoRoomYn;

    private Integer createurResv;

    private String nomCreateurResv;

    private String codeGarantie;

    private String flgDed;

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

    private String descriptionTypeChb;

    private String codeTypeChb;

    private String classChb;

    private String caractChb;

    private String typeChbDeReservation;

    private String descriptionTypeChbDeResv;

    private String codeTypeChbDeResv;

    private String statutDeReservation;

    private String circuitDistribution;

    private String circuitDistribUserRegroup;

    private String numCrs;

    private String typeRefCrs;

    private LocalDate crsInsertDate;

    private LocalDate dateCreaResv;

    private LocalDate datePremier;

    private String statutPremier;

    private LocalDate dateDernier;

    private String statutDernier;

    private LocalDate dateDernierPseudo;

    private String statutDernierPseudo;

    private Integer diffDtCreaAnn;

    private Integer diffDtArrAnn;

    private Integer leadtime;

    private Integer los;

    private String occupantsGroupe;

    private Integer nbNuitee;

    private Integer nbNuiteeNnDed;

    private Integer nbResvAnn;

    private Integer nbAdu;

    private Integer nbEnf;

    private Integer nbPersDayU;

    private Integer nbPersArr;

    private Integer nbPersDep;

    private Integer nbPersAnn;

    private Integer nbPersNoshow;

    private Integer nbChbDayU;

    private Integer nbChbArr;

    private Integer nbChbDep;

    private Integer nbChbAnn;

    private Integer nbChbNoshow;

    private Long revenuNetChambre;

    private Long revenuTaxeChambre;

    private Long revenuNetChambreGlobal;

    private Long revenuTaxeChambreGlobal;

    private Long revenuNetBq;

    private Long revenuTaxeBq;

    private Long revenuNetBqGlobal;

    private Long revenuTaxeBqGlobal;

    private Long revenuNetExtra;

    private Long revenuTaxeExtra;

    private Long revenuNetExtraGlobal;

    private Long revenuTaxeExtraGlobal;

    private Long revenuNetTotal;

    private Long revenuTaxeTotal;

    private Long revenuNetTotalGlobal;

    private Long revenuTaxeTotalGlobal;

    private Long prodRevenuChambre;

    private Long prodRevenuBq;

    private Long prodRevenuExtra;

    private Long prodRevenuTotal;

    private Long prodChambreNbNuitees;

    private LocalDate techCreateDate;

    private LocalDate techUpdateDate;

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

    public Integer getParentResvNameId() {
        return parentResvNameId;
    }

    public void setParentResvNameId(Integer parentResvNameId) {
        this.parentResvNameId = parentResvNameId;
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

    public Integer getNumBloc() {
        return numBloc;
    }

    public void setNumBloc(Integer numBloc) {
        this.numBloc = numBloc;
    }

    public String getTypeResv() {
        return typeResv;
    }

    public void setTypeResv(String typeResv) {
        this.typeResv = typeResv;
    }

    public String getStatutResv() {
        return statutResv;
    }

    public void setStatutResv(String statutResv) {
        this.statutResv = statutResv;
    }

    public LocalDate getDateDebutResv() {
        return dateDebutResv;
    }

    public void setDateDebutResv(LocalDate dateDebutResv) {
        this.dateDebutResv = dateDebutResv;
    }

    public LocalDate getDateFinResv() {
        return dateFinResv;
    }

    public void setDateFinResv(LocalDate dateFinResv) {
        this.dateFinResv = dateFinResv;
    }

    public LocalDate getTruncDateDebutResv() {
        return truncDateDebutResv;
    }

    public void setTruncDateDebutResv(LocalDate truncDateDebutResv) {
        this.truncDateDebutResv = truncDateDebutResv;
    }

    public LocalDate getTruncDateFinResv() {
        return truncDateFinResv;
    }

    public void setTruncDateFinResv(LocalDate truncDateFinResv) {
        this.truncDateFinResv = truncDateFinResv;
    }

    public LocalDate getDateAnnResv() {
        return dateAnnResv;
    }

    public void setDateAnnResv(LocalDate dateAnnResv) {
        this.dateAnnResv = dateAnnResv;
    }

    public String getPseudoRoomYn() {
        return pseudoRoomYn;
    }

    public void setPseudoRoomYn(String pseudoRoomYn) {
        this.pseudoRoomYn = pseudoRoomYn;
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

    public String getCodeGarantie() {
        return codeGarantie;
    }

    public void setCodeGarantie(String codeGarantie) {
        this.codeGarantie = codeGarantie;
    }

    public String getFlgDed() {
        return flgDed;
    }

    public void setFlgDed(String flgDed) {
        this.flgDed = flgDed;
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

    public String getCaractChb() {
        return caractChb;
    }

    public void setCaractChb(String caractChb) {
        this.caractChb = caractChb;
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

    public String getStatutDeReservation() {
        return statutDeReservation;
    }

    public void setStatutDeReservation(String statutDeReservation) {
        this.statutDeReservation = statutDeReservation;
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

    public String getNumCrs() {
        return numCrs;
    }

    public void setNumCrs(String numCrs) {
        this.numCrs = numCrs;
    }

    public String getTypeRefCrs() {
        return typeRefCrs;
    }

    public void setTypeRefCrs(String typeRefCrs) {
        this.typeRefCrs = typeRefCrs;
    }

    public LocalDate getCrsInsertDate() {
        return crsInsertDate;
    }

    public void setCrsInsertDate(LocalDate crsInsertDate) {
        this.crsInsertDate = crsInsertDate;
    }

    public LocalDate getDateCreaResv() {
        return dateCreaResv;
    }

    public void setDateCreaResv(LocalDate dateCreaResv) {
        this.dateCreaResv = dateCreaResv;
    }

    public LocalDate getDatePremier() {
        return datePremier;
    }

    public void setDatePremier(LocalDate datePremier) {
        this.datePremier = datePremier;
    }

    public String getStatutPremier() {
        return statutPremier;
    }

    public void setStatutPremier(String statutPremier) {
        this.statutPremier = statutPremier;
    }

    public LocalDate getDateDernier() {
        return dateDernier;
    }

    public void setDateDernier(LocalDate dateDernier) {
        this.dateDernier = dateDernier;
    }

    public String getStatutDernier() {
        return statutDernier;
    }

    public void setStatutDernier(String statutDernier) {
        this.statutDernier = statutDernier;
    }

    public LocalDate getDateDernierPseudo() {
        return dateDernierPseudo;
    }

    public void setDateDernierPseudo(LocalDate dateDernierPseudo) {
        this.dateDernierPseudo = dateDernierPseudo;
    }

    public String getStatutDernierPseudo() {
        return statutDernierPseudo;
    }

    public void setStatutDernierPseudo(String statutDernierPseudo) {
        this.statutDernierPseudo = statutDernierPseudo;
    }

    public Integer getDiffDtCreaAnn() {
        return diffDtCreaAnn;
    }

    public void setDiffDtCreaAnn(Integer diffDtCreaAnn) {
        this.diffDtCreaAnn = diffDtCreaAnn;
    }

    public Integer getDiffDtArrAnn() {
        return diffDtArrAnn;
    }

    public void setDiffDtArrAnn(Integer diffDtArrAnn) {
        this.diffDtArrAnn = diffDtArrAnn;
    }

    public Integer getLeadtime() {
        return leadtime;
    }

    public void setLeadtime(Integer leadtime) {
        this.leadtime = leadtime;
    }

    public Integer getLos() {
        return los;
    }

    public void setLos(Integer los) {
        this.los = los;
    }

    public String getOccupantsGroupe() {
        return occupantsGroupe;
    }

    public void setOccupantsGroupe(String occupantsGroupe) {
        this.occupantsGroupe = occupantsGroupe;
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

    public Integer getNbResvAnn() {
        return nbResvAnn;
    }

    public void setNbResvAnn(Integer nbResvAnn) {
        this.nbResvAnn = nbResvAnn;
    }

    public Integer getNbAdu() {
        return nbAdu;
    }

    public void setNbAdu(Integer nbAdu) {
        this.nbAdu = nbAdu;
    }

    public Integer getNbEnf() {
        return nbEnf;
    }

    public void setNbEnf(Integer nbEnf) {
        this.nbEnf = nbEnf;
    }

    public Integer getNbPersDayU() {
        return nbPersDayU;
    }

    public void setNbPersDayU(Integer nbPersDayU) {
        this.nbPersDayU = nbPersDayU;
    }

    public Integer getNbPersArr() {
        return nbPersArr;
    }

    public void setNbPersArr(Integer nbPersArr) {
        this.nbPersArr = nbPersArr;
    }

    public Integer getNbPersDep() {
        return nbPersDep;
    }

    public void setNbPersDep(Integer nbPersDep) {
        this.nbPersDep = nbPersDep;
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

    public Integer getNbChbDayU() {
        return nbChbDayU;
    }

    public void setNbChbDayU(Integer nbChbDayU) {
        this.nbChbDayU = nbChbDayU;
    }

    public Integer getNbChbArr() {
        return nbChbArr;
    }

    public void setNbChbArr(Integer nbChbArr) {
        this.nbChbArr = nbChbArr;
    }

    public Integer getNbChbDep() {
        return nbChbDep;
    }

    public void setNbChbDep(Integer nbChbDep) {
        this.nbChbDep = nbChbDep;
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

    public Long getRevenuNetChambre() {
        return revenuNetChambre;
    }

    public void setRevenuNetChambre(Long revenuNetChambre) {
        this.revenuNetChambre = revenuNetChambre;
    }

    public Long getRevenuTaxeChambre() {
        return revenuTaxeChambre;
    }

    public void setRevenuTaxeChambre(Long revenuTaxeChambre) {
        this.revenuTaxeChambre = revenuTaxeChambre;
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

    public Long getRevenuNetBq() {
        return revenuNetBq;
    }

    public void setRevenuNetBq(Long revenuNetBq) {
        this.revenuNetBq = revenuNetBq;
    }

    public Long getRevenuTaxeBq() {
        return revenuTaxeBq;
    }

    public void setRevenuTaxeBq(Long revenuTaxeBq) {
        this.revenuTaxeBq = revenuTaxeBq;
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

    public Long getRevenuNetExtra() {
        return revenuNetExtra;
    }

    public void setRevenuNetExtra(Long revenuNetExtra) {
        this.revenuNetExtra = revenuNetExtra;
    }

    public Long getRevenuTaxeExtra() {
        return revenuTaxeExtra;
    }

    public void setRevenuTaxeExtra(Long revenuTaxeExtra) {
        this.revenuTaxeExtra = revenuTaxeExtra;
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

    public Long getRevenuNetTotal() {
        return revenuNetTotal;
    }

    public void setRevenuNetTotal(Long revenuNetTotal) {
        this.revenuNetTotal = revenuNetTotal;
    }

    public Long getRevenuTaxeTotal() {
        return revenuTaxeTotal;
    }

    public void setRevenuTaxeTotal(Long revenuTaxeTotal) {
        this.revenuTaxeTotal = revenuTaxeTotal;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DmOResvDTO)) {
            return false;
        }

        DmOResvDTO dmOResvDTO = (DmOResvDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, dmOResvDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmOResvDTO{" +
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

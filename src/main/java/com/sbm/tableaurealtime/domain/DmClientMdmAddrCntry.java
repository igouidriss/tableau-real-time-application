package com.sbm.tableaurealtime.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A DmClientMdmAddrCntry.
 */
@Entity
@Table(name = "dm_client_mdm_addr_cntry")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DmClientMdmAddrCntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "prty_fk", nullable = false)
    private String prtyFk;

    @Column(name = "frst_cntry_frmt")
    private String frstCntryFrmt;

    @Column(name = "frst_continent")
    private String frstContinent;

    @Column(name = "scnd_cntry_frmt")
    private String scndCntryFrmt;

    @Column(name = "scnd_continent")
    private String scndContinent;

    @Column(name = "thrd_cntry_frmt")
    private String thrdCntryFrmt;

    @Column(name = "thrd_continent")
    private String thrdContinent;

    @Column(name = "frth_cntry_frmt")
    private String frthCntryFrmt;

    @Column(name = "frth_continent")
    private String frthContinent;

    @Column(name = "tech_lineage")
    private String techLineage;

    @Column(name = "tech_created_date")
    private LocalDate techCreatedDate;

    @Column(name = "tech_updated_date")
    private LocalDate techUpdatedDate;

    @Column(name = "tech_mapping")
    private String techMapping;

    @Column(name = "tech_comment")
    private String techComment;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public DmClientMdmAddrCntry id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrtyFk() {
        return this.prtyFk;
    }

    public DmClientMdmAddrCntry prtyFk(String prtyFk) {
        this.setPrtyFk(prtyFk);
        return this;
    }

    public void setPrtyFk(String prtyFk) {
        this.prtyFk = prtyFk;
    }

    public String getFrstCntryFrmt() {
        return this.frstCntryFrmt;
    }

    public DmClientMdmAddrCntry frstCntryFrmt(String frstCntryFrmt) {
        this.setFrstCntryFrmt(frstCntryFrmt);
        return this;
    }

    public void setFrstCntryFrmt(String frstCntryFrmt) {
        this.frstCntryFrmt = frstCntryFrmt;
    }

    public String getFrstContinent() {
        return this.frstContinent;
    }

    public DmClientMdmAddrCntry frstContinent(String frstContinent) {
        this.setFrstContinent(frstContinent);
        return this;
    }

    public void setFrstContinent(String frstContinent) {
        this.frstContinent = frstContinent;
    }

    public String getScndCntryFrmt() {
        return this.scndCntryFrmt;
    }

    public DmClientMdmAddrCntry scndCntryFrmt(String scndCntryFrmt) {
        this.setScndCntryFrmt(scndCntryFrmt);
        return this;
    }

    public void setScndCntryFrmt(String scndCntryFrmt) {
        this.scndCntryFrmt = scndCntryFrmt;
    }

    public String getScndContinent() {
        return this.scndContinent;
    }

    public DmClientMdmAddrCntry scndContinent(String scndContinent) {
        this.setScndContinent(scndContinent);
        return this;
    }

    public void setScndContinent(String scndContinent) {
        this.scndContinent = scndContinent;
    }

    public String getThrdCntryFrmt() {
        return this.thrdCntryFrmt;
    }

    public DmClientMdmAddrCntry thrdCntryFrmt(String thrdCntryFrmt) {
        this.setThrdCntryFrmt(thrdCntryFrmt);
        return this;
    }

    public void setThrdCntryFrmt(String thrdCntryFrmt) {
        this.thrdCntryFrmt = thrdCntryFrmt;
    }

    public String getThrdContinent() {
        return this.thrdContinent;
    }

    public DmClientMdmAddrCntry thrdContinent(String thrdContinent) {
        this.setThrdContinent(thrdContinent);
        return this;
    }

    public void setThrdContinent(String thrdContinent) {
        this.thrdContinent = thrdContinent;
    }

    public String getFrthCntryFrmt() {
        return this.frthCntryFrmt;
    }

    public DmClientMdmAddrCntry frthCntryFrmt(String frthCntryFrmt) {
        this.setFrthCntryFrmt(frthCntryFrmt);
        return this;
    }

    public void setFrthCntryFrmt(String frthCntryFrmt) {
        this.frthCntryFrmt = frthCntryFrmt;
    }

    public String getFrthContinent() {
        return this.frthContinent;
    }

    public DmClientMdmAddrCntry frthContinent(String frthContinent) {
        this.setFrthContinent(frthContinent);
        return this;
    }

    public void setFrthContinent(String frthContinent) {
        this.frthContinent = frthContinent;
    }

    public String getTechLineage() {
        return this.techLineage;
    }

    public DmClientMdmAddrCntry techLineage(String techLineage) {
        this.setTechLineage(techLineage);
        return this;
    }

    public void setTechLineage(String techLineage) {
        this.techLineage = techLineage;
    }

    public LocalDate getTechCreatedDate() {
        return this.techCreatedDate;
    }

    public DmClientMdmAddrCntry techCreatedDate(LocalDate techCreatedDate) {
        this.setTechCreatedDate(techCreatedDate);
        return this;
    }

    public void setTechCreatedDate(LocalDate techCreatedDate) {
        this.techCreatedDate = techCreatedDate;
    }

    public LocalDate getTechUpdatedDate() {
        return this.techUpdatedDate;
    }

    public DmClientMdmAddrCntry techUpdatedDate(LocalDate techUpdatedDate) {
        this.setTechUpdatedDate(techUpdatedDate);
        return this;
    }

    public void setTechUpdatedDate(LocalDate techUpdatedDate) {
        this.techUpdatedDate = techUpdatedDate;
    }

    public String getTechMapping() {
        return this.techMapping;
    }

    public DmClientMdmAddrCntry techMapping(String techMapping) {
        this.setTechMapping(techMapping);
        return this;
    }

    public void setTechMapping(String techMapping) {
        this.techMapping = techMapping;
    }

    public String getTechComment() {
        return this.techComment;
    }

    public DmClientMdmAddrCntry techComment(String techComment) {
        this.setTechComment(techComment);
        return this;
    }

    public void setTechComment(String techComment) {
        this.techComment = techComment;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DmClientMdmAddrCntry)) {
            return false;
        }
        return getId() != null && getId().equals(((DmClientMdmAddrCntry) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmClientMdmAddrCntry{" +
            "id=" + getId() +
            ", prtyFk='" + getPrtyFk() + "'" +
            ", frstCntryFrmt='" + getFrstCntryFrmt() + "'" +
            ", frstContinent='" + getFrstContinent() + "'" +
            ", scndCntryFrmt='" + getScndCntryFrmt() + "'" +
            ", scndContinent='" + getScndContinent() + "'" +
            ", thrdCntryFrmt='" + getThrdCntryFrmt() + "'" +
            ", thrdContinent='" + getThrdContinent() + "'" +
            ", frthCntryFrmt='" + getFrthCntryFrmt() + "'" +
            ", frthContinent='" + getFrthContinent() + "'" +
            ", techLineage='" + getTechLineage() + "'" +
            ", techCreatedDate='" + getTechCreatedDate() + "'" +
            ", techUpdatedDate='" + getTechUpdatedDate() + "'" +
            ", techMapping='" + getTechMapping() + "'" +
            ", techComment='" + getTechComment() + "'" +
            "}";
    }
}

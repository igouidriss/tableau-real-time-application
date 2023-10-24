package com.sbm.tableaurealtime.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A DmClientMdmNtnltyCntry.
 */
@Entity
@Table(name = "dm_client_mdm_ntnlty_cntry")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DmClientMdmNtnltyCntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "prty_fk", nullable = false)
    private String prtyFk;

    @Column(name = "frst_ntnlt_frmt")
    private String frstNtnltFrmt;

    @Column(name = "frst_continent")
    private String frstContinent;

    @Column(name = "scnd_ntnlt_frmt")
    private String scndNtnltFrmt;

    @Column(name = "scnd_continent")
    private String scndContinent;

    @Column(name = "thrd_ntnlt_frmt")
    private String thrdNtnltFrmt;

    @Column(name = "thrd_continent")
    private String thrdContinent;

    @Column(name = "frth_ntnlt_frmt")
    private String frthNtnltFrmt;

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

    public DmClientMdmNtnltyCntry id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrtyFk() {
        return this.prtyFk;
    }

    public DmClientMdmNtnltyCntry prtyFk(String prtyFk) {
        this.setPrtyFk(prtyFk);
        return this;
    }

    public void setPrtyFk(String prtyFk) {
        this.prtyFk = prtyFk;
    }

    public String getFrstNtnltFrmt() {
        return this.frstNtnltFrmt;
    }

    public DmClientMdmNtnltyCntry frstNtnltFrmt(String frstNtnltFrmt) {
        this.setFrstNtnltFrmt(frstNtnltFrmt);
        return this;
    }

    public void setFrstNtnltFrmt(String frstNtnltFrmt) {
        this.frstNtnltFrmt = frstNtnltFrmt;
    }

    public String getFrstContinent() {
        return this.frstContinent;
    }

    public DmClientMdmNtnltyCntry frstContinent(String frstContinent) {
        this.setFrstContinent(frstContinent);
        return this;
    }

    public void setFrstContinent(String frstContinent) {
        this.frstContinent = frstContinent;
    }

    public String getScndNtnltFrmt() {
        return this.scndNtnltFrmt;
    }

    public DmClientMdmNtnltyCntry scndNtnltFrmt(String scndNtnltFrmt) {
        this.setScndNtnltFrmt(scndNtnltFrmt);
        return this;
    }

    public void setScndNtnltFrmt(String scndNtnltFrmt) {
        this.scndNtnltFrmt = scndNtnltFrmt;
    }

    public String getScndContinent() {
        return this.scndContinent;
    }

    public DmClientMdmNtnltyCntry scndContinent(String scndContinent) {
        this.setScndContinent(scndContinent);
        return this;
    }

    public void setScndContinent(String scndContinent) {
        this.scndContinent = scndContinent;
    }

    public String getThrdNtnltFrmt() {
        return this.thrdNtnltFrmt;
    }

    public DmClientMdmNtnltyCntry thrdNtnltFrmt(String thrdNtnltFrmt) {
        this.setThrdNtnltFrmt(thrdNtnltFrmt);
        return this;
    }

    public void setThrdNtnltFrmt(String thrdNtnltFrmt) {
        this.thrdNtnltFrmt = thrdNtnltFrmt;
    }

    public String getThrdContinent() {
        return this.thrdContinent;
    }

    public DmClientMdmNtnltyCntry thrdContinent(String thrdContinent) {
        this.setThrdContinent(thrdContinent);
        return this;
    }

    public void setThrdContinent(String thrdContinent) {
        this.thrdContinent = thrdContinent;
    }

    public String getFrthNtnltFrmt() {
        return this.frthNtnltFrmt;
    }

    public DmClientMdmNtnltyCntry frthNtnltFrmt(String frthNtnltFrmt) {
        this.setFrthNtnltFrmt(frthNtnltFrmt);
        return this;
    }

    public void setFrthNtnltFrmt(String frthNtnltFrmt) {
        this.frthNtnltFrmt = frthNtnltFrmt;
    }

    public String getFrthContinent() {
        return this.frthContinent;
    }

    public DmClientMdmNtnltyCntry frthContinent(String frthContinent) {
        this.setFrthContinent(frthContinent);
        return this;
    }

    public void setFrthContinent(String frthContinent) {
        this.frthContinent = frthContinent;
    }

    public String getTechLineage() {
        return this.techLineage;
    }

    public DmClientMdmNtnltyCntry techLineage(String techLineage) {
        this.setTechLineage(techLineage);
        return this;
    }

    public void setTechLineage(String techLineage) {
        this.techLineage = techLineage;
    }

    public LocalDate getTechCreatedDate() {
        return this.techCreatedDate;
    }

    public DmClientMdmNtnltyCntry techCreatedDate(LocalDate techCreatedDate) {
        this.setTechCreatedDate(techCreatedDate);
        return this;
    }

    public void setTechCreatedDate(LocalDate techCreatedDate) {
        this.techCreatedDate = techCreatedDate;
    }

    public LocalDate getTechUpdatedDate() {
        return this.techUpdatedDate;
    }

    public DmClientMdmNtnltyCntry techUpdatedDate(LocalDate techUpdatedDate) {
        this.setTechUpdatedDate(techUpdatedDate);
        return this;
    }

    public void setTechUpdatedDate(LocalDate techUpdatedDate) {
        this.techUpdatedDate = techUpdatedDate;
    }

    public String getTechMapping() {
        return this.techMapping;
    }

    public DmClientMdmNtnltyCntry techMapping(String techMapping) {
        this.setTechMapping(techMapping);
        return this;
    }

    public void setTechMapping(String techMapping) {
        this.techMapping = techMapping;
    }

    public String getTechComment() {
        return this.techComment;
    }

    public DmClientMdmNtnltyCntry techComment(String techComment) {
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
        if (!(o instanceof DmClientMdmNtnltyCntry)) {
            return false;
        }
        return getId() != null && getId().equals(((DmClientMdmNtnltyCntry) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmClientMdmNtnltyCntry{" +
            "id=" + getId() +
            ", prtyFk='" + getPrtyFk() + "'" +
            ", frstNtnltFrmt='" + getFrstNtnltFrmt() + "'" +
            ", frstContinent='" + getFrstContinent() + "'" +
            ", scndNtnltFrmt='" + getScndNtnltFrmt() + "'" +
            ", scndContinent='" + getScndContinent() + "'" +
            ", thrdNtnltFrmt='" + getThrdNtnltFrmt() + "'" +
            ", thrdContinent='" + getThrdContinent() + "'" +
            ", frthNtnltFrmt='" + getFrthNtnltFrmt() + "'" +
            ", frthContinent='" + getFrthContinent() + "'" +
            ", techLineage='" + getTechLineage() + "'" +
            ", techCreatedDate='" + getTechCreatedDate() + "'" +
            ", techUpdatedDate='" + getTechUpdatedDate() + "'" +
            ", techMapping='" + getTechMapping() + "'" +
            ", techComment='" + getTechComment() + "'" +
            "}";
    }
}

package com.sbm.tableaurealtime.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.sbm.tableaurealtime.domain.DmClientMdmAddrCntry} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DmClientMdmAddrCntryDTO implements Serializable {

    private Long id;

    @NotNull
    private String prtyFk;

    private String frstCntryFrmt;

    private String frstContinent;

    private String scndCntryFrmt;

    private String scndContinent;

    private String thrdCntryFrmt;

    private String thrdContinent;

    private String frthCntryFrmt;

    private String frthContinent;

    private String techLineage;

    private LocalDate techCreatedDate;

    private LocalDate techUpdatedDate;

    private String techMapping;

    private String techComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrtyFk() {
        return prtyFk;
    }

    public void setPrtyFk(String prtyFk) {
        this.prtyFk = prtyFk;
    }

    public String getFrstCntryFrmt() {
        return frstCntryFrmt;
    }

    public void setFrstCntryFrmt(String frstCntryFrmt) {
        this.frstCntryFrmt = frstCntryFrmt;
    }

    public String getFrstContinent() {
        return frstContinent;
    }

    public void setFrstContinent(String frstContinent) {
        this.frstContinent = frstContinent;
    }

    public String getScndCntryFrmt() {
        return scndCntryFrmt;
    }

    public void setScndCntryFrmt(String scndCntryFrmt) {
        this.scndCntryFrmt = scndCntryFrmt;
    }

    public String getScndContinent() {
        return scndContinent;
    }

    public void setScndContinent(String scndContinent) {
        this.scndContinent = scndContinent;
    }

    public String getThrdCntryFrmt() {
        return thrdCntryFrmt;
    }

    public void setThrdCntryFrmt(String thrdCntryFrmt) {
        this.thrdCntryFrmt = thrdCntryFrmt;
    }

    public String getThrdContinent() {
        return thrdContinent;
    }

    public void setThrdContinent(String thrdContinent) {
        this.thrdContinent = thrdContinent;
    }

    public String getFrthCntryFrmt() {
        return frthCntryFrmt;
    }

    public void setFrthCntryFrmt(String frthCntryFrmt) {
        this.frthCntryFrmt = frthCntryFrmt;
    }

    public String getFrthContinent() {
        return frthContinent;
    }

    public void setFrthContinent(String frthContinent) {
        this.frthContinent = frthContinent;
    }

    public String getTechLineage() {
        return techLineage;
    }

    public void setTechLineage(String techLineage) {
        this.techLineage = techLineage;
    }

    public LocalDate getTechCreatedDate() {
        return techCreatedDate;
    }

    public void setTechCreatedDate(LocalDate techCreatedDate) {
        this.techCreatedDate = techCreatedDate;
    }

    public LocalDate getTechUpdatedDate() {
        return techUpdatedDate;
    }

    public void setTechUpdatedDate(LocalDate techUpdatedDate) {
        this.techUpdatedDate = techUpdatedDate;
    }

    public String getTechMapping() {
        return techMapping;
    }

    public void setTechMapping(String techMapping) {
        this.techMapping = techMapping;
    }

    public String getTechComment() {
        return techComment;
    }

    public void setTechComment(String techComment) {
        this.techComment = techComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DmClientMdmAddrCntryDTO)) {
            return false;
        }

        DmClientMdmAddrCntryDTO dmClientMdmAddrCntryDTO = (DmClientMdmAddrCntryDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, dmClientMdmAddrCntryDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmClientMdmAddrCntryDTO{" +
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

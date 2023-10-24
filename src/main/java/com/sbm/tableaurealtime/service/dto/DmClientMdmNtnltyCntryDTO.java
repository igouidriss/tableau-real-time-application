package com.sbm.tableaurealtime.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.sbm.tableaurealtime.domain.DmClientMdmNtnltyCntry} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DmClientMdmNtnltyCntryDTO implements Serializable {

    private Long id;

    @NotNull
    private String prtyFk;

    private String frstNtnltFrmt;

    private String frstContinent;

    private String scndNtnltFrmt;

    private String scndContinent;

    private String thrdNtnltFrmt;

    private String thrdContinent;

    private String frthNtnltFrmt;

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

    public String getFrstNtnltFrmt() {
        return frstNtnltFrmt;
    }

    public void setFrstNtnltFrmt(String frstNtnltFrmt) {
        this.frstNtnltFrmt = frstNtnltFrmt;
    }

    public String getFrstContinent() {
        return frstContinent;
    }

    public void setFrstContinent(String frstContinent) {
        this.frstContinent = frstContinent;
    }

    public String getScndNtnltFrmt() {
        return scndNtnltFrmt;
    }

    public void setScndNtnltFrmt(String scndNtnltFrmt) {
        this.scndNtnltFrmt = scndNtnltFrmt;
    }

    public String getScndContinent() {
        return scndContinent;
    }

    public void setScndContinent(String scndContinent) {
        this.scndContinent = scndContinent;
    }

    public String getThrdNtnltFrmt() {
        return thrdNtnltFrmt;
    }

    public void setThrdNtnltFrmt(String thrdNtnltFrmt) {
        this.thrdNtnltFrmt = thrdNtnltFrmt;
    }

    public String getThrdContinent() {
        return thrdContinent;
    }

    public void setThrdContinent(String thrdContinent) {
        this.thrdContinent = thrdContinent;
    }

    public String getFrthNtnltFrmt() {
        return frthNtnltFrmt;
    }

    public void setFrthNtnltFrmt(String frthNtnltFrmt) {
        this.frthNtnltFrmt = frthNtnltFrmt;
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
        if (!(o instanceof DmClientMdmNtnltyCntryDTO)) {
            return false;
        }

        DmClientMdmNtnltyCntryDTO dmClientMdmNtnltyCntryDTO = (DmClientMdmNtnltyCntryDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, dmClientMdmNtnltyCntryDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmClientMdmNtnltyCntryDTO{" +
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

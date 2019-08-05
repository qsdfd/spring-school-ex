package com.whatever.school.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SCHOOL_YEAR")
public class SchoolYear extends BaseEntity{

    @NotNull
    @NotBlank
    @Range(min = 2000, max = 2100)
    @Column(name = "START_YEAR")
    private int startYear;

    public SchoolYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return startYear + 1;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Override
    public String toString() {
        return startYear + " - " + getEndYear();
    }
}

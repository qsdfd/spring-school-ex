package com.whatever.school.domain;

import com.whatever.school.annotation.schoolNumber.ValidSchoolNumber;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SCHOOL_ACCOUNT")
@ValidSchoolNumber
public class SchoolAccount extends PersonDetails {

    @NotNull
    @NotBlank
    @Column(name = "NUMBER")
    private String number;

    @Enumerated(EnumType.STRING)
    private SchoolRole role;

    public SchoolAccount() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public SchoolRole getRole() {
        return role;
    }

    public void setRole(SchoolRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SchoolAccount{" +
                "number='" + number + '\'' +
                ", role=" + role +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", version=" + version +
                '}';
    }
}

package com.whatever.school.domain;

import com.whatever.school.domain.validators.ValidSchoolNumber;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "SCHOOL_ACCOUNT")
@ValidSchoolNumber
public class SchoolAccount extends Person {

    @NotNull
    @NotBlank
    @Column(name = "NUMBER")
    private String number;

    @Enumerated(EnumType.STRING)
    private SchoolRole role;

    public SchoolAccount(
            @NotNull @NotBlank @Size(min = 1, max = 30) String firstName,
            @NotNull @NotBlank @Size(min = 1, max = 30) String lastName,
            @NotNull @NotBlank @Email String email,
            @NotNull @NotBlank @Pattern(regexp = "^s[0-9]{6}$") String number,
            List<Program> programs) {
        super(firstName, lastName, email);
        this.number = number;
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

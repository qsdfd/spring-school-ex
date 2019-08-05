package com.whatever.school.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Person extends BaseEntity{
    @NotNull
    @NotBlank
    @Size(min = 1, max = 30)
    @Column(name = "FIRST_NAME")
    protected String firstName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 30)
    @Column(name = "LAST_NAME")
    protected String lastName;

    @NotNull
    @NotBlank
    @Email
    @Column(name = "EMAIL", unique = true)
    protected String email;

    protected Person(@NotNull @NotBlank @Size(min = 1, max = 30) String firstName, @NotNull @NotBlank @Size(min = 1, max = 30) String lastName, @NotNull @NotBlank @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

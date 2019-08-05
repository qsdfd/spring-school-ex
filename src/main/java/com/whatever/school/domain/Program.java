package com.whatever.school.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "PROGRAM")
public class Program extends BaseEntity {

    @NotNull
    @NotBlank
    @ManyToOne(fetch = FetchType.EAGER)
    private SchoolYear schoolYear;

    @NotNull
    @NotBlank
    @ManyToOne(fetch = FetchType.EAGER)
    private SchoolAccount schoolAccount;

    @NotNull
    @NotBlank
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable()
    private Set<Course> courses;

    public Integer getTotalStudyPoints(){
        Integer sumOfStudyPoints = courses.stream().mapToInt(c -> c.getStudyPoints()).sum();
        return sumOfStudyPoints;
    }

    public Program(@NotNull @NotBlank SchoolYear schoolYear, @NotNull @NotBlank Set<Course> courses) {
        this.schoolYear = schoolYear;
        this.courses = courses;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}

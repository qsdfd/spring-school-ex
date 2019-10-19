package com.whatever.school.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "COURSE")
public class Course extends BaseEntity{

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "STUDY_POINTS")
    private Integer studyPoints;

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudyPoints() {
        return studyPoints;
    }

    public void setStudyPoints(Integer studyPoints) {
        this.studyPoints = studyPoints;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", studyPoints=" + studyPoints +
                ", id=" + id +
                ", version=" + version +
                '}';
    }
}

package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "educationDegree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationDegreeId;
    private String educationDegreeName;
    @OneToMany(mappedBy = "educationDegrees")
    private Set<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(String educationDegreeName, Set<Employee> employees) {
        this.educationDegreeName = educationDegreeName;
        this.employees = employees;
    }

    public Long getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Long educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}

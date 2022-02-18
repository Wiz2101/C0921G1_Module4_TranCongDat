package com.codegym.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private Long employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    @ManyToOne
    @JoinColumn (name = "position_id",referencedColumnName = "positionId")
    private Position positions;

    @ManyToOne
    @JoinColumn (name = "educationDegree_id", referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegrees;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    @ManyToOne
    @JoinColumn (name = "division_id",referencedColumnName = "divisionId")
    private Division divisions;

    @OneToOne
    @JoinColumn (name = "user",referencedColumnName = "user")
    private User users;

    public Employee() {
    }

    public Employee(String employeeName, String employeeBirthday, String employeeIdCard, Long employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Position positions, EducationDegree educationDegrees, Division divisions, User users) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positions = positions;
        this.educationDegrees = educationDegrees;
        this.divisions = divisions;
        this.users = users;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPositions() {
        return positions;
    }

    public void setPositions(Position positions) {
        this.positions = positions;
    }

    public EducationDegree getEducationDegrees() {
        return educationDegrees;
    }

    public void setEducationDegrees(EducationDegree educationDegrees) {
        this.educationDegrees = educationDegrees;
    }

    public Division getDivisions() {
        return divisions;
    }

    public void setDivisions(Division divisions) {
        this.divisions = divisions;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}

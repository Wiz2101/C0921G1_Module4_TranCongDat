package com.codegym.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    private String user;
    private String password;
    @OneToOne (mappedBy = "users")
    private Employee employee;

    @OneToMany (mappedBy = "users", fetch = FetchType.EAGER)
    private List<UserRole> userRoles;

    public User() {
    }

    public User(String user, String password, Employee employee, List<UserRole> userRoles) {
        this.user = user;
        this.password = password;
        this.employee = employee;
        this.userRoles = userRoles;
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public User(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}

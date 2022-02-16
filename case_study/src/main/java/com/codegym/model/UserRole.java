package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userRoleId;
    @ManyToOne
    @JoinColumn (name = "role_id", referencedColumnName = "roleId")
    private Role roles;

    @ManyToOne
    @JoinColumn (name = "username", referencedColumnName = "user")
    private User users;

    public UserRole() {
    }

    public UserRole(Role roles, User users) {
        this.roles = roles;
        this.users = users;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}

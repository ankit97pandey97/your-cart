package com.yourcart.Entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles extends IdGeneratorClass{

    @Column(name = "role")
    private String role;

    public Roles() {
    }

    public Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

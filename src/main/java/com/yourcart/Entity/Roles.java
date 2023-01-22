package com.yourcart.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "roles")
public class Roles extends IdGeneratorClass{

    @Column(name = "role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

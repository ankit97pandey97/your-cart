package com.yourcart.Entity;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends IdGeneratorClass{

    public User() {
    }

    @Column(name = "username")
    private String userName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "pass_word")
    private String password;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Roles role;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userdetail_id")
    private UserDetails userDetails;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public User(String userName, String firstName, String lastName, String password, Roles role, UserDetails userDetails) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.userDetails = userDetails;
    }

    public User(Integer id,String userName, String firstName, String lastName, String password, Roles role, UserDetails userDetails) {
        this.setId(id);
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.userDetails = userDetails;
    }

}

package com.yourcart.Entity;

import javax.persistence.*;

@Entity
@Table(name = "userdetails")
public class UserDetails extends IdGeneratorClass{

    public UserDetails() {
    }
    @Column(name = "street")
    private String street;

    @Column(name = "colony")
    private String colony;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pinCode;

    @Column(name = "country")
    private String country;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserDetails(int id, String street, String colony, String city, String state, String pinCode, String country) {
        this.setId(id);
        this.street = street;
        this.colony = colony;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.country = country;
    }

    public UserDetails(String street, String colony, String city, String state, String pinCode, String country) {
        this.street = street;
        this.colony = colony;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + this.getId() +
                ", street='" + street + '\'' +
                ", colony='" + colony + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

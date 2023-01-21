package com.yourcart.rest;

public class RestUserDetails {

    public RestUserDetails() {
    }

    private int id;

    private String street;

    private String colony;

    private String city;

    private String state;

    private String pinCode;

    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public RestUserDetails(int id, String street, String colony, String city, String state, String pinCode, String country) {
        this.id = id;
        this.street = street;
        this.colony = colony;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.country = country;
    }

    public RestUserDetails(String street, String colony, String city, String state, String pinCode, String country) {
        this.street = street;
        this.colony = colony;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return "RestUserDetails{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", colony='" + colony + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", Country='" + country + '\'' +
                '}';
    }
}

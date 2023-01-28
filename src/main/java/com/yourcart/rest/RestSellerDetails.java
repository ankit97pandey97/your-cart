package com.yourcart.rest;

public class RestSellerDetails {

    private Integer id;

    private Integer sellerRating;

    public RestSellerDetails() {
    }

    public RestSellerDetails(Integer id, Integer sellerRating, RestProduct product) {
        this.id = id;
        this.sellerRating = sellerRating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(Integer sellerRating) {
        this.sellerRating = sellerRating;
    }

}

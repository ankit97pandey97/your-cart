package com.yourcart.rest;

import com.yourcart.Entity.SellerDetails;

public class RestProductAndDetails {

    private RestProduct restProduct;

    private RestProductDetails restProductDetails;

    private RestCategory restCategory;

    private RestSellerDetails restSellerDetails;

    public RestProduct getRestProduct() {
        return restProduct;
    }

    public void setRestProduct(RestProduct restProduct) {
        this.restProduct = restProduct;
    }

    public RestProductDetails getRestProductDetails() {
        return restProductDetails;
    }

    public void setRestProductDetails(RestProductDetails restProductDetails) {
        this.restProductDetails = restProductDetails;
    }

    public RestCategory getRestCategory() {
        return restCategory;
    }

    public void setRestCategory(RestCategory restCategory) {
        this.restCategory = restCategory;
    }

    public RestSellerDetails getRestSellerDetails() {
        return restSellerDetails;
    }

    public void setRestSellerDetails(RestSellerDetails restSellerDetails) {
        this.restSellerDetails = restSellerDetails;
    }
}

package com.yourcart.rest;

import com.yourcart.Entity.SellerDetails;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder;

public class RestProductDetails {
    private Integer id;

    private String productCode;

    public RestProductDetails() {
    }

    public RestProductDetails(Integer id, String productCode) {
        this.id = id;
        this.productCode = productCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

}

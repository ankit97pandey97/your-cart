package com.yourcart.Entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@CrossOrigin
@Table(name = "sellerDetails")
public class SellerDetails extends IdGeneratorClass {

    //find name and other details of seller through user table

   private int sellerRating;

   @OneToOne(mappedBy = "sellers")
   private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(int sellerRating) {
        this.sellerRating = sellerRating;
    }
}

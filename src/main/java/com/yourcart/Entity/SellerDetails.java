package com.yourcart.Entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@CrossOrigin
@Table(name = "sellerDetails")
public class SellerDetails extends IdGeneratorClass {

    //find name and other details of seller through user table

   @JoinColumn(name = "seller_rating")
   private int sellerRating;

    public int getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(int sellerRating) {
        this.sellerRating = sellerRating;
    }
}

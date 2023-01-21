package com.yourcart.Entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;

@Entity
@CrossOrigin
@Table(name = "sellerDetails")
public class SellerDetails extends IdGeneratorClass {

    private int sellerId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

}

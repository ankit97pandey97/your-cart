package com.yourcart.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends IdGeneratorClass{

    @Column(name = "product_name")
    private String productName;

    @Column(name = "category")
    private String category;

    @OneToOne()
    @JoinColumn(name = "product_code")
    private ProductDetails productDetails;


    @OneToMany(mappedBy = "product")
    public List<SellerDetails>  sellers;


    public String getCategory() {
        return category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

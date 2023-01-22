package com.yourcart.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends IdGeneratorClass{

    @Column(name = "product_name")
    private String productName;

    @Column(name = "category")
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne()
    @JoinColumn(name = "product_code")
    private ProductDetails productDetails;



  @OneToOne
  @JoinColumn(name = "product_id")
    public SellerDetails  sellers;

    public SellerDetails getSellers() {
        return sellers;
    }

    public void setSellers(SellerDetails sellers) {
        this.sellers = sellers;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}

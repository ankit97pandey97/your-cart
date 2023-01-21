package com.yourcart.Entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;

@Entity
@CrossOrigin
@Table(name = "productDetails")
public class ProductDetails extends IdGeneratorClass {
    @Column(name = "product_code")
    private String productCode;



    public String getProductCode() {
        return productCode;
    }


    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

}

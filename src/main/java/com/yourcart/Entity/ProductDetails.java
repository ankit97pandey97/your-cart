package com.yourcart.Entity;
import javax.persistence.*;

@Entity
@Table(name = "productDetails")
public class ProductDetails extends IdGeneratorClass {
    @Column(name = "product_code")
    private String productCode;

    @OneToOne()
    @JoinColumn(name = "seller_id")
    private SellerDetails sellerDetails;


    public String getProductCode() {
        return productCode;
    }



    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

}

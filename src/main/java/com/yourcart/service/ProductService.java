package com.yourcart.service;

import com.yourcart.Dao.ProductDao;
import com.yourcart.Entity.Product;
import com.yourcart.rest.RestProduct;
import com.yourcart.rest.RestProductAndDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductDao productDao;

    public RestProductAndDetails getProductById(Integer id){
        return convertToRestProductAndDetails(productDao.getProductById(id));
    }

    public RestProductAndDetails convertToRestProductAndDetails(Product product){
        RestProductAndDetails restProductAndDetails= new RestProductAndDetails();
        restProductAndDetails.getRestProduct().setId(product.getId());
        restProductAndDetails.getRestProduct().setProductName(product.getProductName());
        restProductAndDetails.getRestProductDetails().setProductCode(product.getProductDetails().getProductCode());
        restProductAndDetails.getRestProductDetails().setId(product.getProductDetails().getId());
        restProductAndDetails.getRestSellerDetails().setId(product.getSellers().getId());
        restProductAndDetails.getRestSellerDetails().setSellerRating(product.getSellers().getSellerRating());
        restProductAndDetails.getRestCategory().setId(product.getCategory().getId());
        restProductAndDetails.getRestCategory().setCategory(product.getCategory().getCategory());
        return restProductAndDetails;
    }

    public void convertToProduct(RestProductAndDetails restProductAndDetails){
        Product product = new Product();
        product.setId(restProductAndDetails.getRestProduct().getId());
        product.setProductName(restProductAndDetails.getRestProduct().getProductName());
        product.getProductDetails().setId(restProductAndDetails.getRestProductDetails().getId());
        product.getProductDetails().setProductCode(restProductAndDetails.getRestProductDetails().getProductCode());

    }
}

package com.yourcart.controllers;

import com.yourcart.rest.RestProduct;
import com.yourcart.rest.RestProductAndDetails;
import com.yourcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/:{id}")
    public RestProductAndDetails getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @PostMapping("/{:id}")
    public void postProduct(@RequestBody RestProductAndDetails restProductAndDetails){
    }



}

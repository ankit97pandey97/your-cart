package com.yourcart.Dao;

import com.yourcart.Entity.Product;
import com.yourcart.rest.RestProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

    @Autowired
    SessionFactory sessionFactory;

    public Product getProductById(Integer id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class,id);
    }

}

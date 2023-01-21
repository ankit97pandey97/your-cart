//package com.yourcart.Dao;
//
//import com.yourcart.Entity.User;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class CommonDao<T> {
//    private T t;
//
//    public T getT() {
//        return t;
//    }
//
//    public void setT(T t) {
//        this.t = t;
//    }
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public T getById(int id){
//        Session session = sessionFactory.getCurrentSession();
//        T t = session.get(T,id);
//        return t;
//
//    }
//}

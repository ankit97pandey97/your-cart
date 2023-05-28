package com.yourcart.Dao;

import com.yourcart.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public User getUserById(int id){
        Session session = sessionFactory.getCurrentSession();
        return  session.get(User.class,id);
    }

    public List<User> getAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        Query qry = session.createQuery("from User");
        return qry.list();
    }
    public User getUserByUserName(String username){
        System.out.println("username");
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User u where u.userName =:username",User.class).setParameter("username",username).uniqueResult();

    }
    public void postUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
}

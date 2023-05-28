package com.yourcart.service;

import com.yourcart.Dao.UserDao;
import com.yourcart.Entity.User;
import com.yourcart.rest.RestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceCustom {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public RestUser getUserById(int id) {
        User user = userDao.getUserById(id);
        return userToRest(user);
    }

    public void postUser(RestUser tempUser){
        userDao.postUser(restUserToUser(tempUser));
    }

    public User getUserByUserName(String userName){
        return userDao.getUserByUserName(userName);

    }

    public List<RestUser> getAllUsers(){
       List<User> users = userDao.getAllUsers();
       List<RestUser> restUsers = new ArrayList<>();
       for (User user : users){
           restUsers.add(userToRest(user));
       }
       return restUsers;
    }

   public RestUser userToRest(User user){
        RestUser temp = new RestUser();
        temp.setFirstName(user.getFirstName());
        temp.setUserName(user.getUserName());
        temp.setPassword(user.getPassword());
        temp.setLastName(user.getLastName());
        temp.setUserDetails(user.getUserDetails());
        temp.setRoles(user.getRole());
        if (user.getId() != 0){
            temp.setId(user.getId());
        }
        return temp;
   }
   public User restUserToUser(RestUser user){
       User temp = new User();
        temp.setFirstName(user.getFirstName());
        temp.setUserName(user.getUserName());
       String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
       System.out.println(encodedPassword);
//       nUser.setPassword(encodedPassword);
        temp.setPassword(encodedPassword);
        temp.setLastName(user.getLastName());
        temp.setRole(user.getRoles());
        temp.setUserDetails(user.getUserDetails());

        return temp;
   }

    public List<RestUser> getUsersByIds(List<Integer> ids) {
        List<RestUser> restUsers = new ArrayList<>();
        for (int id : ids){
            restUsers.add(userToRest(userDao.getUserById(id)));
        }
        return restUsers;
    }
}

package com.yourcart.service;

import com.yourcart.Entity.CustomUserDetails;
import com.yourcart.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserServiceCustom userServiceCustom;

    public CustomUserDetailService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userServiceCustom.getUserByUserName(username);
        if(user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }else {
            System.out.println("222222223333333");
            CustomUserDetails temp =  new CustomUserDetails(user);
            return temp;
        }
    }
}

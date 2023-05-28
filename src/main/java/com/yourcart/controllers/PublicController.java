package com.yourcart.controllers;

import com.yourcart.config.TokenProvider;
import com.yourcart.rest.RestLoginUser;
import com.yourcart.service.CustomUserDetailService;
import com.yourcart.service.UserServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PublicController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;
    @Autowired
    private UserServiceCustom userServiceCustom;
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @PostMapping("/public/login")
    public ResponseEntity<?> login(@RequestBody RestLoginUser loginUser){
        try{
            final Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            loginUser.getUserName(),
                            loginUser.getPassword()
                    )
            );
            System.out.println("2222");
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            System.out.println("33333");
            final String token = jwtTokenUtil.generateToken(authenticate);
            System.out.println("4444444");
            return ResponseEntity.ok(token);
        }catch (Exception e){
           e.printStackTrace();
        }

return null;
    }


}

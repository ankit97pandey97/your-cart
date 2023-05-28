package com.yourcart.config;

import com.yourcart.Entity.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name="customUserDetailService")
    private UserDetailsService userDetailsService1;
//    @Autowired
//    private CustomUserDetails customUserDetails;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable().authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/api/**").hasRole("BUYER")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "BUYER")
                .anyRequest().authenticated().and()
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

//        .and()
//                .formLogin()
//                .loginPage("/login-page")
//                .loginProcessingUrl("/authenticateTheUser")
//                .permitAll();
//        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        UserBuilder users = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser(users.username("john").password("12345").roles("EMPLOYEE"))
//                .withUser(users.username("marry").password("123456").roles("MANAGER"))
//                .withUser(users.username("susan").password("123457").roles("ADMIN"))
//                .withUser(users.username("ankit").password("123458").roles("CEO"));
        auth.userDetailsService(userDetailsService1).passwordEncoder(encoder());
    }

    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}

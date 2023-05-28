//package com.yourcart.config;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class TokenAuthenticationFilter extends OncePerRequestFilter {
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        String token = extractToken(httpServletRequest);
//
//        if (token != null && isValidToken(token)) {
//            Authentication authentication = new UsernamePasswordAuthenticationToken(token, null);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//
//        filterChain.doFilter(httpServletRequest, httpServletResponse);
//    }
//
//    private String extractToken(HttpServletRequest request) {
//        // Extract the token from the request, e.g., from a header or a query parameter
//        // Return null if no token is found
//        return null;
//    }
//
//    private boolean isValidToken(String token) {
//        // Perform token validation logic
//        // Return true if the token is valid, false otherwise
//        return false;
//    }
//}

package com.livraison.Livraison.security;

import com.livraison.Livraison.filter.JwtAccessDeniedHandler;
import com.livraison.Livraison.filter.JwtAuthEntryPoint;
import com.livraison.Livraison.filter.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityConfigiration extends WebSecurityConfigurerAdapter {

 private JwtAuthFilter jwtAuthFilter;
 private JwtAccessDeniedHandler jwtAccessDeniedHandler;
 private JwtAuthEntryPoint jwtAuthEntryPoint;
 private UserDetailsService userDetailsService;
 private BCryptPasswordEncoder bCryptPasswordEncoder;
@Autowired
    public SecurityConfigiration(JwtAuthFilter jwtAuthFilter, JwtAccessDeniedHandler jwtAccessDeniedHandler, JwtAuthEntryPoint jwtAuthEntryPoint, UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
        this.jwtAuthEntryPoint = jwtAuthEntryPoint;
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}

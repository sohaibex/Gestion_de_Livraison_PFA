package com.livraison.Livraison.security;

import com.livraison.Livraison.filter.JwtAccessDeniedHandler;
import com.livraison.Livraison.filter.JwtAuthEntryPoint;
import com.livraison.Livraison.filter.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfigiration extends WebSecurityConfigurerAdapter {


//Configuration du spring securite
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
              //activation du cors qui permet de communiquer avec plusiers systemes
              .cors().and()
              //desactivation du crf parce qu'on a pas un formulaire
              .csrf().disable()
//autorisation seulement Post request de la route /users
              .authorizeRequests()
              .antMatchers((HttpMethod.POST),"/users")
              .permitAll()
              //tous les autres methodes doivent etre connecte
              .anyRequest().authenticated();
    }


}

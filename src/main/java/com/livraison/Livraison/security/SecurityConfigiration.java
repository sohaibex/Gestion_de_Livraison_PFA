package com.livraison.Livraison.security;


import com.livraison.Livraison.services.UserService;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class SecurityConfigiration extends WebSecurityConfigurerAdapter {

    private final UserService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//initialisation des attributs avec le contructeur
    public SecurityConfigiration(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

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

    // configure adapter donne la possibilite de creer une instance de la personne authentifier
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }


}
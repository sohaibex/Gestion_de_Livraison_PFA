package com.livraison.Livraison.security;

public class SecurityConstants {

//expiration du token
    public static final long EXPIRATION_TIME = 864000000; // 10 Days
    //prefix du token il doit commancer par bearer
    public static final String TOKEN_PREFIX = "Bearer ";
    //header string authorization
    public static final String HEADER_STRING = "Authorization";
    //sign up url les routes que je veux les autorises
    public static final String SIGN_UP_URL = "/users";
    //token key secret
    public static final String TOKEN_SECRET = "dfg893hdc475zwerop4tghg4ddfdfgdsdfeqaas?=-0ljznm0-9";
}

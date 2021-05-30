package com.livraison.Livraison.security;

public class SecurityConstant {

    //Date d'expiration du token
    public static  final long EXIPRATION_TIME = 432_000_000; //5 days
    //Token header Barer token
    public static final String TOKEN_PREFIX="Bearer";
    //the JWT TOKEN
    public static final String JWT_TOKEN_HEADER="Jwt-Token";
    //message d'erreur si le token ne peut pas etre verifier
    public static final String TOKEN_CANNOT_BE_VERIFIED="Token cannot be verified";
    //
    public static final String Get_ARRAYS_LLC="Get Arrays,LLC";
    //
    public static final String Get_Arrays_ADMINISTRATION="User Management Portal";
    //
    public static final String AUTHORITIES="Authorities";
    //
    public static final String FORBIDDEN_MESSAGE="you need to login to access to your dashboard";
    //
    public static final String ACCESS_DENIED_MESSAGE="You don't have the permission to access this page";
    //
    public static final String OPTIONS_HTTP_METHOD="OPTIONS";
    //
    public static final String[]PUBLIC_URLS={"/user/login","/user/register","/user/resetpassword/**"};





}

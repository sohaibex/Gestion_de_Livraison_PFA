package com.livraison.Livraison.jwt;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.livraison.Livraison.models.UserPrincipal;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.livraison.Livraison.security.SecurityConstant.*;
import static java.util.Arrays.stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import com.auth0.jwt.JWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {
    @Value("${jwt}")
    private String secret;

    //method that generates jwt token to pass requests
    public String generateJwtToken(UserPrincipal userPrincipal) {
        String[] claims = getClaimsFromUser(userPrincipal);

        return
                //creation du jwt (json web token )
                JWT.create()
                        //if the token came from another api
                        .withIssuer(Get_ARRAYS_LLC)
                        //
                        .withAudience(Get_Arrays_ADMINISTRATION)
                        //if we ave an issue get the date of the issue
                        .withIssuedAt(new Date())
                        //get the username
                        .withSubject(userPrincipal.getUsername())
                        //get the authorisations
                        .withArrayClaim(AUTHORITIES, claims)
                        //the time when the jwt is expired
                        .withExpiresAt(new Date(System.currentTimeMillis() + EXIPRATION_TIME))
                        // the hash sign method HMAC512
                        .sign(HMAC512(secret.getBytes()));

    }


    //methode that get authorities

    public List<GrantedAuthority> getAuthorities(String token) {
        String[] claims = getClaimsFromToken(token);
        return stream(claims).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }



    //methode that get claims from the role
    private String[] getClaimsFromToken(String token) {
        JWTVerifier verifier = getJWTVerifier();
        return verifier.verify(token).getClaim(AUTHORITIES).asArray(String.class);

    }



    private JWTVerifier getJWTVerifier() {
        JWTVerifier verfier;
        try {
            Algorithm algorithm = HMAC512(secret);
            verfier = JWT.require(algorithm).withIssuer(Get_ARRAYS_LLC).build();
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException(TOKEN_CANNOT_BE_VERIFIED);
        }
        return verfier;
    }

    private String[] getClaimsFromUser(UserPrincipal user) {
        List<String> authorities = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : user.getAuthorities()) {
            authorities.add(grantedAuthority.getAuthority());
        }
        return authorities.toArray(new String[0]);
    }

    public Authentication getAuthentification(String username, List<GrantedAuthority>
            authorities, HttpServletRequest request)
    {
        UsernamePasswordAuthenticationToken userPasswordAuthToken
                = new UsernamePasswordAuthenticationToken(username,null,authorities);
        userPasswordAuthToken.setDetails((new WebAuthenticationDetailsSource().buildDetails(request)));
         return userPasswordAuthToken;
    }



    public boolean isTokenValid(String username,String token)
    {
JWTVerifier verifier=getJWTVerifier();
return StringUtils.isNoneEmpty(username) && !isTokenExpired(verifier,token);

    }

    private boolean isTokenExpired(JWTVerifier verifier, String token) {
        Date expiration = verifier.verify(token).getExpiresAt();
        return  expiration.before(new Date());
    }

    public String getSubject(String token)
    {
        JWTVerifier verifier=getJWTVerifier();
        return verifier.verify(token).getSubject();
    }


}

package io.gopulu.javasecurityjwt.security;

import io.gopulu.javasecurityjwt.model.JWTUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import org.springframework.stereotype.Component;

import java.util.Base64;
import java.security.Key;

/**
 * Created by lingrajmahanand on 3/28/18.
 */
@Component
public class JWTGenerator {


    public String generate(JWTUser jwtUser) {
        //Here we can also set token expiry but for the sake of brevity
        //token expiry is now infinite
        Claims claims = Jwts.claims().setSubject(jwtUser.getUsername());
        claims.put("password",jwtUser.getPassword());

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,SecretSign.getBase64SecretBytes()).compact();
    }
}

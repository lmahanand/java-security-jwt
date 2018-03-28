package io.gopulu.javasecurityjwt.security;

import io.gopulu.javasecurityjwt.model.JWTUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

/**
 * Created by lingrajmahanand on 3/28/18.
 *
 * it uses the token to get the user details
 */

@Component
public class JWTValidator {
    public JWTUser validate(String token) {

        JWTUser jwtUser = null;

        try{
            Claims body = Jwts.parser()
                    .setSigningKey(SecretSign.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JWTUser();
            jwtUser.setUsername(body.getSubject());

            jwtUser.setPassword((String)body.get("password"));
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }


        return jwtUser;
    }
}

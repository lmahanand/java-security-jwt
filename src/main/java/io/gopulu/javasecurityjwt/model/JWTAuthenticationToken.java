package io.gopulu.javasecurityjwt.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by lingrajmahanand on 3/28/18.
 * Token will be held by this class
 */
public class JWTAuthenticationToken extends UsernamePasswordAuthenticationToken{
    private String token;
    public JWTAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}

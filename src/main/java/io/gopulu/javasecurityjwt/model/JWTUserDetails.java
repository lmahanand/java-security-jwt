package io.gopulu.javasecurityjwt.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by lingrajmahanand on 3/28/18.
 */
public class JWTUserDetails implements UserDetails {

    private String username;
    private String password;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;

    public JWTUserDetails(String username, String password, String token, List<GrantedAuthority> grantedAuthorities) {
        this.username = username;
        this.password = password;
        this.token = token;
        this.authorities = grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    public String getToken() {
        return token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}

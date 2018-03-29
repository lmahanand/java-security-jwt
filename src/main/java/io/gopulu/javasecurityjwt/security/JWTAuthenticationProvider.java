package io.gopulu.javasecurityjwt.security;

import io.gopulu.javasecurityjwt.model.JWTAuthenticationToken;
import io.gopulu.javasecurityjwt.model.JWTUser;
import io.gopulu.javasecurityjwt.model.JWTUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lingrajmahanand on 3/28/18.
 */
@Component
public class JWTAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{
    private static final Logger logger = LoggerFactory.getLogger(JWTAuthenticationProvider.class);

    @Autowired
    private JWTValidator jwtValidator;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        JWTAuthenticationToken jwtAuthenticationToken = (JWTAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();

        // now validate if token is correct
        JWTUser jwtUser = jwtValidator.validate(token);

        if(jwtUser == null){
            logger.error("JWT Token is incorrect");
            throw new RuntimeException("JWT Token is incorrect");
        }

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                                                    .commaSeparatedStringToAuthorityList(jwtUser.getRole());
        //jwtUser
        return new JWTUserDetails(jwtUser.getUsername(), jwtUser.getPassword(), token,grantedAuthorities);

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return JWTAuthenticationToken.class.isAssignableFrom(aClass);
    }
}

package io.gopulu.javasecurityjwt.security;

import io.gopulu.javasecurityjwt.model.JWTAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lingrajmahanand on 3/28/18.
 */
public class JWTAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        String header = httpServletRequest.getHeader("Authorization");

        if(header == null || !header.startsWith("Token ")){
            throw new RuntimeException("JWT is missing.");
        }

        String authenticationToken = header.substring(6);

        JWTAuthenticationToken token = new JWTAuthenticationToken(authenticationToken);



        return getAuthenticationManager().authenticate(token);
    }

    //This filter will be hit for every request
    public JWTAuthenticationTokenFilter() {
        super("/app/**");
    }
}

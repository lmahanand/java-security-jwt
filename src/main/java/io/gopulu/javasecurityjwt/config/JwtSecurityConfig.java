package io.gopulu.javasecurityjwt.config;

import io.gopulu.javasecurityjwt.security.JWTAuthenticationTokenFilter;
import io.gopulu.javasecurityjwt.security.JWTAuthenticationProvider;
import io.gopulu.javasecurityjwt.security.JwtSuccessHandler;
import io.gopulu.javasecurityjwt.security.JWTAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

/**
 * Created by lingrajmahanand on 3/28/18.
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private JWTAuthenticationProvider authenticationProvider;
    @Autowired
    private JWTAuthenticationEntryPoint entryPoint;

    //Authentication manager
    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }

// JWT custom filters are used.

    @Bean
    public JWTAuthenticationTokenFilter authenticationTokenFilter(){
        JWTAuthenticationTokenFilter filter = new JWTAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //authenticationEntryPoint redirects the error messages
        //Session is stateless
        http.csrf().disable()
                .authorizeRequests().antMatchers("**/app/**").authenticated()
                .and().exceptionHandling().authenticationEntryPoint(entryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //Filters are added and it should be loaded before UsernamePasswordAuthenticationFilter

        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        http.headers().cacheControl();
    }
}

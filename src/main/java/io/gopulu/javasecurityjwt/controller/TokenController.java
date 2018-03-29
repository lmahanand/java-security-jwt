package io.gopulu.javasecurityjwt.controller;

import io.gopulu.javasecurityjwt.model.JWTUser;
import io.gopulu.javasecurityjwt.security.JWTGenerator;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lingrajmahanand on 3/28/18.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/token")
public class TokenController {

    private static final Logger logger = LoggerFactory.getLogger(TokenController.class);

    private  JWTGenerator jwtGenerator;

    public TokenController(JWTGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generateToken(@RequestBody final JWTUser jwtUser){
        //For the sake of brevity user id and password are hard coded.
        if(jwtUser.getUsername().isEmpty() || jwtUser.getPassword().isEmpty()){
            logger.error("Username and password are empty.");
            throw new RuntimeException("Please provide username and password.");
        }

        if(jwtUser.getUsername().equals("admin") && jwtUser.getPassword().equals("123"))
        return jwtGenerator.generate(jwtUser);
        else {
            logger.error("Invalid credentials.");
            throw new RuntimeException("Invalid credentials.");
        }
    }

}

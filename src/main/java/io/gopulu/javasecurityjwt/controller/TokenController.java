package io.gopulu.javasecurityjwt.controller;

import io.gopulu.javasecurityjwt.model.JWTUser;
import io.gopulu.javasecurityjwt.security.JWTGenerator;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lingrajmahanand on 3/28/18.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/token")
public class TokenController {

    private  JWTGenerator jwtGenerator;

    public TokenController(JWTGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generateToken(@RequestBody final JWTUser jwtUser){
        if(jwtUser.getUsername().isEmpty() || jwtUser.getPassword().isEmpty()){
            throw new RuntimeException("Please provide username and password.");
        }

        if(jwtUser.getUsername().equals("admin") && jwtUser.getPassword().equals("123"))
        return jwtGenerator.generate(jwtUser);
        else {
            throw new RuntimeException("Invalid credentials.");
        }
    }

}

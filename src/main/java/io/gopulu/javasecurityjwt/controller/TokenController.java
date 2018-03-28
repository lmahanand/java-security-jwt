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
        return jwtGenerator.generate(jwtUser);
    }

}

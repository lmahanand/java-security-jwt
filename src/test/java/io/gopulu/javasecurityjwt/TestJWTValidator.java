package io.gopulu.javasecurityjwt;

import io.gopulu.javasecurityjwt.model.JWTUser;
import io.gopulu.javasecurityjwt.security.JWTValidator;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class TestJWTValidator {
    @Test
    public void validate(){

        JWTValidator jwtValidator = new JWTValidator();
        JWTUser jwtUser =jwtValidator.validate("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInBhc3N3b3JkIjoiMTIzIn0.KU9eM8tTWYCSnQIrXf21dCeOmgaM6ZQySJ0OkAlsn_g");
        assertNull(jwtUser);
    }
}

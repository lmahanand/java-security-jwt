package io.gopulu.javasecurityjwt;

import io.gopulu.javasecurityjwt.model.JWTUser;
import io.gopulu.javasecurityjwt.security.JWTGenerator;
import org.junit.Test;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
public class TestJWTGenerator {
    @Test
    public void generate(){
        JWTUser jwtUser = new JWTUser();
        jwtUser.setUsername("admin");
        jwtUser.setPassword("123");

        JWTGenerator jwtGenerator = new JWTGenerator();

        final String jwt = jwtGenerator.generate(jwtUser);
        System.out.println(jwt);
        assertNotNull(jwt);
        assertTrue(!jwt.isEmpty());

    }
}

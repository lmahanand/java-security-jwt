package io.gopulu.javasecurityjwt.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;

/**
 * Created by lingrajmahanand on 3/28/18.
 */
public class SecretSign {
    private static final Key secret = MacProvider.generateKey(SignatureAlgorithm.HS256);
    private static final byte[] secretBytes = secret.getEncoded();
    private static final String base64SecretBytes = java.util.Base64.getEncoder().encodeToString(secretBytes);

    public static String getBase64SecretBytes(){
        return base64SecretBytes;
    }

    public static Key getSecretKey(){
        return secret;
    }
}

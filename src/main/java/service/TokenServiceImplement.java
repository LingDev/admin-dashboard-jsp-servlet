/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.UUID;
import model.AuthenticatedUserBean;

/**
 *
 * @author vando
 */
public class TokenServiceImplement {

    private static final long TOKEN_EXPIRY = 1000 * 60 * 60 * 24; // 1 day

    private final KeyPair keyPair;

    public TokenServiceImplement() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(new FileInputStream("C:\\Program Files\\Java\\jdk-13.0.2\\bin\\hanbotest.jks"), "123test321".toCharArray());
            Key key = keyStore.getKey("hanbotest", "123test321".toCharArray());
            if (key instanceof PrivateKey) {
                // Get the certificate
                Certificate cert = keyStore.getCertificate("hanbotest");

                // Get Public Key
                PublicKey pubKey = cert.getPublicKey();
                this.keyPair = new KeyPair(pubKey, (PrivateKey) key);
            } else {
                throw new IOException("Failed to read KeyStore");
            }
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException | UnrecoverableKeyException e) {

            throw new RuntimeException(e);
        }
    }

    public String generateToken(AuthenticatedUserBean details) {
        if (details == null) {
            throw new IllegalArgumentException("User details must not be null");
        }
        final Date now = new Date();
        final String jti = UUID.randomUUID().toString();

        return Jwts.builder().signWith(keyPair.getPrivate(), SignatureAlgorithm.RS256)
                .setSubject(details.getUserName())
                .claim("userId", details.getUserId())
                .claim("roles", details.getRoles())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + TOKEN_EXPIRY))
                .setId(jti)
                .compact();
    }

    public  boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(keyPair.getPublic()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public  AuthenticatedUserBean getUserDetailsFromToken(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            Claims claims = Jwts.parser().setSigningKey(keyPair.getPublic()).parseClaimsJws(token.replace("Bearer ", "")).getBody();
            return new AuthenticatedUserBean(claims.getSubject(), (int) claims.get("userId"), (String) claims.get("roles"));
        }
        return null;
    }

    public  String getTokenId(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            Claims claims = Jwts.parser().setSigningKey(keyPair.getPublic()).parseClaimsJws(token.replace("Bearer ", "")).getBody();
            return claims.getId();
        }
        return null;
    }
}

package org.example.service;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class TokenService {

//    @Value("${app-config.jwt.secret}")
//    private String secret;
//
//    public String tokenGenerate(String numberCard) {
//        return Jwts.builder()
//                .setSubject(numberCard)
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
public String encriptografa(String numeroCartao) {

    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(numeroCartao.getBytes(StandardCharsets.UTF_8)));

        return String.format("%32x", hash);
    } catch (NoSuchAlgorithmException exception) {
        throw new RuntimeException(exception.getMessage());
    }
    }
}

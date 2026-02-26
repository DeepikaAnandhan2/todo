package com.sample.todo.utils;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET="yufyuefwjkfkmf_bfhgry__dehgefyuefy__h";
    private final long EXPIRATION=1000 * 60;
    private final Key secretKey= Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));//the json web token should be in Key format(Then only it will be acceptable) not String format


    public String generateToken(String email){

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(secretKey, SignatureAlgorithm.HS256)//like digitially sealed if suppose the seal is broke then the particular key is not valid
                .compact();
    }

    public boolean validateJwtToken(String token){
        try{

            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJwt(token)
                    .getBody()
                    .getSubject();

            return true;

        }
        catch(JwtException e){

            return false;

        }
    }


}

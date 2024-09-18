package com.jovicruz.points_of_interest.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.jovicruz.points_of_interest.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class tokenService {
    @Value("{api.security.salt}")
    private String salt;
    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(salt);
            String token = JWT.create()
                    .withIssuer("points-of-interest-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException ex){
            throw new RuntimeException("Error while generating token " + ex);
        }
    }


    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(salt);
            return JWT.require(algorithm)
                    .withIssuer("points-of-interest-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException ex){
            throw new RuntimeException("Error while validating token " + ex);

        }
    }
}

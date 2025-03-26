package my.test.Task.Management.System;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import java.util.Date;

@Component
public class JWTCore {

    @Value("${testing.app.secret}")
    private static String secret;

    @Value("${testing.app.lifeTime}")
    private static int lifeTime;


    public static String generateToken(Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + lifeTime))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }


    public String getNameFromJwt(String token) {
        return Jwts.parser().setSigningKey(secret).build().parseSignedClaims(token).getPayload().getSubject();
                //.setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();

    }


}

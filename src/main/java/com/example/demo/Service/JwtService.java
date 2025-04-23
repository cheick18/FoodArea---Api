package com.example.demo.Service;

import com.example.demo.model.AppUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${app.secret-key}")
    private String secreteKey;
    public String generateToken( AppUser user){
        Map<String,Object> claims= new HashMap<>();
        claims.put("login", user.getLogin());
        claims.put("role", user.getAccountType());
      return  Jwts
              .builder()
              .claims()
              .add(claims)
              .subject(user.getLogin())
              .issuer("CHEICK")
              .issuedAt(new Date(System.currentTimeMillis()))
              .expiration(new Date(System.currentTimeMillis()+60*10*1000))
              .and()
              .signWith(generateKey())
              .compact();

    }

    private SecretKey generateKey() {
        byte[] decode= Decoders.BASE64.decode(generateSecreteKey());
      return Keys.hmacShaKeyFor(decode);
    }


    public String generateSecreteKey(){
        return secreteKey;

    }


    public String extractUsername(String token) {
        return extractClaims(token,Claims::getSubject);
    }

     private <T> T extractClaims(String token, Function<Claims,T> claimResolver) {
    Claims claims= extractClaims(token);
    return claimResolver.apply(claims);
    }
    private Claims extractClaims(String token){
      return  Jwts
                .parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName=extractUsername(token);

        return (userName.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token){
       return extractClaims(token,Claims::getExpiration);

    }

}

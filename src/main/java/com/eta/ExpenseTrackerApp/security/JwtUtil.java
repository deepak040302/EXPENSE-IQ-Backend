package com.eta.ExpenseTrackerApp.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    // Use a stronger key in production
    private final String SECRET_KEY = "ef6651ea9e30fb2a964d573732aa5561fc883a38a6a313109ee24b09fa82b858ba183b21854e3b5c081cd640e38b992fe4edb8a25868dc95b6c22c2e6886159833d6d6450ab362250205960ddddc427190aad650e5c6be1ed7b8d4f68584518209e8d4b688c021d435211e50198b94997119ecf299f5dba0ef79596f2eb5f38daf4a56a4968864425b9d9d6997bddf7023474886c9748deaf4c0e5158aa99eb901fdbf149ad349a65b710db2abba5740382bbc1a642067f599f03d45f7a04a7653e50a36c2989b5e2d4a8ff8d529afceb42a2c97fb4acc4d16e01e96e98ba42961d5a4afda01fe3924c67a89a923a61807b8378914e2732d8035e64659f4441b";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}

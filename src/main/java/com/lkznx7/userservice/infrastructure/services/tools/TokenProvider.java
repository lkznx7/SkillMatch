package com.lkznx7.userservice.infrastructure.services.tools;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
@Service
public class TokenProvider {

    @Value("${JWT.SECRET}")
    String Secret;
    @Value("${JWT.EXPIRATION}")
    Long Expiration;

    UserDetailsService userDetailsService;
    public TokenProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    String getToken(String username){
        UserDetails user = userDetailsService.loadUserByUsername(username);
        String email = user.getUsername();
        var role = user.getAuthorities();
        List<String> authorities = new ArrayList<>();
        for (GrantedAuthority authority : role) {
            authorities.add(authority.getAuthority());
        }
        return Jwts.builder().subject(email).expiration(new Date(System.currentTimeMillis()+Expiration))
                .claim("role",authorities).signWith(signKey()).compact();
    }
    Key signKey(){
        byte[] encoded = Base64.getEncoder().encode(Secret.getBytes());
        return Keys.hmacShaKeyFor(encoded);
    }

    private Claims extractAllClaims(String token) {
        try {
            return Jwts.parser()
                    .verifyWith((SecretKey) signKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (SignatureException e) {
            throw new RuntimeException("Assinatura do token inválida.");
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("O token JWT expirou.");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar o token JWT.");
        }
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    @SuppressWarnings("unchecked")
    public List<String> extractRoles(String token) {
        return extractClaim(token, claims -> claims.get("role", List.class));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}

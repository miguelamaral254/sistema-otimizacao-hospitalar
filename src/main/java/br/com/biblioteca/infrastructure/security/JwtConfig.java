package br.com.biblioteca.infrastructure.security;

import br.com.biblioteca.domain.exceptions.InvalidException;
import br.com.biblioteca.domain.exceptions.ServerException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JwtConfig {

    @Value("${api.security.token.secret}")
    private String secretKey;

    private static final long EXPIRATION_TIME = 86400000;

    public String generateToken(String email, String role) {
        try {
            return Jwts.builder()
                    .setSubject(email)
                    .claim("role", "ROLE_" + role)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, secretKey)
                    .compact();
        } catch (Exception e) {
            throw new ServerException("Internal Server Error");
        }
    }

    public boolean validateToken(String token) {
        try {
            var claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();

            String role = claims.get("role", String.class);
            return role != null && (
                    role.equals("ROLE_ADMIN") ||
                            role.equals("ROLE_RESEARCHER") ||
                            role.equals("ROLE_USER")
            );
        } catch (Exception e) {
            throw new InvalidException("Invalid Token");
        }
    }

    public String extractEmail(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            throw new InvalidException("Invalid Token");
        }
    }
}
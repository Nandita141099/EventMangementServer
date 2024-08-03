package com.elysiana.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.elysiana.service.impl.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	private String SECRET_KEY = "DWQDwqDqdfQWEfqFqwFqFWEFqwFQWFwhtrjhwRWG2Qrt4YhA3R";

	public String extractEmail(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(UserDetails userDetails) {
		// Cast UserDetails to UserDetailsImpl to access custom fields
		if (!(userDetails instanceof UserDetailsImpl)) {
			throw new IllegalArgumentException("UserDetails is not an instance of UserDetailsImpl");
		}

		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) userDetails;

		// Add custom claims to the token
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", userDetailsImpl.getUserId());
		claims.put("name", userDetailsImpl.getName());
		claims.put("contact", userDetailsImpl.getContact());
		claims.put("role", userDetailsImpl.getAuthorities().iterator().next().getAuthority());

		// Generate the token with the custom claims
		return createToken(claims, userDetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String email = extractEmail(token);
		return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}

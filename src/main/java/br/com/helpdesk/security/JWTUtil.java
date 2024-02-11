package br.com.helpdesk.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	@Value("${jwt.expiration}")
	private Long exepiration;
	
	@Value("${jwt.secret}")
	private String secret;
	
	public String genereteToken(String email) {
		return Jwts.builder()
				.setSubject(email)
				.setExpiration(new Date(System.currentTimeMillis() + exepiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
}

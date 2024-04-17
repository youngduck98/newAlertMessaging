package org.example.newalertmessaging.component.Token.provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.TypeRef;
import io.jsonwebtoken.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.newalertmessaging.component.Token.Token;
import org.example.newalertmessaging.component.Token.provider.JWTProvider;
import org.example.newalertmessaging.exception.auth.Cookie.CookieNotFoundException;
import org.example.newalertmessaging.exception.auth.JWT.InvalidTokenException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JWTProviderImpl implements JWTProvider {
    private final String secretKey;
    /*private final UserDetailsService userDetailsService;
    private final ObjectMapper objectMapper;
    public JWTProviderImpl(@Value("{jwt.secret}") String secretKey,
                           UserDetailsService userDetailsService,
                           ObjectMapper objectMapper){
        this.secretKey = secretKey;
        this.userDetailsService = userDetailsService;
        this.objectMapper = objectMapper;
    }
     */

    public JWTProviderImpl(@Value("{jwt.secret}") String secretKey){
        this.secretKey = secretKey;
    }

    private Token createToken(String tokenType, String userUid, List<String> roles, long duration){
        Claims claims = createClaims(userUid, roles);
        Date now = new Date();
        Date expiredAt = new Date(now.getTime() + duration);
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiredAt)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return new Token(tokenType, token, expiredAt);
    }

    @Override
    public boolean isValidTokenWithExpiration(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey)
                    .build()
                    .parseClaimsJwt(token);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean isValidTokenWithoutExpiration(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey)
                    .build()
                    .parseClaimsJwt(token);
        } catch (ExpiredJwtException expireError){
            return true;
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Claims createClaims(String userUid, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(userUid);
        claims.put(ROLES, roles);
        return claims;
    }

    @Override
    public Token createAccessToken(String userUid, List<String> roles) {
        return createToken(ACCESS_TOKEN, userUid, roles, ACCESS_TOKEN_EXPIRY);
    }

    @Override
    public Token createRefreshToken(String userUid, List<String> roles) {
        return createToken(REFRESH_TOKEN, userUid, roles, REFRESH_TOKEN_EXPIRY);
    }

    @Override
    public Token recreateAccessToken(String refreshToken) {
        if(!isValidTokenWithExpiration(refreshToken))
            throw new InvalidTokenException("리프레시 토큰이 유효하지 않습니다.");
        String userUid = getUserUid(refreshToken);
        List<String> userRole = getUserRoles(refreshToken);
        return createAccessToken(userUid, userRole);
    }

    @Override
    public Authentication getAuthentication(String token) {
        /*
        //check token's subject really our user by using db's info
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(this.getUserEmail(token));
         */
        Claims claims = getClaim(token);
        UserDetails userDetails = User.builder()
                .username(claims.getSubject())
                .password("")
                .authorities(claims.getAudience())
                .build();
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    @Override
    public Claims getClaim(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    @Override
    public String getUserUid(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }

    @Override
    public List<String> getUserRoles(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJwt(token)
                .getBody();
        return claims.get(ROLES, List.class);
    }

    @Override
    public String resolveFromCookie(String key, HttpServletRequest request) {
        if(request.getCookies() == null)
            throw new CookieNotFoundException("can't find cookie");
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(key)) {
                return cookie.getValue();
            }
        }
        throw new CookieNotFoundException("can't find parameter from cookie");
    }

    @Override
    public ResponseCookie createCookie(String key, String value, int maxAge) {
        return ResponseCookie.from(key, value)
                .httpOnly(true)
                .secure(true)
                .sameSite("None")
                .path("/")
                .maxAge(maxAge)
                .build();
    }

    @Override
    public void removeTokensFromCookie(HttpServletResponse response) {
        ResponseCookie accessTokenCookie = createCookie(ACCESS_TOKEN, "", 0);
        ResponseCookie refreshTokenCookie = createCookie(REFRESH_TOKEN, "", 0);

        response.addHeader(SET_COOKIE, accessTokenCookie.toString());
        response.addHeader(SET_COOKIE, refreshTokenCookie.toString());
    }

    //이전 setTokenToCookie -> setValueToCookie
    @Override
    public void setValueToCookie(String key, String value, int duration, HttpServletResponse response) {
        ResponseCookie cookie = createCookie(key, value, duration);
        response.addHeader(SET_COOKIE, cookie.toString());
    }
}

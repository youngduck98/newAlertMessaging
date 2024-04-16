package org.example.newalertmessaging.config.security.filterChain;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.newalertmessaging.component.Token.provider.JWTProvider;
import org.example.newalertmessaging.component.Token.provider.JWTProviderImpl;
import org.example.newalertmessaging.config.security.SecurityConfig;
import org.example.newalertmessaging.exception.auth.Cookie.CookieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
/*
OncePerRequestFilter: 스프링의 보안 인프라 내에서 HTTP 요청당 한 번씩만 실행되는 필터를 구현하는 데 사용됨.
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JWTProvider jwtProvider;
    private final PathMatcher pathMatcher;

    @Autowired
    public JwtAuthenticationFilter(JWTProviderImpl jwtProvider,
                                   AntPathMatcher antPathMatcher) {
        this.jwtProvider = jwtProvider;
        this.pathMatcher = antPathMatcher;
    }

    private void tokenValidation(String token){
        boolean validTokenCondition = token != null && jwtProvider.isValidTokenWithExpiration(token);
        if (validTokenCondition) {
            Authentication authentication = jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private void needAuthentication(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain){
        try {
            String accessToken = jwtProvider.resolveFromCookie(JWTProvider.ACCESS_TOKEN, request);
            tokenValidation(accessToken);
        }
        catch (CookieNotFoundException e1){
            String refreshToken = jwtProvider.resolveFromCookie(JWTProvider.REFRESH_TOKEN, request);
            tokenValidation(refreshToken);
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        boolean urlFromNotNeedAuthentication = Arrays.stream(SecurityConfig.PublicUrls).
                anyMatch(url -> pathMatcher.match(url, requestURI));
        if(!urlFromNotNeedAuthentication) {
            needAuthentication(request, response, filterChain);
        }
        filterChain.doFilter(request, response);
    }
}

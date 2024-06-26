package org.example.newalertmessaging.exception;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.example.newalertmessaging.exception.auth.JWT.InvalidTokenException;
/*
public class FilterExceptionReasonFinder {
    private static String findJwtExactError(Exception e){
        String msg;
        if(e instanceof ExpiredJwtException){
            msg = "Token has Expired";
        }else if(e instanceof MalformedJwtException){
            msg = "Invalid JWT token";
        }else if(e instanceof SignatureException){
            msg = "Invalid Signature";
        }else if(e instanceof IllegalArgumentException){
            msg = "Invalid token";
        }else if(e instanceof InvalidTokenException){
            msg = "Invalid token - from custom";
        } else{
            msg = "unknown error";
        }
        return msg;
    }
}
*/
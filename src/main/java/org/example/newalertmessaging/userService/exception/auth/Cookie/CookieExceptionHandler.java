package org.example.newalertmessaging.userService.exception.auth.Cookie;

import jakarta.servlet.http.HttpServletResponse;
import org.example.newalertmessaging.common.DTO.ResponseDTO;
import org.example.newalertmessaging.common.exception.DTO.factory.ErrorResponseDTOFactory;
import org.example.newalertmessaging.common.DTO.factory.ResponseDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
public class CookieExceptionHandler {
    ResponseDTOFactory responseFactory;

    @Autowired
    public CookieExceptionHandler(ErrorResponseDTOFactory errorResponseDTOFactory){
        this.responseFactory = errorResponseDTOFactory;
    }
    @ExceptionHandler(CookieNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleCookieNotFoundException(
            CookieNotFoundException cookieNotFoundException){
        return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(
                responseFactory.newResponseDto(cookieNotFoundException.getMessage())
        );
    }
}

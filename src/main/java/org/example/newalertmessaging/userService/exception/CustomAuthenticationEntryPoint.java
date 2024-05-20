package org.example.newalertmessaging.userService.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.newalertmessaging.common.exception.DTO.factory.ErrorResponseDTOFactory;
import org.example.newalertmessaging.common.DTO.factory.ResponseDTOFactory;
import org.example.newalertmessaging.common.DTO.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
/*
인증 과정에서 예외가 발생하는 경우 호출
- 사용자가 잘못된 이메일이나 비밀번호를 제공하였을 때
- 인증 토큰이 누락 되었을 때
- 토큰이 만료 되었을 때
 */
@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;
    private final ResponseDTOFactory errorResponseDTOFactory;

    private final String defaultString = "인증에 실패하셨습니다.: ";
    @Autowired
    public CustomAuthenticationEntryPoint(ObjectMapper objectMapper,
                                          ErrorResponseDTOFactory errorResponseDTOFactory){
        this.objectMapper = objectMapper;
        this.errorResponseDTOFactory = errorResponseDTOFactory;
    }
    //적절한 응답을 클라이언트에게 보내는 데 필요한 로직을 구현
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        errorResponseDTOFactory.setMail(false);
        ResponseDTO errorResponseDto = errorResponseDTOFactory.newResponseDto(
                defaultString + authException.getCause().getMessage()
        );
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(errorResponseDto));
    }
}

package org.example.newalertmessaging.exception.DTO.factory;

import org.example.newalertmessaging.exception.DTO.ErrorResponseDTO;
import org.example.newalertmessaging.exception.DTO.ResponseDTO;
import org.springframework.stereotype.Component;
/*
using factory method pattern
 */
@Component
public class ErrorResponseDTOFactory extends ResponseDTOFactory{
    public ErrorResponseDTOFactory(){
        super.setMail(true);
    }
    @Override
    protected ResponseDTO createResponseDTOWithAdditionalWork(String msg) {
        //TODO if mail is true, send email to admin
        return new ErrorResponseDTO<String>(msg);
    }
}

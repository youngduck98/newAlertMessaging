package org.example.newalertmessaging.common.exception.DTO.factory;

import org.example.newalertmessaging.common.DTO.factory.ResponseDTOFactory;
import org.example.newalertmessaging.common.exception.DTO.ErrorResponseDTO;
import org.example.newalertmessaging.common.DTO.ResponseDTO;
import org.springframework.stereotype.Component;
/*
using factory method pattern
 */
@Component
public class ErrorResponseDTOFactory extends ResponseDTOFactory {
    public ErrorResponseDTOFactory(){
        super.setMail(true);
    }

    @Override
    public void clear(){
        super.mail = true;
    }
    @Override
    protected ResponseDTO createResponseDTOWithAdditionalWork(String msg) {
        //TODO if mail is true, send email to admin
        return new ErrorResponseDTO<String>(msg);
    }
}

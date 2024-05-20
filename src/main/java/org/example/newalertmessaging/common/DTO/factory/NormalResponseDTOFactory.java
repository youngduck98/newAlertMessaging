package org.example.newalertmessaging.common.DTO.factory;

import org.example.newalertmessaging.common.DTO.ResponseDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class NormalResponseDTOFactory extends ResponseDTOFactory{

    @Override
    protected ResponseDTO createResponseDTOWithAdditionalWork(String msg) {
        return new ResponseDTO(msg);
    }
}

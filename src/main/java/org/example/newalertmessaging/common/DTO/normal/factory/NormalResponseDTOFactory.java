package org.example.newalertmessaging.common.DTO.normal.factory;

import org.example.newalertmessaging.common.DTO.ResponseDTOFactory;
import org.example.newalertmessaging.common.DTO.normal.ResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class NormalResponseDTOFactory extends ResponseDTOFactory {

    @Override
    protected ResponseDTO createResponseDTOWithAdditionalWork(String msg) {
        return new ResponseDTO(msg);
    }
}

package org.example.newalertmessaging.common.DTO.factory;

import lombok.Setter;
import org.example.newalertmessaging.common.DTO.ResponseDTO;

@Setter
public abstract class ResponseDTOFactory {
    protected boolean mail = false;

    public ResponseDTO newResponseDto(String msg){
        return createResponseDTOWithAdditionalWork(msg);
    }

    protected abstract ResponseDTO createResponseDTOWithAdditionalWork(String msg);
}

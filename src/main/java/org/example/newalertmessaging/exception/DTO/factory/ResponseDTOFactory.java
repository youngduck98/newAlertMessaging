package org.example.newalertmessaging.exception.DTO.factory;

import lombok.Setter;
import org.example.newalertmessaging.exception.DTO.ResponseDTO;

@Setter
public abstract class ResponseDTOFactory {
    protected boolean mail = false;

    public void clear(){ //initialize state
        mail = false;
    }

    public ResponseDTO newResponseDto(String msg){
        return createResponseDTOWithAdditionalWork(msg);
    }

    protected abstract ResponseDTO createResponseDTOWithAdditionalWork(String msg);
}

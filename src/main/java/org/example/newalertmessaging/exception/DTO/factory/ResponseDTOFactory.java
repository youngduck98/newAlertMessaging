package org.example.newalertmessaging.exception.DTO.factory;

import org.example.newalertmessaging.exception.DTO.ResponseDTO;

public abstract class ResponseDTOFactory {
    protected boolean mail = false;

    public void setMail(boolean bool){
        this.mail = bool;
    }
    public ResponseDTO newResponseDto(String msg){
        return createResponseDTOWithAdditionalWork(msg);
    }

    protected abstract ResponseDTO createResponseDTOWithAdditionalWork(String msg);
}

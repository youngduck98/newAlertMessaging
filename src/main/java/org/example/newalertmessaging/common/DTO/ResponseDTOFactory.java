package org.example.newalertmessaging.common.DTO;

import lombok.Setter;
import org.example.newalertmessaging.common.DTO.normal.ResponseDTO;

@Setter
public abstract class ResponseDTOFactory {
    protected boolean mail = false;

    public void clear(){this.mail = false;}

    public ResponseDTO newResponseDto(String msg){
        return createResponseDTOWithAdditionalWork(msg);
    }

    protected abstract ResponseDTO createResponseDTOWithAdditionalWork(String msg);
}

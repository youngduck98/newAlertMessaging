package org.example.newalertmessaging.common.exception.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.newalertmessaging.common.DTO.ResponseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class ErrorResponseDTO<T> extends ResponseDTO {
    private T result;
    public ErrorResponseDTO(){
        super();
    }
    public ErrorResponseDTO(String msg){
        super(msg);
    }
}

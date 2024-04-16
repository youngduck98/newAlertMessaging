package org.example.newalertmessaging.exception.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
public class ErrorResponseDTO<T> extends ResponseDTO{
    private T result;
    public ErrorResponseDTO(){
        super();
    }
    public ErrorResponseDTO(String msg){
        super(msg);
    }
}

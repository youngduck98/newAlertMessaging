package org.example.newalertmessaging.exception.DTO;

import lombok.Data;

@Data
public class ResponseDTO{
    String msg;
    public ResponseDTO(){
        this.msg = "";
    }
    public ResponseDTO(String msg){
        this.msg = msg;
    }
}

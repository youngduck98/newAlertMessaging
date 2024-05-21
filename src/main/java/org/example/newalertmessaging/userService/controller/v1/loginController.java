package org.example.newalertmessaging.userService.controller.v1;

import lombok.RequiredArgsConstructor;
import org.example.newalertmessaging.common.DTO.normal.ResponseDTO;
import org.example.newalertmessaging.common.DTO.normal.factory.NormalResponseDTOFactory;
import org.example.newalertmessaging.common.DTO.ResponseDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-api")
@RequiredArgsConstructor
public class loginController {
    ResponseDTOFactory dtoFactory;

    @Autowired
    public loginController(NormalResponseDTOFactory factory){
        this.dtoFactory = factory;
    }

    @GetMapping("/login")
    public ResponseDTO login() {
        return dtoFactory.newResponseDto("login success");
    }
}

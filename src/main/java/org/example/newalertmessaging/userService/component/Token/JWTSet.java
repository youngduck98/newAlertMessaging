package org.example.newalertmessaging.userService.component.Token;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTSet {
    private Token accessToken;
    private Token refreshToken;
}

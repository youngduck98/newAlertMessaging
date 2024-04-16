package org.example.newalertmessaging.component.Token;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class Token {
    public String tokenType;
    public String value;
    public Date expiredAt;
}

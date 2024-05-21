package org.example.newalertmessaging.mailService.common.domainObject;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Site {
    int id;
    String link;
    Department department;
}

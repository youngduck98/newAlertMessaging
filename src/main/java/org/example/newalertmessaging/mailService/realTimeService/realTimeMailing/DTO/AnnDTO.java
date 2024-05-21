package org.example.newalertmessaging.mailService.realTimeService.realTimeMailing.DTO;

import org.example.newalertmessaging.mailService.common.domainObject.Department;
import org.example.newalertmessaging.mailService.common.domainObject.Site;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnDTO {
    int crawlCount;
    int postNumber;
    String title;
    Site site;
    LocalDate postAt;
    String writer;
    Department department;
}

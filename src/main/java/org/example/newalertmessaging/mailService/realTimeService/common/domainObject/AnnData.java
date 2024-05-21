package org.example.newalertmessaging.mailService.realTimeService.common.domainObject;

import java.time.LocalDate;

public class AnnData {
    long id;
    int crawlCount;
    int postNumber;
    String title;
    Site site;
    LocalDate postAt;
    String writer;
    Department department;
}

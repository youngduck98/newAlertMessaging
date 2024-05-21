package org.example.newalertmessaging.mailService.common.domainObject;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Builder
public class AnnData {
    int crawlCount;
    int postNumber;
    String title;
    Site site;
    LocalDate postAt;
    String writer;
    Department department;
    LocalDateTime getAt;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AnnData other) {
            return this.postNumber == other.postNumber
                    && this.department.equals(other.department);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postNumber, department);
    }
}

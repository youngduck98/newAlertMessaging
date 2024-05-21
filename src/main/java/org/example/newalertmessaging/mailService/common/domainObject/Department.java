package org.example.newalertmessaging.mailService.common.domainObject;

import java.util.Objects;

public class Department {
    int id;
    String departmentName;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Department d) {
            return d.departmentName.equals(this.departmentName)
                    && d.id == this.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, id);
    }
}

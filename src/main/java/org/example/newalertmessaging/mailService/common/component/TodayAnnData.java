package org.example.newalertmessaging.mailService.common.component;

import org.example.newalertmessaging.mailService.common.domainObject.AnnData;
import org.example.newalertmessaging.mailService.common.domainObject.Department;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TodayAnnData {
    public Map<Department, DepartmentAnnDataPerDay> todayAnnDataPerDepartment;
    public TodayAnnData() {
        todayAnnDataPerDepartment = new HashMap<Department, DepartmentAnnDataPerDay>();
        update();
    }

    public void update(){
        //TODO db data 활용하여 해당 component update
    }

    public void addAnnData(AnnData annData) {
        todayAnnDataPerDepartment.get(annData.getDepartment()).addData(annData);
    }
}

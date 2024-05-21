package org.example.newalertmessaging.mailService.common.component;

import org.example.newalertmessaging.mailService.common.domainObject.AnnData;
import org.example.newalertmessaging.mailService.common.domainObject.Department;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class YesterdayAnnData {
    Map<Department, DepartmentAnnDataPerDay> yesterdayAnnDataPerDepartment;
    public YesterdayAnnData() {
        yesterdayAnnDataPerDepartment = new HashMap<Department, DepartmentAnnDataPerDay>();
        update();
    }

    public void update(){
        //TODO db 참조해서 bean data update
    }

    public YesterdayAnnData(TodayAnnData todayAnnData) {
        this.yesterdayAnnDataPerDepartment = todayAnnData.todayAnnDataPerDepartment;
    }
}

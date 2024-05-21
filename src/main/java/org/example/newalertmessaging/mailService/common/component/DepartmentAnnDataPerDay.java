package org.example.newalertmessaging.mailService.common.component;

import org.example.newalertmessaging.mailService.common.domainObject.AnnData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepartmentAnnDataPerDay {
    public List<Set<AnnData>> AnnouncementsPerHour = new ArrayList<Set<AnnData>>(24);

    public DepartmentAnnDataPerDay() {
        for(int i=0;i<24;i++){
            AnnouncementsPerHour.set(i, new HashSet<>());
        }
        update();
    }

    public void update(){
        //TODO db 참조해서 해당 시간대 게시글 가져오고 추가하기
    }

    public void addData(AnnData annData){
        AnnouncementsPerHour.get(annData.getGetAt().getHour()).add(annData);
    }

    public void addData(List<AnnData> annDataList){
        for(int i=0;i<annDataList.size();i++){
            addData(annDataList.get(i));
        }
    }
}

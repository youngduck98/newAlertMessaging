package org.example.newalertmessaging.mailService.common.component;

import org.example.newalertmessaging.mailService.common.domainObject.AnnData;
import org.example.newalertmessaging.mailService.common.domainObject.Department;
import org.example.newalertmessaging.mailService.common.exception.MissingAnnException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RecentAnn {
    Map<Department, Integer> recentAnnInDepartment;
    public RecentAnn() {
        this.recentAnnInDepartment = new HashMap<Department, Integer>();
    }

    public void update(){
        //TODO db 정보 참조해서 해당 bean update
    }

    public boolean update(AnnData ann){
        if(recentAnnInDepartment.get(ann.getDepartment()) == null){
            recentAnnInDepartment.put(ann.getDepartment(), ann.getPostNumber());
            return true;
        }
        if(recentAnnInDepartment.get(ann.getDepartment()) + 1 == ann.getPostNumber()){
            recentAnnInDepartment.put(ann.getDepartment(), ann.getPostNumber());
            return true;
        }
        if(recentAnnInDepartment.get(ann.getDepartment()) >= ann.getPostNumber()){
            //TODO warning 남기고 넘어감
            return true;
        }
        //TODO 크롤링 서비스에 해당 부분이 비었다는 것을 알리고 원본 사이트도 같은 형식인지
        // 확인 후 최신화 혹은 exception throw
        throw new MissingAnnException(
                recentAnnInDepartment.get(ann.getDepartment()), ann);
    }
}

package org.example.newalertmessaging.mailService.realTimeService.realTimeMailing.component;

import org.example.newalertmessaging.mailService.common.component.RecentAnn;
import org.springframework.stereotype.Component;

@Component
public class RealTimeProcess {
    RecentAnn recentAnn;

    public RealTimeProcess(RecentAnn recentAnn) {
        this.recentAnn = recentAnn;
    }
    //TODO kafka 연결
    public void listener(){

    }
}

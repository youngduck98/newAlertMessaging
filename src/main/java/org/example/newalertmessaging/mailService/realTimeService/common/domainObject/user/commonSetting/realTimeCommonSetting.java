package org.example.newalertmessaging.mailService.realTimeService.common.domainObject.user.commonSetting;

public class realTimeCommonSetting extends UserCommonSetting{
    public realTimeCommonSetting(){
        super.realtime = true;
    }
    int banTimeStart;
    int banTimeEnd;
}

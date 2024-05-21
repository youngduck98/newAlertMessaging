package org.example.newalertmessaging.mailService.common.domainObject.user.commonSetting;

import org.example.newalertmessaging.mailService.common.domainObject.user.Frequency;

public class FrequencyCommonSetting extends UserCommonSetting {
    public FrequencyCommonSetting() {
        super.realtime = false;
    }
    Frequency frequency;
}

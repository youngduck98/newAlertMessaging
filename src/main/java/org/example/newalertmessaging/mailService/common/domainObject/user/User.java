package org.example.newalertmessaging.mailService.common.domainObject.user;

import org.example.newalertmessaging.mailService.common.domainObject.Department;
import org.example.newalertmessaging.mailService.common.domainObject.user.commonSetting.UserCommonSetting;

import java.util.List;
import java.util.Map;

public class User {
    long id;
    String email;
    UserCommonSetting commonSetting;
    Map<Department, List<String>> departmentSetting;
}

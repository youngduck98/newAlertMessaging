package org.example.newalertmessaging.mailService.common.domainObject.user;

public enum Frequency {
    oneAt8(8, 8), oneAt20(20, 20), twoAt8And20(8, 20);
    private final int time1;
    private final int time2;
    private Frequency(int time1, int time2) {
        this.time1 = time1;
        this.time2 = time2;
    }
    public boolean isRightTime(int hour) {
        return this.time1 == hour || this.time2 == hour;
    }
}

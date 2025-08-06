package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class LiveAppointmentData implements Serializable {
    private int appointedNum;
    private LiveAppointmentGroupData liveGroup;

    public int getAppointedNum() {
        return this.appointedNum;
    }

    public LiveAppointmentGroupData getLiveGroup() {
        return this.liveGroup;
    }

    public void setAppointedNum(int i11) {
        this.appointedNum = i11;
    }

    public void setLiveGroup(LiveAppointmentGroupData liveAppointmentGroupData) {
        this.liveGroup = liveAppointmentGroupData;
    }
}

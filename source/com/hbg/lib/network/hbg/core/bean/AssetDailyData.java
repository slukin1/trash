package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class AssetDailyData implements Serializable {
    public int dailyStatus;
    public String userId;

    public boolean displayGuideDot() {
        return this.dailyStatus == 1;
    }

    public void reset() {
        this.userId = "";
        this.dailyStatus = 0;
    }
}

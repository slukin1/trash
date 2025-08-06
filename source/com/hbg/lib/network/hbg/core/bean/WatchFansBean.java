package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import java.io.Serializable;

public class WatchFansBean implements Serializable {
    private int focusStatus;
    private long focusTime;
    private PersonalCenterInfo.UcExtInfo ucExtInfo;
    private String uidUnique;
    private String userAvatar;
    private String userNickname;

    public int getFocusStatus() {
        return this.focusStatus;
    }

    public long getFocusTime() {
        return this.focusTime;
    }

    public PersonalCenterInfo.UcExtInfo getUcExtInfo() {
        return this.ucExtInfo;
    }

    public String getUidUnique() {
        return this.uidUnique;
    }

    public String getUserAvatar() {
        return this.userAvatar;
    }

    public String getUserNickname() {
        return this.userNickname;
    }

    public void setFocusStatus(int i11) {
        this.focusStatus = i11;
    }

    public void setFocusTime(long j11) {
        this.focusTime = j11;
    }

    public void setUcExtInfo(PersonalCenterInfo.UcExtInfo ucExtInfo2) {
        this.ucExtInfo = ucExtInfo2;
    }

    public void setUidUnique(String str) {
        this.uidUnique = str;
    }

    public void setUserAvatar(String str) {
        this.userAvatar = str;
    }

    public void setUserNickname(String str) {
        this.userNickname = str;
    }
}

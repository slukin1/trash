package com.hbg.lib.core.model;

import java.io.Serializable;

public class AccountRedDotMgtOpen implements Serializable {
    private int account;
    private int autoUploadLogTime;

    public int getAccount() {
        return this.account;
    }

    public int getAutoUploadLogTime() {
        return this.autoUploadLogTime;
    }

    public void setAccount(int i11) {
        this.account = i11;
    }

    public void setAutoUploadLogTime(int i11) {
        this.autoUploadLogTime = i11;
    }
}

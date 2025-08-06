package com.tencent.android.tpush.data;

import java.io.Serializable;

public class UnregisterInfo implements Serializable {
    public static final byte TYPE_UNINSTALL = 1;
    public static final byte TYPE_UNREGISTER = 0;
    private static final long serialVersionUID = -2293449011577410421L;
    public long accessId;
    public String accessKey;
    public String appCert;
    public byte isUninstall;
    public String option;
    public String packName;
    public long timestamp;
    public String token;

    public UnregisterInfo() {
    }

    public String toString() {
        return "------------UnregisterInfo----------------\n" + "accessId=" + this.accessId + "\n" + "accesskey=" + this.accessKey + "\n" + "token=" + this.token + "\n" + "isUninstall=" + this.isUninstall + "\n" + "packName=" + this.packName + "\n" + "--------------UnregisterInfo End------------";
    }

    public UnregisterInfo(int i11, String str, String str2, byte b11, String str3) {
        this.accessId = (long) i11;
        this.accessKey = str;
        this.token = str2;
        this.isUninstall = b11;
        this.packName = str3;
    }
}

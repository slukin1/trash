package com.tencent.imsdk.offlinePush;

public class OfflinePushToken {
    private int businessID;
    private int deviceBrand;
    private String deviceToken;
    private int isTPNSToken;

    public void setBusinessID(int i11) {
        this.businessID = i11;
    }

    public void setDeviceBrand(int i11) {
        this.deviceBrand = i11;
    }

    public void setDeviceToken(String str) {
        this.deviceToken = str;
    }

    public void setIsTPNSToken(boolean z11) {
        this.isTPNSToken = z11 ? 1 : 0;
    }
}

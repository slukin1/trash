package com.adjust.sdk.huawei;

public class HuaweiInstallReferrerResult {
    public String error;
    public HuaweiInstallReferrerDetails huaweiInstallReferrerDetails;

    public HuaweiInstallReferrerResult(HuaweiInstallReferrerDetails huaweiInstallReferrerDetails2) {
        this.huaweiInstallReferrerDetails = huaweiInstallReferrerDetails2;
    }

    public HuaweiInstallReferrerResult(String str) {
        this.error = str;
    }
}

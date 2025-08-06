package com.adjust.sdk.samsung;

public class SamsungInstallReferrerResult {
    public String error;
    public SamsungInstallReferrerDetails samsungInstallReferrerDetails;

    public SamsungInstallReferrerResult(SamsungInstallReferrerDetails samsungInstallReferrerDetails2) {
        this.samsungInstallReferrerDetails = samsungInstallReferrerDetails2;
    }

    public SamsungInstallReferrerResult(String str) {
        this.error = str;
    }
}

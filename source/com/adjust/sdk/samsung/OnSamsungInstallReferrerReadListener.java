package com.adjust.sdk.samsung;

public interface OnSamsungInstallReferrerReadListener {
    void onFail(String str);

    void onSamsungInstallReferrerRead(SamsungInstallReferrerDetails samsungInstallReferrerDetails);
}

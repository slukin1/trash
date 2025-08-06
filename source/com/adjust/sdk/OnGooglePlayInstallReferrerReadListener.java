package com.adjust.sdk;

public interface OnGooglePlayInstallReferrerReadListener {
    void onFail(String str);

    void onInstallReferrerRead(GooglePlayInstallReferrerDetails googlePlayInstallReferrerDetails);
}

package com.adjust.sdk;

public interface InstallReferrerReadListener {
    void onFail(String str);

    void onInstallReferrerRead(ReferrerDetails referrerDetails, String str);
}

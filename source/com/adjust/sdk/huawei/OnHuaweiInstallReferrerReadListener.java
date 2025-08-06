package com.adjust.sdk.huawei;

public interface OnHuaweiInstallReferrerReadListener {
    void onFail(String str);

    void onInstallReferrerDetailsRead(HuaweiInstallReferrerDetails huaweiInstallReferrerDetails);
}

package com.adjust.sdk.vivo;

public interface OnVivoInstallReferrerReadListener {
    void onFail(String str);

    void onVivoInstallReferrerRead(VivoInstallReferrerDetails vivoInstallReferrerDetails);
}

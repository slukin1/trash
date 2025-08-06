package com.adjust.sdk.vivo;

public class VivoInstallReferrerResult {
    public String error;
    public VivoInstallReferrerDetails vivoInstallReferrerDetails;

    public VivoInstallReferrerResult(VivoInstallReferrerDetails vivoInstallReferrerDetails2) {
        this.vivoInstallReferrerDetails = vivoInstallReferrerDetails2;
    }

    public VivoInstallReferrerResult(String str) {
        this.error = str;
    }
}

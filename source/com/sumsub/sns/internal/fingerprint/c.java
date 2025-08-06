package com.sumsub.sns.internal.fingerprint;

import android.annotation.SuppressLint;
import com.sumsub.sns.internal.fingerprint.Fingerprinter;

public final class c {
    @SuppressLint({"DiscouragedApi"})
    public static final boolean a(Fingerprinter.Version version, Fingerprinter.Version version2, Fingerprinter.Version version3) {
        if (version.getIntValue$idensic_mobile_sdk_aar_release() >= version2.getIntValue$idensic_mobile_sdk_aar_release()) {
            if (version3 == null || version.getIntValue$idensic_mobile_sdk_aar_release() < version3.getIntValue$idensic_mobile_sdk_aar_release()) {
                return true;
            }
        }
        return false;
    }
}

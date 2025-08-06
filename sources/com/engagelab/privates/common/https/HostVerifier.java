package com.engagelab.privates.common.https;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class HostVerifier implements HostnameVerifier {
    private static final String TAG = "HostVerifier";
    public String checkHost;

    public HostVerifier(String str) {
        this.checkHost = str;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.checkHost, str);
    }
}

package com.huobi.woodpecker.kalle.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

public class SSLUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final HostnameVerifier f21123a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final SSLSocketFactory f21124b = new TLSSocketFactory();

    public class a implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }
}

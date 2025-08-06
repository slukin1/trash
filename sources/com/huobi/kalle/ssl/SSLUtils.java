package com.huobi.kalle.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

public class SSLUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final HostnameVerifier f74765a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final SSLSocketFactory f74766b = new TLSSocketFactory();

    public class a implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }
}

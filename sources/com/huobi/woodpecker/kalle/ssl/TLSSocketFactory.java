package com.huobi.woodpecker.kalle.ssl;

import android.os.Build;
import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class TLSSocketFactory extends SSLSocketFactory {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f21125b;

    /* renamed from: c  reason: collision with root package name */
    public static final X509TrustManager f21126c = new a();

    /* renamed from: a  reason: collision with root package name */
    public SSLSocketFactory f21127a;

    public class a implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            f21125b = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"};
        } else if (i11 >= 16) {
            f21125b = new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
        } else {
            f21125b = new String[]{"SSLv3", "TLSv1"};
        }
    }

    public TLSSocketFactory() {
        try {
            SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
            instance.init((KeyManager[]) null, new TrustManager[]{f21126c}, new SecureRandom());
            this.f21127a = instance.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    public static void a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(f21125b);
        }
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        Socket createSocket = this.f21127a.createSocket(socket, str, i11, z11);
        a(createSocket);
        return createSocket;
    }

    public String[] getDefaultCipherSuites() {
        return this.f21127a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f21127a.getSupportedCipherSuites();
    }

    public Socket createSocket(String str, int i11) throws IOException {
        Socket createSocket = this.f21127a.createSocket(str, i11);
        a(createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException {
        Socket createSocket = this.f21127a.createSocket(str, i11, inetAddress, i12);
        a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        Socket createSocket = this.f21127a.createSocket(inetAddress, i11);
        a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        Socket createSocket = this.f21127a.createSocket(inetAddress, i11, inetAddress2, i12);
        a(createSocket);
        return createSocket;
    }

    public Socket createSocket() throws IOException {
        Socket createSocket = this.f21127a.createSocket();
        a(createSocket);
        return createSocket;
    }
}

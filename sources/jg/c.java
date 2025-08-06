package jg;

import com.huawei.secure.android.common.ssl.SSLUtil;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class c extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    public SSLContext f40530a;

    /* renamed from: b  reason: collision with root package name */
    public SSLSocket f40531b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f40532c;

    /* renamed from: d  reason: collision with root package name */
    public X509TrustManager f40533d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f40534e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f40535f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f40536g;

    @Deprecated
    public c(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f40530a = null;
        this.f40531b = null;
        this.f40530a = SSLUtil.f();
        b(x509TrustManager);
        this.f40530a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, (SecureRandom) null);
    }

    public final void a(Socket socket) {
        boolean z11;
        boolean z12 = true;
        if (!a.a(this.f40536g)) {
            e.e("SSLFNew", "set protocols");
            SSLUtil.e((SSLSocket) socket, this.f40536g);
            z11 = true;
        } else {
            z11 = false;
        }
        if (!a.a(this.f40535f) || !a.a(this.f40534e)) {
            e.e("SSLFNew", "set cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.d(sSLSocket);
            if (!a.a(this.f40535f)) {
                SSLUtil.h(sSLSocket, this.f40535f);
            } else {
                SSLUtil.b(sSLSocket, this.f40534e);
            }
        } else {
            z12 = false;
        }
        if (!z11) {
            e.e("SSLFNew", "set default protocols");
            SSLUtil.d((SSLSocket) socket);
        }
        if (!z12) {
            e.e("SSLFNew", "set default cipher");
            SSLUtil.c((SSLSocket) socket);
        }
    }

    public void b(X509TrustManager x509TrustManager) {
        this.f40533d = x509TrustManager;
    }

    public Socket createSocket(String str, int i11) throws IOException {
        e.e("SSLFNew", "createSocket: host , port");
        Socket createSocket = this.f40530a.getSocketFactory().createSocket(str, i11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f40531b = sSLSocket;
            this.f40532c = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f40532c;
        return strArr != null ? strArr : new String[0];
    }

    public Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i11);
    }

    public Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException, UnknownHostException {
        return createSocket(str, i11);
    }

    public Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i11);
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        e.e("SSLFNew", "createSocket");
        Socket createSocket = this.f40530a.getSocketFactory().createSocket(socket, str, i11, z11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f40531b = sSLSocket;
            this.f40532c = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }
}

package jg;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SSLUtil;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
public class b extends SSLSocketFactory {
    @Deprecated

    /* renamed from: i  reason: collision with root package name */
    public static final X509HostnameVerifier f40518i = new BrowserCompatHostnameVerifier();
    @Deprecated

    /* renamed from: j  reason: collision with root package name */
    public static final X509HostnameVerifier f40519j = new StrictHostnameVerifier();

    /* renamed from: k  reason: collision with root package name */
    public static final String f40520k = b.class.getSimpleName();

    /* renamed from: l  reason: collision with root package name */
    public static volatile b f40521l = null;

    /* renamed from: a  reason: collision with root package name */
    public SSLContext f40522a = null;

    /* renamed from: b  reason: collision with root package name */
    public SSLSocket f40523b = null;

    /* renamed from: c  reason: collision with root package name */
    public Context f40524c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f40525d;

    /* renamed from: e  reason: collision with root package name */
    public X509TrustManager f40526e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f40527f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f40528g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f40529h;

    public b(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        if (context == null) {
            e.d(f40520k, "SecureSSLSocketFactory: context is null");
            return;
        }
        c(context);
        d(SSLUtil.f());
        e a11 = d.a(context);
        this.f40526e = a11;
        this.f40522a.init((KeyManager[]) null, new X509TrustManager[]{a11}, secureRandom);
    }

    @Deprecated
    public static b b(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.b(context);
        if (f40521l == null) {
            synchronized (b.class) {
                if (f40521l == null) {
                    f40521l = new b(context, (SecureRandom) null);
                }
            }
        }
        if (f40521l.f40524c == null && context != null) {
            f40521l.c(context);
        }
        String str = f40520k;
        e.b(str, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f40521l;
    }

    public final void a(Socket socket) {
        boolean z11;
        boolean z12 = true;
        if (!a.a(this.f40529h)) {
            e.e(f40520k, "set protocols");
            SSLUtil.e((SSLSocket) socket, this.f40529h);
            z11 = true;
        } else {
            z11 = false;
        }
        if (!a.a(this.f40528g) || !a.a(this.f40527f)) {
            e.e(f40520k, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.d(sSLSocket);
            if (!a.a(this.f40528g)) {
                SSLUtil.h(sSLSocket, this.f40528g);
            } else {
                SSLUtil.b(sSLSocket, this.f40527f);
            }
        } else {
            z12 = false;
        }
        if (!z11) {
            e.e(f40520k, "set default protocols");
            SSLUtil.d((SSLSocket) socket);
        }
        if (!z12) {
            e.e(f40520k, "set default cipher suites");
            SSLUtil.c((SSLSocket) socket);
        }
    }

    public void c(Context context) {
        this.f40524c = context.getApplicationContext();
    }

    public Socket createSocket(String str, int i11) throws IOException {
        e.e(f40520k, "createSocket: host , port");
        Socket createSocket = this.f40522a.getSocketFactory().createSocket(str, i11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f40523b = sSLSocket;
            this.f40525d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public void d(SSLContext sSLContext) {
        this.f40522a = sSLContext;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f40525d;
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
        e.e(f40520k, "createSocket s host port autoClose");
        Socket createSocket = this.f40522a.getSocketFactory().createSocket(socket, str, i11, z11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f40523b = sSLSocket;
            this.f40525d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }
}

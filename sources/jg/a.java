package jg;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SSLUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class a extends SSLSocketFactory {

    /* renamed from: h  reason: collision with root package name */
    public static final X509HostnameVerifier f40507h = new BrowserCompatHostnameVerifier();

    /* renamed from: i  reason: collision with root package name */
    public static final X509HostnameVerifier f40508i = new StrictHostnameVerifier();

    /* renamed from: j  reason: collision with root package name */
    public static final String f40509j = a.class.getSimpleName();

    /* renamed from: k  reason: collision with root package name */
    public static volatile a f40510k = null;

    /* renamed from: a  reason: collision with root package name */
    public SSLContext f40511a;

    /* renamed from: b  reason: collision with root package name */
    public SSLSocket f40512b;

    /* renamed from: c  reason: collision with root package name */
    public Context f40513c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f40514d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f40515e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f40516f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f40517g;

    public final void a(Socket socket) {
        boolean z11;
        boolean z12 = true;
        if (!com.huawei.secure.android.common.ssl.util.a.a(this.f40517g)) {
            e.e(f40509j, "set protocols");
            SSLUtil.e((SSLSocket) socket, this.f40517g);
            z11 = true;
        } else {
            z11 = false;
        }
        if (!com.huawei.secure.android.common.ssl.util.a.a(this.f40516f) || !com.huawei.secure.android.common.ssl.util.a.a(this.f40515e)) {
            e.e(f40509j, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.d(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f40516f)) {
                SSLUtil.h(sSLSocket, this.f40516f);
            } else {
                SSLUtil.b(sSLSocket, this.f40515e);
            }
        } else {
            z12 = false;
        }
        if (!z11) {
            e.e(f40509j, "set default protocols");
            SSLUtil.d((SSLSocket) socket);
        }
        if (!z12) {
            e.e(f40509j, "set default cipher suites");
            SSLUtil.c((SSLSocket) socket);
        }
    }

    public void b(Context context) {
        this.f40513c = context.getApplicationContext();
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        e.e(f40509j, "createSocket: socket host port autoClose");
        Socket createSocket = this.f40511a.getSocketFactory().createSocket(socket, str, i11, z11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f40512b = sSLSocket;
            this.f40514d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public Socket createSocket() throws IOException {
        e.e(f40509j, "createSocket: ");
        Socket createSocket = this.f40511a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f40512b = sSLSocket;
            this.f40514d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }
}

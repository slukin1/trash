package ty;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.text.TextUtils;
import com.huobi.vulcan.model.VulcanInfo;
import com.ta.a.e.h;
import com.tencent.android.tpush.XGServerInfo;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class e extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    public Method f40587a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f40588b;

    /* renamed from: c  reason: collision with root package name */
    public HostnameVerifier f40589c = HttpsURLConnection.getDefaultHostnameVerifier();

    public e(String str) {
        this.f40588b = str;
    }

    public Socket createSocket() throws IOException {
        return null;
    }

    public Socket createSocket(String str, int i11) throws IOException {
        return null;
    }

    public Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        return null;
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        SSLSocket sSLSocket;
        h.g("", "peerHost", this.f40588b, VulcanInfo.HOST, str, XGServerInfo.TAG_PORT, Integer.valueOf(i11), "autoClose", Boolean.valueOf(z11));
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 24) {
            sSLCertificateSocketFactory.setTrustManagers(f.a());
        } else {
            sSLCertificateSocketFactory.setTrustManagers(b.a());
        }
        h.e("", "createSocket");
        if (i12 < 23) {
            InetAddress inetAddress = socket.getInetAddress();
            if (z11) {
                socket.close();
            }
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i11);
        } else {
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.f40588b, i11, true);
        }
        h.e("", "createSocket end");
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (i12 >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.f40588b);
        } else {
            try {
                if (this.f40587a == null) {
                    Method method = sSLSocket.getClass().getMethod("setHostname", new Class[]{String.class});
                    this.f40587a = method;
                    method.setAccessible(true);
                }
                this.f40587a.invoke(sSLSocket, new Object[]{this.f40588b});
            } catch (Exception e11) {
                h.e("", "SNI not useable", e11);
            }
        }
        SSLSession session = sSLSocket.getSession();
        if (this.f40589c.verify(this.f40588b, session)) {
            h.g("", "SSLSession PeerHost", session.getPeerHost());
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + this.f40588b);
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f40588b) || !(obj instanceof e)) {
            return false;
        }
        String str = ((e) obj).f40588b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f40588b.equals(str);
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}

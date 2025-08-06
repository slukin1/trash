package b3;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.huobi.vulcan.model.VulcanInfo;
import com.tencent.android.tpush.XGServerInfo;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class a extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    public Method f12315a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f12316b;

    public a(String str) {
        this.f12316b = str;
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
        if (this.f12316b == null) {
            this.f12316b = str;
        }
        LogUtil.a(VulcanInfo.HOST + this.f12316b + XGServerInfo.TAG_PORT + i11 + "autoClose" + z11);
        InetAddress inetAddress = socket.getInetAddress();
        if (z11) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i11);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.f12316b);
        } else {
            try {
                if (this.f12315a == null) {
                    Method method = sSLSocket.getClass().getMethod("setHostname", new Class[]{String.class});
                    this.f12315a = method;
                    method.setAccessible(true);
                }
                this.f12315a.invoke(sSLSocket, new Object[]{this.f12316b});
            } catch (Exception e11) {
                LogUtil.e("SNI not useable", e11);
            }
        }
        sSLSocket.getSession();
        return sSLSocket;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}

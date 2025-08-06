package com.tencent.tpns.baseapi.core.net;

import android.os.Build;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TlsCompatSocketFactory extends SSLSocketFactory {
    private static final String TAG = "TlsCompatSocketFactory";
    private static final String[] TLS_VERSION_LIST_FOR_API_LEVEL_UNDER_20 = {"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
    public final SSLSocketFactory target;

    public TlsCompatSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.target = sSLSocketFactory;
    }

    private Socket supportTLS(Socket socket) {
        if ((socket instanceof SSLSocket) && Build.VERSION.SDK_INT < 20) {
            ((SSLSocket) socket).setEnabledProtocols(TLS_VERSION_LIST_FOR_API_LEVEL_UNDER_20);
        }
        return socket;
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) {
        return supportTLS(this.target.createSocket(socket, str, i11, z11));
    }

    public String[] getDefaultCipherSuites() {
        return this.target.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.target.getSupportedCipherSuites();
    }

    public Socket createSocket(String str, int i11) {
        return supportTLS(this.target.createSocket(str, i11));
    }

    public Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) {
        return supportTLS(this.target.createSocket(str, i11, inetAddress, i12));
    }

    public Socket createSocket(InetAddress inetAddress, int i11) {
        return supportTLS(this.target.createSocket(inetAddress, i11));
    }

    public Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) {
        return supportTLS(this.target.createSocket(inetAddress, i11, inetAddress2, i12));
    }
}

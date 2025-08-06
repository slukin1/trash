package io.flutter.plugins.videoplayer;

import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class CustomSSLSocketFactory extends SSLSocketFactory {
    private SSLSocketFactory sslSocketFactory;

    public CustomSSLSocketFactory() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        this.sslSocketFactory = instance.getSocketFactory();
    }

    private Socket enableProtocols(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
        }
        return socket;
    }

    public Socket createSocket() throws IOException {
        return enableProtocols(this.sslSocketFactory.createSocket());
    }

    public String[] getDefaultCipherSuites() {
        return this.sslSocketFactory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.sslSocketFactory.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        return enableProtocols(this.sslSocketFactory.createSocket(socket, str, i11, z11));
    }

    public Socket createSocket(String str, int i11) throws IOException {
        return enableProtocols(this.sslSocketFactory.createSocket(str, i11));
    }

    public Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException {
        return enableProtocols(this.sslSocketFactory.createSocket(str, i11, inetAddress, i12));
    }

    public Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        return enableProtocols(this.sslSocketFactory.createSocket(inetAddress, i11));
    }

    public Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        return enableProtocols(this.sslSocketFactory.createSocket(inetAddress, i11, inetAddress2, i12));
    }
}

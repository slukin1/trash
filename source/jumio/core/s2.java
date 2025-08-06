package jumio.core;

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

public final class s2 extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    public final SSLSocketFactory f56323a;

    public s2(TrustManager[] trustManagerArr) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLSv1.2");
        instance.init((KeyManager[]) null, trustManagerArr, (SecureRandom) null);
        this.f56323a = instance.getSocketFactory();
    }

    public static Socket a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
        }
        return socket;
    }

    public final Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        return a(this.f56323a.createSocket(socket, str, i11, z11));
    }

    public final String[] getDefaultCipherSuites() {
        return this.f56323a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f56323a.getSupportedCipherSuites();
    }

    public final Socket createSocket(String str, int i11) throws IOException {
        return a(this.f56323a.createSocket(str, i11));
    }

    public final Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException {
        return a(this.f56323a.createSocket(str, i11, inetAddress, i12));
    }

    public final Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        return a(this.f56323a.createSocket(inetAddress, i11));
    }

    public final Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        return a(this.f56323a.createSocket(inetAddress, i11, inetAddress2, i12));
    }
}

package com.amazonaws.http;

import android.os.Build;
import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class TLS12SocketFactory extends SSLSocketFactory {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f14901c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f14902d = {"TLSv1", "TLSv1.1", "TLSv1.2"};

    /* renamed from: e  reason: collision with root package name */
    public static SSLContext f14903e = null;

    /* renamed from: a  reason: collision with root package name */
    public final SSLSocketFactory f14904a;

    /* renamed from: b  reason: collision with root package name */
    public LoggingHandshakeCompletedListener f14905b;

    public TLS12SocketFactory(SSLContext sSLContext) throws KeyManagementException, NoSuchAlgorithmException {
        if (sSLContext != null) {
            this.f14904a = sSLContext.getSocketFactory();
        } else {
            synchronized (f14901c) {
                if (f14903e == null) {
                    SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
                    f14903e = instance;
                    instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                }
            }
            this.f14904a = f14903e.getSocketFactory();
        }
        this.f14905b = new LoggingHandshakeCompletedListener();
    }

    public static TLS12SocketFactory a() {
        return b((SSLContext) null);
    }

    public static TLS12SocketFactory b(SSLContext sSLContext) {
        if (Build.VERSION.SDK_INT >= 21) {
            return null;
        }
        try {
            return new TLS12SocketFactory(sSLContext);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void c(HttpsURLConnection httpsURLConnection, TLS12SocketFactory tLS12SocketFactory) {
        if (Build.VERSION.SDK_INT < 21 && tLS12SocketFactory != null) {
            try {
                httpsURLConnection.setSSLSocketFactory(tLS12SocketFactory);
            } catch (Exception unused) {
            }
        }
    }

    public Socket createSocket() throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.f14904a.createSocket();
        sSLSocket.addHandshakeCompletedListener(this.f14905b);
        return d(sSLSocket);
    }

    public final Socket d(Socket socket) {
        if (socket instanceof SSLSocket) {
            try {
                ((SSLSocket) socket).setEnabledProtocols(f14902d);
            } catch (Exception unused) {
            }
        }
        return socket;
    }

    public String[] getDefaultCipherSuites() {
        return this.f14904a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f14904a.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.f14904a.createSocket(socket, str, i11, z11);
        sSLSocket.addHandshakeCompletedListener(this.f14905b);
        return d(sSLSocket);
    }

    public Socket createSocket(String str, int i11) throws IOException, UnknownHostException {
        SSLSocket sSLSocket = (SSLSocket) this.f14904a.createSocket(str, i11);
        sSLSocket.addHandshakeCompletedListener(this.f14905b);
        return d(sSLSocket);
    }

    public Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException, UnknownHostException {
        SSLSocket sSLSocket = (SSLSocket) this.f14904a.createSocket(str, i11, inetAddress, i12);
        sSLSocket.addHandshakeCompletedListener(this.f14905b);
        return d(sSLSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.f14904a.createSocket(inetAddress, i11);
        sSLSocket.addHandshakeCompletedListener(this.f14905b);
        return d(sSLSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.f14904a.createSocket(inetAddress, i11, inetAddress2, i12);
        sSLSocket.addHandshakeCompletedListener(this.f14905b);
        return d(sSLSocket);
    }
}

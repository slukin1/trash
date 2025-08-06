package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.google.common.net.HttpHeaders;
import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class UrlHttpClient implements HttpClient {

    /* renamed from: e  reason: collision with root package name */
    public static final Log f14906e = LogFactory.b(UrlHttpClient.class);

    /* renamed from: a  reason: collision with root package name */
    public final ClientConfiguration f14907a;

    /* renamed from: b  reason: collision with root package name */
    public final TLS12SocketFactory f14908b;

    /* renamed from: c  reason: collision with root package name */
    public SSLContext f14909c = null;

    /* renamed from: d  reason: collision with root package name */
    public TLS12SocketFactory f14910d;

    public final class CurlBuilder {

        /* renamed from: a  reason: collision with root package name */
        public final URL f14911a;

        /* renamed from: b  reason: collision with root package name */
        public String f14912b = null;

        /* renamed from: c  reason: collision with root package name */
        public final HashMap<String, String> f14913c = new HashMap<>();

        /* renamed from: d  reason: collision with root package name */
        public String f14914d = null;

        /* renamed from: e  reason: collision with root package name */
        public boolean f14915e = false;

        public CurlBuilder(URL url) {
            if (url != null) {
                this.f14911a = url;
                return;
            }
            throw new IllegalArgumentException("Must have a valid url");
        }

        public String a() {
            if (b()) {
                StringBuilder sb2 = new StringBuilder("curl");
                if (this.f14912b != null) {
                    sb2.append(" -X ");
                    sb2.append(this.f14912b);
                }
                for (Map.Entry next : this.f14913c.entrySet()) {
                    sb2.append(" -H \"");
                    sb2.append((String) next.getKey());
                    sb2.append(":");
                    sb2.append((String) next.getValue());
                    sb2.append("\"");
                }
                if (this.f14914d != null) {
                    sb2.append(" -d '");
                    sb2.append(this.f14914d);
                    sb2.append("'");
                }
                sb2.append(" ");
                sb2.append(this.f14911a.toString());
                return sb2.toString();
            }
            throw new IllegalStateException("Invalid state, cannot create curl command");
        }

        public boolean b() {
            return !this.f14915e;
        }

        public CurlBuilder c(String str) {
            this.f14914d = str;
            return this;
        }

        public CurlBuilder d(boolean z11) {
            this.f14915e = z11;
            return this;
        }

        public CurlBuilder e(Map<String, String> map) {
            this.f14913c.clear();
            this.f14913c.putAll(map);
            return this;
        }

        public CurlBuilder f(String str) {
            this.f14912b = str;
            return this;
        }
    }

    public UrlHttpClient(ClientConfiguration clientConfiguration) {
        this.f14907a = clientConfiguration;
        this.f14908b = TLS12SocketFactory.a();
    }

    public HttpResponse a(HttpRequest httpRequest) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.e().toURL().openConnection();
        CurlBuilder curlBuilder = this.f14907a.j() ? new CurlBuilder(httpRequest.e().toURL()) : null;
        c(httpRequest, httpURLConnection);
        b(httpRequest, httpURLConnection, curlBuilder);
        h(httpRequest, httpURLConnection, curlBuilder);
        if (curlBuilder != null) {
            if (curlBuilder.b()) {
                f(curlBuilder.a());
            } else {
                f("Failed to create curl, content too long");
            }
        }
        return d(httpRequest, httpURLConnection);
    }

    public HttpURLConnection b(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) throws ProtocolException {
        if (httpRequest.c() != null && !httpRequest.c().isEmpty()) {
            if (curlBuilder != null) {
                curlBuilder.e(httpRequest.c());
            }
            for (Map.Entry next : httpRequest.c().entrySet()) {
                String str = (String) next.getKey();
                if (!str.equals("Content-Length") && !str.equals("Host")) {
                    str.equals(HttpHeaders.EXPECT);
                    httpURLConnection.setRequestProperty(str, (String) next.getValue());
                }
            }
        }
        String d11 = httpRequest.d();
        httpURLConnection.setRequestMethod(d11);
        if (curlBuilder != null) {
            curlBuilder.f(d11);
        }
        return httpURLConnection;
    }

    public void c(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(this.f14907a.a());
        httpURLConnection.setReadTimeout(this.f14907a.f());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        if (httpRequest.f()) {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            if (this.f14907a.g() != null) {
                e(httpsURLConnection);
                return;
            }
            TLS12SocketFactory tLS12SocketFactory = this.f14908b;
            if (tLS12SocketFactory != null) {
                TLS12SocketFactory.c(httpsURLConnection, tLS12SocketFactory);
            }
        }
    }

    public HttpResponse d(HttpRequest httpRequest, HttpURLConnection httpURLConnection) throws IOException {
        String responseMessage = httpURLConnection.getResponseMessage();
        int responseCode = httpURLConnection.getResponseCode();
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null && !"HEAD".equals(httpRequest.d())) {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
            }
        }
        HttpResponse.Builder b11 = HttpResponse.a().d(responseCode).e(responseMessage).b(errorStream);
        for (Map.Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                b11.c((String) entry.getKey(), (String) ((List) entry.getValue()).get(0));
            }
        }
        return b11.a();
    }

    public final void e(HttpsURLConnection httpsURLConnection) {
        if (this.f14909c == null) {
            TrustManager[] trustManagerArr = {this.f14907a.g()};
            try {
                SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
                this.f14909c = instance;
                instance.init((KeyManager[]) null, trustManagerArr, (SecureRandom) null);
                if (this.f14910d == null) {
                    this.f14910d = TLS12SocketFactory.b(this.f14909c);
                }
            } catch (GeneralSecurityException e11) {
                throw new RuntimeException(e11);
            }
        }
        TLS12SocketFactory tLS12SocketFactory = this.f14910d;
        if (tLS12SocketFactory != null) {
            httpsURLConnection.setSSLSocketFactory(tLS12SocketFactory);
        } else {
            httpsURLConnection.setSSLSocketFactory(this.f14909c.getSocketFactory());
        }
    }

    public void f(String str) {
        f14906e.h(str);
    }

    public final void g(InputStream inputStream, OutputStream outputStream, CurlBuilder curlBuilder, ByteBuffer byteBuffer) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                if (byteBuffer != null) {
                    try {
                        byteBuffer.put(bArr, 0, read);
                    } catch (BufferOverflowException unused) {
                        curlBuilder.d(true);
                    }
                }
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public void h(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) throws IOException {
        if (httpRequest.a() != null && httpRequest.b() >= 0) {
            httpURLConnection.setDoOutput(true);
            if (!httpRequest.f()) {
                httpURLConnection.setFixedLengthStreamingMode((int) httpRequest.b());
            }
            OutputStream outputStream = httpURLConnection.getOutputStream();
            ByteBuffer byteBuffer = null;
            if (curlBuilder != null) {
                if (httpRequest.b() < 2147483647L) {
                    byteBuffer = ByteBuffer.allocate((int) httpRequest.b());
                } else {
                    curlBuilder.d(true);
                }
            }
            g(httpRequest.a(), outputStream, curlBuilder, byteBuffer);
            if (!(curlBuilder == null || byteBuffer == null || byteBuffer.position() == 0)) {
                curlBuilder.c(new String(byteBuffer.array(), "UTF-8"));
            }
            outputStream.flush();
            outputStream.close();
        }
    }

    public void shutdown() {
    }
}

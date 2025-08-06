package com.kakao.network;

import com.adjust.sdk.Constants;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.jumio.core.cdn.CDNDownload;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import uw.d;
import vw.b;

public class KakaoNetworkImpl implements d {

    /* renamed from: g  reason: collision with root package name */
    public static final HostnameVerifier f25052g = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f25053a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f25054b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f25055c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public HttpURLConnection f25056d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f25057e = "ISO-8859-1";

    /* renamed from: f  reason: collision with root package name */
    public int f25058f = -1;

    public static class a implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public void a(String str, String str2) {
        this.f25055c.put(str, str2);
    }

    public void b(String str, String str2) {
        this.f25054b.put(str, str2);
    }

    public void c(b bVar) {
        this.f25053a.add(bVar);
    }

    public void connect() throws IOException {
        try {
            this.f25058f = this.f25056d.getResponseCode();
        } catch (IOException unused) {
            this.f25058f = this.f25056d.getResponseCode();
        }
    }

    public byte[] d() throws IOException {
        InputStream g11 = g(this.f25056d);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = g11.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                g11.close();
            } catch (IOException unused) {
            }
            return byteArray;
        } catch (Throwable th2) {
            if (g11 != null) {
                try {
                    g11.close();
                } catch (IOException unused2) {
                }
            }
            throw th2;
        }
    }

    public void disconnect() {
        this.f25054b.clear();
        this.f25055c.clear();
        this.f25053a.clear();
        HttpURLConnection httpURLConnection = this.f25056d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f25058f = 200;
    }

    public void e() throws IOException {
        vw.a aVar;
        this.f25056d.setDoInput(true);
        this.f25056d.setConnectTimeout(5000);
        this.f25056d.setReadTimeout(CDNDownload.DEFAULT_TIMEOUT);
        int i11 = 0;
        this.f25056d.setInstanceFollowRedirects(false);
        this.f25056d.setRequestProperty(HttpHeaders.CONNECTION, "keep-alive");
        if (!this.f25055c.isEmpty()) {
            for (String next : this.f25055c.keySet()) {
                this.f25056d.setRequestProperty(next, this.f25055c.get(next));
            }
        }
        String requestMethod = this.f25056d.getRequestMethod();
        if ("POST".equals(requestMethod) || "PUT".equals(requestMethod)) {
            this.f25056d.setRequestProperty("Content-Length", "0");
            this.f25056d.setDoOutput(true);
            String str = null;
            if (!this.f25054b.isEmpty()) {
                String h11 = h(this.f25054b);
                i11 = 0 + h11.length();
                str = h11;
                aVar = null;
            } else if (!this.f25053a.isEmpty()) {
                aVar = new vw.a(this.f25053a);
                i11 = (int) (((long) 0) + aVar.d());
                this.f25056d.setRequestProperty("Content-Type", aVar.e());
            } else {
                aVar = null;
            }
            if (i11 > 0) {
                this.f25056d.setFixedLengthStreamingMode(i11);
                this.f25056d.setRequestProperty("Content-Length", String.valueOf(i11));
            }
            if (str != null && !str.isEmpty()) {
                this.f25056d.getOutputStream().write(str.getBytes(this.f25057e));
            }
            if (aVar != null) {
                aVar.f(this.f25056d.getOutputStream());
            }
        }
    }

    public void f(String str, String str2, String str3) throws IOException {
        com.kakao.util.helper.log.a.a("++ url: " + str);
        com.kakao.util.helper.log.a.a("++ method: " + str2);
        this.f25057e = str3;
        this.f25056d = (HttpURLConnection) new URL(str).openConnection(Proxy.NO_PROXY);
        if (str.startsWith(Constants.SCHEME)) {
            ((HttpsURLConnection) this.f25056d).setHostnameVerifier(f25052g);
        }
        this.f25056d.setRequestMethod(str2);
    }

    public final InputStream g(HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getResponseCode() < 400) {
            return httpURLConnection.getInputStream();
        }
        InputStream errorStream = httpURLConnection.getErrorStream();
        return errorStream != null ? errorStream : new ByteArrayInputStream(new byte[0]);
    }

    public int getStatusCode() {
        return this.f25058f;
    }

    public final String h(Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb2.length() > 0) {
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb2.append(URLEncoder.encode((String) next.getKey(), this.f25057e));
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append(URLEncoder.encode((String) next.getValue(), this.f25057e));
        }
        return sb2.toString();
    }
}

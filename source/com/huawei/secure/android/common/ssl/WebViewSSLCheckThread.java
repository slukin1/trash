package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.e;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class WebViewSSLCheckThread extends Thread {

    /* renamed from: j  reason: collision with root package name */
    public static final String f38643j = WebViewSSLCheckThread.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public SSLSocketFactory f38644b;

    /* renamed from: c  reason: collision with root package name */
    public HostnameVerifier f38645c;

    /* renamed from: d  reason: collision with root package name */
    public org.apache.http.conn.ssl.SSLSocketFactory f38646d;

    /* renamed from: e  reason: collision with root package name */
    public X509HostnameVerifier f38647e;

    /* renamed from: f  reason: collision with root package name */
    public SslErrorHandler f38648f;

    /* renamed from: g  reason: collision with root package name */
    public String f38649g;

    /* renamed from: h  reason: collision with root package name */
    public a f38650h;

    /* renamed from: i  reason: collision with root package name */
    public Context f38651i;

    public interface a {
        void a(Context context, String str);

        void b(Context context, String str);
    }

    public final void a() {
        String str = f38643j;
        e.e(str, "callbackCancel: ");
        a aVar = this.f38650h;
        if (aVar != null) {
            aVar.a(this.f38651i, this.f38649g);
        } else if (this.f38648f != null) {
            e.e(str, "callbackCancel 2: ");
            this.f38648f.cancel();
        }
    }

    public final void b() {
        e.e(f38643j, "callbackProceed: ");
        a aVar = this.f38650h;
        if (aVar != null) {
            aVar.b(this.f38651i, this.f38649g);
            return;
        }
        SslErrorHandler sslErrorHandler = this.f38648f;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            super.run()
            org.apache.http.conn.ssl.SSLSocketFactory r0 = r8.f38646d
            r1 = 0
            if (r0 == 0) goto L_0x00d3
            org.apache.http.conn.ssl.X509HostnameVerifier r0 = r8.f38647e
            if (r0 == 0) goto L_0x00d3
            android.webkit.SslErrorHandler r0 = r8.f38648f
            if (r0 == 0) goto L_0x00c8
            java.lang.String r0 = r8.f38649g
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001a
            goto L_0x00c8
        L_0x001a:
            org.apache.http.conn.ssl.SSLSocketFactory r0 = r8.f38646d     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.conn.ssl.X509HostnameVerifier r2 = r8.f38647e     // Catch:{ Exception -> 0x00a2 }
            r0.setHostnameVerifier(r2)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.conn.ssl.SSLSocketFactory r0 = r8.f38646d     // Catch:{ Exception -> 0x00a2 }
            boolean r2 = r0 instanceof jg.a     // Catch:{ Exception -> 0x00a2 }
            if (r2 == 0) goto L_0x002e
            jg.a r0 = (jg.a) r0     // Catch:{ Exception -> 0x00a2 }
            android.content.Context r2 = r8.f38651i     // Catch:{ Exception -> 0x00a2 }
            r0.b(r2)     // Catch:{ Exception -> 0x00a2 }
        L_0x002e:
            org.apache.http.params.BasicHttpParams r0 = new org.apache.http.params.BasicHttpParams     // Catch:{ Exception -> 0x00a2 }
            r0.<init>()     // Catch:{ Exception -> 0x00a2 }
            r2 = 30000(0x7530, float:4.2039E-41)
            org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r0, r2)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.params.HttpConnectionParams.setSoTimeout(r0, r2)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.conn.scheme.SchemeRegistry r2 = new org.apache.http.conn.scheme.SchemeRegistry     // Catch:{ Exception -> 0x00a2 }
            r2.<init>()     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.conn.scheme.Scheme r3 = new org.apache.http.conn.scheme.Scheme     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r4 = "https"
            org.apache.http.conn.ssl.SSLSocketFactory r5 = r8.f38646d     // Catch:{ Exception -> 0x00a2 }
            r6 = 443(0x1bb, float:6.21E-43)
            r3.<init>(r4, r5, r6)     // Catch:{ Exception -> 0x00a2 }
            r2.register(r3)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.conn.scheme.Scheme r3 = new org.apache.http.conn.scheme.Scheme     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r4 = "http"
            org.apache.http.conn.scheme.PlainSocketFactory r5 = org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory()     // Catch:{ Exception -> 0x00a2 }
            r6 = 80
            r3.<init>(r4, r5, r6)     // Catch:{ Exception -> 0x00a2 }
            r2.register(r3)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager r3 = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager     // Catch:{ Exception -> 0x00a2 }
            r3.<init>(r0, r2)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.impl.client.DefaultHttpClient r2 = new org.apache.http.impl.client.DefaultHttpClient     // Catch:{ Exception -> 0x00a2 }
            r2.<init>(r3, r0)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.client.methods.HttpGet r0 = new org.apache.http.client.methods.HttpGet     // Catch:{ Exception -> 0x00a2 }
            r0.<init>()     // Catch:{ Exception -> 0x00a2 }
            java.net.URI r3 = new java.net.URI     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r4 = r8.f38649g     // Catch:{ Exception -> 0x00a2 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00a2 }
            r0.setURI(r3)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.HttpResponse r0 = r2.execute(r0)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r2 = f38643j     // Catch:{ Exception -> 0x00a2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a2 }
            r3.<init>()     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r4 = "status code is : "
            r3.append(r4)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.StatusLine r0 = r0.getStatusLine()     // Catch:{ Exception -> 0x00a2 }
            int r0 = r0.getStatusCode()     // Catch:{ Exception -> 0x00a2 }
            r3.append(r0)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x00a2 }
            com.huawei.secure.android.common.ssl.util.e.e(r2, r0)     // Catch:{ Exception -> 0x00a2 }
            com.huawei.secure.android.common.ssl.util.d.d(r1)
            r8.b()
            return
        L_0x00a0:
            r0 = move-exception
            goto L_0x00c4
        L_0x00a2:
            r0 = move-exception
            java.lang.String r2 = f38643j     // Catch:{ all -> 0x00a0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            r3.<init>()     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = "run: exception : "
            r3.append(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00a0 }
            r3.append(r0)     // Catch:{ all -> 0x00a0 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00a0 }
            com.huawei.secure.android.common.ssl.util.e.d(r2, r0)     // Catch:{ all -> 0x00a0 }
            r8.a()     // Catch:{ all -> 0x00a0 }
            com.huawei.secure.android.common.ssl.util.d.d(r1)
            return
        L_0x00c4:
            com.huawei.secure.android.common.ssl.util.d.d(r1)
            throw r0
        L_0x00c8:
            java.lang.String r0 = f38643j
            java.lang.String r1 = "sslErrorHandler or url is null"
            com.huawei.secure.android.common.ssl.util.e.d(r0, r1)
            r8.a()
            return
        L_0x00d3:
            javax.net.ssl.SSLSocketFactory r0 = r8.f38644b
            if (r0 == 0) goto L_0x0148
            javax.net.ssl.HostnameVerifier r0 = r8.f38645c
            if (r0 == 0) goto L_0x0148
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x011a, all -> 0x0115 }
            java.lang.String r2 = r8.f38649g     // Catch:{ Exception -> 0x011a, all -> 0x0115 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x011a, all -> 0x0115 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x011a, all -> 0x0115 }
            boolean r2 = r0 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x011a, all -> 0x0115 }
            if (r2 == 0) goto L_0x010c
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x011a, all -> 0x0115 }
            javax.net.ssl.SSLSocketFactory r1 = r8.f38644b     // Catch:{ Exception -> 0x010a }
            r0.setSSLSocketFactory(r1)     // Catch:{ Exception -> 0x010a }
            javax.net.ssl.HostnameVerifier r1 = r8.f38645c     // Catch:{ Exception -> 0x010a }
            r0.setHostnameVerifier(r1)     // Catch:{ Exception -> 0x010a }
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x010a }
            r1 = 10000(0x2710, float:1.4013E-41)
            r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x010a }
            r1 = 20000(0x4e20, float:2.8026E-41)
            r0.setReadTimeout(r1)     // Catch:{ Exception -> 0x010a }
            r0.connect()     // Catch:{ Exception -> 0x010a }
            r1 = r0
            goto L_0x010c
        L_0x010a:
            r1 = move-exception
            goto L_0x011e
        L_0x010c:
            if (r1 == 0) goto L_0x0111
            r1.disconnect()
        L_0x0111:
            r8.b()
            return
        L_0x0115:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x0142
        L_0x011a:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x011e:
            java.lang.String r2 = f38643j     // Catch:{ all -> 0x0141 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            r3.<init>()     // Catch:{ all -> 0x0141 }
            java.lang.String r4 = "exception : "
            r3.append(r4)     // Catch:{ all -> 0x0141 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0141 }
            r3.append(r1)     // Catch:{ all -> 0x0141 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0141 }
            com.huawei.secure.android.common.ssl.util.e.d(r2, r1)     // Catch:{ all -> 0x0141 }
            r8.a()     // Catch:{ all -> 0x0141 }
            if (r0 == 0) goto L_0x0140
            r0.disconnect()
        L_0x0140:
            return
        L_0x0141:
            r1 = move-exception
        L_0x0142:
            if (r0 == 0) goto L_0x0147
            r0.disconnect()
        L_0x0147:
            throw r1
        L_0x0148:
            r8.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.run():void");
    }
}

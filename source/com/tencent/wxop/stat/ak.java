package com.tencent.wxop.stat;

import android.content.Context;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.facebook.stetho.inspector.network.DecompressionHelper;
import com.google.common.net.HttpHeaders;
import com.huochat.community.base.CommunityConstants;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.g;
import com.tencent.wxop.stat.b.l;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class ak {

    /* renamed from: cx  reason: collision with root package name */
    private static b f50968cx = l.av();

    /* renamed from: dj  reason: collision with root package name */
    private static ak f50969dj = null;

    /* renamed from: dk  reason: collision with root package name */
    private static Context f50970dk = null;

    /* renamed from: cv  reason: collision with root package name */
    private long f50971cv = 0;

    /* renamed from: dg  reason: collision with root package name */
    public DefaultHttpClient f50972dg = null;

    /* renamed from: dh  reason: collision with root package name */
    public f f50973dh = null;

    /* renamed from: di  reason: collision with root package name */
    public StringBuilder f50974di = new StringBuilder(4096);

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|(3:4|5|6)|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0064 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ak(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "debug"
            r5.<init>()
            r1 = 0
            r5.f50972dg = r1
            r5.f50973dh = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 4096(0x1000, float:5.74E-42)
            r1.<init>(r2)
            r5.f50974di = r1
            r1 = 0
            r5.f50971cv = r1
            android.content.Context r6 = r6.getApplicationContext()     // Catch:{ all -> 0x0085 }
            f50970dk = r6     // Catch:{ all -> 0x0085 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0085 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            r5.f50971cv = r1     // Catch:{ all -> 0x0085 }
            com.tencent.wxop.stat.b.f r6 = new com.tencent.wxop.stat.b.f     // Catch:{ all -> 0x0085 }
            r6.<init>()     // Catch:{ all -> 0x0085 }
            r5.f50973dh = r6     // Catch:{ all -> 0x0085 }
            boolean r6 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x0085 }
            if (r6 == 0) goto L_0x0064
            java.lang.String r6 = "org.apache.http.wire"
            java.util.logging.Logger r6 = java.util.logging.Logger.getLogger(r6)     // Catch:{ all -> 0x0064 }
            java.util.logging.Level r1 = java.util.logging.Level.FINER     // Catch:{ all -> 0x0064 }
            r6.setLevel(r1)     // Catch:{ all -> 0x0064 }
            java.lang.String r6 = "org.apache.http.headers"
            java.util.logging.Logger r6 = java.util.logging.Logger.getLogger(r6)     // Catch:{ all -> 0x0064 }
            r6.setLevel(r1)     // Catch:{ all -> 0x0064 }
            java.lang.String r6 = "org.apache.commons.logging.Log"
            java.lang.String r1 = "org.apache.commons.logging.impl.SimpleLog"
            java.lang.System.setProperty(r6, r1)     // Catch:{ all -> 0x0064 }
            java.lang.String r6 = "org.apache.commons.logging.simplelog.showdatetime"
            java.lang.String r1 = "true"
            java.lang.System.setProperty(r6, r1)     // Catch:{ all -> 0x0064 }
            java.lang.String r6 = "org.apache.commons.logging.simplelog.log.httpclient.wire"
            java.lang.System.setProperty(r6, r0)     // Catch:{ all -> 0x0064 }
            java.lang.String r6 = "org.apache.commons.logging.simplelog.log.org.apache.http"
            java.lang.System.setProperty(r6, r0)     // Catch:{ all -> 0x0064 }
            java.lang.String r6 = "org.apache.commons.logging.simplelog.log.org.apache.http.headers"
            java.lang.System.setProperty(r6, r0)     // Catch:{ all -> 0x0064 }
        L_0x0064:
            org.apache.http.params.BasicHttpParams r6 = new org.apache.http.params.BasicHttpParams     // Catch:{ all -> 0x0085 }
            r6.<init>()     // Catch:{ all -> 0x0085 }
            r0 = 0
            org.apache.http.params.HttpConnectionParams.setStaleCheckingEnabled(r6, r0)     // Catch:{ all -> 0x0085 }
            r0 = 10000(0x2710, float:1.4013E-41)
            org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r6, r0)     // Catch:{ all -> 0x0085 }
            org.apache.http.params.HttpConnectionParams.setSoTimeout(r6, r0)     // Catch:{ all -> 0x0085 }
            org.apache.http.impl.client.DefaultHttpClient r0 = new org.apache.http.impl.client.DefaultHttpClient     // Catch:{ all -> 0x0085 }
            r0.<init>(r6)     // Catch:{ all -> 0x0085 }
            r5.f50972dg = r0     // Catch:{ all -> 0x0085 }
            com.tencent.wxop.stat.al r6 = new com.tencent.wxop.stat.al     // Catch:{ all -> 0x0085 }
            r6.<init>(r5)     // Catch:{ all -> 0x0085 }
            r0.setKeepAliveStrategy(r6)     // Catch:{ all -> 0x0085 }
            return
        L_0x0085:
            r6 = move-exception
            com.tencent.wxop.stat.b.b r0 = f50968cx
            r0.b((java.lang.Throwable) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.ak.<init>(android.content.Context):void");
    }

    public static ak Z(Context context) {
        if (f50969dj == null) {
            synchronized (ak.class) {
                if (f50969dj == null) {
                    f50969dj = new ak(context);
                }
            }
        }
        return f50969dj;
    }

    public static Context aB() {
        return f50970dk;
    }

    public static void j(Context context) {
        f50970dk = context.getApplicationContext();
    }

    public final void a(d dVar, aj ajVar) {
        b(Arrays.asList(new String[]{dVar.af()}), ajVar);
    }

    public final void a(List<?> list, aj ajVar) {
        Throwable th2;
        List<?> list2 = list;
        if (list2 != null && !list.isEmpty()) {
            int size = list.size();
            list2.get(0);
            try {
                StringBuilder sb2 = this.f50974di;
                sb2.delete(0, sb2.length());
                this.f50974di.append("[");
                for (int i11 = 0; i11 < size; i11++) {
                    this.f50974di.append(list2.get(i11).toString());
                    if (i11 != size - 1) {
                        this.f50974di.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                this.f50974di.append("]");
                String sb3 = this.f50974di.toString();
                int length = sb3.length();
                String str = c.y() + "/?index=" + this.f50971cv;
                this.f50971cv++;
                if (c.k()) {
                    f50968cx.b((Object) "[" + str + "]Send request(" + length + "bytes), content:" + sb3);
                }
                HttpPost httpPost = new HttpPost(str);
                httpPost.addHeader(HttpHeaders.ACCEPT_ENCODING, DecompressionHelper.GZIP_ENCODING);
                httpPost.setHeader(HttpHeaders.CONNECTION, "Keep-Alive");
                httpPost.removeHeaders(HttpHeaders.CACHE_CONTROL);
                HttpHost V = g.r(f50970dk).V();
                httpPost.addHeader(HttpHeaders.CONTENT_ENCODING, "rc4");
                if (V == null) {
                    this.f50972dg.getParams().removeParameter("http.route.default-proxy");
                } else {
                    if (c.k()) {
                        f50968cx.e("proxy:" + V.toHostString());
                    }
                    httpPost.addHeader("X-Content-Encoding", "rc4");
                    this.f50972dg.getParams().setParameter("http.route.default-proxy", V);
                    httpPost.addHeader("X-Online-Host", c.f51042al);
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("Content-Type", MTPushConstants.Analysis.KEY_JSON);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
                byte[] bytes = sb3.getBytes("UTF-8");
                int length2 = bytes.length;
                if (length > c.aA) {
                    httpPost.removeHeaders(HttpHeaders.CONTENT_ENCODING);
                    String str2 = "rc4" + ",gzip";
                    httpPost.addHeader(HttpHeaders.CONTENT_ENCODING, str2);
                    if (V != null) {
                        httpPost.removeHeaders("X-Content-Encoding");
                        httpPost.addHeader("X-Content-Encoding", str2);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length2);
                    if (c.k()) {
                        f50968cx.e("before Gzip:" + length2 + " bytes, after Gzip:" + bytes.length + " bytes");
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(g.b(bytes)));
                HttpResponse execute = this.f50972dg.execute(httpPost);
                HttpEntity entity = execute.getEntity();
                int statusCode = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (c.k()) {
                    f50968cx.b((Object) "http recv response status code:" + statusCode + ", content length:" + contentLength);
                }
                int i12 = (contentLength > 0 ? 1 : (contentLength == 0 ? 0 : -1));
                if (i12 <= 0) {
                    f50968cx.d("Server response no data.");
                    if (ajVar != null) {
                        ajVar.B();
                    }
                    EntityUtils.toString(entity);
                    return;
                }
                if (i12 > 0) {
                    InputStream content = entity.getContent();
                    DataInputStream dataInputStream = new DataInputStream(content);
                    byte[] bArr = new byte[((int) entity.getContentLength())];
                    dataInputStream.readFully(bArr);
                    content.close();
                    dataInputStream.close();
                    Header firstHeader = execute.getFirstHeader(HttpHeaders.CONTENT_ENCODING);
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bArr = g.c(l.b(bArr));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bArr = l.b(g.c(bArr));
                        } else if (firstHeader.getValue().equalsIgnoreCase(DecompressionHelper.GZIP_ENCODING)) {
                            bArr = l.b(bArr);
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                            bArr = g.c(bArr);
                        }
                    }
                    String str3 = new String(bArr, "UTF-8");
                    if (c.k()) {
                        f50968cx.b((Object) "http get response data:" + str3);
                    }
                    JSONObject jSONObject = new JSONObject(str3);
                    if (statusCode == 200) {
                        String optString = jSONObject.optString(CommunityConstants.REQUEST_KEY_MID);
                        if (h.e(optString)) {
                            if (c.k()) {
                                f50968cx.b((Object) "update mid:" + optString);
                            }
                            com.tencent.a.a.a.a.g.a(f50970dk).b(optString);
                        }
                        if (!jSONObject.isNull("cfg")) {
                            c.a(f50970dk, jSONObject.getJSONObject("cfg"));
                        }
                        if (!jSONObject.isNull("ncts")) {
                            int i13 = jSONObject.getInt("ncts");
                            int currentTimeMillis = (int) (((long) i13) - (System.currentTimeMillis() / 1000));
                            if (c.k()) {
                                f50968cx.b((Object) "server time:" + i13 + ", diff time:" + currentTimeMillis);
                            }
                            l.Q(f50970dk);
                            l.a(f50970dk, currentTimeMillis);
                        }
                        if (ajVar != null) {
                            if (jSONObject.optInt("ret") == 0) {
                                ajVar.ah();
                            } else {
                                f50968cx.error("response error data.");
                            }
                        }
                        content.close();
                    } else {
                        f50968cx.error("Server response error code:" + statusCode + ", error:" + new String(bArr, "UTF-8"));
                        if (ajVar != null) {
                        }
                        content.close();
                    }
                    ajVar.B();
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th2 = null;
                if (th2 != null) {
                    f50968cx.a(th2);
                    if (ajVar != null) {
                        try {
                            ajVar.B();
                        } catch (Throwable th3) {
                            f50968cx.b(th3);
                        }
                    }
                    if (th2 instanceof OutOfMemoryError) {
                        System.gc();
                        this.f50974di = null;
                        this.f50974di = new StringBuilder(2048);
                    }
                    g.r(f50970dk).I();
                }
            } catch (Throwable th4) {
                th2 = th4;
            }
        }
    }

    public final void b(List<?> list, aj ajVar) {
        f fVar = this.f50973dh;
        if (fVar != null) {
            fVar.a(new am(this, list, ajVar));
        }
    }
}

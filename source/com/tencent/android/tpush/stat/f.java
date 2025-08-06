package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.android.tpush.stat.b.c;
import com.tencent.android.tpush.stat.event.Event;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f70046a;

    /* renamed from: b  reason: collision with root package name */
    private static c f70047b = b.b();

    /* renamed from: c  reason: collision with root package name */
    private static Context f70048c = null;

    /* renamed from: d  reason: collision with root package name */
    private StringBuilder f70049d = new StringBuilder(4096);

    /* renamed from: e  reason: collision with root package name */
    private long f70050e = 0;

    private f(Context context) {
        try {
            f70048c = context.getApplicationContext();
            this.f70050e = System.currentTimeMillis() / 1000;
        } catch (Throwable th2) {
            f70047b.b(th2);
        }
    }

    public static void a(Context context) {
        f70048c = context.getApplicationContext();
    }

    public static f b(Context context) {
        if (f70046a == null) {
            synchronized (f.class) {
                if (f70046a == null) {
                    f70046a = new f(context);
                }
            }
        }
        return f70046a;
    }

    public static Context a() {
        return f70048c;
    }

    private void a(JSONObject jSONObject) {
        try {
            if (!jSONObject.isNull("cfg")) {
                d.a(f70048c, jSONObject.getJSONObject("cfg"));
            }
            if (!jSONObject.isNull("ncts")) {
                int i11 = jSONObject.getInt("ncts");
                int currentTimeMillis = (int) (((long) i11) - (System.currentTimeMillis() / 1000));
                if (d.b()) {
                    c cVar = f70047b;
                    cVar.b((Object) "server time:" + i11 + ", diff time:" + currentTimeMillis);
                }
                b.f(f70048c);
                b.a(f70048c, currentTimeMillis);
            }
        } catch (Throwable th2) {
            f70047b.d(th2);
        }
    }

    public void b(List<?> list, e eVar) {
        try {
            if (!j.b(GuidInfoManager.getToken(f70048c))) {
                a(list, eVar);
            } else if (eVar != null) {
                eVar.a();
            }
        } catch (Throwable unused) {
            f70047b.c("unexpected for sendList");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:23|24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        new java.lang.StringBuilder().append("unexpected for:");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0089, code lost:
        throw null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x007f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:80:0x024c */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x039b A[Catch:{ all -> 0x03c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03ca  */
    /* JADX WARNING: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010b A[Catch:{ all -> 0x03c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0144 A[Catch:{ all -> 0x03c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0162 A[Catch:{ all -> 0x03c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01c8 A[Catch:{ all -> 0x03c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x021c A[Catch:{ all -> 0x024c }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0271 A[Catch:{ all -> 0x03c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02a3 A[Catch:{ all -> 0x03c6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<?> r18, com.tencent.android.tpush.stat.e r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r3 = "["
            java.lang.String r4 = "gzip"
            java.lang.String r5 = ""
            if (r0 == 0) goto L_0x03f6
            boolean r6 = r18.isEmpty()
            if (r6 == 0) goto L_0x0016
            goto L_0x03f6
        L_0x0016:
            android.content.Context r6 = f70048c
            com.tencent.tpns.baseapi.base.util.CloudManager r6 = com.tencent.tpns.baseapi.base.util.CloudManager.getInstance(r6)
            boolean r6 = r6.shouldRefuse()
            if (r6 == 0) goto L_0x002a
            com.tencent.android.tpush.stat.b.c r0 = f70047b
            java.lang.String r2 = "sendHttpsPost refused by cloud"
            r0.d(r2)
            return
        L_0x002a:
            int r6 = r18.size()
            r7 = 0
            java.lang.StringBuilder r8 = r1.f70049d     // Catch:{ all -> 0x03c6 }
            int r9 = r8.length()     // Catch:{ all -> 0x03c6 }
            r10 = 0
            r8.delete(r10, r9)     // Catch:{ all -> 0x03c6 }
            java.lang.StringBuilder r8 = r1.f70049d     // Catch:{ all -> 0x03c6 }
            r8.append(r3)     // Catch:{ all -> 0x03c6 }
            r8 = r10
        L_0x003f:
            java.lang.String r9 = "accessId"
            if (r8 >= r6) goto L_0x008a
            java.lang.Object r11 = r0.get(r8)     // Catch:{ all -> 0x03c6 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x03c6 }
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ all -> 0x007f }
            r12.<init>(r11)     // Catch:{ all -> 0x007f }
            r13 = 0
            long r13 = r12.optLong(r9, r13)     // Catch:{ all -> 0x007f }
            boolean r9 = com.tencent.tpns.baseapi.base.util.Util.checkAccessId(r13)     // Catch:{ all -> 0x007f }
            if (r9 == 0) goto L_0x007c
            java.lang.String r9 = "rpTs"
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x007f }
            r15 = 1000(0x3e8, double:4.94E-321)
            long r13 = r13 / r15
            r12.put(r9, r13)     // Catch:{ all -> 0x007f }
            java.lang.StringBuilder r9 = r1.f70049d     // Catch:{ all -> 0x007f }
            java.lang.String r11 = r12.toString()     // Catch:{ all -> 0x007f }
            r9.append(r11)     // Catch:{ all -> 0x007f }
            int r9 = r6 + -1
            if (r8 == r9) goto L_0x007c
            java.lang.StringBuilder r9 = r1.f70049d     // Catch:{ all -> 0x007f }
            java.lang.String r11 = ","
            r9.append(r11)     // Catch:{ all -> 0x007f }
        L_0x007c:
            int r8 = r8 + 1
            goto L_0x003f
        L_0x007f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c6 }
            r0.<init>()     // Catch:{ all -> 0x03c6 }
            java.lang.String r2 = "unexpected for:"
            r0.append(r2)     // Catch:{ all -> 0x03c6 }
            throw r7     // Catch:{ all -> 0x03c6 }
        L_0x008a:
            java.lang.StringBuilder r6 = r1.f70049d     // Catch:{ all -> 0x03c6 }
            java.lang.String r8 = "]"
            r6.append(r8)     // Catch:{ all -> 0x03c6 }
            java.lang.StringBuilder r6 = r1.f70049d     // Catch:{ all -> 0x03c6 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x03c6 }
            int r8 = r6.length()     // Catch:{ all -> 0x03c6 }
            android.content.Context r11 = f70048c     // Catch:{ all -> 0x03c6 }
            java.lang.String r11 = com.tencent.tpns.baseapi.XGApiConfig.getStatServerAddr(r11)     // Catch:{ all -> 0x03c6 }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ all -> 0x00e8 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00e8 }
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ all -> 0x00e8 }
            r12.<init>(r0)     // Catch:{ all -> 0x00e8 }
            java.lang.String r0 = "msgId"
            java.lang.String r0 = r12.optString(r0, r5)     // Catch:{ all -> 0x00e8 }
            java.lang.String r9 = r12.optString(r9, r5)     // Catch:{ all -> 0x00e8 }
            java.lang.String r13 = "sdkVersion"
            java.lang.String r13 = r12.optString(r13, r5)     // Catch:{ all -> 0x00e5 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00e3 }
            if (r0 != 0) goto L_0x00cc
            com.tencent.android.tpush.stat.b.c r0 = f70047b     // Catch:{ all -> 0x00e3 }
            java.lang.String r12 = "stat for pushAction"
            r0.h(r12)     // Catch:{ all -> 0x00e3 }
            goto L_0x0105
        L_0x00cc:
            java.lang.String r0 = "customEvent"
            boolean r0 = r12.has(r0)     // Catch:{ all -> 0x00e3 }
            if (r0 == 0) goto L_0x00db
            android.content.Context r0 = f70048c     // Catch:{ all -> 0x00e3 }
            java.lang.String r0 = com.tencent.tpns.baseapi.XGApiConfig.getCustomEvenServerAddr(r0)     // Catch:{ all -> 0x00e3 }
            goto L_0x00e1
        L_0x00db:
            android.content.Context r0 = f70048c     // Catch:{ all -> 0x00e3 }
            java.lang.String r0 = com.tencent.tpns.baseapi.XGApiConfig.getErrCodeServerAddr(r0)     // Catch:{ all -> 0x00e3 }
        L_0x00e1:
            r11 = r0
            goto L_0x0105
        L_0x00e3:
            r0 = move-exception
            goto L_0x00eb
        L_0x00e5:
            r0 = move-exception
            r13 = r5
            goto L_0x00eb
        L_0x00e8:
            r0 = move-exception
            r9 = r5
            r13 = r9
        L_0x00eb:
            com.tencent.android.tpush.stat.b.c r12 = f70047b     // Catch:{ all -> 0x03c6 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c6 }
            r14.<init>()     // Catch:{ all -> 0x03c6 }
            java.lang.String r15 = "parse event to json error: "
            r14.append(r15)     // Catch:{ all -> 0x03c6 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03c6 }
            r14.append(r0)     // Catch:{ all -> 0x03c6 }
            java.lang.String r0 = r14.toString()     // Catch:{ all -> 0x03c6 }
            r12.f(r0)     // Catch:{ all -> 0x03c6 }
        L_0x0105:
            boolean r0 = com.tencent.android.tpush.stat.d.b()     // Catch:{ all -> 0x03c6 }
            if (r0 == 0) goto L_0x012f
            com.tencent.android.tpush.stat.b.c r0 = f70047b     // Catch:{ all -> 0x03c6 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c6 }
            r12.<init>()     // Catch:{ all -> 0x03c6 }
            r12.append(r3)     // Catch:{ all -> 0x03c6 }
            r12.append(r11)     // Catch:{ all -> 0x03c6 }
            java.lang.String r3 = "]Send request("
            r12.append(r3)     // Catch:{ all -> 0x03c6 }
            r12.append(r8)     // Catch:{ all -> 0x03c6 }
            java.lang.String r3 = "bytes), content:"
            r12.append(r3)     // Catch:{ all -> 0x03c6 }
            r12.append(r6)     // Catch:{ all -> 0x03c6 }
            java.lang.String r3 = r12.toString()     // Catch:{ all -> 0x03c6 }
            r0.b((java.lang.Object) r3)     // Catch:{ all -> 0x03c6 }
        L_0x012f:
            java.net.URL r0 = new java.net.URL     // Catch:{ all -> 0x03c6 }
            r0.<init>(r11)     // Catch:{ all -> 0x03c6 }
            java.lang.String r3 = r0.getProtocol()     // Catch:{ all -> 0x03c6 }
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x03c6 }
            java.lang.String r11 = "https"
            boolean r3 = r3.equals(r11)     // Catch:{ all -> 0x03c6 }
            if (r3 == 0) goto L_0x0162
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ all -> 0x03c6 }
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ all -> 0x03c6 }
            org.apache.http.conn.ssl.X509HostnameVerifier r3 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER     // Catch:{ all -> 0x03c6 }
            r0.setHostnameVerifier(r3)     // Catch:{ all -> 0x03c6 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x03c6 }
            r11 = 20
            if (r3 >= r11) goto L_0x0168
            com.tencent.tpns.baseapi.core.net.TlsCompatSocketFactory r3 = new com.tencent.tpns.baseapi.core.net.TlsCompatSocketFactory     // Catch:{ all -> 0x03c6 }
            javax.net.ssl.SSLSocketFactory r11 = r0.getSSLSocketFactory()     // Catch:{ all -> 0x03c6 }
            r3.<init>(r11)     // Catch:{ all -> 0x03c6 }
            r0.setSSLSocketFactory(r3)     // Catch:{ all -> 0x03c6 }
            goto L_0x0168
        L_0x0162:
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ all -> 0x03c6 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ all -> 0x03c6 }
        L_0x0168:
            r3 = 10000(0x2710, float:1.4013E-41)
            r0.setReadTimeout(r3)     // Catch:{ all -> 0x03c6 }
            r3 = 15000(0x3a98, float:2.102E-41)
            r0.setConnectTimeout(r3)     // Catch:{ all -> 0x03c6 }
            r3 = 1
            r0.setDoInput(r3)     // Catch:{ all -> 0x03c6 }
            r0.setDoOutput(r3)     // Catch:{ all -> 0x03c6 }
            r0.setUseCaches(r10)     // Catch:{ all -> 0x03c6 }
            java.lang.String r3 = "POST"
            r0.setRequestMethod(r3)     // Catch:{ all -> 0x03c6 }
            java.lang.String r3 = "Connection"
            java.lang.String r10 = "Keep-Alive"
            r0.setRequestProperty(r3, r10)     // Catch:{ all -> 0x03c6 }
            java.lang.String r3 = "Accept-Encoding"
            r0.setRequestProperty(r3, r4)     // Catch:{ all -> 0x03c6 }
            if (r9 == 0) goto L_0x019a
            int r3 = r9.length()     // Catch:{ all -> 0x03c6 }
            if (r3 <= 0) goto L_0x019a
            java.lang.String r3 = "AccessId"
            r0.setRequestProperty(r3, r9)     // Catch:{ all -> 0x03c6 }
        L_0x019a:
            if (r13 == 0) goto L_0x01a7
            int r3 = r13.length()     // Catch:{ all -> 0x03c6 }
            if (r3 <= 0) goto L_0x01a7
            java.lang.String r3 = "SdkVersion"
            r0.setRequestProperty(r3, r13)     // Catch:{ all -> 0x03c6 }
        L_0x01a7:
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x03c6 }
            r3.<init>(r8)     // Catch:{ all -> 0x03c6 }
            java.lang.String r8 = "utf-8"
            byte[] r8 = r6.getBytes(r8)     // Catch:{ all -> 0x03c6 }
            int r10 = r8.length     // Catch:{ all -> 0x03c6 }
            java.util.zip.GZIPOutputStream r11 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x03c6 }
            r11.<init>(r3)     // Catch:{ all -> 0x03c6 }
            r11.write(r8)     // Catch:{ all -> 0x03c6 }
            r11.close()     // Catch:{ all -> 0x03c6 }
            byte[] r11 = r3.toByteArray()     // Catch:{ all -> 0x03c6 }
            boolean r12 = com.tencent.android.tpush.stat.d.b()     // Catch:{ all -> 0x03c6 }
            if (r12 == 0) goto L_0x01ec
            com.tencent.android.tpush.stat.b.c r12 = f70047b     // Catch:{ all -> 0x03c6 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c6 }
            r13.<init>()     // Catch:{ all -> 0x03c6 }
            java.lang.String r14 = "before Gzip:"
            r13.append(r14)     // Catch:{ all -> 0x03c6 }
            r13.append(r10)     // Catch:{ all -> 0x03c6 }
            java.lang.String r10 = " bytes, after Gzip:"
            r13.append(r10)     // Catch:{ all -> 0x03c6 }
            int r10 = r11.length     // Catch:{ all -> 0x03c6 }
            r13.append(r10)     // Catch:{ all -> 0x03c6 }
            java.lang.String r10 = " bytes"
            r13.append(r10)     // Catch:{ all -> 0x03c6 }
            java.lang.String r10 = r13.toString()     // Catch:{ all -> 0x03c6 }
            r12.h(r10)     // Catch:{ all -> 0x03c6 }
        L_0x01ec:
            java.lang.String r10 = "ContentAuth"
            java.lang.String r8 = com.tencent.android.tpush.encrypt.a.a(r8)     // Catch:{ all -> 0x03c6 }
            r0.setRequestProperty(r10, r8)     // Catch:{ all -> 0x03c6 }
            java.lang.String r8 = "ContentGzipAuth"
            java.lang.String r10 = com.tencent.android.tpush.encrypt.a.a(r11)     // Catch:{ all -> 0x03c6 }
            r0.setRequestProperty(r8, r10)     // Catch:{ all -> 0x03c6 }
            r0.setRequestProperty(r2, r4)     // Catch:{ all -> 0x03c6 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x024c }
            r8.<init>()     // Catch:{ all -> 0x024c }
            r8.append(r9)     // Catch:{ all -> 0x024c }
            r8.append(r5)     // Catch:{ all -> 0x024c }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x024c }
            android.content.Context r9 = f70048c     // Catch:{ all -> 0x024c }
            java.lang.String r9 = com.tencent.tpns.baseapi.XGApiConfig.getAccessKey(r9)     // Catch:{ all -> 0x024c }
            java.util.Map r8 = com.tencent.tpns.baseapi.base.util.HttpHelper.getSignAuthHeader(r8, r9, r11)     // Catch:{ all -> 0x024c }
            if (r8 == 0) goto L_0x024c
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x024c }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x024c }
        L_0x0224:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x024c }
            if (r9 == 0) goto L_0x024c
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x024c }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ all -> 0x024c }
            java.lang.Object r10 = r9.getKey()     // Catch:{ all -> 0x024c }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x024c }
            java.lang.Object r9 = r9.getValue()     // Catch:{ all -> 0x024c }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x024c }
            boolean r12 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r10)     // Catch:{ all -> 0x024c }
            if (r12 != 0) goto L_0x0224
            if (r9 == 0) goto L_0x0224
            java.lang.String r9 = r9.trim()     // Catch:{ all -> 0x024c }
            r0.setRequestProperty(r10, r9)     // Catch:{ all -> 0x024c }
            goto L_0x0224
        L_0x024c:
            java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ all -> 0x03c6 }
            java.io.OutputStream r9 = r0.getOutputStream()     // Catch:{ all -> 0x03c6 }
            r8.<init>(r9)     // Catch:{ all -> 0x03c6 }
            r8.write(r11)     // Catch:{ all -> 0x03c6 }
            r8.flush()     // Catch:{ all -> 0x03c6 }
            int r9 = r0.getResponseCode()     // Catch:{ all -> 0x03c6 }
            java.lang.String r10 = r0.getResponseMessage()     // Catch:{ all -> 0x03c6 }
            int r11 = r0.getContentLength()     // Catch:{ all -> 0x03c6 }
            java.lang.String r2 = r0.getHeaderField(r2)     // Catch:{ all -> 0x03c6 }
            boolean r12 = com.tencent.android.tpush.stat.d.b()     // Catch:{ all -> 0x03c6 }
            if (r12 == 0) goto L_0x029f
            com.tencent.android.tpush.stat.b.c r12 = f70047b     // Catch:{ all -> 0x03c6 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c6 }
            r13.<init>()     // Catch:{ all -> 0x03c6 }
            java.lang.String r14 = "http recv response status code:"
            r13.append(r14)     // Catch:{ all -> 0x03c6 }
            r13.append(r9)     // Catch:{ all -> 0x03c6 }
            java.lang.String r14 = ", responseMsg:"
            r13.append(r14)     // Catch:{ all -> 0x03c6 }
            r13.append(r10)     // Catch:{ all -> 0x03c6 }
            java.lang.String r14 = ",contentLength:"
            r13.append(r14)     // Catch:{ all -> 0x03c6 }
            r13.append(r11)     // Catch:{ all -> 0x03c6 }
            java.lang.String r14 = ",contentEncoding:"
            r13.append(r14)     // Catch:{ all -> 0x03c6 }
            r13.append(r2)     // Catch:{ all -> 0x03c6 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x03c6 }
            r12.b((java.lang.Object) r13)     // Catch:{ all -> 0x03c6 }
        L_0x029f:
            r12 = 200(0xc8, float:2.8E-43)
            if (r9 != r12) goto L_0x039b
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ all -> 0x03c6 }
            java.io.DataInputStream r9 = new java.io.DataInputStream     // Catch:{ all -> 0x03c6 }
            r9.<init>(r0)     // Catch:{ all -> 0x03c6 }
            byte[] r10 = new byte[r11]     // Catch:{ all -> 0x03c6 }
            r9.readFully(r10)     // Catch:{ all -> 0x03c6 }
            r0.close()     // Catch:{ all -> 0x03c6 }
            r9.close()     // Catch:{ all -> 0x03c6 }
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x03c6 }
            java.lang.String r9 = "UTF-8"
            if (r0 == 0) goto L_0x02c9
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x03c6 }
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r9)     // Catch:{ all -> 0x03c6 }
            r5.<init>(r10, r0)     // Catch:{ all -> 0x03c6 }
            goto L_0x0326
        L_0x02c9:
            java.lang.String r0 = "gzip,rc4"
            boolean r0 = r2.equalsIgnoreCase(r0)     // Catch:{ all -> 0x03c6 }
            if (r0 == 0) goto L_0x02e3
            byte[] r0 = com.tencent.android.tpush.stat.b.b.a((byte[]) r10)     // Catch:{ all -> 0x03c6 }
            byte[] r0 = com.tencent.tpns.baseapi.base.util.RC4.decrypt(r0)     // Catch:{ all -> 0x03c6 }
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x03c6 }
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r9)     // Catch:{ all -> 0x03c6 }
            r5.<init>(r0, r2)     // Catch:{ all -> 0x03c6 }
            goto L_0x0326
        L_0x02e3:
            java.lang.String r0 = "rc4,gzip"
            boolean r0 = r2.equalsIgnoreCase(r0)     // Catch:{ all -> 0x03c6 }
            if (r0 == 0) goto L_0x02fd
            byte[] r0 = com.tencent.tpns.baseapi.base.util.RC4.decrypt(r10)     // Catch:{ all -> 0x03c6 }
            byte[] r0 = com.tencent.android.tpush.stat.b.b.a((byte[]) r0)     // Catch:{ all -> 0x03c6 }
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x03c6 }
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r9)     // Catch:{ all -> 0x03c6 }
            r5.<init>(r0, r2)     // Catch:{ all -> 0x03c6 }
            goto L_0x0326
        L_0x02fd:
            boolean r0 = r2.equalsIgnoreCase(r4)     // Catch:{ all -> 0x03c6 }
            if (r0 == 0) goto L_0x0311
            byte[] r0 = com.tencent.android.tpush.stat.b.b.a((byte[]) r10)     // Catch:{ all -> 0x03c6 }
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x03c6 }
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r9)     // Catch:{ all -> 0x03c6 }
            r5.<init>(r0, r2)     // Catch:{ all -> 0x03c6 }
            goto L_0x0326
        L_0x0311:
            java.lang.String r0 = "rc4"
            boolean r0 = r2.equalsIgnoreCase(r0)     // Catch:{ all -> 0x03c6 }
            if (r0 == 0) goto L_0x0326
            byte[] r0 = com.tencent.tpns.baseapi.base.util.RC4.decrypt(r10)     // Catch:{ all -> 0x03c6 }
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x03c6 }
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r9)     // Catch:{ all -> 0x03c6 }
            r5.<init>(r0, r2)     // Catch:{ all -> 0x03c6 }
        L_0x0326:
            com.tencent.android.tpush.stat.b.c r0 = f70047b     // Catch:{ all -> 0x03c6 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c6 }
            r2.<init>()     // Catch:{ all -> 0x03c6 }
            java.lang.String r4 = "http recv response data: "
            r2.append(r4)     // Catch:{ all -> 0x03c6 }
            r2.append(r5)     // Catch:{ all -> 0x03c6 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03c6 }
            r0.b((java.lang.Object) r2)     // Catch:{ all -> 0x03c6 }
            int r0 = r5.length()     // Catch:{ all -> 0x03c6 }
            if (r0 <= 0) goto L_0x0390
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x03c6 }
            r0.<init>(r5)     // Catch:{ all -> 0x03c6 }
            r1.a((org.json.JSONObject) r0)     // Catch:{ all -> 0x03c6 }
            if (r19 == 0) goto L_0x03be
            java.lang.String r2 = "ret_code"
            r4 = -1
            int r0 = r0.optInt(r2, r4)     // Catch:{ all -> 0x03c6 }
            if (r0 != 0) goto L_0x0376
            com.tencent.android.tpush.stat.b.c r0 = f70047b     // Catch:{ all -> 0x03c6 }
            java.lang.String r2 = "http data upload ok"
            r0.b((java.lang.Object) r2)     // Catch:{ all -> 0x03c6 }
            r19.a()     // Catch:{ all -> 0x03c6 }
            com.tencent.android.tpush.stat.b.c r0 = f70047b     // Catch:{ all -> 0x03c6 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c6 }
            r2.<init>()     // Catch:{ all -> 0x03c6 }
            java.lang.String r4 = "send Event success:"
            r2.append(r4)     // Catch:{ all -> 0x03c6 }
            r2.append(r6)     // Catch:{ all -> 0x03c6 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03c6 }
            r0.b((java.lang.Object) r2)     // Catch:{ all -> 0x03c6 }
            goto L_0x03be
        L_0x0376:
            com.tencent.android.tpush.stat.b.c r2 = f70047b     // Catch:{ all -> 0x03c6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c6 }
            r4.<init>()     // Catch:{ all -> 0x03c6 }
            java.lang.String r5 = "http response error data ret_code = "
            r4.append(r5)     // Catch:{ all -> 0x03c6 }
            r4.append(r0)     // Catch:{ all -> 0x03c6 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x03c6 }
            r2.e(r0)     // Catch:{ all -> 0x03c6 }
            r19.b()     // Catch:{ all -> 0x03c6 }
            goto L_0x03be
        L_0x0390:
            com.tencent.android.tpush.stat.b.c r0 = f70047b     // Catch:{ all -> 0x03c6 }
            java.lang.String r2 = "http response data null"
            r0.e(r2)     // Catch:{ all -> 0x03c6 }
            r19.b()     // Catch:{ all -> 0x03c6 }
            goto L_0x03be
        L_0x039b:
            com.tencent.android.tpush.stat.b.c r0 = f70047b     // Catch:{ all -> 0x03c6 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c6 }
            r2.<init>()     // Catch:{ all -> 0x03c6 }
            java.lang.String r4 = "Server response error code:"
            r2.append(r4)     // Catch:{ all -> 0x03c6 }
            r2.append(r9)     // Catch:{ all -> 0x03c6 }
            java.lang.String r4 = ", error:"
            r2.append(r4)     // Catch:{ all -> 0x03c6 }
            r2.append(r10)     // Catch:{ all -> 0x03c6 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03c6 }
            r0.e(r2)     // Catch:{ all -> 0x03c6 }
            if (r19 == 0) goto L_0x03be
            r19.b()     // Catch:{ all -> 0x03c6 }
        L_0x03be:
            r8.close()     // Catch:{ all -> 0x03c6 }
            r3.close()     // Catch:{ all -> 0x03c6 }
            r2 = r7
            goto L_0x03c8
        L_0x03c6:
            r0 = move-exception
            r2 = r0
        L_0x03c8:
            if (r2 == 0) goto L_0x03f6
            com.tencent.android.tpush.stat.b.c r0 = f70047b
            r0.a((java.lang.Throwable) r2)
            if (r19 == 0) goto L_0x03dc
            r19.b()     // Catch:{ all -> 0x03d5 }
            goto L_0x03dc
        L_0x03d5:
            r0 = move-exception
            r3 = r0
            com.tencent.android.tpush.stat.b.c r0 = f70047b
            r0.b((java.lang.Throwable) r3)
        L_0x03dc:
            boolean r0 = r2 instanceof java.lang.OutOfMemoryError
            if (r0 == 0) goto L_0x03ef
            r1.f70049d = r7
            java.lang.System.gc()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r2 = 2048(0x800, float:2.87E-42)
            r0.<init>(r2)
            r1.f70049d = r0
            goto L_0x03f6
        L_0x03ef:
            boolean r0 = r2 instanceof java.net.UnknownHostException
            if (r0 == 0) goto L_0x03f4
            goto L_0x03f6
        L_0x03f4:
            boolean r0 = r2 instanceof java.net.SocketTimeoutException
        L_0x03f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.f.a(java.util.List, com.tencent.android.tpush.stat.e):void");
    }

    public void a(Event event, e eVar) {
        b(Arrays.asList(new String[]{event.toJsonString()}), eVar);
    }
}

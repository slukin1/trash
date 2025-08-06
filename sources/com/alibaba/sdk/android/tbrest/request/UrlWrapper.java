package com.alibaba.sdk.android.tbrest.request;

import b3.a;
import com.alibaba.sdk.android.tbrest.SendService;
import com.huochat.community.network.domain.DomainTool;

public class UrlWrapper {

    /* renamed from: a  reason: collision with root package name */
    public static int f14717a;

    /* renamed from: b  reason: collision with root package name */
    public static a f14718b;

    static {
        System.setProperty("http.keepAlive", "true");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.DataOutputStream} */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v10, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01da A[SYNTHETIC, Splitter:B:108:0x01da] */
    /* JADX WARNING: Removed duplicated region for block: B:114:? A[ExcHandler: IOException | MalformedURLException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:5:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0103 A[Catch:{ SSLHandshakeException -> 0x01ba, Exception -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0122 A[SYNTHETIC, Splitter:B:51:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014e A[Catch:{ IOException -> 0x0159, all -> 0x0156 }, LOOP:0: B:61:0x0147->B:63:0x014e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0152 A[EDGE_INSN: B:64:0x0152->B:65:? ?: BREAK  , SYNTHETIC, Splitter:B:64:0x0152] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0168 A[SYNTHETIC, Splitter:B:75:0x0168] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x018d A[SYNTHETIC, Splitter:B:83:0x018d] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01ad A[SYNTHETIC, Splitter:B:93:0x01ad] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:99:0x01bb=Splitter:B:99:0x01bb, B:90:0x019d=Splitter:B:90:0x019d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.sdk.android.tbrest.request.BizResponse a(com.alibaba.sdk.android.tbrest.SendService r7, java.lang.String r8, java.lang.String r9, byte[] r10) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "sendRequest use adashx, bytes length : "
            r0.append(r1)
            if (r10 != 0) goto L_0x000f
            java.lang.String r1 = "0"
            goto L_0x0014
        L_0x000f:
            int r1 = r10.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0014:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.alibaba.sdk.android.tbrest.utils.LogUtil.a(r0)
            com.alibaba.sdk.android.tbrest.request.BizResponse r0 = new com.alibaba.sdk.android.tbrest.request.BizResponse
            r0.<init>()
            java.net.URL r1 = new java.net.URL     // Catch:{ IOException | MalformedURLException -> 0x01e7 }
            r1.<init>(r9)     // Catch:{ IOException | MalformedURLException -> 0x01e7 }
            java.net.URLConnection r9 = r1.openConnection()     // Catch:{ IOException | MalformedURLException -> 0x01e7 }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ IOException | MalformedURLException -> 0x01e7 }
            boolean r2 = r9 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException | MalformedURLException -> 0x01e7 }
            if (r2 == 0) goto L_0x0053
            b3.a r2 = f14718b     // Catch:{ IllegalStateException -> 0x0053, IOException | MalformedURLException -> 0x01e7 }
            if (r2 != 0) goto L_0x004b
            java.lang.String r2 = r1.getHost()     // Catch:{ IllegalStateException -> 0x0053, IOException | MalformedURLException -> 0x01e7 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x0053, IOException | MalformedURLException -> 0x01e7 }
            if (r2 != 0) goto L_0x004b
            b3.a r2 = new b3.a     // Catch:{ IllegalStateException -> 0x0053, IOException | MalformedURLException -> 0x01e7 }
            java.lang.String r1 = r1.getHost()     // Catch:{ IllegalStateException -> 0x0053, IOException | MalformedURLException -> 0x01e7 }
            r2.<init>(r1)     // Catch:{ IllegalStateException -> 0x0053, IOException | MalformedURLException -> 0x01e7 }
            f14718b = r2     // Catch:{ IllegalStateException -> 0x0053, IOException | MalformedURLException -> 0x01e7 }
        L_0x004b:
            r1 = r9
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ IllegalStateException -> 0x0053, IOException | MalformedURLException -> 0x01e7 }
            b3.a r2 = f14718b     // Catch:{ IllegalStateException -> 0x0053, IOException | MalformedURLException -> 0x01e7 }
            r1.setSSLSocketFactory(r2)     // Catch:{ IllegalStateException -> 0x0053, IOException | MalformedURLException -> 0x01e7 }
        L_0x0053:
            if (r9 == 0) goto L_0x01e7
            r1 = 1
            r9.setDoOutput(r1)
            r9.setDoInput(r1)
            java.lang.String r2 = "POST"
            r9.setRequestMethod(r2)     // Catch:{  }
            r2 = 0
            r9.setUseCaches(r2)
            r3 = 10000(0x2710, float:1.4013E-41)
            r9.setConnectTimeout(r3)
            r3 = 60000(0xea60, float:8.4078E-41)
            r9.setReadTimeout(r3)
            r9.setInstanceFollowRedirects(r1)
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/x-www-form-urlencoded"
            r9.setRequestProperty(r3, r4)
            java.lang.String r3 = "Charset"
            java.lang.String r4 = "UTF-8"
            r9.setRequestProperty(r3, r4)
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto L_0x008c
            java.lang.String r3 = "x-k"
            r9.setRequestProperty(r3, r8)
        L_0x008c:
            java.lang.String r7 = r7.f14689d     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = "x-t"
            java.lang.String r4 = "x-s"
            java.lang.String r5 = "signValue:"
            if (r7 == 0) goto L_0x00c4
            int r6 = r7.length()     // Catch:{ all -> 0x00ee }
            if (r6 <= 0) goto L_0x00c4
            a3.a r6 = new a3.a     // Catch:{ all -> 0x00ee }
            r6.<init>(r8, r7, r1)     // Catch:{ all -> 0x00ee }
            java.lang.String r7 = com.alibaba.sdk.android.tbrest.utils.MD5Utils.b(r10)     // Catch:{ all -> 0x00ee }
            java.lang.String r7 = r6.c(r7)     // Catch:{ all -> 0x00ee }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r8.<init>()     // Catch:{ all -> 0x00ee }
            r8.append(r5)     // Catch:{ all -> 0x00ee }
            r8.append(r7)     // Catch:{ all -> 0x00ee }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00ee }
            com.alibaba.sdk.android.tbrest.utils.LogUtil.a(r8)     // Catch:{ all -> 0x00ee }
            r9.setRequestProperty(r4, r7)     // Catch:{ all -> 0x00ee }
            java.lang.String r7 = "2"
            r9.setRequestProperty(r3, r7)     // Catch:{ all -> 0x00ee }
            goto L_0x00f6
        L_0x00c4:
            java.lang.String r7 = ""
            a3.a r1 = new a3.a     // Catch:{ all -> 0x00ee }
            r1.<init>(r8, r7, r2)     // Catch:{ all -> 0x00ee }
            java.lang.String r7 = com.alibaba.sdk.android.tbrest.utils.MD5Utils.b(r10)     // Catch:{ all -> 0x00ee }
            java.lang.String r7 = r1.c(r7)     // Catch:{ all -> 0x00ee }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r8.<init>()     // Catch:{ all -> 0x00ee }
            r8.append(r5)     // Catch:{ all -> 0x00ee }
            r8.append(r7)     // Catch:{ all -> 0x00ee }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00ee }
            com.alibaba.sdk.android.tbrest.utils.LogUtil.a(r8)     // Catch:{ all -> 0x00ee }
            r9.setRequestProperty(r4, r7)     // Catch:{ all -> 0x00ee }
            java.lang.String r7 = "3"
            r9.setRequestProperty(r3, r7)     // Catch:{ all -> 0x00ee }
            goto L_0x00f6
        L_0x00ee:
            r7 = move-exception
            java.lang.String r7 = r7.toString()
            com.alibaba.sdk.android.tbrest.utils.LogUtil.b(r7)
        L_0x00f6:
            long r7 = java.lang.System.currentTimeMillis()
            r1 = 0
            r9.connect()     // Catch:{ SSLHandshakeException -> 0x01ba, Exception -> 0x019c }
            if (r10 == 0) goto L_0x011f
            int r3 = r10.length     // Catch:{ SSLHandshakeException -> 0x01ba, Exception -> 0x019c }
            if (r3 <= 0) goto L_0x011f
            java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ SSLHandshakeException -> 0x01ba, Exception -> 0x019c }
            java.io.OutputStream r4 = r9.getOutputStream()     // Catch:{ SSLHandshakeException -> 0x01ba, Exception -> 0x019c }
            r3.<init>(r4)     // Catch:{ SSLHandshakeException -> 0x01ba, Exception -> 0x019c }
            r3.write(r10)     // Catch:{ SSLHandshakeException -> 0x011b, Exception -> 0x0117, all -> 0x0113 }
            r3.flush()     // Catch:{ SSLHandshakeException -> 0x011b, Exception -> 0x0117, all -> 0x0113 }
            goto L_0x0120
        L_0x0113:
            r7 = move-exception
            r1 = r3
            goto L_0x01d8
        L_0x0117:
            r9 = move-exception
            r1 = r3
            goto L_0x019d
        L_0x011b:
            r9 = move-exception
            r1 = r3
            goto L_0x01bb
        L_0x011f:
            r3 = r1
        L_0x0120:
            if (r3 == 0) goto L_0x012e
            r3.close()     // Catch:{ IOException -> 0x0126 }
            goto L_0x012e
        L_0x0126:
            r10 = move-exception
            java.lang.String r10 = r10.toString()
            com.alibaba.sdk.android.tbrest.utils.LogUtil.b(r10)
        L_0x012e:
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r7
            r0.f14715b = r3
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream
            r7.<init>()
            java.io.DataInputStream r8 = new java.io.DataInputStream     // Catch:{ IOException -> 0x015e }
            java.io.InputStream r9 = r9.getInputStream()     // Catch:{ IOException -> 0x015e }
            r8.<init>(r9)     // Catch:{ IOException -> 0x015e }
            r9 = 2048(0x800, float:2.87E-42)
            byte[] r10 = new byte[r9]     // Catch:{ IOException -> 0x0159, all -> 0x0156 }
        L_0x0147:
            int r1 = r8.read(r10, r2, r9)     // Catch:{ IOException -> 0x0159, all -> 0x0156 }
            r3 = -1
            if (r1 == r3) goto L_0x0152
            r7.write(r10, r2, r1)     // Catch:{ IOException -> 0x0159, all -> 0x0156 }
            goto L_0x0147
        L_0x0152:
            r8.close()     // Catch:{ Exception -> 0x016c }
            goto L_0x0174
        L_0x0156:
            r7 = move-exception
            r1 = r8
            goto L_0x018b
        L_0x0159:
            r9 = move-exception
            r1 = r8
            goto L_0x015f
        L_0x015c:
            r7 = move-exception
            goto L_0x018b
        L_0x015e:
            r9 = move-exception
        L_0x015f:
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x015c }
            com.alibaba.sdk.android.tbrest.utils.LogUtil.b(r8)     // Catch:{ all -> 0x015c }
            if (r1 == 0) goto L_0x0174
            r1.close()     // Catch:{ Exception -> 0x016c }
            goto L_0x0174
        L_0x016c:
            r8 = move-exception
            java.lang.String r8 = r8.toString()
            com.alibaba.sdk.android.tbrest.utils.LogUtil.b(r8)
        L_0x0174:
            int r8 = r7.size()
            if (r8 <= 0) goto L_0x01e7
            byte[] r7 = r7.toByteArray()
            int r7 = com.alibaba.sdk.android.tbrest.request.BizRequest.e(r7)
            f14717a = r7
            r0.f14714a = r7
            java.lang.String r7 = com.alibaba.sdk.android.tbrest.request.BizRequest.f14712b
            r0.f14716c = r7
            goto L_0x01e7
        L_0x018b:
            if (r1 == 0) goto L_0x0199
            r1.close()     // Catch:{ Exception -> 0x0191 }
            goto L_0x0199
        L_0x0191:
            r8 = move-exception
            java.lang.String r8 = r8.toString()
            com.alibaba.sdk.android.tbrest.utils.LogUtil.b(r8)
        L_0x0199:
            throw r7
        L_0x019a:
            r7 = move-exception
            goto L_0x01d8
        L_0x019c:
            r9 = move-exception
        L_0x019d:
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x019a }
            com.alibaba.sdk.android.tbrest.utils.LogUtil.b(r9)     // Catch:{ all -> 0x019a }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x019a }
            long r9 = r9 - r7
            r0.f14715b = r9     // Catch:{ all -> 0x019a }
            if (r1 == 0) goto L_0x01b9
            r1.close()     // Catch:{ IOException -> 0x01b1 }
            goto L_0x01b9
        L_0x01b1:
            r7 = move-exception
            java.lang.String r7 = r7.toString()
            com.alibaba.sdk.android.tbrest.utils.LogUtil.b(r7)
        L_0x01b9:
            return r0
        L_0x01ba:
            r9 = move-exception
        L_0x01bb:
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x019a }
            com.alibaba.sdk.android.tbrest.utils.LogUtil.b(r9)     // Catch:{ all -> 0x019a }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x019a }
            long r9 = r9 - r7
            r0.f14715b = r9     // Catch:{ all -> 0x019a }
            if (r1 == 0) goto L_0x01d7
            r1.close()     // Catch:{ IOException -> 0x01cf }
            goto L_0x01d7
        L_0x01cf:
            r7 = move-exception
            java.lang.String r7 = r7.toString()
            com.alibaba.sdk.android.tbrest.utils.LogUtil.b(r7)
        L_0x01d7:
            return r0
        L_0x01d8:
            if (r1 == 0) goto L_0x01e6
            r1.close()     // Catch:{ IOException -> 0x01de }
            goto L_0x01e6
        L_0x01de:
            r8 = move-exception
            java.lang.String r8 = r8.toString()
            com.alibaba.sdk.android.tbrest.utils.LogUtil.b(r8)
        L_0x01e6:
            throw r7
        L_0x01e7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.tbrest.request.UrlWrapper.a(com.alibaba.sdk.android.tbrest.SendService, java.lang.String, java.lang.String, byte[]):com.alibaba.sdk.android.tbrest.request.BizResponse");
    }

    public static BizResponse b(SendService sendService, String str, byte[] bArr) {
        String str2;
        String str3 = sendService.f14688c;
        if (sendService.f14694i.booleanValue()) {
            str2 = DomainTool.DOMAIN_PREFIX_HTTP + str + "/upload";
        } else {
            str2 = DomainTool.DOMAIN_PREFIX + str + "/upload";
        }
        return a(sendService, str3, str2, bArr);
    }
}

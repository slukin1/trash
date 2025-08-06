package ty;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static e f40582a = null;

    /* renamed from: b  reason: collision with root package name */
    public static c f40583b = null;

    static {
        System.setProperty("http.keepAlive", "true");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r6v11, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r6v13, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r10v3, types: [java.io.DataInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r6v14 */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r6v16 */
    /* JADX WARNING: type inference failed for: r10v5, types: [java.io.DataInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r6v30 */
    /* JADX WARNING: type inference failed for: r6v33 */
    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x022f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0230, code lost:
        com.ta.a.e.h.e("", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01cd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01ce, code lost:
        r2 = r0;
        r6 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01d1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01d2, code lost:
        r6 = r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x021b A[SYNTHETIC, Splitter:B:106:0x021b] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x022b A[SYNTHETIC, Splitter:B:112:0x022b] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01cd A[ExcHandler: all (r0v27 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r10 
      PHI: (r10v4 ?) = (r10v3 ?), (r10v5 ?) binds: [B:88:0x01e8, B:68:0x01b3] A[DONT_GENERATE, DONT_INLINE], Splitter:B:68:0x01b3] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01f0 A[Catch:{ Exception -> 0x020e, all -> 0x01cd }, LOOP:1: B:90:0x01ea->B:92:0x01f0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01f4 A[EDGE_INSN: B:93:0x01f4->B:94:? ?: BREAK  , SYNTHETIC, Splitter:B:93:0x01f4] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0207  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.ta.a.d.a a(java.lang.String r17, java.lang.String r18, boolean r19) {
        /*
            r0 = r18
            java.lang.String r1 = ""
            com.ta.a.d.a r2 = new com.ta.a.d.a
            r2.<init>()
            boolean r3 = android.text.TextUtils.isEmpty(r17)
            if (r3 == 0) goto L_0x0010
            return r2
        L_0x0010:
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            r5 = r17
            r4.<init>(r5)     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            java.lang.String r5 = r4.getHost()     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            if (r5 == 0) goto L_0x0023
            return r2
        L_0x0023:
            java.net.URLConnection r5 = r4.openConnection()     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            boolean r6 = r5 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            if (r6 == 0) goto L_0x005b
            ty.e r6 = f40582a     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            if (r6 != 0) goto L_0x003c
            ty.e r6 = new ty.e     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            java.lang.String r7 = r4.getHost()     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            r6.<init>(r7)     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            f40582a = r6     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
        L_0x003c:
            ty.c r6 = f40583b     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            if (r6 != 0) goto L_0x004b
            ty.c r6 = new ty.c     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            java.lang.String r4 = r4.getHost()     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            r6.<init>(r4)     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            f40583b = r6     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
        L_0x004b:
            r4 = r5
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            ty.e r6 = f40582a     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            r4.setSSLSocketFactory(r6)     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            r4 = r5
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            ty.c r6 = f40583b     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
            r4.setHostnameVerifier(r6)     // Catch:{ MalformedURLException -> 0x027f, IOException -> 0x0278, all -> 0x0271 }
        L_0x005b:
            if (r5 == 0) goto L_0x0270
            r4 = 1
            r5.setDoInput(r4)
            if (r19 == 0) goto L_0x0073
            r5.setDoOutput(r4)
            java.lang.String r6 = "POST"
            r5.setRequestMethod(r6)     // Catch:{ ProtocolException -> 0x006c }
            goto L_0x0078
        L_0x006c:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r3]
            com.ta.a.e.h.d(r1, r0, r3)
            return r2
        L_0x0073:
            java.lang.String r6 = "GET"
            r5.setRequestMethod(r6)     // Catch:{ ProtocolException -> 0x026a }
        L_0x0078:
            r5.setUseCaches(r3)
            r6 = 10000(0x2710, float:1.4013E-41)
            r5.setConnectTimeout(r6)
            r5.setReadTimeout(r6)
            r5.setInstanceFollowRedirects(r4)
            java.lang.String r6 = "Content-Type"
            java.lang.String r7 = "application/x-www-form-urlencoded"
            r5.setRequestProperty(r6, r7)
            java.lang.String r6 = "Charset"
            java.lang.String r7 = "UTF-8"
            r5.setRequestProperty(r6, r7)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "x-audid-appkey"
            r5.setRequestProperty(r8, r1)
            py.a r8 = py.a.c()
            android.content.Context r8 = r8.f()
            java.lang.String r8 = r8.getPackageName()
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x00bc
            java.lang.String r9 = "x-audid-appname"
            java.lang.String r7 = java.net.URLEncoder.encode(r8, r7)     // Catch:{ Exception -> 0x00bc }
            r5.setRequestProperty(r9, r7)     // Catch:{ Exception -> 0x00bc }
            r6.append(r8)     // Catch:{ Exception -> 0x00bc }
        L_0x00bc:
            java.lang.String r7 = "x-audid-sdk"
            java.lang.String r8 = "2.5.1"
            r5.setRequestProperty(r7, r8)
            r6.append(r8)
            py.a r7 = py.a.c()
            java.lang.String r7 = r7.b()
            java.lang.String r8 = "x-audid-timestamp"
            r5.setRequestProperty(r8, r7)
            java.lang.Object[] r9 = new java.lang.Object[r4]
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "timestamp:"
            r10.append(r11)
            r10.append(r7)
            java.lang.String r10 = r10.toString()
            r9[r3] = r10
            com.ta.a.e.h.e(r1, r9)
            r6.append(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = uy.d.e(r6)
            byte[] r6 = r6.getBytes()
            r7 = 2
            java.lang.String r6 = vy.b.f(r6, r7)
            java.lang.String r7 = "signature"
            r5.setRequestProperty(r7, r6)
            long r9 = java.lang.System.currentTimeMillis()
            r6 = 0
            r5.connect()     // Catch:{ all -> 0x0239 }
            if (r0 == 0) goto L_0x012b
            int r11 = r18.length()     // Catch:{ all -> 0x0239 }
            if (r11 <= 0) goto L_0x012b
            java.io.DataOutputStream r11 = new java.io.DataOutputStream     // Catch:{ all -> 0x0239 }
            java.io.OutputStream r12 = r5.getOutputStream()     // Catch:{ all -> 0x0239 }
            r11.<init>(r12)     // Catch:{ all -> 0x0239 }
            r11.writeBytes(r0)     // Catch:{ all -> 0x0127 }
            r11.flush()     // Catch:{ all -> 0x0127 }
            goto L_0x012c
        L_0x0127:
            r0 = move-exception
            r6 = r11
            goto L_0x023a
        L_0x012b:
            r11 = r6
        L_0x012c:
            if (r11 == 0) goto L_0x013b
            r11.close()     // Catch:{ IOException -> 0x0132 }
            goto L_0x013b
        L_0x0132:
            r0 = move-exception
            r11 = r0
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r3] = r11
            com.ta.a.e.h.e(r1, r0)
        L_0x013b:
            int r0 = r5.getResponseCode()     // Catch:{ Exception -> 0x0148 }
            r2.f40357a = r0     // Catch:{ Exception -> 0x0148 }
            java.lang.String r0 = r5.getHeaderField(r7)     // Catch:{ Exception -> 0x0148 }
            r2.f40359c = r0     // Catch:{ Exception -> 0x0148 }
            goto L_0x0150
        L_0x0148:
            r0 = move-exception
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r7[r3] = r0
            com.ta.a.e.h.e(r1, r7)
        L_0x0150:
            java.lang.String r0 = r5.getHeaderField(r8)     // Catch:{ Exception -> 0x019b }
            long r7 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x019b }
            r2.f40358b = r7     // Catch:{ Exception -> 0x019b }
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x019b }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x019b }
            r7.<init>()     // Catch:{ Exception -> 0x019b }
            java.lang.String r8 = "repsonse.timestamp:"
            r7.append(r8)     // Catch:{ Exception -> 0x019b }
            long r11 = r2.f40358b     // Catch:{ Exception -> 0x019b }
            r7.append(r11)     // Catch:{ Exception -> 0x019b }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x019b }
            r0[r3] = r7     // Catch:{ Exception -> 0x019b }
            com.ta.a.e.h.e(r1, r0)     // Catch:{ Exception -> 0x019b }
            py.a r0 = py.a.c()     // Catch:{ Exception -> 0x019b }
            long r7 = r0.a()     // Catch:{ Exception -> 0x019b }
            long r11 = r2.f40358b     // Catch:{ Exception -> 0x019b }
            r13 = 0
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x019b
            r13 = 1800000(0x1b7740, double:8.89318E-318)
            long r15 = r7 + r13
            int r0 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r0 > 0) goto L_0x0192
            long r7 = r7 - r13
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x019b
        L_0x0192:
            py.a r0 = py.a.c()     // Catch:{ Exception -> 0x019b }
            long r7 = r2.f40358b     // Catch:{ Exception -> 0x019b }
            r0.d(r7)     // Catch:{ Exception -> 0x019b }
        L_0x019b:
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 - r9
            r2.f40361e = r7
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream
            r7.<init>()
            r8 = -1
            r9 = 2048(0x800, float:2.87E-42)
            java.io.DataInputStream r10 = new java.io.DataInputStream     // Catch:{ IOException -> 0x01d7 }
            java.io.InputStream r0 = r5.getInputStream()     // Catch:{ IOException -> 0x01d7 }
            r10.<init>(r0)     // Catch:{ IOException -> 0x01d7 }
            byte[] r0 = new byte[r9]     // Catch:{ IOException -> 0x01d1, all -> 0x01cd }
        L_0x01b5:
            int r6 = r10.read(r0, r3, r9)     // Catch:{ IOException -> 0x01d1, all -> 0x01cd }
            if (r6 == r8) goto L_0x01bf
            r7.write(r0, r3, r6)     // Catch:{ IOException -> 0x01d1, all -> 0x01cd }
            goto L_0x01b5
        L_0x01bf:
            r10.close()     // Catch:{ Exception -> 0x01c3 }
            goto L_0x0201
        L_0x01c3:
            r0 = move-exception
            r5 = r0
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r3] = r5
            com.ta.a.e.h.e(r1, r0)
            goto L_0x0201
        L_0x01cd:
            r0 = move-exception
            r2 = r0
            r6 = r10
            goto L_0x0229
        L_0x01d1:
            r0 = move-exception
            r6 = r10
            goto L_0x01d8
        L_0x01d4:
            r0 = move-exception
            r2 = r0
            goto L_0x0229
        L_0x01d7:
            r0 = move-exception
        L_0x01d8:
            java.lang.Object[] r10 = new java.lang.Object[r4]     // Catch:{ all -> 0x01d4 }
            r10[r3] = r0     // Catch:{ all -> 0x01d4 }
            com.ta.a.e.h.e(r1, r10)     // Catch:{ all -> 0x01d4 }
            java.io.DataInputStream r10 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0211 }
            java.io.InputStream r0 = r5.getErrorStream()     // Catch:{ Exception -> 0x0211 }
            r10.<init>(r0)     // Catch:{ Exception -> 0x0211 }
            byte[] r0 = new byte[r9]     // Catch:{ Exception -> 0x020e, all -> 0x01cd }
        L_0x01ea:
            int r5 = r10.read(r0, r3, r9)     // Catch:{ Exception -> 0x020e, all -> 0x01cd }
            if (r5 == r8) goto L_0x01f4
            r7.write(r0, r3, r5)     // Catch:{ Exception -> 0x020e, all -> 0x01cd }
            goto L_0x01ea
        L_0x01f4:
            r10.close()     // Catch:{ Exception -> 0x01f8 }
            goto L_0x0201
        L_0x01f8:
            r0 = move-exception
            r5 = r0
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r3] = r5
            com.ta.a.e.h.e(r1, r0)
        L_0x0201:
            int r0 = r7.size()
            if (r0 <= 0) goto L_0x0270
            byte[] r0 = r7.toByteArray()
            r2.f40360d = r0
            goto L_0x0270
        L_0x020e:
            r0 = move-exception
            r6 = r10
            goto L_0x0212
        L_0x0211:
            r0 = move-exception
        L_0x0212:
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x01d4 }
            r5[r3] = r0     // Catch:{ all -> 0x01d4 }
            com.ta.a.e.h.e(r1, r5)     // Catch:{ all -> 0x01d4 }
            if (r6 == 0) goto L_0x0228
            r6.close()     // Catch:{ Exception -> 0x021f }
            goto L_0x0228
        L_0x021f:
            r0 = move-exception
            r5 = r0
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r3] = r5
            com.ta.a.e.h.e(r1, r0)
        L_0x0228:
            return r2
        L_0x0229:
            if (r6 == 0) goto L_0x0238
            r6.close()     // Catch:{ Exception -> 0x022f }
            goto L_0x0238
        L_0x022f:
            r0 = move-exception
            r5 = r0
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r3] = r5
            com.ta.a.e.h.e(r1, r0)
        L_0x0238:
            throw r2
        L_0x0239:
            r0 = move-exception
        L_0x023a:
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0258 }
            r5[r3] = r0     // Catch:{ all -> 0x0258 }
            com.ta.a.e.h.e(r1, r5)     // Catch:{ all -> 0x0258 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0258 }
            long r7 = r7 - r9
            r2.f40361e = r7     // Catch:{ all -> 0x0258 }
            if (r6 == 0) goto L_0x0257
            r6.close()     // Catch:{ IOException -> 0x024e }
            goto L_0x0257
        L_0x024e:
            r0 = move-exception
            r5 = r0
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r3] = r5
            com.ta.a.e.h.e(r1, r0)
        L_0x0257:
            return r2
        L_0x0258:
            r0 = move-exception
            r2 = r0
            if (r6 == 0) goto L_0x0269
            r6.close()     // Catch:{ IOException -> 0x0260 }
            goto L_0x0269
        L_0x0260:
            r0 = move-exception
            r5 = r0
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r3] = r5
            com.ta.a.e.h.e(r1, r0)
        L_0x0269:
            throw r2
        L_0x026a:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r3]
            com.ta.a.e.h.d(r1, r0, r3)
        L_0x0270:
            return r2
        L_0x0271:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r3]
            com.ta.a.e.h.d(r1, r0, r3)
            return r2
        L_0x0278:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r3]
            com.ta.a.e.h.d(r1, r0, r3)
            return r2
        L_0x027f:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r3]
            com.ta.a.e.h.d(r1, r0, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ty.a.a(java.lang.String, java.lang.String, boolean):com.ta.a.d.a");
    }
}

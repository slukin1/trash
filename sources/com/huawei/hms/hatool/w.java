package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.common.net.HttpHeaders;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public abstract class w {

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static n0 a(String str, byte[] bArr, Map<String, String> map) {
        return a(str, bArr, map, "POST");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x00eb, code lost:
        com.huawei.hms.hatool.k1.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0105, code lost:
        com.huawei.hms.hatool.k1.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x011f, code lost:
        com.huawei.hms.hatool.k1.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0139, code lost:
        com.huawei.hms.hatool.k1.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0149, code lost:
        com.huawei.hms.hatool.k1.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0057, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005a, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005d, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0060, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0063, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0066, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x009d, code lost:
        com.huawei.hms.hatool.k1.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00b7, code lost:
        com.huawei.hms.hatool.k1.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x00d1, code lost:
        com.huawei.hms.hatool.k1.a(r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:133:? A[ExcHandler: a (unused com.huawei.hms.hatool.w$a), SYNTHETIC, Splitter:B:18:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0066 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:18:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.hms.hatool.n0 a(java.lang.String r6, byte[] r7, java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "hmsSdk"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0012
            com.huawei.hms.hatool.n0 r6 = new com.huawei.hms.hatool.n0
            r7 = -100
            r6.<init>(r7, r2)
            return r6
        L_0x0012:
            r1 = -102(0xffffffffffffff9a, float:NaN)
            r3 = -101(0xffffffffffffff9b, float:NaN)
            r4 = 0
            int r5 = r7.length     // Catch:{ a -> 0x0123, SecurityException -> 0x0109, SSLPeerUnverifiedException -> 0x00ef, SSLHandshakeException -> 0x00d5, ConnectException -> 0x00bb, UnknownHostException -> 0x00a1, IOException -> 0x0087, all -> 0x0082 }
            java.net.HttpURLConnection r6 = a((java.lang.String) r6, (int) r5, (java.util.Map<java.lang.String, java.lang.String>) r8, (java.lang.String) r9)     // Catch:{ a -> 0x0123, SecurityException -> 0x0109, SSLPeerUnverifiedException -> 0x00ef, SSLHandshakeException -> 0x00d5, ConnectException -> 0x00bb, UnknownHostException -> 0x00a1, IOException -> 0x0087, all -> 0x0082 }
            if (r6 != 0) goto L_0x002f
            com.huawei.hms.hatool.n0 r7 = new com.huawei.hms.hatool.n0     // Catch:{ a -> 0x007f, SecurityException -> 0x007c, SSLPeerUnverifiedException -> 0x0079, SSLHandshakeException -> 0x0076, ConnectException -> 0x0074, UnknownHostException -> 0x0072, IOException -> 0x0070, all -> 0x006c }
            r7.<init>(r3, r2)     // Catch:{ a -> 0x007f, SecurityException -> 0x007c, SSLPeerUnverifiedException -> 0x0079, SSLHandshakeException -> 0x0076, ConnectException -> 0x0074, UnknownHostException -> 0x0072, IOException -> 0x0070, all -> 0x006c }
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r4)
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r4)
            if (r6 == 0) goto L_0x002e
            com.huawei.hms.hatool.k1.a((java.net.HttpURLConnection) r6)
        L_0x002e:
            return r7
        L_0x002f:
            java.io.OutputStream r8 = r6.getOutputStream()     // Catch:{ a -> 0x007f, SecurityException -> 0x007c, SSLPeerUnverifiedException -> 0x0079, SSLHandshakeException -> 0x0076, ConnectException -> 0x0074, UnknownHostException -> 0x0072, IOException -> 0x0070, all -> 0x006c }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ a -> 0x0125, SecurityException -> 0x010b, SSLPeerUnverifiedException -> 0x00f1, SSLHandshakeException -> 0x00d7, ConnectException -> 0x00bd, UnknownHostException -> 0x00a3, IOException -> 0x0089, all -> 0x0069 }
            r9.<init>(r8)     // Catch:{ a -> 0x0125, SecurityException -> 0x010b, SSLPeerUnverifiedException -> 0x00f1, SSLHandshakeException -> 0x00d7, ConnectException -> 0x00bd, UnknownHostException -> 0x00a3, IOException -> 0x0089, all -> 0x0069 }
            r9.write(r7)     // Catch:{ a -> 0x0126, SecurityException -> 0x010c, SSLPeerUnverifiedException -> 0x00f2, SSLHandshakeException -> 0x00d8, ConnectException -> 0x00be, UnknownHostException -> 0x00a4, IOException -> 0x008a, all -> 0x0066 }
            r9.flush()     // Catch:{ a -> 0x0126, SecurityException -> 0x010c, SSLPeerUnverifiedException -> 0x00f2, SSLHandshakeException -> 0x00d8, ConnectException -> 0x00be, UnknownHostException -> 0x00a4, IOException -> 0x008a, all -> 0x0066 }
            int r7 = r6.getResponseCode()     // Catch:{ a -> 0x0126, SecurityException -> 0x010c, SSLPeerUnverifiedException -> 0x00f2, SSLHandshakeException -> 0x00d8, ConnectException -> 0x00be, UnknownHostException -> 0x00a4, IOException -> 0x008a, all -> 0x0066 }
            java.lang.String r1 = b(r6)     // Catch:{ a -> 0x0126, SecurityException -> 0x0063, SSLPeerUnverifiedException -> 0x0060, SSLHandshakeException -> 0x005d, ConnectException -> 0x005a, UnknownHostException -> 0x0057, IOException -> 0x0055, all -> 0x0066 }
            com.huawei.hms.hatool.n0 r4 = new com.huawei.hms.hatool.n0     // Catch:{ a -> 0x0126, SecurityException -> 0x0063, SSLPeerUnverifiedException -> 0x0060, SSLHandshakeException -> 0x005d, ConnectException -> 0x005a, UnknownHostException -> 0x0057, IOException -> 0x0055, all -> 0x0066 }
            r4.<init>(r7, r1)     // Catch:{ a -> 0x0126, SecurityException -> 0x0063, SSLPeerUnverifiedException -> 0x0060, SSLHandshakeException -> 0x005d, ConnectException -> 0x005a, UnknownHostException -> 0x0057, IOException -> 0x0055, all -> 0x0066 }
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r9)
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r8)
            com.huawei.hms.hatool.k1.a((java.net.HttpURLConnection) r6)
            return r4
        L_0x0055:
            r1 = r7
            goto L_0x008a
        L_0x0057:
            r1 = r7
            goto L_0x00a4
        L_0x005a:
            r1 = r7
            goto L_0x00be
        L_0x005d:
            r1 = r7
            goto L_0x00d8
        L_0x0060:
            r1 = r7
            goto L_0x00f2
        L_0x0063:
            r1 = r7
            goto L_0x010c
        L_0x0066:
            r7 = move-exception
            goto L_0x0141
        L_0x0069:
            r7 = move-exception
            goto L_0x0140
        L_0x006c:
            r7 = move-exception
            r8 = r4
            goto L_0x0140
        L_0x0070:
            r8 = r4
            goto L_0x0089
        L_0x0072:
            r8 = r4
            goto L_0x00a3
        L_0x0074:
            r8 = r4
            goto L_0x00bd
        L_0x0076:
            r8 = r4
            goto L_0x00d7
        L_0x0079:
            r8 = r4
            goto L_0x00f1
        L_0x007c:
            r8 = r4
            goto L_0x010b
        L_0x007f:
            r8 = r4
            goto L_0x0125
        L_0x0082:
            r7 = move-exception
            r6 = r4
            r8 = r6
            goto L_0x0140
        L_0x0087:
            r6 = r4
            r8 = r6
        L_0x0089:
            r9 = r4
        L_0x008a:
            r4 = r6
            java.lang.String r6 = "events PostRequest(byte[]): IOException occurred."
            com.huawei.hms.hatool.v.f(r0, r6)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.n0 r6 = new com.huawei.hms.hatool.n0     // Catch:{ all -> 0x013d }
            r6.<init>(r1, r2)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r9)
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r8)
            if (r4 == 0) goto L_0x00a0
            com.huawei.hms.hatool.k1.a((java.net.HttpURLConnection) r4)
        L_0x00a0:
            return r6
        L_0x00a1:
            r6 = r4
            r8 = r6
        L_0x00a3:
            r9 = r4
        L_0x00a4:
            r4 = r6
            java.lang.String r6 = "No address associated with hostname or No network"
            com.huawei.hms.hatool.v.f(r0, r6)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.n0 r6 = new com.huawei.hms.hatool.n0     // Catch:{ all -> 0x013d }
            r6.<init>(r1, r2)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r9)
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r8)
            if (r4 == 0) goto L_0x00ba
            com.huawei.hms.hatool.k1.a((java.net.HttpURLConnection) r4)
        L_0x00ba:
            return r6
        L_0x00bb:
            r6 = r4
            r8 = r6
        L_0x00bd:
            r9 = r4
        L_0x00be:
            r4 = r6
            java.lang.String r6 = "Network is unreachable or Connection refused"
            com.huawei.hms.hatool.v.f(r0, r6)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.n0 r6 = new com.huawei.hms.hatool.n0     // Catch:{ all -> 0x013d }
            r6.<init>(r1, r2)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r9)
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r8)
            if (r4 == 0) goto L_0x00d4
            com.huawei.hms.hatool.k1.a((java.net.HttpURLConnection) r4)
        L_0x00d4:
            return r6
        L_0x00d5:
            r6 = r4
            r8 = r6
        L_0x00d7:
            r9 = r4
        L_0x00d8:
            r4 = r6
            java.lang.String r6 = "Chain validation failed,Certificate expired"
            com.huawei.hms.hatool.v.f(r0, r6)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.n0 r6 = new com.huawei.hms.hatool.n0     // Catch:{ all -> 0x013d }
            r6.<init>(r1, r2)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r9)
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r8)
            if (r4 == 0) goto L_0x00ee
            com.huawei.hms.hatool.k1.a((java.net.HttpURLConnection) r4)
        L_0x00ee:
            return r6
        L_0x00ef:
            r6 = r4
            r8 = r6
        L_0x00f1:
            r9 = r4
        L_0x00f2:
            r4 = r6
            java.lang.String r6 = "Certificate has not been verified,Request is restricted!"
            com.huawei.hms.hatool.v.f(r0, r6)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.n0 r6 = new com.huawei.hms.hatool.n0     // Catch:{ all -> 0x013d }
            r6.<init>(r1, r2)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r9)
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r8)
            if (r4 == 0) goto L_0x0108
            com.huawei.hms.hatool.k1.a((java.net.HttpURLConnection) r4)
        L_0x0108:
            return r6
        L_0x0109:
            r6 = r4
            r8 = r6
        L_0x010b:
            r9 = r4
        L_0x010c:
            r4 = r6
            java.lang.String r6 = "SecurityException with HttpClient. Please check INTERNET permission."
            com.huawei.hms.hatool.v.f(r0, r6)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.n0 r6 = new com.huawei.hms.hatool.n0     // Catch:{ all -> 0x013d }
            r6.<init>(r1, r2)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r9)
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r8)
            if (r4 == 0) goto L_0x0122
            com.huawei.hms.hatool.k1.a((java.net.HttpURLConnection) r4)
        L_0x0122:
            return r6
        L_0x0123:
            r6 = r4
            r8 = r6
        L_0x0125:
            r9 = r4
        L_0x0126:
            r4 = r6
            java.lang.String r6 = "PostRequest(byte[]): No ssl socket factory set!"
            com.huawei.hms.hatool.v.f(r0, r6)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.n0 r6 = new com.huawei.hms.hatool.n0     // Catch:{ all -> 0x013d }
            r6.<init>(r3, r2)     // Catch:{ all -> 0x013d }
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r9)
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r8)
            if (r4 == 0) goto L_0x013c
            com.huawei.hms.hatool.k1.a((java.net.HttpURLConnection) r4)
        L_0x013c:
            return r6
        L_0x013d:
            r7 = move-exception
            r6 = r4
            r4 = r9
        L_0x0140:
            r9 = r4
        L_0x0141:
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r9)
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r8)
            if (r6 == 0) goto L_0x014c
            com.huawei.hms.hatool.k1.a((java.net.HttpURLConnection) r6)
        L_0x014c:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.w.a(java.lang.String, byte[], java.util.Map, java.lang.String):com.huawei.hms.hatool.n0");
    }

    private static HttpURLConnection a(String str, int i11, Map<String, String> map, String str2) {
        if (TextUtils.isEmpty(str)) {
            v.b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS);
        httpURLConnection.setReadTimeout(DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(i11));
        httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry next : map.entrySet()) {
                String str3 = (String) next.getKey();
                if (str3 != null && !TextUtils.isEmpty(str3)) {
                    httpURLConnection.setRequestProperty(str3, (String) next.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.net.HttpURLConnection r3) {
        /*
            java.lang.String r0 = "hmsSdk"
            boolean r1 = r3 instanceof javax.net.ssl.HttpsURLConnection
            if (r1 == 0) goto L_0x0039
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3
            r1 = 0
            android.content.Context r2 = com.huawei.hms.hatool.q0.i()     // Catch:{ NoSuchAlgorithmException -> 0x001e, KeyStoreException -> 0x001b, GeneralSecurityException -> 0x0018, IOException -> 0x0015, IllegalAccessException -> 0x0012 }
            jg.b r1 = jg.b.b(r2)     // Catch:{ NoSuchAlgorithmException -> 0x001e, KeyStoreException -> 0x001b, GeneralSecurityException -> 0x0018, IOException -> 0x0015, IllegalAccessException -> 0x0012 }
            goto L_0x0023
        L_0x0012:
            java.lang.String r2 = "getSocketFactory(): Illegal Access Exception "
            goto L_0x0020
        L_0x0015:
            java.lang.String r2 = "getSocketFactory(): IO Exception!"
            goto L_0x0020
        L_0x0018:
            java.lang.String r2 = "getSocketFactory(): General Security Exception"
            goto L_0x0020
        L_0x001b:
            java.lang.String r2 = "getSocketFactory(): Key Store exception"
            goto L_0x0020
        L_0x001e:
            java.lang.String r2 = "getSocketFactory(): Algorithm Exception!"
        L_0x0020:
            com.huawei.hms.hatool.v.f(r0, r2)
        L_0x0023:
            if (r1 == 0) goto L_0x0031
            r3.setSSLSocketFactory(r1)
            com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier r0 = new com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier
            r0.<init>()
            r3.setHostnameVerifier(r0)
            goto L_0x0039
        L_0x0031:
            com.huawei.hms.hatool.w$a r3 = new com.huawei.hms.hatool.w$a
            java.lang.String r0 = "No ssl socket factory set"
            r3.<init>(r0)
            throw r3
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.w.a(java.net.HttpURLConnection):void");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        com.huawei.hms.hatool.v.f("hmsSdk", "When Response Content From Connection inputStream operation exception! " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        com.huawei.hms.hatool.k1.a((java.io.Closeable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        com.huawei.hms.hatool.k1.a((java.io.Closeable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r4 = r4.getResponseCode();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.net.HttpURLConnection r4) {
        /*
            r0 = 0
            java.io.InputStream r0 = r4.getInputStream()     // Catch:{ IOException -> 0x000f }
            java.lang.String r4 = com.huawei.hms.hatool.k1.a((java.io.InputStream) r0)     // Catch:{ IOException -> 0x000f }
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r0)
            return r4
        L_0x000d:
            r4 = move-exception
            goto L_0x002f
        L_0x000f:
            int r4 = r4.getResponseCode()     // Catch:{ all -> 0x000d }
            java.lang.String r1 = "hmsSdk"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x000d }
            r2.<init>()     // Catch:{ all -> 0x000d }
            java.lang.String r3 = "When Response Content From Connection inputStream operation exception! "
            r2.append(r3)     // Catch:{ all -> 0x000d }
            r2.append(r4)     // Catch:{ all -> 0x000d }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x000d }
            com.huawei.hms.hatool.v.f(r1, r4)     // Catch:{ all -> 0x000d }
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r0)
            java.lang.String r4 = ""
            return r4
        L_0x002f:
            com.huawei.hms.hatool.k1.a((java.io.Closeable) r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.w.b(java.net.HttpURLConnection):java.lang.String");
    }
}

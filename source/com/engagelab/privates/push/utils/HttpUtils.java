package com.engagelab.privates.push.utils;

public class HttpUtils {
    private static final String TAG = "HttpClient";

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f7 A[SYNTHETIC, Splitter:B:42:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ff A[Catch:{ all -> 0x00fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x013c A[SYNTHETIC, Splitter:B:55:0x013c] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0144 A[Catch:{ all -> 0x0140 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x017f A[SYNTHETIC, Splitter:B:68:0x017f] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0187 A[Catch:{ all -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01a4  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:52:0x0122=Splitter:B:52:0x0122, B:65:0x0165=Splitter:B:65:0x0165, B:39:0x00dd=Splitter:B:39:0x00dd} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] get(android.content.Context r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "close failed "
            boolean r9 = com.engagelab.privates.common.utils.SystemUtil.isNetworkConnecting(r9)
            r1 = 0
            java.lang.String r2 = "HttpClient"
            if (r9 != 0) goto L_0x0011
            java.lang.String r9 = "can't get, network is disConnected"
            com.engagelab.privates.common.log.MTCommonLog.d(r2, r9)
            return r1
        L_0x0011:
            java.net.URL r9 = new java.net.URL     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            r9.<init>(r10)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            java.lang.String r10 = "GET"
            r9.setRequestMethod(r10)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            r10 = 6000(0x1770, float:8.408E-42)
            r9.setConnectTimeout(r10)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            r9.setReadTimeout(r10)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            java.lang.String r10 = "Accept-Encoding"
            java.lang.String r3 = "identity"
            r9.setRequestProperty(r10, r3)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            java.lang.String r10 = "Connection"
            java.lang.String r3 = "Close"
            r9.addRequestProperty(r10, r3)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            java.lang.String r10 = "Charset"
            java.lang.String r3 = "UTF-8"
            r9.setRequestProperty(r10, r3)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            boolean r10 = r9 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            if (r10 == 0) goto L_0x0068
            java.lang.String r10 = "TLS"
            javax.net.ssl.SSLContext r10 = javax.net.ssl.SSLContext.getInstance(r10)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            r10.init(r1, r1, r1)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            r3 = r9
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            javax.net.ssl.SSLSocketFactory r10 = r10.getSocketFactory()     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            r3.setSSLSocketFactory(r10)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            r10 = r9
            javax.net.ssl.HttpsURLConnection r10 = (javax.net.ssl.HttpsURLConnection) r10     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            com.engagelab.privates.common.https.HostVerifier r3 = new com.engagelab.privates.common.https.HostVerifier     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            java.net.URL r4 = r9.getURL()     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            java.lang.String r4 = r4.getHost()     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            r3.<init>(r4)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            r10.setHostnameVerifier(r3)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
        L_0x0068:
            r10 = 1
            r9.setDoInput(r10)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            r10 = 0
            r9.setUseCaches(r10)     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            r9.connect()     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            int r3 = r9.getContentLength()     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            int r4 = r9.getResponseCode()     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L_0x00ae
            java.io.InputStream r9 = r9.getInputStream()     // Catch:{ MalformedURLException -> 0x015f, IOException -> 0x011c, all -> 0x00d7 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ MalformedURLException -> 0x00a8, IOException -> 0x00a2, all -> 0x009d }
            r4.<init>()     // Catch:{ MalformedURLException -> 0x00a8, IOException -> 0x00a2, all -> 0x009d }
            byte[] r3 = new byte[r3]     // Catch:{ MalformedURLException -> 0x009a, IOException -> 0x0097, all -> 0x0095 }
        L_0x008a:
            int r5 = r9.read(r3)     // Catch:{ MalformedURLException -> 0x009a, IOException -> 0x0097, all -> 0x0095 }
            r6 = -1
            if (r5 == r6) goto L_0x00b0
            r4.write(r3, r10, r5)     // Catch:{ MalformedURLException -> 0x009a, IOException -> 0x0097, all -> 0x0095 }
            goto L_0x008a
        L_0x0095:
            r10 = move-exception
            goto L_0x00dd
        L_0x0097:
            r10 = move-exception
            goto L_0x0122
        L_0x009a:
            r10 = move-exception
            goto L_0x0165
        L_0x009d:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00d9
        L_0x00a2:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x011e
        L_0x00a8:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x0161
        L_0x00ae:
            r9 = r1
            r4 = r9
        L_0x00b0:
            if (r4 == 0) goto L_0x00b8
            r4.close()     // Catch:{ all -> 0x00b6 }
            goto L_0x00b8
        L_0x00b6:
            r9 = move-exception
            goto L_0x00bf
        L_0x00b8:
            if (r9 == 0) goto L_0x01a1
            r9.close()     // Catch:{ all -> 0x00b6 }
            goto L_0x01a1
        L_0x00bf:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r2, r9)
            goto L_0x01a1
        L_0x00d7:
            r9 = move-exception
            r10 = r1
        L_0x00d9:
            r4 = r1
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x00dd:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a9 }
            r3.<init>()     // Catch:{ all -> 0x01a9 }
            java.lang.String r5 = "get failed "
            r3.append(r5)     // Catch:{ all -> 0x01a9 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x01a9 }
            r3.append(r10)     // Catch:{ all -> 0x01a9 }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x01a9 }
            com.engagelab.privates.common.log.MTCommonLog.w(r2, r10)     // Catch:{ all -> 0x01a9 }
            if (r4 == 0) goto L_0x00fd
            r4.close()     // Catch:{ all -> 0x00fb }
            goto L_0x00fd
        L_0x00fb:
            r9 = move-exception
            goto L_0x0104
        L_0x00fd:
            if (r9 == 0) goto L_0x01a1
            r9.close()     // Catch:{ all -> 0x00fb }
            goto L_0x01a1
        L_0x0104:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r2, r9)
            goto L_0x01a1
        L_0x011c:
            r9 = move-exception
            r10 = r1
        L_0x011e:
            r4 = r1
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0122:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a9 }
            r3.<init>()     // Catch:{ all -> 0x01a9 }
            java.lang.String r5 = "get ioException:"
            r3.append(r5)     // Catch:{ all -> 0x01a9 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x01a9 }
            r3.append(r10)     // Catch:{ all -> 0x01a9 }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x01a9 }
            com.engagelab.privates.common.log.MTCommonLog.w(r2, r10)     // Catch:{ all -> 0x01a9 }
            if (r4 == 0) goto L_0x0142
            r4.close()     // Catch:{ all -> 0x0140 }
            goto L_0x0142
        L_0x0140:
            r9 = move-exception
            goto L_0x0148
        L_0x0142:
            if (r9 == 0) goto L_0x01a1
            r9.close()     // Catch:{ all -> 0x0140 }
            goto L_0x01a1
        L_0x0148:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r2, r9)
            goto L_0x01a1
        L_0x015f:
            r9 = move-exception
            r10 = r1
        L_0x0161:
            r4 = r1
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0165:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a9 }
            r3.<init>()     // Catch:{ all -> 0x01a9 }
            java.lang.String r5 = "get malformedURLException:"
            r3.append(r5)     // Catch:{ all -> 0x01a9 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x01a9 }
            r3.append(r10)     // Catch:{ all -> 0x01a9 }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x01a9 }
            com.engagelab.privates.common.log.MTCommonLog.w(r2, r10)     // Catch:{ all -> 0x01a9 }
            if (r4 == 0) goto L_0x0185
            r4.close()     // Catch:{ all -> 0x0183 }
            goto L_0x0185
        L_0x0183:
            r9 = move-exception
            goto L_0x018b
        L_0x0185:
            if (r9 == 0) goto L_0x01a1
            r9.close()     // Catch:{ all -> 0x0183 }
            goto L_0x01a1
        L_0x018b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r2, r9)
        L_0x01a1:
            if (r4 != 0) goto L_0x01a4
            return r1
        L_0x01a4:
            byte[] r9 = r4.toByteArray()
            return r9
        L_0x01a9:
            r10 = move-exception
            if (r4 == 0) goto L_0x01b2
            r4.close()     // Catch:{ all -> 0x01b0 }
            goto L_0x01b2
        L_0x01b0:
            r9 = move-exception
            goto L_0x01b8
        L_0x01b2:
            if (r9 == 0) goto L_0x01ce
            r9.close()     // Catch:{ all -> 0x01b0 }
            goto L_0x01ce
        L_0x01b8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r9 = r9.getMessage()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r2, r9)
        L_0x01ce:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.engagelab.privates.push.utils.HttpUtils.get(android.content.Context, java.lang.String):byte[]");
    }
}

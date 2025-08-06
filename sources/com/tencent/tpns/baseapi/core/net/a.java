package com.tencent.tpns.baseapi.core.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.SSLPeerUnverifiedException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f49880a;

    /* renamed from: b  reason: collision with root package name */
    private Context f49881b = null;

    private a(Context context) {
        if (context == null) {
            return;
        }
        if (context.getApplicationContext() != null) {
            this.f49881b = context.getApplicationContext();
        } else {
            this.f49881b = context;
        }
    }

    public static a a(Context context) {
        if (f49880a == null) {
            synchronized (a.class) {
                if (f49880a == null) {
                    f49880a = new a(context);
                }
            }
        }
        return f49880a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0093 A[SYNTHETIC, Splitter:B:19:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b7 A[Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fc A[SYNTHETIC, Splitter:B:35:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0198 A[Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01d9 A[Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x026e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(java.lang.String r9, final java.lang.String r10, java.lang.String r11, com.tencent.tpns.baseapi.core.net.HttpRequestCallback r12, boolean r13) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "HttpRequest"
            r2 = 0
            if (r11 != 0) goto L_0x0008
            return r2
        L_0x0008:
            r3 = 0
            int r4 = r11.length()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r5.<init>()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r6 = "["
            r5.append(r6)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r5.append(r9)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r6 = "]Send request("
            r5.append(r6)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r5.append(r4)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r4 = "bytes), content:"
            r5.append(r4)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r5.append(r11)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r4 = r5.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            com.tencent.tpns.baseapi.base.util.Logger.d(r1, r4)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0045 }
            r4.<init>(r11)     // Catch:{ all -> 0x0045 }
            java.lang.String r5 = "accessId"
            java.lang.String r5 = r4.optString(r5, r0)     // Catch:{ all -> 0x0045 }
            java.lang.String r6 = "sdkVersion"
            java.lang.String r4 = r4.optString(r6, r0)     // Catch:{ all -> 0x0043 }
            goto L_0x0060
        L_0x0043:
            r4 = move-exception
            goto L_0x0047
        L_0x0045:
            r4 = move-exception
            r5 = r0
        L_0x0047:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.<init>()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r7 = "parse request body to json error: "
            r6.append(r7)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r4 = r4.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.append(r4)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r4 = r6.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            com.tencent.tpns.baseapi.base.util.Logger.e(r1, r4)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r4 = r0
        L_0x0060:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.<init>()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r7 = "sendHttpPost | url: "
            r6.append(r7)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.append(r9)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r7 = " hostName: "
            r6.append(r7)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.append(r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r6 = r6.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            com.tencent.tpns.baseapi.base.util.Logger.d(r1, r6)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.net.URL r6 = new java.net.URL     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.<init>(r9)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r9 = r6.getProtocol()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r7 = "https"
            boolean r9 = r9.equals(r7)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r7 = "host"
            if (r9 == 0) goto L_0x00b7
            java.net.URLConnection r9 = r6.openConnection()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            javax.net.ssl.HttpsURLConnection r9 = (javax.net.ssl.HttpsURLConnection) r9     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r9.setRequestProperty(r7, r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            com.tencent.tpns.baseapi.core.net.a$1 r6 = new com.tencent.tpns.baseapi.core.net.a$1     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.<init>(r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r9.setHostnameVerifier(r6)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6 = 20
            if (r10 >= r6) goto L_0x00c0
            com.tencent.tpns.baseapi.core.net.TlsCompatSocketFactory r10 = new com.tencent.tpns.baseapi.core.net.TlsCompatSocketFactory     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            javax.net.ssl.SSLSocketFactory r6 = r9.getSSLSocketFactory()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r10.<init>(r6)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r9.setSSLSocketFactory(r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            goto L_0x00c0
        L_0x00b7:
            java.net.URLConnection r9 = r6.openConnection()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r9.setRequestProperty(r7, r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
        L_0x00c0:
            r10 = 15000(0x3a98, float:2.102E-41)
            r9.setReadTimeout(r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6 = 1
            r9.setDoInput(r6)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r9.setDoOutput(r6)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r9.setUseCaches(r3)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r6 = "POST"
            r9.setRequestMethod(r6)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r6 = "Content-Type"
            java.lang.String r7 = "json"
            r9.setRequestProperty(r6, r7)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r9.setConnectTimeout(r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            if (r5 == 0) goto L_0x00eb
            int r10 = r5.length()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            if (r10 <= 0) goto L_0x00eb
            java.lang.String r10 = "AccessId"
            r9.setRequestProperty(r10, r5)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
        L_0x00eb:
            if (r4 == 0) goto L_0x00f8
            int r10 = r4.length()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            if (r10 <= 0) goto L_0x00f8
            java.lang.String r10 = "SdkVersion"
            r9.setRequestProperty(r10, r4)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
        L_0x00f8:
            java.lang.String r10 = "UTF-8"
            if (r13 == 0) goto L_0x0151
            android.content.Context r13 = r8.f49881b     // Catch:{ all -> 0x0138 }
            java.lang.String r13 = com.tencent.tpns.baseapi.XGApiConfig.getAccessKey(r13)     // Catch:{ all -> 0x0138 }
            byte[] r4 = r11.getBytes(r10)     // Catch:{ all -> 0x0138 }
            java.util.Map r13 = com.tencent.tpns.baseapi.base.util.HttpHelper.getSignAuthHeader(r5, r13, r4)     // Catch:{ all -> 0x0138 }
            if (r13 == 0) goto L_0x0151
            java.util.Set r13 = r13.entrySet()     // Catch:{ all -> 0x0138 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x0138 }
        L_0x0114:
            boolean r4 = r13.hasNext()     // Catch:{ all -> 0x0138 }
            if (r4 == 0) goto L_0x0151
            java.lang.Object r4 = r13.next()     // Catch:{ all -> 0x0138 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x0138 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ all -> 0x0138 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0138 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0138 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0138 }
            boolean r6 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r5)     // Catch:{ all -> 0x0138 }
            if (r6 != 0) goto L_0x0114
            if (r4 == 0) goto L_0x0114
            r9.setRequestProperty(r5, r4)     // Catch:{ all -> 0x0138 }
            goto L_0x0114
        L_0x0138:
            r13 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r4.<init>()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r5 = "sign error"
            r4.append(r5)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r13 = r13.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r4.append(r13)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r13 = r4.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            com.tencent.tpns.baseapi.base.util.Logger.w(r1, r13)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
        L_0x0151:
            byte[] r11 = r11.getBytes(r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.io.DataOutputStream r13 = new java.io.DataOutputStream     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.io.OutputStream r4 = r9.getOutputStream()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r13.<init>(r4)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r13.write(r11)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r13.flush()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            int r11 = r9.getResponseCode()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r4 = r9.getResponseMessage()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            int r5 = r9.getContentLength()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.<init>()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r7 = "http recv response status code:"
            r6.append(r7)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.append(r11)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r7 = ", responseMsg:"
            r6.append(r7)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.append(r4)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r7 = ",contentLength:"
            r6.append(r7)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.append(r5)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r5 = r6.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            com.tencent.tpns.baseapi.base.util.Logger.d(r1, r5)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r11 != r5) goto L_0x01d9
            java.io.BufferedReader r11 = new java.io.BufferedReader     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.io.InputStream r5 = r9.getInputStream()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r4.<init>(r5, r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r11.<init>(r4)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
        L_0x01a6:
            java.lang.String r10 = r11.readLine()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            if (r10 == 0) goto L_0x01bc
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r4.<init>()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r4.append(r0)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r4.append(r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r0 = r4.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            goto L_0x01a6
        L_0x01bc:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r10.<init>()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r4 = "http get response data:"
            r10.append(r4)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r10.append(r0)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r10 = r10.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            com.tencent.tpns.baseapi.base.util.Logger.d(r1, r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            if (r12 == 0) goto L_0x01d5
            r12.onSuccess(r0)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
        L_0x01d5:
            r11.close()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            goto L_0x0250
        L_0x01d9:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r5.<init>()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r6 = "Server response error code:"
            r5.append(r6)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r5.append(r11)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r6 = ", error:"
            r5.append(r6)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r5.append(r4)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r5 = r5.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            com.tencent.tpns.baseapi.base.util.Logger.e(r1, r5)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.io.InputStream r7 = r9.getErrorStream()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.<init>(r7, r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r5.<init>(r6)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
        L_0x0203:
            java.lang.String r10 = r5.readLine()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            if (r10 == 0) goto L_0x0219
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.<init>()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.append(r0)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.append(r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r0 = r6.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            goto L_0x0203
        L_0x0219:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r10.<init>()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r6 = "http get error response data:"
            r10.append(r6)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r10.append(r0)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r10 = r10.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            com.tencent.tpns.baseapi.base.util.Logger.e(r1, r10)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            if (r12 == 0) goto L_0x024d
            r10 = -510(0xfffffffffffffe02, float:NaN)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.<init>()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r7 = "Http返回:"
            r6.append(r7)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.append(r11)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r11 = ", "
            r6.append(r11)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r6.append(r4)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            java.lang.String r11 = r6.toString()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r12.onFailure(r10, r11)     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
        L_0x024d:
            r5.close()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
        L_0x0250:
            r13.close()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            r9.disconnect()     // Catch:{ UnknownHostException -> 0x0268, SocketTimeoutException -> 0x0263, ConnectException -> 0x025e, SSLPeerUnverifiedException -> 0x025c, all -> 0x0257 }
            goto L_0x026c
        L_0x0257:
            r9 = move-exception
            r2 = r9
            r3 = -511(0xfffffffffffffe01, float:NaN)
            goto L_0x026c
        L_0x025c:
            r9 = move-exception
            throw r9
        L_0x025e:
            r9 = move-exception
            r2 = r9
            r3 = -513(0xfffffffffffffdff, float:NaN)
            goto L_0x026c
        L_0x0263:
            r9 = move-exception
            r2 = r9
            r3 = -512(0xfffffffffffffe00, float:NaN)
            goto L_0x026c
        L_0x0268:
            r9 = move-exception
            r2 = r9
            r3 = -506(0xfffffffffffffe06, float:NaN)
        L_0x026c:
            if (r2 == 0) goto L_0x02a3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Http Request Error, Tr: "
            r9.append(r10)
            java.lang.String r10 = r2.toString()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.tencent.tpns.baseapi.base.util.Logger.e(r1, r9, r2)
            if (r12 == 0) goto L_0x02a3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x029d }
            r9.<init>()     // Catch:{ all -> 0x029d }
            java.lang.String r10 = "HttpRequest Throw Error:"
            r9.append(r10)     // Catch:{ all -> 0x029d }
            r9.append(r2)     // Catch:{ all -> 0x029d }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x029d }
            r12.onFailure(r3, r9)     // Catch:{ all -> 0x029d }
            goto L_0x02a3
        L_0x029d:
            r9 = move-exception
            java.lang.String r10 = "Callback Error, Tr:"
            com.tencent.tpns.baseapi.base.util.Logger.e(r1, r10, r9)
        L_0x02a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.net.a.b(java.lang.String, java.lang.String, java.lang.String, com.tencent.tpns.baseapi.core.net.HttpRequestCallback, boolean):java.lang.String");
    }

    public String a(String str, String str2, String str3, String str4, HttpRequestCallback httpRequestCallback, boolean z11) {
        try {
            return b(str, str3, str4, httpRequestCallback, z11);
        } catch (Exception | SSLPeerUnverifiedException unused) {
            try {
                Logger.e("HttpRequest", "use host url retry");
                return b(str2, str3, str4, httpRequestCallback, z11);
            } catch (Exception | SSLPeerUnverifiedException e11) {
                Logger.e("HttpRequest", "Http Request Error, Tr: " + e11.toString(), e11);
                if (httpRequestCallback == null) {
                    return null;
                }
                httpRequestCallback.onFailure(ErrCode.GUID_HTTP_REQ_ERROR_OTHER, "HttpRequest Throw Error:" + e11);
                return null;
            } catch (Throwable th2) {
                Logger.e("HttpRequest", "Callback Error, Tr:", th2);
                return null;
            }
        }
    }

    public String a(String str, String str2, String str3, HttpRequestCallback httpRequestCallback, boolean z11) {
        try {
            return b(str, str2, str3, httpRequestCallback, z11);
        } catch (Exception e11) {
            Logger.e("HttpRequest", "Http Request Error, Tr: " + e11.toString(), e11);
            if (httpRequestCallback == null) {
                return null;
            }
            httpRequestCallback.onFailure(ErrCode.GUID_HTTP_REQ_ERROR_OTHER, "HttpRequest Throw Error:" + e11);
            return null;
        } catch (Throwable th2) {
            Logger.e("HttpRequest", "Callback Error, Tr:", th2);
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e11) {
            Logger.e("HttpRequest", "getHostName Exception :", e11);
            return "";
        }
    }
}

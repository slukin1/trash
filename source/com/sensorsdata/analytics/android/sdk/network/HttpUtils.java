package com.sensorsdata.analytics.android.sdk.network;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huochat.community.network.domain.DomainTool;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class HttpUtils {
    private static final int HTTP_307 = 307;

    public static String getLocation(HttpURLConnection httpURLConnection, String str) throws MalformedURLException {
        if (httpURLConnection == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
        if (TextUtils.isEmpty(headerField)) {
            headerField = httpURLConnection.getHeaderField("location");
        }
        if (TextUtils.isEmpty(headerField)) {
            return null;
        }
        if (headerField.startsWith(DomainTool.DOMAIN_PREFIX_HTTP) || headerField.startsWith(DomainTool.DOMAIN_PREFIX)) {
            return headerField;
        }
        URL url = new URL(str);
        return url.getProtocol() + "://" + url.getHost() + headerField;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049 A[SYNTHETIC, Splitter:B:26:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0053 A[SYNTHETIC, Splitter:B:31:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0061 A[SYNTHETIC, Splitter:B:37:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006b A[SYNTHETIC, Splitter:B:42:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getRetString(java.io.InputStream r5) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0040, all -> 0x003b }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0040, all -> 0x003b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r5, r3)     // Catch:{ Exception -> 0x0040, all -> 0x003b }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0040, all -> 0x003b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0039 }
            r0.<init>()     // Catch:{ Exception -> 0x0039 }
        L_0x0012:
            java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0039 }
            if (r2 == 0) goto L_0x0021
            r0.append(r2)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r2 = "\n"
            r0.append(r2)     // Catch:{ Exception -> 0x0039 }
            goto L_0x0012
        L_0x0021:
            r5.close()     // Catch:{ Exception -> 0x0039 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0039 }
            r1.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r1 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
        L_0x0030:
            r5.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x0038:
            return r0
        L_0x0039:
            r0 = move-exception
            goto L_0x0044
        L_0x003b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x005f
        L_0x0040:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0044:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0051:
            if (r5 == 0) goto L_0x005b
            r5.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x005b:
            java.lang.String r5 = ""
            return r5
        L_0x005e:
            r0 = move-exception
        L_0x005f:
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r1 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
        L_0x0069:
            if (r5 == 0) goto L_0x0073
            r5.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x0073:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.network.HttpUtils.getRetString(java.io.InputStream):java.lang.String");
    }

    public static boolean needRedirects(int i11) {
        return i11 == 301 || i11 == 302 || i11 == 307;
    }
}

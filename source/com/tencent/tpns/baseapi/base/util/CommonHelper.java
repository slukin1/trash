package com.tencent.tpns.baseapi.base.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import com.tencent.tpns.baseapi.core.net.a;
import java.io.Closeable;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonHelper {
    public static boolean checkManifestIfComponentConfiged(Context context, String str) {
        try {
            context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 0);
            return true;
        } catch (Throwable th2) {
            Logger.e("CommonHelper", "CommonHelper -> checkManifestIfComponentConfiged", th2);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|6|7|(3:8|9|(1:11)(1:59))|12|13|14|15|16|17|18|19) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0055 A[SYNTHETIC, Splitter:B:33:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005a A[SYNTHETIC, Splitter:B:37:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005f A[SYNTHETIC, Splitter:B:41:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0070 A[SYNTHETIC, Splitter:B:55:0x0070] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] decodeGZipContent(byte[] r7) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0039 }
            r1.<init>(r7)     // Catch:{ all -> 0x0039 }
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0036 }
            r2.<init>(r1)     // Catch:{ all -> 0x0036 }
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0033 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0033 }
            int r7 = r7.length     // Catch:{ all -> 0x0033 }
            int r7 = r7 * 2
            r4.<init>(r7)     // Catch:{ all -> 0x0033 }
        L_0x0017:
            int r7 = r2.read(r3)     // Catch:{ all -> 0x0031 }
            r5 = -1
            if (r7 == r5) goto L_0x0023
            r5 = 0
            r4.write(r3, r5, r7)     // Catch:{ all -> 0x0031 }
            goto L_0x0017
        L_0x0023:
            byte[] r7 = r4.toByteArray()     // Catch:{ all -> 0x0031 }
            r4.close()     // Catch:{ all -> 0x002a }
        L_0x002a:
            r2.close()     // Catch:{ all -> 0x002d }
        L_0x002d:
            r1.close()     // Catch:{ all -> 0x0030 }
        L_0x0030:
            return r7
        L_0x0031:
            r7 = move-exception
            goto L_0x003d
        L_0x0033:
            r7 = move-exception
            r4 = r0
            goto L_0x003d
        L_0x0036:
            r7 = move-exception
            r2 = r0
            goto L_0x003c
        L_0x0039:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L_0x003c:
            r4 = r2
        L_0x003d:
            java.lang.String r3 = "CommonHelper"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r5.<init>()     // Catch:{ all -> 0x0063 }
            java.lang.String r6 = "decode gzip content failed, error "
            r5.append(r6)     // Catch:{ all -> 0x0063 }
            r5.append(r7)     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x0063 }
            com.tencent.tpns.baseapi.base.util.Logger.e(r3, r7)     // Catch:{ all -> 0x0063 }
            if (r4 == 0) goto L_0x0058
            r4.close()     // Catch:{ all -> 0x0058 }
        L_0x0058:
            if (r2 == 0) goto L_0x005d
            r2.close()     // Catch:{ all -> 0x005d }
        L_0x005d:
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ all -> 0x0062 }
        L_0x0062:
            return r0
        L_0x0063:
            r7 = move-exception
            if (r4 == 0) goto L_0x0069
            r4.close()     // Catch:{ all -> 0x0069 }
        L_0x0069:
            if (r2 == 0) goto L_0x006e
            r2.close()     // Catch:{ all -> 0x006e }
        L_0x006e:
            if (r1 == 0) goto L_0x0073
            r1.close()     // Catch:{ all -> 0x0073 }
        L_0x0073:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.base.util.CommonHelper.decodeGZipContent(byte[]):byte[]");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003a A[SYNTHETIC, Splitter:B:23:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003f A[SYNTHETIC, Splitter:B:27:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] encodeGZipContent(byte[] r6) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x001f }
            int r2 = r6.length     // Catch:{ all -> 0x001f }
            r1.<init>(r2)     // Catch:{ all -> 0x001f }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x001c }
            r2.<init>(r1)     // Catch:{ all -> 0x001c }
            r2.write(r6)     // Catch:{ all -> 0x001a }
            r2.close()     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r1.close()     // Catch:{ all -> 0x0015 }
        L_0x0015:
            byte[] r6 = r1.toByteArray()
            return r6
        L_0x001a:
            r6 = move-exception
            goto L_0x0022
        L_0x001c:
            r6 = move-exception
            r2 = r0
            goto L_0x0022
        L_0x001f:
            r6 = move-exception
            r1 = r0
            r2 = r1
        L_0x0022:
            java.lang.String r3 = "CommonHelper"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r4.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r5 = "encode gzip content failed, error "
            r4.append(r5)     // Catch:{ all -> 0x0043 }
            r4.append(r6)     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0043 }
            com.tencent.tpns.baseapi.base.util.Logger.e(r3, r6)     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x003d
            r2.close()     // Catch:{ all -> 0x003d }
        L_0x003d:
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ all -> 0x0042 }
        L_0x0042:
            return r0
        L_0x0043:
            r6 = move-exception
            if (r2 == 0) goto L_0x0049
            r2.close()     // Catch:{ all -> 0x0049 }
        L_0x0049:
            if (r1 == 0) goto L_0x004e
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x004e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.base.util.CommonHelper.encodeGZipContent(byte[]):byte[]");
    }

    public static Object getMetaData(Context context, String str, Object obj) {
        Object obj2;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (obj2 = applicationInfo.metaData.get(str)) == null) {
                return obj;
            }
            return obj2;
        } catch (Throwable unused) {
            Logger.e("CommonHelper", "unexpected for getMetaData:" + str);
        }
    }

    public static String getOfflineMsg(Context context, String str, String str2, HttpRequestCallback httpRequestCallback) {
        try {
            if (CloudManager.getInstance(context).shouldRefuse()) {
                Logger.i("CommonHelper", "getOfflineMsg refused by cloud");
                return "";
            }
            return a.a(context).a(str, a.a(str), str2, httpRequestCallback, true);
        } catch (Throwable th2) {
            Logger.w("CommonHelper", "unexpected for getOfflineMsg, exception:", th2);
            return "";
        }
    }

    public static boolean isIPValid(String str) {
        if (str == null || str.length() < 7 || str.length() > 15 || "".equals(str)) {
            return false;
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }

    public static Object jsonGet(JSONObject jSONObject, String str, Object obj) {
        try {
            if (jSONObject.has(str)) {
                return jSONObject.get(str);
            }
        } catch (JSONException e11) {
            Logger.e("CommonHelper", "unexpected for jsonGet:" + e11.getMessage());
        }
        return obj;
    }

    public static boolean jsonPut(JSONObject jSONObject, String str, Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            jSONObject.put(str, obj);
            return true;
        } catch (JSONException e11) {
            Logger.e("CommonHelper", "unexpected for jsonPush:" + e11.getMessage());
            return false;
        }
    }

    public static boolean safeClose(Closeable closeable) {
        if (closeable == null) {
            return false;
        }
        try {
            closeable.close();
            return true;
        } catch (Throwable th2) {
            Logger.e("CommonHelper", "unexpected for safeClose:" + th2.getMessage());
            return false;
        }
    }
}

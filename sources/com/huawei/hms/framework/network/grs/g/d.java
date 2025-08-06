package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;

public class d {

    /* renamed from: o  reason: collision with root package name */
    private static final String f38046o = "d";

    /* renamed from: a  reason: collision with root package name */
    private Map<String, List<String>> f38047a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f38048b;

    /* renamed from: c  reason: collision with root package name */
    private int f38049c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f38050d;

    /* renamed from: e  reason: collision with root package name */
    private long f38051e;

    /* renamed from: f  reason: collision with root package name */
    private long f38052f;

    /* renamed from: g  reason: collision with root package name */
    private String f38053g;

    /* renamed from: h  reason: collision with root package name */
    private int f38054h = 2;

    /* renamed from: i  reason: collision with root package name */
    private int f38055i = 9001;

    /* renamed from: j  reason: collision with root package name */
    private String f38056j = "";

    /* renamed from: k  reason: collision with root package name */
    private long f38057k = 0;

    /* renamed from: l  reason: collision with root package name */
    private String f38058l = "";

    /* renamed from: m  reason: collision with root package name */
    private Exception f38059m;

    /* renamed from: n  reason: collision with root package name */
    private String f38060n;

    public d(int i11, Map<String, List<String>> map, byte[] bArr, long j11) {
        this.f38049c = i11;
        this.f38047a = map;
        this.f38048b = ByteBuffer.wrap(bArr).array();
        this.f38050d = j11;
        s();
    }

    public d(Exception exc, long j11) {
        this.f38059m = exc;
        this.f38050d = j11;
    }

    private void a(Map<String, String> map) {
        String str;
        String str2;
        if (map.containsKey(HttpHeaders.ETAG)) {
            String str3 = map.get(HttpHeaders.ETAG);
            if (!TextUtils.isEmpty(str3)) {
                Logger.i(f38046o, "success get Etag from server");
                a(str3);
                return;
            }
            str = f38046o;
            str2 = "The Response Heads Etag is Empty";
        } else {
            str = f38046o;
            str2 = "Response Heads has not Etag";
        }
        Logger.i(str, str2);
    }

    private void b(int i11) {
        this.f38055i = i11;
    }

    private void b(Map<String, String> map) {
        long j11;
        if (map.containsKey(HttpHeaders.CACHE_CONTROL)) {
            String str = map.get(HttpHeaders.CACHE_CONTROL);
            if (!TextUtils.isEmpty(str) && str.contains("max-age=")) {
                try {
                    j11 = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                    try {
                        Logger.v(f38046o, "Cache-Control value{%s}", Long.valueOf(j11));
                    } catch (NumberFormatException e11) {
                        e = e11;
                    }
                } catch (NumberFormatException e12) {
                    e = e12;
                    j11 = 0;
                    Logger.w(f38046o, "getExpireTime addHeadersToResult NumberFormatException", (Throwable) e);
                    j11 = 86400;
                    long j12 = j11 * 1000;
                    Logger.i(f38046o, "convert expireTime{%s}", Long.valueOf(j12));
                    c(String.valueOf(j12 + System.currentTimeMillis()));
                }
                if (j11 <= 0 || j11 > 2592000) {
                    j11 = 86400;
                }
                long j122 = j11 * 1000;
                Logger.i(f38046o, "convert expireTime{%s}", Long.valueOf(j122));
                c(String.valueOf(j122 + System.currentTimeMillis()));
            }
        } else if (map.containsKey(HttpHeaders.EXPIRES)) {
            String str2 = map.get(HttpHeaders.EXPIRES);
            Logger.v(f38046o, "expires is{%s}", str2);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
            String str3 = null;
            if (map.containsKey(HttpHeaders.DATE)) {
                str3 = map.get(HttpHeaders.DATE);
            }
            try {
                j11 = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
            } catch (ParseException e13) {
                Logger.w(f38046o, "getExpireTime ParseException.", (Throwable) e13);
            }
            j11 = 86400;
            long j1222 = j11 * 1000;
            Logger.i(f38046o, "convert expireTime{%s}", Long.valueOf(j1222));
            c(String.valueOf(j1222 + System.currentTimeMillis()));
        } else {
            Logger.i(f38046o, "response headers neither contains Cache-Control nor Expires.");
        }
        j11 = 0;
        j11 = 86400;
        long j12222 = j11 * 1000;
        Logger.i(f38046o, "convert expireTime{%s}", Long.valueOf(j12222));
        c(String.valueOf(j12222 + System.currentTimeMillis()));
    }

    private void c(int i11) {
        this.f38054h = i11;
    }

    private void c(long j11) {
        this.f38057k = j11;
    }

    private void c(String str) {
        this.f38056j = str;
    }

    private void c(Map<String, String> map) {
        long j11;
        if (map.containsKey(HttpHeaders.RETRY_AFTER)) {
            String str = map.get(HttpHeaders.RETRY_AFTER);
            if (!TextUtils.isEmpty(str)) {
                try {
                    j11 = Long.parseLong(str);
                } catch (NumberFormatException e11) {
                    Logger.w(f38046o, "getRetryAfter addHeadersToResult NumberFormatException", (Throwable) e11);
                }
                long j12 = j11 * 1000;
                Logger.v(f38046o, "convert retry-afterTime{%s}", Long.valueOf(j12));
                c(j12);
            }
        }
        j11 = 0;
        long j122 = j11 * 1000;
        Logger.v(f38046o, "convert retry-afterTime{%s}", Long.valueOf(j122));
        c(j122);
    }

    private void d(String str) {
    }

    private void e(String str) {
    }

    private void f(String str) {
        this.f38053g = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        if (r9.getInt("resultCode") == 0) goto L_0x0054;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063 A[SYNTHETIC, Splitter:B:24:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0098 A[Catch:{ JSONException -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a1 A[Catch:{ JSONException -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ab A[Catch:{ JSONException -> 0x00b7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void p() {
        /*
            r11 = this;
            java.lang.String r0 = "errorDesc"
            java.lang.String r1 = "errorList"
            java.lang.String r2 = "errorCode"
            java.lang.String r3 = "resultCode"
            java.lang.String r4 = "isSuccess"
            boolean r5 = r11.m()
            r6 = 1
            if (r5 == 0) goto L_0x001c
            java.lang.String r0 = f38046o
            java.lang.String r1 = "GRSSDK get httpcode{304} not any changed."
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            r11.c((int) r6)
            return
        L_0x001c:
            boolean r5 = r11.o()
            r7 = 2
            if (r5 != 0) goto L_0x002e
            java.lang.String r0 = f38046o
            java.lang.String r1 = "GRSSDK parse server body all failed."
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            r11.c((int) r7)
            return
        L_0x002e:
            r5 = 0
            byte[] r8 = r11.f38048b     // Catch:{ JSONException -> 0x00b7 }
            java.lang.String r8 = com.huawei.hms.framework.common.StringUtils.byte2Str(r8)     // Catch:{ JSONException -> 0x00b7 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b7 }
            r9.<init>(r8)     // Catch:{ JSONException -> 0x00b7 }
            r8 = -1
            boolean r10 = r9.has(r4)     // Catch:{ JSONException -> 0x00b7 }
            if (r10 == 0) goto L_0x0048
            int r3 = r9.getInt(r4)     // Catch:{ JSONException -> 0x00b7 }
            if (r3 != r6) goto L_0x0056
            goto L_0x0054
        L_0x0048:
            boolean r4 = r9.has(r3)     // Catch:{ JSONException -> 0x00b7 }
            if (r4 == 0) goto L_0x0058
            int r3 = r9.getInt(r3)     // Catch:{ JSONException -> 0x00b7 }
            if (r3 != 0) goto L_0x0056
        L_0x0054:
            r8 = r6
            goto L_0x005f
        L_0x0056:
            r8 = r7
            goto L_0x005f
        L_0x0058:
            java.lang.String r3 = f38046o     // Catch:{ JSONException -> 0x00b7 }
            java.lang.String r4 = "sth. wrong because server errorcode's key."
            com.huawei.hms.framework.common.Logger.e(r3, r4)     // Catch:{ JSONException -> 0x00b7 }
        L_0x005f:
            java.lang.String r3 = "services"
            if (r8 == r6) goto L_0x006a
            boolean r4 = r9.has(r3)     // Catch:{ JSONException -> 0x00b7 }
            if (r4 == 0) goto L_0x006a
            r8 = r5
        L_0x006a:
            r11.c((int) r8)     // Catch:{ JSONException -> 0x00b7 }
            java.lang.String r4 = ""
            if (r8 == r6) goto L_0x0092
            if (r8 != 0) goto L_0x0074
            goto L_0x0092
        L_0x0074:
            boolean r1 = r9.has(r2)     // Catch:{ JSONException -> 0x00b7 }
            if (r1 == 0) goto L_0x007f
            int r1 = r9.getInt(r2)     // Catch:{ JSONException -> 0x00b7 }
            goto L_0x0081
        L_0x007f:
            r1 = 9001(0x2329, float:1.2613E-41)
        L_0x0081:
            r11.b((int) r1)     // Catch:{ JSONException -> 0x00b7 }
            boolean r1 = r9.has(r0)     // Catch:{ JSONException -> 0x00b7 }
            if (r1 == 0) goto L_0x008e
            java.lang.String r4 = r9.getString(r0)     // Catch:{ JSONException -> 0x00b7 }
        L_0x008e:
            r11.d(r4)     // Catch:{ JSONException -> 0x00b7 }
            goto L_0x00ce
        L_0x0092:
            boolean r0 = r9.has(r3)     // Catch:{ JSONException -> 0x00b7 }
            if (r0 == 0) goto L_0x00a1
            org.json.JSONObject r0 = r9.getJSONObject(r3)     // Catch:{ JSONException -> 0x00b7 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00b7 }
            goto L_0x00a2
        L_0x00a1:
            r0 = r4
        L_0x00a2:
            r11.f(r0)     // Catch:{ JSONException -> 0x00b7 }
            boolean r0 = r9.has(r1)     // Catch:{ JSONException -> 0x00b7 }
            if (r0 == 0) goto L_0x00b3
            org.json.JSONObject r0 = r9.getJSONObject(r1)     // Catch:{ JSONException -> 0x00b7 }
            java.lang.String r4 = r0.toString()     // Catch:{ JSONException -> 0x00b7 }
        L_0x00b3:
            r11.e(r4)     // Catch:{ JSONException -> 0x00b7 }
            goto L_0x00ce
        L_0x00b7:
            r0 = move-exception
            java.lang.String r1 = f38046o
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r0)
            r2[r5] = r0
            java.lang.String r0 = "GrsResponse GrsResponse(String result) JSONException: %s"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r1, (java.lang.String) r0, (java.lang.Object[]) r2)
            r11.c((int) r7)
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.d.p():void");
    }

    private void q() {
        if (o() || n() || m()) {
            Map<String, String> r11 = r();
            if (r11.size() <= 0) {
                Logger.w(f38046o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (o() || m()) {
                    b(r11);
                    a(r11);
                }
                if (n()) {
                    c(r11);
                }
            } catch (JSONException e11) {
                Logger.w(f38046o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e11.getMessage()));
            }
        }
    }

    private Map<String, String> r() {
        HashMap hashMap = new HashMap(16);
        Map<String, List<String>> map = this.f38047a;
        if (map == null || map.size() <= 0) {
            Logger.v(f38046o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return hashMap;
        }
        for (Map.Entry next : this.f38047a.entrySet()) {
            String str = (String) next.getKey();
            for (String put : (List) next.getValue()) {
                hashMap.put(str, put);
            }
        }
        return hashMap;
    }

    private void s() {
        q();
        p();
    }

    public String a() {
        return this.f38056j;
    }

    public void a(int i11) {
    }

    public void a(long j11) {
        this.f38052f = j11;
    }

    public void a(String str) {
        this.f38058l = str;
    }

    public int b() {
        return this.f38049c;
    }

    public void b(long j11) {
        this.f38051e = j11;
    }

    public void b(String str) {
        this.f38060n = str;
    }

    public int c() {
        return this.f38055i;
    }

    public Exception d() {
        return this.f38059m;
    }

    public String e() {
        return this.f38058l;
    }

    public int f() {
        return this.f38054h;
    }

    public long g() {
        return this.f38052f;
    }

    public long h() {
        return this.f38051e;
    }

    public long i() {
        return this.f38050d;
    }

    public String j() {
        return this.f38053g;
    }

    public long k() {
        return this.f38057k;
    }

    public String l() {
        return this.f38060n;
    }

    public boolean m() {
        return this.f38049c == 304;
    }

    public boolean n() {
        return this.f38049c == 503;
    }

    public boolean o() {
        return this.f38049c == 200;
    }
}

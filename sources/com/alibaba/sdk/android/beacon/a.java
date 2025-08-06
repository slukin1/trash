package com.alibaba.sdk.android.beacon;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.beacon.Beacon;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huochat.community.network.domain.DomainTool;
import com.sumsub.sns.internal.core.common.n0;
import com.ta.utdid2.device.UTDevice;
import com.tencent.android.tpush.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f14468d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f14469e;

    /* renamed from: a  reason: collision with root package name */
    public final List<Beacon.c> f14470a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Beacon f14471b;

    /* renamed from: c  reason: collision with root package name */
    public final b f14472c;

    public final class b {
        public b() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8 A[SYNTHETIC, Splitter:B:40:0x00a8] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00ad A[Catch:{ IOException -> 0x00b0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00b6 A[SYNTHETIC, Splitter:B:47:0x00b6] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00bb A[Catch:{ IOException -> 0x00be }] */
        /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String a(java.lang.String r7, byte[] r8) {
            /*
                r6 = this;
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0090, all -> 0x008d }
                r1.<init>(r7)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
                java.net.URLConnection r7 = r1.openConnection()     // Catch:{ Exception -> 0x0090, all -> 0x008d }
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x0090, all -> 0x008d }
                r1 = 10000(0x2710, float:1.4013E-41)
                r7.setReadTimeout(r1)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
                r7.setConnectTimeout(r1)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
                java.lang.String r1 = "POST"
                r7.setRequestMethod(r1)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
                r1 = 1
                r7.setDoOutput(r1)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
                r7.setDoInput(r1)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
                r1 = 0
                r7.setUseCaches(r1)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
                boolean r1 = j2.a.f16008a     // Catch:{ Exception -> 0x0090, all -> 0x008d }
                if (r1 == 0) goto L_0x002f
                java.lang.String r1 = "Host"
                java.lang.String r2 = "beacon-api.aliyuncs.com"
                r7.setRequestProperty(r1, r2)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            L_0x002f:
                java.io.OutputStream r1 = r7.getOutputStream()     // Catch:{ Exception -> 0x0090, all -> 0x008d }
                r1.write(r8)     // Catch:{ Exception -> 0x0089, all -> 0x0085 }
                r1.flush()     // Catch:{ Exception -> 0x0089, all -> 0x0085 }
                int r8 = r7.getResponseCode()     // Catch:{ Exception -> 0x0089, all -> 0x0085 }
                boolean r2 = r6.b(r8)     // Catch:{ Exception -> 0x0089, all -> 0x0085 }
                if (r2 == 0) goto L_0x0048
                java.io.InputStream r7 = r7.getInputStream()     // Catch:{ Exception -> 0x0089, all -> 0x0085 }
                goto L_0x004c
            L_0x0048:
                java.io.InputStream r7 = r7.getErrorStream()     // Catch:{ Exception -> 0x0089, all -> 0x0085 }
            L_0x004c:
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0089, all -> 0x0085 }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0089, all -> 0x0085 }
                java.lang.String r5 = "UTF-8"
                r4.<init>(r7, r5)     // Catch:{ Exception -> 0x0089, all -> 0x0085 }
                r3.<init>(r4)     // Catch:{ Exception -> 0x0089, all -> 0x0085 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                r7.<init>()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            L_0x005d:
                java.lang.String r0 = r3.readLine()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                if (r0 == 0) goto L_0x0067
                r7.append(r0)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                goto L_0x005d
            L_0x0067:
                if (r2 != 0) goto L_0x0076
                com.alibaba.sdk.android.beacon.a r0 = com.alibaba.sdk.android.beacon.a.this     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                r0.g(r8, r2)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            L_0x0076:
                java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                r1.close()     // Catch:{ IOException -> 0x0080 }
                r3.close()     // Catch:{ IOException -> 0x0080 }
            L_0x0080:
                return r7
            L_0x0081:
                r7 = move-exception
                goto L_0x0087
            L_0x0083:
                r7 = move-exception
                goto L_0x008b
            L_0x0085:
                r7 = move-exception
                r3 = r0
            L_0x0087:
                r0 = r1
                goto L_0x00b4
            L_0x0089:
                r7 = move-exception
                r3 = r0
            L_0x008b:
                r0 = r1
                goto L_0x0092
            L_0x008d:
                r7 = move-exception
                r3 = r0
                goto L_0x00b4
            L_0x0090:
                r7 = move-exception
                r3 = r0
            L_0x0092:
                java.lang.String r8 = "beacon"
                java.lang.String r1 = r7.getMessage()     // Catch:{ all -> 0x00b3 }
                android.util.Log.i(r8, r1, r7)     // Catch:{ all -> 0x00b3 }
                com.alibaba.sdk.android.beacon.a r8 = com.alibaba.sdk.android.beacon.a.this     // Catch:{ all -> 0x00b3 }
                java.lang.String r1 = "-100"
                java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x00b3 }
                r8.g(r1, r7)     // Catch:{ all -> 0x00b3 }
                if (r0 == 0) goto L_0x00ab
                r0.close()     // Catch:{ IOException -> 0x00b0 }
            L_0x00ab:
                if (r3 == 0) goto L_0x00b0
                r3.close()     // Catch:{ IOException -> 0x00b0 }
            L_0x00b0:
                java.lang.String r7 = ""
                return r7
            L_0x00b3:
                r7 = move-exception
            L_0x00b4:
                if (r0 == 0) goto L_0x00b9
                r0.close()     // Catch:{ IOException -> 0x00be }
            L_0x00b9:
                if (r3 == 0) goto L_0x00be
                r3.close()     // Catch:{ IOException -> 0x00be }
            L_0x00be:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.beacon.a.b.a(java.lang.String, byte[]):java.lang.String");
        }

        public boolean b(int i11) {
            return i11 >= 200 && i11 < 300;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14474a;

        /* renamed from: b  reason: collision with root package name */
        public final String f14475b;

        /* renamed from: c  reason: collision with root package name */
        public final String f14476c;

        /* renamed from: d  reason: collision with root package name */
        public final String f14477d;

        /* renamed from: e  reason: collision with root package name */
        public final String f14478e;

        /* renamed from: f  reason: collision with root package name */
        public final String f14479f;

        /* renamed from: g  reason: collision with root package name */
        public final String f14480g;

        /* renamed from: h  reason: collision with root package name */
        public final Map<String, String> f14481h;

        /* renamed from: i  reason: collision with root package name */
        public final String f14482i;

        /* renamed from: j  reason: collision with root package name */
        public final Map<String, String> f14483j;

        /* renamed from: com.alibaba.sdk.android.beacon.a$c$a  reason: collision with other inner class name */
        public static final class C0066a {

            /* renamed from: a  reason: collision with root package name */
            public String f14484a;

            /* renamed from: b  reason: collision with root package name */
            public String f14485b;

            /* renamed from: c  reason: collision with root package name */
            public String f14486c;

            /* renamed from: d  reason: collision with root package name */
            public String f14487d;

            /* renamed from: e  reason: collision with root package name */
            public String f14488e;

            /* renamed from: f  reason: collision with root package name */
            public String f14489f;

            /* renamed from: g  reason: collision with root package name */
            public String f14490g;

            /* renamed from: h  reason: collision with root package name */
            public Map<String, String> f14491h = new HashMap();

            public C0066a a(String str) {
                this.f14484a = str;
                return this;
            }

            public C0066a b(Map<String, String> map) {
                this.f14491h.putAll(map);
                return this;
            }

            public c c() {
                return new c(this);
            }

            public C0066a d(String str) {
                this.f14485b = str;
                return this;
            }

            public C0066a e(String str) {
                this.f14486c = str;
                return this;
            }

            public C0066a f(String str) {
                this.f14487d = str;
                return this;
            }

            public C0066a g(String str) {
                this.f14488e = str;
                return this;
            }

            public C0066a h(String str) {
                this.f14489f = str;
                return this;
            }

            public C0066a i(String str) {
                this.f14490g = str;
                return this;
            }
        }

        public c(C0066a aVar) {
            this.f14483j = new TreeMap();
            this.f14474a = aVar.f14484a;
            this.f14475b = aVar.f14485b;
            this.f14476c = aVar.f14486c;
            this.f14477d = aVar.f14487d;
            this.f14478e = aVar.f14488e;
            this.f14479f = aVar.f14489f;
            this.f14480g = aVar.f14490g;
            this.f14481h = aVar.f14491h;
            this.f14482i = a();
        }

        public final String a() {
            this.f14483j.put("appKey", this.f14474a);
            this.f14483j.put("appVer", this.f14476c);
            this.f14483j.put("osType", this.f14477d);
            this.f14483j.put("osVer", this.f14478e);
            this.f14483j.put(Constants.FLAG_DEVICE_ID, this.f14479f);
            this.f14483j.put("beaconVer", this.f14480g);
            for (String next : this.f14481h.keySet()) {
                this.f14483j.put(next, this.f14481h.get(next));
            }
            StringBuilder sb2 = new StringBuilder();
            for (String next2 : this.f14483j.keySet()) {
                sb2.append(next2);
                sb2.append(this.f14483j.get(next2));
            }
            String b11 = j2.b.b(this.f14475b, sb2.toString());
            this.f14483j.put("sign", b11);
            return b11;
        }
    }

    static {
        String str = j2.a.f16008a ? "100.67.64.54" : "beacon-api.aliyuncs.com";
        f14468d = str;
        f14469e = DomainTool.DOMAIN_PREFIX + str + "/beacon/fetch/config";
    }

    public a(Beacon beacon) {
        this.f14471b = beacon;
        this.f14472c = new b();
    }

    public final c a(Context context, String str, String str2, Map<String, String> map) {
        return new c.C0066a().a(str).d(str2).e(j2.b.a(context)).f(n0.f32119g).g(String.valueOf(Build.VERSION.SDK_INT)).h(UTDevice.getUtdid(context)).i("1.0.7").b(map).c();
    }

    public final String b(c cVar) {
        Map<String, String> map = cVar.f14483j;
        StringBuilder sb2 = new StringBuilder();
        for (String next : map.keySet()) {
            sb2.append(i(next));
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append(i(map.get(next)));
            sb2.append(ContainerUtils.FIELD_DELIMITER);
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        return sb2.toString();
    }

    public List<Beacon.c> c() {
        return Collections.unmodifiableList(this.f14470a);
    }

    public void d(Context context, String str, String str2, Map<String, String> map) {
        c a11 = a(context, str, str2, map);
        String str3 = f14469e + "/" + "byappkey";
        Log.i("beacon", "url=" + str3);
        String a12 = this.f14472c.a(str3, b(a11).getBytes());
        Log.i("beacon", "[fetchByAppKey] result: " + a12);
        f(a12);
    }

    public final void f(String str) {
        h(str);
    }

    public final void g(String str, String str2) {
        this.f14471b.c(new Beacon.d(str, str2));
    }

    public final void h(String str) {
        JSONArray optJSONArray;
        try {
            if (!TextUtils.isEmpty(str) && (optJSONArray = new JSONObject(str).optJSONArray("result")) != null && optJSONArray.length() > 0) {
                this.f14470a.clear();
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    JSONObject jSONObject = (JSONObject) optJSONArray.get(i11);
                    this.f14470a.add(new Beacon.c(jSONObject.optString("key"), jSONObject.optString("value")));
                }
            }
        } catch (Exception unused) {
        }
    }

    public final String i(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
            return "";
        }
    }
}

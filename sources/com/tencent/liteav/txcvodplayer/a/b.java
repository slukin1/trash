package com.tencent.liteav.txcvodplayer.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: d  reason: collision with root package name */
    private static volatile b f21860d;

    /* renamed from: a  reason: collision with root package name */
    private Context f21861a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, List<C0170b>> f21862b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Long> f21863c = new HashMap();

    private b(Context context) {
        this.f21861a = context.getApplicationContext();
        a();
    }

    public static b a(Context context) {
        if (f21860d == null) {
            synchronized (b.class) {
                if (f21860d == null) {
                    f21860d = new b(context);
                }
            }
        }
        return f21860d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long d(java.lang.String r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0059
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x0009
            goto L_0x0059
        L_0x0009:
            monitor-enter(r4)
            java.util.Map<java.lang.String, java.lang.Long> r0 = r4.f21863c     // Catch:{ all -> 0x0056 }
            boolean r0 = r0.containsKey(r5)     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0020
            java.util.Map<java.lang.String, java.lang.Long> r0 = r4.f21863c     // Catch:{ all -> 0x0056 }
            java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x0056 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0056 }
            long r0 = r5.longValue()     // Catch:{ all -> 0x0056 }
            monitor-exit(r4)     // Catch:{ all -> 0x0056 }
            return r0
        L_0x0020:
            java.util.Map<java.lang.String, java.util.List<com.tencent.liteav.txcvodplayer.a.b$b>> r0 = r4.f21862b     // Catch:{ all -> 0x0056 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0056 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0052
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0056 }
        L_0x002e:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0056 }
            com.tencent.liteav.txcvodplayer.a.b$b r1 = (com.tencent.liteav.txcvodplayer.a.b.C0170b) r1     // Catch:{ all -> 0x0056 }
            java.lang.String r2 = "40305"
            java.lang.String r3 = r1.f21870e     // Catch:{ all -> 0x0056 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x002e
            java.lang.String r2 = r1.f21869d     // Catch:{ all -> 0x0056 }
            boolean r2 = r5.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x002e
            com.tencent.liteav.txcvodplayer.a.b$a r1 = (com.tencent.liteav.txcvodplayer.a.b.a) r1     // Catch:{ all -> 0x0056 }
            long r0 = r1.f21868c     // Catch:{ all -> 0x0056 }
            monitor-exit(r4)     // Catch:{ all -> 0x0056 }
            return r0
        L_0x0052:
            monitor-exit(r4)     // Catch:{ all -> 0x0056 }
            r0 = 0
            return r0
        L_0x0056:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0056 }
            throw r5
        L_0x0059:
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
            r2 = 3600(0xe10, double:1.7786E-320)
            long r0 = r0 + r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.a.b.d(java.lang.String):long");
    }

    private static List<C0170b> e(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                if (optJSONObject != null) {
                    optJSONObject.optString("appid", "");
                    if (optJSONObject.optString("eventid", "").equalsIgnoreCase("40305")) {
                        String optString = optJSONObject.optString("40305", "");
                        if (!optString.isEmpty()) {
                            arrayList.add(new a(optString));
                        }
                    }
                }
            }
        } catch (JSONException e11) {
            LiteavLog.e("TXCVodPlayReportControl", "controlDataListParseFormString :" + e11.toString());
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L_0x0051
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L_0x000a
            goto L_0x0051
        L_0x000a:
            monitor-enter(r9)
            java.util.Map<java.lang.String, java.util.List<com.tencent.liteav.txcvodplayer.a.b$b>> r1 = r9.f21862b     // Catch:{ all -> 0x004e }
            java.lang.Object r1 = r1.get(r10)     // Catch:{ all -> 0x004e }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x004c
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x004e }
        L_0x0019:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x004c
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x004e }
            com.tencent.liteav.txcvodplayer.a.b$b r2 = (com.tencent.liteav.txcvodplayer.a.b.C0170b) r2     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x0019
            java.lang.String r3 = "40305"
            java.lang.String r4 = r2.f21870e     // Catch:{ all -> 0x004e }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x0019
            java.lang.String r3 = r2.f21869d     // Catch:{ all -> 0x004e }
            boolean r3 = r10.equalsIgnoreCase(r3)     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x0019
            com.tencent.liteav.txcvodplayer.a.b$a r2 = (com.tencent.liteav.txcvodplayer.a.b.a) r2     // Catch:{ all -> 0x004e }
            long r3 = r2.f21868c     // Catch:{ all -> 0x004e }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x004e }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0019
            boolean r10 = r2.f21867b     // Catch:{ all -> 0x004e }
            monitor-exit(r9)     // Catch:{ all -> 0x004e }
            return r10
        L_0x004c:
            monitor-exit(r9)     // Catch:{ all -> 0x004e }
            return r0
        L_0x004e:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004e }
            throw r10
        L_0x0051:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.a.b.b(java.lang.String):boolean");
    }

    public final void c(final String str) {
        if (str != null && !str.isEmpty()) {
            synchronized (this) {
                if (d(str) < System.currentTimeMillis() / 1000) {
                    LiteavLog.i("TXCVodPlayReportControl", "RequestReportControl");
                    a(str, (System.currentTimeMillis() / 1000) + 3600);
                    new Thread(new Runnable() {
                        public final void run() {
                            b.a(b.this, str);
                            b.a(b.this);
                        }
                    }, "report_control").start();
                }
            }
        }
    }

    /* renamed from: com.tencent.liteav.txcvodplayer.a.b$b  reason: collision with other inner class name */
    public static class C0170b {

        /* renamed from: d  reason: collision with root package name */
        public String f21869d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f21870e = "";

        public C0170b(String str, String str2) {
            this.f21869d = str;
            this.f21870e = str2;
        }

        public C0170b() {
        }
    }

    public static class a extends C0170b {

        /* renamed from: a  reason: collision with root package name */
        public int f21866a = 60;

        /* renamed from: b  reason: collision with root package name */
        public boolean f21867b = false;

        /* renamed from: c  reason: collision with root package name */
        public long f21868c = 0;

        public a(int i11, boolean z11, long j11, String str) {
            super(str, "40305");
            this.f21866a = i11;
            this.f21867b = z11;
            this.f21868c = j11;
        }

        private JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("SengmentDuration", this.f21866a);
                jSONObject.put("ReportSwitch", this.f21867b);
                jSONObject.put("ExpireTime", this.f21868c);
                jSONObject.put("appid", this.f21869d);
                jSONObject.put("eventid", this.f21870e);
            } catch (JSONException e11) {
                LiteavLog.e("TXCVodPlayReportControl", "toJsonObject jsonexception: " + e11.toString());
            }
            return jSONObject;
        }

        public final String toString() {
            return a().toString();
        }

        public a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f21866a = jSONObject.optInt("SengmentDuration", 60);
                this.f21867b = jSONObject.optBoolean("ReportSwitch", false);
                this.f21868c = jSONObject.optLong("ExpireTime", (System.currentTimeMillis() / 1000) + 3600);
                this.f21869d = jSONObject.optString("appid", "");
                this.f21870e = jSONObject.optString("eventid", "");
            } catch (JSONException e11) {
                LiteavLog.i("TXCVodPlayReportControl", "parseFromString: " + e11.toString());
                this.f21866a = 60;
                this.f21867b = false;
                this.f21868c = 0;
                this.f21869d = "";
                this.f21870e = "40305";
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
        return 60;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 60
            if (r10 == 0) goto L_0x0052
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L_0x000b
            goto L_0x0052
        L_0x000b:
            monitor-enter(r9)
            java.util.Map<java.lang.String, java.util.List<com.tencent.liteav.txcvodplayer.a.b$b>> r1 = r9.f21862b     // Catch:{ all -> 0x004f }
            java.lang.Object r1 = r1.get(r10)     // Catch:{ all -> 0x004f }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x004d
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x004f }
        L_0x001a:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x004d
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x004f }
            com.tencent.liteav.txcvodplayer.a.b$b r2 = (com.tencent.liteav.txcvodplayer.a.b.C0170b) r2     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x001a
            java.lang.String r3 = "40305"
            java.lang.String r4 = r2.f21870e     // Catch:{ all -> 0x004f }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x004f }
            if (r3 == 0) goto L_0x001a
            java.lang.String r3 = r2.f21869d     // Catch:{ all -> 0x004f }
            boolean r3 = r10.equalsIgnoreCase(r3)     // Catch:{ all -> 0x004f }
            if (r3 == 0) goto L_0x001a
            com.tencent.liteav.txcvodplayer.a.b$a r2 = (com.tencent.liteav.txcvodplayer.a.b.a) r2     // Catch:{ all -> 0x004f }
            long r3 = r2.f21868c     // Catch:{ all -> 0x004f }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x004f }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x001a
            int r10 = r2.f21866a     // Catch:{ all -> 0x004f }
            monitor-exit(r9)     // Catch:{ all -> 0x004f }
            return r10
        L_0x004d:
            monitor-exit(r9)     // Catch:{ all -> 0x004f }
            return r0
        L_0x004f:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004f }
            throw r10
        L_0x0052:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.a.b.a(java.lang.String):int");
    }

    private void a(String str, long j11) {
        synchronized (this) {
            this.f21863c.put(str, Long.valueOf(j11));
            LiteavLog.i("TXCVodPlayReportControl", "SetReportExpireTime in mem appid= " + str + " , time=" + j11);
        }
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f21861a.getSharedPreferences("vod_report_config", 0);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("value", "");
            if (!string.isEmpty()) {
                try {
                    synchronized (this) {
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                            List<C0170b> e11 = e(jSONArray.optString(i11));
                            if (e11.size() > 0) {
                                this.f21862b.put(e11.get(0).f21869d, e11);
                            }
                        }
                    }
                } catch (JSONException e12) {
                    LiteavLog.e("TXCVodPlayReportControl", e12.toString());
                }
            }
        }
    }

    private void a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("controlInfos");
        int optInt = jSONObject.optInt("appId");
        if (optInt == 0) {
            LiteavLog.i("TXCVodPlayReportControl", "response appid is zero!");
        } else if (optJSONArray != null && optJSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                if (optJSONObject != null && "40305".equals(optJSONObject.optString("eventId"))) {
                    long optLong = optJSONObject.optLong("expireTime", 0);
                    if (optLong > System.currentTimeMillis() / 1000) {
                        String optString = optJSONObject.optString("switch");
                        int optInt2 = optJSONObject.optInt("frequency", 60);
                        arrayList.add(new a(optInt2 < 60 ? 60 : optInt2, "on".equalsIgnoreCase(optString), optLong, String.valueOf(optInt)));
                    }
                }
            }
            synchronized (this) {
                if (arrayList.size() != 0) {
                    this.f21862b.put(String.valueOf(optInt), arrayList);
                    this.f21863c.remove(Integer.valueOf(optInt));
                }
            }
        }
    }

    private static String a(List<C0170b> list) {
        if (list == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        int i11 = 0;
        for (C0170b next : list) {
            JSONObject jSONObject = new JSONObject();
            if ("40305".equals(next.f21870e)) {
                a aVar = (a) next;
                try {
                    jSONObject.put("appid", aVar.f21869d);
                    jSONObject.put("eventid", aVar.f21870e);
                    jSONObject.put("40305", aVar.toString());
                } catch (JSONException e11) {
                    LiteavLog.e("TXCVodPlayReportControl", "controlDataListToString jsonObject.put：" + e11.toString());
                }
            }
            int i12 = i11 + 1;
            try {
                jSONArray.put(i11, jSONObject);
            } catch (JSONException e12) {
                LiteavLog.e("TXCVodPlayReportControl", "jsonArray.put： " + e12.toString());
            }
            i11 = i12;
        }
        return jSONArray.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x014e A[SYNTHETIC, Splitter:B:51:0x014e] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0157 A[SYNTHETIC, Splitter:B:56:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(com.tencent.liteav.txcvodplayer.a.b r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "TXCVodPlayReportControl"
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0030 }
            java.lang.String r3 = com.tencent.liteav.base.util.CommonUtil.getSDKVersionStr()     // Catch:{ MalformedURLException -> 0x0030 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0030 }
            java.lang.String r5 = "https://vodreport.qcloud.com/describeControlInfos/v1/"
            r4.<init>(r5)     // Catch:{ MalformedURLException -> 0x0030 }
            r4.append(r10)     // Catch:{ MalformedURLException -> 0x0030 }
            java.lang.String r10 = "?sdkVersion="
            r4.append(r10)     // Catch:{ MalformedURLException -> 0x0030 }
            r4.append(r3)     // Catch:{ MalformedURLException -> 0x0030 }
            java.lang.String r10 = r4.toString()     // Catch:{ MalformedURLException -> 0x0030 }
            java.lang.String r3 = "makeUrl: "
            java.lang.String r4 = java.lang.String.valueOf(r10)     // Catch:{ MalformedURLException -> 0x0030 }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ MalformedURLException -> 0x0030 }
            com.tencent.liteav.base.util.LiteavLog.i(r0, r3)     // Catch:{ MalformedURLException -> 0x0030 }
            r2.<init>(r10)     // Catch:{ MalformedURLException -> 0x0030 }
            goto L_0x0047
        L_0x0030:
            r10 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "URL :"
            r2.<init>(r3)
            java.lang.String r10 = r10.toString()
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            com.tencent.liteav.base.util.LiteavLog.i(r0, r10)
            r2 = r1
        L_0x0047:
            if (r2 == 0) goto L_0x015b
            java.net.URLConnection r10 = r2.openConnection()     // Catch:{ IOException -> 0x0050 }
            javax.net.ssl.HttpsURLConnection r10 = (javax.net.ssl.HttpsURLConnection) r10     // Catch:{ IOException -> 0x0050 }
            goto L_0x0067
        L_0x0050:
            r10 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "openConnection :"
            r2.<init>(r3)
            java.lang.String r10 = r10.toString()
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            com.tencent.liteav.base.util.LiteavLog.i(r0, r10)
            r10 = r1
        L_0x0067:
            if (r10 == 0) goto L_0x015b
            r2 = 8000(0x1f40, float:1.121E-41)
            r10.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0133 }
            r10.setReadTimeout(r2)     // Catch:{ IOException -> 0x0133 }
            java.lang.String r2 = "Accept-Encoding"
            java.lang.String r3 = "identity"
            r10.setRequestProperty(r2, r3)     // Catch:{ IOException -> 0x0133 }
            r2 = 1
            r10.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x0133 }
            r10.connect()     // Catch:{ IOException -> 0x0133 }
            int r3 = r10.getResponseCode()     // Catch:{ IOException -> 0x0133 }
            java.lang.String r4 = "request report control response code : "
            java.lang.String r5 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x0133 }
            java.lang.String r4 = r4.concat(r5)     // Catch:{ IOException -> 0x0133 }
            com.tencent.liteav.base.util.LiteavLog.i(r0, r4)     // Catch:{ IOException -> 0x0133 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r4 != r3) goto L_0x0128
            java.io.InputStream r3 = r10.getInputStream()     // Catch:{ IOException -> 0x0133 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0133 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0133 }
            r5.<init>(r3)     // Catch:{ IOException -> 0x0133 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0133 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
            r1.<init>()     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
        L_0x00a7:
            java.lang.String r3 = r4.readLine()     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
            if (r3 == 0) goto L_0x00b1
            r1.append(r3)     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
            goto L_0x00a7
        L_0x00b1:
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
            if (r1 == 0) goto L_0x011b
            boolean r3 = r1.isEmpty()     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
            if (r3 == 0) goto L_0x00be
            goto L_0x011b
        L_0x00be:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0104 }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r1 = "code"
            int r1 = r3.getInt(r1)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r5 = "message"
            java.lang.String r5 = r3.optString(r5)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r6 = "requestId"
            java.lang.String r6 = r3.optString(r6)     // Catch:{ JSONException -> 0x0104 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r8 = "code = "
            r7.<init>(r8)     // Catch:{ JSONException -> 0x0104 }
            r7.append(r1)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r8 = " ,message = "
            r7.append(r8)     // Catch:{ JSONException -> 0x0104 }
            r7.append(r5)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r5 = " , requestID= "
            r7.append(r5)     // Catch:{ JSONException -> 0x0104 }
            r7.append(r6)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r5 = r7.toString()     // Catch:{ JSONException -> 0x0104 }
            com.tencent.liteav.base.util.LiteavLog.i(r0, r5)     // Catch:{ JSONException -> 0x0104 }
            if (r1 != 0) goto L_0x0120
            java.lang.String r1 = "version"
            int r1 = r3.getInt(r1)     // Catch:{ JSONException -> 0x0104 }
            if (r1 != r2) goto L_0x0120
            r9.a((org.json.JSONObject) r3)     // Catch:{ JSONException -> 0x0104 }
            goto L_0x0120
        L_0x0104:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
            java.lang.String r2 = "parseJson err: "
            r1.<init>(r2)     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
            r1.append(r9)     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
            java.lang.String r9 = r1.toString()     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
            com.tencent.liteav.base.util.LiteavLog.e(r0, r9)     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
            goto L_0x0120
        L_0x011b:
            java.lang.String r9 = "response msg is empty"
            com.tencent.liteav.base.util.LiteavLog.i(r0, r9)     // Catch:{ IOException -> 0x0125, all -> 0x0122 }
        L_0x0120:
            r1 = r4
            goto L_0x0128
        L_0x0122:
            r9 = move-exception
            r1 = r4
            goto L_0x0152
        L_0x0125:
            r9 = move-exception
            r1 = r4
            goto L_0x0134
        L_0x0128:
            r10.disconnect()
            if (r1 == 0) goto L_0x015b
            r1.close()     // Catch:{ IOException -> 0x0130 }
        L_0x0130:
            return
        L_0x0131:
            r9 = move-exception
            goto L_0x0152
        L_0x0133:
            r9 = move-exception
        L_0x0134:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = "connect or read: "
            r2.<init>(r3)     // Catch:{ all -> 0x0131 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0131 }
            r2.append(r9)     // Catch:{ all -> 0x0131 }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x0131 }
            com.tencent.liteav.base.util.LiteavLog.i(r0, r9)     // Catch:{ all -> 0x0131 }
            r10.disconnect()
            if (r1 == 0) goto L_0x015b
            r1.close()     // Catch:{ IOException -> 0x0151 }
        L_0x0151:
            return
        L_0x0152:
            r10.disconnect()
            if (r1 == 0) goto L_0x015a
            r1.close()     // Catch:{ IOException -> 0x015a }
        L_0x015a:
            throw r9
        L_0x015b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.a.b.a(com.tencent.liteav.txcvodplayer.a.b, java.lang.String):void");
    }

    public static /* synthetic */ void a(b bVar) {
        SharedPreferences.Editor edit;
        synchronized (bVar) {
            int i11 = 0;
            SharedPreferences sharedPreferences = bVar.f21861a.getSharedPreferences("vod_report_config", 0);
            if (!(sharedPreferences == null || (edit = sharedPreferences.edit()) == null || bVar.f21862b.size() <= 0)) {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry value : bVar.f21862b.entrySet()) {
                    int i12 = i11 + 1;
                    try {
                        jSONArray.put(i11, a((List<C0170b>) (List) value.getValue()));
                    } catch (JSONException e11) {
                        LiteavLog.e("TXCVodPlayReportControl", e11.toString());
                    }
                    i11 = i12;
                }
                edit.putString("value", jSONArray.toString());
                edit.apply();
            }
        }
    }
}

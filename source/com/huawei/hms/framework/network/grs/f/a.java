package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.h.c;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public com.huawei.hms.framework.network.grs.local.model.a f38013a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f38014b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38015c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38016d = false;

    /* renamed from: e  reason: collision with root package name */
    public Set<String> f38017e = new HashSet(16);

    private Map<String, String> a(List<b> list, GrsBaseInfo grsBaseInfo, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (b next : list) {
            if (next.a().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), next.b());
            }
            if (next.a().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), next.b());
            }
            if (next.a().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), next.b());
            }
            if (next.a().contains(str)) {
                Logger.v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, next.b());
            }
        }
        return concurrentHashMap;
    }

    private int b(String str, Context context) {
        if (g(c.a(str, context)) != 0) {
            return -1;
        }
        Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", str);
        return 0;
    }

    private int g(String str) {
        int c11;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.f38016d && (c11 = c(str)) != 0) {
            return c11;
        }
        int b11 = b(str);
        return b11 != 0 ? b11 : f(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r0 = r1.f38014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        r0 = d(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int h(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0008
            r2 = -1
            return r2
        L_0x0008:
            boolean r0 = r1.f38016d
            if (r0 == 0) goto L_0x001d
            java.util.List<com.huawei.hms.framework.network.grs.local.model.b> r0 = r1.f38014b
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001d
        L_0x0016:
            int r0 = r1.d(r2)
            if (r0 == 0) goto L_0x001d
            return r0
        L_0x001d:
            int r2 = r1.e(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.a.h(java.lang.String):int");
    }

    public int a(String str, Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(GrsApp.getInstance().getBrand("/"));
        sb2.append(str);
        return b(sb2.toString(), context) != 0 ? -1 : 0;
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.f38013a;
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z11) {
        Map<String, String> a11 = a(context, aVar, grsBaseInfo, str, z11);
        if (a11 != null) {
            return a11.get(str2);
        }
        Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("no_route_country".equals(str)) {
            return "no-country";
        }
        List<b> list = this.f38014b;
        if (list != null && !list.isEmpty()) {
            for (b next : this.f38014b) {
                if (next.a().contains(str)) {
                    return next.b();
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[Catch:{ JSONException -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.huawei.hms.framework.network.grs.local.model.b> a(org.json.JSONArray r13) {
        /*
            r12 = this;
            java.lang.String r0 = "countries"
            java.lang.String r1 = "countriesOrAreas"
            java.lang.String r2 = "AbstractLocalManager"
            if (r13 == 0) goto L_0x00aa
            int r3 = r13.length()
            if (r3 != 0) goto L_0x0010
            goto L_0x00aa
        L_0x0010:
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0091 }
            r5 = 16
            r4.<init>(r5)     // Catch:{ JSONException -> 0x0091 }
            r6 = r3
        L_0x0019:
            int r7 = r13.length()     // Catch:{ JSONException -> 0x0091 }
            if (r6 >= r7) goto L_0x0090
            org.json.JSONObject r7 = r13.getJSONObject(r6)     // Catch:{ JSONException -> 0x0091 }
            com.huawei.hms.framework.network.grs.local.model.b r8 = new com.huawei.hms.framework.network.grs.local.model.b     // Catch:{ JSONException -> 0x0091 }
            r8.<init>()     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r9 = "id"
            java.lang.String r9 = r7.getString(r9)     // Catch:{ JSONException -> 0x0091 }
            r8.b(r9)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r9 = "name"
            java.lang.String r9 = r7.getString(r9)     // Catch:{ JSONException -> 0x0091 }
            r8.c(r9)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r9 = "description"
            java.lang.String r9 = r7.getString(r9)     // Catch:{ JSONException -> 0x0091 }
            r8.a((java.lang.String) r9)     // Catch:{ JSONException -> 0x0091 }
            r9 = 0
            boolean r10 = r7.has(r1)     // Catch:{ JSONException -> 0x0091 }
            if (r10 == 0) goto L_0x0050
            org.json.JSONArray r7 = r7.getJSONArray(r1)     // Catch:{ JSONException -> 0x0091 }
        L_0x004e:
            r9 = r7
            goto L_0x0060
        L_0x0050:
            boolean r10 = r7.has(r0)     // Catch:{ JSONException -> 0x0091 }
            if (r10 == 0) goto L_0x005b
            org.json.JSONArray r7 = r7.getJSONArray(r0)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x004e
        L_0x005b:
            java.lang.String r7 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.w(r2, r7)     // Catch:{ JSONException -> 0x0091 }
        L_0x0060:
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ JSONException -> 0x0091 }
            r7.<init>(r5)     // Catch:{ JSONException -> 0x0091 }
            if (r9 == 0) goto L_0x008a
            int r10 = r9.length()     // Catch:{ JSONException -> 0x0091 }
            if (r10 != 0) goto L_0x006e
            goto L_0x008a
        L_0x006e:
            r10 = r3
        L_0x006f:
            int r11 = r9.length()     // Catch:{ JSONException -> 0x0091 }
            if (r10 >= r11) goto L_0x0081
            java.lang.Object r11 = r9.get(r10)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x0091 }
            r7.add(r11)     // Catch:{ JSONException -> 0x0091 }
            int r10 = r10 + 1
            goto L_0x006f
        L_0x0081:
            r8.a((java.util.Set<java.lang.String>) r7)     // Catch:{ JSONException -> 0x0091 }
            r4.add(r8)     // Catch:{ JSONException -> 0x0091 }
            int r6 = r6 + 1
            goto L_0x0019
        L_0x008a:
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0091 }
            r13.<init>()     // Catch:{ JSONException -> 0x0091 }
            return r13
        L_0x0090:
            return r4
        L_0x0091:
            r13 = move-exception
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r13 = r13.getMessage()
            java.lang.String r13 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r13)
            r0[r3] = r13
            java.lang.String r13 = "parse countrygroup failed maybe json style is wrong. %s"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r2, (java.lang.String) r13, (java.lang.Object[]) r0)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            return r13
        L_0x00aa:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.a.a(org.json.JSONArray):java.util.List");
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z11) {
        com.huawei.hms.framework.network.grs.local.model.a aVar2 = this.f38013a;
        if (aVar2 == null) {
            Logger.w("AbstractLocalManager", "application data is null.");
            return null;
        }
        com.huawei.hms.framework.network.grs.local.model.c a11 = aVar2.a(str);
        if (a11 == null) {
            Logger.w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String b11 = e.b(context, aVar, a11.b(), grsBaseInfo, z11);
        if (b11 == null) {
            Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", a11.b());
            return null;
        }
        List<b> a12 = a11.a();
        d a13 = a11.a((a12 == null || a12.size() == 0) ? a(b11) : a(a12, grsBaseInfo, b11).get(b11));
        if (a13 == null) {
            return null;
        }
        return a13.a();
    }

    public void a(Context context, List<String> list) {
        if (list != null && list.size() > 0) {
            for (String next : list) {
                Logger.d("AbstractLocalManager", "getBatchLoadSdkSuccessFlag file:" + next);
                if (TextUtils.isEmpty(next) || !Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", next)) {
                    Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, skipped.", next);
                } else {
                    if (h(c.a(GrsApp.getInstance().getBrand("/") + next, context)) == 0) {
                        Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", next);
                    } else {
                        Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", next);
                    }
                }
            }
        }
    }

    public abstract int b(String str);

    public Set<String> b() {
        return this.f38017e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(org.json.JSONArray r15) {
        /*
            r14 = this;
            if (r15 == 0) goto L_0x00f6
            int r0 = r15.length()
            if (r0 != 0) goto L_0x000a
            goto L_0x00f6
        L_0x000a:
            r0 = 0
            r1 = r0
        L_0x000c:
            int r2 = r15.length()
            if (r1 >= r2) goto L_0x00f6
            org.json.JSONObject r2 = r15.getJSONObject(r1)
            com.huawei.hms.framework.network.grs.local.model.c r3 = new com.huawei.hms.framework.network.grs.local.model.c
            r3.<init>()
            java.lang.String r4 = "name"
            java.lang.String r4 = r2.getString(r4)
            r3.b(r4)
            java.util.Set<java.lang.String> r5 = r14.f38017e
            boolean r5 = r5.contains(r4)
            if (r5 != 0) goto L_0x00f2
            java.util.Set<java.lang.String> r5 = r14.f38017e
            r5.add(r4)
            boolean r5 = r14.f38016d
            if (r5 == 0) goto L_0x00f2
            java.lang.String r5 = "routeBy"
            java.lang.String r5 = r2.getString(r5)
            r3.c(r5)
            java.lang.String r5 = "servings"
            org.json.JSONArray r5 = r2.getJSONArray(r5)
            r6 = r0
        L_0x0045:
            int r7 = r5.length()
            java.lang.String r8 = "AbstractLocalManager"
            if (r6 >= r7) goto L_0x00bf
            java.lang.Object r7 = r5.get(r6)
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            com.huawei.hms.framework.network.grs.local.model.d r9 = new com.huawei.hms.framework.network.grs.local.model.d
            r9.<init>()
            java.lang.String r10 = "countryOrAreaGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L_0x0065
        L_0x0060:
            java.lang.String r8 = r7.getString(r10)
            goto L_0x007a
        L_0x0065:
            java.lang.String r10 = "countryGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L_0x006e
            goto L_0x0060
        L_0x006e:
            r10 = 1
            java.lang.Object[] r10 = new java.lang.Object[r10]
            r10[r0] = r4
            java.lang.String r11 = "maybe this service{%s} routeBy is unconditional."
            com.huawei.hms.framework.common.Logger.v(r8, r11, r10)
            java.lang.String r8 = "no-country"
        L_0x007a:
            r9.a((java.lang.String) r8)
            java.lang.String r8 = "addresses"
            org.json.JSONObject r7 = r7.getJSONObject(r8)
            java.util.concurrent.ConcurrentHashMap r8 = new java.util.concurrent.ConcurrentHashMap
            r10 = 16
            r8.<init>(r10)
            java.util.Iterator r10 = r7.keys()
        L_0x008e:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00b2
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = r7.getString(r11)
            boolean r13 = android.text.TextUtils.isEmpty(r11)
            if (r13 != 0) goto L_0x008e
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x008e
            java.lang.String r12 = r7.getString(r11)
            r8.put(r11, r12)
            goto L_0x008e
        L_0x00b2:
            r9.a((java.util.Map<java.lang.String, java.lang.String>) r8)
            java.lang.String r7 = r9.b()
            r3.a(r7, r9)
            int r6 = r6 + 1
            goto L_0x0045
        L_0x00bf:
            r5 = 0
            java.lang.String r6 = "countryOrAreaGroups"
            boolean r7 = r2.has(r6)
            if (r7 == 0) goto L_0x00d1
        L_0x00c8:
            org.json.JSONArray r2 = r2.getJSONArray(r6)
            java.util.List r5 = r14.a((org.json.JSONArray) r2)
            goto L_0x00df
        L_0x00d1:
            java.lang.String r6 = "countryGroups"
            boolean r7 = r2.has(r6)
            if (r7 == 0) goto L_0x00da
            goto L_0x00c8
        L_0x00da:
            java.lang.String r2 = "service use default countryOrAreaGroup"
            com.huawei.hms.framework.common.Logger.i(r8, r2)
        L_0x00df:
            r3.a((java.util.List<com.huawei.hms.framework.network.grs.local.model.b>) r5)
            com.huawei.hms.framework.network.grs.local.model.a r2 = r14.f38013a
            if (r2 != 0) goto L_0x00ed
            com.huawei.hms.framework.network.grs.local.model.a r2 = new com.huawei.hms.framework.network.grs.local.model.a
            r2.<init>()
            r14.f38013a = r2
        L_0x00ed:
            com.huawei.hms.framework.network.grs.local.model.a r2 = r14.f38013a
            r2.a(r4, r3)
        L_0x00f2:
            int r1 = r1 + 1
            goto L_0x000c
        L_0x00f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.a.b(org.json.JSONArray):void");
    }

    public abstract int c(String str);

    public boolean c() {
        return this.f38015c;
    }

    public int d(String str) {
        this.f38014b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = null;
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
            }
            if (jSONArray == null) {
                return -1;
            }
            this.f38014b.addAll(a(jSONArray));
            return 0;
        } catch (JSONException e11) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return -1;
        }
    }

    public int e(String str) {
        try {
            b(new JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (JSONException e11) {
            Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return -1;
        }
    }

    public abstract int f(String str);
}

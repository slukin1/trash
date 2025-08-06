package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.huawei.hms.framework.network.grs.local.model.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a {
    public c(Context context, boolean z11) {
        this.f38016d = z11;
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.f38015c = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0060 A[Catch:{ JSONException -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.huawei.hms.framework.network.grs.local.model.b> a(org.json.JSONObject r13) {
        /*
            r12 = this;
            java.lang.String r0 = "countries"
            java.lang.String r1 = "countriesOrAreas"
            java.lang.String r2 = "LocalManagerV1"
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0088 }
            r5 = 16
            r4.<init>(r5)     // Catch:{ JSONException -> 0x0088 }
            java.util.Iterator r6 = r13.keys()     // Catch:{ JSONException -> 0x0088 }
        L_0x0012:
            boolean r7 = r6.hasNext()     // Catch:{ JSONException -> 0x0088 }
            if (r7 == 0) goto L_0x0087
            java.lang.Object r7 = r6.next()     // Catch:{ JSONException -> 0x0088 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ JSONException -> 0x0088 }
            com.huawei.hms.framework.network.grs.local.model.b r8 = new com.huawei.hms.framework.network.grs.local.model.b     // Catch:{ JSONException -> 0x0088 }
            r8.<init>()     // Catch:{ JSONException -> 0x0088 }
            r8.b(r7)     // Catch:{ JSONException -> 0x0088 }
            org.json.JSONObject r7 = r13.getJSONObject(r7)     // Catch:{ JSONException -> 0x0088 }
            java.lang.String r9 = "name"
            java.lang.String r9 = r7.getString(r9)     // Catch:{ JSONException -> 0x0088 }
            r8.c(r9)     // Catch:{ JSONException -> 0x0088 }
            java.lang.String r9 = "description"
            java.lang.String r9 = r7.getString(r9)     // Catch:{ JSONException -> 0x0088 }
            r8.a((java.lang.String) r9)     // Catch:{ JSONException -> 0x0088 }
            r9 = 0
            boolean r10 = r7.has(r1)     // Catch:{ JSONException -> 0x0088 }
            if (r10 == 0) goto L_0x0049
            org.json.JSONArray r7 = r7.getJSONArray(r1)     // Catch:{ JSONException -> 0x0088 }
        L_0x0047:
            r9 = r7
            goto L_0x0059
        L_0x0049:
            boolean r10 = r7.has(r0)     // Catch:{ JSONException -> 0x0088 }
            if (r10 == 0) goto L_0x0054
            org.json.JSONArray r7 = r7.getJSONArray(r0)     // Catch:{ JSONException -> 0x0088 }
            goto L_0x0047
        L_0x0054:
            java.lang.String r7 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.w(r2, r7)     // Catch:{ JSONException -> 0x0088 }
        L_0x0059:
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ JSONException -> 0x0088 }
            r7.<init>(r5)     // Catch:{ JSONException -> 0x0088 }
            if (r9 == 0) goto L_0x0081
            int r10 = r9.length()     // Catch:{ JSONException -> 0x0088 }
            if (r10 != 0) goto L_0x0067
            goto L_0x0081
        L_0x0067:
            r10 = r3
        L_0x0068:
            int r11 = r9.length()     // Catch:{ JSONException -> 0x0088 }
            if (r10 >= r11) goto L_0x007a
            java.lang.Object r11 = r9.get(r10)     // Catch:{ JSONException -> 0x0088 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x0088 }
            r7.add(r11)     // Catch:{ JSONException -> 0x0088 }
            int r10 = r10 + 1
            goto L_0x0068
        L_0x007a:
            r8.a((java.util.Set<java.lang.String>) r7)     // Catch:{ JSONException -> 0x0088 }
            r4.add(r8)     // Catch:{ JSONException -> 0x0088 }
            goto L_0x0012
        L_0x0081:
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0088 }
            r13.<init>()     // Catch:{ JSONException -> 0x0088 }
            return r13
        L_0x0087:
            return r4
        L_0x0088:
            r13 = move-exception
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r13 = r13.getMessage()
            java.lang.String r13 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r13)
            r0[r3] = r13
            java.lang.String r13 = "parse countryGroups failed maybe json style is wrong. %s"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r2, (java.lang.String) r13, (java.lang.Object[]) r0)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.c.a(org.json.JSONObject):java.util.List");
    }

    public List<b> a(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : a(jSONObject);
    }

    public int b(String str) {
        this.f38013a = new a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(MimeTypes.BASE_TYPE_APPLICATION);
            String string = jSONObject.getString("name");
            long j11 = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.f38013a.b(string);
            this.f38013a.a(j11);
            return (jSONArray == null || jSONArray.length() == 0) ? -1 : 0;
        } catch (JSONException e11) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return -1;
        }
    }

    public int c(String str) {
        this.f38014b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = null;
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONObject2 = jSONObject.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONObject2 = jSONObject.getJSONObject("countryGroups");
            } else {
                Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
            }
            if (jSONObject2 == null) {
                return -1;
            }
            if (jSONObject2.length() != 0) {
                this.f38014b.addAll(a(jSONObject2));
            }
            return 0;
        } catch (JSONException e11) {
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2 A[Catch:{ JSONException -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010c A[Catch:{ JSONException -> 0x0120 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int f(java.lang.String r21) {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = "countryGroup"
            java.lang.String r2 = "countryOrAreaGroup"
            java.lang.String r3 = "countryGroups"
            java.lang.String r4 = "countryOrAreaGroups"
            java.lang.String r5 = "LocalManagerV1"
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0120 }
            r8 = r21
            r7.<init>(r8)     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r8 = "services"
            org.json.JSONObject r7 = r7.getJSONObject(r8)     // Catch:{ JSONException -> 0x0120 }
            java.util.Iterator r8 = r7.keys()     // Catch:{ JSONException -> 0x0120 }
        L_0x001d:
            boolean r9 = r8.hasNext()     // Catch:{ JSONException -> 0x0120 }
            if (r9 == 0) goto L_0x011e
            java.lang.Object r9 = r8.next()     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ JSONException -> 0x0120 }
            com.huawei.hms.framework.network.grs.local.model.c r10 = new com.huawei.hms.framework.network.grs.local.model.c     // Catch:{ JSONException -> 0x0120 }
            r10.<init>()     // Catch:{ JSONException -> 0x0120 }
            r10.b(r9)     // Catch:{ JSONException -> 0x0120 }
            java.util.Set<java.lang.String> r11 = r1.f38017e     // Catch:{ JSONException -> 0x0120 }
            boolean r11 = r11.contains(r9)     // Catch:{ JSONException -> 0x0120 }
            if (r11 != 0) goto L_0x001d
            java.util.Set<java.lang.String> r11 = r1.f38017e     // Catch:{ JSONException -> 0x0120 }
            r11.add(r9)     // Catch:{ JSONException -> 0x0120 }
            boolean r11 = r1.f38016d     // Catch:{ JSONException -> 0x0120 }
            if (r11 == 0) goto L_0x001d
            org.json.JSONObject r11 = r7.getJSONObject(r9)     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r12 = "routeBy"
            java.lang.String r12 = r11.getString(r12)     // Catch:{ JSONException -> 0x0120 }
            r10.c(r12)     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r12 = "servings"
            org.json.JSONArray r12 = r11.getJSONArray(r12)     // Catch:{ JSONException -> 0x0120 }
            r13 = 0
        L_0x0056:
            int r14 = r12.length()     // Catch:{ JSONException -> 0x0120 }
            if (r13 >= r14) goto L_0x00e1
            java.lang.Object r14 = r12.get(r13)     // Catch:{ JSONException -> 0x0120 }
            org.json.JSONObject r14 = (org.json.JSONObject) r14     // Catch:{ JSONException -> 0x0120 }
            com.huawei.hms.framework.network.grs.local.model.d r15 = new com.huawei.hms.framework.network.grs.local.model.d     // Catch:{ JSONException -> 0x0120 }
            r15.<init>()     // Catch:{ JSONException -> 0x0120 }
            boolean r16 = r14.has(r2)     // Catch:{ JSONException -> 0x0120 }
            if (r16 == 0) goto L_0x0072
            java.lang.String r16 = r14.getString(r2)     // Catch:{ JSONException -> 0x0120 }
            goto L_0x007c
        L_0x0072:
            boolean r16 = r14.has(r0)     // Catch:{ JSONException -> 0x0120 }
            if (r16 == 0) goto L_0x007f
            java.lang.String r16 = r14.getString(r0)     // Catch:{ JSONException -> 0x0120 }
        L_0x007c:
            r6 = r16
            goto L_0x0086
        L_0x007f:
            java.lang.String r6 = "maybe this service routeBy is unconditional."
            com.huawei.hms.framework.common.Logger.v(r5, r6)     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r6 = "no-country"
        L_0x0086:
            r15.a((java.lang.String) r6)     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r6 = "addresses"
            org.json.JSONObject r6 = r14.getJSONObject(r6)     // Catch:{ JSONException -> 0x0120 }
            java.util.concurrent.ConcurrentHashMap r14 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ JSONException -> 0x0120 }
            r17 = r0
            r0 = 16
            r14.<init>(r0)     // Catch:{ JSONException -> 0x0120 }
            java.util.Iterator r0 = r6.keys()     // Catch:{ JSONException -> 0x0120 }
        L_0x009c:
            boolean r18 = r0.hasNext()     // Catch:{ JSONException -> 0x0120 }
            if (r18 == 0) goto L_0x00cd
            java.lang.Object r18 = r0.next()     // Catch:{ JSONException -> 0x0120 }
            r21 = r0
            r0 = r18
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r18 = r6.getString(r0)     // Catch:{ JSONException -> 0x0120 }
            boolean r19 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0120 }
            if (r19 != 0) goto L_0x00ca
            boolean r18 = android.text.TextUtils.isEmpty(r18)     // Catch:{ JSONException -> 0x0120 }
            if (r18 != 0) goto L_0x00ca
            r18 = r2
            java.lang.String r2 = r6.getString(r0)     // Catch:{ JSONException -> 0x0120 }
            r14.put(r0, r2)     // Catch:{ JSONException -> 0x0120 }
            r0 = r21
            r2 = r18
            goto L_0x009c
        L_0x00ca:
            r0 = r21
            goto L_0x009c
        L_0x00cd:
            r18 = r2
            r15.a((java.util.Map<java.lang.String, java.lang.String>) r14)     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r0 = r15.b()     // Catch:{ JSONException -> 0x0120 }
            r10.a(r0, r15)     // Catch:{ JSONException -> 0x0120 }
            int r13 = r13 + 1
            r0 = r17
            r2 = r18
            goto L_0x0056
        L_0x00e1:
            r17 = r0
            r18 = r2
            boolean r0 = r11.has(r4)     // Catch:{ JSONException -> 0x0120 }
            r2 = 0
            if (r0 == 0) goto L_0x00f1
            org.json.JSONObject r0 = r11.getJSONObject(r4)     // Catch:{ JSONException -> 0x0120 }
            goto L_0x00fb
        L_0x00f1:
            boolean r0 = r11.has(r3)     // Catch:{ JSONException -> 0x0120 }
            if (r0 == 0) goto L_0x0100
            org.json.JSONObject r0 = r11.getJSONObject(r3)     // Catch:{ JSONException -> 0x0120 }
        L_0x00fb:
            java.util.List r2 = r1.a(r2, r0)     // Catch:{ JSONException -> 0x0120 }
            goto L_0x0105
        L_0x0100:
            java.lang.String r0 = "service use default countryOrAreaGroup"
            com.huawei.hms.framework.common.Logger.v(r5, r0)     // Catch:{ JSONException -> 0x0120 }
        L_0x0105:
            r10.a((java.util.List<com.huawei.hms.framework.network.grs.local.model.b>) r2)     // Catch:{ JSONException -> 0x0120 }
            com.huawei.hms.framework.network.grs.local.model.a r0 = r1.f38013a     // Catch:{ JSONException -> 0x0120 }
            if (r0 != 0) goto L_0x0113
            com.huawei.hms.framework.network.grs.local.model.a r0 = new com.huawei.hms.framework.network.grs.local.model.a     // Catch:{ JSONException -> 0x0120 }
            r0.<init>()     // Catch:{ JSONException -> 0x0120 }
            r1.f38013a = r0     // Catch:{ JSONException -> 0x0120 }
        L_0x0113:
            com.huawei.hms.framework.network.grs.local.model.a r0 = r1.f38013a     // Catch:{ JSONException -> 0x0120 }
            r0.a(r9, r10)     // Catch:{ JSONException -> 0x0120 }
            r0 = r17
            r2 = r18
            goto L_0x001d
        L_0x011e:
            r2 = 0
            return r2
        L_0x0120:
            r0 = move-exception
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r0)
            r3 = 0
            r2[r3] = r0
            java.lang.String r0 = "parse 1.0 services failed maybe because of json style.please check! %s"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r5, (java.lang.String) r0, (java.lang.Object[]) r2)
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.c.f(java.lang.String):int");
    }
}

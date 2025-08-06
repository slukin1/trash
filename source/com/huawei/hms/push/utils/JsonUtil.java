package com.huawei.hms.push.utils;

import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    private JsonUtil() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: long[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(org.json.JSONObject r3, java.lang.String r4, java.lang.Object r5, android.os.Bundle r6) {
        /*
            java.lang.String r0 = "JsonUtil"
            if (r5 != 0) goto L_0x000a
            java.lang.String r3 = "transfer jsonObject to bundle failed, defaultValue is null."
            com.huawei.hms.support.log.HMSLog.w(r0, r3)
            return
        L_0x000a:
            boolean r1 = r5 instanceof java.lang.String
            r2 = 0
            if (r1 == 0) goto L_0x0021
            java.lang.String r5 = (java.lang.String) r5
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r2 = r5
        L_0x0019:
            java.lang.String r3 = getString(r3, r4, r2)
            r6.putString(r4, r3)
            goto L_0x0071
        L_0x0021:
            boolean r1 = r5 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x0033
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r3 = getInt(r3, r4, r5)
            r6.putInt(r4, r3)
            goto L_0x0071
        L_0x0033:
            boolean r1 = r5 instanceof int[]
            if (r1 == 0) goto L_0x0046
            int[] r5 = (int[]) r5
            int r0 = r5.length
            if (r0 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r2 = r5
        L_0x003e:
            int[] r3 = getIntArray(r3, r4, r2)
            r6.putIntArray(r4, r3)
            goto L_0x0071
        L_0x0046:
            boolean r1 = r5 instanceof long[]
            if (r1 == 0) goto L_0x0059
            long[] r5 = (long[]) r5
            int r0 = r5.length
            if (r0 != 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r2 = r5
        L_0x0051:
            long[] r3 = getLongArray(r3, r4, r2)
            r6.putLongArray(r4, r3)
            goto L_0x0071
        L_0x0059:
            boolean r1 = r5 instanceof java.lang.String[]
            if (r1 == 0) goto L_0x006c
            java.lang.String[] r5 = (java.lang.String[]) r5
            int r0 = r5.length
            if (r0 != 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r2 = r5
        L_0x0064:
            java.lang.String[] r3 = getStringArray(r3, r4, r2)
            r6.putStringArray(r4, r3)
            goto L_0x0071
        L_0x006c:
            java.lang.String r3 = "transfer jsonObject to bundle failed, invalid data type."
            com.huawei.hms.support.log.HMSLog.w(r0, r3)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.utils.JsonUtil.a(org.json.JSONObject, java.lang.String, java.lang.Object, android.os.Bundle):void");
    }

    public static int getInt(JSONObject jSONObject, String str, int i11) {
        if (jSONObject == null) {
            return i11;
        }
        try {
            if (jSONObject.has(str)) {
                return jSONObject.getInt(str);
            }
            return i11;
        } catch (JSONException unused) {
            HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            return i11;
        }
    }

    public static int[] getIntArray(JSONObject jSONObject, String str, int[] iArr) {
        int[] iArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    iArr2 = new int[jSONArray.length()];
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        iArr2[i11] = ((Integer) jSONArray.get(i11)).intValue();
                    }
                }
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return iArr2 == null ? iArr : iArr2;
    }

    public static JSONArray getIntJsonArray(int[] iArr) {
        JSONArray jSONArray = new JSONArray();
        if (!(iArr == null || iArr.length == 0)) {
            for (int put : iArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }

    public static long[] getLongArray(JSONObject jSONObject, String str, long[] jArr) {
        long[] jArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    jArr2 = new long[jSONArray.length()];
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        jArr2[i11] = jSONArray.getLong(i11);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return jArr2 == null ? jArr : jArr2;
    }

    public static JSONArray getLongJsonArray(long[] jArr) {
        JSONArray jSONArray = new JSONArray();
        if (!(jArr == null || jArr.length == 0)) {
            for (long put : jArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return str2;
        }
        try {
            if (!jSONObject.has(str) || jSONObject.get(str) == null) {
                return str2;
            }
            return String.valueOf(jSONObject.get(str));
        } catch (JSONException unused) {
            HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            return str2;
        }
    }

    public static String[] getStringArray(JSONObject jSONObject, String str, String[] strArr) {
        String[] strArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    strArr2 = new String[jSONArray.length()];
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        strArr2[i11] = (String) jSONArray.get(i11);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return strArr2;
    }

    public static JSONArray getStringJsonArray(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (!(strArr == null || strArr.length == 0)) {
            for (String put : strArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }

    public static void transferJsonObjectToBundle(JSONObject jSONObject, Bundle bundle, HashMap<String, Object> hashMap) {
        for (Map.Entry next : hashMap.entrySet()) {
            a(jSONObject, (String) next.getKey(), next.getValue(), bundle);
        }
    }
}

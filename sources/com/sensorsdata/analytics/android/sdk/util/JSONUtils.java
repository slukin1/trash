package com.sensorsdata.analytics.android.sdk.util;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
    private static void addIndentBlank(StringBuilder sb2, int i11) {
        int i12 = 0;
        while (i12 < i11) {
            try {
                sb2.append(9);
                i12++;
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
                return;
            }
        }
    }

    public static JSONObject cloneJsonObject(JSONObject jSONObject) throws InvalidDataException {
        if (jSONObject == null) {
            return null;
        }
        try {
            SADataHelper.assertPropertyTypes(jSONObject);
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof Date) {
                    jSONObject2.put(next, new Date(((Date) obj).getTime()));
                }
            }
            return jSONObject2;
        } catch (JSONException unused) {
            return jSONObject;
        }
    }

    public static String formatJson(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    StringBuilder sb2 = new StringBuilder();
                    int i11 = 0;
                    char c11 = 0;
                    boolean z11 = false;
                    int i12 = 0;
                    while (i11 < str.length()) {
                        char charAt = str.charAt(i11);
                        if (charAt == '\"') {
                            if (c11 != '\\') {
                                z11 = !z11;
                            }
                            sb2.append(charAt);
                        } else if (charAt != ',') {
                            if (charAt != '{') {
                                if (charAt != '}') {
                                    switch (charAt) {
                                        case '[':
                                            break;
                                        case '\\':
                                            break;
                                        case ']':
                                            break;
                                        default:
                                            sb2.append(charAt);
                                            break;
                                    }
                                }
                                if (!z11) {
                                    sb2.append(10);
                                    i12--;
                                    addIndentBlank(sb2, i12);
                                }
                                sb2.append(charAt);
                            }
                            sb2.append(charAt);
                            if (!z11) {
                                sb2.append(10);
                                i12++;
                                addIndentBlank(sb2, i12);
                            }
                        } else {
                            sb2.append(charAt);
                            if (c11 != '\\' && !z11) {
                                sb2.append(10);
                                addIndentBlank(sb2, i12);
                            }
                        }
                        i11++;
                        c11 = charAt;
                    }
                    return sb2.toString();
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
        return "";
    }

    public static Map<String, String> json2Map(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.optString(next));
        }
        return hashMap;
    }

    public static void mergeDistinctProperty(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject2.has(next)) {
                    Object obj = jSONObject.get(next);
                    if (!(obj instanceof Date) || "$time".equals(next)) {
                        jSONObject2.put(next, obj);
                    } else {
                        jSONObject2.put(next, TimeUtils.formatDate((Date) obj, Locale.CHINA));
                    }
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static String optionalStringKey(JSONObject jSONObject, String str) throws JSONException {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }
}

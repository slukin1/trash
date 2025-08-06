package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public class c1 {
    public static Map<String, List<b1>> a(Context context, String str) {
        if (context == null) {
            return null;
        }
        Map<String, ?> a11 = d.a(context, str);
        b(a11);
        return a(a11);
    }

    public static Map<String, List<b1>> a(Context context, String str, String str2) {
        Map<String, List<b1>> map;
        Map<String, List<b1>> map2;
        if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
            v.c("hmsSdk", "read all event records");
            map = a(context, "stat_v2_1");
            map2 = a(context, "cached_v2_1");
        } else {
            String a11 = n1.a(str, str2);
            map = b(context, "stat_v2_1", a11);
            map2 = b(context, "cached_v2_1", a11);
        }
        return a(map, map2);
    }

    private static Map<String, List<b1>> a(Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            if (next.getValue() instanceof String) {
                a(str, (String) next.getValue(), (Map<String, List<b1>>) hashMap);
            }
        }
        return hashMap;
    }

    private static Map<String, List<b1>> a(Map<String, List<b1>> map, Map<String, List<b1>> map2) {
        if (map.size() == 0 && map2.size() == 0) {
            return new HashMap();
        }
        if (map.size() == 0) {
            return map2;
        }
        if (map2.size() == 0) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        hashMap.putAll(map2);
        return hashMap;
    }

    private static void a(String str, String str2, Map<String, List<b1>> map) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONArray jSONArray = new JSONArray(str2);
                if (jSONArray.length() != 0) {
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        b1 b1Var = new b1();
                        try {
                            b1Var.a(jSONArray.getJSONObject(i11));
                            arrayList.add(b1Var);
                        } catch (JSONException unused) {
                            v.e("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
                        }
                    }
                    map.put(str, arrayList);
                }
            }
        } catch (JSONException unused2) {
            v.e("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
        }
    }

    public static Map<String, List<b1>> b(Context context, String str, String str2) {
        String a11 = d.a(context, str, str2, "");
        HashMap hashMap = new HashMap();
        a(str2, a11, (Map<String, List<b1>>) hashMap);
        return hashMap;
    }

    private static void b(Map<String, ?> map) {
        Iterator<Map.Entry<String, ?>> it2 = map.entrySet().iterator();
        Set<String> a11 = n1.a(q0.b());
        while (it2.hasNext()) {
            if (!a11.contains(it2.next().getKey())) {
                it2.remove();
            }
        }
    }
}

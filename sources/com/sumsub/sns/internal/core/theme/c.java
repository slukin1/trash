package com.sumsub.sns.internal.core.theme;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    public static final Map<String, Object> a(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = a((JSONObject) obj);
            }
            linkedHashMap.put(next, obj);
        }
        return linkedHashMap;
    }

    public static final List<String> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i11 = 0; i11 < length; i11++) {
            arrayList.add(jSONArray.optString(i11));
        }
        return arrayList;
    }

    public static final List<Object> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i11 = 0; i11 < length; i11++) {
            Object obj = jSONArray.get(i11);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = a((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}

package com.sensorsdata.analytics.android.sdk;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public final class PropertyBuilder {
    private static final String TAG = "SA.PropertyBuilder";
    private final LinkedHashMap<String, Object> innerPropertyMap = new LinkedHashMap<>();

    private PropertyBuilder() {
    }

    public static PropertyBuilder newInstance() {
        return new PropertyBuilder();
    }

    public PropertyBuilder append(String str, Object obj) {
        this.innerPropertyMap.put(str, obj);
        return this;
    }

    public void clear() {
        this.innerPropertyMap.clear();
    }

    public Object remove(String str) {
        return this.innerPropertyMap.remove(str);
    }

    public int size() {
        return this.innerPropertyMap.size();
    }

    public JSONObject toJSONObject() {
        this.innerPropertyMap.remove((Object) null);
        if (this.innerPropertyMap.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String next : this.innerPropertyMap.keySet()) {
            try {
                jSONObject.put(next, this.innerPropertyMap.get(next));
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
        return jSONObject;
    }

    public PropertyBuilder append(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            this.innerPropertyMap.putAll(map);
        }
        return this;
    }

    public PropertyBuilder append(Object... objArr) {
        if (objArr == null || objArr.length <= 1) {
            SALog.i(TAG, "The key value pair is incorrect.");
            return this;
        }
        int i11 = 0;
        while (i11 < objArr.length) {
            String str = objArr[i11];
            int i12 = i11 + 1;
            if (i12 >= objArr.length) {
                SALog.i(TAG, "this element key[index= " + i12 + "] will be ignored, because no element can pair with it. ");
                return this;
            }
            Object obj = objArr[i12];
            if (str instanceof String) {
                this.innerPropertyMap.put(str, obj);
            } else {
                SALog.i(TAG, "this element key[index= " + i12 + "] is not a String, the method will ignore the element and the next element. ");
            }
            i11 = i12 + 1;
        }
        return this;
    }
}

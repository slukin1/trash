package com.huobi.store;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class BusinessLineHelper {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentHashMap<Integer, Object> f81296a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static ConcurrentHashMap<Integer, JSONObject> f81297b = new ConcurrentHashMap<>();

    public static <T> T a(BusinessLine businessLine, Class<T> cls) {
        try {
            if (f81296a.containsKey(Integer.valueOf(businessLine.number))) {
                return f81296a.get(Integer.valueOf(businessLine.number));
            }
            T parseObject = businessLine.parseObject(cls);
            if (parseObject != null) {
                f81296a.put(Integer.valueOf(businessLine.number), parseObject);
            }
            return parseObject;
        } catch (Exception e11) {
            Log.e("AppConfig", "get: ", e11);
            return null;
        }
    }

    public static <T> T b(BusinessLine businessLine, Type type) {
        try {
            if (f81296a.containsKey(Integer.valueOf(businessLine.number))) {
                return f81296a.get(Integer.valueOf(businessLine.number));
            }
            T parseObject = businessLine.parseObject(type);
            if (parseObject != null) {
                f81296a.put(Integer.valueOf(businessLine.number), parseObject);
            }
            return parseObject;
        } catch (Exception e11) {
            Log.e("AppConfig", "get: ", e11);
            return null;
        }
    }

    public static <T> boolean c(BusinessLine businessLine, String str, boolean z11, Class<T> cls) {
        T t11;
        JSONObject jSONObject;
        if (str.equals("isSwitch")) {
            return businessLine.isSwitch();
        }
        if (str.equals("isOpen")) {
            return businessLine.isOpen();
        }
        if (businessLine == null) {
            return z11;
        }
        if (cls == null) {
            try {
                if (f81297b.containsKey(Integer.valueOf(businessLine.number))) {
                    jSONObject = f81297b.get(Integer.valueOf(businessLine.number));
                } else {
                    if (!TextUtils.isEmpty(businessLine.patternContent)) {
                        JSONObject jSONObject2 = new JSONObject(businessLine.patternContent);
                        f81297b.put(Integer.valueOf(businessLine.number), jSONObject2);
                        jSONObject = jSONObject2;
                    }
                    return z11;
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    if (keys.next().equals(str)) {
                        return jSONObject.optBoolean(str, z11);
                    }
                }
                return z11;
            } catch (Exception e11) {
                Log.e("AppConfig", "getBoolean: ", e11);
                return z11;
            }
        } else {
            if (f81296a.containsKey(Integer.valueOf(businessLine.number))) {
                t11 = f81296a.get(Integer.valueOf(businessLine.number));
            } else {
                T fromJson = GsonHelper.a().fromJson(businessLine.patternContent, cls);
                if (fromJson != null) {
                    f81296a.put(Integer.valueOf(businessLine.number), fromJson);
                }
                t11 = fromJson;
            }
            return t11.getClass().getField(str).getBoolean(t11);
        }
    }

    public static <T> int d(BusinessLine businessLine, String str, int i11, Class<T> cls) {
        T t11;
        JSONObject jSONObject;
        if (businessLine == null) {
            return i11;
        }
        if (cls == null) {
            try {
                if (f81297b.containsKey(Integer.valueOf(businessLine.number))) {
                    jSONObject = f81297b.get(Integer.valueOf(businessLine.number));
                } else {
                    if (!TextUtils.isEmpty(businessLine.patternContent)) {
                        JSONObject jSONObject2 = new JSONObject(businessLine.patternContent);
                        f81297b.put(Integer.valueOf(businessLine.number), jSONObject2);
                        jSONObject = jSONObject2;
                    }
                    return i11;
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    if (keys.next().equals(str)) {
                        return jSONObject.optInt(str, i11);
                    }
                }
                return i11;
            } catch (Exception e11) {
                Log.e("AppConfig", "getInt: ", e11);
                return i11;
            }
        } else {
            if (f81296a.containsKey(Integer.valueOf(businessLine.number))) {
                t11 = f81296a.get(Integer.valueOf(businessLine.number));
            } else {
                T fromJson = GsonHelper.a().fromJson(businessLine.patternContent, cls);
                if (fromJson != null) {
                    f81296a.put(Integer.valueOf(businessLine.number), fromJson);
                }
                t11 = fromJson;
            }
            return t11.getClass().getField(str).getInt(t11);
        }
    }

    public static <T> List<T> e(BusinessLine businessLine, Class<T> cls) {
        try {
            if (f81296a.containsKey(Integer.valueOf(businessLine.number))) {
                return (List) f81296a.get(Integer.valueOf(businessLine.number));
            }
            List<T> parseArray = businessLine.parseArray(cls);
            if (parseArray != null) {
                f81296a.put(Integer.valueOf(businessLine.number), parseArray);
            }
            return parseArray;
        } catch (Exception e11) {
            Log.e("AppConfig", "getObjectList: ", e11);
            return new ArrayList();
        }
    }

    public static <T> String f(BusinessLine businessLine, String str, String str2, Class<T> cls) {
        T t11;
        JSONObject jSONObject;
        if (businessLine == null) {
            return str2;
        }
        if (cls == null) {
            try {
                if (f81297b.containsKey(Integer.valueOf(businessLine.number))) {
                    jSONObject = f81297b.get(Integer.valueOf(businessLine.number));
                } else {
                    if (!TextUtils.isEmpty(businessLine.patternContent)) {
                        JSONObject jSONObject2 = new JSONObject(businessLine.patternContent);
                        f81297b.put(Integer.valueOf(businessLine.number), jSONObject2);
                        jSONObject = jSONObject2;
                    }
                    return str2;
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    if (keys.next().equals(str)) {
                        return jSONObject.optString(str, str2);
                    }
                }
                return str2;
            } catch (Exception e11) {
                Log.e("AppConfig", "getString: ", e11);
                return str2;
            }
        } else {
            if (f81296a.containsKey(Integer.valueOf(businessLine.number))) {
                t11 = f81296a.get(Integer.valueOf(businessLine.number));
            } else {
                T fromJson = GsonHelper.a().fromJson(businessLine.patternContent, cls);
                if (fromJson != null) {
                    f81296a.put(Integer.valueOf(businessLine.number), fromJson);
                }
                t11 = fromJson;
            }
            return (String) t11.getClass().getField(str).get(t11);
        }
    }
}

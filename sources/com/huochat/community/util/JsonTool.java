package com.huochat.community.util;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

public class JsonTool {
    public static <T> List<T> parseArray(String str, Class<T> cls) {
        try {
            return JSON.parseArray(str, cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject parseObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return JSON.parseObject(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String toJSONString(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Exception unused) {
            return "";
        }
    }

    public static <T> T parseObject(String str, Class<T> cls) {
        try {
            return JSON.parseObject(str, cls);
        } catch (Exception unused) {
            return null;
        }
    }
}

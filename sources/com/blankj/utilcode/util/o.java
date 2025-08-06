package com.blankj.utilcode.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o {
    public static String a(String str) {
        return b(str, 4);
    }

    public static String b(String str, int i11) {
        try {
            int length = str.length();
            for (int i12 = 0; i12 < length; i12++) {
                char charAt = str.charAt(i12);
                if (charAt == '{') {
                    return new JSONObject(str).toString(i11);
                }
                if (charAt == '[') {
                    return new JSONArray(str).toString(i11);
                }
                if (!Character.isWhitespace(charAt)) {
                    return str;
                }
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return str;
    }
}

package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class h {
    public static String a(String str, String str2) {
        return !str.equals(str2) ? b(str, str2) : str;
    }

    private static String b(String str, String str2) {
        HashSet<String> hashSet = new HashSet<>();
        if (!TextUtils.isEmpty(str)) {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("services");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                hashSet.add(jSONArray.getString(i11));
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            JSONArray jSONArray2 = new JSONObject(str2).getJSONArray("services");
            for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                hashSet.add(jSONArray2.getString(i12));
            }
        }
        if (hashSet.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray3 = new JSONArray();
        for (String put : hashSet) {
            jSONArray3.put(put);
        }
        jSONObject.put("services", jSONArray3);
        return jSONObject.toString();
    }
}

package com.huobi.woodpecker.model;

import android.text.TextUtils;
import com.huobi.woodpecker.net.UrlConfig;
import java.util.Map;
import okhttp3.Headers;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiResHeader {

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f21135a = new JSONObject();

    public static ApiResHeader a(Headers headers) {
        if (headers == null || headers.size() <= 0 || UrlConfig.b() == null) {
            return null;
        }
        ApiResHeader apiResHeader = new ApiResHeader();
        for (Map.Entry next : UrlConfig.b().entrySet()) {
            String str = headers.get((String) next.getKey());
            if (!TextUtils.isEmpty(str)) {
                try {
                    apiResHeader.f21135a.put((String) next.getValue(), str);
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
        }
        return apiResHeader;
    }

    public JSONObject b() {
        return this.f21135a;
    }

    public String toString() {
        JSONObject b11 = b();
        return b11 != null ? b11.toString() : "{}";
    }
}

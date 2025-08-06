package com.kakao.common;

import android.content.Context;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.SystemInfo;
import com.kakao.util.helper.Utility;
import org.json.JSONException;
import org.json.JSONObject;
import qw.c;

public interface IConfiguration {

    public static class Factory {
        public static IConfiguration a(Context context) throws KakaoException {
            SystemInfo.b(context);
            String b11 = Utility.b(context);
            String a11 = SystemInfo.a();
            String valueOf = String.valueOf(Utility.a(context));
            String packageName = context.getPackageName();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appPkg", context.getPackageName());
                jSONObject.put("KA", a11);
                jSONObject.put("keyHash", b11);
                return new c(b11, a11, valueOf, packageName, jSONObject);
            } catch (JSONException e11) {
                throw new IllegalArgumentException("JSON parsing error. Malformed parameters were provided. Detailed error message: " + e11.toString());
            }
        }
    }

    String a();

    String b();

    JSONObject c();
}

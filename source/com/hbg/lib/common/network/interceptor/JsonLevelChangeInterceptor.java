package com.hbg.lib.common.network.interceptor;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaomi.mipush.sdk.Constants;
import i6.d;
import i6.m;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class JsonLevelChangeInterceptor implements Interceptor {
    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            JSONObject parseObject = JSON.parseObject(str);
            if ((parseObject.containsKey("status") && !m.a0(parseObject.get("status").toString())) || !parseObject.containsKey("data")) {
                return str;
            }
            String str2 = parseObject.getString("data").toString();
            if (TextUtils.isEmpty(str2) || !str2.trim().startsWith("{")) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            StringBuilder deleteCharAt = sb2.deleteCharAt(sb2.length() - 1);
            deleteCharAt.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            deleteCharAt.append(str2.substring(1, str2.length()));
            return sb2.toString();
        } catch (Exception e11) {
            d.g(e11);
            return str;
        }
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        if (proceed == null || !proceed.isSuccessful() || proceed.body() == null) {
            return proceed;
        }
        return proceed.newBuilder().body(ResponseBody.create(proceed.body().contentType(), a(proceed.body().string()))).build();
    }
}

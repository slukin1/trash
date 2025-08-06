package com.huobi.network.interceptor;

import android.text.TextUtils;
import i6.k;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tg.r;

public class ProInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Headers.Builder newBuilder = request.headers().newBuilder();
        if (r.x().F0()) {
            if (TextUtils.isEmpty(r.x().H())) {
                String httpUrl = request.url().toString();
                if (httpUrl.contains("v2/beta/common/symbols") || httpUrl.contains("v2/beta/common/currencies") || httpUrl.contains("v1/hbg/super-margin/symbols")) {
                    k.o("Pro拦截器", "url为symbol或者currencies");
                    newBuilder.set("HB-PRO-TOKEN", "aaa");
                }
            } else {
                newBuilder.set("HB-PRO-TOKEN", r.x().H());
            }
        } else if (!TextUtils.isEmpty(r.x().H())) {
            newBuilder.set("HB-PRO-TOKEN", r.x().H());
        }
        newBuilder.set("HB-API-VERSION", "1.7");
        if (!TextUtils.isEmpty(r.x().C())) {
            newBuilder.set("HB-KYC-TOKEN", r.x().C());
        }
        return chain.proceed(request.newBuilder().headers(newBuilder.build()).build());
    }
}

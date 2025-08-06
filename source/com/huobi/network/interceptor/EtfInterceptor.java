package com.huobi.network.interceptor;

import android.text.TextUtils;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tg.r;

public class EtfInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Headers.Builder newBuilder = request.headers().newBuilder();
        if (!TextUtils.isEmpty(r.x().v())) {
            newBuilder.set("HB-ETF-TOKEN", r.x().v());
        }
        return chain.proceed(request.newBuilder().headers(newBuilder.build()).build());
    }
}

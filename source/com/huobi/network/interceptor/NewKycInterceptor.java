package com.huobi.network.interceptor;

import android.text.TextUtils;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tg.r;

public class NewKycInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Headers.Builder newBuilder = request.headers().newBuilder();
        if (!TextUtils.isEmpty(r.x().C())) {
            newBuilder.set("HB-KYC-TOKEN", r.x().C());
        }
        return chain.proceed(request.newBuilder().headers(newBuilder.build()).build());
    }
}

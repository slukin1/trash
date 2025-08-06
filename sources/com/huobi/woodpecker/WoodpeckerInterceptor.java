package com.huobi.woodpecker;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class WoodpeckerInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Headers.Builder newBuilder = request.headers().newBuilder();
        newBuilder.set("x-b3-traceid", b.b());
        return chain.proceed(request.newBuilder().headers(newBuilder.build()).build());
    }
}

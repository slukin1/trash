package com.huobi.network.interceptor;

import android.text.TextUtils;
import com.huobi.utils.x;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tg.r;

public class PhpInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Headers headers = request.headers();
        Headers.Builder newBuilder = headers.newBuilder();
        if (!TextUtils.isEmpty(r.x().G())) {
            newBuilder.set("HB-OLD-TOKEN", r.x().G());
        }
        if (!(headers.get("countryType") == null || x.b() == null)) {
            newBuilder.set("countryType", x.b());
        }
        return chain.proceed(request.newBuilder().headers(newBuilder.build()).build());
    }
}

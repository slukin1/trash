package com.huobi.network.interceptor;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.network.uc.core.utils.UcHelper;
import com.huawei.hms.push.AttributionReporter;
import com.tencent.android.tpush.common.Constants;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class SocketHeaderInterceptor implements Interceptor {
    public void a(Headers.Builder builder) {
        String b11 = UcHelper.b(true);
        if (!TextUtils.isEmpty(b11)) {
            builder.set(Constants.FLAG_DEVICE_ID, b11);
        }
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Headers.Builder newBuilder = request.headers().newBuilder();
        newBuilder.set("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        newBuilder.set(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE);
        newBuilder.set(HttpHeaders.UPGRADE, "websocket");
        newBuilder.set("appType", "1");
        newBuilder.set("Content-Type", "application/json;charset=UTF-8");
        newBuilder.set(AttributionReporter.APP_VERSION, String.valueOf(105400));
        newBuilder.set("Huobi-Website", "huobi.pro");
        a(newBuilder);
        return chain.proceed(request.newBuilder().headers(newBuilder.build()).build());
    }
}

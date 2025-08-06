package com.huobi.network.interceptor;

import android.text.TextUtils;
import bh.j;
import com.hbg.lib.common.BaseApplication;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.otc.utils.OtcCountryConfigUtil;
import i6.k;
import i6.l;
import java.io.IOException;
import java.util.UUID;
import ku.b;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tg.r;

public class OtcInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Headers.Builder newBuilder = request.headers().newBuilder();
        if (!TextUtils.isEmpty(r.x().E())) {
            newBuilder.set("token", r.x().E());
        }
        String str = LiteReHelper.a().b() ? "huobi_android_lite" : "huobi_android";
        newBuilder.set("client-type", str);
        newBuilder.set("portal", str);
        newBuilder.set("Content-Type", "application/x-www-form-urlencoded");
        String h11 = b.e().h(BaseApplication.b());
        if (!TextUtils.isEmpty(h11)) {
            newBuilder.set(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, h11);
        }
        newBuilder.set("trace_id", UUID.randomUUID().toString());
        newBuilder.set("otc-language", OtcCountryConfigUtil.b());
        newBuilder.set("vToken", b.e().h(BaseApplication.b()));
        Request build = request.newBuilder().headers(newBuilder.build()).build();
        try {
            return chain.proceed(build);
        } catch (Throwable th2) {
            k.g("OTC-LOG-Interface", "--IP:" + l.d(j.c()) + "--Request:" + build.toString(), th2);
            th2.printStackTrace();
            throw th2;
        }
    }
}

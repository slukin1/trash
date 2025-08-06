package com.huobi.network.interceptor;

import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.m0;
import com.huochat.community.util.EncryptTool;
import java.io.IOException;
import java.util.regex.Pattern;
import ku.b;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tg.r;

public class UcInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public Pattern f78046a = Pattern.compile("uc/open/login[a-z]+");

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Headers.Builder newBuilder = request.headers().newBuilder();
        if (!TextUtils.isEmpty(r.x().I())) {
            String httpUrl = request.url().toString();
            boolean z11 = httpUrl.contains("uc/open/login/") || this.f78046a.matcher(httpUrl).find() || httpUrl.contains("uc/open/login_");
            if (!httpUrl.contains("uc/open/login_register/verify_auth_code") && !httpUrl.contains("uc/open/passkey/login") && !httpUrl.contains("uc/open/2fa/login") && !httpUrl.contains("uc/open/third/login") && (!httpUrl.contains("uc/open/login") || z11)) {
                newBuilder.set("HB-UC-TOKEN", r.x().I());
            }
        }
        newBuilder.set("HUOBI-CLIENT-PLATFORM", "ANDROID");
        newBuilder.set("HUOBI-CLIENT-FINGERPRINT", PhoneUtils.s(true));
        newBuilder.set("HB-UC-UA", EncryptTool.md5(m0.a()));
        newBuilder.set("vToken", b.e().h(BaseApplication.b()));
        return chain.proceed(request.newBuilder().headers(newBuilder.build()).build());
    }
}

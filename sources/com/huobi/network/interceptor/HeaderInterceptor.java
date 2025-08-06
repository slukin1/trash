package com.huobi.network.interceptor;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.core.util.PhoneUtils;
import com.huawei.hms.push.AttributionReporter;
import com.huobi.app.GrayConfigHelper;
import i6.l;
import java.io.IOException;
import ku.b;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import sn.a;
import tg.r;

public class HeaderInterceptor implements Interceptor {
    public final String a() {
        boolean z11;
        Application b11 = BaseApplication.b();
        if (b11 == null) {
            return "0";
        }
        NetworkInfo networkInfo = ((ConnectivityManager) b11.getSystemService("connectivity")).getNetworkInfo(17);
        if (networkInfo == null) {
            z11 = false;
        } else {
            z11 = networkInfo.isConnected();
        }
        if (z11) {
            return "1";
        }
        return "0";
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        Request request = chain.request();
        Headers.Builder newBuilder = request.headers().newBuilder();
        newBuilder.set("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        newBuilder.set("appType", "1");
        newBuilder.set("Huobi-App-Client", "2");
        newBuilder.set("huobi-client-platform", "android");
        newBuilder.set("Huobi-App-Version", "10.54.0");
        newBuilder.set("Huobi-App-Version-Code", String.valueOf(105400));
        newBuilder.set("Content-Type", "application/json;charset=UTF-8");
        newBuilder.set(AttributionReporter.APP_VERSION, String.valueOf(105400));
        newBuilder.set("User-Agent", l.f());
        newBuilder.set("Huobi-TimeZone", DateTimeUtils.o());
        newBuilder.set("terminalId", "1");
        if (GrayConfigHelper.d(request.url().encodedPath(), "api")) {
            newBuilder.set("canary", "always");
        }
        newBuilder.set("vop", a());
        newBuilder.set("DEVICE-V-TOKEN", PhoneUtils.r());
        newBuilder.set("vToken", b.e().h(BaseApplication.b()));
        newBuilder.set("Huobi-Website", "huobi.pro");
        try {
            str = ChannelUtils.a();
        } catch (Exception e11) {
            e11.printStackTrace();
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            newBuilder.set("Huobi-App-Channel", str);
        }
        if (!TextUtils.isEmpty(a.c().a())) {
            newBuilder.set("HB-COUNTRY-ID", a.c().a());
        }
        String b11 = a.c().b();
        if (!TextUtils.isEmpty(b11) && Integer.valueOf(Integer.parseInt(b11)).intValue() > 0) {
            newBuilder.set("HB-REGION-ID", a.c().b());
        }
        String J = r.x().J();
        if (!TextUtils.isEmpty(J)) {
            newBuilder.set("HB-CTX-ID", J);
        }
        return chain.proceed(request.newBuilder().headers(newBuilder.build()).build());
    }
}

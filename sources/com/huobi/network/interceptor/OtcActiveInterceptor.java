package com.huobi.network.interceptor;

import android.text.TextUtils;
import com.huobi.otc.event.OtcActivityEvent;
import com.huobi.otc.event.OtcActivityOrderEvent;
import i6.k;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.greenrobot.eventbus.EventBus;

public class OtcActiveInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url();
        Response proceed = chain.proceed(request.newBuilder().build());
        Headers headers = proceed.headers();
        String str = headers.get("hbgContentUrl");
        String str2 = headers.get("type");
        k.o("OtcActiveInterceptor  hbactive", "intercept: hbgContentUrl:" + str);
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str2, "hbgContent")) {
            k.o("hbactive", "intercept: 发出通知---->" + url);
            if (url.toString().contains("v1/trade/order?")) {
                OtcActivityOrderEvent otcActivityOrderEvent = new OtcActivityOrderEvent();
                otcActivityOrderEvent.setHbgContentUrl(str);
                EventBus.d().k(otcActivityOrderEvent);
            } else {
                OtcActivityEvent otcActivityEvent = new OtcActivityEvent();
                otcActivityEvent.setHbgContentUrl(str);
                EventBus.d().k(otcActivityEvent);
            }
        }
        return proceed;
    }
}

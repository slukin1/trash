package com.huobi.network.interceptor;

import android.text.TextUtils;
import com.hbg.module.huobi.im.group.bean.OberverData;
import com.hbg.module.huobi.im.observer.ActiveObserverHelper;
import i6.k;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Response;

public class ActiveInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f78034a;

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request().newBuilder().build());
        Headers headers = proceed.headers();
        String str = headers.get("hbgContentUrl");
        String str2 = headers.get("type");
        k.o("ActiveInterceptor  hbactive", "intercept: hbgContentUrl:" + str);
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str2, "hbgContent")) {
            if (this.f78034a == null) {
                this.f78034a = new HashMap();
            }
            this.f78034a.clear();
            this.f78034a.put("hbgContentUrl", str);
            k.o("hbactive", "intercept: 发出通知");
            ActiveObserverHelper.b().a(new OberverData(1, this.f78034a));
        }
        return proceed;
    }
}

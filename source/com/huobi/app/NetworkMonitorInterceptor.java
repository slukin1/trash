package com.huobi.app;

import bh.j;
import gs.g;
import i6.l;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Interceptor;
import okhttp3.Response;

public class NetworkMonitorInterceptor implements Interceptor {
    public static void a(String str, long j11, int i11, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("api", str);
        hashMap.put("durtion", Long.valueOf(System.currentTimeMillis() - j11));
        hashMap.put("code", Integer.valueOf(i11));
        hashMap.put("errorMsg", str2);
        hashMap.put("network_dns", l.c(j.c().getApplicationContext()));
        g.i("network_monitor", hashMap);
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        Response proceed = chain.proceed(chain.request());
        String encodedPath = chain.request().url().encodedPath();
        if (NetworkMonitorManager.a().c(encodedPath)) {
            a(encodedPath, currentTimeMillis, proceed.code(), proceed.message());
        }
        return proceed;
    }
}

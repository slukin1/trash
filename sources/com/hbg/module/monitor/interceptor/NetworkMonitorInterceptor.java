package com.hbg.module.monitor.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import rf.a;

public final class NetworkMonitorInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        a aVar = a.f29190a;
        if (aVar.c().isStart()) {
            String encodedPath = request.url().encodedPath();
            if (aVar.c().isAll()) {
                if (!aVar.c().ignoreList().contains(encodedPath)) {
                    a.a(encodedPath, proceed.isSuccessful());
                }
            } else if (aVar.c().apiList().contains(encodedPath)) {
                a.a(encodedPath, proceed.isSuccessful());
            }
        }
        return proceed;
    }
}

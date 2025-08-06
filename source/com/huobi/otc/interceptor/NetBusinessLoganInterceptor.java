package com.huobi.otc.interceptor;

import java.io.IOException;
import np.a;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetBusinessLoganInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        try {
            if (a.f().l(request.url().encodedPath())) {
                a.f().o(request, proceed, String.valueOf(System.currentTimeMillis()));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return proceed;
    }
}

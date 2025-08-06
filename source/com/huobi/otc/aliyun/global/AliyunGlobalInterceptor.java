package com.huobi.otc.aliyun.global;

import i6.k;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AliyunGlobalInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        try {
            return chain.proceed(request);
        } catch (Exception e11) {
            k.c("接口请求异常:" + e11.getMessage() + " --Request:" + request);
            throw e11;
        }
    }
}

package com.huobi.domain;

import android.net.Uri;
import android.text.TextUtils;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http2.StreamResetException;

public class DomainTestInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response;
        Request request = chain.request();
        try {
            if (Boolean.parseBoolean(request.headers().get("isRemoveCommonHeaders"))) {
                return chain.proceed(request.newBuilder().headers(new Headers.Builder().build()).build());
            }
            response = chain.proceed(request);
            if (response != null) {
                return response;
            }
            return chain.proceed(request);
        } catch (Exception e11) {
            int i11 = 1;
            if (DomainSwitcher.A().V() != null) {
                i11 = DomainSwitcher.A().V().request_again;
            }
            if (i11 != 0) {
                try {
                    if ((e11 instanceof SocketTimeoutException) || (e11 instanceof SocketException) || (e11 instanceof SSLException) || (e11 instanceof UnknownHostException) || (e11 instanceof StreamResetException)) {
                        LogAndWoodRecorder.a("DOMAIN_TEST", "接口为指定异常：自动切换域名重试");
                        LogAndWoodRecorder.a("DOMAIN_TEST", "切换前：" + request.url());
                        String host = request.url().host();
                        String host2 = Uri.parse(DomainSwitcher.A().q(request.url().url().toString())).getHost();
                        if (!TextUtils.equals(host, host2)) {
                            Response proceed = chain.proceed(request.newBuilder().url(request.url().newBuilder().host(host2).build()).build());
                            LogAndWoodRecorder.a("DOMAIN_TEST", "自动切换域名重试成功");
                            return proceed;
                        }
                    }
                } catch (Exception e12) {
                    LogAndWoodRecorder.a("DOMAIN_TEST", "切换域名重试失败：" + request.url() + Constants.ACCEPT_TIME_SEPARATOR_SP + e12.getMessage());
                }
            } else if ((e11 instanceof SocketTimeoutException) || (e11 instanceof SocketException) || (e11 instanceof SSLException)) {
                LogAndWoodRecorder.a("DOMAIN_TEST", "接口为指定异常：" + e11.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SP + e11.getMessage() + ":" + request.url());
                DomainSwitcher.A().p(request.url().url().toString());
            } else if (e11 instanceof UnknownHostException) {
                DomainSwitcher.A().q(request.url().url().toString());
            } else {
                throw e11;
            }
            response = null;
        }
    }
}

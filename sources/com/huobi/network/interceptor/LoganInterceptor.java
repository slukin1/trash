package com.huobi.network.interceptor;

import android.text.TextUtils;
import com.hbg.lib.network.retrofit.response.IResponse;
import com.iproov.sdk.bridge.OptionsBridge;
import i6.d;
import i6.k;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import tg.r;

public abstract class LoganInterceptor implements Interceptor {

    public abstract class ResponseError implements IResponse {
        public ResponseError() {
        }

        public abstract String getErrCode();

        public abstract String getErrMsg();
    }

    public abstract ResponseError a(String str, String str2);

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Charset charset;
        boolean z11;
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        if (proceed == null) {
            return proceed;
        }
        if (!proceed.isSuccessful()) {
            k.c("[Login Status]" + r.x().F0());
            k.c(request.toString() + proceed.toString());
            return proceed;
        }
        ResponseBody body = proceed.body();
        if (body == null) {
            return proceed;
        }
        body.source().request(Long.MAX_VALUE);
        Buffer clone = body.source().buffer().clone();
        if (body.contentType() != null) {
            charset = body.contentType().charset(Charset.forName("UTF-8"));
        } else {
            charset = Charset.forName("UTF-8");
        }
        String readString = clone.readString(charset);
        try {
            ResponseError a11 = a(request.url().host(), readString);
            if (!TextUtils.isEmpty(a11.getErrMsg())) {
                if (!OptionsBridge.NULL_VALUE.equals(a11.getErrMsg())) {
                    z11 = false;
                    if (!a11.isSuccess() && !z11) {
                        k.c(request.url().toString() + readString);
                        d.b(request.url().toString() + readString);
                    }
                    return proceed;
                }
            }
            z11 = true;
            k.c(request.url().toString() + readString);
            d.b(request.url().toString() + readString);
        } catch (Exception unused) {
            d.b(request.url().toString() + readString);
        }
        return proceed;
    }
}

package com.hbg.lib.common.network.interceptor;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import i6.d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LogginInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public SimpleDateFormat f67470a = new SimpleDateFormat("HH:mm:ss");

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r3 = r0.indexOf("?");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(okhttp3.Request r3) {
        /*
            r2 = this;
            okhttp3.HttpUrl r0 = r3.url()
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = r3.method()
            java.lang.String r1 = "Get"
            boolean r3 = r3.equalsIgnoreCase(r1)
            if (r3 == 0) goto L_0x0021
            java.lang.String r3 = "?"
            int r3 = r0.indexOf(r3)
            if (r3 <= 0) goto L_0x0021
            r1 = 0
            java.lang.String r0 = r0.substring(r1, r3)
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.network.interceptor.LogginInterceptor.a(okhttp3.Request):java.lang.String");
    }

    public final StringBuilder b(Request request) {
        int indexOf;
        StringBuilder sb2 = new StringBuilder("Request \n");
        sb2.append(String.format("\t Method: %s\n", new Object[]{request.method()}));
        sb2.append(String.format("\t Time: %s \n", new Object[]{this.f67470a.format(new Date(System.currentTimeMillis()))}));
        if (!(request.body() == null || request.body().contentType() == null)) {
            sb2.append(String.format("\t Content-Type: %s \n", new Object[]{request.body().contentType().toString()}));
        }
        String httpUrl = request.url().toString();
        String str = null;
        if (request.method().equalsIgnoreCase("Get") && (indexOf = httpUrl.indexOf("?")) > 0) {
            str = httpUrl.substring(indexOf + 1);
        }
        sb2.append(String.format("\t Request: %s \n", new Object[]{a(request)}));
        if (!TextUtils.isEmpty(str)) {
            sb2.append("\t Params:\n");
            for (String split : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split2 = split.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length == 2) {
                    try {
                        sb2.append(String.format("\t\t %s: %s \n", new Object[]{split2[0], URLDecoder.decode(split2[1], "UTF-8")}));
                    } catch (UnsupportedEncodingException e11) {
                        d.g(e11);
                    }
                }
            }
        }
        if (request.headers().size() > 0) {
            sb2.append("\t Headers: \n");
            for (String next : request.headers().names()) {
                sb2.append(String.format("\t\t %s: %s \n", new Object[]{next, request.header(next)}));
            }
        }
        if (request.body() != null && (request.body() instanceof FormBody)) {
            sb2.append("\t Params: \n");
            FormBody formBody = (FormBody) request.body();
            for (int i11 = 0; i11 < formBody.size(); i11++) {
                sb2.append(String.format("\t\t %s: %s \n", new Object[]{formBody.name(i11), formBody.value(i11)}));
            }
        }
        return sb2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (d.k()) {
            b(request);
        }
        return chain.proceed(request);
    }
}

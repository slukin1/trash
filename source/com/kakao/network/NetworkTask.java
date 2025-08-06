package com.kakao.network;

import com.google.common.net.HttpHeaders;
import com.kakao.util.helper.log.a;
import java.io.IOException;
import java.util.Map;
import uw.d;
import uw.e;
import ww.b;

public class NetworkTask {

    /* renamed from: a  reason: collision with root package name */
    public final d f25059a = new KakaoNetworkImpl();

    public b a(e eVar) throws IOException {
        try {
            this.f25059a.f(eVar.getUrl(), eVar.a(), eVar.b());
            Map<String, String> headers = eVar.getHeaders();
            a.a(headers.toString());
            for (String next : headers.keySet()) {
                if (!next.equalsIgnoreCase(HttpHeaders.EXPECT)) {
                    this.f25059a.a(next, headers.get(next));
                } else {
                    throw new IllegalStateException("Expect: 100-Continue not supported");
                }
            }
            Map<String, String> params = eVar.getParams();
            for (String next2 : params.keySet()) {
                this.f25059a.b(next2, params.get(next2));
            }
            for (vw.b c11 : eVar.c()) {
                this.f25059a.c(c11);
            }
            this.f25059a.e();
            this.f25059a.connect();
            int statusCode = this.f25059a.getStatusCode();
            a.b("++ httpStatus : [%s]", Integer.valueOf(statusCode));
            return new b(statusCode, this.f25059a.d());
        } finally {
            this.f25059a.disconnect();
        }
    }
}

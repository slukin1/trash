package com.huobi.network.interceptor;

import com.google.gson.Gson;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.etf.entity.EtfToken;
import com.huobi.etf.utils.EtfDataSource;
import com.huobi.network.interceptor.BaseTokenErrorCheckInterceptor;
import i6.d;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import mo.b;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rx.Subscription;
import tg.r;

public class EtfErrorCheckInterceptor extends BaseTokenErrorCheckInterceptor {

    /* renamed from: d  reason: collision with root package name */
    public static final EtfErrorCheckInterceptor f78039d = new EtfErrorCheckInterceptor();

    /* renamed from: c  reason: collision with root package name */
    public Subscription f78040c;

    public static class EtfErrorHandleResponse extends BaseTokenErrorCheckInterceptor.BaseTokenErrorHandleResponse {
        private int code;
        private String message;

        public int getCode() {
            return this.code;
        }

        public String getErrCode() {
            return String.valueOf(this.code);
        }

        public String getErrMsg() {
            return this.message;
        }

        public String getMessage() {
            return this.message;
        }

        public String getStatus() {
            return "";
        }

        public boolean isSuccess() {
            return this.code == 200;
        }

        public boolean isTokenError() {
            int i11 = this.code;
            return i11 == 511 || i11 == 512;
        }

        public void setCode(int i11) {
            this.code = i11;
        }

        public void setMessage(String str) {
            this.message = str;
        }
    }

    public class a extends EasySubscriber<EtfToken> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseTokenErrorCheckInterceptor.BaseTokenWrapper f78041b;

        public a(BaseTokenErrorCheckInterceptor.BaseTokenWrapper baseTokenWrapper) {
            this.f78041b = baseTokenWrapper;
        }

        /* renamed from: a */
        public void onNext(EtfToken etfToken) {
            super.onNext(etfToken);
            if (etfToken != null) {
                this.f78041b.d(etfToken.getToken());
                r.x().n0(etfToken.getToken());
                return;
            }
            this.f78041b.c(0);
        }

        public void onError2(Throwable th2) {
            String c11 = EtfErrorCheckInterceptor.this.c();
            d.c(c11, "getEtfToken e = " + th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String c11 = EtfErrorCheckInterceptor.this.c();
            d.c(c11, "getEtfToken APIStatusErrorException = " + aPIStatusErrorException);
        }
    }

    public static EtfErrorCheckInterceptor q() {
        return f78039d;
    }

    public static /* synthetic */ EtfToken r(Throwable th2) {
        return null;
    }

    public void a() {
        r.x().n0((String) null);
    }

    public Response b(Interceptor.Chain chain, Response response, String str, int i11) throws IOException {
        Request build = chain.request().newBuilder().header("token", str).build();
        if (!(response == null || response.body() == null)) {
            response.body().close();
        }
        return chain.proceed(build);
    }

    public String c() {
        return "OtcErrorCheckInterceptor";
    }

    public String d() {
        return r.x().v();
    }

    public int g(BaseTokenErrorCheckInterceptor.BaseTokenErrorHandleResponse baseTokenErrorHandleResponse) {
        if (baseTokenErrorHandleResponse == null || baseTokenErrorHandleResponse.isSuccess()) {
            return 0;
        }
        if (String.valueOf(512).equals(baseTokenErrorHandleResponse.getErrCode()) || String.valueOf(511).equals(baseTokenErrorHandleResponse.getErrCode())) {
            return 1;
        }
        return 0;
    }

    public BaseTokenErrorCheckInterceptor.BaseTokenErrorHandleResponse j(String str, String str2) {
        return (EtfErrorHandleResponse) new Gson().fromJson(str2, EtfErrorHandleResponse.class);
    }

    public BaseTokenErrorCheckInterceptor.BaseTokenWrapper k(int i11) {
        return p();
    }

    public BaseTokenErrorCheckInterceptor.BaseTokenErrorHandleResponse n(Response response, int i11) throws IOException {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        body.source().request(Long.MAX_VALUE);
        return (EtfErrorHandleResponse) new Gson().fromJson(body.source().buffer().clone().readString(body.contentType() != null ? body.contentType().charset(StandardCharsets.UTF_8) : StandardCharsets.UTF_8), EtfErrorHandleResponse.class);
    }

    public BaseTokenErrorCheckInterceptor.BaseTokenWrapper p() {
        Subscription subscription = this.f78040c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        BaseTokenErrorCheckInterceptor.BaseTokenWrapper baseTokenWrapper = new BaseTokenErrorCheckInterceptor.BaseTokenWrapper();
        this.f78040c = EtfDataSource.b().timeout(4000, TimeUnit.MILLISECONDS).onErrorReturn(b.f58248b).subscribe(new a(baseTokenWrapper));
        return baseTokenWrapper;
    }
}

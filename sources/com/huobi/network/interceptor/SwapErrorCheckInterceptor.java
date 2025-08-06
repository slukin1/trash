package com.huobi.network.interceptor;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.contract.helper.ContractDataSource;
import com.huobi.network.interceptor.BaseTokenErrorCheckInterceptor;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rx.Subscription;
import tg.r;

public class SwapErrorCheckInterceptor extends BaseTokenErrorCheckInterceptor {

    /* renamed from: c  reason: collision with root package name */
    public Subscription f78043c;

    public static class SwapErrorHandleResponse extends BaseTokenErrorCheckInterceptor.BaseTokenErrorHandleResponse {
        @SerializedName("err_code")
        private int errCode;
        @SerializedName("err_msg")
        private String errMsg;
        private String status;

        public String getErrCode() {
            return String.valueOf(this.errCode);
        }

        public String getErrMsg() {
            return this.errMsg;
        }

        public String getStatus() {
            return this.status;
        }

        public boolean isSuccess() {
            return "OK".equalsIgnoreCase(this.status);
        }

        public boolean isTokenError() {
            int i11 = this.errCode;
            return i11 == 1029 || i11 == 1011;
        }
    }

    public class a extends EasySubscriber<String[]> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseTokenErrorCheckInterceptor.BaseTokenWrapper f78044b;

        public a(BaseTokenErrorCheckInterceptor.BaseTokenWrapper baseTokenWrapper) {
            this.f78044b = baseTokenWrapper;
        }

        /* renamed from: a */
        public void onNext(String[] strArr) {
            super.onNext(strArr);
            if (strArr == null) {
                this.f78044b.c(-1);
            } else if (!TextUtils.isEmpty(strArr[0])) {
                this.f78044b.d(strArr[0]);
                r.x().k0(strArr[0]);
            } else if (!TextUtils.isEmpty(strArr[1])) {
                this.f78044b.c(1);
            } else {
                this.f78044b.c(0);
            }
        }

        public void onError2(Throwable th2) {
            SwapErrorCheckInterceptor swapErrorCheckInterceptor = SwapErrorCheckInterceptor.this;
            swapErrorCheckInterceptor.i("getContractToken error = " + th2);
            this.f78044b.c(1);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            SwapErrorCheckInterceptor swapErrorCheckInterceptor = SwapErrorCheckInterceptor.this;
            swapErrorCheckInterceptor.i("getContractToken APIStatusErrorException error = " + aPIStatusErrorException);
            this.f78044b.c(1);
        }
    }

    public void a() {
        r.x().k0((String) null);
    }

    public Response b(Interceptor.Chain chain, Response response, String str, int i11) throws IOException {
        Request build = chain.request().newBuilder().header("hbsession", str).build();
        if (!(response == null || response.body() == null)) {
            response.body().close();
        }
        return chain.proceed(build);
    }

    public String c() {
        return "SwapErrorCheckInterceptor";
    }

    public String d() {
        return r.x().q();
    }

    public int g(BaseTokenErrorCheckInterceptor.BaseTokenErrorHandleResponse baseTokenErrorHandleResponse) {
        if (baseTokenErrorHandleResponse == null || baseTokenErrorHandleResponse.isSuccess() || !baseTokenErrorHandleResponse.isTokenError()) {
            return 0;
        }
        return 1;
    }

    public BaseTokenErrorCheckInterceptor.BaseTokenErrorHandleResponse j(String str, String str2) {
        return (SwapErrorHandleResponse) new Gson().fromJson(str2, SwapErrorHandleResponse.class);
    }

    public BaseTokenErrorCheckInterceptor.BaseTokenWrapper k(int i11) {
        return o();
    }

    public BaseTokenErrorCheckInterceptor.BaseTokenErrorHandleResponse n(Response response, int i11) throws IOException {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        body.source().request(Long.MAX_VALUE);
        return (SwapErrorHandleResponse) new Gson().fromJson(body.source().buffer().clone().readString(body.contentType() != null ? body.contentType().charset(StandardCharsets.UTF_8) : StandardCharsets.UTF_8), SwapErrorHandleResponse.class);
    }

    public BaseTokenErrorCheckInterceptor.BaseTokenWrapper o() {
        Subscription subscription = this.f78043c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        BaseTokenErrorCheckInterceptor.BaseTokenWrapper baseTokenWrapper = new BaseTokenErrorCheckInterceptor.BaseTokenWrapper();
        this.f78043c = ContractDataSource.f("SwapErrorCheckInterceptor").subscribe(new a(baseTokenWrapper));
        return baseTokenWrapper;
    }
}

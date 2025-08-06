package com.hbg.lib.network.pro.retrofit;

import a9.f;
import a9.g;
import c9.b;
import com.hbg.lib.network.pro.core.response.IntCodeResponse;
import com.hbg.lib.network.pro.core.response.StringStatusResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

public class ProRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static ProRetrofit f70627a = new ProRetrofit();
    }

    public static ProRetrofit g() {
        return a.f70627a;
    }

    public static <T> Observable.Transformer<IntCodeResponse<T>, T> h() {
        return f.f3503b;
    }

    public static /* synthetic */ void i(IntCodeResponse intCodeResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (intCodeResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (intCodeResponse.isSuccess()) {
            subscriber.onNext(intCodeResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(String.valueOf(intCodeResponse.getCode()), intCodeResponse.getMessage()));
        }
    }

    public static /* synthetic */ void l(StringStatusResponse stringStatusResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (stringStatusResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (stringStatusResponse.isSuccess()) {
            subscriber.onNext(stringStatusResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(stringStatusResponse.getErrCode(), stringStatusResponse.getErrMsg()));
        }
    }

    public static <T> Observable.Transformer<StringStatusResponse<T>, T> o() {
        return g.f3504b;
    }

    public static <T> T request(Class<T> cls) {
        return g().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}

package com.hbg.lib.network.etf.retrofit;

import c9.b;
import com.hbg.lib.network.pro.core.response.IntCodeResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

public class EtfRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static EtfRetrofit f70205a = new EtfRetrofit();
    }

    public static <T> Observable.Transformer<IntCodeResponse<T>, T> d() {
        return u7.b.f60546b;
    }

    public static EtfRetrofit e() {
        return a.f70205a;
    }

    public static /* synthetic */ void f(IntCodeResponse intCodeResponse, Subscriber subscriber) {
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

    public static <T> T request(Class<T> cls) {
        return e().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}

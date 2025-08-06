package com.hbg.lib.network.hbg.retrofit;

import a8.e;
import c9.b;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

public class HbgRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static HbgRetrofit f70295a = new HbgRetrofit();
    }

    public static HbgRetrofit d() {
        return a.f70295a;
    }

    public static <T> Observable.Transformer<HbgIntCodeResponse<T>, T> e() {
        return e.f3496b;
    }

    public static /* synthetic */ void f(HbgIntCodeResponse hbgIntCodeResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (hbgIntCodeResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (hbgIntCodeResponse.isSuccess()) {
            subscriber.onNext(hbgIntCodeResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(String.valueOf(hbgIntCodeResponse.getCode()), hbgIntCodeResponse.getMessage()));
        }
    }

    public static <T> T request(Class<T> cls) {
        return d().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}

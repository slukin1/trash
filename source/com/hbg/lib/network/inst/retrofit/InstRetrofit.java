package com.hbg.lib.network.inst.retrofit;

import c9.b;
import com.hbg.lib.network.inst.response.InstCodeResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import g8.c;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

public class InstRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final InstRetrofit f70314a = new InstRetrofit();
    }

    public static InstRetrofit d() {
        return a.f70314a;
    }

    public static <T> Observable.Transformer<InstCodeResponse<T>, T> e() {
        return c.f54792b;
    }

    public static /* synthetic */ void f(InstCodeResponse instCodeResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (instCodeResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (instCodeResponse.isSuccess()) {
            subscriber.onNext(instCodeResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(String.valueOf(instCodeResponse.getCode()), instCodeResponse.getMessage()));
        }
    }

    public static <T> T request(Class<T> cls) {
        return d().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}

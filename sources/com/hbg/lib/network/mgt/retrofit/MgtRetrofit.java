package com.hbg.lib.network.mgt.retrofit;

import c9.b;
import com.hbg.lib.network.mgt.core.response.UcIntCodeResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

public class MgtRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static MgtRetrofit f68872a = new MgtRetrofit();
    }

    public static MgtRetrofit d() {
        return a.f68872a;
    }

    public static /* synthetic */ void e(UcIntCodeResponse ucIntCodeResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (ucIntCodeResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (ucIntCodeResponse.d()) {
            subscriber.onNext(ucIntCodeResponse.b());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(String.valueOf(ucIntCodeResponse.a()), ucIntCodeResponse.c()));
        }
    }

    public static <T> Observable.Transformer<UcIntCodeResponse<T>, T> h() {
        return m8.b.f58119b;
    }

    public static <T> T request(Class<T> cls) {
        return d().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}

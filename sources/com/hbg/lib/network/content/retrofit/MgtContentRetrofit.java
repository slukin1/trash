package com.hbg.lib.network.content.retrofit;

import c9.b;
import com.hbg.lib.network.content.response.MgtContentCodeResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

public class MgtContentRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static MgtContentRetrofit f69208a = new MgtContentRetrofit();
    }

    public static MgtContentRetrofit d() {
        return a.f69208a;
    }

    public static /* synthetic */ void e(MgtContentCodeResponse mgtContentCodeResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (mgtContentCodeResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (mgtContentCodeResponse.isSuccess()) {
            subscriber.onNext(mgtContentCodeResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(String.valueOf(mgtContentCodeResponse.getCode()), mgtContentCodeResponse.getMessage()));
        }
    }

    public static <T> Observable.Transformer<MgtContentCodeResponse<T>, T> h() {
        return p7.b.f52996b;
    }

    public static <T> T request(Class<T> cls) {
        return d().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}

package com.hbg.lib.network.newkyc.retrofit;

import c9.b;
import com.hbg.lib.network.newkyc.response.NewKycCodeResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import o8.c;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

public class NewKycRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static NewKycRetrofit f68878a = new NewKycRetrofit();
    }

    public static NewKycRetrofit d() {
        return a.f68878a;
    }

    public static /* synthetic */ void e(NewKycCodeResponse newKycCodeResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (newKycCodeResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (newKycCodeResponse.isSuccess()) {
            subscriber.onNext(newKycCodeResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(String.valueOf(newKycCodeResponse.getCode()), newKycCodeResponse.getMessage()));
        }
    }

    public static <T> Observable.Transformer<NewKycCodeResponse<T>, T> h() {
        return c.f58803b;
    }

    public static <T> T request(Class<T> cls) {
        return d().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}

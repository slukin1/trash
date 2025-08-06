package com.hbg.lib.network.option.retrofit;

import c9.b;
import com.hbg.lib.network.option.response.OptionStatusResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

public class OptionRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static OptionRetrofit f69264a = new OptionRetrofit();
    }

    public static OptionRetrofit d() {
        return a.f69264a;
    }

    public static /* synthetic */ void e(OptionStatusResponse optionStatusResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (optionStatusResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (optionStatusResponse.isSuccess()) {
            subscriber.onNext(optionStatusResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(optionStatusResponse.getErrCode(), optionStatusResponse.getErrMsg()));
        }
    }

    public static <T> Observable.Transformer<OptionStatusResponse<T>, T> h() {
        return r8.b.f70521b;
    }

    public static <T> T request(Class<T> cls) {
        return d().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}

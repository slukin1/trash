package com.hbg.lib.network.swap.retrofit;

import c9.b;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import com.hbg.lib.network.swap.core.response.SwapStatusResponse;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

public class SwapRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static SwapRetrofit f70772a = new SwapRetrofit();
    }

    public static SwapRetrofit d() {
        return a.f70772a;
    }

    public static /* synthetic */ void e(SwapStatusResponse swapStatusResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (swapStatusResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (swapStatusResponse.isSuccess()) {
            subscriber.onNext(swapStatusResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(swapStatusResponse.getErrCode(), swapStatusResponse.getErrMsg()));
        }
    }

    public static <T> Observable.Transformer<SwapStatusResponse<T>, T> h() {
        return n9.b.f58311b;
    }

    public static <T> T request(Class<T> cls) {
        return d().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}

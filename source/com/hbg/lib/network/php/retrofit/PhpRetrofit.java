package com.hbg.lib.network.php.retrofit;

import c9.b;
import com.hbg.lib.network.php.core.response.IntStatusResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

public class PhpRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static PhpRetrofit f70604a = new PhpRetrofit();
    }

    public static PhpRetrofit d() {
        return a.f70604a;
    }

    public static <T> Observable.Transformer<IntStatusResponse<T>, T> e() {
        return w8.b.f61229b;
    }

    public static /* synthetic */ void f(IntStatusResponse intStatusResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (intStatusResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (intStatusResponse.isSuccess()) {
            subscriber.onNext(intStatusResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(intStatusResponse.getStatus() + "", intStatusResponse.getMessage()));
        }
    }

    public static <T> T request(Class<T> cls) {
        return d().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}

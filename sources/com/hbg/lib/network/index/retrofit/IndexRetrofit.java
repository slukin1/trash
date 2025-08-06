package com.hbg.lib.network.index.retrofit;

import c9.b;
import com.hbg.lib.network.index.core.IndexStatusResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

public class IndexRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static IndexRetrofit f70308a = new IndexRetrofit();
    }

    public static IndexRetrofit d() {
        return a.f70308a;
    }

    public static /* synthetic */ void e(IndexStatusResponse indexStatusResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (indexStatusResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (indexStatusResponse.isSuccess()) {
            subscriber.onNext(indexStatusResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(indexStatusResponse.getErrCode(), indexStatusResponse.getErrMsg()));
        }
    }

    public static <T> Observable.Transformer<IndexStatusResponse<T>, T> h() {
        return d8.b.f53546b;
    }

    public static <T> T request(Class<T> cls) {
        return d().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}

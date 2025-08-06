package com.hbg.lib.network.uc.retrofit;

import android.content.Context;
import c9.b;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import com.hbg.lib.network.uc.core.response.UcIntCodeResponse;
import q9.c;
import rx.Observable;
import rx.Subscriber;

public class UcRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static UcRetrofit f70780a = new UcRetrofit();
    }

    public static UcRetrofit d() {
        return a.f70780a;
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
        return c.f53313b;
    }

    public static <T> T request(Class<T> cls) {
        return d().doRequest(cls);
    }

    public void init(String str, Context context, b bVar) {
        super.init(str, context, bVar);
    }
}

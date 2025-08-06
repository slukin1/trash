package com.hbg.lib.network.otc.retrofit;

import c9.b;
import com.hbg.lib.network.otc.core.OTCPageListExtendResponse;
import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;
import u8.e;
import u8.f;

public class OtcRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static OtcRetrofit f70600a = new OtcRetrofit();
    }

    public static OtcRetrofit g() {
        return a.f70600a;
    }

    public static /* synthetic */ void h(OTCPageListExtendResponse oTCPageListExtendResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (oTCPageListExtendResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (oTCPageListExtendResponse.isSuccess()) {
            subscriber.onNext(oTCPageListExtendResponse);
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(oTCPageListExtendResponse.getErrCode(), oTCPageListExtendResponse.getErrMsg()));
        }
    }

    public static /* synthetic */ void k(OTCStatusResponse oTCStatusResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (oTCStatusResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (oTCStatusResponse.isSuccess()) {
            subscriber.onNext(oTCStatusResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(oTCStatusResponse.getErrCode(), oTCStatusResponse.getErrMsg()));
        }
    }

    public static <T, R> Observable.Transformer<OTCPageListExtendResponse<T, R>, OTCPageListExtendResponse<T, R>> n() {
        return e.f60552b;
    }

    public static <T> Observable.Transformer<OTCStatusResponse<T>, T> o() {
        return f.f60553b;
    }

    public static <T> T request(Class<T> cls) {
        return g().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}

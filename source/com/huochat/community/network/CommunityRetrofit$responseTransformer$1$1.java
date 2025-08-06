package com.huochat.community.network;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import com.huochat.community.model.CommonNetResponse;
import d10.l;
import kotlin.jvm.internal.Lambda;
import rx.Observable;
import rx.Subscriber;

public final class CommunityRetrofit$responseTransformer$1$1 extends Lambda implements l<CommonNetResponse<T>, Observable<? extends T>> {
    public static final CommunityRetrofit$responseTransformer$1$1 INSTANCE = new CommunityRetrofit$responseTransformer$1$1();

    public CommunityRetrofit$responseTransformer$1$1() {
        super(1);
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CommonNetResponse commonNetResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (commonNetResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (commonNetResponse.isSuccess()) {
            subscriber.onNext(commonNetResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(String.valueOf(commonNetResponse.getCode()), commonNetResponse.getMessage()));
        }
    }

    public final Observable<? extends T> invoke(CommonNetResponse<T> commonNetResponse) {
        return Observable.create(new d(commonNetResponse));
    }
}

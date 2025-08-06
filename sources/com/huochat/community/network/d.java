package com.huochat.community.network;

import com.huochat.community.model.CommonNetResponse;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class d implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonNetResponse f38703b;

    public /* synthetic */ d(CommonNetResponse commonNetResponse) {
        this.f38703b = commonNetResponse;
    }

    public final void call(Object obj) {
        CommunityRetrofit$responseTransformer$1$1.invoke$lambda$0(this.f38703b, (Subscriber) obj);
    }
}

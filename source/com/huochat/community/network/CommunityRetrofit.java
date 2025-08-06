package com.huochat.community.network;

import c9.a;
import c9.b;
import com.huochat.community.model.CommonNetResponse;
import d10.l;
import rx.Observable;

public final class CommunityRetrofit extends a<b> {
    public static final CommunityRetrofit INSTANCE = new CommunityRetrofit();

    private CommunityRetrofit() {
    }

    /* access modifiers changed from: private */
    public static final Observable responseTransformer$lambda$1(Observable observable) {
        return observable.flatMap(new c(CommunityRetrofit$responseTransformer$1$1.INSTANCE));
    }

    /* access modifiers changed from: private */
    public static final Observable responseTransformer$lambda$1$lambda$0(l lVar, Object obj) {
        return (Observable) lVar.invoke(obj);
    }

    public final <T> T request(Class<T> cls) {
        return doRequest(cls);
    }

    public final <T> Observable.Transformer<CommonNetResponse<T>, T> responseTransformer() {
        return b.f38701b;
    }
}

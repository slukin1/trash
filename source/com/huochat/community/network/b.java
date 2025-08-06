package com.huochat.community.network;

import rx.Observable;

public final /* synthetic */ class b implements Observable.Transformer {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ b f38701b = new b();

    public final Object call(Object obj) {
        return CommunityRetrofit.responseTransformer$lambda$1((Observable) obj);
    }
}

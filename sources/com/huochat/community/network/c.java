package com.huochat.community.network;

import d10.l;
import rx.functions.Func1;

public final /* synthetic */ class c implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f38702b;

    public /* synthetic */ c(l lVar) {
        this.f38702b = lVar;
    }

    public final Object call(Object obj) {
        return CommunityRetrofit.responseTransformer$lambda$1$lambda$0(this.f38702b, obj);
    }
}

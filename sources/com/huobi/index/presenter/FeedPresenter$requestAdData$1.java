package com.huobi.index.presenter;

import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class FeedPresenter$requestAdData$1 extends Lambda implements p<Integer, Integer, Unit> {
    public final /* synthetic */ FeedPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedPresenter$requestAdData$1(FeedPresenter feedPresenter) {
        super(2);
        this.this$0 = feedPresenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
        return Unit.f56620a;
    }

    public final void invoke(int i11, int i12) {
        if (i11 == 0) {
            this.this$0.f0().f73307i = i12;
            this.this$0.d0().h(this.this$0.f0());
        }
    }
}

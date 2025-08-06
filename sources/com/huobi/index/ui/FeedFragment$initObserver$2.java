package com.huobi.index.ui;

import com.huobi.index.helper.data.NewFeedModule;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class FeedFragment$initObserver$2 extends Lambda implements l<NewFeedModule, Unit> {
    public final /* synthetic */ FeedFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedFragment$initObserver$2(FeedFragment feedFragment) {
        super(1);
        this.this$0 = feedFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NewFeedModule) obj);
        return Unit.f56620a;
    }

    public final void invoke(NewFeedModule newFeedModule) {
        this.this$0.di(newFeedModule.q(), newFeedModule.f73308j, newFeedModule.f73307i, newFeedModule.f73314p);
    }
}

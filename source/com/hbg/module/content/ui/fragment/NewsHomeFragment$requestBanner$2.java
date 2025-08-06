package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsHomeFragment$requestBanner$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ NewsHomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsHomeFragment$requestBanner$2(NewsHomeFragment newsHomeFragment) {
        super(2);
        this.this$0 = newsHomeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        NewsHomeFragment.Vh(this.this$0).B.getLayoutParams().height = 0;
        NewsHomeFragment.Vh(this.this$0).C.getRoot().setVisibility(8);
        NewsHomeFragment.Vh(this.this$0).B.requestLayout();
        NewsHomeFragment.Vh(this.this$0).G.finishRefresh();
    }
}

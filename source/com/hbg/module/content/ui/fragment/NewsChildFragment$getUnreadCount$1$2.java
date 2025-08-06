package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsChildFragment$getUnreadCount$1$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ NewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsChildFragment$getUnreadCount$1$2(NewsChildFragment newsChildFragment) {
        super(2);
        this.this$0 = newsChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException != null) {
            NewsChildFragment newsChildFragment = this.this$0;
            newsChildFragment.sh();
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
            NewsChildFragment.Zh(newsChildFragment).G.setVisibility(8);
            newsChildFragment.Fi(0);
        }
    }
}

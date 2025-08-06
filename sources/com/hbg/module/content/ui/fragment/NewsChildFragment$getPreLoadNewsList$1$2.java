package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.b;
import d10.p;
import i6.d;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class NewsChildFragment$getPreLoadNewsList$1$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ NewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsChildFragment$getPreLoadNewsList$1$2(NewsChildFragment newsChildFragment) {
        super(2);
        this.this$0 = newsChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        this.this$0.Ji(false);
        d.c("ray01", "2 getPreLoadNewsList error " + this.this$0.oi());
        if (!b.x(this.this$0.ni())) {
            NewsChildFragment.Zh(this.this$0).E.y(0, true, false);
        }
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
    }
}

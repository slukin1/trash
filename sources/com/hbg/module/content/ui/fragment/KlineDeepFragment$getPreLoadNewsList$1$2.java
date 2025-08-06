package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import d10.q;
import i6.d;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class KlineDeepFragment$getPreLoadNewsList$1$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ KlineDeepFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KlineDeepFragment$getPreLoadNewsList$1$2(KlineDeepFragment klineDeepFragment) {
        super(2);
        this.this$0 = klineDeepFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        q<Integer, Boolean, Boolean, Unit> Uh;
        this.this$0.ji(false);
        d.c("ray01", "2 getPreLoadNewsList error " + this.this$0.Zh());
        if (!(this.this$0.Yh() == 0 || (Uh = this.this$0.Uh()) == null)) {
            Uh.invoke(0, Boolean.TRUE, Boolean.FALSE);
        }
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
    }
}

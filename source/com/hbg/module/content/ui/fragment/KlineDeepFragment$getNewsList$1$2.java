package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.a;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class KlineDeepFragment$getNewsList$1$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ KlineDeepFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KlineDeepFragment$getNewsList$1$2(KlineDeepFragment klineDeepFragment) {
        super(2);
        this.this$0 = klineDeepFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        this.this$0.ji(false);
        this.this$0.sh();
        a<Unit> Xh = this.this$0.Xh();
        if (Xh != null) {
            Xh.invoke();
        }
        if (this.this$0.Yh() == 0) {
            KlineDeepFragment.Sh(this.this$0).B.k();
        } else {
            a<Unit> Vh = this.this$0.Vh();
            if (Vh != null) {
                Vh.invoke();
            }
        }
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
    }
}

package com.hbg.module.content.ui.fragment;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class KlineDeepFragment$initView$2 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ KlineDeepFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KlineDeepFragment$initView$2(KlineDeepFragment klineDeepFragment) {
        super(1);
        this.this$0 = klineDeepFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.f56620a;
    }

    public final void invoke(boolean z11) {
        KlineDeepFragment.Sh(this.this$0).D.setNoMoreData(z11);
    }
}

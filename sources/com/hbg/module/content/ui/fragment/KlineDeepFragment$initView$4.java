package com.hbg.module.content.ui.fragment;

import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class KlineDeepFragment$initView$4 extends Lambda implements q<Integer, Boolean, Boolean, Unit> {
    public final /* synthetic */ KlineDeepFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KlineDeepFragment$initView$4(KlineDeepFragment klineDeepFragment) {
        super(3);
        this.this$0 = klineDeepFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue());
        return Unit.f56620a;
    }

    public final void invoke(int i11, boolean z11, boolean z12) {
        KlineDeepFragment.Sh(this.this$0).D.y(i11, z11, z12);
    }
}

package com.huobi.zeroswap.ui;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class ZeroSwapActivity$onCreate$2 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ ZeroSwapActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZeroSwapActivity$onCreate$2(ZeroSwapActivity zeroSwapActivity) {
        super(1);
        this.this$0 = zeroSwapActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        if (bool.booleanValue()) {
            ZeroSwapActivity zeroSwapActivity = this.this$0;
            zeroSwapActivity.Kh(ZeroSwapActivity.Ch(zeroSwapActivity));
        }
    }
}

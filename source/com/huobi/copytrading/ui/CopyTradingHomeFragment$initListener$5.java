package com.huobi.copytrading.ui;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CopyTradingHomeFragment$initListener$5 extends Lambda implements l<String, Unit> {
    public final /* synthetic */ CopyTradingHomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CopyTradingHomeFragment$initListener$5(CopyTradingHomeFragment copyTradingHomeFragment) {
        super(1);
        this.this$0 = copyTradingHomeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.f56620a;
    }

    public final void invoke(String str) {
        if (StringsKt__StringsJVMKt.M(str, " ", false, 2, (Object) null)) {
            this.this$0.Ih().x0().setValue(StringsKt__StringsKt.j1(str).toString());
        } else {
            this.this$0.Ih().A0(this.this$0.f43610i, str);
        }
    }
}

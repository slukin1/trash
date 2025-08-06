package com.hbg.module.content.ui.fragment;

import com.hbg.module.libkt.utils.event.bean.PageVisible;
import d10.a;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class KlineDeepFragment$initView$8 extends Lambda implements l<PageVisible, Unit> {
    public final /* synthetic */ KlineDeepFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KlineDeepFragment$initView$8(KlineDeepFragment klineDeepFragment) {
        super(1);
        this.this$0 = klineDeepFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PageVisible) obj);
        return Unit.f56620a;
    }

    public final void invoke(PageVisible pageVisible) {
        a<Unit> Th = this.this$0.Th();
        if (Th != null) {
            Th.invoke();
        }
    }
}

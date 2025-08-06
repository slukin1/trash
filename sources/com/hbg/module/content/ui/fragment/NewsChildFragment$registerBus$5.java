package com.hbg.module.content.ui.fragment;

import com.hbg.module.libkt.utils.event.bean.PageVisible;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsChildFragment$registerBus$5 extends Lambda implements l<PageVisible, Unit> {
    public final /* synthetic */ NewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsChildFragment$registerBus$5(NewsChildFragment newsChildFragment) {
        super(1);
        this.this$0 = newsChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PageVisible) obj);
        return Unit.f56620a;
    }

    public final void invoke(PageVisible pageVisible) {
        if (this.this$0.ti() != 1) {
            NewsChildFragment.Zh(this.this$0).E.t();
        } else {
            this.this$0.Ai();
        }
    }
}

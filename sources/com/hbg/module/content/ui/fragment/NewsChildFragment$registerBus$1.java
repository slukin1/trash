package com.hbg.module.content.ui.fragment;

import com.hbg.module.content.adapter.NewsAdapter;
import com.hbg.module.libkt.utils.event.bean.RisePut;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsChildFragment$registerBus$1 extends Lambda implements l<RisePut, Unit> {
    public final /* synthetic */ NewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsChildFragment$registerBus$1(NewsChildFragment newsChildFragment) {
        super(1);
        this.this$0 = newsChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RisePut) obj);
        return Unit.f56620a;
    }

    public final void invoke(RisePut risePut) {
        NewsAdapter ci2 = this.this$0.f18781p;
        if (ci2 != null) {
            ci2.C(risePut);
        }
    }
}

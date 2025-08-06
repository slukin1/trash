package com.hbg.module.content.ui.fragment;

import com.hbg.module.content.adapter.NewsAdapter;
import com.hbg.module.libkt.utils.event.bean.ShareNum;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsChildFragment$registerBus$3 extends Lambda implements l<ShareNum, Unit> {
    public final /* synthetic */ NewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsChildFragment$registerBus$3(NewsChildFragment newsChildFragment) {
        super(1);
        this.this$0 = newsChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ShareNum) obj);
        return Unit.f56620a;
    }

    public final void invoke(ShareNum shareNum) {
        NewsAdapter ci2 = this.this$0.f18781p;
        if (ci2 != null) {
            ci2.D(shareNum);
        }
    }
}

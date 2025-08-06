package com.hbg.module.content.ui.fragment;

import com.hbg.module.content.adapter.NewsAdapter;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsChildFragment$registerBus$4 extends Lambda implements l<Object, Unit> {
    public final /* synthetic */ NewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsChildFragment$registerBus$4(NewsChildFragment newsChildFragment) {
        super(1);
        this.this$0 = newsChildFragment;
    }

    public final void invoke(Object obj) {
        NewsAdapter ci2 = this.this$0.f18781p;
        if (ci2 != null) {
            ci2.notifyDataSetChanged();
        }
    }
}

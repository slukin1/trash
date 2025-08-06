package com.huobi.index.ui;

import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.index.helper.data.NewFeedModule;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class FeedFragment$initObserver$1 extends Lambda implements l<NewFeedModule, Unit> {
    public final /* synthetic */ FeedFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedFragment$initObserver$1(FeedFragment feedFragment) {
        super(1);
        this.this$0 = feedFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NewFeedModule) obj);
        return Unit.f56620a;
    }

    public final void invoke(NewFeedModule newFeedModule) {
        LoadingLayout loadingLayout = null;
        if (newFeedModule.f73309k == 0) {
            LoadingLayout Fh = this.this$0.f73507t;
            if (Fh == null) {
                Fh = null;
            }
            if (Fh.isShown()) {
                LoadingLayout Fh2 = this.this$0.f73507t;
                if (Fh2 != null) {
                    loadingLayout = Fh2;
                }
                loadingLayout.setVisibility(8);
            }
            this.this$0.di(newFeedModule.q(), newFeedModule.f73308j, newFeedModule.f73307i, newFeedModule.f73314p);
            return;
        }
        this.this$0.ci();
        if (newFeedModule.q() == null || newFeedModule.q().size() <= 0) {
            LoadingLayout Fh3 = this.this$0.f73507t;
            if (Fh3 == null) {
                Fh3 = null;
            }
            Fh3.setVisibility(0);
            LoadingLayout Fh4 = this.this$0.f73507t;
            if (Fh4 != null) {
                loadingLayout = Fh4;
            }
            loadingLayout.k();
        }
    }
}

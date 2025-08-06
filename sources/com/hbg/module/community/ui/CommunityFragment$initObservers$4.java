package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityFragment$initObservers$4 extends Lambda implements l<List<? extends CommunityFeedInfo.ListBean>, Unit> {
    public final /* synthetic */ CommunityFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFragment$initObservers$4(CommunityFragment communityFragment) {
        super(1);
        this.this$0 = communityFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends CommunityFeedInfo.ListBean>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<? extends CommunityFeedInfo.ListBean> list) {
        if (list != null && this.this$0.fi() == 2) {
            int size = this.this$0.ei().size();
            if (!list.isEmpty()) {
                this.this$0.ei().addAll(list);
            }
            this.this$0.di().notifyItemRangeInserted(size, list.size());
        }
        CommunityFragment.Vh(this.this$0).G.finishRefresh();
        CommunityFragment.Vh(this.this$0).G.w();
        this.this$0.sh();
    }
}

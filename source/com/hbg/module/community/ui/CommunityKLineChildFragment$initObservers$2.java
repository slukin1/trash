package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityKLineChildFragment$initObservers$2 extends Lambda implements l<List<? extends CommunityFeedInfo.ListBean>, Unit> {
    public final /* synthetic */ CommunityKLineChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityKLineChildFragment$initObservers$2(CommunityKLineChildFragment communityKLineChildFragment) {
        super(1);
        this.this$0 = communityKLineChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends CommunityFeedInfo.ListBean>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<? extends CommunityFeedInfo.ListBean> list) {
        if (list != null && this.this$0.ci() == 2) {
            int size = this.this$0.bi().size();
            if (!list.isEmpty()) {
                this.this$0.bi().addAll(list);
            }
            this.this$0.ai().notifyItemRangeInserted(size, list.size());
        }
        CommunityKLineChildFragment.Th(this.this$0).D.finishRefresh();
        CommunityKLineChildFragment.Th(this.this$0).D.w();
        this.this$0.sh();
    }
}

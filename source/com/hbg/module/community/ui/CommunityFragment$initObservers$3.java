package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.hbg.module.community.adapter.b;
import com.hbg.module.community.viewmodel.CommunityViewModel;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityFragment$initObservers$3 extends Lambda implements l<List<? extends LiveBannerData>, Unit> {
    public final /* synthetic */ CommunityFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFragment$initObservers$3(CommunityFragment communityFragment) {
        super(1);
        this.this$0 = communityFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends LiveBannerData>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<? extends LiveBannerData> list) {
        if (this.this$0.fi() == 1 || this.this$0.fi() == -1) {
            if (list == null || !(!list.isEmpty())) {
                this.this$0.ci().clear();
            } else {
                this.this$0.di().h(List.class, new b(this.this$0.f17279r, this.this$0));
                this.this$0.ci().clear();
                this.this$0.ci().addAll(list);
            }
        }
        CommunityViewModel Th = this.this$0.f17278q;
        if (Th == null) {
            Th = null;
        }
        Th.q0(this.this$0.fi());
    }
}

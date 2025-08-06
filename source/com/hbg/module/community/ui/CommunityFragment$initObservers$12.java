package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import xe.c;

public final class CommunityFragment$initObservers$12 extends Lambda implements l<c, Unit> {
    public final /* synthetic */ CommunityFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFragment$initObservers$12(CommunityFragment communityFragment) {
        super(1);
        this.this$0 = communityFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((c) obj);
        return Unit.f56620a;
    }

    public final void invoke(c cVar) {
        CommunityFeedInfo.ListBean listBean = new CommunityFeedInfo.ListBean();
        listBean.setId(Integer.parseInt(cVar.a()));
        int indexOf = this.this$0.ei().indexOf(listBean);
        if (indexOf >= 0) {
            this.this$0.ei().remove(indexOf);
            this.this$0.di().notifyDataSetChanged();
        }
    }
}

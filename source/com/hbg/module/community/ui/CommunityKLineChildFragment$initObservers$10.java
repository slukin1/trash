package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import xe.c;

public final class CommunityKLineChildFragment$initObservers$10 extends Lambda implements l<c, Unit> {
    public final /* synthetic */ CommunityKLineChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityKLineChildFragment$initObservers$10(CommunityKLineChildFragment communityKLineChildFragment) {
        super(1);
        this.this$0 = communityKLineChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((c) obj);
        return Unit.f56620a;
    }

    public final void invoke(c cVar) {
        CommunityFeedInfo.ListBean listBean = new CommunityFeedInfo.ListBean();
        listBean.setId(Integer.parseInt(cVar.a()));
        int indexOf = this.this$0.bi().indexOf(listBean);
        if (indexOf >= 0) {
            this.this$0.bi().remove(indexOf);
            this.this$0.ai().notifyDataSetChanged();
        }
    }
}

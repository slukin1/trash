package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import xe.c;

public final class CommunityChildFragment$initView$1 extends Lambda implements l<c, Unit> {
    public final /* synthetic */ CommunityChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityChildFragment$initView$1(CommunityChildFragment communityChildFragment) {
        super(1);
        this.this$0 = communityChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((c) obj);
        return Unit.f56620a;
    }

    public final void invoke(c cVar) {
        CommunityFeedInfo.ListBean listBean = new CommunityFeedInfo.ListBean();
        listBean.setId(Integer.parseInt(cVar.a()));
        int indexOf = this.this$0.Vh().indexOf(listBean);
        if (indexOf >= 0) {
            this.this$0.Vh().remove(indexOf);
            this.this$0.Th().notifyDataSetChanged();
        }
    }
}

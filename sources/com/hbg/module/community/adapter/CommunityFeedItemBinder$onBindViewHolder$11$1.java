package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import lc.a3;
import we.c;

public final class CommunityFeedItemBinder$onBindViewHolder$11$1 extends Lambda implements l<Integer, Unit> {
    public final /* synthetic */ ItemViewBinder.a<a3> $holder;
    public final /* synthetic */ CommunityFeedInfo.ListBean $item;
    public final /* synthetic */ CommunityFeedItemBinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFeedItemBinder$onBindViewHolder$11$1(CommunityFeedInfo.ListBean listBean, CommunityFeedItemBinder communityFeedItemBinder, ItemViewBinder.a<a3> aVar) {
        super(1);
        this.$item = listBean;
        this.this$0 = communityFeedItemBinder;
        this.$holder = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.f56620a;
    }

    public final void invoke(int i11) {
        this.$item.setFocusStatus(i11);
        this.this$0.D(this.$holder, i11, this.$item.getIsSelf());
        c.q(this.$item.getUidUnique(), this.$item.getFocusStatus());
    }
}

package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import lc.a3;

public final class CommunityFeedItemBinder$onBindViewHolder$7$1 extends Lambda implements p<Integer, Integer, Unit> {
    public final /* synthetic */ ItemViewBinder.a<a3> $holder;
    public final /* synthetic */ CommunityFeedInfo.ListBean $item;
    public final /* synthetic */ CommunityFeedItemBinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFeedItemBinder$onBindViewHolder$7$1(CommunityFeedInfo.ListBean listBean, ItemViewBinder.a<a3> aVar, CommunityFeedItemBinder communityFeedItemBinder) {
        super(2);
        this.$item = listBean;
        this.$holder = aVar;
        this.this$0 = communityFeedItemBinder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
        return Unit.f56620a;
    }

    public final void invoke(int i11, int i12) {
        this.$item.setPraiseNum(i11);
        this.$item.setPraiseStatus(i12);
        this.$holder.e().T.setText(String.valueOf(i11));
        this.this$0.F(this.$holder, i12, true);
    }
}

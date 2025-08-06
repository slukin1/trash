package com.hbg.module.community.adapter;

import android.content.Context;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.a;
import he.c;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import lc.w2;

public final class AttentionRecommendCellAdapter$onBindViewHolder$2$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CommunityFeedInfo.FocusBean $data;
    public final /* synthetic */ c.a<w2> $holder;
    public final /* synthetic */ AttentionRecommendCellAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AttentionRecommendCellAdapter$onBindViewHolder$2$1(CommunityFeedInfo.FocusBean focusBean, AttentionRecommendCellAdapter attentionRecommendCellAdapter, Context context, c.a<w2> aVar) {
        super(0);
        this.$data = focusBean;
        this.this$0 = attentionRecommendCellAdapter;
        this.$context = context;
        this.$holder = aVar;
    }

    public final void invoke() {
        this.$data.setFocusStatus(1);
        this.this$0.t(this.$context, this.$data.getFocusStatus(), this.$holder);
        we.c.q(this.$data.getUidUnique(), this.$data.getFocusStatus());
    }
}

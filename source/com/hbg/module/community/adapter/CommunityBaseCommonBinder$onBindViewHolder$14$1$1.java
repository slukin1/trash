package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommentPraiseBean;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityBaseCommonBinder$onBindViewHolder$14$1$1 extends Lambda implements l<CommentPraiseBean, Unit> {
    public final /* synthetic */ CommunityBaseCommonBinder.a $holder;
    public final /* synthetic */ CommunityFeedInfo.ListBean $item;
    public final /* synthetic */ CommunityBaseCommonBinder<ItemData, SubViewHolder> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityBaseCommonBinder$onBindViewHolder$14$1$1(CommunityFeedInfo.ListBean listBean, CommunityBaseCommonBinder<ItemData, SubViewHolder> communityBaseCommonBinder, CommunityBaseCommonBinder.a aVar) {
        super(1);
        this.$item = listBean;
        this.this$0 = communityBaseCommonBinder;
        this.$holder = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentPraiseBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentPraiseBean commentPraiseBean) {
        if (commentPraiseBean != null) {
            CommunityFeedInfo.ListBean listBean = this.$item;
            CommunityBaseCommonBinder<ItemData, SubViewHolder> communityBaseCommonBinder = this.this$0;
            CommunityBaseCommonBinder.a aVar = this.$holder;
            if (commentPraiseBean.praiseStatus != listBean.getPraiseStatus()) {
                listBean.setPraiseStatus(commentPraiseBean.praiseStatus);
                listBean.setPraiseNum(commentPraiseBean.praiseStatus == 1 ? listBean.getPraiseNum() + 1 : listBean.getPraiseNum() - 1);
            }
            communityBaseCommonBinder.e0(aVar, listBean);
        }
    }
}

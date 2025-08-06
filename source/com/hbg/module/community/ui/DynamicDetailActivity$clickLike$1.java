package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommentPraiseBean;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import we.c;

public final class DynamicDetailActivity$clickLike$1 extends Lambda implements l<CommentPraiseBean, Unit> {
    public final /* synthetic */ DynamicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDetailActivity$clickLike$1(DynamicDetailActivity dynamicDetailActivity) {
        super(1);
        this.this$0 = dynamicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentPraiseBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentPraiseBean commentPraiseBean) {
        if (commentPraiseBean != null) {
            DynamicDetailActivity dynamicDetailActivity = this.this$0;
            DynamicDetailInfo Gh = dynamicDetailActivity.f17332n;
            if (Gh != null) {
                Gh.setPraiseNum(commentPraiseBean.praiseNum);
            }
            DynamicDetailInfo Gh2 = dynamicDetailActivity.f17332n;
            if (Gh2 != null) {
                Gh2.setPraiseStatus(commentPraiseBean.praiseStatus);
            }
            DynamicDetailActivity.Mh(dynamicDetailActivity).M(dynamicDetailActivity.f17332n);
            dynamicDetailActivity.Ui(commentPraiseBean.praiseStatus);
            c.p(dynamicDetailActivity.f17327i, commentPraiseBean.praiseStatus, commentPraiseBean.praiseNum);
        }
    }
}

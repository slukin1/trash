package com.hbg.module.content.ui.activity;

import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.lib.network.hbg.core.bean.CommentPraiseBean;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import we.c;

public final class CommentDetailActivity$praise$1 extends Lambda implements l<CommentPraiseBean, Unit> {
    public final /* synthetic */ CommentDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentDetailActivity$praise$1(CommentDetailActivity commentDetailActivity) {
        super(1);
        this.this$0 = commentDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentPraiseBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentPraiseBean commentPraiseBean) {
        if (commentPraiseBean != null) {
            CommentDetailActivity commentDetailActivity = this.this$0;
            CommentInfo Bh = commentDetailActivity.f18259m;
            if (Bh != null) {
                Bh.parseNums = commentPraiseBean.praiseNum;
            }
            CommentInfo Bh2 = commentDetailActivity.f18259m;
            if (Bh2 != null) {
                Bh2.parseStatus = commentPraiseBean.praiseStatus;
            }
            CommentDetailActivity.Eh(commentDetailActivity).M(commentDetailActivity.f18259m);
            c.y(commentDetailActivity.f18257k, (String) null, commentPraiseBean.praiseNum, commentPraiseBean.praiseStatus, true);
        }
    }
}

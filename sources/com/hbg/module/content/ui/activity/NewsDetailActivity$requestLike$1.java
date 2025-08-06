package com.hbg.module.content.ui.activity;

import com.hbg.lib.network.hbg.core.bean.CommentPraiseBean;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsDetailActivity$requestLike$1 extends Lambda implements l<CommentPraiseBean, Unit> {
    public final /* synthetic */ NewsDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsDetailActivity$requestLike$1(NewsDetailActivity newsDetailActivity) {
        super(1);
        this.this$0 = newsDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentPraiseBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentPraiseBean commentPraiseBean) {
        if (commentPraiseBean != null) {
            NewsDetailActivity newsDetailActivity = this.this$0;
            NewFlashInformation Bh = newsDetailActivity.f18296k;
            if (Bh != null) {
                Bh.praiseNum = commentPraiseBean.praiseNum;
            }
            NewFlashInformation Bh2 = newsDetailActivity.f18296k;
            if (Bh2 != null) {
                Bh2.praiseStatus = commentPraiseBean.praiseStatus;
            }
            NewsDetailActivity.Dh(newsDetailActivity).O(newsDetailActivity.f18296k);
            newsDetailActivity.fi(commentPraiseBean.praiseStatus, true);
        }
    }
}

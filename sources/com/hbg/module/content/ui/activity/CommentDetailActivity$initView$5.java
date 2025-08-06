package com.hbg.module.content.ui.activity;

import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.libkt.utils.event.bean.CommentNum;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommentDetailActivity$initView$5 extends Lambda implements l<CommentNum, Unit> {
    public final /* synthetic */ CommentDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentDetailActivity$initView$5(CommentDetailActivity commentDetailActivity) {
        super(1);
        this.this$0 = commentDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentNum) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentNum commentNum) {
        CommentDetailActivity commentDetailActivity = this.this$0;
        if (commentNum.f()) {
            CommentInfo Bh = commentDetailActivity.f18259m;
            if (Bh != null) {
                CommentInfo Bh2 = commentDetailActivity.f18259m;
                Bh.replyNum = (Bh2 != null ? Integer.valueOf(Bh2.replyNum + 1) : null).intValue();
            }
            CommentDetailActivity.Eh(commentDetailActivity).M(commentDetailActivity.f18259m);
        }
    }
}

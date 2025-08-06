package com.hbg.module.content.ui.activity;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommentDetailActivity$getCommentList$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ CommentDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentDetailActivity$getCommentList$2(CommentDetailActivity commentDetailActivity) {
        super(2);
        this.this$0 = commentDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        CommentDetailActivity.Eh(this.this$0).J.finishRefresh();
        CommentDetailActivity.Eh(this.this$0).J.w();
        if (this.this$0.f18262p == 1) {
            CommentDetailActivity.Eh(this.this$0).I.k();
        }
        this.this$0.Df();
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
    }
}

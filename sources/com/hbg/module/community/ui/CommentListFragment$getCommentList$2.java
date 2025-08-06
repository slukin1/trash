package com.hbg.module.community.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommentListFragment$getCommentList$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ CommentListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentListFragment$getCommentList$2(CommentListFragment commentListFragment) {
        super(2);
        this.this$0 = commentListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        CommentListFragment.Th(this.this$0).D.w();
        CommentListFragment.Th(this.this$0).D.finishRefresh();
        this.this$0.sh();
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
        if (this.this$0.f17260u == 1) {
            CommentListFragment.Th(this.this$0).B.k();
        }
    }
}

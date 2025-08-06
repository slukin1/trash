package com.hbg.module.content.ui.activity;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsDetailActivity$getCommentList$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ NewsDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsDetailActivity$getCommentList$2(NewsDetailActivity newsDetailActivity) {
        super(2);
        this.this$0 = newsDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        NewsDetailActivity.Dh(this.this$0).Z.w();
        this.this$0.Df();
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
        if (this.this$0.f18298m == 1) {
            NewsDetailActivity.Dh(this.this$0).f19309n0.setVisibility(0);
        }
        this.this$0.f18303r = false;
    }
}

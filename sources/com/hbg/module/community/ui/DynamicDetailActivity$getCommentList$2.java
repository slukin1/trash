package com.hbg.module.community.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class DynamicDetailActivity$getCommentList$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ DynamicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDetailActivity$getCommentList$2(DynamicDetailActivity dynamicDetailActivity) {
        super(2);
        this.this$0 = dynamicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        DynamicDetailActivity.Mh(this.this$0).f19150e0.w();
        this.this$0.Df();
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
        if (this.this$0.f17333o == 1) {
            DynamicDetailActivity.Mh(this.this$0).H0.setVisibility(0);
        }
        this.this$0.f17329k = false;
    }
}

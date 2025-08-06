package com.hbg.module.community.adapter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.a;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class AttentionRecommendCellAdapter$requestAttention$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ AttentionRecommendCellAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AttentionRecommendCellAdapter$requestAttention$2(AttentionRecommendCellAdapter attentionRecommendCellAdapter) {
        super(2);
        this.this$0 = attentionRecommendCellAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        a<Unit> m11 = this.this$0.m();
        if (m11 != null) {
            Unit invoke = m11.invoke();
        }
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        }
    }
}

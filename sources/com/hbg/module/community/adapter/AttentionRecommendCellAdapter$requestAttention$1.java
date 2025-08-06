package com.hbg.module.community.adapter;

import d10.a;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class AttentionRecommendCellAdapter$requestAttention$1 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ a<Unit> $onUpdateUI;
    public final /* synthetic */ AttentionRecommendCellAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AttentionRecommendCellAdapter$requestAttention$1(AttentionRecommendCellAdapter attentionRecommendCellAdapter, a<Unit> aVar) {
        super(1);
        this.this$0 = attentionRecommendCellAdapter;
        this.$onUpdateUI = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        a<Unit> m11 = this.this$0.m();
        if (m11 != null) {
            Unit invoke = m11.invoke();
        }
        if (x.b(bool, Boolean.TRUE)) {
            this.$onUpdateUI.invoke();
        }
    }
}

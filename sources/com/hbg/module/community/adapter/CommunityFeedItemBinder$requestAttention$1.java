package com.hbg.module.community.adapter;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityFeedItemBinder$requestAttention$1 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ l<Integer, Unit> $onUpdateUI;
    public final /* synthetic */ int $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFeedItemBinder$requestAttention$1(l<? super Integer, Unit> lVar, int i11) {
        super(1);
        this.$onUpdateUI = lVar;
        this.$type = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        if (bool != null) {
            l<Integer, Unit> lVar = this.$onUpdateUI;
            int i11 = this.$type;
            if (bool.booleanValue()) {
                lVar.invoke(Integer.valueOf(i11));
            }
        }
    }
}

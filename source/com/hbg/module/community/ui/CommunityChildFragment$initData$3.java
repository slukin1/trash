package com.hbg.module.community.ui;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityChildFragment$initData$3 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ CommunityChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityChildFragment$initData$3(CommunityChildFragment communityChildFragment) {
        super(1);
        this.this$0 = communityChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        l<Boolean, Unit> Xh = this.this$0.Xh();
        if (Xh != null) {
            Xh.invoke(Boolean.valueOf(!bool.booleanValue()));
        }
    }
}

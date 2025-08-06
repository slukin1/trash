package com.hbg.module.community.ui;

import d10.a;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityChildFragment$initData$2 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ CommunityChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityChildFragment$initData$2(CommunityChildFragment communityChildFragment) {
        super(1);
        this.this$0 = communityChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        this.this$0.sh();
        a<Unit> Yh = this.this$0.Yh();
        if (Yh != null) {
            Yh.invoke();
        }
        if (bool.booleanValue()) {
            CommunityChildFragment.Sh(this.this$0).B.k();
        }
    }
}

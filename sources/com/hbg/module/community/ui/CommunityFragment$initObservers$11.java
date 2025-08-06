package com.hbg.module.community.ui;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityFragment$initObservers$11 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ CommunityFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFragment$initObservers$11(CommunityFragment communityFragment) {
        super(1);
        this.this$0 = communityFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.f56620a;
    }

    public final void invoke(boolean z11) {
        CommunityFragment communityFragment = this.this$0;
        if (z11 && communityFragment.f17277p.size() > 0) {
            CommunityFragment.Vh(communityFragment).G.t();
        }
    }
}

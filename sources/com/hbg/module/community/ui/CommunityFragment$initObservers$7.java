package com.hbg.module.community.ui;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityFragment$initObservers$7 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ CommunityFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFragment$initObservers$7(CommunityFragment communityFragment) {
        super(1);
        this.this$0 = communityFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        CommunityFragment.Vh(this.this$0).G.setNoMoreData(!bool.booleanValue());
    }
}

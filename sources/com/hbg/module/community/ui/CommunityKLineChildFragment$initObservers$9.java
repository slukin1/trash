package com.hbg.module.community.ui;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityKLineChildFragment$initObservers$9 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ CommunityKLineChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityKLineChildFragment$initObservers$9(CommunityKLineChildFragment communityKLineChildFragment) {
        super(1);
        this.this$0 = communityKLineChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.f56620a;
    }

    public final void invoke(boolean z11) {
        CommunityKLineChildFragment communityKLineChildFragment = this.this$0;
        if (z11 && communityKLineChildFragment.f17292p.size() > 0) {
            CommunityKLineChildFragment.Th(communityKLineChildFragment).D.t();
        }
    }
}

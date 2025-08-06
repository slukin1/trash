package com.hbg.module.community.ui;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityKLineChildFragment$initObservers$4 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ CommunityKLineChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityKLineChildFragment$initObservers$4(CommunityKLineChildFragment communityKLineChildFragment) {
        super(1);
        this.this$0 = communityKLineChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        this.this$0.sh();
        CommunityKLineChildFragment.Th(this.this$0).D.finishRefresh();
        CommunityKLineChildFragment.Th(this.this$0).D.w();
        if (bool.booleanValue()) {
            CommunityKLineChildFragment.Th(this.this$0).B.k();
        }
    }
}

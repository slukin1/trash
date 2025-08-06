package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityUserPermissions;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityKLineChildFragment$initObservers$1 extends Lambda implements l<CommunityUserPermissions, Unit> {
    public final /* synthetic */ CommunityKLineChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityKLineChildFragment$initObservers$1(CommunityKLineChildFragment communityKLineChildFragment) {
        super(1);
        this.this$0 = communityKLineChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommunityUserPermissions) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommunityUserPermissions communityUserPermissions) {
        CommunityKLineChildFragment communityKLineChildFragment = this.this$0;
        boolean z11 = true;
        if (communityUserPermissions.getIsPublish() != 1) {
            z11 = false;
        }
        communityKLineChildFragment.f17300x = Boolean.valueOf(z11);
        this.this$0.f17301y = communityUserPermissions.getUidUnique();
    }
}

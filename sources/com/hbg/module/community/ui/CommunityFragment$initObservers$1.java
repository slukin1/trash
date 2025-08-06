package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityUserPermissions;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityFragment$initObservers$1 extends Lambda implements l<CommunityUserPermissions, Unit> {
    public final /* synthetic */ CommunityFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFragment$initObservers$1(CommunityFragment communityFragment) {
        super(1);
        this.this$0 = communityFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommunityUserPermissions) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommunityUserPermissions communityUserPermissions) {
        CommunityFragment communityFragment = this.this$0;
        boolean z11 = true;
        if (communityUserPermissions.getIsPublish() != 1) {
            z11 = false;
        }
        communityFragment.f17282u = Boolean.valueOf(z11);
        this.this$0.f17283v = communityUserPermissions.getUidUnique();
    }
}

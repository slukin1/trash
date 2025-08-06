package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityUserPermissions;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityKLineFragment$initObservers$1 extends Lambda implements l<CommunityUserPermissions, Unit> {
    public final /* synthetic */ CommunityKLineFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityKLineFragment$initObservers$1(CommunityKLineFragment communityKLineFragment) {
        super(1);
        this.this$0 = communityKLineFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommunityUserPermissions) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommunityUserPermissions communityUserPermissions) {
        CommunityKLineFragment communityKLineFragment = this.this$0;
        boolean z11 = true;
        if (communityUserPermissions.getIsPublish() != 1) {
            z11 = false;
        }
        communityKLineFragment.f17317y = Boolean.valueOf(z11);
        this.this$0.f17318z = communityUserPermissions.getUidUnique();
    }
}

package com.hbg.module.community.viewmodel;

import com.hbg.lib.network.hbg.core.bean.CommunityUserPermissions;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import wf.a;

public final class CommunityViewModel$requestUserInfo$1 extends Lambda implements l<CommunityUserPermissions, Unit> {
    public final /* synthetic */ CommunityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityViewModel$requestUserInfo$1(CommunityViewModel communityViewModel) {
        super(1);
        this.this$0 = communityViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommunityUserPermissions) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommunityUserPermissions communityUserPermissions) {
        this.this$0.k0().setValue(communityUserPermissions);
        a aVar = a.f40622a;
        boolean z11 = true;
        aVar.i(communityUserPermissions != null && communityUserPermissions.getIsPublish() == 1);
        String str = null;
        aVar.k(communityUserPermissions != null ? communityUserPermissions.getPublishTips() : null);
        if (communityUserPermissions == null || communityUserPermissions.getIsLiveShare() != 1) {
            z11 = false;
        }
        aVar.h(z11);
        if (communityUserPermissions != null) {
            str = communityUserPermissions.getPublishRedirectUrl();
        }
        aVar.j(str);
    }
}

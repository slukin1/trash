package com.hbg.module.community.ui;

import com.hbg.module.community.viewmodel.CommunityViewModel;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class CommunityFragment$initObservers$2 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ CommunityFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFragment$initObservers$2(CommunityFragment communityFragment) {
        super(1);
        this.this$0 = communityFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        if (x.b(bool, Boolean.FALSE)) {
            CommunityViewModel Th = this.this$0.f17278q;
            if (Th == null) {
                Th = null;
            }
            Th.q0(this.this$0.fi());
        }
    }
}

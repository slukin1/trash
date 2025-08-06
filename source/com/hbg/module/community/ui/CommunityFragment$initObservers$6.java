package com.hbg.module.community.ui;

import com.hbg.module.libkt.provider.HbgBaseApmProvider;
import com.xiaomi.mipush.sdk.Constants;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityFragment$initObservers$6 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ CommunityFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFragment$initObservers$6(CommunityFragment communityFragment) {
        super(1);
        this.this$0 = communityFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        this.this$0.sh();
        CommunityFragment.Vh(this.this$0).G.finishRefresh();
        CommunityFragment.Vh(this.this$0).G.w();
        if (bool.booleanValue()) {
            CommunityFragment.Vh(this.this$0).E.k();
        }
        if (!this.this$0.C) {
            this.this$0.C = true;
            HbgBaseApmProvider Sh = this.this$0.D;
            if (Sh != null) {
                Sh.i("huobiapp_market_content_community_end", Constants.ACCEPT_TIME_SEPARATOR_SERVER, true);
            }
        }
    }
}

package com.hbg.module.community.viewmodel;

import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import d10.l;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityViewModel$requestBanner$1 extends Lambda implements l<ArrayList<LiveBannerData>, Unit> {
    public final /* synthetic */ CommunityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityViewModel$requestBanner$1(CommunityViewModel communityViewModel) {
        super(1);
        this.this$0 = communityViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<LiveBannerData>) (ArrayList) obj);
        return Unit.f56620a;
    }

    public final void invoke(ArrayList<LiveBannerData> arrayList) {
        this.this$0.m0().setValue(Boolean.TRUE);
        this.this$0.h0().setValue(arrayList);
    }
}

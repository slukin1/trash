package com.hbg.module.community.adapter;

import com.hbg.module.community.adapter.CommunityBaseCommonBinder;
import com.hbg.module.libkt.custom.DynamicPicCardView;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DynamicPicCardView f17201b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder.a f17202c;

    public /* synthetic */ j(DynamicPicCardView dynamicPicCardView, CommunityBaseCommonBinder.a aVar) {
        this.f17201b = dynamicPicCardView;
        this.f17202c = aVar;
    }

    public final void run() {
        CommunityBaseCommonBinder.X(this.f17201b, this.f17202c);
    }
}

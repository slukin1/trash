package com.hbg.module.community.adapter;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;

public final /* synthetic */ class f implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder f17194b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17195c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder.a f17196d;

    public /* synthetic */ f(CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean, CommunityBaseCommonBinder.a aVar) {
        this.f17194b = communityBaseCommonBinder;
        this.f17195c = listBean;
        this.f17196d = aVar;
    }

    public final boolean onLongClick(View view) {
        return CommunityBaseCommonBinder.d0(this.f17194b, this.f17195c, this.f17196d, view);
    }
}

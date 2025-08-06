package com.hbg.module.community.adapter;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;

public final /* synthetic */ class e implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder f17190b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17191c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f17192d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder.a f17193e;

    public /* synthetic */ e(CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean, Context context, CommunityBaseCommonBinder.a aVar) {
        this.f17190b = communityBaseCommonBinder;
        this.f17191c = listBean;
        this.f17192d = context;
        this.f17193e = aVar;
    }

    public final boolean onLongClick(View view) {
        return CommunityBaseCommonBinder.T(this.f17190b, this.f17191c, this.f17192d, this.f17193e, view);
    }
}

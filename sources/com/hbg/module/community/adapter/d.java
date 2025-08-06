package com.hbg.module.community.adapter;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;

public final /* synthetic */ class d implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder f17186b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17187c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f17188d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder.a f17189e;

    public /* synthetic */ d(CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean, Context context, CommunityBaseCommonBinder.a aVar) {
        this.f17186b = communityBaseCommonBinder;
        this.f17187c = listBean;
        this.f17188d = context;
        this.f17189e = aVar;
    }

    public final boolean onLongClick(View view) {
        return CommunityBaseCommonBinder.U(this.f17186b, this.f17187c, this.f17188d, this.f17189e, view);
    }
}

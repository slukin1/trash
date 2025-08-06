package com.hbg.module.community.adapter;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;

public final /* synthetic */ class c implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder f17182b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17183c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f17184d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder.a f17185e;

    public /* synthetic */ c(CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean, Context context, CommunityBaseCommonBinder.a aVar) {
        this.f17182b = communityBaseCommonBinder;
        this.f17183c = listBean;
        this.f17184d = context;
        this.f17185e = aVar;
    }

    public final boolean onLongClick(View view) {
        return CommunityBaseCommonBinder.S(this.f17182b, this.f17183c, this.f17184d, this.f17185e, view);
    }
}

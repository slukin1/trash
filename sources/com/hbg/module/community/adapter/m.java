package com.hbg.module.community.adapter;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17205b;

    public /* synthetic */ m(CommunityFeedInfo.ListBean listBean) {
        this.f17205b = listBean;
    }

    public final void onClick(View view) {
        CommunityFeedItemBinder.A(this.f17205b, view);
    }
}

package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.LinkType;

public final /* synthetic */ class i implements ExpandableTextView.OnLinkClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder f17199a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17200b;

    public /* synthetic */ i(CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean) {
        this.f17199a = communityBaseCommonBinder;
        this.f17200b = listBean;
    }

    public final void onLinkClickListener(LinkType linkType, String str, String str2) {
        CommunityBaseCommonBinder.W(this.f17199a, this.f17200b, linkType, str, str2);
    }
}

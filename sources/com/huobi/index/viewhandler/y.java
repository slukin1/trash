package com.huobi.index.viewhandler;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.LinkType;

public final /* synthetic */ class y implements ExpandableTextView.OnLinkClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NewsCommunityHandler f74500a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f74501b;

    public /* synthetic */ y(NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean) {
        this.f74500a = newsCommunityHandler;
        this.f74501b = listBean;
    }

    public final void onLinkClickListener(LinkType linkType, String str, String str2) {
        NewsCommunityHandler.s(this.f74500a, this.f74501b, linkType, str, str2);
    }
}

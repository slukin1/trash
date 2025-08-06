package com.huobi.index.viewhandler;

import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.LinkType;

public final /* synthetic */ class x implements ExpandableTextView.OnLinkClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NewsCommunityHandler f74499a;

    public /* synthetic */ x(NewsCommunityHandler newsCommunityHandler) {
        this.f74499a = newsCommunityHandler;
    }

    public final void onLinkClickListener(LinkType linkType, String str, String str2) {
        NewsCommunityHandler.r(this.f74499a, linkType, str, str2);
    }
}

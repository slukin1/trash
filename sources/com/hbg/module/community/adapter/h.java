package com.hbg.module.community.adapter;

import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.LinkType;

public final /* synthetic */ class h implements ExpandableTextView.OnLinkClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder f17198a;

    public /* synthetic */ h(CommunityBaseCommonBinder communityBaseCommonBinder) {
        this.f17198a = communityBaseCommonBinder;
    }

    public final void onLinkClickListener(LinkType linkType, String str, String str2) {
        CommunityBaseCommonBinder.V(this.f17198a, linkType, str, str2);
    }
}

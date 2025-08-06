package com.hbg.module.community.adapter;

import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.LinkType;

public final /* synthetic */ class p implements ExpandableTextView.OnLinkClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityReplyArticleCommonBinder f17210a;

    public /* synthetic */ p(CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder) {
        this.f17210a = communityReplyArticleCommonBinder;
    }

    public final void onLinkClickListener(LinkType linkType, String str, String str2) {
        CommunityReplyArticleCommonBinder.u0(this.f17210a, linkType, str, str2);
    }
}

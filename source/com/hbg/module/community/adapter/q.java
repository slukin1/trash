package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.LinkType;

public final /* synthetic */ class q implements ExpandableTextView.OnLinkClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityReplyArticleCommonBinder f17211a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17212b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean.ParentDynamic f17213c;

    public /* synthetic */ q(CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder, CommunityFeedInfo.ListBean listBean, CommunityFeedInfo.ListBean.ParentDynamic parentDynamic) {
        this.f17211a = communityReplyArticleCommonBinder;
        this.f17212b = listBean;
        this.f17213c = parentDynamic;
    }

    public final void onLinkClickListener(LinkType linkType, String str, String str2) {
        CommunityReplyArticleCommonBinder.v0(this.f17211a, this.f17212b, this.f17213c, linkType, str, str2);
    }
}

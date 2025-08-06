package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;
import kotlin.jvm.internal.Ref$BooleanRef;

public final /* synthetic */ class o implements ExpandableTextView.OnExpandOrContractClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityReplyArticleCommonBinder f17207a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17208b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$BooleanRef f17209c;

    public /* synthetic */ o(CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder, CommunityFeedInfo.ListBean listBean, Ref$BooleanRef ref$BooleanRef) {
        this.f17207a = communityReplyArticleCommonBinder;
        this.f17208b = listBean;
        this.f17209c = ref$BooleanRef;
    }

    public final void onClick(StatusType statusType) {
        CommunityReplyArticleCommonBinder.w0(this.f17207a, this.f17208b, this.f17209c, statusType);
    }
}

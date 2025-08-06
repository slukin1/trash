package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;

public final /* synthetic */ class r implements ExpandableTextView.OnExpandOrContractClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17214a;

    public /* synthetic */ r(CommunityFeedInfo.ListBean listBean) {
        this.f17214a = listBean;
    }

    public final void onClick(StatusType statusType) {
        CommunityReplyCommentCommonBinder.s0(this.f17214a, statusType);
    }
}

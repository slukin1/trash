package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;

public final /* synthetic */ class n implements ExpandableTextView.OnExpandOrContractClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17206a;

    public /* synthetic */ n(CommunityFeedInfo.ListBean listBean) {
        this.f17206a = listBean;
    }

    public final void onClick(StatusType statusType) {
        CommunityFeedItemBinder.B(this.f17206a, statusType);
    }
}

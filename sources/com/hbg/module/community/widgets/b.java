package com.hbg.module.community.widgets;

import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;

public final /* synthetic */ class b implements ExpandableTextView.OnExpandOrContractClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityChildLayout f17702a;

    public /* synthetic */ b(CommunityChildLayout communityChildLayout) {
        this.f17702a = communityChildLayout;
    }

    public final void onClick(StatusType statusType) {
        CommunityChildLayout.e(this.f17702a, statusType);
    }
}

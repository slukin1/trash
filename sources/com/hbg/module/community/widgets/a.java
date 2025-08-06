package com.hbg.module.community.widgets;

import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;

public final /* synthetic */ class a implements ExpandableTextView.OnExpandOrContractClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityChildLayout f17701a;

    public /* synthetic */ a(CommunityChildLayout communityChildLayout) {
        this.f17701a = communityChildLayout;
    }

    public final void onClick(StatusType statusType) {
        CommunityChildLayout.d(this.f17701a, statusType);
    }
}

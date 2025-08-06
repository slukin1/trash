package com.hbg.module.community.adapter;

import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;
import d10.a;

public final /* synthetic */ class g implements ExpandableTextView.OnExpandOrContractClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f17197a;

    public /* synthetic */ g(a aVar) {
        this.f17197a = aVar;
    }

    public final void onClick(StatusType statusType) {
        CommunityBaseCommonBinder.R(this.f17197a, statusType);
    }
}

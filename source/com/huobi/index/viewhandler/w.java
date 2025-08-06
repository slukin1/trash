package com.huobi.index.viewhandler;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;

public final /* synthetic */ class w implements ExpandableTextView.OnExpandOrContractClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NewsCommunityHandler f74496a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f74497b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HomeFeedInfoItem f74498c;

    public /* synthetic */ w(NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, HomeFeedInfoItem homeFeedInfoItem) {
        this.f74496a = newsCommunityHandler;
        this.f74497b = listBean;
        this.f74498c = homeFeedInfoItem;
    }

    public final void onClick(StatusType statusType) {
        NewsCommunityHandler.p(this.f74496a, this.f74497b, this.f74498c, statusType);
    }
}

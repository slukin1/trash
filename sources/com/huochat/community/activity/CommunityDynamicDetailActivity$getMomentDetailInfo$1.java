package com.huochat.community.activity;

import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.huochat.community.model.CommunityItemBean;

public final class CommunityDynamicDetailActivity$getMomentDetailInfo$1 extends RequestCallback1<CommunityItemBean> {
    public final /* synthetic */ CommunityDynamicDetailActivity this$0;

    public CommunityDynamicDetailActivity$getMomentDetailInfo$1(CommunityDynamicDetailActivity communityDynamicDetailActivity) {
        this.this$0 = communityDynamicDetailActivity;
    }

    public void onRequestFailure(Throwable th2) {
        this.this$0.finishSkeleton();
        this.this$0.handleEmpty(false);
    }

    public void onRequestStart() {
        this.this$0.showSkeleton();
    }

    public void onRequestSuccess(CommunityItemBean communityItemBean) {
        if (communityItemBean != null) {
            this.this$0.mCommunityItemBean = communityItemBean;
            this.this$0.refreshMomentInfoView();
            this.this$0.refreshMoreDataInfo();
        }
        this.this$0.finishSkeleton();
        this.this$0.handleEmpty(true);
    }
}

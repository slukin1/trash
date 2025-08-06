package com.huochat.community.activity;

import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.huochat.community.adapter.CommunityAdapter;
import com.huochat.community.model.TopicDetailBean;

public final class TopicSearchTemplateActivity$getRealDiscussList$1 extends RequestCallback1<TopicDetailBean> {
    public final /* synthetic */ TopicSearchTemplateActivity this$0;

    public TopicSearchTemplateActivity$getRealDiscussList$1(TopicSearchTemplateActivity topicSearchTemplateActivity) {
        this.this$0 = topicSearchTemplateActivity;
    }

    public void onRequestFailure(Throwable th2) {
        this.this$0.handleEmptyView(false);
    }

    public void onRequestStart() {
        if (-1 == this.this$0.startIndex) {
            CommunityAdapter access$getCircleAdapter$p = this.this$0.circleAdapter;
            boolean z11 = false;
            if (access$getCircleAdapter$p != null && !access$getCircleAdapter$p.hasListData()) {
                z11 = true;
            }
            if (z11) {
                this.this$0.shouLoading(true);
            }
        }
    }

    public void onRequestSuccess(TopicDetailBean topicDetailBean) {
        this.this$0.handleCallback(topicDetailBean);
    }
}

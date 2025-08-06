package com.huochat.community.widget;

import android.view.View;
import com.huochat.community.model.TopicBean;
import com.huochat.community.widget.HotTopicTagFlowView;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HotTopicTagFlowView.HotTopicAdapter f38728b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TopicBean f38729c;

    public /* synthetic */ j(HotTopicTagFlowView.HotTopicAdapter hotTopicAdapter, TopicBean topicBean) {
        this.f38728b = hotTopicAdapter;
        this.f38729c = topicBean;
    }

    public final void onClick(View view) {
        this.f38728b.lambda$onBindViewHolder$0(this.f38729c, view);
    }
}

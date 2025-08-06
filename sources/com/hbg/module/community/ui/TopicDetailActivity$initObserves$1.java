package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityUserPermissions;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class TopicDetailActivity$initObserves$1 extends Lambda implements l<CommunityUserPermissions, Unit> {
    public final /* synthetic */ TopicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicDetailActivity$initObserves$1(TopicDetailActivity topicDetailActivity) {
        super(1);
        this.this$0 = topicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommunityUserPermissions) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommunityUserPermissions communityUserPermissions) {
        TopicDetailActivity topicDetailActivity = this.this$0;
        boolean z11 = true;
        if (communityUserPermissions.getIsPublish() != 1) {
            z11 = false;
        }
        topicDetailActivity.f17524x = Boolean.valueOf(z11);
    }
}

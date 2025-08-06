package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huochat.community.CommunityModuleCallback;
import com.huochat.community.CommunityModuleConfig;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityReplyArticleCommonBinder$onBindContentViewHolder$jumpDetailDynamicPage$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ CommunityFeedInfo.ListBean $bean;
    public final /* synthetic */ CommunityFeedInfo.ListBean.ParentDynamic $data;
    public final /* synthetic */ CommunityReplyArticleCommonBinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityReplyArticleCommonBinder$onBindContentViewHolder$jumpDetailDynamicPage$1(CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder, CommunityFeedInfo.ListBean listBean, CommunityFeedInfo.ListBean.ParentDynamic parentDynamic) {
        super(0);
        this.this$0 = communityReplyArticleCommonBinder;
        this.$bean = listBean;
        this.$data = parentDynamic;
    }

    public final void invoke() {
        CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
        if (moduleCallback != null) {
            moduleCallback.newTrack("app_community_feed", this.this$0.G(this.$bean));
        }
        b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(this.$data.getId())).navigation();
    }
}

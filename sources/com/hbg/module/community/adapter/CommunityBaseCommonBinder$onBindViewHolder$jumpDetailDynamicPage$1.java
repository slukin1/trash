package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huochat.community.CommunityModuleCallback;
import com.huochat.community.CommunityModuleConfig;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityBaseCommonBinder$onBindViewHolder$jumpDetailDynamicPage$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ CommunityFeedInfo.ListBean $item;
    public final /* synthetic */ CommunityBaseCommonBinder<ItemData, SubViewHolder> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityBaseCommonBinder$onBindViewHolder$jumpDetailDynamicPage$1(CommunityBaseCommonBinder<ItemData, SubViewHolder> communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean) {
        super(0);
        this.this$0 = communityBaseCommonBinder;
        this.$item = listBean;
    }

    public final void invoke() {
        CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
        if (moduleCallback != null) {
            moduleCallback.newTrack("app_community_feed", this.this$0.G(this.$item));
        }
        b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(this.$item.getId())).navigation();
    }
}

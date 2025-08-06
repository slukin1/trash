package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.NewFeed;
import com.hbg.module.community.adapter.CommunityRecommendLiveBinder;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.provider.HbgBaseApmProvider;
import com.xiaomi.mipush.sdk.Constants;
import d10.l;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityFragment$initObservers$5 extends Lambda implements l<CommunityFeedInfo, Unit> {
    public final /* synthetic */ CommunityFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFragment$initObservers$5(CommunityFragment communityFragment) {
        super(1);
        this.this$0 = communityFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommunityFeedInfo) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommunityFeedInfo communityFeedInfo) {
        if (communityFeedInfo != null && ((communityFeedInfo.getTopic() != null && communityFeedInfo.getTopic().size() != 0) || (communityFeedInfo.getList() != null && communityFeedInfo.getList().size() != 0))) {
            CommunityFragment.Vh(this.this$0).E.g();
            if (this.this$0.fi() == 1 || this.this$0.fi() == -1) {
                this.this$0.ei().clear();
                int i11 = 0;
                if (this.this$0.ci().size() > 0) {
                    this.this$0.ei().add(this.this$0.ci());
                    i11 = 1;
                }
                if (communityFeedInfo.getTopic() != null && communityFeedInfo.getTopic().size() > 0) {
                    CommunityFeedInfo.TopicListBean topicListBean = new CommunityFeedInfo.TopicListBean();
                    topicListBean.setTopic(communityFeedInfo.getTopic());
                    this.this$0.ei().add(topicListBean);
                }
                if (communityFeedInfo.getList() != null && communityFeedInfo.getList().size() > 0) {
                    this.this$0.ei().addAll(communityFeedInfo.getList());
                }
                ArrayList<NewFeed.CardIndexItem> arrayList = communityFeedInfo.cardIndexList;
                if (arrayList != null) {
                    CommunityFragment communityFragment = this.this$0;
                    for (NewFeed.CardIndexItem cardIndexItem : arrayList) {
                        if (cardIndexItem.type == 3 && !b.w(communityFeedInfo.liveInfoList)) {
                            communityFragment.di().h(CommunityFeedInfo.RecommendLiveBean.class, new CommunityRecommendLiveBinder());
                            CommunityFeedInfo.RecommendLiveBean recommendLiveBean = new CommunityFeedInfo.RecommendLiveBean();
                            recommendLiveBean.lives = communityFeedInfo.liveInfoList;
                            if (b.w(communityFeedInfo.getList())) {
                                communityFragment.ei().add(recommendLiveBean);
                            } else {
                                communityFragment.ei().add(cardIndexItem.index + i11, recommendLiveBean);
                            }
                        }
                    }
                }
                if (!this.this$0.C) {
                    this.this$0.C = true;
                    HbgBaseApmProvider Sh = this.this$0.D;
                    if (Sh != null) {
                        Sh.i("huobiapp_market_content_community_end", Constants.ACCEPT_TIME_SEPARATOR_SERVER, true);
                    }
                }
            }
            this.this$0.di().notifyDataSetChanged();
        } else if (this.this$0.fi() == 1 || this.this$0.fi() == -1) {
            CommunityFragment.Vh(this.this$0).E.i();
        }
        CommunityFragment.Vh(this.this$0).G.finishRefresh();
        CommunityFragment.Vh(this.this$0).G.w();
        this.this$0.sh();
    }
}

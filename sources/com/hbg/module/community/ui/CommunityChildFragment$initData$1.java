package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.a;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityChildFragment$initData$1 extends Lambda implements l<CommunityFeedInfo, Unit> {
    public final /* synthetic */ CommunityChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityChildFragment$initData$1(CommunityChildFragment communityChildFragment) {
        super(1);
        this.this$0 = communityChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommunityFeedInfo) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommunityFeedInfo communityFeedInfo) {
        this.this$0.sh();
        a<Unit> Yh = this.this$0.Yh();
        if (Yh != null) {
            Yh.invoke();
        }
        if (communityFeedInfo != null && ((communityFeedInfo.getRecommend() != null && communityFeedInfo.getRecommend().size() != 0) || (communityFeedInfo.getList() != null && communityFeedInfo.getList().size() != 0))) {
            CommunityChildFragment.Sh(this.this$0).B.g();
            if (this.this$0.Wh() == 1 || this.this$0.Wh() == -1) {
                this.this$0.Vh().clear();
                if (communityFeedInfo.getTopic() != null && communityFeedInfo.getTopic().size() > 0) {
                    CommunityFeedInfo.TopicListBean topicListBean = new CommunityFeedInfo.TopicListBean();
                    topicListBean.setTopic(communityFeedInfo.getTopic());
                    this.this$0.Vh().add(topicListBean);
                }
                if (communityFeedInfo.getList() != null && communityFeedInfo.getList().size() > 0) {
                    this.this$0.Vh().addAll(communityFeedInfo.getList());
                }
            } else {
                if (communityFeedInfo.getTopic() != null && communityFeedInfo.getTopic().size() > 0) {
                    CommunityFeedInfo.TopicListBean topicListBean2 = new CommunityFeedInfo.TopicListBean();
                    topicListBean2.setTopic(communityFeedInfo.getTopic());
                    int i11 = 0;
                    int size = this.this$0.Vh().size();
                    while (true) {
                        if (i11 >= size) {
                            break;
                        } else if (this.this$0.Vh().get(i11) instanceof CommunityFeedInfo.TopicListBean) {
                            this.this$0.Vh().set(i11, topicListBean2);
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                if (communityFeedInfo.getList() != null && communityFeedInfo.getList().size() > 0) {
                    this.this$0.Vh().addAll(communityFeedInfo.getList());
                }
            }
            this.this$0.Th().notifyDataSetChanged();
        } else if (this.this$0.Wh() == 1 || this.this$0.Wh() == -1) {
            CommunityChildFragment.Sh(this.this$0).B.i();
        }
    }
}

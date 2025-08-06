package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class TopicDetailChildFragment$getDynamicListInfo$1 extends Lambda implements l<List<CommunityFeedInfo.ListBean>, Unit> {
    public final /* synthetic */ int $actionType;
    public final /* synthetic */ TopicDetailChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicDetailChildFragment$getDynamicListInfo$1(TopicDetailChildFragment topicDetailChildFragment, int i11) {
        super(1);
        this.this$0 = topicDetailChildFragment;
        this.$actionType = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<CommunityFeedInfo.ListBean>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<CommunityFeedInfo.ListBean> list) {
        TopicDetailChildFragment topicDetailChildFragment = this.this$0;
        int i11 = this.$actionType;
        TopicDetailChildFragment.Th(topicDetailChildFragment).D.finishRefresh();
        TopicDetailChildFragment.Th(topicDetailChildFragment).D.w();
        if (list != null && list.size() > 0) {
            TopicDetailChildFragment.Th(topicDetailChildFragment).C.g();
            MultiTypeAdapter multiTypeAdapter = null;
            if (i11 == 1) {
                topicDetailChildFragment.f17543u.clear();
                topicDetailChildFragment.f17543u.addAll(list);
                MultiTypeAdapter Sh = topicDetailChildFragment.f17544v;
                if (Sh == null) {
                    Sh = null;
                }
                Sh.setItems(topicDetailChildFragment.f17543u);
                MultiTypeAdapter Sh2 = topicDetailChildFragment.f17544v;
                if (Sh2 != null) {
                    multiTypeAdapter = Sh2;
                }
                multiTypeAdapter.notifyDataSetChanged();
            } else {
                int size = topicDetailChildFragment.f17543u.size();
                topicDetailChildFragment.f17543u.addAll(list);
                MultiTypeAdapter Sh3 = topicDetailChildFragment.f17544v;
                if (Sh3 == null) {
                    Sh3 = null;
                }
                Sh3.setItems(topicDetailChildFragment.f17543u);
                MultiTypeAdapter Sh4 = topicDetailChildFragment.f17544v;
                if (Sh4 != null) {
                    multiTypeAdapter = Sh4;
                }
                multiTypeAdapter.notifyItemRangeInserted(size, list.size());
            }
            topicDetailChildFragment.f17541s = ((CommunityFeedInfo.ListBean) CollectionsKt___CollectionsKt.m0(list)).getCreatedTime().longValue();
        } else if (i11 == 2) {
            TopicDetailChildFragment.Th(topicDetailChildFragment).D.setNoMoreData(true);
        } else {
            TopicDetailChildFragment.Th(topicDetailChildFragment).C.i();
        }
        topicDetailChildFragment.sh();
    }
}

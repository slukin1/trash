package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class PersonalCenterChildFragment$getDynamicListInfo$1 extends Lambda implements l<List<CommunityFeedInfo.ListBean>, Unit> {
    public final /* synthetic */ boolean $loadMore;
    public final /* synthetic */ PersonalCenterChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalCenterChildFragment$getDynamicListInfo$1(PersonalCenterChildFragment personalCenterChildFragment, boolean z11) {
        super(1);
        this.this$0 = personalCenterChildFragment;
        this.$loadMore = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<CommunityFeedInfo.ListBean>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<CommunityFeedInfo.ListBean> list) {
        PersonalCenterChildFragment personalCenterChildFragment = this.this$0;
        boolean z11 = this.$loadMore;
        PersonalCenterChildFragment.Th(personalCenterChildFragment).G.finishRefresh();
        PersonalCenterChildFragment.Th(personalCenterChildFragment).G.w();
        if (list != null && list.size() > 0) {
            PersonalCenterChildFragment.Th(personalCenterChildFragment).G.setNoMoreData(list.size() < 20);
            PersonalCenterChildFragment.Th(personalCenterChildFragment).F.g();
            MultiTypeAdapter multiTypeAdapter = null;
            if (!z11) {
                personalCenterChildFragment.f17485t.clear();
                personalCenterChildFragment.f17485t.addAll(list);
                MultiTypeAdapter Sh = personalCenterChildFragment.f17486u;
                if (Sh == null) {
                    Sh = null;
                }
                Sh.setItems(personalCenterChildFragment.f17485t);
                MultiTypeAdapter Sh2 = personalCenterChildFragment.f17486u;
                if (Sh2 != null) {
                    multiTypeAdapter = Sh2;
                }
                multiTypeAdapter.notifyDataSetChanged();
            } else {
                int size = personalCenterChildFragment.f17485t.size();
                personalCenterChildFragment.f17485t.addAll(list);
                MultiTypeAdapter Sh3 = personalCenterChildFragment.f17486u;
                if (Sh3 == null) {
                    Sh3 = null;
                }
                Sh3.setItems(personalCenterChildFragment.f17485t);
                MultiTypeAdapter Sh4 = personalCenterChildFragment.f17486u;
                if (Sh4 != null) {
                    multiTypeAdapter = Sh4;
                }
                multiTypeAdapter.notifyItemRangeInserted(size, list.size());
            }
            personalCenterChildFragment.f17484s = ((CommunityFeedInfo.ListBean) CollectionsKt___CollectionsKt.m0(list)).getCreatedTime().longValue();
        } else if (!z11) {
            PersonalCenterChildFragment.Th(personalCenterChildFragment).F.i();
        }
        personalCenterChildFragment.sh();
    }
}

package com.hbg.module.community.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityViewModel$requestCommunityFeedInfoNew$1 extends Lambda implements l<CommunityFeedInfo, Unit> {
    public final /* synthetic */ int $loadStatus;
    public final /* synthetic */ CommunityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityViewModel$requestCommunityFeedInfoNew$1(int i11, CommunityViewModel communityViewModel) {
        super(1);
        this.$loadStatus = i11;
        this.this$0 = communityViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommunityFeedInfo) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommunityFeedInfo communityFeedInfo) {
        List<CommunityFeedInfo.ListBean> list;
        int i11 = this.$loadStatus;
        boolean z11 = false;
        if (i11 == 1 || i11 == -1) {
            this.this$0.j0().setValue(communityFeedInfo);
            CommunityFeedInfo value = this.this$0.j0().getValue();
            if (!(value == null || (list = value.getList()) == null)) {
                CommunityViewModel communityViewModel = this.this$0;
                if (list.size() > 0) {
                    communityViewModel.f17622h = ((CommunityFeedInfo.ListBean) CollectionsKt___CollectionsKt.m0(list)).getCreatedTime().longValue();
                    communityViewModel.f17623i = ((CommunityFeedInfo.ListBean) CollectionsKt___CollectionsKt.m0(list)).getId();
                } else {
                    communityViewModel.f17622h = 0;
                    communityViewModel.f17623i = 0;
                }
            }
        } else {
            if (communityFeedInfo != null) {
                this.this$0.i0().setValue(communityFeedInfo.getList());
            }
            List value2 = this.this$0.i0().getValue();
            if (value2 != null) {
                CommunityViewModel communityViewModel2 = this.this$0;
                if (!value2.isEmpty()) {
                    communityViewModel2.f17622h = ((CommunityFeedInfo.ListBean) CollectionsKt___CollectionsKt.m0(value2)).getCreatedTime().longValue();
                    communityViewModel2.f17623i = ((CommunityFeedInfo.ListBean) CollectionsKt___CollectionsKt.m0(value2)).getId();
                }
            }
        }
        if (communityFeedInfo == null || communityFeedInfo.getList() == null) {
            this.this$0.n0().setValue(Boolean.FALSE);
            return;
        }
        MutableLiveData<Boolean> n02 = this.this$0.n0();
        List<CommunityFeedInfo.ListBean> list2 = communityFeedInfo.getList();
        if ((list2 != null ? Integer.valueOf(list2.size()) : null).intValue() > 0) {
            z11 = true;
        }
        n02.setValue(Boolean.valueOf(z11));
    }
}

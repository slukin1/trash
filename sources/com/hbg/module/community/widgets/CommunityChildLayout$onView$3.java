package com.hbg.module.community.widgets;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.p;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityChildLayout$onView$3 extends Lambda implements p<Integer, List<? extends CommunityFeedInfo.imgListBean>, Unit> {
    public final /* synthetic */ CommunityChildLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityChildLayout$onView$3(CommunityChildLayout communityChildLayout) {
        super(2);
        this.this$0 = communityChildLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (List<? extends CommunityFeedInfo.imgListBean>) (List) obj2);
        return Unit.f56620a;
    }

    public final void invoke(int i11, List<? extends CommunityFeedInfo.imgListBean> list) {
        p<Integer, List<? extends CommunityFeedInfo.imgListBean>, Unit> onImageClick = this.this$0.getOnImageClick();
        if (onImageClick != null) {
            onImageClick.invoke(Integer.valueOf(i11), list);
        }
    }
}

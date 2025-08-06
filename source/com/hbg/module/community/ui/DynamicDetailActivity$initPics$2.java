package com.hbg.module.community.ui;

import com.hbg.lib.core.util.SaveImageUtils;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.p;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class DynamicDetailActivity$initPics$2 extends Lambda implements p<Integer, List<? extends CommunityFeedInfo.imgListBean>, Unit> {
    public final /* synthetic */ DynamicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDetailActivity$initPics$2(DynamicDetailActivity dynamicDetailActivity) {
        super(2);
        this.this$0 = dynamicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (List<? extends CommunityFeedInfo.imgListBean>) (List) obj2);
        return Unit.f56620a;
    }

    public final void invoke(int i11, List<? extends CommunityFeedInfo.imgListBean> list) {
        CommunityFeedInfo.imgListBean imglistbean;
        if (i11 < (list != null ? list.size() : 0)) {
            SaveImageUtils.h(this.this$0, (list == null || (imglistbean = (CommunityFeedInfo.imgListBean) list.get(i11)) == null) ? null : imglistbean.getImage());
        }
    }
}

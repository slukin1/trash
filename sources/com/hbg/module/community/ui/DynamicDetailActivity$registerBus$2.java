package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import xe.e;

public final class DynamicDetailActivity$registerBus$2 extends Lambda implements l<e, Unit> {
    public final /* synthetic */ DynamicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDetailActivity$registerBus$2(DynamicDetailActivity dynamicDetailActivity) {
        super(1);
        this.this$0 = dynamicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((e) obj);
        return Unit.f56620a;
    }

    public final void invoke(e eVar) {
        DynamicDetailActivity dynamicDetailActivity = this.this$0;
        String b11 = eVar.b();
        DynamicDetailInfo Gh = dynamicDetailActivity.f17332n;
        if (x.b(b11, Gh != null ? Gh.getUidUnique() : null)) {
            DynamicDetailInfo Gh2 = dynamicDetailActivity.f17332n;
            if (Gh2 != null) {
                Gh2.setFocusStatus(eVar.a());
            }
            DynamicDetailInfo Gh3 = dynamicDetailActivity.f17332n;
            int i11 = 0;
            int focusStatus = Gh3 != null ? Gh3.getFocusStatus() : 0;
            DynamicDetailInfo Gh4 = dynamicDetailActivity.f17332n;
            if (Gh4 != null) {
                i11 = Gh4.getIsSelf();
            }
            dynamicDetailActivity.Qi(focusStatus, i11);
        }
    }
}

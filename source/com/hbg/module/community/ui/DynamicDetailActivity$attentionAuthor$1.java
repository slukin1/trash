package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import we.c;

public final class DynamicDetailActivity$attentionAuthor$1 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ DynamicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDetailActivity$attentionAuthor$1(DynamicDetailActivity dynamicDetailActivity) {
        super(1);
        this.this$0 = dynamicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        if (x.b(bool, Boolean.TRUE)) {
            DynamicDetailInfo Gh = this.this$0.f17332n;
            if (Gh != null) {
                Gh.setFocusStatus(1);
            }
            DynamicDetailActivity dynamicDetailActivity = this.this$0;
            DynamicDetailInfo Gh2 = dynamicDetailActivity.f17332n;
            int i11 = 0;
            dynamicDetailActivity.Qi(1, Gh2 != null ? Gh2.getIsSelf() : 0);
            DynamicDetailInfo Gh3 = this.this$0.f17332n;
            String uidUnique = Gh3 != null ? Gh3.getUidUnique() : null;
            if (uidUnique == null) {
                uidUnique = "";
            }
            DynamicDetailInfo Gh4 = this.this$0.f17332n;
            if (Gh4 != null) {
                i11 = Gh4.getFocusStatus();
            }
            c.q(uidUnique, i11);
        }
    }
}

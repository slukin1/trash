package com.hbg.module.content.ui.activity.live;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveDetailActivity$observeUpdateGroupId$1 extends Lambda implements l<String, Unit> {
    public final /* synthetic */ LiveDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$observeUpdateGroupId$1(LiveDetailActivity liveDetailActivity) {
        super(1);
        this.this$0 = liveDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.f56620a;
    }

    public final void invoke(String str) {
        LiveDetailActivity liveDetailActivity = this.this$0;
        liveDetailActivity.zl("setupGroupId('" + str + "')");
        String str2 = this.this$0.Nj() == null ? "gone" : "visible";
        LiveDetailActivity liveDetailActivity2 = this.this$0;
        liveDetailActivity2.zl("integralGetVisible('" + str2 + "')");
    }
}

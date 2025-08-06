package com.hbg.module.content.ui.activity.live;

import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveDetailActivity$getLiveData$1 extends Lambda implements l<LiveDetailBean, Unit> {
    public final /* synthetic */ LiveDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$getLiveData$1(LiveDetailActivity liveDetailActivity) {
        super(1);
        this.this$0 = liveDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LiveDetailBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(LiveDetailBean liveDetailBean) {
        this.this$0.Df();
        LiveDetailActivity.Ki(this.this$0).G0.getRoot().setVisibility(8);
        if (liveDetailBean != null) {
            LiveDetailActivity liveDetailActivity = this.this$0;
            liveDetailActivity.f18466m = liveDetailBean;
            liveDetailActivity.initData();
            liveDetailActivity.Oj();
        }
    }
}

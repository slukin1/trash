package com.hbg.module.content.ui.activity.live;

import com.hbg.lib.network.hbg.core.bean.LiveEndRecommendData;
import com.tencent.imsdk.common.IMLog;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveDetailActivity$initData$1$11$onLiveEndListener$1 extends Lambda implements l<LiveEndRecommendData, Unit> {
    public final /* synthetic */ LiveDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$initData$1$11$onLiveEndListener$1(LiveDetailActivity liveDetailActivity) {
        super(1);
        this.this$0 = liveDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LiveEndRecommendData) obj);
        return Unit.f56620a;
    }

    public final void invoke(LiveEndRecommendData liveEndRecommendData) {
        IMLog.i("hbrecommend", "接口请求成功 开始摆放布局");
        this.this$0.Sl(liveEndRecommendData);
    }
}

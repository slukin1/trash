package com.hbg.module.content.ui.activity.live;

import com.hbg.lib.network.hbg.core.bean.LiveRecommendInfo;
import com.hbg.module.content.custom.LiveRecommendDialog;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveDetailActivity$getRecommendInfo$1 extends Lambda implements l<LiveRecommendInfo, Unit> {
    public final /* synthetic */ Integer $id;
    public final /* synthetic */ int $type;
    public final /* synthetic */ LiveDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$getRecommendInfo$1(LiveDetailActivity liveDetailActivity, Integer num, int i11) {
        super(1);
        this.this$0 = liveDetailActivity;
        this.$id = num;
        this.$type = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LiveRecommendInfo) obj);
        return Unit.f56620a;
    }

    public final void invoke(LiveRecommendInfo liveRecommendInfo) {
        this.this$0.Df();
        if (liveRecommendInfo != null) {
            Integer num = this.$id;
            LiveDetailActivity liveDetailActivity = this.this$0;
            int i11 = this.$type;
            liveRecommendInfo.f70255id = num != null ? num.intValue() : 0;
            LiveRecommendDialog.f18033f.a(liveDetailActivity.getSupportFragmentManager(), liveRecommendInfo, i11, liveDetailActivity.Sj());
        }
    }
}

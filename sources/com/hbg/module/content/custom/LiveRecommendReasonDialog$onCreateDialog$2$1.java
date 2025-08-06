package com.hbg.module.content.custom;

import com.hbg.lib.network.hbg.core.bean.RecommendTrader;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$string;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveRecommendReasonDialog$onCreateDialog$2$1 extends Lambda implements l<RecommendTrader, Unit> {
    public final /* synthetic */ LiveRecommendReasonDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveRecommendReasonDialog$onCreateDialog$2$1(LiveRecommendReasonDialog liveRecommendReasonDialog) {
        super(1);
        this.this$0 = liveRecommendReasonDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecommendTrader) obj);
        return Unit.f56620a;
    }

    public final void invoke(RecommendTrader recommendTrader) {
        HuobiToastUtil.g(R$string.n_content_publish_success);
        LiveDetailActivity liveDetailActivity = (LiveDetailActivity) this.this$0.getActivity();
        if (liveDetailActivity != null) {
            liveDetailActivity.Df();
        }
        RecommendTrader recommendTrader2 = new RecommendTrader();
        recommendTrader2.f70265id = recommendTrader != null ? recommendTrader.f70265id : 0;
        LiveDetailActivity liveDetailActivity2 = (LiveDetailActivity) this.this$0.getActivity();
        if (liveDetailActivity2 != null) {
            liveDetailActivity2.vl(recommendTrader2);
        }
        this.this$0.dismiss();
    }
}

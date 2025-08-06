package com.hbg.module.content.custom;

import com.hbg.lib.network.hbg.core.bean.RecommendTrader;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$string;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveRecommendDialog$onCreateDialog$2$3$1 extends Lambda implements l<Object, Unit> {
    public final /* synthetic */ LiveRecommendDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveRecommendDialog$onCreateDialog$2$3$1(LiveRecommendDialog liveRecommendDialog) {
        super(1);
        this.this$0 = liveRecommendDialog;
    }

    public final void invoke(Object obj) {
        HuobiToastUtil.g(R$string.n_live_recommend_cancel_success);
        LiveDetailActivity liveDetailActivity = (LiveDetailActivity) this.this$0.getActivity();
        if (liveDetailActivity != null) {
            liveDetailActivity.Df();
        }
        LiveDetailActivity liveDetailActivity2 = (LiveDetailActivity) this.this$0.getActivity();
        if (liveDetailActivity2 != null) {
            liveDetailActivity2.vl((RecommendTrader) null);
        }
        this.this$0.dismiss();
    }
}

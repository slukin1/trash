package com.hbg.module.content.custom;

import com.hbg.lib.network.hbg.core.bean.LiveRecommendInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$string;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveRecommendDialog$onCreateDialog$2$3$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ LiveRecommendInfo $this_run;
    public final /* synthetic */ LiveRecommendDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveRecommendDialog$onCreateDialog$2$3$2(LiveRecommendDialog liveRecommendDialog, LiveRecommendInfo liveRecommendInfo) {
        super(2);
        this.this$0 = liveRecommendDialog;
        this.$this_run = liveRecommendInfo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        Unit unit;
        LiveDetailActivity liveDetailActivity = (LiveDetailActivity) this.this$0.getActivity();
        if (liveDetailActivity != null) {
            liveDetailActivity.Df();
        }
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
            unit = Unit.f56620a;
        } else {
            unit = null;
        }
        if (unit == null) {
            HuobiToastUtil.g(R$string.n_service_error);
        }
    }
}

package com.hbg.module.content.custom;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$string;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveRecommendReasonDialog$onCreateDialog$2$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ LiveRecommendReasonDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveRecommendReasonDialog$onCreateDialog$2$2(LiveRecommendReasonDialog liveRecommendReasonDialog) {
        super(2);
        this.this$0 = liveRecommendReasonDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        Unit unit;
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
            unit = Unit.f56620a;
        } else {
            unit = null;
        }
        if (unit == null) {
            HuobiToastUtil.g(R$string.n_content_publish_success);
        }
        LiveDetailActivity liveDetailActivity = (LiveDetailActivity) this.this$0.getActivity();
        if (liveDetailActivity != null) {
            liveDetailActivity.Df();
        }
        this.this$0.dismiss();
    }
}

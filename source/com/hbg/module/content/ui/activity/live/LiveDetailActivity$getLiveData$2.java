package com.hbg.module.content.ui.activity.live;

import android.text.TextUtils;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$string;
import com.hbg.module.huobi.im.utils.LiveErrorCode;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveDetailActivity$getLiveData$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ LiveDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$getLiveData$2(LiveDetailActivity liveDetailActivity) {
        super(2);
        this.this$0 = liveDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        this.this$0.Df();
        LiveDetailActivity.Ki(this.this$0).G0.getRoot().setVisibility(0);
        if (aPIStatusErrorException != null) {
            LiveDetailActivity liveDetailActivity = this.this$0;
            if (TextUtils.equals(aPIStatusErrorException.getErrCode(), String.valueOf(LiveErrorCode.LIVE_USER_ROOM_KICK.getCode()))) {
                HuobiToastUtil.i(liveDetailActivity.getString(R$string.n_live_im_kickout));
                liveDetailActivity.finish();
                return;
            }
            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        }
    }
}

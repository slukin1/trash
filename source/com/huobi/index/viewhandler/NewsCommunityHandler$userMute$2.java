package com.huobi.index.viewhandler;

import android.content.Context;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import pro.huobi.R;

public final class NewsCommunityHandler$userMute$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ NewsCommunityHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsCommunityHandler$userMute$2(NewsCommunityHandler newsCommunityHandler, Context context) {
        super(2);
        this.this$0 = newsCommunityHandler;
        this.$context = context;
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
            HuobiToastUtil.i(this.$context.getResources().getString(R.string.invite_share_fail));
        }
    }
}

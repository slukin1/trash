package com.hbg.module.community.adapter;

import android.content.Context;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$string;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityBaseCommonBinder$userMute$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CommunityBaseCommonBinder<ItemData, SubViewHolder> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityBaseCommonBinder$userMute$2(CommunityBaseCommonBinder<ItemData, SubViewHolder> communityBaseCommonBinder, Context context) {
        super(2);
        this.this$0 = communityBaseCommonBinder;
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
            HuobiToastUtil.i(this.$context.getResources().getString(R$string.invite_share_fail));
        }
    }
}

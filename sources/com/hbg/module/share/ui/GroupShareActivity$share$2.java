package com.hbg.module.share.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.share.R$string;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class GroupShareActivity$share$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ GroupShareActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupShareActivity$share$2(GroupShareActivity groupShareActivity) {
        super(2);
        this.this$0 = groupShareActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        Unit unit;
        this.this$0.Df();
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

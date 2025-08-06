package com.hbg.module.huobi.im.c2c.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CustomerInfoActivity$initView$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ CustomerInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerInfoActivity$initView$2(CustomerInfoActivity customerInfoActivity) {
        super(2);
        this.this$0 = customerInfoActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        this.this$0.Df();
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        }
    }
}

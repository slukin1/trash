package com.huobi.finance.controller;

import com.hbg.lib.network.hbg.core.bean.CTAccountBean;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CTAccountController$requestCTAStatus$1 extends Lambda implements l<CTAccountBean, Unit> {
    public final /* synthetic */ CTAccountController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CTAccountController$requestCTAStatus$1(CTAccountController cTAccountController) {
        super(1);
        this.this$0 = cTAccountController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CTAccountBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(CTAccountBean cTAccountBean) {
        if (cTAccountBean != null) {
            this.this$0.d(cTAccountBean);
        }
    }
}

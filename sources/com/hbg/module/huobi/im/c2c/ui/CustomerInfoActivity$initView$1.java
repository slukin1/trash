package com.hbg.module.huobi.im.c2c.ui;

import com.hbg.lib.network.hbg.core.bean.CustomerInfo;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CustomerInfoActivity$initView$1 extends Lambda implements l<CustomerInfo, Unit> {
    public final /* synthetic */ CustomerInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerInfoActivity$initView$1(CustomerInfoActivity customerInfoActivity) {
        super(1);
        this.this$0 = customerInfoActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomerInfo) obj);
        return Unit.f56620a;
    }

    public final void invoke(CustomerInfo customerInfo) {
        this.this$0.Df();
        if (customerInfo != null) {
            CustomerInfoActivity customerInfoActivity = this.this$0;
            customerInfoActivity.Ch(customerInfo);
            CustomerInfoActivity.yh(customerInfoActivity).M(customerInfo);
        }
    }
}

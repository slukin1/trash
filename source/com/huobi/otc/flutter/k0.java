package com.huobi.otc.flutter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;

public final /* synthetic */ class k0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ APIStatusErrorException f78656b;

    public /* synthetic */ k0(APIStatusErrorException aPIStatusErrorException) {
        this.f78656b = aPIStatusErrorException;
    }

    public final void run() {
        HuobiToastUtil.m(this.f78656b.getErrMsg());
    }
}

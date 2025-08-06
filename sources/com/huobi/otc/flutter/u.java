package com.huobi.otc.flutter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ APIStatusErrorException f78680b;

    public /* synthetic */ u(APIStatusErrorException aPIStatusErrorException) {
        this.f78680b = aPIStatusErrorException;
    }

    public final void run() {
        HuobiToastUtil.m(this.f78680b.getErrMsg());
    }
}

package com.huobi.account.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class y4 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityStrategyController f41862b;

    public /* synthetic */ y4(SecurityStrategyController securityStrategyController) {
        this.f41862b = securityStrategyController;
    }

    public final void call(Object obj) {
        this.f41862b.M((APIStatusErrorException) obj);
    }
}

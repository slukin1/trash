package com.huobi.finance.ui;

import al.p;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import rx.functions.Action1;

public final /* synthetic */ class n1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ n1 f47244b = new n1();

    public final void call(Object obj) {
        ((BalanceProfitLossData) obj).setHideAssetAmount(!p.u());
    }
}

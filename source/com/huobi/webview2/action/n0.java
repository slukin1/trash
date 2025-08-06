package com.huobi.webview2.action;

import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import rx.functions.Func1;

public final /* synthetic */ class n0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ n0 f20852b = new n0();

    public final Object call(Object obj) {
        return Boolean.valueOf(((BaseAssetInfo) obj) instanceof BalanceDetailInfo);
    }
}

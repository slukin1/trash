package com.huobi.finance.ui;

import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import rx.functions.Func1;

public final /* synthetic */ class t4 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ t4 f47334b = new t4();

    public final Object call(Object obj) {
        return Boolean.valueOf(((BaseAssetInfo) obj) instanceof BalanceDetailInfo);
    }
}

package com.huobi.finance.ui;

import android.text.TextUtils;
import com.huobi.finance.bean.BalanceDetailInfo;
import rx.functions.Func1;

public final /* synthetic */ class v implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f47356b;

    public /* synthetic */ v(String str) {
        this.f47356b = str;
    }

    public final Object call(Object obj) {
        return Boolean.valueOf(TextUtils.equals(((BalanceDetailInfo) obj).getCurrency(), this.f47356b));
    }
}

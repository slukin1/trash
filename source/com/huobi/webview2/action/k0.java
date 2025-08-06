package com.huobi.webview2.action;

import android.text.TextUtils;
import com.huobi.finance.bean.BalanceDetailInfo;
import rx.functions.Func1;

public final /* synthetic */ class k0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f20842b;

    public /* synthetic */ k0(String str) {
        this.f20842b = str;
    }

    public final Object call(Object obj) {
        return Boolean.valueOf(TextUtils.equals(((BalanceDetailInfo) obj).getCurrency(), this.f20842b));
    }
}

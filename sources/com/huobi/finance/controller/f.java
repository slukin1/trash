package com.huobi.finance.controller;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import rx.functions.Action1;

public final /* synthetic */ class f implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f45421b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f45422c;

    public /* synthetic */ f(String str, FragmentActivity fragmentActivity) {
        this.f45421b = str;
        this.f45422c = fragmentActivity;
    }

    public final void call(Object obj) {
        DepositWithdrawController.s(this.f45421b, this.f45422c, (CurrencyBean) obj);
    }
}

package com.huobi.finance.controller;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f45419b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f45420c;

    public /* synthetic */ e(String str, FragmentActivity fragmentActivity) {
        this.f45419b = str;
        this.f45420c = fragmentActivity;
    }

    public final void call(Object obj) {
        DepositWithdrawController.q(this.f45419b, this.f45420c, (CurrencyBean) obj);
    }
}

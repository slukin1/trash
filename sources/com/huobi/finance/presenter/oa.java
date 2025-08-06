package com.huobi.finance.presenter;

import com.hbg.lib.network.pro.core.bean.WithdrawRiskInfo;
import rx.functions.Action1;

public final /* synthetic */ class oa implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f46043b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f46044c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f46045d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f46046e;

    public /* synthetic */ oa(UnifyWithdrawPresenter unifyWithdrawPresenter, String str, String str2, String str3) {
        this.f46043b = unifyWithdrawPresenter;
        this.f46044c = str;
        this.f46045d = str2;
        this.f46046e = str3;
    }

    public final void call(Object obj) {
        this.f46043b.K1(this.f46044c, this.f46045d, this.f46046e, (WithdrawRiskInfo) obj);
    }
}

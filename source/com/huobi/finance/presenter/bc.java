package com.huobi.finance.presenter;

import com.hbg.lib.network.pro.core.bean.WithdrawRiskInfo;
import rx.functions.Action1;

public final /* synthetic */ class bc implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WithdrawInfoConfirmPresenter f45824b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f45825c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f45826d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f45827e;

    public /* synthetic */ bc(WithdrawInfoConfirmPresenter withdrawInfoConfirmPresenter, String str, String str2, String str3) {
        this.f45824b = withdrawInfoConfirmPresenter;
        this.f45825c = str;
        this.f45826d = str2;
        this.f45827e = str3;
    }

    public final void call(Object obj) {
        this.f45824b.l0(this.f45825c, this.f45826d, this.f45827e, (WithdrawRiskInfo) obj);
    }
}

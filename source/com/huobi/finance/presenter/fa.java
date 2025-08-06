package com.huobi.finance.presenter;

import com.hbg.lib.widgets.utils.PermissionUtils;

public final /* synthetic */ class fa implements PermissionUtils.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f45882a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f45883b;

    public /* synthetic */ fa(UnifyWithdrawPresenter unifyWithdrawPresenter, String[] strArr) {
        this.f45882a = unifyWithdrawPresenter;
        this.f45883b = strArr;
    }

    public final void onResult(int i11) {
        this.f45882a.J1(this.f45883b, i11);
    }
}

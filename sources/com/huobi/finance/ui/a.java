package com.huobi.finance.ui;

import com.hbg.lib.widgets.utils.PermissionUtils;

public final /* synthetic */ class a implements PermissionUtils.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbsDwActivity f47034a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f47035b;

    public /* synthetic */ a(AbsDwActivity absDwActivity, String[] strArr) {
        this.f47034a = absDwActivity;
        this.f47035b = strArr;
    }

    public final void onResult(int i11) {
        this.f47034a.oj(this.f47035b, i11);
    }
}

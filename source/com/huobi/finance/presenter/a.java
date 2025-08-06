package com.huobi.finance.presenter;

import com.hbg.lib.widgets.utils.PermissionUtils;

public final /* synthetic */ class a implements PermissionUtils.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddVirtualAddressPresenter f45794a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f45795b;

    public /* synthetic */ a(AddVirtualAddressPresenter addVirtualAddressPresenter, String[] strArr) {
        this.f45794a = addVirtualAddressPresenter;
        this.f45795b = strArr;
    }

    public final void onResult(int i11) {
        this.f45794a.C0(this.f45795b, i11);
    }
}

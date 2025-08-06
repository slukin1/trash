package com.huobi.finance.presenter;

import com.huobi.finance.bean.VirtualAddressInfo;
import rx.functions.Action1;

public final /* synthetic */ class k implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddVirtualAddressPresenter f45945b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VirtualAddressInfo f45946c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f45947d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f45948e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f45949f;

    public /* synthetic */ k(AddVirtualAddressPresenter addVirtualAddressPresenter, VirtualAddressInfo virtualAddressInfo, String str, String str2, String str3) {
        this.f45945b = addVirtualAddressPresenter;
        this.f45946c = virtualAddressInfo;
        this.f45947d = str;
        this.f45948e = str2;
        this.f45949f = str3;
    }

    public final void call(Object obj) {
        this.f45945b.y0(this.f45946c, this.f45947d, this.f45948e, this.f45949f, (String) obj);
    }
}

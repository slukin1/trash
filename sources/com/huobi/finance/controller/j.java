package com.huobi.finance.controller;

import java.util.ArrayList;
import rx.functions.Action1;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VirtualAddressProvider f45426b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f45427c;

    public /* synthetic */ j(VirtualAddressProvider virtualAddressProvider, String str) {
        this.f45426b = virtualAddressProvider;
        this.f45427c = str;
    }

    public final void call(Object obj) {
        this.f45426b.g(this.f45427c, (ArrayList) obj);
    }
}

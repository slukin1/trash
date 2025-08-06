package com.huobi.account.ui;

import com.huobi.account.ui.SecurityPasskeyActivity;

public final /* synthetic */ class k1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityPasskeyActivity.e.a f41730b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f41731c;

    public /* synthetic */ k1(SecurityPasskeyActivity.e.a aVar, String str) {
        this.f41730b = aVar;
        this.f41731c = str;
    }

    public final void run() {
        this.f41730b.b(this.f41731c);
    }
}

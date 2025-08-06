package com.huobi.account.ui;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f41813b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f41814c;

    public /* synthetic */ t(MethodChannel.Result result, String str) {
        this.f41813b = result;
        this.f41814c = str;
    }

    public final void run() {
        this.f41813b.success(this.f41814c);
    }
}

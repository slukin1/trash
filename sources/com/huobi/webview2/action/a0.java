package com.huobi.webview2.action;

import com.hbg.lib.core.webview.HBBaseWebActivity;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBBaseWebActivity f20801b;

    public /* synthetic */ a0(HBBaseWebActivity hBBaseWebActivity) {
        this.f20801b = hBBaseWebActivity;
    }

    public final void run() {
        this.f20801b.tryShowCloseButton();
    }
}

package com.huobi.webview2.action;

import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.bean.JsMessage;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBBaseWebActivity f20816b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20817c;

    public /* synthetic */ e0(HBBaseWebActivity hBBaseWebActivity, JsMessage jsMessage) {
        this.f20816b = hBBaseWebActivity;
        this.f20817c = jsMessage;
    }

    public final void run() {
        this.f20816b.showTopBar(this.f20817c);
    }
}

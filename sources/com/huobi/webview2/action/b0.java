package com.huobi.webview2.action;

import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.bean.JsMessage;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBBaseWebActivity f20803b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20804c;

    public /* synthetic */ b0(HBBaseWebActivity hBBaseWebActivity, JsMessage jsMessage) {
        this.f20803b = hBBaseWebActivity;
        this.f20804c = jsMessage;
    }

    public final void run() {
        this.f20803b.customTopBar(this.f20804c);
    }
}

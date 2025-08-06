package com.huobi.webview2.action;

import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.bean.JsMessage;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBBaseWebActivity f20807b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20808c;

    public /* synthetic */ c0(HBBaseWebActivity hBBaseWebActivity, JsMessage jsMessage) {
        this.f20807b = hBBaseWebActivity;
        this.f20808c = jsMessage;
    }

    public final void run() {
        this.f20807b.setTopBarColor(this.f20808c);
    }
}

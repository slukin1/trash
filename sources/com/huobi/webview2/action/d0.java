package com.huobi.webview2.action;

import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.bean.JsMessage;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBBaseWebActivity f20811b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20812c;

    public /* synthetic */ d0(HBBaseWebActivity hBBaseWebActivity, JsMessage jsMessage) {
        this.f20811b = hBBaseWebActivity;
        this.f20812c = jsMessage;
    }

    public final void run() {
        this.f20811b.updateTopBarFunction(this.f20812c);
    }
}

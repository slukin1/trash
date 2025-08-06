package com.huobi.webview2.action;

import com.hbg.lib.core.webview.bean.JsMessage;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20802b;

    public /* synthetic */ b(JsMessage jsMessage) {
        this.f20802b = jsMessage;
    }

    public final void run() {
        JsBusinessActionHelper.lambda$tradingBotShare$13(this.f20802b);
    }
}

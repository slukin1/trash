package com.huobi.webview2.action;

import com.hbg.lib.core.webview.bean.JsMessage;
import v6.u;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20809b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ u f20810c;

    public /* synthetic */ d(JsMessage jsMessage, u uVar) {
        this.f20809b = jsMessage;
        this.f20810c = uVar;
    }

    public final void run() {
        JsBusinessActionHelper.lambda$tradingBotFilterDialog$12(this.f20809b, this.f20810c);
    }
}

package com.huobi.webview2.action;

import com.hbg.lib.core.webview.bean.JsMessage;
import v6.u;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20805b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ u f20806c;

    public /* synthetic */ c(JsMessage jsMessage, u uVar) {
        this.f20805b = jsMessage;
        this.f20806c = uVar;
    }

    public final void run() {
        JsBusinessActionHelper.lambda$dealWithKyc$14(this.f20805b, this.f20806c);
    }
}

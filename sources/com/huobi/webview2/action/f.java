package com.huobi.webview2.action;

import com.hbg.lib.core.webview.bean.JsMessage;
import com.huobi.account.entity.H5SelectWidgetData;
import v6.u;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ H5SelectWidgetData f20818b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20819c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u f20820d;

    public /* synthetic */ f(H5SelectWidgetData h5SelectWidgetData, JsMessage jsMessage, u uVar) {
        this.f20818b = h5SelectWidgetData;
        this.f20819c = jsMessage;
        this.f20820d = uVar;
    }

    public final void run() {
        JsBusinessActionHelper.lambda$jumpSelectWidget$1(this.f20818b, this.f20819c, this.f20820d);
    }
}

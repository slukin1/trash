package com.huobi.webview2.action;

import com.hbg.lib.core.webview.bean.JsMessage;
import v6.t;
import v6.u;

public final /* synthetic */ class o implements t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20853a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f20854b;

    public /* synthetic */ o(JsMessage jsMessage, u uVar) {
        this.f20853a = jsMessage;
        this.f20854b = uVar;
    }

    public final void onResume() {
        JsBusinessActionHelper.backToH5(this.f20853a, this.f20854b);
    }
}

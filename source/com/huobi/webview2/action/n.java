package com.huobi.webview2.action;

import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.bean.JsMessage;
import sm.a;

public final /* synthetic */ class n implements a.C0821a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HBBaseWebActivity f20849a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20850b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f20851c;

    public /* synthetic */ n(HBBaseWebActivity hBBaseWebActivity, JsMessage jsMessage, String str) {
        this.f20849a = hBBaseWebActivity;
        this.f20850b = jsMessage;
        this.f20851c = str;
    }

    public final void a(boolean z11, String str, String str2) {
        JsBusinessActionHelper.postHuaweiLivenessResult(this.f20849a, this.f20850b, this.f20851c, z11, str, str2);
    }
}

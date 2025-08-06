package com.huobi.webview2.action;

import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.bean.JsMessage;
import sm.a;

public final /* synthetic */ class m implements a.C0821a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HBBaseWebActivity f20845a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20846b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f20847c;

    public /* synthetic */ m(HBBaseWebActivity hBBaseWebActivity, JsMessage jsMessage, String str) {
        this.f20845a = hBBaseWebActivity;
        this.f20846b = jsMessage;
        this.f20847c = str;
    }

    public final void a(boolean z11, String str, String str2) {
        JsBusinessActionHelper.postHuaweiLivenessResult(this.f20845a, this.f20846b, this.f20847c, z11, str, str2);
    }
}

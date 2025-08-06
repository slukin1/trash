package com.huobi.webview2.action;

import tu.a;
import v6.u;

public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f20835b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f20836c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f20837d;

    public /* synthetic */ i0(u uVar, String str, a aVar) {
        this.f20835b = uVar;
        this.f20836c = str;
        this.f20837d = aVar;
    }

    public final void run() {
        JsCommonActionHelper.loadBase64Image(this.f20835b, this.f20836c, this.f20837d);
    }
}

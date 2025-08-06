package com.huobi.webview2.action;

import com.hbg.lib.core.webview.bean.JsMessage;
import com.huobi.entity.PlatformInfo;
import v6.u;

public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f20829b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlatformInfo f20830c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20831d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f20832e;

    public /* synthetic */ h0(u uVar, PlatformInfo platformInfo, JsMessage jsMessage, String str) {
        this.f20829b = uVar;
        this.f20830c = platformInfo;
        this.f20831d = jsMessage;
        this.f20832e = str;
    }

    public final void run() {
        JsCommonActionHelper.lambda$dealWithBasePlatformInfo$3(this.f20829b, this.f20830c, this.f20831d, this.f20832e);
    }
}

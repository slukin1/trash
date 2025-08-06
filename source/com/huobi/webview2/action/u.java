package com.huobi.webview2.action;

import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.network.newkyc.bean.KycSDKTokenInfo;
import d10.l;

public final /* synthetic */ class u implements l {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20877b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KycSDKTokenInfo f20878c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ v6.u f20879d;

    public /* synthetic */ u(JsMessage jsMessage, KycSDKTokenInfo kycSDKTokenInfo, v6.u uVar) {
        this.f20877b = jsMessage;
        this.f20878c = kycSDKTokenInfo;
        this.f20879d = uVar;
    }

    public final Object invoke(Object obj) {
        return JsBusinessActionHelper.lambda$realJumpJumioLiveness$8(this.f20877b, this.f20878c, this.f20879d, (String) obj);
    }
}

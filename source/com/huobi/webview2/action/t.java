package com.huobi.webview2.action;

import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.network.newkyc.bean.KycSDKTokenInfo;
import d10.l;
import v6.u;

public final /* synthetic */ class t implements l {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20873b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KycSDKTokenInfo f20874c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u f20875d;

    public /* synthetic */ t(JsMessage jsMessage, KycSDKTokenInfo kycSDKTokenInfo, u uVar) {
        this.f20873b = jsMessage;
        this.f20874c = kycSDKTokenInfo;
        this.f20875d = uVar;
    }

    public final Object invoke(Object obj) {
        return JsBusinessActionHelper.lambda$realJumpSumsubLiveness$7(this.f20873b, this.f20874c, this.f20875d, (String) obj);
    }
}

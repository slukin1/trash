package com.huobi.webview2.action;

import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import rx.functions.Action1;
import v6.u;

public final /* synthetic */ class s0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f20871b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f20872c;

    public /* synthetic */ s0(u uVar, String str) {
        this.f20871b = uVar;
        this.f20872c = str;
    }

    public final void call(Object obj) {
        JsOtcActionHelper.lambda$getProTokenFromH5$2(this.f20871b, this.f20872c, (ProUserToken) obj);
    }
}

package com.huobi.webview2.action;

import com.hbg.lib.network.otc.core.bean.UserVO;
import rx.functions.Action1;
import v6.u;

public final /* synthetic */ class r0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f20867b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f20868c;

    public /* synthetic */ r0(u uVar, String str) {
        this.f20867b = uVar;
        this.f20868c = str;
    }

    public final void call(Object obj) {
        JsOtcActionHelper.lambda$getOtcTokenFromH5$0(this.f20867b, this.f20868c, (UserVO) obj);
    }
}

package com.huobi.webview2.action;

import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.network.newkyc.bean.KycTicketInfo;
import d10.l;
import v6.u;

public final /* synthetic */ class v implements l {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20882b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KycTicketInfo f20883c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u f20884d;

    public /* synthetic */ v(JsMessage jsMessage, KycTicketInfo kycTicketInfo, u uVar) {
        this.f20882b = jsMessage;
        this.f20883c = kycTicketInfo;
        this.f20884d = uVar;
    }

    public final Object invoke(Object obj) {
        return JsBusinessActionHelper.lambda$jumpJumioLiveness$5(this.f20882b, this.f20883c, this.f20884d, (String) obj);
    }
}

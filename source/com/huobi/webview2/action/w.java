package com.huobi.webview2.action;

import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.network.newkyc.bean.KycTicketInfo;
import d10.l;
import v6.u;

public final /* synthetic */ class w implements l {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20885b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KycTicketInfo f20886c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u f20887d;

    public /* synthetic */ w(JsMessage jsMessage, KycTicketInfo kycTicketInfo, u uVar) {
        this.f20885b = jsMessage;
        this.f20886c = kycTicketInfo;
        this.f20887d = uVar;
    }

    public final Object invoke(Object obj) {
        return JsBusinessActionHelper.lambda$jumpSumsubLiveness$4(this.f20885b, this.f20886c, this.f20887d, (String) obj);
    }
}

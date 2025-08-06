package com.huobi.webview2.action;

import com.hbg.lib.core.webview.bean.JsMessage;
import com.huobi.account.entity.ChooseListData;
import v6.u;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseListData f20813b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20814c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u f20815d;

    public /* synthetic */ e(ChooseListData chooseListData, JsMessage jsMessage, u uVar) {
        this.f20813b = chooseListData;
        this.f20814c = jsMessage;
        this.f20815d = uVar;
    }

    public final void run() {
        JsBusinessActionHelper.lambda$dealWithTurkeyKycDialog$3(this.f20813b, this.f20814c, this.f20815d);
    }
}

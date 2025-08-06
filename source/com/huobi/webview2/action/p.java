package com.huobi.webview2.action;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.core.webview.bean.JsMessage;
import v6.u;

public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f20856b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20857c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u f20858d;

    public /* synthetic */ p(Dialog dialog, JsMessage jsMessage, u uVar) {
        this.f20856b = dialog;
        this.f20857c = jsMessage;
        this.f20858d = uVar;
    }

    public final void onClick(View view) {
        JsBusinessActionHelper.lambda$picChoose$16(this.f20856b, this.f20857c, this.f20858d, view);
    }
}

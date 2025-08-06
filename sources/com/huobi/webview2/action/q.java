package com.huobi.webview2.action;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.core.webview.bean.JsMessage;
import v6.u;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f20860b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20861c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u f20862d;

    public /* synthetic */ q(Dialog dialog, JsMessage jsMessage, u uVar) {
        this.f20860b = dialog;
        this.f20861c = jsMessage;
        this.f20862d = uVar;
    }

    public final void onClick(View view) {
        JsBusinessActionHelper.lambda$picChoose$15(this.f20860b, this.f20861c, this.f20862d, view);
    }
}

package com.huobi.view;

import android.app.Dialog;
import android.view.View;

public final /* synthetic */ class c1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f19006b;

    public /* synthetic */ c1(Dialog dialog) {
        this.f19006b = dialog;
    }

    public final void onClick(View view) {
        OtcDialogUtils.lambda$showOtcOrderWithdrawDialog$3(this.f19006b, view);
    }
}

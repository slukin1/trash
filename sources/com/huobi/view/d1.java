package com.huobi.view;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class d1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f19021b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.f f19022c;

    public /* synthetic */ d1(Dialog dialog, DialogUtils.b.f fVar) {
        this.f19021b = dialog;
        this.f19022c = fVar;
    }

    public final void onClick(View view) {
        OtcDialogUtils.lambda$showOtcOrderWithdrawDialog$4(this.f19021b, this.f19022c, view);
    }
}

package com.huobi.view;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class f1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.f f19031b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f19032c;

    public /* synthetic */ f1(DialogUtils.b.f fVar, Dialog dialog) {
        this.f19031b = fVar;
        this.f19032c = dialog;
    }

    public final void onClick(View view) {
        OtcDialogUtils.lambda$showAbandonOrderDialog$2(this.f19031b, this.f19032c, view);
    }
}

package com.huobi.view;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class g1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.f f19037b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f19038c;

    public /* synthetic */ g1(DialogUtils.b.f fVar, Dialog dialog) {
        this.f19037b = fVar;
        this.f19038c = dialog;
    }

    public final void onClick(View view) {
        OtcDialogUtils.lambda$showAbandonOrderDialog$1(this.f19037b, this.f19038c, view);
    }
}

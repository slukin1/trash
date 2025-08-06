package com.huobi.view.pickerview;

import android.content.DialogInterface;

public final /* synthetic */ class a implements DialogInterface.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BasePickerView f19089b;

    public /* synthetic */ a(BasePickerView basePickerView) {
        this.f19089b = basePickerView;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f19089b.lambda$createDialog$4(dialogInterface);
    }
}

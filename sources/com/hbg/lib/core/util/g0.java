package com.hbg.lib.core.util;

import android.app.Activity;
import android.content.DialogInterface;

public final /* synthetic */ class g0 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f68705b;

    public /* synthetic */ g0(Activity activity) {
        this.f68705b = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        SaveImageUtils.d(this.f68705b, dialogInterface, i11);
    }
}

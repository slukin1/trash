package com.tencent.qcloud.tuicore.permission;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;

public final /* synthetic */ class b implements DialogInterface.OnKeyListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f48156b;

    public /* synthetic */ b(Dialog dialog) {
        this.f48156b = dialog;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        return PermissionActivity.lambda$showSettingsTip$3(this.f48156b, dialogInterface, i11, keyEvent);
    }
}

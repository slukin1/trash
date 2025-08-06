package com.tencent.qcloud.tuicore.permission;

import android.content.DialogInterface;

public final /* synthetic */ class a implements DialogInterface.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PermissionActivity f48155b;

    public /* synthetic */ a(PermissionActivity permissionActivity) {
        this.f48155b = permissionActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f48155b.lambda$showSettingsTip$0(dialogInterface);
    }
}

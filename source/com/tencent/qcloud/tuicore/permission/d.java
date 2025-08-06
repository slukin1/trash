package com.tencent.qcloud.tuicore.permission;

import android.app.Dialog;
import android.view.View;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PermissionActivity f48158b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f48159c;

    public /* synthetic */ d(PermissionActivity permissionActivity, Dialog dialog) {
        this.f48158b = permissionActivity;
        this.f48159c = dialog;
    }

    public final void onClick(View view) {
        this.f48158b.lambda$showSettingsTip$1(this.f48159c, view);
    }
}

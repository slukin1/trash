package com.tencent.qcloud.tuicore.permission;

import android.app.Dialog;
import android.view.View;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f48157b;

    public /* synthetic */ c(Dialog dialog) {
        this.f48157b = dialog;
    }

    public final void onClick(View view) {
        PermissionActivity.lambda$showSettingsTip$2(this.f48157b, view);
    }
}

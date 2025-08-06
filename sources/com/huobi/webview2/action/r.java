package com.huobi.webview2.action;

import androidx.activity.result.ActivityResultLauncher;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.utils.PermissionUtils;

public final /* synthetic */ class r implements PermissionUtils.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HBBaseWebActivity f20865a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActivityResultLauncher f20866b;

    public /* synthetic */ r(HBBaseWebActivity hBBaseWebActivity, ActivityResultLauncher activityResultLauncher) {
        this.f20865a = hBBaseWebActivity;
        this.f20866b = activityResultLauncher;
    }

    public final void onResult(int i11) {
        JsBusinessActionHelper.lambda$actionScanQR$22(this.f20865a, this.f20866b, i11);
    }
}

package com.tencent.qcloud.tuicore.permission;

import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import java.util.Map;

public final /* synthetic */ class e implements ITUINotification {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PermissionRequester f48160b;

    public /* synthetic */ e(PermissionRequester permissionRequester) {
        this.f48160b = permissionRequester;
    }

    public final void onNotifyEvent(String str, String str2, Map map) {
        this.f48160b.lambda$new$0(str, str2, map);
    }
}

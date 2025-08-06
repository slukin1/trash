package com.tencent.qcloud.tuicore.permission;

public abstract class PermissionCallback {
    public void onDenied() {
    }

    public abstract void onGranted();
}

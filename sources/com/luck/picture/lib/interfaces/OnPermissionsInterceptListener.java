package com.luck.picture.lib.interfaces;

import androidx.fragment.app.Fragment;

public interface OnPermissionsInterceptListener {
    boolean hasPermissions(Fragment fragment, String[] strArr);

    void requestPermission(Fragment fragment, String[] strArr, OnRequestPermissionListener onRequestPermissionListener);
}

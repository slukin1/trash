package com.luck.picture.lib.interfaces;

import androidx.fragment.app.Fragment;

public interface OnPermissionDeniedListener {
    void onDenied(Fragment fragment, String[] strArr, int i11, OnCallbackListener<Boolean> onCallbackListener);
}

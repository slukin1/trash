package com.huobi.framework.im.common;

import android.app.Activity;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.permissions.PermissionConfig;
import java.util.ArrayList;

public final class PermissionUtils {
    public static final PermissionUtils INSTANCE = new PermissionUtils();
    public static final int REQ_PERMISSION_CODE = 256;
    private static final String TAG = PermissionUtils.class.getSimpleName();

    private PermissionUtils() {
    }

    public final boolean checkPermission(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        ImManager imManager = ImManager.INSTANCE;
        if (ContextCompat.checkSelfPermission(imManager.getAppContext(), PermissionConfig.WRITE_EXTERNAL_STORAGE) != 0) {
            arrayList.add(PermissionConfig.WRITE_EXTERNAL_STORAGE);
        }
        if (ContextCompat.checkSelfPermission(imManager.getAppContext(), "android.permission.CAMERA") != 0) {
            arrayList.add("android.permission.CAMERA");
        }
        if (ContextCompat.checkSelfPermission(imManager.getAppContext(), "android.permission.RECORD_AUDIO") != 0) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (ContextCompat.checkSelfPermission(imManager.getAppContext(), "android.permission.READ_PHONE_STATE") != 0) {
            arrayList.add("android.permission.READ_PHONE_STATE");
        }
        if (ContextCompat.checkSelfPermission(imManager.getAppContext(), PermissionConfig.READ_EXTERNAL_STORAGE) != 0) {
            arrayList.add(PermissionConfig.READ_EXTERNAL_STORAGE);
        }
        if (arrayList.size() == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(activity, (String[]) arrayList.toArray(new String[0]), 256);
        return false;
    }
}

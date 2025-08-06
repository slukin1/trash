package com.luck.picture.lib.permissions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class PermissionUtil {
    public static final String ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION = "android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION";

    public static void goIntentSetting(Fragment fragment, int i11) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", fragment.getActivity().getPackageName(), (String) null));
            fragment.startActivityForResult(intent, i11);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static boolean hasPermissions(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String checkSelfPermission : strArr) {
            if (ContextCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllGranted(int[] iArr) {
        if (iArr.length <= 0) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 != 0) {
                return false;
            }
        }
        return true;
    }
}

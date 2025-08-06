package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Arrays;

final class ImagePickerUtils {
    private static boolean isPermissionPresentInManifest(Context context, String str) {
        try {
            return Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions).contains(str);
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean needRequestCameraPermission(Context context) {
        if (!(Build.VERSION.SDK_INT >= 23) || !isPermissionPresentInManifest(context, "android.permission.CAMERA")) {
            return false;
        }
        return true;
    }
}

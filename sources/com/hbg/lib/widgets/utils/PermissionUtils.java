package com.hbg.lib.widgets.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.luck.picture.lib.permissions.PermissionConfig;
import oa.g;
import oa.h;
import oa.i;

public class PermissionUtils {

    public interface a {
        void onResult(int i11);
    }

    public static void g(Activity activity, a aVar) {
        h(activity, aVar, false);
    }

    public static void h(Activity activity, a aVar, boolean z11) {
        int i11;
        boolean z12;
        String[] strArr;
        int checkSelfPermission = ContextCompat.checkSelfPermission(activity, "android.permission.CAMERA");
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 33) {
            i11 = ContextCompat.checkSelfPermission(activity, PermissionConfig.READ_MEDIA_IMAGES);
        } else {
            i11 = ContextCompat.checkSelfPermission(activity, PermissionConfig.READ_EXTERNAL_STORAGE);
        }
        if (checkSelfPermission == 0 && i11 == 0) {
            aVar.onResult(0);
            return;
        }
        boolean shouldShowRequestPermissionRationale = ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.CAMERA");
        if (i12 >= 33) {
            z12 = ActivityCompat.shouldShowRequestPermissionRationale(activity, PermissionConfig.READ_MEDIA_IMAGES);
        } else {
            z12 = ActivityCompat.shouldShowRequestPermissionRationale(activity, PermissionConfig.READ_EXTERNAL_STORAGE);
        }
        if (shouldShowRequestPermissionRationale || z12) {
            activity.runOnUiThread(new g(activity));
            aVar.onResult(1);
            return;
        }
        if (z11) {
            if (i12 >= 33) {
                strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
            } else {
                strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE, PermissionConfig.READ_EXTERNAL_STORAGE};
            }
            ActivityCompat.requestPermissions(activity, strArr, 0);
        }
        aVar.onResult(2);
    }

    public static int i(Activity activity) {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.READ_EXTERNAL_STORAGE;
        if (ContextCompat.checkSelfPermission(activity, str) == 0) {
            return 0;
        }
        if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
            return 2;
        }
        activity.runOnUiThread(new i(activity));
        return 1;
    }

    public static int j(Activity activity) {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.WRITE_EXTERNAL_STORAGE;
        if (ContextCompat.checkSelfPermission(activity, str) == 0) {
            return 0;
        }
        if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
            return 2;
        }
        activity.runOnUiThread(new h(activity));
        return 1;
    }

    public static /* synthetic */ void k(Activity activity, HBDialogFragment hBDialogFragment) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
        activity.startActivity(intent);
        hBDialogFragment.dismiss();
    }

    public static /* synthetic */ void m(Activity activity, HBDialogFragment hBDialogFragment) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
        activity.startActivity(intent);
        hBDialogFragment.dismiss();
    }

    public static /* synthetic */ void o(Activity activity, HBDialogFragment hBDialogFragment) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
        activity.startActivity(intent);
        hBDialogFragment.dismiss();
    }
}

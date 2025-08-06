package com.tencent.qcloud.tuikit.tuichat.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;
import java.util.ArrayList;

public class PermissionUtils {
    public static final int REQ_PERMISSION_CODE = 256;
    private static final String TAG = "PermissionUtils";

    public static boolean checkPermission(Context context, String str) {
        String str2 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("checkPermission permission:");
        sb2.append(str);
        sb2.append("|sdk:");
        int i11 = Build.VERSION.SDK_INT;
        sb2.append(i11);
        Log.i(str2, sb2.toString());
        if (i11 < 23 || ContextCompat.checkSelfPermission(context, str) == 0) {
            return true;
        }
        showPermissionDialog(context);
        return false;
    }

    private static void showPermissionDialog(final Context context) {
        new AlertDialog.Builder(context).setMessage(ServiceInitializer.getAppContext().getString(R.string.permission_content)).setPositiveButton(ServiceInitializer.getAppContext().getString(R.string.setting), new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                dialogInterface.cancel();
                context.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName())));
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        }).setNegativeButton(ServiceInitializer.getAppContext().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                dialogInterface.cancel();
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        }).create().show();
    }

    public static boolean checkPermission(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        if (ContextCompat.checkSelfPermission(activity, PermissionConfig.WRITE_EXTERNAL_STORAGE) != 0) {
            arrayList.add(PermissionConfig.WRITE_EXTERNAL_STORAGE);
        }
        if (ContextCompat.checkSelfPermission(activity, "android.permission.CAMERA") != 0) {
            arrayList.add("android.permission.CAMERA");
        }
        if (ContextCompat.checkSelfPermission(activity, "android.permission.RECORD_AUDIO") != 0) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (ContextCompat.checkSelfPermission(activity, "android.permission.READ_PHONE_STATE") != 0) {
            arrayList.add("android.permission.READ_PHONE_STATE");
        }
        if (ContextCompat.checkSelfPermission(activity, PermissionConfig.READ_EXTERNAL_STORAGE) != 0) {
            arrayList.add(PermissionConfig.READ_EXTERNAL_STORAGE);
        }
        if (ContextCompat.checkSelfPermission(activity, PermissionConfig.READ_MEDIA_IMAGES) != 0) {
            arrayList.add(PermissionConfig.READ_MEDIA_IMAGES);
        }
        if (ContextCompat.checkSelfPermission(activity, PermissionConfig.READ_MEDIA_AUDIO) != 0) {
            arrayList.add(PermissionConfig.READ_MEDIA_AUDIO);
        }
        if (ContextCompat.checkSelfPermission(activity, PermissionConfig.READ_MEDIA_VIDEO) != 0) {
            arrayList.add(PermissionConfig.READ_MEDIA_VIDEO);
        }
        if (arrayList.size() == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(activity, (String[]) arrayList.toArray(new String[0]), 256);
        return false;
    }
}

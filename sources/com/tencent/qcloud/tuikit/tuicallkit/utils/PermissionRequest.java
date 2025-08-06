package com.tencent.qcloud.tuikit.tuicallkit.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.qcloud.tuicore.permission.PermissionCallback;
import com.tencent.qcloud.tuicore.permission.PermissionRequester;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.utils.BrandUtils;
import com.tencent.qcloud.tuikit.tuicallengine.utils.PermissionUtils;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import java.util.ArrayList;

public class PermissionRequest {
    public static void requestFloatPermission(Context context) {
        if (!PermissionUtils.hasPermission(context)) {
            if (BrandUtils.isBrandVivo()) {
                requestVivoFloatPermission(context);
            } else {
                startCommonSettings(context);
            }
        }
    }

    public static void requestPermissions(Context context, TUICallDefine.MediaType mediaType, PermissionCallback permissionCallback) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getString(R.string.tuicalling_permission_microphone));
        StringBuilder sb3 = new StringBuilder();
        sb3.append(context.getString(R.string.tuicalling_permission_mic_reason));
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.RECORD_AUDIO");
        if (TUICallDefine.MediaType.Video.equals(mediaType)) {
            sb2.append(context.getString(R.string.tuicalling_permission_separator));
            sb2.append(context.getString(R.string.tuicalling_permission_camera));
            sb3.append(context.getString(R.string.tuicalling_permission_camera_reason));
            arrayList.add("android.permission.CAMERA");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            sb2.append(context.getString(R.string.tuicalling_permission_separator));
            sb2.append(context.getString(R.string.tuicalling_permission_bluetooth));
            sb3.append(context.getString(R.string.tuicalling_permission_bluetooth_reason));
            arrayList.add("android.permission.BLUETOOTH_CONNECT");
        }
        String charSequence = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
        PermissionRequester.newInstance((String[]) arrayList.toArray(new String[0])).title(context.getString(R.string.tuicalling_permission_title, new Object[]{charSequence, sb2})).description(sb3.toString()).settingsTip(context.getString(R.string.tuicalling_permission_tips, new Object[]{sb2})).callback(permissionCallback).request();
    }

    private static void requestVivoFloatPermission(Context context) {
        Intent intent = new Intent();
        String model = BrandUtils.getModel();
        boolean z11 = false;
        if (!TextUtils.isEmpty(model) && model.contains("Y85") && !model.contains("Y85A")) {
            z11 = true;
        }
        if (TextUtils.isEmpty(model) || (!z11 && !model.contains("vivo Y53L"))) {
            intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
            intent.setAction("secure.intent.action.softPermissionDetail");
        } else {
            intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.PurviewTabActivity");
            intent.putExtra("tabId", "1");
        }
        intent.putExtra("packagename", context.getPackageName());
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void startCommonSettings(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }
}

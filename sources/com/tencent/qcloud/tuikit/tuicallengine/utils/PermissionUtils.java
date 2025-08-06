package com.tencent.qcloud.tuikit.tuicallengine.utils;

import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import com.tencent.imsdk.BaseConstants;
import java.lang.reflect.Method;

public class PermissionUtils {
    @Deprecated
    public static boolean hasPermission(Context context) {
        if (BrandUtils.isBrandXiaoMi()) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 23) {
                return Settings.canDrawOverlays(context);
            }
            if (i11 >= 19) {
                return isXiaomiBgStartPermissionAllowed(context);
            }
            return true;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 23) {
            return Settings.canDrawOverlays(context);
        }
        if (i12 >= 19) {
            return hasPermissionBelowMarshmallow(context);
        }
        return true;
    }

    private static boolean hasPermissionBelowMarshmallow(Context context) {
        try {
            AppOpsManager appOpsManager = Build.VERSION.SDK_INT >= 19 ? (AppOpsManager) context.getSystemService("appops") : null;
            if (appOpsManager == null) {
                return false;
            }
            Class<AppOpsManager> cls = AppOpsManager.class;
            Class cls2 = Integer.TYPE;
            if (((Integer) cls.getMethod("checkOp", new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{24, Integer.valueOf(Binder.getCallingUid()), context.getApplicationContext().getPackageName()})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean isVivoBgStartPermissionAllowed(Context context) {
        try {
            Uri parse = Uri.parse("content://com.vivo.permissionmanager.provider.permission/start_bg_activity");
            ContentResolver contentResolver = context.getContentResolver();
            Cursor query = contentResolver.query(parse, (String[]) null, "pkgname = ?", new String[]{context.getPackageName()}, (String) null);
            if (!query.moveToFirst() || query.getInt(query.getColumnIndex("currentstate")) != 0) {
                return false;
            }
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return false;
    }

    private static boolean isXiaomiBgStartPermissionAllowed(Context context) {
        try {
            AppOpsManager appOpsManager = Build.VERSION.SDK_INT >= 19 ? (AppOpsManager) context.getSystemService("appops") : null;
            if (appOpsManager == null) {
                return false;
            }
            Class<?> cls = appOpsManager.getClass();
            Class cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class});
            method.setAccessible(true);
            if (((Integer) method.invoke(appOpsManager, new Object[]{Integer.valueOf(BaseConstants.ERR_SVR_GROUP_GROUPID_IN_USED), Integer.valueOf(Process.myUid()), context.getPackageName()})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }
}

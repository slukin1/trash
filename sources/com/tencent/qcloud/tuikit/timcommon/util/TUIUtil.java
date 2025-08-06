package com.tencent.qcloud.tuikit.timcommon.util;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.R;
import java.lang.reflect.Method;

public class TUIUtil {
    private static String currentProcessName = "";

    public static int getDefaultGroupIconResIDByGroupType(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return R.drawable.core_default_group_icon_community;
        }
        if (TextUtils.equals(str, "Work")) {
            return TUIThemeManager.getAttrResId(context, R.attr.core_default_group_icon_work);
        }
        if (TextUtils.equals(str, "Meeting")) {
            return TUIThemeManager.getAttrResId(context, R.attr.core_default_group_icon_meeting);
        }
        if (TextUtils.equals(str, "Public")) {
            return TUIThemeManager.getAttrResId(context, R.attr.core_default_group_icon_public);
        }
        if (TextUtils.equals(str, "Community")) {
            return TUIThemeManager.getAttrResId(context, R.attr.core_default_group_icon_community);
        }
        return R.drawable.core_default_group_icon_community;
    }

    public static String getProcessName() {
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            String processName = Application.getProcessName();
            currentProcessName = processName;
            return processName;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            if (invoke instanceof String) {
                currentProcessName = (String) invoke;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return currentProcessName;
    }
}

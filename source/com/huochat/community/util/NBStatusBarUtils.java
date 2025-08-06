package com.huochat.community.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class NBStatusBarUtils {
    private static final int STATUSBAR_TYPE_ANDROID6 = 3;
    private static final int STATUSBAR_TYPE_DEFAULT = 0;
    private static final int STATUSBAR_TYPE_FLYME = 2;
    private static final int STATUSBAR_TYPE_MIUI = 1;
    private static final int STATUS_BAR_DEFAULT_HEIGHT_DP = 25;
    private static int mStatuBarType = 0;
    private static int sStatusbarHeight = -1;
    private static Integer sTransparentValue = null;
    public static float sVirtualDensity = -1.0f;
    public static float sVirtualDensityDpi = -1.0f;

    @Retention(RetentionPolicy.SOURCE)
    public @interface StatusBarType {
    }

    @TargetApi(23)
    private static boolean Android6SetStatusBarLightMode(Window window, boolean z11) {
        window.getDecorView().setSystemUiVisibility(changeStatusBarModeRetainFlag(window, z11 ? 8192 : 256));
        if (!NBDeviceHelper.isMIUIV9()) {
            return true;
        }
        MIUISetStatusBarLightMode(window, z11);
        return true;
    }

    public static boolean FlymeSetStatusBarLightMode(Window window, boolean z11) {
        if (window != null) {
            Android6SetStatusBarLightMode(window, z11);
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i11 = declaredField.getInt((Object) null);
                int i12 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z11 ? i12 | i11 : (~i11) & i12);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean MIUISetStatusBarLightMode(Window window, boolean z11) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i11 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Class cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", new Class[]{cls3, cls3});
                if (z11) {
                    method.invoke(window, new Object[]{Integer.valueOf(i11), Integer.valueOf(i11)});
                    return true;
                }
                method.invoke(window, new Object[]{0, Integer.valueOf(i11)});
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @TargetApi(23)
    private static int changeStatusBarModeRetainFlag(Window window, int i11) {
        return retainSystemUiFlag(window, retainSystemUiFlag(window, retainSystemUiFlag(window, retainSystemUiFlag(window, retainSystemUiFlag(window, retainSystemUiFlag(window, i11, 1024), 4), 2), 4096), 1024), 512);
    }

    public static Integer getStatusBarAPITransparentValue(Context context) {
        Integer num = sTransparentValue;
        if (num != null) {
            return num;
        }
        String str = null;
        for (String str2 : context.getPackageManager().getSystemSharedLibraryNames()) {
            if ("touchwiz".equals(str2)) {
                str = "SYSTEM_UI_FLAG_TRANSPARENT_BACKGROUND";
            } else if (str2.startsWith("com.sonyericsson.navigationbar")) {
                str = "SYSTEM_UI_FLAG_TRANSPARENT";
            }
        }
        if (str != null) {
            try {
                Field field = View.class.getField(str);
                if (field != null && field.getType() == Integer.TYPE) {
                    sTransparentValue = Integer.valueOf(field.getInt((Object) null));
                }
            } catch (Exception unused) {
            }
        }
        return sTransparentValue;
    }

    public static int getStatusbarHeight(Context context) {
        if (sStatusbarHeight == -1) {
            initStatusBarHeight(context);
        }
        return sStatusbarHeight;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.reflect.Field} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void initStatusBarHeight(android.content.Context r5) {
        /*
            r0 = 0
            java.lang.String r1 = "com.android.internal.R$dimen"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x002b }
            java.lang.Object r2 = r1.newInstance()     // Catch:{ all -> 0x002b }
            boolean r3 = com.huochat.community.util.NBDeviceHelper.isMeizu()     // Catch:{ all -> 0x0025 }
            if (r3 == 0) goto L_0x001c
            java.lang.String r3 = "status_bar_height_large"
            java.lang.reflect.Field r0 = r1.getField(r3)     // Catch:{ all -> 0x0018 }
            goto L_0x001c
        L_0x0018:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x0025 }
        L_0x001c:
            if (r0 != 0) goto L_0x0033
            java.lang.String r3 = "status_bar_height"
            java.lang.reflect.Field r0 = r1.getField(r3)     // Catch:{ all -> 0x0025 }
            goto L_0x0033
        L_0x0025:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r2
            r2 = r4
            goto L_0x002e
        L_0x002b:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x002e:
            r2.printStackTrace()
            r2 = r0
            r0 = r1
        L_0x0033:
            if (r0 == 0) goto L_0x0052
            if (r2 == 0) goto L_0x0052
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004e }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x004e }
            android.content.res.Resources r1 = r5.getResources()     // Catch:{ all -> 0x004e }
            int r0 = r1.getDimensionPixelSize(r0)     // Catch:{ all -> 0x004e }
            sStatusbarHeight = r0     // Catch:{ all -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0052:
            boolean r0 = com.huochat.community.util.NBDeviceHelper.isTablet(r5)
            r1 = 1103626240(0x41c80000, float:25.0)
            if (r0 == 0) goto L_0x0066
            int r0 = sStatusbarHeight
            int r2 = com.huochat.community.util.DisplayTool.dp2px(r5, r1)
            if (r0 <= r2) goto L_0x0066
            r5 = 0
            sStatusbarHeight = r5
            goto L_0x0080
        L_0x0066:
            int r0 = sStatusbarHeight
            if (r0 > 0) goto L_0x0080
            float r0 = sVirtualDensity
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0079
            int r5 = com.huochat.community.util.DisplayTool.dp2px(r5, r1)
            sStatusbarHeight = r5
            goto L_0x0080
        L_0x0079:
            float r0 = r0 * r1
            r5 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r5
            int r5 = (int) r0
            sStatusbarHeight = r5
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.NBStatusBarUtils.initStatusBarHeight(android.content.Context):void");
    }

    public static boolean isFullScreen(Activity activity) {
        try {
            if ((activity.getWindow().getAttributes().flags & 1024) != 0) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    private static boolean isMIUICustomStatusBarLightModeImpl() {
        if ((!NBDeviceHelper.isMIUIV9() || Build.VERSION.SDK_INT >= 23) && !NBDeviceHelper.isMIUIV5() && !NBDeviceHelper.isMIUIV6() && !NBDeviceHelper.isMIUIV7() && !NBDeviceHelper.isMIUIV8()) {
            return false;
        }
        return true;
    }

    public static int retainSystemUiFlag(Window window, int i11, int i12) {
        return (window.getDecorView().getSystemUiVisibility() & i12) == i12 ? i11 | i12 : i11;
    }

    public static boolean setStatusBarDarkMode(Activity activity) {
        if (activity == null) {
            return false;
        }
        int i11 = mStatuBarType;
        if (i11 == 0) {
            return true;
        }
        if (i11 == 1) {
            return MIUISetStatusBarLightMode(activity.getWindow(), false);
        }
        if (i11 == 2) {
            return FlymeSetStatusBarLightMode(activity.getWindow(), false);
        }
        if (i11 == 3) {
            return Android6SetStatusBarLightMode(activity.getWindow(), false);
        }
        return true;
    }

    public static boolean setStatusBarLightMode(Activity activity) {
        if (activity == null || NBDeviceHelper.isZTKC2016()) {
            return false;
        }
        int i11 = mStatuBarType;
        if (i11 != 0) {
            return setStatusBarLightMode(activity, i11);
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 19) {
            if (isMIUICustomStatusBarLightModeImpl() && MIUISetStatusBarLightMode(activity.getWindow(), true)) {
                mStatuBarType = 1;
                return true;
            } else if (FlymeSetStatusBarLightMode(activity.getWindow(), true)) {
                mStatuBarType = 2;
                return true;
            } else if (i12 >= 23) {
                Android6SetStatusBarLightMode(activity.getWindow(), true);
                mStatuBarType = 3;
                return true;
            }
        }
        return false;
    }

    public static void setVirtualDensity(float f11) {
        sVirtualDensity = f11;
    }

    public static void setVirtualDensityDpi(float f11) {
        sVirtualDensityDpi = f11;
    }

    public static boolean supportTransclentStatusBar6() {
        return !NBDeviceHelper.isZUKZ1() && !NBDeviceHelper.isZTKC2016();
    }

    private static boolean supportTranslucent() {
        int i11 = Build.VERSION.SDK_INT;
        return i11 >= 19 && (!NBDeviceHelper.isEssentialPhone() || i11 >= 26);
    }

    public static void translucent(Activity activity) {
        translucent(activity.getWindow());
    }

    public static void translucent(Window window) {
        translucent(window, 1073741824);
    }

    public static void translucent(Activity activity, int i11) {
        translucent(activity.getWindow(), i11);
    }

    @TargetApi(19)
    public static void translucent(Window window, int i11) {
        if (supportTranslucent()) {
            if (NBDeviceHelper.isMeizu() || (NBDeviceHelper.isMIUI() && Build.VERSION.SDK_INT < 23)) {
                window.setFlags(67108864, 67108864);
                return;
            }
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 21) {
                window.getDecorView().setSystemUiVisibility(1280);
                if (i12 < 23 || !supportTransclentStatusBar6()) {
                    window.clearFlags(67108864);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(i11);
                    return;
                }
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            }
        }
    }

    private static boolean setStatusBarLightMode(Activity activity, int i11) {
        if (i11 == 1) {
            return MIUISetStatusBarLightMode(activity.getWindow(), true);
        }
        if (i11 == 2) {
            return FlymeSetStatusBarLightMode(activity.getWindow(), true);
        }
        if (i11 == 3) {
            return Android6SetStatusBarLightMode(activity.getWindow(), true);
        }
        return false;
    }
}

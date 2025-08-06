package com.yalantis.ucrop.statusbar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class LightStatusBarUtils {
    private static void initStatusBarStyle(Activity activity, boolean z11, boolean z12) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        if (z11 && z12) {
            activity.getWindow().getDecorView().setSystemUiVisibility(256);
        } else if (!z11 && !z12) {
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else if (!z11 && z12) {
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        }
    }

    @TargetApi(11)
    private static void setAndroidNativeLightStatusBar(Activity activity, boolean z11, boolean z12, boolean z13, boolean z14) {
        if (z13) {
            try {
                Window window = activity.getWindow();
                int i11 = Build.VERSION.SDK_INT;
                if (i11 < 21) {
                    return;
                }
                if (!z11 || !z12) {
                    if (z11 || z12) {
                        if (!z11 && z12) {
                            if (!z14 || i11 < 23) {
                                window.getDecorView().setSystemUiVisibility(1280);
                            } else {
                                window.getDecorView().setSystemUiVisibility(9472);
                            }
                        }
                    } else if (!z14 || i11 < 23) {
                        window.getDecorView().setSystemUiVisibility(1280);
                    } else {
                        window.getDecorView().setSystemUiVisibility(9472);
                    }
                } else if (!z14 || i11 < 23) {
                    window.getDecorView().setSystemUiVisibility(256);
                } else {
                    window.getDecorView().setSystemUiVisibility(8448);
                }
            } catch (Exception unused) {
            }
        } else {
            View decorView = activity.getWindow().getDecorView();
            if (!z14 || Build.VERSION.SDK_INT < 23) {
                decorView.setSystemUiVisibility(0);
            } else {
                decorView.setSystemUiVisibility(8192);
            }
        }
    }

    private static boolean setFlymeLightStatusBar(Activity activity, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15 = true;
        if (activity == null) {
            return false;
        }
        initStatusBarStyle(activity, z11, z12);
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i11 = declaredField.getInt((Object) null);
            int i12 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z14 ? i11 | i12 : (~i11) & i12);
            activity.getWindow().setAttributes(attributes);
            try {
                if (RomUtils.getFlymeVersion() < 7) {
                    return true;
                }
                setAndroidNativeLightStatusBar(activity, z11, z12, z13, z14);
                return true;
            } catch (Exception unused) {
                setAndroidNativeLightStatusBar(activity, z11, z12, z13, z14);
                return z15;
            }
        } catch (Exception unused2) {
            z15 = false;
            setAndroidNativeLightStatusBar(activity, z11, z12, z13, z14);
            return z15;
        }
    }

    public static void setLightStatusBar(Activity activity, boolean z11) {
        setLightStatusBar(activity, false, false, false, z11);
    }

    public static void setLightStatusBarAboveAPI23(Activity activity, boolean z11, boolean z12, boolean z13, boolean z14) {
        if (Build.VERSION.SDK_INT >= 23) {
            setLightStatusBar(activity, z11, z12, z13, z14);
        }
    }

    private static boolean setMIUILightStatusBar(Activity activity, boolean z11, boolean z12, boolean z13, boolean z14) {
        initStatusBarStyle(activity, z11, z12);
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i11 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", new Class[]{cls3, cls3});
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z14 ? i11 : 0);
            objArr[1] = Integer.valueOf(i11);
            method.invoke(window, objArr);
            return true;
        } catch (Exception unused) {
            setAndroidNativeLightStatusBar(activity, z11, z12, z13, z14);
            return false;
        }
    }

    public static void setLightStatusBar(Activity activity, boolean z11, boolean z12, boolean z13, boolean z14) {
        int lightStatausBarAvailableRomType = RomUtils.getLightStatausBarAvailableRomType();
        if (lightStatausBarAvailableRomType != 1) {
            if (lightStatausBarAvailableRomType == 2) {
                setFlymeLightStatusBar(activity, z11, z12, z13, z14);
            } else if (lightStatausBarAvailableRomType == 3) {
                setAndroidNativeLightStatusBar(activity, z11, z12, z13, z14);
            }
        } else if (RomUtils.getMIUIVersionCode() >= 7) {
            setAndroidNativeLightStatusBar(activity, z11, z12, z13, z14);
        } else {
            setMIUILightStatusBar(activity, z11, z12, z13, z14);
        }
    }
}

package i6;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f68166a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f68167b;

    public static boolean a(Activity activity) {
        try {
            Class<?> loadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Activity activity) {
        if (f68166a) {
            return f68167b;
        }
        f68166a = true;
        f68167b = false;
        try {
            if (Build.VERSION.SDK_INT < 28) {
                String str = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str)) {
                    f68167b = false;
                } else if (str.equalsIgnoreCase("HUAWEI")) {
                    f68167b = a(activity);
                } else if (str.equalsIgnoreCase("xiaomi")) {
                    f68167b = e(activity);
                } else if (str.equalsIgnoreCase(MTPushConstants.Manufacturer.OPPO)) {
                    f68167b = c(activity);
                } else if (str.equalsIgnoreCase("vivo")) {
                    f68167b = d(activity);
                }
            } else if (activity.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout() != null) {
                f68167b = true;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return f68167b;
    }

    public static boolean c(Activity activity) {
        return activity.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean d(Activity activity) {
        try {
            Class<?> cls = Class.forName("android.util.FtFeature");
            return ((Boolean) cls.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(cls, new Object[]{32})).booleanValue();
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean e(Activity activity) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            if (((Integer) cls.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(cls, new Object[]{"ro.miui.notch", 0})).intValue() == 1) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }
}

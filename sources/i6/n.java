package i6;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import java.util.Objects;
import lombok.NonNull;

public final class n {
    public static int a(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Activity activity) {
        if (i(activity)) {
            return d(activity);
        }
        return 0;
    }

    public static String c() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("HUAWEI")) {
            return "navigationbar_is_min";
        }
        if (str.equalsIgnoreCase("XIAOMI")) {
            return "force_fsg_nav_bar";
        }
        if (!str.equalsIgnoreCase("VIVO") && !str.equalsIgnoreCase("OPPO")) {
            return "navigationbar_is_min";
        }
        return "navigation_gesture_on";
    }

    public static int d(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static float e() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static int f(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.y;
    }

    public static int g(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.x;
    }

    public static int h(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        return dimensionPixelSize <= 0 ? a(context, 25.0f) : dimensionPixelSize;
    }

    public static boolean i(Activity activity) {
        int visibility;
        View findViewById = activity.findViewById(16908336);
        if (findViewById == null || (visibility = findViewById.getVisibility()) == 8 || visibility == 4) {
            return false;
        }
        return true;
    }

    public static boolean j(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), c(), 0) != 0;
    }

    public static Bitmap k(@NonNull Activity activity, boolean z11) {
        Bitmap bitmap;
        Objects.requireNonNull(activity, "activity is marked @NonNull but is null");
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.setWillNotCacheDrawing(false);
        Bitmap drawingCache = decorView.getDrawingCache();
        Bitmap bitmap2 = null;
        if (drawingCache == null) {
            return null;
        }
        if (z11) {
            try {
                int h11 = h(activity);
                bitmap = Bitmap.createBitmap(drawingCache, 0, h11, g(activity), (f(activity) - h11) - d(activity));
            } catch (Throwable th2) {
                d.g(th2);
            }
        } else {
            bitmap = Bitmap.createBitmap(drawingCache, 0, 0, g(activity), f(activity));
        }
        bitmap2 = bitmap;
        decorView.destroyDrawingCache();
        return bitmap2;
    }
}

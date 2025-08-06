package xa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import ra.c;

public final class a {
    public static String a(boolean z11) {
        return z11 ? "buy" : "sell";
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.x;
    }

    public static void c(Activity activity, Intent intent) {
        if (c.c().C(activity, (Intent) null, intent)) {
            activity.startActivity(intent);
        }
    }
}

package a30;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.h0;

@TargetApi(21)
public class b {
    public static void a(Activity activity, int i11) {
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i11);
        window.getDecorView().setSystemUiVisibility(0);
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        if (childAt != null) {
            h0.G0(childAt, false);
            h0.u0(childAt);
        }
    }

    public static void b(Activity activity, boolean z11) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        if (z11) {
            window.clearFlags(67108864);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        } else {
            window.addFlags(67108864);
            window.getDecorView().setSystemUiVisibility(0);
        }
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        if (childAt != null) {
            h0.G0(childAt, false);
            h0.u0(childAt);
        }
    }
}

package v1;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

public class y extends x {

    /* renamed from: k  reason: collision with root package name */
    public static boolean f16698k = true;

    @SuppressLint({"NewApi"})
    public void h(View view, int i11) {
        if (Build.VERSION.SDK_INT == 28) {
            super.h(view, i11);
        } else if (f16698k) {
            try {
                view.setTransitionVisibility(i11);
            } catch (NoSuchMethodError unused) {
                f16698k = false;
            }
        }
    }
}

package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import v1.c;
import v1.d;

public class b {
    public static c a(View view, ViewGroup viewGroup, Matrix matrix) {
        if (Build.VERSION.SDK_INT == 28) {
            return d.b(view, viewGroup, matrix);
        }
        return GhostViewPort.b(view, viewGroup, matrix);
    }

    public static void b(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            d.f(view);
        } else {
            GhostViewPort.f(view);
        }
    }
}

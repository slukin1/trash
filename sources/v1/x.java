package v1;

import android.annotation.SuppressLint;
import android.view.View;

public class x extends w {

    /* renamed from: j  reason: collision with root package name */
    public static boolean f16697j = true;

    @SuppressLint({"NewApi"})
    public void f(View view, int i11, int i12, int i13, int i14) {
        if (f16697j) {
            try {
                view.setLeftTopRightBottom(i11, i12, i13, i14);
            } catch (NoSuchMethodError unused) {
                f16697j = false;
            }
        }
    }
}

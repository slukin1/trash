package uk.co.senab.photoview.scrollerproxy;

import android.content.Context;
import android.os.Build;
import e30.a;
import e30.b;
import e30.c;

public abstract class ScrollerProxy {
    public static ScrollerProxy f(Context context) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 9) {
            return new c(context);
        }
        if (i11 < 14) {
            return new a(context);
        }
        return new b(context);
    }

    public abstract boolean a();

    public abstract void b(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21);

    public abstract void c(boolean z11);

    public abstract int d();

    public abstract int e();

    public abstract boolean g();
}

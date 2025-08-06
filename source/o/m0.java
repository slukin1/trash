package o;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import o.l0;

public final /* synthetic */ class m0 {
    public static l0.b a(Context context, Handler handler) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            return new p0(context);
        }
        if (i11 >= 29) {
            return new o0(context);
        }
        if (i11 >= 28) {
            return n0.h(context);
        }
        return q0.g(context, handler);
    }
}

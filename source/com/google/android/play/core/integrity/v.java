package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ae;

final class v {

    /* renamed from: a  reason: collision with root package name */
    private static o f66856a;

    public static synchronized o a(Context context) {
        o oVar;
        synchronized (v.class) {
            if (f66856a == null) {
                m mVar = new m((l) null);
                mVar.a(ae.a(context));
                f66856a = mVar.b();
            }
            oVar = f66856a;
        }
        return oVar;
    }
}

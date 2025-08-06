package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ae;

final class aj {

    /* renamed from: a  reason: collision with root package name */
    private static s f66787a;

    public static synchronized s a(Context context) {
        s sVar;
        synchronized (aj.class) {
            if (f66787a == null) {
                q qVar = new q((p) null);
                qVar.a(ae.a(context));
                f66787a = qVar.b();
            }
            sVar = f66787a;
        }
        return sVar;
    }
}

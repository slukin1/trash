package uk.co.senab.photoview.gestures;

import android.content.Context;
import android.os.Build;
import c30.a;
import c30.b;
import c30.c;
import c30.d;
import c30.e;

public final class VersionedGestureDetector {
    public static d a(Context context, e eVar) {
        d dVar;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 5) {
            dVar = new a(context);
        } else if (i11 < 8) {
            dVar = new b(context);
        } else {
            dVar = new c(context);
        }
        dVar.d(eVar);
        return dVar;
    }
}

package p0;

import android.app.Service;
import android.os.Build;

public final class r {

    public static class a {
        public static void a(Service service, int i11) {
            service.stopForeground(i11);
        }
    }

    public static void a(Service service, int i11) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(service, i11);
            return;
        }
        boolean z11 = true;
        if ((i11 & 1) == 0) {
            z11 = false;
        }
        service.stopForeground(z11);
    }
}

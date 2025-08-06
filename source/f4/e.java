package f4;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final double f66255a;

    static {
        double d11 = 1.0d;
        if (Build.VERSION.SDK_INT >= 17) {
            d11 = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f66255a = d11;
    }

    public static double a(long j11) {
        return ((double) (b() - j11)) * f66255a;
    }

    @TargetApi(17)
    public static long b() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }
}

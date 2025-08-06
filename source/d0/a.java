package d0;

import android.util.Pair;
import androidx.camera.video.internal.compat.quirk.NegativeLatLongSavesIncorrectlyQuirk;

public final class a {
    public static Pair<Double, Double> a(double d11, double d12) {
        if (a0.a.a(NegativeLatLongSavesIncorrectlyQuirk.class) != null) {
            d11 = b(d11);
            d12 = b(d12);
        }
        return Pair.create(Double.valueOf(d11), Double.valueOf(d12));
    }

    public static double b(double d11) {
        return d11 >= 0.0d ? d11 : ((d11 * 10000.0d) - 1.0d) / 10000.0d;
    }
}

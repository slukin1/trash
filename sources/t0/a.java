package t0;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.core.graphics.BlendModeCompat;
import t0.b;

public class a {

    /* renamed from: t0.a$a  reason: collision with other inner class name */
    public static class C0102a {
        public static ColorFilter a(int i11, Object obj) {
            return new BlendModeColorFilter(i11, (BlendMode) obj);
        }
    }

    public static ColorFilter a(int i11, BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object a11 = b.C0103b.a(blendModeCompat);
            if (a11 != null) {
                return C0102a.a(i11, a11);
            }
            return null;
        }
        PorterDuff.Mode a12 = b.a(blendModeCompat);
        if (a12 != null) {
            return new PorterDuffColorFilter(i11, a12);
        }
        return null;
    }
}

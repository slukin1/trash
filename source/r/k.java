package r;

import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.core.impl.SessionConfig;
import q.d;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Rational f16430a = new Rational(16, 9);

    public static boolean a(Size size, Rational rational) {
        return rational.equals(new Rational(size.getWidth(), size.getHeight()));
    }

    public static void b(Size size, SessionConfig.Builder builder) {
        if (((PreviewPixelHDRnetQuirk) d.a(PreviewPixelHDRnetQuirk.class)) != null && !a(size, f16430a)) {
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.c(CaptureRequest.TONEMAP_MODE, 2);
            builder.addImplementationOptions(builder2.build());
        }
    }
}

package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;

public abstract class MeteringPointFactory {
    private Rational mSurfaceAspectRatio;

    public MeteringPointFactory() {
        this((Rational) null);
    }

    public static float getDefaultPointSize() {
        return 0.15f;
    }

    public abstract PointF convertPoint(float f11, float f12);

    public final MeteringPoint createPoint(float f11, float f12) {
        return createPoint(f11, f12, getDefaultPointSize());
    }

    public MeteringPointFactory(Rational rational) {
        this.mSurfaceAspectRatio = rational;
    }

    public final MeteringPoint createPoint(float f11, float f12, float f13) {
        PointF convertPoint = convertPoint(f11, f12);
        return new MeteringPoint(convertPoint.x, convertPoint.y, f13, this.mSurfaceAspectRatio);
    }
}

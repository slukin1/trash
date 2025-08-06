package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;
import android.util.Size;

public class SurfaceOrientedMeteringPointFactory extends MeteringPointFactory {
    private final float mHeight;
    private final float mWidth;

    public SurfaceOrientedMeteringPointFactory(float f11, float f12) {
        this.mWidth = f11;
        this.mHeight = f12;
    }

    private static Rational getUseCaseAspectRatio(UseCase useCase) {
        if (useCase == null) {
            return null;
        }
        Size attachedSurfaceResolution = useCase.getAttachedSurfaceResolution();
        if (attachedSurfaceResolution != null) {
            return new Rational(attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight());
        }
        throw new IllegalStateException("UseCase " + useCase + " is not bound.");
    }

    public PointF convertPoint(float f11, float f12) {
        return new PointF(f11 / this.mWidth, f12 / this.mHeight);
    }

    public SurfaceOrientedMeteringPointFactory(float f11, float f12, UseCase useCase) {
        super(getUseCaseAspectRatio(useCase));
        this.mWidth = f11;
        this.mHeight = f12;
    }
}

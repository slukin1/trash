package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import x0.a;

public class n4 implements ZoomState {

    /* renamed from: a  reason: collision with root package name */
    public float f5231a;

    /* renamed from: b  reason: collision with root package name */
    public final float f5232b;

    /* renamed from: c  reason: collision with root package name */
    public final float f5233c;

    /* renamed from: d  reason: collision with root package name */
    public float f5234d;

    public n4(float f11, float f12) {
        this.f5232b = f11;
        this.f5233c = f12;
    }

    public final float a(float f11) {
        float f12 = this.f5232b;
        float f13 = this.f5233c;
        if (f12 == f13) {
            return 0.0f;
        }
        if (f11 == f12) {
            return 1.0f;
        }
        if (f11 == f13) {
            return 0.0f;
        }
        float f14 = 1.0f / f13;
        return ((1.0f / f11) - f14) / ((1.0f / f12) - f14);
    }

    public final float b(float f11) {
        if (f11 == 1.0f) {
            return this.f5232b;
        }
        if (f11 == 0.0f) {
            return this.f5233c;
        }
        float f12 = this.f5232b;
        float f13 = this.f5233c;
        double d11 = (double) (1.0f / f13);
        return (float) a.a(1.0d / (d11 + ((((double) (1.0f / f12)) - d11) * ((double) f11))), (double) f13, (double) f12);
    }

    public void c(float f11) throws IllegalArgumentException {
        if (f11 > 1.0f || f11 < 0.0f) {
            throw new IllegalArgumentException("Requested linearZoom " + f11 + " is not within valid range [0..1]");
        }
        this.f5234d = f11;
        this.f5231a = b(f11);
    }

    public void d(float f11) throws IllegalArgumentException {
        if (f11 > this.f5232b || f11 < this.f5233c) {
            throw new IllegalArgumentException("Requested zoomRatio " + f11 + " is not within valid range [" + this.f5233c + " , " + this.f5232b + "]");
        }
        this.f5231a = f11;
        this.f5234d = a(f11);
    }

    public float getLinearZoom() {
        return this.f5234d;
    }

    public float getMaxZoomRatio() {
        return this.f5232b;
    }

    public float getMinZoomRatio() {
        return this.f5233c;
    }

    public float getZoomRatio() {
        return this.f5231a;
    }
}

package b6;

import android.graphics.PointF;
import android.view.animation.Interpolator;

public class a implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public PointF f66735a;

    /* renamed from: b  reason: collision with root package name */
    public PointF f66736b;

    /* renamed from: c  reason: collision with root package name */
    public PointF f66737c;

    /* renamed from: d  reason: collision with root package name */
    public PointF f66738d;

    /* renamed from: e  reason: collision with root package name */
    public PointF f66739e;

    public a(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.f66737c = new PointF();
        this.f66738d = new PointF();
        this.f66739e = new PointF();
        float f11 = pointF.x;
        if (f11 < 0.0f || f11 > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        float f12 = pointF2.x;
        if (f12 < 0.0f || f12 > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.f66735a = pointF;
        this.f66736b = pointF2;
    }

    public final float a(float f11) {
        PointF pointF = this.f66739e;
        PointF pointF2 = this.f66735a;
        float f12 = pointF2.x * 3.0f;
        pointF.x = f12;
        PointF pointF3 = this.f66738d;
        float f13 = ((this.f66736b.x - pointF2.x) * 3.0f) - f12;
        pointF3.x = f13;
        PointF pointF4 = this.f66737c;
        float f14 = (1.0f - pointF.x) - f13;
        pointF4.x = f14;
        return f11 * (pointF.x + ((pointF3.x + (f14 * f11)) * f11));
    }

    public float b(float f11) {
        PointF pointF = this.f66739e;
        PointF pointF2 = this.f66735a;
        float f12 = pointF2.y * 3.0f;
        pointF.y = f12;
        PointF pointF3 = this.f66738d;
        float f13 = ((this.f66736b.y - pointF2.y) * 3.0f) - f12;
        pointF3.y = f13;
        PointF pointF4 = this.f66737c;
        float f14 = (1.0f - pointF.y) - f13;
        pointF4.y = f14;
        return f11 * (pointF.y + ((pointF3.y + (f14 * f11)) * f11));
    }

    public final float c(float f11) {
        return this.f66739e.x + (f11 * ((this.f66738d.x * 2.0f) + (this.f66737c.x * 3.0f * f11)));
    }

    public float d(float f11) {
        float f12 = f11;
        for (int i11 = 1; i11 < 14; i11++) {
            float a11 = a(f12) - f11;
            if (((double) Math.abs(a11)) < 0.001d) {
                break;
            }
            f12 -= a11 / c(f12);
        }
        return f12;
    }

    public float getInterpolation(float f11) {
        return b(d(f11));
    }

    public a(float f11, float f12, float f13, float f14) {
        this(new PointF(f11, f12), new PointF(f13, f14));
    }

    public a(double d11, double d12, double d13, double d14) {
        this((float) d11, (float) d12, (float) d13, (float) d14);
    }
}

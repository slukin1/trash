package c1;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

public class a implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f12998a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f12999b;

    public a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i11 = ((int) (length / 0.002f)) + 1;
        this.f12998a = new float[i11];
        this.f12999b = new float[i11];
        float[] fArr = new float[2];
        for (int i12 = 0; i12 < i11; i12++) {
            pathMeasure.getPosTan((((float) i12) * length) / ((float) (i11 - 1)), fArr, (float[]) null);
            this.f12998a[i12] = fArr[0];
            this.f12999b[i12] = fArr[1];
        }
    }

    public static Path a(float f11, float f12, float f13, float f14) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f11, f12, f13, f14, 1.0f, 1.0f);
        return path;
    }

    public float getInterpolation(float f11) {
        if (f11 <= 0.0f) {
            return 0.0f;
        }
        if (f11 >= 1.0f) {
            return 1.0f;
        }
        int i11 = 0;
        int length = this.f12998a.length - 1;
        while (length - i11 > 1) {
            int i12 = (i11 + length) / 2;
            if (f11 < this.f12998a[i12]) {
                length = i12;
            } else {
                i11 = i12;
            }
        }
        float[] fArr = this.f12998a;
        float f12 = fArr[length] - fArr[i11];
        if (f12 == 0.0f) {
            return this.f12999b[i11];
        }
        float[] fArr2 = this.f12999b;
        float f13 = fArr2[i11];
        return f13 + (((f11 - fArr[i11]) / f12) * (fArr2[length] - f13));
    }

    public a(float f11, float f12, float f13, float f14) {
        this(a(f11, f12, f13, f14));
    }
}

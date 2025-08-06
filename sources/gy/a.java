package gy;

import android.view.animation.Interpolator;

public abstract class a implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f37152a;

    /* renamed from: b  reason: collision with root package name */
    public final float f37153b;

    public a(float[] fArr) {
        this.f37152a = fArr;
        this.f37153b = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f11) {
        if (f11 >= 1.0f) {
            return 1.0f;
        }
        if (f11 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f37152a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f11), fArr.length - 2);
        float f12 = this.f37153b;
        float f13 = (f11 - (((float) min) * f12)) / f12;
        float[] fArr2 = this.f37152a;
        return fArr2[min] + (f13 * (fArr2[min + 1] - fArr2[min]));
    }
}

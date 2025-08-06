package v1;

import android.animation.TypeEvaluator;

public class b implements TypeEvaluator<float[]> {

    /* renamed from: a  reason: collision with root package name */
    public float[] f16635a;

    public b(float[] fArr) {
        this.f16635a = fArr;
    }

    /* renamed from: a */
    public float[] evaluate(float f11, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f16635a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i11 = 0; i11 < fArr3.length; i11++) {
            float f12 = fArr[i11];
            fArr3[i11] = f12 + ((fArr2[i11] - f12) * f11);
        }
        return fArr3;
    }
}

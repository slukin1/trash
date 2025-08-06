package com.iproov.sdk.p032throw;

/* renamed from: com.iproov.sdk.throw.if  reason: invalid class name and invalid package */
public class Cif extends Cfor<float[]> {
    public Cif(long j11, float[] fArr, float[] fArr2) {
        super(j11, fArr, fArr2);
    }

    /* renamed from: if  reason: not valid java name */
    public float[] m1904do(float f11) {
        int length = ((float[]) this.f2025if).length;
        float[] fArr = new float[length];
        for (int i11 = 0; i11 < length; i11++) {
            float f12 = ((float[]) this.f2025if)[i11];
            fArr[i11] = f12 + ((((float[]) this.f2024for)[i11] - f12) * f11);
        }
        return fArr;
    }
}

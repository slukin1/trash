package kotlinx.serialization.internal;

import java.util.Arrays;

public final class a0 extends PrimitiveArrayBuilder<float[]> {

    /* renamed from: a  reason: collision with root package name */
    public float[] f57688a;

    /* renamed from: b  reason: collision with root package name */
    public int f57689b;

    public a0(float[] fArr) {
        this.f57688a = fArr;
        this.f57689b = fArr.length;
        b(10);
    }

    public void b(int i11) {
        float[] fArr = this.f57688a;
        if (fArr.length < i11) {
            this.f57688a = Arrays.copyOf(fArr, RangesKt___RangesKt.d(i11, fArr.length * 2));
        }
    }

    public int d() {
        return this.f57689b;
    }

    public final void e(float f11) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        float[] fArr = this.f57688a;
        int d11 = d();
        this.f57689b = d11 + 1;
        fArr[d11] = f11;
    }

    /* renamed from: f */
    public float[] a() {
        return Arrays.copyOf(this.f57688a, d());
    }
}

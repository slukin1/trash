package a5;

import com.github.mikephil.charting.data.BarEntry;
import g5.a;

public class b extends a<a> {

    /* renamed from: g  reason: collision with root package name */
    public int f63135g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f63136h = 1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f63137i = false;

    /* renamed from: j  reason: collision with root package name */
    public boolean f63138j = false;

    /* renamed from: k  reason: collision with root package name */
    public float f63139k = 1.0f;

    public b(int i11, int i12, boolean z11) {
        super(i11);
        this.f63136h = i12;
        this.f63137i = z11;
    }

    public void d(float f11, float f12, float f13, float f14) {
        float[] fArr = this.f63130b;
        int i11 = this.f63129a;
        int i12 = i11 + 1;
        this.f63129a = i12;
        fArr[i11] = f11;
        int i13 = i12 + 1;
        this.f63129a = i13;
        fArr[i12] = f12;
        int i14 = i13 + 1;
        this.f63129a = i14;
        fArr[i13] = f13;
        this.f63129a = i14 + 1;
        fArr[i14] = f14;
    }

    public void e(a aVar) {
        float f11;
        float f12;
        float f13;
        float f14;
        float entryCount = ((float) aVar.getEntryCount()) * this.f63131c;
        float f15 = this.f63139k / 2.0f;
        for (int i11 = 0; ((float) i11) < entryCount; i11++) {
            BarEntry barEntry = (BarEntry) aVar.getEntryForIndex(i11);
            if (barEntry != null) {
                float x11 = barEntry.getX();
                float y11 = barEntry.getY();
                float[] yVals = barEntry.getYVals();
                if (!this.f63137i || yVals == null) {
                    float f16 = x11 - f15;
                    float f17 = x11 + f15;
                    if (this.f63138j) {
                        f11 = y11 >= 0.0f ? y11 : 0.0f;
                        if (y11 > 0.0f) {
                            y11 = 0.0f;
                        }
                    } else {
                        float f18 = y11 >= 0.0f ? y11 : 0.0f;
                        if (y11 > 0.0f) {
                            y11 = 0.0f;
                        }
                        float f19 = y11;
                        y11 = f18;
                        f11 = f19;
                    }
                    if (y11 > 0.0f) {
                        y11 *= this.f63132d;
                    } else {
                        f11 *= this.f63132d;
                    }
                    d(f16, y11, f17, f11);
                } else {
                    float f21 = -barEntry.getNegativeSum();
                    float f22 = 0.0f;
                    int i12 = 0;
                    while (i12 < yVals.length) {
                        float f23 = yVals[i12];
                        int i13 = (f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1));
                        if (i13 == 0 && (f22 == 0.0f || f21 == 0.0f)) {
                            f12 = f23;
                            f13 = f21;
                            f21 = f12;
                        } else if (i13 >= 0) {
                            f12 = f23 + f22;
                            f13 = f21;
                            f21 = f22;
                            f22 = f12;
                        } else {
                            f12 = Math.abs(f23) + f21;
                            f13 = Math.abs(f23) + f21;
                        }
                        float f24 = x11 - f15;
                        float f25 = x11 + f15;
                        if (this.f63138j) {
                            f14 = f21 >= f12 ? f21 : f12;
                            if (f21 > f12) {
                                f21 = f12;
                            }
                        } else {
                            float f26 = f21 >= f12 ? f21 : f12;
                            if (f21 > f12) {
                                f21 = f12;
                            }
                            float f27 = f21;
                            f21 = f26;
                            f14 = f27;
                        }
                        float f28 = this.f63132d;
                        d(f24, f21 * f28, f25, f14 * f28);
                        i12++;
                        f21 = f13;
                    }
                }
            }
        }
        a();
    }

    public void f(float f11) {
        this.f63139k = f11;
    }

    public void g(int i11) {
        this.f63135g = i11;
    }

    public void h(boolean z11) {
        this.f63138j = z11;
    }
}

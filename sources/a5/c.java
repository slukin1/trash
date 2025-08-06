package a5;

import com.github.mikephil.charting.data.BarEntry;
import g5.a;

public class c extends b {
    public c(int i11, int i12, boolean z11) {
        super(i11, i12, z11);
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
                    d(f11, f17, y11, f16);
                } else {
                    float f21 = -barEntry.getNegativeSum();
                    float f22 = 0.0f;
                    int i12 = 0;
                    while (i12 < yVals.length) {
                        float f23 = yVals[i12];
                        if (f23 >= 0.0f) {
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
                        d(f14 * f28, f25, f21 * f28, f24);
                        i12++;
                        f21 = f13;
                    }
                }
            }
        }
        a();
    }
}

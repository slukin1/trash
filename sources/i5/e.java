package i5;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.github.mikephil.charting.utils.a;
import f5.d;
import i5.c;
import java.util.List;

public class e extends l {

    /* renamed from: i  reason: collision with root package name */
    public d f66306i;

    /* renamed from: j  reason: collision with root package name */
    public float[] f66307j = new float[8];

    /* renamed from: k  reason: collision with root package name */
    public float[] f66308k = new float[4];

    /* renamed from: l  reason: collision with root package name */
    public float[] f66309l = new float[4];

    /* renamed from: m  reason: collision with root package name */
    public float[] f66310m = new float[4];

    /* renamed from: n  reason: collision with root package name */
    public float[] f66311n = new float[4];

    public e(d dVar, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f66306i = dVar;
    }

    public void b(Canvas canvas) {
        for (g5.d dVar : this.f66306i.getCandleData().g()) {
            if (dVar.isVisible()) {
                l(canvas, dVar);
            }
        }
    }

    public void c(Canvas canvas) {
    }

    public void d(Canvas canvas, e5.d[] dVarArr) {
        CandleData candleData = this.f66306i.getCandleData();
        for (e5.d dVar : dVarArr) {
            g5.d dVar2 = (g5.d) candleData.e(dVar.d());
            if (dVar2 != null && dVar2.isHighlightEnabled()) {
                CandleEntry candleEntry = (CandleEntry) dVar2.getEntryForXValue(dVar.h(), dVar.j());
                if (i(candleEntry, dVar2)) {
                    a e11 = this.f66306i.d(dVar2.getAxisDependency()).e(candleEntry.getX(), ((candleEntry.getLow() * this.f66316b.b()) + (candleEntry.getHigh() * this.f66316b.b())) / 2.0f);
                    dVar.m((float) e11.f65588c, (float) e11.f65589d);
                    k(canvas, (float) e11.f65588c, (float) e11.f65589d, dVar2);
                }
            }
        }
    }

    public void f(Canvas canvas) {
        int i11;
        MPPointF mPPointF;
        float f11;
        float f12;
        if (h(this.f66306i)) {
            List g11 = this.f66306i.getCandleData().g();
            for (int i12 = 0; i12 < g11.size(); i12++) {
                g5.d dVar = (g5.d) g11.get(i12);
                if (j(dVar)) {
                    a(dVar);
                    k5.a d11 = this.f66306i.d(dVar.getAxisDependency());
                    this.f66297g.a(this.f66306i, dVar);
                    float a11 = this.f66316b.a();
                    float b11 = this.f66316b.b();
                    c.a aVar = this.f66297g;
                    float[] b12 = d11.b(dVar, a11, b11, aVar.f66298a, aVar.f66299b);
                    float e11 = Utils.e(5.0f);
                    MPPointF d12 = MPPointF.d(dVar.getIconsOffset());
                    d12.f65546c = Utils.e(d12.f65546c);
                    d12.f65547d = Utils.e(d12.f65547d);
                    int i13 = 0;
                    while (i13 < b12.length) {
                        float f13 = b12[i13];
                        float f14 = b12[i13 + 1];
                        if (!this.f66370a.A(f13)) {
                            break;
                        }
                        if (!this.f66370a.z(f13) || !this.f66370a.D(f14)) {
                            i11 = i13;
                            mPPointF = d12;
                        } else {
                            int i14 = i13 / 2;
                            CandleEntry candleEntry = (CandleEntry) dVar.getEntryForIndex(this.f66297g.f66298a + i14);
                            if (dVar.isDrawValuesEnabled()) {
                                f12 = f14;
                                f11 = f13;
                                i11 = i13;
                                mPPointF = d12;
                                e(canvas, dVar.getValueFormatter(), candleEntry.getHigh(), candleEntry, i12, f13, f14 - e11, dVar.getValueTextColor(i14));
                            } else {
                                f12 = f14;
                                f11 = f13;
                                i11 = i13;
                                mPPointF = d12;
                            }
                            if (candleEntry.getIcon() != null && dVar.isDrawIconsEnabled()) {
                                Drawable icon = candleEntry.getIcon();
                                Utils.f(canvas, icon, (int) (f11 + mPPointF.f65546c), (int) (f12 + mPPointF.f65547d), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            }
                        }
                        i13 = i11 + 2;
                        d12 = mPPointF;
                    }
                    MPPointF.f(d12);
                }
            }
        }
    }

    public void g() {
    }

    public void l(Canvas canvas, g5.d dVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        g5.d dVar2 = dVar;
        k5.a d11 = this.f66306i.d(dVar.getAxisDependency());
        float b11 = this.f66316b.b();
        float S = dVar.S();
        boolean j11 = dVar.j();
        this.f66297g.a(this.f66306i, dVar2);
        this.f66317c.setStrokeWidth(dVar.O());
        int i16 = this.f66297g.f66298a;
        while (true) {
            c.a aVar = this.f66297g;
            if (i16 <= aVar.f66300c + aVar.f66298a) {
                CandleEntry candleEntry = (CandleEntry) dVar2.getEntryForIndex(i16);
                if (candleEntry == null) {
                    Canvas canvas2 = canvas;
                } else {
                    float x11 = candleEntry.getX();
                    float open = candleEntry.getOpen();
                    float close = candleEntry.getClose();
                    float high = candleEntry.getHigh();
                    float low = candleEntry.getLow();
                    if (j11) {
                        float[] fArr = this.f66307j;
                        fArr[0] = x11;
                        fArr[2] = x11;
                        fArr[4] = x11;
                        fArr[6] = x11;
                        int i17 = (open > close ? 1 : (open == close ? 0 : -1));
                        if (i17 > 0) {
                            fArr[1] = high * b11;
                            fArr[3] = open * b11;
                            fArr[5] = low * b11;
                            fArr[7] = close * b11;
                        } else if (open < close) {
                            fArr[1] = high * b11;
                            fArr[3] = close * b11;
                            fArr[5] = low * b11;
                            fArr[7] = open * b11;
                        } else {
                            fArr[1] = high * b11;
                            fArr[3] = open * b11;
                            fArr[5] = low * b11;
                            fArr[7] = fArr[3];
                        }
                        d11.k(fArr);
                        if (!dVar.G()) {
                            Paint paint = this.f66317c;
                            if (dVar.Z() == 1122867) {
                                i12 = dVar2.getColor(i16);
                            } else {
                                i12 = dVar.Z();
                            }
                            paint.setColor(i12);
                        } else if (i17 > 0) {
                            Paint paint2 = this.f66317c;
                            if (dVar.z() == 1122867) {
                                i15 = dVar2.getColor(i16);
                            } else {
                                i15 = dVar.z();
                            }
                            paint2.setColor(i15);
                        } else if (open < close) {
                            Paint paint3 = this.f66317c;
                            if (dVar.i() == 1122867) {
                                i14 = dVar2.getColor(i16);
                            } else {
                                i14 = dVar.i();
                            }
                            paint3.setColor(i14);
                        } else {
                            Paint paint4 = this.f66317c;
                            if (dVar.M() == 1122867) {
                                i13 = dVar2.getColor(i16);
                            } else {
                                i13 = dVar.M();
                            }
                            paint4.setColor(i13);
                        }
                        this.f66317c.setStyle(Paint.Style.STROKE);
                        canvas.drawLines(this.f66307j, this.f66317c);
                        float[] fArr2 = this.f66308k;
                        fArr2[0] = (x11 - 0.5f) + S;
                        fArr2[1] = close * b11;
                        fArr2[2] = (x11 + 0.5f) - S;
                        fArr2[3] = open * b11;
                        d11.k(fArr2);
                        if (i17 > 0) {
                            if (dVar.z() == 1122867) {
                                this.f66317c.setColor(dVar2.getColor(i16));
                            } else {
                                this.f66317c.setColor(dVar.z());
                            }
                            this.f66317c.setStyle(dVar.R());
                            float[] fArr3 = this.f66308k;
                            canvas.drawRect(fArr3[0], fArr3[3], fArr3[2], fArr3[1], this.f66317c);
                        } else if (open < close) {
                            if (dVar.i() == 1122867) {
                                this.f66317c.setColor(dVar2.getColor(i16));
                            } else {
                                this.f66317c.setColor(dVar.i());
                            }
                            this.f66317c.setStyle(dVar.s());
                            float[] fArr4 = this.f66308k;
                            canvas.drawRect(fArr4[0], fArr4[1], fArr4[2], fArr4[3], this.f66317c);
                        } else {
                            if (dVar.M() == 1122867) {
                                this.f66317c.setColor(dVar2.getColor(i16));
                            } else {
                                this.f66317c.setColor(dVar.M());
                            }
                            float[] fArr5 = this.f66308k;
                            canvas.drawLine(fArr5[0], fArr5[1], fArr5[2], fArr5[3], this.f66317c);
                        }
                    } else {
                        Canvas canvas3 = canvas;
                        float[] fArr6 = this.f66309l;
                        fArr6[0] = x11;
                        fArr6[1] = high * b11;
                        fArr6[2] = x11;
                        fArr6[3] = low * b11;
                        float[] fArr7 = this.f66310m;
                        fArr7[0] = (x11 - 0.5f) + S;
                        float f11 = open * b11;
                        fArr7[1] = f11;
                        fArr7[2] = x11;
                        fArr7[3] = f11;
                        float[] fArr8 = this.f66311n;
                        fArr8[0] = (0.5f + x11) - S;
                        float f12 = close * b11;
                        fArr8[1] = f12;
                        fArr8[2] = x11;
                        fArr8[3] = f12;
                        d11.k(fArr6);
                        d11.k(this.f66310m);
                        d11.k(this.f66311n);
                        if (open > close) {
                            if (dVar.z() == 1122867) {
                                i11 = dVar2.getColor(i16);
                            } else {
                                i11 = dVar.z();
                            }
                        } else if (open < close) {
                            if (dVar.i() == 1122867) {
                                i11 = dVar2.getColor(i16);
                            } else {
                                i11 = dVar.i();
                            }
                        } else if (dVar.M() == 1122867) {
                            i11 = dVar2.getColor(i16);
                        } else {
                            i11 = dVar.M();
                        }
                        this.f66317c.setColor(i11);
                        float[] fArr9 = this.f66309l;
                        Canvas canvas4 = canvas;
                        canvas4.drawLine(fArr9[0], fArr9[1], fArr9[2], fArr9[3], this.f66317c);
                        float[] fArr10 = this.f66310m;
                        canvas4.drawLine(fArr10[0], fArr10[1], fArr10[2], fArr10[3], this.f66317c);
                        float[] fArr11 = this.f66311n;
                        canvas4.drawLine(fArr11[0], fArr11[1], fArr11[2], fArr11[3], this.f66317c);
                    }
                }
                i16++;
            } else {
                return;
            }
        }
    }
}

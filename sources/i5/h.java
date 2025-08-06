package i5;

import a5.b;
import a5.c;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.huobi.coupon.bean.CouponReturn;
import d5.e;
import e5.d;
import f5.a;
import java.util.List;

public class h extends b {

    /* renamed from: n  reason: collision with root package name */
    public RectF f66321n = new RectF();

    public h(a aVar, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(aVar, chartAnimator, viewPortHandler);
        this.f66320f.setTextAlign(Paint.Align.LEFT);
    }

    public void f(Canvas canvas) {
        List list;
        MPPointF mPPointF;
        int i11;
        float[] fArr;
        float[] fArr2;
        int i12;
        float f11;
        float f12;
        float f13;
        BarEntry barEntry;
        boolean z11;
        List list2;
        int i13;
        float f14;
        b bVar;
        e eVar;
        MPPointF mPPointF2;
        float f15;
        if (h(this.f66291h)) {
            List g11 = this.f66291h.getBarData().g();
            float e11 = Utils.e(5.0f);
            boolean a11 = this.f66291h.a();
            int i14 = 0;
            while (i14 < this.f66291h.getBarData().f()) {
                g5.a aVar = (g5.a) g11.get(i14);
                if (!j(aVar)) {
                    list = g11;
                } else {
                    boolean e12 = this.f66291h.e(aVar.getAxisDependency());
                    a(aVar);
                    float f16 = 2.0f;
                    float a12 = ((float) Utils.a(this.f66320f, CouponReturn.TYPE_EXPERIENCE)) / 2.0f;
                    e valueFormatter = aVar.getValueFormatter();
                    b bVar2 = this.f66293j[i14];
                    float b11 = this.f66316b.b();
                    MPPointF d11 = MPPointF.d(aVar.getIconsOffset());
                    d11.f65546c = Utils.e(d11.f65546c);
                    d11.f65547d = Utils.e(d11.f65547d);
                    if (!aVar.u()) {
                        int i15 = 0;
                        while (((float) i15) < ((float) bVar2.f63130b.length) * this.f66316b.a()) {
                            float[] fArr3 = bVar2.f63130b;
                            int i16 = i15 + 1;
                            float f17 = (fArr3[i16] + fArr3[i15 + 3]) / f16;
                            if (!this.f66370a.B(fArr3[i16])) {
                                break;
                            }
                            if (this.f66370a.C(bVar2.f63130b[i15]) && this.f66370a.y(bVar2.f63130b[i16])) {
                                BarEntry barEntry2 = (BarEntry) aVar.getEntryForIndex(i15 / 4);
                                float y11 = barEntry2.getY();
                                String b12 = valueFormatter.b(y11, barEntry2, i14, this.f66370a);
                                MPPointF mPPointF3 = d11;
                                float d12 = (float) Utils.d(this.f66320f, b12);
                                String str = b12;
                                float f18 = a11 ? e11 : -(d12 + e11);
                                e eVar2 = valueFormatter;
                                float f19 = a11 ? -(d12 + e11) : e11;
                                if (e12) {
                                    f18 = (-f18) - d12;
                                    f19 = (-f19) - d12;
                                }
                                float f21 = f18;
                                float f22 = f19;
                                if (aVar.isDrawValuesEnabled()) {
                                    f15 = y11;
                                    i13 = i15;
                                    list2 = g11;
                                    mPPointF2 = mPPointF3;
                                    f14 = a12;
                                    bVar = bVar2;
                                    z11 = e12;
                                    eVar = eVar2;
                                    n(canvas, str, (y11 >= 0.0f ? f21 : f22) + bVar2.f63130b[i15 + 2], f17 + a12, aVar.getValueTextColor(i15 / 2));
                                } else {
                                    f15 = y11;
                                    i13 = i15;
                                    list2 = g11;
                                    z11 = e12;
                                    mPPointF2 = mPPointF3;
                                    eVar = eVar2;
                                    f14 = a12;
                                    bVar = bVar2;
                                }
                                if (barEntry2.getIcon() != null && aVar.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry2.getIcon();
                                    float f23 = bVar.f63130b[i13 + 2];
                                    if (f15 < 0.0f) {
                                        f21 = f22;
                                    }
                                    Utils.f(canvas, icon, (int) (f23 + f21 + mPPointF2.f65546c), (int) (f17 + mPPointF2.f65547d), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            } else {
                                i13 = i15;
                                list2 = g11;
                                z11 = e12;
                                f14 = a12;
                                mPPointF2 = d11;
                                bVar = bVar2;
                                eVar = valueFormatter;
                            }
                            i15 = i13 + 4;
                            d11 = mPPointF2;
                            valueFormatter = eVar;
                            bVar2 = bVar;
                            a12 = f14;
                            g11 = list2;
                            e12 = z11;
                            f16 = 2.0f;
                        }
                        list = g11;
                        mPPointF = d11;
                    } else {
                        list = g11;
                        boolean z12 = e12;
                        float f24 = a12;
                        mPPointF = d11;
                        b bVar3 = bVar2;
                        e eVar3 = valueFormatter;
                        k5.a d13 = this.f66291h.d(aVar.getAxisDependency());
                        int i17 = 0;
                        int i18 = 0;
                        while (((float) i17) < ((float) aVar.getEntryCount()) * this.f66316b.a()) {
                            BarEntry barEntry3 = (BarEntry) aVar.getEntryForIndex(i17);
                            int valueTextColor = aVar.getValueTextColor(i17);
                            float[] yVals = barEntry3.getYVals();
                            if (yVals != null) {
                                BarEntry barEntry4 = barEntry3;
                                i11 = i17;
                                fArr = yVals;
                                int length = fArr.length * 2;
                                float[] fArr4 = new float[length];
                                float f25 = -barEntry4.getNegativeSum();
                                float f26 = 0.0f;
                                int i19 = 0;
                                int i21 = 0;
                                while (i19 < length) {
                                    float f27 = fArr[i21];
                                    int i22 = (f27 > 0.0f ? 1 : (f27 == 0.0f ? 0 : -1));
                                    if (i22 == 0 && (f26 == 0.0f || f25 == 0.0f)) {
                                        float f28 = f25;
                                        f25 = f27;
                                        f13 = f28;
                                    } else if (i22 >= 0) {
                                        f26 += f27;
                                        f13 = f25;
                                        f25 = f26;
                                    } else {
                                        f13 = f25 - f27;
                                    }
                                    fArr4[i19] = f25 * b11;
                                    i19 += 2;
                                    i21++;
                                    f25 = f13;
                                }
                                d13.k(fArr4);
                                int i23 = 0;
                                while (true) {
                                    if (i23 >= length) {
                                        break;
                                    }
                                    float f29 = fArr[i23 / 2];
                                    String b13 = eVar3.b(f29, barEntry4, i14, this.f66370a);
                                    float d14 = (float) Utils.d(this.f66320f, b13);
                                    String str2 = b13;
                                    float f31 = a11 ? e11 : -(d14 + e11);
                                    int i24 = length;
                                    float f32 = a11 ? -(d14 + e11) : e11;
                                    if (z12) {
                                        f31 = (-f31) - d14;
                                        f32 = (-f32) - d14;
                                    }
                                    boolean z13 = (f29 == 0.0f && f25 == 0.0f && f26 > 0.0f) || f29 < 0.0f;
                                    float f33 = fArr4[i23];
                                    if (z13) {
                                        f31 = f32;
                                    }
                                    float f34 = f33 + f31;
                                    float[] fArr5 = bVar3.f63130b;
                                    float f35 = (fArr5[i18 + 1] + fArr5[i18 + 3]) / 2.0f;
                                    if (!this.f66370a.B(f35)) {
                                        break;
                                    }
                                    if (this.f66370a.C(f34) && this.f66370a.y(f35)) {
                                        if (aVar.isDrawValuesEnabled()) {
                                            float f36 = f35 + f24;
                                            f11 = f35;
                                            String str3 = str2;
                                            i12 = i23;
                                            fArr2 = fArr4;
                                            float f37 = f36;
                                            f12 = f34;
                                            n(canvas, str3, f34, f37, valueTextColor);
                                        } else {
                                            f11 = f35;
                                            i12 = i23;
                                            fArr2 = fArr4;
                                            f12 = f34;
                                        }
                                        if (barEntry4.getIcon() != null && aVar.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry4.getIcon();
                                            Utils.f(canvas, icon2, (int) (f12 + mPPointF.f65546c), (int) (f11 + mPPointF.f65547d), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i12 = i23;
                                        fArr2 = fArr4;
                                    }
                                    i23 = i12 + 2;
                                    length = i24;
                                    fArr4 = fArr2;
                                }
                            } else {
                                int i25 = i18 + 1;
                                if (!this.f66370a.B(bVar3.f63130b[i25])) {
                                    break;
                                } else if (this.f66370a.C(bVar3.f63130b[i18]) && this.f66370a.y(bVar3.f63130b[i25])) {
                                    String b14 = eVar3.b(barEntry3.getY(), barEntry3, i14, this.f66370a);
                                    float d15 = (float) Utils.d(this.f66320f, b14);
                                    float f38 = a11 ? e11 : -(d15 + e11);
                                    float f39 = a11 ? -(d15 + e11) : e11;
                                    if (z12) {
                                        f38 = (-f38) - d15;
                                        f39 = (-f39) - d15;
                                    }
                                    float f40 = f38;
                                    float f41 = f39;
                                    if (aVar.isDrawValuesEnabled()) {
                                        i11 = i17;
                                        fArr = yVals;
                                        barEntry = barEntry3;
                                        n(canvas, b14, bVar3.f63130b[i18 + 2] + (barEntry3.getY() >= 0.0f ? f40 : f41), bVar3.f63130b[i25] + f24, valueTextColor);
                                    } else {
                                        barEntry = barEntry3;
                                        i11 = i17;
                                        fArr = yVals;
                                    }
                                    if (barEntry.getIcon() != null && aVar.isDrawIconsEnabled()) {
                                        Drawable icon3 = barEntry.getIcon();
                                        float f42 = bVar3.f63130b[i18 + 2];
                                        if (barEntry.getY() < 0.0f) {
                                            f40 = f41;
                                        }
                                        Utils.f(canvas, icon3, (int) (f42 + f40 + mPPointF.f65546c), (int) (bVar3.f63130b[i25] + mPPointF.f65547d), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                    }
                                }
                            }
                            if (fArr == null) {
                                i18 += 4;
                            } else {
                                i18 += fArr.length * 4;
                            }
                            i17 = i11 + 1;
                        }
                    }
                    MPPointF.f(mPPointF);
                }
                i14++;
                g11 = list;
            }
        }
    }

    public void g() {
        BarData barData = this.f66291h.getBarData();
        this.f66293j = new c[barData.f()];
        for (int i11 = 0; i11 < this.f66293j.length; i11++) {
            g5.a aVar = (g5.a) barData.e(i11);
            this.f66293j[i11] = new c(aVar.getEntryCount() * 4 * (aVar.u() ? aVar.h() : 1), barData.f(), aVar.u());
        }
    }

    public boolean h(f5.e eVar) {
        return ((float) eVar.getData().h()) < ((float) eVar.getMaxVisibleCount()) * this.f66370a.r();
    }

    public void k(Canvas canvas, g5.a aVar, int i11) {
        g5.a aVar2 = aVar;
        int i12 = i11;
        k5.a d11 = this.f66291h.d(aVar.getAxisDependency());
        this.f66295l.setColor(aVar.D());
        this.f66295l.setStrokeWidth(Utils.e(aVar.q()));
        int i13 = 0;
        boolean z11 = true;
        boolean z12 = aVar.q() > 0.0f;
        float a11 = this.f66316b.a();
        float b11 = this.f66316b.b();
        if (this.f66291h.c()) {
            this.f66294k.setColor(aVar.V());
            float v11 = this.f66291h.getBarData().v() / 2.0f;
            int min = Math.min((int) Math.ceil((double) (((float) aVar.getEntryCount()) * a11)), aVar.getEntryCount());
            for (int i14 = 0; i14 < min; i14++) {
                float x11 = ((BarEntry) aVar2.getEntryForIndex(i14)).getX();
                RectF rectF = this.f66321n;
                rectF.top = x11 - v11;
                rectF.bottom = x11 + v11;
                d11.p(rectF);
                if (!this.f66370a.B(this.f66321n.bottom)) {
                    Canvas canvas2 = canvas;
                } else if (!this.f66370a.y(this.f66321n.top)) {
                    break;
                } else {
                    this.f66321n.left = this.f66370a.h();
                    this.f66321n.right = this.f66370a.i();
                    canvas.drawRect(this.f66321n, this.f66294k);
                }
            }
        }
        Canvas canvas3 = canvas;
        b bVar = this.f66293j[i12];
        bVar.b(a11, b11);
        bVar.g(i12);
        bVar.h(this.f66291h.e(aVar.getAxisDependency()));
        bVar.f(this.f66291h.getBarData().v());
        bVar.e(aVar2);
        d11.k(bVar.f63130b);
        if (aVar.getColors().size() != 1) {
            z11 = false;
        }
        if (z11) {
            this.f66317c.setColor(aVar.getColor());
        }
        while (i13 < bVar.c()) {
            int i15 = i13 + 3;
            if (this.f66370a.B(bVar.f63130b[i15])) {
                int i16 = i13 + 1;
                if (this.f66370a.y(bVar.f63130b[i16])) {
                    if (!z11) {
                        this.f66317c.setColor(aVar2.getColor(i13 / 4));
                    }
                    float[] fArr = bVar.f63130b;
                    int i17 = i13 + 2;
                    canvas.drawRect(fArr[i13], fArr[i16], fArr[i17], fArr[i15], this.f66317c);
                    if (z12) {
                        float[] fArr2 = bVar.f63130b;
                        canvas.drawRect(fArr2[i13], fArr2[i16], fArr2[i17], fArr2[i15], this.f66295l);
                    }
                }
                i13 += 4;
                Canvas canvas4 = canvas;
            } else {
                return;
            }
        }
    }

    public void l(float f11, float f12, float f13, float f14, k5.a aVar) {
        this.f66292i.set(f12, f11 - f14, f13, f11 + f14);
        aVar.o(this.f66292i, this.f66316b.b());
    }

    public void m(d dVar, RectF rectF) {
        dVar.m(rectF.centerY(), rectF.right);
    }

    public void n(Canvas canvas, String str, float f11, float f12, int i11) {
        this.f66320f.setColor(i11);
        canvas.drawText(str, f11, f12, this.f66320f);
    }
}

package i5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import e5.d;
import e5.j;
import f5.a;
import java.util.List;

public class b extends c {

    /* renamed from: h  reason: collision with root package name */
    public a f66291h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f66292i = new RectF();

    /* renamed from: j  reason: collision with root package name */
    public a5.b[] f66293j;

    /* renamed from: k  reason: collision with root package name */
    public Paint f66294k;

    /* renamed from: l  reason: collision with root package name */
    public Paint f66295l;

    /* renamed from: m  reason: collision with root package name */
    public RectF f66296m = new RectF();

    public b(a aVar, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f66291h = aVar;
        Paint paint = new Paint(1);
        this.f66318d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f66318d.setColor(Color.rgb(0, 0, 0));
        this.f66318d.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.f66294k = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.f66295l = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    public void b(Canvas canvas) {
        BarData barData = this.f66291h.getBarData();
        for (int i11 = 0; i11 < barData.f(); i11++) {
            g5.a aVar = (g5.a) barData.e(i11);
            if (aVar.isVisible()) {
                k(canvas, aVar, i11);
            }
        }
    }

    public void c(Canvas canvas) {
    }

    public void d(Canvas canvas, d[] dVarArr) {
        float f11;
        float f12;
        float f13;
        float f14;
        BarData barData = this.f66291h.getBarData();
        for (d dVar : dVarArr) {
            g5.a aVar = (g5.a) barData.e(dVar.d());
            if (aVar != null && aVar.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) aVar.getEntryForXValue(dVar.h(), dVar.j());
                if (i(barEntry, aVar)) {
                    k5.a d11 = this.f66291h.d(aVar.getAxisDependency());
                    this.f66318d.setColor(aVar.getHighLightColor());
                    this.f66318d.setAlpha(aVar.Y());
                    if (!(dVar.g() >= 0 && barEntry.isStacked())) {
                        f14 = barEntry.getY();
                        f13 = 0.0f;
                    } else if (this.f66291h.b()) {
                        f14 = barEntry.getPositiveSum();
                        f13 = -barEntry.getNegativeSum();
                    } else {
                        j jVar = barEntry.getRanges()[dVar.g()];
                        f12 = jVar.f66239a;
                        f11 = jVar.f66240b;
                        l(barEntry.getX(), f12, f11, barData.v() / 2.0f, d11);
                        m(dVar, this.f66292i);
                        canvas.drawRect(this.f66292i, this.f66318d);
                    }
                    f11 = f13;
                    f12 = f14;
                    l(barEntry.getX(), f12, f11, barData.v() / 2.0f, d11);
                    m(dVar, this.f66292i);
                    canvas.drawRect(this.f66292i, this.f66318d);
                }
            }
        }
    }

    public void f(Canvas canvas) {
        boolean z11;
        float f11;
        float f12;
        boolean z12;
        List list;
        MPPointF mPPointF;
        int i11;
        float f13;
        boolean z13;
        k5.a aVar;
        float[] fArr;
        float f14;
        int i12;
        float[] fArr2;
        int i13;
        float f15;
        float f16;
        float f17;
        int i14;
        List list2;
        MPPointF mPPointF2;
        a5.b bVar;
        float f18;
        if (h(this.f66291h)) {
            List g11 = this.f66291h.getBarData().g();
            float e11 = Utils.e(4.5f);
            boolean a11 = this.f66291h.a();
            int i15 = 0;
            while (i15 < this.f66291h.getBarData().f()) {
                g5.a aVar2 = (g5.a) g11.get(i15);
                if (!j(aVar2)) {
                    list = g11;
                    f12 = f11;
                    z12 = z11;
                } else {
                    a(aVar2);
                    boolean e12 = this.f66291h.e(aVar2.getAxisDependency());
                    float a12 = (float) Utils.a(this.f66320f, "8");
                    float f19 = z11 ? -f11 : a12 + f11;
                    float f21 = z11 ? a12 + f11 : -f11;
                    if (e12) {
                        f19 = (-f19) - a12;
                        f21 = (-f21) - a12;
                    }
                    float f22 = f19;
                    float f23 = f21;
                    a5.b bVar2 = this.f66293j[i15];
                    float b11 = this.f66316b.b();
                    MPPointF d11 = MPPointF.d(aVar2.getIconsOffset());
                    d11.f65546c = Utils.e(d11.f65546c);
                    d11.f65547d = Utils.e(d11.f65547d);
                    if (!aVar2.u()) {
                        int i16 = 0;
                        while (((float) i16) < ((float) bVar2.f63130b.length) * this.f66316b.a()) {
                            float[] fArr3 = bVar2.f63130b;
                            float f24 = (fArr3[i16] + fArr3[i16 + 2]) / 2.0f;
                            if (!this.f66370a.A(f24)) {
                                break;
                            }
                            int i17 = i16 + 1;
                            if (!this.f66370a.D(bVar2.f63130b[i17]) || !this.f66370a.z(f24)) {
                                i14 = i16;
                                mPPointF2 = d11;
                                list2 = g11;
                                bVar = bVar2;
                            } else {
                                int i18 = i16 / 4;
                                BarEntry barEntry = (BarEntry) aVar2.getEntryForIndex(i18);
                                float y11 = barEntry.getY();
                                if (aVar2.isDrawValuesEnabled()) {
                                    f18 = f24;
                                    i14 = i16;
                                    mPPointF2 = d11;
                                    list2 = g11;
                                    bVar = bVar2;
                                    e(canvas, aVar2.getValueFormatter(), y11, barEntry, i15, f18, y11 >= 0.0f ? bVar2.f63130b[i17] + f22 : bVar2.f63130b[i16 + 3] + f23, aVar2.getValueTextColor(i18));
                                } else {
                                    f18 = f24;
                                    i14 = i16;
                                    mPPointF2 = d11;
                                    list2 = g11;
                                    bVar = bVar2;
                                }
                                if (barEntry.getIcon() != null && aVar2.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry.getIcon();
                                    Utils.f(canvas, icon, (int) (f18 + mPPointF2.f65546c), (int) ((y11 >= 0.0f ? bVar.f63130b[i17] + f22 : bVar.f63130b[i14 + 3] + f23) + mPPointF2.f65547d), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            }
                            i16 = i14 + 4;
                            bVar2 = bVar;
                            d11 = mPPointF2;
                            g11 = list2;
                        }
                        mPPointF = d11;
                        list = g11;
                    } else {
                        mPPointF = d11;
                        list = g11;
                        a5.b bVar3 = bVar2;
                        k5.a d12 = this.f66291h.d(aVar2.getAxisDependency());
                        int i19 = 0;
                        int i21 = 0;
                        while (((float) i19) < ((float) aVar2.getEntryCount()) * this.f66316b.a()) {
                            BarEntry barEntry2 = (BarEntry) aVar2.getEntryForIndex(i19);
                            float[] yVals = barEntry2.getYVals();
                            float[] fArr4 = bVar3.f63130b;
                            float f25 = (fArr4[i21] + fArr4[i21 + 2]) / 2.0f;
                            int valueTextColor = aVar2.getValueTextColor(i19);
                            if (yVals != null) {
                                i11 = i19;
                                f13 = f11;
                                z13 = z11;
                                fArr = yVals;
                                aVar = d12;
                                float f26 = f25;
                                int length = fArr.length * 2;
                                float[] fArr5 = new float[length];
                                float f27 = -barEntry2.getNegativeSum();
                                float f28 = 0.0f;
                                int i22 = 0;
                                int i23 = 0;
                                while (i22 < length) {
                                    float f29 = fArr[i23];
                                    int i24 = (f29 > 0.0f ? 1 : (f29 == 0.0f ? 0 : -1));
                                    if (i24 == 0 && (f28 == 0.0f || f27 == 0.0f)) {
                                        float f31 = f27;
                                        f27 = f29;
                                        f16 = f31;
                                    } else if (i24 >= 0) {
                                        f28 += f29;
                                        f16 = f27;
                                        f27 = f28;
                                    } else {
                                        f16 = f27 - f29;
                                    }
                                    fArr5[i22 + 1] = f27 * b11;
                                    i22 += 2;
                                    i23++;
                                    f27 = f16;
                                }
                                aVar.k(fArr5);
                                int i25 = 0;
                                while (i25 < length) {
                                    int i26 = i25 / 2;
                                    float f32 = fArr[i26];
                                    float f33 = fArr5[i25 + 1] + (((f32 > 0.0f ? 1 : (f32 == 0.0f ? 0 : -1)) == 0 && (f27 > 0.0f ? 1 : (f27 == 0.0f ? 0 : -1)) == 0 && (f28 > 0.0f ? 1 : (f28 == 0.0f ? 0 : -1)) > 0) || (f32 > 0.0f ? 1 : (f32 == 0.0f ? 0 : -1)) < 0 ? f23 : f22);
                                    if (!this.f66370a.A(f26)) {
                                        break;
                                    }
                                    if (!this.f66370a.D(f33) || !this.f66370a.z(f26)) {
                                        i13 = i25;
                                        fArr2 = fArr5;
                                        i12 = length;
                                        f14 = f26;
                                    } else {
                                        if (aVar2.isDrawValuesEnabled()) {
                                            f15 = f33;
                                            i13 = i25;
                                            fArr2 = fArr5;
                                            i12 = length;
                                            f14 = f26;
                                            e(canvas, aVar2.getValueFormatter(), fArr[i26], barEntry2, i15, f26, f15, valueTextColor);
                                        } else {
                                            f15 = f33;
                                            i13 = i25;
                                            fArr2 = fArr5;
                                            i12 = length;
                                            f14 = f26;
                                        }
                                        if (barEntry2.getIcon() != null && aVar2.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry2.getIcon();
                                            Utils.f(canvas, icon2, (int) (f14 + mPPointF.f65546c), (int) (f15 + mPPointF.f65547d), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    }
                                    i25 = i13 + 2;
                                    fArr5 = fArr2;
                                    length = i12;
                                    f26 = f14;
                                }
                            } else if (!this.f66370a.A(f25)) {
                                break;
                            } else {
                                int i27 = i21 + 1;
                                if (!this.f66370a.D(bVar3.f63130b[i27]) || !this.f66370a.z(f25)) {
                                    d12 = d12;
                                    z11 = z11;
                                    f11 = f11;
                                    i19 = i19;
                                } else {
                                    if (aVar2.isDrawValuesEnabled()) {
                                        f17 = f25;
                                        f13 = f11;
                                        fArr = yVals;
                                        i11 = i19;
                                        z13 = z11;
                                        aVar = d12;
                                        e(canvas, aVar2.getValueFormatter(), barEntry2.getY(), barEntry2, i15, f17, bVar3.f63130b[i27] + (barEntry2.getY() >= 0.0f ? f22 : f23), valueTextColor);
                                    } else {
                                        f17 = f25;
                                        i11 = i19;
                                        f13 = f11;
                                        z13 = z11;
                                        fArr = yVals;
                                        aVar = d12;
                                    }
                                    if (barEntry2.getIcon() != null && aVar2.isDrawIconsEnabled()) {
                                        Drawable icon3 = barEntry2.getIcon();
                                        Utils.f(canvas, icon3, (int) (f17 + mPPointF.f65546c), (int) (bVar3.f63130b[i27] + (barEntry2.getY() >= 0.0f ? f22 : f23) + mPPointF.f65547d), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                    }
                                }
                            }
                            if (fArr == null) {
                                i21 += 4;
                            } else {
                                i21 += fArr.length * 4;
                            }
                            i19 = i11 + 1;
                            d12 = aVar;
                            z11 = z13;
                            f11 = f13;
                        }
                    }
                    f12 = f11;
                    z12 = z11;
                    MPPointF.f(mPPointF);
                }
                i15++;
                g11 = list;
                a11 = z12;
                e11 = f12;
            }
        }
    }

    public void g() {
        BarData barData = this.f66291h.getBarData();
        this.f66293j = new a5.b[barData.f()];
        for (int i11 = 0; i11 < this.f66293j.length; i11++) {
            g5.a aVar = (g5.a) barData.e(i11);
            this.f66293j[i11] = new a5.b(aVar.getEntryCount() * 4 * (aVar.u() ? aVar.h() : 1), barData.f(), aVar.u());
        }
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
                RectF rectF = this.f66296m;
                rectF.left = x11 - v11;
                rectF.right = x11 + v11;
                d11.p(rectF);
                if (!this.f66370a.z(this.f66296m.right)) {
                    Canvas canvas2 = canvas;
                } else if (!this.f66370a.A(this.f66296m.left)) {
                    break;
                } else {
                    this.f66296m.top = this.f66370a.j();
                    this.f66296m.bottom = this.f66370a.f();
                    canvas.drawRect(this.f66296m, this.f66294k);
                }
            }
        }
        Canvas canvas3 = canvas;
        a5.b bVar = this.f66293j[i12];
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
            int i15 = i13 + 2;
            if (this.f66370a.z(bVar.f63130b[i15])) {
                if (this.f66370a.A(bVar.f63130b[i13])) {
                    if (!z11) {
                        this.f66317c.setColor(aVar2.getColor(i13 / 4));
                    }
                    float[] fArr = bVar.f63130b;
                    int i16 = i13 + 1;
                    int i17 = i13 + 3;
                    canvas.drawRect(fArr[i13], fArr[i16], fArr[i15], fArr[i17], this.f66317c);
                    if (z12) {
                        float[] fArr2 = bVar.f63130b;
                        canvas.drawRect(fArr2[i13], fArr2[i16], fArr2[i15], fArr2[i17], this.f66295l);
                    }
                } else {
                    return;
                }
            }
            i13 += 4;
            Canvas canvas4 = canvas;
        }
    }

    public void l(float f11, float f12, float f13, float f14, k5.a aVar) {
        this.f66292i.set(f11 - f14, f12, f11 + f14, f13);
        aVar.n(this.f66292i, this.f66316b.b());
    }

    public void m(d dVar, RectF rectF) {
        dVar.m(rectF.centerX(), rectF.top);
    }
}

package i5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import f5.c;
import i5.c;
import java.util.List;
import k5.a;

public class d extends c {

    /* renamed from: h  reason: collision with root package name */
    public c f66302h;

    /* renamed from: i  reason: collision with root package name */
    public float[] f66303i = new float[4];

    /* renamed from: j  reason: collision with root package name */
    public float[] f66304j = new float[2];

    /* renamed from: k  reason: collision with root package name */
    public float[] f66305k = new float[3];

    public d(c cVar, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f66302h = cVar;
        this.f66317c.setStyle(Paint.Style.FILL);
        this.f66318d.setStyle(Paint.Style.STROKE);
        this.f66318d.setStrokeWidth(Utils.e(1.5f));
    }

    public void b(Canvas canvas) {
        for (g5.c cVar : this.f66302h.getBubbleData().g()) {
            if (cVar.isVisible()) {
                k(canvas, cVar);
            }
        }
    }

    public void c(Canvas canvas) {
    }

    public void d(Canvas canvas, e5.d[] dVarArr) {
        BubbleData bubbleData = this.f66302h.getBubbleData();
        float b11 = this.f66316b.b();
        for (e5.d dVar : dVarArr) {
            g5.c cVar = (g5.c) bubbleData.e(dVar.d());
            if (cVar != null && cVar.isHighlightEnabled()) {
                BubbleEntry bubbleEntry = (BubbleEntry) cVar.getEntryForXValue(dVar.h(), dVar.j());
                if (bubbleEntry.getY() == dVar.j() && i(bubbleEntry, cVar)) {
                    a d11 = this.f66302h.d(cVar.getAxisDependency());
                    float[] fArr = this.f66303i;
                    fArr[0] = 0.0f;
                    fArr[2] = 1.0f;
                    d11.k(fArr);
                    boolean l11 = cVar.l();
                    float[] fArr2 = this.f66303i;
                    float min = Math.min(Math.abs(this.f66370a.f() - this.f66370a.j()), Math.abs(fArr2[2] - fArr2[0]));
                    this.f66304j[0] = bubbleEntry.getX();
                    this.f66304j[1] = bubbleEntry.getY() * b11;
                    d11.k(this.f66304j);
                    float[] fArr3 = this.f66304j;
                    dVar.m(fArr3[0], fArr3[1]);
                    float l12 = l(bubbleEntry.getSize(), cVar.f(), min, l11) / 2.0f;
                    if (this.f66370a.B(this.f66304j[1] + l12) && this.f66370a.y(this.f66304j[1] - l12) && this.f66370a.z(this.f66304j[0] + l12)) {
                        if (this.f66370a.A(this.f66304j[0] - l12)) {
                            int color = cVar.getColor((int) bubbleEntry.getX());
                            Color.RGBToHSV(Color.red(color), Color.green(color), Color.blue(color), this.f66305k);
                            float[] fArr4 = this.f66305k;
                            fArr4[2] = fArr4[2] * 0.5f;
                            this.f66318d.setColor(Color.HSVToColor(Color.alpha(color), this.f66305k));
                            this.f66318d.setStrokeWidth(cVar.J());
                            float[] fArr5 = this.f66304j;
                            canvas.drawCircle(fArr5[0], fArr5[1], l12, this.f66318d);
                        } else {
                            return;
                        }
                    }
                }
            }
            Canvas canvas2 = canvas;
        }
    }

    public void f(Canvas canvas) {
        int i11;
        MPPointF mPPointF;
        float f11;
        float f12;
        BubbleData bubbleData = this.f66302h.getBubbleData();
        if (bubbleData != null && h(this.f66302h)) {
            List g11 = bubbleData.g();
            float a11 = (float) Utils.a(this.f66320f, "1");
            for (int i12 = 0; i12 < g11.size(); i12++) {
                g5.c cVar = (g5.c) g11.get(i12);
                if (j(cVar)) {
                    a(cVar);
                    float max = Math.max(0.0f, Math.min(1.0f, this.f66316b.a()));
                    float b11 = this.f66316b.b();
                    this.f66297g.a(this.f66302h, cVar);
                    a d11 = this.f66302h.d(cVar.getAxisDependency());
                    c.a aVar = this.f66297g;
                    float[] a12 = d11.a(cVar, b11, aVar.f66298a, aVar.f66299b);
                    float f13 = max == 1.0f ? b11 : max;
                    MPPointF d12 = MPPointF.d(cVar.getIconsOffset());
                    d12.f65546c = Utils.e(d12.f65546c);
                    d12.f65547d = Utils.e(d12.f65547d);
                    int i13 = 0;
                    while (i13 < a12.length) {
                        int i14 = i13 / 2;
                        int valueTextColor = cVar.getValueTextColor(this.f66297g.f66298a + i14);
                        int argb = Color.argb(Math.round(255.0f * f13), Color.red(valueTextColor), Color.green(valueTextColor), Color.blue(valueTextColor));
                        float f14 = a12[i13];
                        float f15 = a12[i13 + 1];
                        if (!this.f66370a.A(f14)) {
                            break;
                        }
                        if (!this.f66370a.z(f14) || !this.f66370a.D(f15)) {
                            i11 = i13;
                            mPPointF = d12;
                        } else {
                            BubbleEntry bubbleEntry = (BubbleEntry) cVar.getEntryForIndex(i14 + this.f66297g.f66298a);
                            if (cVar.isDrawValuesEnabled()) {
                                f12 = f15;
                                f11 = f14;
                                i11 = i13;
                                mPPointF = d12;
                                e(canvas, cVar.getValueFormatter(), bubbleEntry.getSize(), bubbleEntry, i12, f14, f15 + (0.5f * a11), argb);
                            } else {
                                f12 = f15;
                                f11 = f14;
                                i11 = i13;
                                mPPointF = d12;
                            }
                            if (bubbleEntry.getIcon() != null && cVar.isDrawIconsEnabled()) {
                                Drawable icon = bubbleEntry.getIcon();
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

    public void k(Canvas canvas, g5.c cVar) {
        a d11 = this.f66302h.d(cVar.getAxisDependency());
        float b11 = this.f66316b.b();
        this.f66297g.a(this.f66302h, cVar);
        float[] fArr = this.f66303i;
        fArr[0] = 0.0f;
        fArr[2] = 1.0f;
        d11.k(fArr);
        boolean l11 = cVar.l();
        float[] fArr2 = this.f66303i;
        float min = Math.min(Math.abs(this.f66370a.f() - this.f66370a.j()), Math.abs(fArr2[2] - fArr2[0]));
        int i11 = this.f66297g.f66298a;
        while (true) {
            c.a aVar = this.f66297g;
            if (i11 <= aVar.f66300c + aVar.f66298a) {
                BubbleEntry bubbleEntry = (BubbleEntry) cVar.getEntryForIndex(i11);
                this.f66304j[0] = bubbleEntry.getX();
                this.f66304j[1] = bubbleEntry.getY() * b11;
                d11.k(this.f66304j);
                float l12 = l(bubbleEntry.getSize(), cVar.f(), min, l11) / 2.0f;
                if (this.f66370a.B(this.f66304j[1] + l12) && this.f66370a.y(this.f66304j[1] - l12) && this.f66370a.z(this.f66304j[0] + l12)) {
                    if (this.f66370a.A(this.f66304j[0] - l12)) {
                        this.f66317c.setColor(cVar.getColor((int) bubbleEntry.getX()));
                        float[] fArr3 = this.f66304j;
                        canvas.drawCircle(fArr3[0], fArr3[1], l12, this.f66317c);
                    } else {
                        return;
                    }
                }
                i11++;
            } else {
                return;
            }
        }
    }

    public float l(float f11, float f12, float f13, boolean z11) {
        if (z11) {
            f11 = f12 == 0.0f ? 1.0f : (float) Math.sqrt((double) (f11 / f12));
        }
        return f13 * f11;
    }
}

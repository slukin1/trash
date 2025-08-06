package i5;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;
import k5.a;

public class u extends t {

    /* renamed from: r  reason: collision with root package name */
    public Path f66394r = new Path();

    /* renamed from: s  reason: collision with root package name */
    public Path f66395s = new Path();

    /* renamed from: t  reason: collision with root package name */
    public float[] f66396t = new float[4];

    public u(ViewPortHandler viewPortHandler, YAxis yAxis, a aVar) {
        super(viewPortHandler, yAxis, aVar);
        this.f66290g.setTextAlign(Paint.Align.LEFT);
    }

    public void a(float f11, float f12, boolean z11) {
        float f13;
        double d11;
        if (this.f66370a.g() > 10.0f && !this.f66370a.v()) {
            com.github.mikephil.charting.utils.a g11 = this.f66286c.g(this.f66370a.h(), this.f66370a.j());
            com.github.mikephil.charting.utils.a g12 = this.f66286c.g(this.f66370a.i(), this.f66370a.j());
            if (!z11) {
                f13 = (float) g11.f65588c;
                d11 = g12.f65588c;
            } else {
                f13 = (float) g12.f65588c;
                d11 = g11.f65588c;
            }
            com.github.mikephil.charting.utils.a.c(g11);
            com.github.mikephil.charting.utils.a.c(g12);
            f11 = f13;
            f12 = (float) d11;
        }
        b(f11, f12);
    }

    public void d(Canvas canvas, float f11, float[] fArr, float f12) {
        this.f66288e.setTypeface(this.f66384h.c());
        this.f66288e.setTextSize(this.f66384h.b());
        this.f66288e.setColor(this.f66384h.a());
        int i11 = this.f66384h.Z() ? this.f66384h.f65399n : this.f66384h.f65399n - 1;
        for (int i12 = !this.f66384h.Y(); i12 < i11; i12++) {
            canvas.drawText(this.f66384h.o(i12), fArr[i12 * 2], f11 - f12, this.f66288e);
        }
    }

    public void e(Canvas canvas) {
        int save = canvas.save();
        this.f66390n.set(this.f66370a.o());
        this.f66390n.inset(-this.f66384h.X(), 0.0f);
        canvas.clipRect(this.f66393q);
        com.github.mikephil.charting.utils.a e11 = this.f66286c.e(0.0f, 0.0f);
        this.f66385i.setColor(this.f66384h.W());
        this.f66385i.setStrokeWidth(this.f66384h.X());
        Path path = this.f66394r;
        path.reset();
        path.moveTo(((float) e11.f65588c) - 1.0f, this.f66370a.j());
        path.lineTo(((float) e11.f65588c) - 1.0f, this.f66370a.f());
        canvas.drawPath(path, this.f66385i);
        canvas.restoreToCount(save);
    }

    public RectF f() {
        this.f66387k.set(this.f66370a.o());
        this.f66387k.inset(-this.f66285b.s(), 0.0f);
        return this.f66387k;
    }

    public float[] g() {
        int length = this.f66388l.length;
        int i11 = this.f66384h.f65399n;
        if (length != i11 * 2) {
            this.f66388l = new float[(i11 * 2)];
        }
        float[] fArr = this.f66388l;
        for (int i12 = 0; i12 < fArr.length; i12 += 2) {
            fArr[i12] = this.f66384h.f65397l[i12 / 2];
        }
        this.f66286c.k(fArr);
        return fArr;
    }

    public Path h(Path path, int i11, float[] fArr) {
        path.moveTo(fArr[i11], this.f66370a.j());
        path.lineTo(fArr[i11], this.f66370a.f());
        return path;
    }

    public void i(Canvas canvas) {
        float f11;
        float f12;
        float f13;
        if (this.f66384h.f() && this.f66384h.A()) {
            float[] g11 = g();
            this.f66288e.setTypeface(this.f66384h.c());
            this.f66288e.setTextSize(this.f66384h.b());
            this.f66288e.setColor(this.f66384h.a());
            this.f66288e.setTextAlign(Paint.Align.CENTER);
            float e11 = Utils.e(2.5f);
            float a11 = (float) Utils.a(this.f66288e, "Q");
            YAxis.AxisDependency O = this.f66384h.O();
            YAxis.YAxisLabelPosition P = this.f66384h.P();
            if (O == YAxis.AxisDependency.LEFT) {
                if (P == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    f13 = this.f66370a.j();
                } else {
                    f13 = this.f66370a.j();
                }
                f11 = f13 - e11;
            } else {
                if (P == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    f12 = this.f66370a.f();
                } else {
                    f12 = this.f66370a.f();
                }
                f11 = f12 + a11 + e11;
            }
            d(canvas, f11, g11, this.f66384h.e());
        }
    }

    public void j(Canvas canvas) {
        if (this.f66384h.f() && this.f66384h.y()) {
            this.f66289f.setColor(this.f66384h.l());
            this.f66289f.setStrokeWidth(this.f66384h.n());
            if (this.f66384h.O() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.f66370a.h(), this.f66370a.j(), this.f66370a.i(), this.f66370a.j(), this.f66289f);
                return;
            }
            canvas.drawLine(this.f66370a.h(), this.f66370a.f(), this.f66370a.i(), this.f66370a.f(), this.f66289f);
        }
    }

    public void l(Canvas canvas) {
        Canvas canvas2 = canvas;
        List<LimitLine> u11 = this.f66384h.u();
        if (u11 != null && u11.size() > 0) {
            float[] fArr = this.f66396t;
            float f11 = 0.0f;
            fArr[0] = 0.0f;
            char c11 = 1;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            Path path = this.f66395s;
            path.reset();
            int i11 = 0;
            while (i11 < u11.size()) {
                LimitLine limitLine = u11.get(i11);
                if (limitLine.f()) {
                    int save = canvas.save();
                    this.f66393q.set(this.f66370a.o());
                    this.f66393q.inset(-limitLine.o(), f11);
                    canvas2.clipRect(this.f66393q);
                    fArr[0] = limitLine.m();
                    fArr[2] = limitLine.m();
                    this.f66286c.k(fArr);
                    fArr[c11] = this.f66370a.j();
                    fArr[3] = this.f66370a.f();
                    path.moveTo(fArr[0], fArr[c11]);
                    path.lineTo(fArr[2], fArr[3]);
                    this.f66290g.setStyle(Paint.Style.STROKE);
                    this.f66290g.setColor(limitLine.n());
                    this.f66290g.setPathEffect(limitLine.j());
                    this.f66290g.setStrokeWidth(limitLine.o());
                    canvas2.drawPath(path, this.f66290g);
                    path.reset();
                    String k11 = limitLine.k();
                    if (k11 != null && !k11.equals("")) {
                        this.f66290g.setStyle(limitLine.p());
                        this.f66290g.setPathEffect((PathEffect) null);
                        this.f66290g.setColor(limitLine.a());
                        this.f66290g.setTypeface(limitLine.c());
                        this.f66290g.setStrokeWidth(0.5f);
                        this.f66290g.setTextSize(limitLine.b());
                        float o11 = limitLine.o() + limitLine.d();
                        float e11 = Utils.e(2.0f) + limitLine.e();
                        LimitLine.LimitLabelPosition l11 = limitLine.l();
                        if (l11 == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            this.f66290g.setTextAlign(Paint.Align.LEFT);
                            canvas2.drawText(k11, fArr[0] + o11, this.f66370a.j() + e11 + ((float) Utils.a(this.f66290g, k11)), this.f66290g);
                        } else if (l11 == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                            this.f66290g.setTextAlign(Paint.Align.LEFT);
                            canvas2.drawText(k11, fArr[0] + o11, this.f66370a.f() - e11, this.f66290g);
                        } else if (l11 == LimitLine.LimitLabelPosition.LEFT_TOP) {
                            this.f66290g.setTextAlign(Paint.Align.RIGHT);
                            canvas2.drawText(k11, fArr[0] - o11, this.f66370a.j() + e11 + ((float) Utils.a(this.f66290g, k11)), this.f66290g);
                        } else {
                            this.f66290g.setTextAlign(Paint.Align.RIGHT);
                            canvas2.drawText(k11, fArr[0] - o11, this.f66370a.f() - e11, this.f66290g);
                        }
                    }
                    canvas2.restoreToCount(save);
                }
                i11++;
                f11 = 0.0f;
                c11 = 1;
            }
        }
    }
}

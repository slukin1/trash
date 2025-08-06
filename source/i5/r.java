package i5;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import d5.c;
import java.util.List;
import k5.a;

public class r extends q {

    /* renamed from: p  reason: collision with root package name */
    public BarChart f66381p;

    /* renamed from: q  reason: collision with root package name */
    public Path f66382q = new Path();

    public r(ViewPortHandler viewPortHandler, XAxis xAxis, a aVar, BarChart barChart) {
        super(viewPortHandler, xAxis, aVar);
        this.f66381p = barChart;
    }

    public void a(float f11, float f12, boolean z11) {
        float f13;
        double d11;
        if (this.f66370a.k() > 10.0f && !this.f66370a.w()) {
            com.github.mikephil.charting.utils.a g11 = this.f66286c.g(this.f66370a.h(), this.f66370a.f());
            com.github.mikephil.charting.utils.a g12 = this.f66286c.g(this.f66370a.h(), this.f66370a.j());
            if (z11) {
                f13 = (float) g12.f65589d;
                d11 = g11.f65589d;
            } else {
                f13 = (float) g11.f65589d;
                d11 = g12.f65589d;
            }
            com.github.mikephil.charting.utils.a.c(g11);
            com.github.mikephil.charting.utils.a.c(g12);
            f11 = f13;
            f12 = (float) d11;
        }
        b(f11, f12);
    }

    public void d() {
        this.f66288e.setTypeface(this.f66373h.c());
        this.f66288e.setTextSize(this.f66373h.b());
        FSize b11 = Utils.b(this.f66288e, this.f66373h.v());
        float f11 = b11.f65543d;
        FSize t11 = Utils.t(b11.f65542c, f11, this.f66373h.O());
        this.f66373h.I = Math.round((float) ((int) (b11.f65542c + (this.f66373h.d() * 3.5f))));
        this.f66373h.J = Math.round(f11);
        XAxis xAxis = this.f66373h;
        xAxis.K = (int) (t11.f65542c + (xAxis.d() * 3.5f));
        this.f66373h.L = Math.round(t11.f65543d);
        FSize.c(t11);
    }

    public void e(Canvas canvas, float f11, float f12, Path path) {
        path.moveTo(this.f66370a.i(), f12);
        path.lineTo(this.f66370a.h(), f12);
        canvas.drawPath(path, this.f66287d);
        path.reset();
    }

    public void g(Canvas canvas, float f11, MPPointF mPPointF) {
        float O = this.f66373h.O();
        boolean x11 = this.f66373h.x();
        int i11 = this.f66373h.f65399n * 2;
        float[] fArr = new float[i11];
        for (int i12 = 0; i12 < i11; i12 += 2) {
            if (x11) {
                fArr[i12 + 1] = this.f66373h.f65398m[i12 / 2];
            } else {
                fArr[i12 + 1] = this.f66373h.f65397l[i12 / 2];
            }
        }
        this.f66286c.k(fArr);
        for (int i13 = 0; i13 < i11; i13 += 2) {
            float f12 = fArr[i13 + 1];
            if (this.f66370a.D(f12)) {
                c w11 = this.f66373h.w();
                XAxis xAxis = this.f66373h;
                f(canvas, w11.a(xAxis.f65397l[i13 / 2], xAxis), f11, f12, mPPointF, O);
            }
        }
    }

    public RectF h() {
        this.f66376k.set(this.f66370a.o());
        this.f66376k.inset(0.0f, -this.f66285b.s());
        return this.f66376k;
    }

    public void i(Canvas canvas) {
        if (this.f66373h.f() && this.f66373h.A()) {
            float d11 = this.f66373h.d();
            this.f66288e.setTypeface(this.f66373h.c());
            this.f66288e.setTextSize(this.f66373h.b());
            this.f66288e.setColor(this.f66373h.a());
            MPPointF c11 = MPPointF.c(0.0f, 0.0f);
            if (this.f66373h.P() == XAxis.XAxisPosition.TOP) {
                c11.f65546c = 0.0f;
                c11.f65547d = 0.5f;
                g(canvas, this.f66370a.i() + d11, c11);
            } else if (this.f66373h.P() == XAxis.XAxisPosition.TOP_INSIDE) {
                c11.f65546c = 1.0f;
                c11.f65547d = 0.5f;
                g(canvas, this.f66370a.i() - d11, c11);
            } else if (this.f66373h.P() == XAxis.XAxisPosition.BOTTOM) {
                c11.f65546c = 1.0f;
                c11.f65547d = 0.5f;
                g(canvas, this.f66370a.h() - d11, c11);
            } else if (this.f66373h.P() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                c11.f65546c = 1.0f;
                c11.f65547d = 0.5f;
                g(canvas, this.f66370a.h() + d11, c11);
            } else {
                c11.f65546c = 0.0f;
                c11.f65547d = 0.5f;
                g(canvas, this.f66370a.i() + d11, c11);
                c11.f65546c = 1.0f;
                c11.f65547d = 0.5f;
                g(canvas, this.f66370a.h() - d11, c11);
            }
            MPPointF.f(c11);
        }
    }

    public void j(Canvas canvas) {
        if (this.f66373h.y() && this.f66373h.f()) {
            this.f66289f.setColor(this.f66373h.l());
            this.f66289f.setStrokeWidth(this.f66373h.n());
            if (this.f66373h.P() == XAxis.XAxisPosition.TOP || this.f66373h.P() == XAxis.XAxisPosition.TOP_INSIDE || this.f66373h.P() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f66370a.i(), this.f66370a.j(), this.f66370a.i(), this.f66370a.f(), this.f66289f);
            }
            if (this.f66373h.P() == XAxis.XAxisPosition.BOTTOM || this.f66373h.P() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.f66373h.P() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f66370a.h(), this.f66370a.j(), this.f66370a.h(), this.f66370a.f(), this.f66289f);
            }
        }
    }

    public void n(Canvas canvas) {
        List<LimitLine> u11 = this.f66373h.u();
        if (u11 != null && u11.size() > 0) {
            float[] fArr = this.f66377l;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.f66382q;
            path.reset();
            for (int i11 = 0; i11 < u11.size(); i11++) {
                LimitLine limitLine = u11.get(i11);
                if (limitLine.f()) {
                    int save = canvas.save();
                    this.f66378m.set(this.f66370a.o());
                    this.f66378m.inset(0.0f, -limitLine.o());
                    canvas.clipRect(this.f66378m);
                    this.f66290g.setStyle(Paint.Style.STROKE);
                    this.f66290g.setColor(limitLine.n());
                    this.f66290g.setStrokeWidth(limitLine.o());
                    this.f66290g.setPathEffect(limitLine.j());
                    fArr[1] = limitLine.m();
                    this.f66286c.k(fArr);
                    path.moveTo(this.f66370a.h(), fArr[1]);
                    path.lineTo(this.f66370a.i(), fArr[1]);
                    canvas.drawPath(path, this.f66290g);
                    path.reset();
                    String k11 = limitLine.k();
                    if (k11 != null && !k11.equals("")) {
                        this.f66290g.setStyle(limitLine.p());
                        this.f66290g.setPathEffect((PathEffect) null);
                        this.f66290g.setColor(limitLine.a());
                        this.f66290g.setStrokeWidth(0.5f);
                        this.f66290g.setTextSize(limitLine.b());
                        float a11 = (float) Utils.a(this.f66290g, k11);
                        float e11 = Utils.e(4.0f) + limitLine.d();
                        float o11 = limitLine.o() + a11 + limitLine.e();
                        LimitLine.LimitLabelPosition l11 = limitLine.l();
                        if (l11 == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            this.f66290g.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(k11, this.f66370a.i() - e11, (fArr[1] - o11) + a11, this.f66290g);
                        } else if (l11 == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                            this.f66290g.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(k11, this.f66370a.i() - e11, fArr[1] + o11, this.f66290g);
                        } else if (l11 == LimitLine.LimitLabelPosition.LEFT_TOP) {
                            this.f66290g.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(k11, this.f66370a.h() + e11, (fArr[1] - o11) + a11, this.f66290g);
                        } else {
                            this.f66290g.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(k11, this.f66370a.G() + e11, fArr[1] + o11, this.f66290g);
                        }
                    }
                    canvas.restoreToCount(save);
                }
            }
        }
    }
}

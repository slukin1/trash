package i5;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.huobi.view.roundimg.RoundedDrawable;
import d5.c;
import java.util.List;
import k5.a;

public class q extends a {

    /* renamed from: h  reason: collision with root package name */
    public XAxis f66373h;

    /* renamed from: i  reason: collision with root package name */
    public Path f66374i = new Path();

    /* renamed from: j  reason: collision with root package name */
    public float[] f66375j = new float[2];

    /* renamed from: k  reason: collision with root package name */
    public RectF f66376k = new RectF();

    /* renamed from: l  reason: collision with root package name */
    public float[] f66377l = new float[2];

    /* renamed from: m  reason: collision with root package name */
    public RectF f66378m = new RectF();

    /* renamed from: n  reason: collision with root package name */
    public float[] f66379n = new float[4];

    /* renamed from: o  reason: collision with root package name */
    public Path f66380o = new Path();

    public q(ViewPortHandler viewPortHandler, XAxis xAxis, a aVar) {
        super(viewPortHandler, aVar, xAxis);
        this.f66373h = xAxis;
        this.f66288e.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.f66288e.setTextAlign(Paint.Align.CENTER);
        this.f66288e.setTextSize(Utils.e(10.0f));
    }

    public void a(float f11, float f12, boolean z11) {
        float f13;
        double d11;
        if (this.f66370a.k() > 10.0f && !this.f66370a.v()) {
            com.github.mikephil.charting.utils.a g11 = this.f66286c.g(this.f66370a.h(), this.f66370a.j());
            com.github.mikephil.charting.utils.a g12 = this.f66286c.g(this.f66370a.i(), this.f66370a.j());
            if (z11) {
                f13 = (float) g12.f65588c;
                d11 = g11.f65588c;
            } else {
                f13 = (float) g11.f65588c;
                d11 = g12.f65588c;
            }
            com.github.mikephil.charting.utils.a.c(g11);
            com.github.mikephil.charting.utils.a.c(g12);
            f11 = f13;
            f12 = (float) d11;
        }
        b(f11, f12);
    }

    public void b(float f11, float f12) {
        super.b(f11, f12);
        d();
    }

    public void d() {
        String v11 = this.f66373h.v();
        this.f66288e.setTypeface(this.f66373h.c());
        this.f66288e.setTextSize(this.f66373h.b());
        FSize b11 = Utils.b(this.f66288e, v11);
        float f11 = b11.f65542c;
        float a11 = (float) Utils.a(this.f66288e, "Q");
        FSize t11 = Utils.t(f11, a11, this.f66373h.O());
        this.f66373h.I = Math.round(f11);
        this.f66373h.J = Math.round(a11);
        this.f66373h.K = Math.round(t11.f65542c);
        this.f66373h.L = Math.round(t11.f65543d);
        FSize.c(t11);
        FSize.c(b11);
    }

    public void e(Canvas canvas, float f11, float f12, Path path) {
        path.moveTo(f11, this.f66370a.f());
        path.lineTo(f11, this.f66370a.j());
        canvas.drawPath(path, this.f66287d);
        path.reset();
    }

    public void f(Canvas canvas, String str, float f11, float f12, MPPointF mPPointF, float f13) {
        Utils.g(canvas, str, f11, f12, this.f66288e, mPPointF, f13);
    }

    public void g(Canvas canvas, float f11, MPPointF mPPointF) {
        float O = this.f66373h.O();
        boolean x11 = this.f66373h.x();
        int i11 = this.f66373h.f65399n * 2;
        float[] fArr = new float[i11];
        for (int i12 = 0; i12 < i11; i12 += 2) {
            if (x11) {
                fArr[i12] = this.f66373h.f65398m[i12 / 2];
            } else {
                fArr[i12] = this.f66373h.f65397l[i12 / 2];
            }
        }
        this.f66286c.k(fArr);
        for (int i13 = 0; i13 < i11; i13 += 2) {
            float f12 = fArr[i13];
            if (this.f66370a.C(f12)) {
                c w11 = this.f66373h.w();
                XAxis xAxis = this.f66373h;
                String a11 = w11.a(xAxis.f65397l[i13 / 2], xAxis);
                if (this.f66373h.Q()) {
                    int i14 = this.f66373h.f65399n;
                    if (i13 == i14 - 1 && i14 > 1) {
                        float d11 = (float) Utils.d(this.f66288e, a11);
                        if (d11 > this.f66370a.H() * 2.0f && f12 + d11 > this.f66370a.m()) {
                            f12 -= d11 / 2.0f;
                        }
                    } else if (i13 == 0) {
                        f12 += ((float) Utils.d(this.f66288e, a11)) / 2.0f;
                    }
                }
                f(canvas, a11, f12, f11, mPPointF, O);
            }
        }
    }

    public RectF h() {
        this.f66376k.set(this.f66370a.o());
        this.f66376k.inset(-this.f66285b.s(), 0.0f);
        return this.f66376k;
    }

    public void i(Canvas canvas) {
        if (this.f66373h.f() && this.f66373h.A()) {
            float e11 = this.f66373h.e();
            this.f66288e.setTypeface(this.f66373h.c());
            this.f66288e.setTextSize(this.f66373h.b());
            this.f66288e.setColor(this.f66373h.a());
            MPPointF c11 = MPPointF.c(0.0f, 0.0f);
            if (this.f66373h.P() == XAxis.XAxisPosition.TOP) {
                c11.f65546c = 0.5f;
                c11.f65547d = 1.0f;
                g(canvas, this.f66370a.j() - e11, c11);
            } else if (this.f66373h.P() == XAxis.XAxisPosition.TOP_INSIDE) {
                c11.f65546c = 0.5f;
                c11.f65547d = 1.0f;
                g(canvas, this.f66370a.j() + e11 + ((float) this.f66373h.L), c11);
            } else if (this.f66373h.P() == XAxis.XAxisPosition.BOTTOM) {
                c11.f65546c = 0.5f;
                c11.f65547d = 0.0f;
                g(canvas, this.f66370a.f() + e11, c11);
            } else if (this.f66373h.P() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                c11.f65546c = 0.5f;
                c11.f65547d = 0.0f;
                g(canvas, (this.f66370a.f() - e11) - ((float) this.f66373h.L), c11);
            } else {
                c11.f65546c = 0.5f;
                c11.f65547d = 1.0f;
                g(canvas, this.f66370a.j() - e11, c11);
                c11.f65546c = 0.5f;
                c11.f65547d = 0.0f;
                g(canvas, this.f66370a.f() + e11, c11);
            }
            MPPointF.f(c11);
        }
    }

    public void j(Canvas canvas) {
        if (this.f66373h.y() && this.f66373h.f()) {
            this.f66289f.setColor(this.f66373h.l());
            this.f66289f.setStrokeWidth(this.f66373h.n());
            this.f66289f.setPathEffect(this.f66373h.m());
            if (this.f66373h.P() == XAxis.XAxisPosition.TOP || this.f66373h.P() == XAxis.XAxisPosition.TOP_INSIDE || this.f66373h.P() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f66370a.h(), this.f66370a.j(), this.f66370a.i(), this.f66370a.j(), this.f66289f);
            }
            if (this.f66373h.P() == XAxis.XAxisPosition.BOTTOM || this.f66373h.P() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.f66373h.P() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f66370a.h(), this.f66370a.f(), this.f66370a.i(), this.f66370a.f(), this.f66289f);
            }
        }
    }

    public void k(Canvas canvas) {
        if (this.f66373h.z() && this.f66373h.f()) {
            int save = canvas.save();
            canvas.clipRect(h());
            if (this.f66375j.length != this.f66285b.f65399n * 2) {
                this.f66375j = new float[(this.f66373h.f65399n * 2)];
            }
            float[] fArr = this.f66375j;
            for (int i11 = 0; i11 < fArr.length; i11 += 2) {
                float[] fArr2 = this.f66373h.f65397l;
                int i12 = i11 / 2;
                fArr[i11] = fArr2[i12];
                fArr[i11 + 1] = fArr2[i12];
            }
            this.f66286c.k(fArr);
            o();
            Path path = this.f66374i;
            path.reset();
            for (int i13 = 0; i13 < fArr.length; i13 += 2) {
                e(canvas, fArr[i13], fArr[i13 + 1], path);
            }
            canvas.restoreToCount(save);
        }
    }

    public void l(Canvas canvas, LimitLine limitLine, float[] fArr, float f11) {
        String k11 = limitLine.k();
        if (k11 != null && !k11.equals("")) {
            this.f66290g.setStyle(limitLine.p());
            this.f66290g.setPathEffect((PathEffect) null);
            this.f66290g.setColor(limitLine.a());
            this.f66290g.setStrokeWidth(0.5f);
            this.f66290g.setTextSize(limitLine.b());
            float o11 = limitLine.o() + limitLine.d();
            LimitLine.LimitLabelPosition l11 = limitLine.l();
            if (l11 == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                this.f66290g.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(k11, fArr[0] + o11, this.f66370a.j() + f11 + ((float) Utils.a(this.f66290g, k11)), this.f66290g);
            } else if (l11 == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                this.f66290g.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(k11, fArr[0] + o11, this.f66370a.f() - f11, this.f66290g);
            } else if (l11 == LimitLine.LimitLabelPosition.LEFT_TOP) {
                this.f66290g.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(k11, fArr[0] - o11, this.f66370a.j() + f11 + ((float) Utils.a(this.f66290g, k11)), this.f66290g);
            } else {
                this.f66290g.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(k11, fArr[0] - o11, this.f66370a.f() - f11, this.f66290g);
            }
        }
    }

    public void m(Canvas canvas, LimitLine limitLine, float[] fArr) {
        float[] fArr2 = this.f66379n;
        fArr2[0] = fArr[0];
        fArr2[1] = this.f66370a.j();
        float[] fArr3 = this.f66379n;
        fArr3[2] = fArr[0];
        fArr3[3] = this.f66370a.f();
        this.f66380o.reset();
        Path path = this.f66380o;
        float[] fArr4 = this.f66379n;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.f66380o;
        float[] fArr5 = this.f66379n;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.f66290g.setStyle(Paint.Style.STROKE);
        this.f66290g.setColor(limitLine.n());
        this.f66290g.setStrokeWidth(limitLine.o());
        this.f66290g.setPathEffect(limitLine.j());
        canvas.drawPath(this.f66380o, this.f66290g);
    }

    public void n(Canvas canvas) {
        List<LimitLine> u11 = this.f66373h.u();
        if (u11 != null && u11.size() > 0) {
            float[] fArr = this.f66377l;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            for (int i11 = 0; i11 < u11.size(); i11++) {
                LimitLine limitLine = u11.get(i11);
                if (limitLine.f()) {
                    int save = canvas.save();
                    this.f66378m.set(this.f66370a.o());
                    this.f66378m.inset(-limitLine.o(), 0.0f);
                    canvas.clipRect(this.f66378m);
                    fArr[0] = limitLine.m();
                    fArr[1] = 0.0f;
                    this.f66286c.k(fArr);
                    m(canvas, limitLine, fArr);
                    l(canvas, limitLine, fArr, limitLine.e() + 2.0f);
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    public void o() {
        this.f66287d.setColor(this.f66373h.q());
        this.f66287d.setStrokeWidth(this.f66373h.s());
        this.f66287d.setPathEffect(this.f66373h.r());
    }
}

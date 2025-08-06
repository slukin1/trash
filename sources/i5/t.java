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
import com.huobi.view.roundimg.RoundedDrawable;
import java.util.List;
import k5.a;

public class t extends a {

    /* renamed from: h  reason: collision with root package name */
    public YAxis f66384h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f66385i;

    /* renamed from: j  reason: collision with root package name */
    public Path f66386j = new Path();

    /* renamed from: k  reason: collision with root package name */
    public RectF f66387k = new RectF();

    /* renamed from: l  reason: collision with root package name */
    public float[] f66388l = new float[2];

    /* renamed from: m  reason: collision with root package name */
    public Path f66389m = new Path();

    /* renamed from: n  reason: collision with root package name */
    public RectF f66390n = new RectF();

    /* renamed from: o  reason: collision with root package name */
    public Path f66391o = new Path();

    /* renamed from: p  reason: collision with root package name */
    public float[] f66392p = new float[2];

    /* renamed from: q  reason: collision with root package name */
    public RectF f66393q = new RectF();

    public t(ViewPortHandler viewPortHandler, YAxis yAxis, a aVar) {
        super(viewPortHandler, aVar, yAxis);
        this.f66384h = yAxis;
        if (this.f66370a != null) {
            this.f66288e.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            this.f66288e.setTextSize(Utils.e(10.0f));
            Paint paint = new Paint(1);
            this.f66385i = paint;
            paint.setColor(-7829368);
            this.f66385i.setStrokeWidth(1.0f);
            this.f66385i.setStyle(Paint.Style.STROKE);
        }
    }

    public void d(Canvas canvas, float f11, float[] fArr, float f12) {
        int i11 = this.f66384h.Z() ? this.f66384h.f65399n : this.f66384h.f65399n - 1;
        for (int i12 = !this.f66384h.Y(); i12 < i11; i12++) {
            canvas.drawText(this.f66384h.o(i12), f11, fArr[(i12 * 2) + 1] + f12, this.f66288e);
        }
    }

    public void e(Canvas canvas) {
        int save = canvas.save();
        this.f66390n.set(this.f66370a.o());
        this.f66390n.inset(0.0f, -this.f66384h.X());
        canvas.clipRect(this.f66390n);
        com.github.mikephil.charting.utils.a e11 = this.f66286c.e(0.0f, 0.0f);
        this.f66385i.setColor(this.f66384h.W());
        this.f66385i.setStrokeWidth(this.f66384h.X());
        Path path = this.f66389m;
        path.reset();
        path.moveTo(this.f66370a.h(), (float) e11.f65589d);
        path.lineTo(this.f66370a.i(), (float) e11.f65589d);
        canvas.drawPath(path, this.f66385i);
        canvas.restoreToCount(save);
    }

    public RectF f() {
        this.f66387k.set(this.f66370a.o());
        this.f66387k.inset(0.0f, -this.f66285b.s());
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
            fArr[i12 + 1] = this.f66384h.f65397l[i12 / 2];
        }
        this.f66286c.k(fArr);
        return fArr;
    }

    public Path h(Path path, int i11, float[] fArr) {
        int i12 = i11 + 1;
        path.moveTo(this.f66370a.G(), fArr[i12]);
        path.lineTo(this.f66370a.i(), fArr[i12]);
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
            float d11 = this.f66384h.d();
            float a11 = (((float) Utils.a(this.f66288e, "A")) / 2.5f) + this.f66384h.e();
            YAxis.AxisDependency O = this.f66384h.O();
            YAxis.YAxisLabelPosition P = this.f66384h.P();
            if (O == YAxis.AxisDependency.LEFT) {
                if (P == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.f66288e.setTextAlign(Paint.Align.RIGHT);
                    f12 = this.f66370a.G();
                    f11 = f12 - d11;
                    d(canvas, f11, g11, a11);
                }
                this.f66288e.setTextAlign(Paint.Align.LEFT);
                f13 = this.f66370a.G();
            } else if (P == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.f66288e.setTextAlign(Paint.Align.LEFT);
                f13 = this.f66370a.i();
            } else {
                this.f66288e.setTextAlign(Paint.Align.RIGHT);
                f12 = this.f66370a.i();
                f11 = f12 - d11;
                d(canvas, f11, g11, a11);
            }
            f11 = f13 + d11;
            d(canvas, f11, g11, a11);
        }
    }

    public void j(Canvas canvas) {
        if (this.f66384h.f() && this.f66384h.y()) {
            this.f66289f.setColor(this.f66384h.l());
            this.f66289f.setStrokeWidth(this.f66384h.n());
            if (this.f66384h.O() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.f66370a.h(), this.f66370a.j(), this.f66370a.h(), this.f66370a.f(), this.f66289f);
                return;
            }
            canvas.drawLine(this.f66370a.i(), this.f66370a.j(), this.f66370a.i(), this.f66370a.f(), this.f66289f);
        }
    }

    public void k(Canvas canvas) {
        if (this.f66384h.f()) {
            if (this.f66384h.z()) {
                int save = canvas.save();
                canvas.clipRect(f());
                float[] g11 = g();
                this.f66287d.setColor(this.f66384h.q());
                this.f66287d.setStrokeWidth(this.f66384h.s());
                this.f66287d.setPathEffect(this.f66384h.r());
                Path path = this.f66386j;
                path.reset();
                for (int i11 = 0; i11 < g11.length; i11 += 2) {
                    canvas.drawPath(h(path, i11, g11), this.f66287d);
                    path.reset();
                }
                canvas.restoreToCount(save);
            }
            if (this.f66384h.a0()) {
                e(canvas);
            }
        }
    }

    public void l(Canvas canvas) {
        List<LimitLine> u11 = this.f66384h.u();
        if (u11 != null && u11.size() > 0) {
            float[] fArr = this.f66392p;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.f66391o;
            path.reset();
            for (int i11 = 0; i11 < u11.size(); i11++) {
                LimitLine limitLine = u11.get(i11);
                if (limitLine.f()) {
                    int save = canvas.save();
                    this.f66393q.set(this.f66370a.o());
                    this.f66393q.inset(0.0f, -limitLine.o());
                    canvas.clipRect(this.f66393q);
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
                        this.f66290g.setTypeface(limitLine.c());
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

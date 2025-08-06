package i5;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import g5.j;
import java.util.List;
import k5.a;

public class v extends t {

    /* renamed from: r  reason: collision with root package name */
    public RadarChart f66397r;

    /* renamed from: s  reason: collision with root package name */
    public Path f66398s = new Path();

    public v(ViewPortHandler viewPortHandler, YAxis yAxis, RadarChart radarChart) {
        super(viewPortHandler, yAxis, (a) null);
        this.f66397r = radarChart;
    }

    public void b(float f11, float f12) {
        double d11;
        double d12;
        boolean z11;
        float f13 = f11;
        float f14 = f12;
        int t11 = this.f66285b.t();
        double abs = (double) Math.abs(f14 - f13);
        if (t11 == 0 || abs <= 0.0d || Double.isInfinite(abs)) {
            AxisBase axisBase = this.f66285b;
            axisBase.f65397l = new float[0];
            axisBase.f65398m = new float[0];
            axisBase.f65399n = 0;
            return;
        }
        double y11 = (double) Utils.y(abs / ((double) t11));
        if (this.f66285b.D() && y11 < ((double) this.f66285b.p())) {
            y11 = (double) this.f66285b.p();
        }
        double y12 = (double) Utils.y(Math.pow(10.0d, (double) ((int) Math.log10(y11))));
        if (((int) (y11 / y12)) > 5) {
            y11 = Math.floor(y12 * 10.0d);
        }
        boolean x11 = this.f66285b.x();
        if (this.f66285b.C()) {
            float f15 = ((float) abs) / ((float) (t11 - 1));
            AxisBase axisBase2 = this.f66285b;
            axisBase2.f65399n = t11;
            if (axisBase2.f65397l.length < t11) {
                axisBase2.f65397l = new float[t11];
            }
            for (int i11 = 0; i11 < t11; i11++) {
                this.f66285b.f65397l[i11] = f13;
                f13 += f15;
            }
        } else {
            int i12 = (y11 > 0.0d ? 1 : (y11 == 0.0d ? 0 : -1));
            if (i12 == 0) {
                d11 = 0.0d;
            } else {
                d11 = Math.ceil(((double) f13) / y11) * y11;
            }
            if (x11) {
                d11 -= y11;
            }
            if (i12 == 0) {
                d12 = 0.0d;
            } else {
                d12 = Utils.w(Math.floor(((double) f14) / y11) * y11);
            }
            if (i12 != 0) {
                z11 = x11;
                for (double d13 = d11; d13 <= d12; d13 += y11) {
                    z11++;
                }
            } else {
                z11 = x11;
            }
            int i13 = ((int) z11) + 1;
            AxisBase axisBase3 = this.f66285b;
            axisBase3.f65399n = i13;
            if (axisBase3.f65397l.length < i13) {
                axisBase3.f65397l = new float[i13];
            }
            for (int i14 = 0; i14 < i13; i14++) {
                if (d11 == 0.0d) {
                    d11 = 0.0d;
                }
                this.f66285b.f65397l[i14] = (float) d11;
                d11 += y11;
            }
            t11 = i13;
        }
        if (y11 < 1.0d) {
            this.f66285b.f65400o = (int) Math.ceil(-Math.log10(y11));
        } else {
            this.f66285b.f65400o = 0;
        }
        if (x11) {
            AxisBase axisBase4 = this.f66285b;
            if (axisBase4.f65398m.length < t11) {
                axisBase4.f65398m = new float[t11];
            }
            float[] fArr = axisBase4.f65397l;
            float f16 = (fArr[1] - fArr[0]) / 2.0f;
            for (int i15 = 0; i15 < t11; i15++) {
                AxisBase axisBase5 = this.f66285b;
                axisBase5.f65398m[i15] = axisBase5.f65397l[i15] + f16;
            }
        }
        AxisBase axisBase6 = this.f66285b;
        float[] fArr2 = axisBase6.f65397l;
        float f17 = fArr2[0];
        axisBase6.G = f17;
        float f18 = fArr2[t11 - 1];
        axisBase6.F = f18;
        axisBase6.H = Math.abs(f18 - f17);
    }

    public void i(Canvas canvas) {
        if (this.f66384h.f() && this.f66384h.A()) {
            this.f66288e.setTypeface(this.f66384h.c());
            this.f66288e.setTextSize(this.f66384h.b());
            this.f66288e.setColor(this.f66384h.a());
            MPPointF centerOffsets = this.f66397r.getCenterOffsets();
            MPPointF c11 = MPPointF.c(0.0f, 0.0f);
            float factor = this.f66397r.getFactor();
            int i11 = this.f66384h.Z() ? this.f66384h.f65399n : this.f66384h.f65399n - 1;
            for (int i12 = !this.f66384h.Y(); i12 < i11; i12++) {
                YAxis yAxis = this.f66384h;
                Utils.r(centerOffsets, (yAxis.f65397l[i12] - yAxis.G) * factor, this.f66397r.getRotationAngle(), c11);
                canvas.drawText(this.f66384h.o(i12), c11.f65546c + 10.0f, c11.f65547d, this.f66288e);
            }
            MPPointF.f(centerOffsets);
            MPPointF.f(c11);
        }
    }

    public void l(Canvas canvas) {
        List<LimitLine> u11 = this.f66384h.u();
        if (u11 != null) {
            float sliceAngle = this.f66397r.getSliceAngle();
            float factor = this.f66397r.getFactor();
            MPPointF centerOffsets = this.f66397r.getCenterOffsets();
            MPPointF c11 = MPPointF.c(0.0f, 0.0f);
            for (int i11 = 0; i11 < u11.size(); i11++) {
                LimitLine limitLine = u11.get(i11);
                if (limitLine.f()) {
                    this.f66290g.setColor(limitLine.n());
                    this.f66290g.setPathEffect(limitLine.j());
                    this.f66290g.setStrokeWidth(limitLine.o());
                    float m11 = (limitLine.m() - this.f66397r.getYChartMin()) * factor;
                    Path path = this.f66398s;
                    path.reset();
                    for (int i12 = 0; i12 < ((j) ((RadarData) this.f66397r.getData()).l()).getEntryCount(); i12++) {
                        Utils.r(centerOffsets, m11, (((float) i12) * sliceAngle) + this.f66397r.getRotationAngle(), c11);
                        if (i12 == 0) {
                            path.moveTo(c11.f65546c, c11.f65547d);
                        } else {
                            path.lineTo(c11.f65546c, c11.f65547d);
                        }
                    }
                    path.close();
                    canvas.drawPath(path, this.f66290g);
                }
            }
            MPPointF.f(centerOffsets);
            MPPointF.f(c11);
        }
    }
}

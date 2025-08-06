package i5;

import android.graphics.Paint;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.huobi.view.roundimg.RoundedDrawable;

public abstract class a extends o {

    /* renamed from: b  reason: collision with root package name */
    public AxisBase f66285b;

    /* renamed from: c  reason: collision with root package name */
    public k5.a f66286c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f66287d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f66288e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f66289f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f66290g;

    public a(ViewPortHandler viewPortHandler, k5.a aVar, AxisBase axisBase) {
        super(viewPortHandler);
        this.f66286c = aVar;
        this.f66285b = axisBase;
        if (this.f66370a != null) {
            this.f66288e = new Paint(1);
            Paint paint = new Paint();
            this.f66287d = paint;
            paint.setColor(-7829368);
            this.f66287d.setStrokeWidth(1.0f);
            this.f66287d.setStyle(Paint.Style.STROKE);
            this.f66287d.setAlpha(90);
            Paint paint2 = new Paint();
            this.f66289f = paint2;
            paint2.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            this.f66289f.setStrokeWidth(1.0f);
            this.f66289f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(1);
            this.f66290g = paint3;
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public void a(float f11, float f12, boolean z11) {
        float f13;
        double d11;
        ViewPortHandler viewPortHandler = this.f66370a;
        if (viewPortHandler != null && viewPortHandler.k() > 10.0f && !this.f66370a.w()) {
            com.github.mikephil.charting.utils.a g11 = this.f66286c.g(this.f66370a.h(), this.f66370a.j());
            com.github.mikephil.charting.utils.a g12 = this.f66286c.g(this.f66370a.h(), this.f66370a.f());
            if (!z11) {
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

    public void b(float f11, float f12) {
        double d11;
        double d12;
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
        int x11 = this.f66285b.x();
        if (this.f66285b.C()) {
            y11 = (double) (((float) abs) / ((float) (t11 - 1)));
            AxisBase axisBase2 = this.f66285b;
            axisBase2.f65399n = t11;
            if (axisBase2.f65397l.length < t11) {
                axisBase2.f65397l = new float[t11];
            }
            for (int i11 = 0; i11 < t11; i11++) {
                this.f66285b.f65397l[i11] = f13;
                f13 = (float) (((double) f13) + y11);
            }
        } else {
            int i12 = (y11 > 0.0d ? 1 : (y11 == 0.0d ? 0 : -1));
            if (i12 == 0) {
                d11 = 0.0d;
            } else {
                d11 = Math.ceil(((double) f13) / y11) * y11;
            }
            if (this.f66285b.x()) {
                d11 -= y11;
            }
            if (i12 == 0) {
                d12 = 0.0d;
            } else {
                d12 = Utils.w(Math.floor(((double) f14) / y11) * y11);
            }
            if (i12 != 0) {
                for (double d13 = d11; d13 <= d12; d13 += y11) {
                    x11++;
                }
            }
            AxisBase axisBase3 = this.f66285b;
            axisBase3.f65399n = x11;
            if (axisBase3.f65397l.length < x11) {
                axisBase3.f65397l = new float[x11];
            }
            for (int i13 = 0; i13 < x11; i13++) {
                if (d11 == 0.0d) {
                    d11 = 0.0d;
                }
                this.f66285b.f65397l[i13] = (float) d11;
                d11 += y11;
            }
            t11 = x11;
        }
        if (y11 < 1.0d) {
            this.f66285b.f65400o = (int) Math.ceil(-Math.log10(y11));
        } else {
            this.f66285b.f65400o = 0;
        }
        if (this.f66285b.x()) {
            AxisBase axisBase4 = this.f66285b;
            if (axisBase4.f65398m.length < t11) {
                axisBase4.f65398m = new float[t11];
            }
            float f15 = ((float) y11) / 2.0f;
            for (int i14 = 0; i14 < t11; i14++) {
                AxisBase axisBase5 = this.f66285b;
                axisBase5.f65398m[i14] = axisBase5.f65397l[i14] + f15;
            }
        }
    }

    public Paint c() {
        return this.f66288e;
    }
}

package r5;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import com.google.android.material.math.MathUtils;
import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.component.kline.draw.bean.KlineDrawPointBean;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import i6.d;
import java.util.List;
import v5.m;

public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f68307e = PixelUtils.a(4.0f);

    /* renamed from: f  reason: collision with root package name */
    public static final int f68308f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f68309g;

    /* renamed from: a  reason: collision with root package name */
    public KlineDrawLineBean f68310a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68311b = false;

    /* renamed from: c  reason: collision with root package name */
    public CandleStickRender f68312c;

    /* renamed from: d  reason: collision with root package name */
    public m f68313d;

    static {
        int a11 = PixelUtils.a(10.0f);
        f68308f = a11;
        f68309g = a11;
    }

    public a(KlineDrawLineBean klineDrawLineBean, CandleStickRender candleStickRender, m mVar) {
        this.f68310a = klineDrawLineBean;
        this.f68312c = candleStickRender;
        this.f68313d = mVar;
    }

    public void A(KlineDrawPointBean klineDrawPointBean, float f11, float f12) {
        if (!this.f68310a.getLock() && klineDrawPointBean != null) {
            klineDrawPointBean.setX(w(h(f11)));
            klineDrawPointBean.setY(x(i(f12)));
        }
    }

    public void B(KlineDrawPointBean klineDrawPointBean) {
    }

    public void C() {
    }

    public void D(boolean z11) {
        this.f68311b = z11;
    }

    public void E(Paint paint) {
        if (this.f68310a.getLineStyle() == 3) {
            paint.setStyle(Paint.Style.STROKE);
        } else {
            paint.setStyle(Paint.Style.STROKE);
        }
    }

    public float[] a(float f11, float f12, float f13, float f14) {
        float f15 = f11 - f13;
        return new float[]{(f14 - f12) / f15, ((f14 * f11) - (f12 * f13)) / f15};
    }

    public float b(float[] fArr, float[] fArr2, float f11, float f12) {
        if (fArr[0] == fArr2[0]) {
            return Math.abs(f11 - fArr2[0]);
        }
        float f13 = (fArr[1] - fArr2[1]) / (fArr[0] - fArr2[0]);
        float f14 = fArr[1] - (fArr[0] * f13);
        float f15 = -1.0f / f13;
        float[] a11 = a(f13, f14, f15, f12 - (f15 * f11));
        return MathUtils.dist(f11, f12, a11[0], a11[1]);
    }

    public boolean c(float[] fArr, float[] fArr2, float f11, float f12) {
        float f13;
        float f14;
        if (fArr[0] > fArr2[0]) {
            f14 = fArr[0];
            f13 = fArr2[0];
        } else {
            f14 = fArr2[0];
            f13 = fArr[0];
        }
        if (f11 < f13 || f11 > f14 || Math.abs(f12 - fArr[1]) > ((float) f68309g)) {
            return false;
        }
        return true;
    }

    public boolean d(float[] fArr, float[] fArr2, float f11, float f12) {
        float f13;
        float f14;
        if (fArr[1] > fArr2[1]) {
            f14 = fArr[1];
            f13 = fArr2[1];
        } else {
            f14 = fArr2[1];
            f13 = fArr[1];
        }
        if (f12 < f13 || f12 > f14 || Math.abs(f11 - fArr[0]) > ((float) f68309g)) {
            return false;
        }
        return true;
    }

    public boolean e(float[] fArr, float[] fArr2, float f11, float f12) {
        float f13;
        float f14;
        float f15;
        float f16;
        if (fArr[0] > fArr2[0]) {
            f14 = fArr2[0];
            f13 = fArr[0];
        } else {
            f14 = fArr[0];
            f13 = fArr2[0];
        }
        if (fArr[1] > fArr2[1]) {
            f15 = fArr2[1];
            f16 = fArr[1];
        } else {
            float f17 = fArr[1];
            float f18 = fArr2[1];
            f15 = f17;
            f16 = f18;
        }
        if (f11 < f14 || f11 > f13 || f12 < f15 || f12 > f16) {
            return false;
        }
        return true;
    }

    public KlineDrawPointBean f(float f11, float f12) {
        List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
        if (pointList != null) {
            for (KlineDrawPointBean next : pointList) {
                float[] j11 = j(next);
                float dist = MathUtils.dist(f11, f12, j11[0], j11[1]);
                String simpleName = m.class.getSimpleName();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Drawline----checkDownInAnchor----distance = ");
                sb2.append(dist);
                sb2.append("; RADIUS = ");
                int i11 = f68308f;
                sb2.append(i11);
                d.c(simpleName, sb2.toString());
                if (dist <= ((float) i11)) {
                    return next;
                }
            }
        }
        return null;
    }

    public abstract boolean g(float f11, float f12);

    public float h(float f11) {
        if (f11 >= this.f68313d.M0()) {
            return this.f68313d.M0();
        }
        return f11 <= this.f68313d.L0() ? Math.max(this.f68313d.L0(), 1.0f) : f11;
    }

    public float i(float f11) {
        if (f11 >= this.f68313d.K0()) {
            return this.f68313d.K0();
        }
        return f11 <= this.f68313d.N0() ? this.f68313d.N0() : f11;
    }

    public float[] j(KlineDrawPointBean klineDrawPointBean) {
        return new float[]{v(klineDrawPointBean.getX()), u(klineDrawPointBean.getY())};
    }

    public final DashPathEffect k(int i11) {
        if (i11 == 1) {
            return new DashPathEffect(new float[]{(float) PixelUtils.a(4.0f), (float) PixelUtils.a(1.0f)}, 0.0f);
        } else if (i11 != 2) {
            return null;
        } else {
            return new DashPathEffect(new float[]{(float) PixelUtils.a(1.5f), (float) PixelUtils.a(1.5f)}, 0.0f);
        }
    }

    public KlineDrawPointBean l(float f11, float f12) {
        KlineDrawPointBean klineDrawPointBean = new KlineDrawPointBean();
        klineDrawPointBean.setX(w(f11));
        klineDrawPointBean.setY(x(f12));
        this.f68310a.getPointList().add(klineDrawPointBean);
        return klineDrawPointBean;
    }

    public void m(Canvas canvas, float f11, float f12, Paint paint) {
        d.c(m.class.getSimpleName(), String.format("drawline drawAnchor -----> x = %f; y = %f;", new Object[]{Float.valueOf(f11), Float.valueOf(f12)}));
        paint.setPathEffect((PathEffect) null);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(48);
        canvas.drawCircle(f11, f12, (float) f68308f, paint);
        paint.setAlpha(255);
        canvas.drawCircle(f11, f12, (float) f68307e, paint);
    }

    public void n(Canvas canvas, float f11, float f12, float f13, float f14, int i11, Paint paint) {
        paint.setPathEffect(k(i11));
        E(paint);
        canvas.drawLine(f11, f12, f13, f14, paint);
    }

    public abstract void o(Canvas canvas, Paint paint);

    public void p(Canvas canvas, Path path, Paint paint) {
        paint.setPathEffect(k(this.f68310a.getLineStyle()));
        E(paint);
        canvas.drawPath(path, paint);
    }

    public final float q(int i11) {
        return ((float) (this.f68312c.o0() + this.f68312c.j0(i11))) + (this.f68312c.f67282w0 / 2.0f);
    }

    public KlineDrawLineBean r() {
        return this.f68310a;
    }

    public final long s() {
        return (long) (((float) CandleStickRender.KLineType.getKlineTimePerUnit(this.f68312c.N1())) / this.f68312c.f67282w0);
    }

    public boolean t() {
        return this.f68311b;
    }

    public float u(float f11) {
        float[] fArr = {0.0f, f11};
        this.f68312c.O.mapPoints(fArr);
        return fArr[1];
    }

    public float v(long j11) {
        float f11 = 0.0f;
        if (this.f68312c.z1() == null) {
            return 0.0f;
        }
        int i22 = this.f68312c.i2();
        if (i22 >= 0 && i22 < this.f68312c.z1().size()) {
            KlineInfo klineInfo = this.f68312c.z1().get(i22);
            float q11 = q(i22);
            long s11 = s();
            if (s11 > 0) {
                f11 = ((float) ((j11 - klineInfo.getId()) / s11)) + q11;
            }
            String simpleName = m.class.getSimpleName();
            d.c(simpleName, "mapTsToX stepTs = " + s11 + "; targetX = " + f11 + "; x = " + j11);
        }
        return f11;
    }

    public long w(float f11) {
        int i22;
        if (this.f68312c.z1() == null || (i22 = this.f68312c.i2()) < 0 || i22 >= this.f68312c.z1().size()) {
            return 0;
        }
        float q11 = q(i22);
        long s11 = s();
        long id2 = this.f68312c.z1().get(i22).getId() + ((long) ((f11 - q11) * ((float) s11)));
        String simpleName = m.class.getSimpleName();
        d.c(simpleName, "mapXToTs stepTs = " + s11 + "; targetTs = " + id2 + "; x = " + f11);
        return id2;
    }

    public float x(float f11) {
        float[] fArr = {0.0f, f11};
        Matrix matrix = new Matrix();
        this.f68312c.O.invert(matrix);
        matrix.mapPoints(fArr);
        return fArr[1];
    }

    public void y(float f11, float f12, float f13, float f14) {
        if (!this.f68310a.getLock()) {
            if (f11 >= this.f68313d.M0() || f11 <= this.f68313d.L0()) {
                f13 = 0.0f;
            }
            if (f12 >= this.f68313d.K0() || f12 <= this.f68313d.N0()) {
                f14 = 0.0f;
            }
            for (KlineDrawPointBean z11 : this.f68310a.getPointList()) {
                z(z11, f13, f14);
            }
        }
    }

    public final void z(KlineDrawPointBean klineDrawPointBean, float f11, float f12) {
        float[] j11 = j(klineDrawPointBean);
        j11[0] = j11[0] + f11;
        j11[1] = j11[1] + f12;
        klineDrawPointBean.setX(w(j11[0]));
        klineDrawPointBean.setY(x(j11[1]));
    }
}

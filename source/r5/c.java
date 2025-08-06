package r5;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.component.kline.draw.bean.KlineDrawPointBean;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.lib.common.utils.PixelUtils;
import java.util.List;
import v5.m;

public class c extends a {

    /* renamed from: h  reason: collision with root package name */
    public float[] f68314h = new float[2];

    public c(KlineDrawLineBean klineDrawLineBean, CandleStickRender candleStickRender, m mVar) {
        super(klineDrawLineBean, candleStickRender, mVar);
    }

    public void A(KlineDrawPointBean klineDrawPointBean, float f11, float f12) {
        if (!this.f68310a.getLock() && klineDrawPointBean != null) {
            float h11 = h(f11);
            float i11 = i(f12);
            List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
            int size = pointList.size();
            int indexOf = pointList.indexOf(klineDrawPointBean);
            if (size == 3) {
                KlineDrawPointBean klineDrawPointBean2 = pointList.get(2);
                float[] j11 = j(pointList.get(0));
                float[] j12 = j(pointList.get(1));
                float[] j13 = j(klineDrawPointBean2);
                if (indexOf == 0) {
                    F(klineDrawPointBean2, j11, j12, j13, h11, i11);
                    super.A(klineDrawPointBean, h11, i11);
                } else if (indexOf == 1) {
                    F(klineDrawPointBean2, j12, j11, j13, h11, i11);
                    super.A(klineDrawPointBean, h11, i11);
                } else {
                    klineDrawPointBean2.setY(x(i(i11)));
                }
            }
        }
    }

    public void B(KlineDrawPointBean klineDrawPointBean) {
        List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
        int size = pointList.size();
        int indexOf = pointList.indexOf(klineDrawPointBean);
        if (size == 3) {
            float[] j11 = j(pointList.get(0));
            float[] j12 = j(pointList.get(1));
            float[] j13 = j(pointList.get(2));
            if (indexOf == 0) {
                J(j11, j12, j13);
            } else if (indexOf == 1) {
                J(j12, j11, j13);
            }
        }
    }

    public void C() {
        this.f68314h = null;
    }

    public final void F(KlineDrawPointBean klineDrawPointBean, float[] fArr, float[] fArr2, float[] fArr3, float f11, float f12) {
        float f13;
        float f14;
        float[] fArr4 = {f11, f12};
        float f15 = (f11 + fArr2[0]) / 2.0f;
        if (fArr4[0] == fArr2[0]) {
            f14 = this.f68314h[1];
            f13 = (f12 - fArr2[1]) / 2.0f;
        } else {
            float G = G(fArr4, fArr2);
            float[] fArr5 = this.f68314h;
            f13 = fArr5[1] - (fArr5[0] * G);
            f14 = G * f15;
        }
        klineDrawPointBean.setX(w(f15));
        klineDrawPointBean.setY(x(f14 + f13));
    }

    public final float G(float[] fArr, float[] fArr2) {
        return (fArr2[1] - fArr[1]) / (fArr2[0] - fArr[0]);
    }

    public final void H(Canvas canvas, Path path, Paint paint) {
        paint.setPathEffect(new DashPathEffect(new float[]{(float) PixelUtils.a(4.0f), (float) PixelUtils.a(3.0f)}, 0.0f));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);
        paint.setAlpha(255);
    }

    public final void I(Canvas canvas, Path path, Paint paint) {
        paint.setAlpha(48);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
        paint.setAlpha(255);
    }

    public final void J(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArr4 = new float[2];
        this.f68314h = fArr4;
        fArr4[0] = fArr2[0];
        if (fArr[0] == fArr2[0]) {
            fArr4[1] = fArr3[1] - ((fArr[1] - fArr2[1]) / 2.0f);
            return;
        }
        float G = G(fArr, fArr2);
        float f11 = fArr3[1] - (fArr3[0] * G);
        float[] fArr5 = this.f68314h;
        fArr5[1] = (fArr5[0] * G) + f11;
    }

    public boolean g(float f11, float f12) {
        List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
        if (pointList != null && pointList.size() >= 3) {
            float[] j11 = j(pointList.get(0));
            float[] j12 = j(pointList.get(1));
            float[] j13 = j(pointList.get(2));
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            fArr[0] = j12[0];
            fArr2[0] = j11[0];
            float G = G(j11, j12);
            float f13 = j11[1] - (j11[0] * G);
            float f14 = j13[1] - (j13[0] * G);
            fArr[1] = (fArr[0] * G) + f14;
            fArr2[1] = (fArr2[0] * G) + f14;
            float max = Math.max(j11[0], j12[0]);
            if (f11 >= Math.min(j11[0], j12[0]) && f11 <= max) {
                float f15 = G * f11;
                float f16 = f13 + f15;
                float f17 = f15 + f14;
                float max2 = Math.max(f16, f17);
                if (f12 < Math.min(f16, f17) || f12 > max2) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public KlineDrawPointBean l(float f11, float f12) {
        List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
        if (pointList.size() <= 1) {
            return super.l(f11, f12);
        }
        if (pointList.size() != 2) {
            return null;
        }
        float[] j11 = j(pointList.get(0));
        float[] j12 = j(pointList.get(1));
        KlineDrawPointBean klineDrawPointBean = new KlineDrawPointBean();
        klineDrawPointBean.setX(w((j11[0] + j12[0]) / 2.0f));
        klineDrawPointBean.setY(x(f12));
        this.f68310a.getPointList().add(klineDrawPointBean);
        return klineDrawPointBean;
    }

    public void o(Canvas canvas, Paint paint) {
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        int size = this.f68310a.getPointList().size();
        if (size != 0) {
            paint2.setColor(this.f68310a.getLineColor());
            paint2.setStrokeWidth(this.f68310a.getLineSize());
            float[] j11 = j(this.f68310a.getPointList().get(0));
            if (t()) {
                m(canvas2, j11[0], j11[1], paint2);
            }
            Path path = new Path();
            path.moveTo(j11[0], j11[1]);
            if (size > 1) {
                float[] j12 = j(this.f68310a.getPointList().get(1));
                if (t()) {
                    m(canvas2, j12[0], j12[1], paint2);
                }
                path.lineTo(j12[0], j12[1]);
                if (size > 2) {
                    float[] j13 = j(this.f68310a.getPointList().get(2));
                    if (t()) {
                        m(canvas2, j13[0], j13[1], paint2);
                    }
                    float[] fArr = new float[2];
                    float[] fArr2 = new float[2];
                    fArr[0] = j12[0];
                    fArr2[0] = j11[0];
                    float G = G(j11, j12);
                    if (j11[0] == j12[0]) {
                        fArr[1] = j13[1] + ((j12[1] - j11[1]) / 2.0f);
                        fArr2[1] = j13[1] - ((j12[1] - j11[1]) / 2.0f);
                    } else {
                        float f11 = j13[1] - (j13[0] * G);
                        float[] fArr3 = this.f68314h;
                        if (fArr3 == null) {
                            fArr[1] = (fArr[0] * G) + f11;
                            fArr2[1] = (fArr2[0] * G) + f11;
                        } else if (fArr[0] == fArr3[0]) {
                            fArr[1] = fArr3[1];
                            fArr2[1] = (fArr2[0] * G) + f11;
                        } else if (fArr2[0] == fArr3[0]) {
                            fArr2[1] = fArr3[1];
                            fArr[1] = (fArr[0] * G) + f11;
                        } else {
                            fArr[1] = (fArr[0] * G) + f11;
                            fArr2[1] = (fArr2[0] * G) + f11;
                        }
                    }
                    path.moveTo(fArr[0], fArr[1]);
                    path.lineTo(fArr2[0], fArr2[1]);
                    Path path2 = new Path();
                    path2.moveTo(j11[0], j11[1]);
                    path2.lineTo(j12[0], j12[1]);
                    path2.lineTo(fArr[0], fArr[1]);
                    path2.lineTo(fArr2[0], fArr2[1]);
                    I(canvas2, path2, paint2);
                    float[] fArr4 = {(j11[0] + fArr2[0]) / 2.0f, (j11[1] + fArr2[1]) / 2.0f};
                    float[] fArr5 = {(j12[0] + fArr[0]) / 2.0f, (j12[1] + fArr[1]) / 2.0f};
                    Path path3 = new Path();
                    path3.moveTo(fArr4[0], fArr4[1]);
                    path3.lineTo(fArr5[0], fArr5[1]);
                    H(canvas2, path3, paint2);
                }
            }
            p(canvas2, path, paint2);
        }
    }
}

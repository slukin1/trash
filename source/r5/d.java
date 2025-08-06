package r5;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.component.kline.draw.bean.KlineDrawPointBean;
import com.hbg.component.kline.render.CandleStickRender;
import java.util.List;
import v5.m;

public class d extends a {
    public d(KlineDrawLineBean klineDrawLineBean, CandleStickRender candleStickRender, m mVar) {
        super(klineDrawLineBean, candleStickRender, mVar);
    }

    public final float[] F(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArr4 = new float[2];
        float f11 = (fArr2[1] - fArr[1]) / (fArr2[0] - fArr[0]);
        float f12 = fArr[1];
        float f13 = fArr[0];
        float f14 = (fArr3[1] - fArr2[1]) / (fArr3[0] - fArr2[0]);
        float f15 = fArr2[1];
        float f16 = fArr2[0];
        float f17 = fArr3[1] - (fArr3[0] * f11);
        float f18 = fArr[1] - (fArr[0] * f14);
        if (fArr2[0] == fArr[0] && fArr3[0] == fArr2[0]) {
            fArr4[0] = fArr3[0];
            fArr4[1] = fArr3[1];
        } else if (fArr2[0] == fArr[0]) {
            float f19 = fArr[1] - (fArr[0] * f14);
            fArr4[0] = fArr3[0];
            fArr4[1] = (fArr4[0] * f14) + f19;
        } else if (fArr3[0] == fArr2[0]) {
            fArr4[0] = fArr[0];
            fArr4[1] = (fArr4[0] * f11) + (fArr3[1] - (fArr3[0] * f11));
        } else {
            float f21 = f11 - f14;
            fArr4[0] = (f18 - f17) / f21;
            fArr4[1] = ((f18 * f11) - (f17 * f14)) / f21;
        }
        return fArr4;
    }

    public final boolean G(float[] fArr, float[] fArr2, float f11, float f12) {
        return b(fArr, fArr2, f11, f12) <= ((float) a.f68309g);
    }

    public boolean g(float f11, float f12) {
        List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
        if (pointList != null && pointList.size() >= 3) {
            float[] j11 = j(pointList.get(0));
            float[] j12 = j(pointList.get(1));
            float[] j13 = j(pointList.get(2));
            float[] F = F(j11, j12, j13);
            if (e(j11, j12, f11, f12)) {
                return G(j11, j12, f11, f12);
            }
            if (e(j12, j13, f11, f12)) {
                return G(j12, j13, f11, f12);
            }
            if (e(j13, F, f11, f12)) {
                return G(j13, F, f11, f12);
            }
            if (e(F, j11, f11, f12)) {
                return G(F, j11, f11, f12);
            }
        }
        return false;
    }

    public void o(Canvas canvas, Paint paint) {
        int size = this.f68310a.getPointList().size();
        if (size != 0) {
            paint.setColor(this.f68310a.getLineColor());
            paint.setStrokeWidth(this.f68310a.getLineSize());
            float[] j11 = j(this.f68310a.getPointList().get(0));
            if (t()) {
                m(canvas, j11[0], j11[1], paint);
            }
            Path path = new Path();
            path.moveTo(j11[0], j11[1]);
            if (size > 1) {
                float[] j12 = j(this.f68310a.getPointList().get(1));
                if (t()) {
                    m(canvas, j12[0], j12[1], paint);
                }
                path.lineTo(j12[0], j12[1]);
                if (size > 2) {
                    float[] j13 = j(this.f68310a.getPointList().get(2));
                    float[] F = F(j11, j12, j13);
                    if (t()) {
                        m(canvas, j13[0], j13[1], paint);
                    }
                    path.lineTo(j13[0], j13[1]);
                    path.lineTo(F[0], F[1]);
                    path.lineTo(j11[0], j11[1]);
                }
            }
            p(canvas, path, paint);
        }
    }
}

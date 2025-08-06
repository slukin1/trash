package r5;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.google.android.material.math.MathUtils;
import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.component.kline.draw.bean.KlineDrawPointBean;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.lib.common.utils.PixelUtils;
import java.util.List;
import v5.m;

public class e extends a {
    public e(KlineDrawLineBean klineDrawLineBean, CandleStickRender candleStickRender, m mVar) {
        super(klineDrawLineBean, candleStickRender, mVar);
    }

    public final float[] F(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[2];
        float f11 = (fArr2[1] - fArr[1]) / (fArr2[0] - fArr[0]);
        float f12 = fArr2[1] - (fArr2[0] * f11);
        if (fArr2[1] == fArr[1]) {
            if (fArr2[0] >= fArr[0]) {
                fArr3[0] = (float) PixelUtils.g();
            } else {
                fArr3[0] = 0.0f;
            }
            fArr3[1] = fArr[1];
        } else if (fArr2[0] == fArr[0]) {
            if (fArr2[1] >= fArr[1]) {
                fArr3[1] = 0.0f;
            } else {
                fArr3[1] = (float) PixelUtils.f();
            }
            fArr3[0] = fArr[0];
        } else if (fArr2[1] < fArr[1]) {
            fArr3[0] = (0.0f - f12) / (f11 - 0.0f);
            fArr3[1] = 0.0f;
        } else if (fArr2[1] > fArr[1]) {
            fArr3[0] = (((float) PixelUtils.f()) - f12) / (f11 - 0.0f);
            fArr3[1] = (float) PixelUtils.f();
        }
        return fArr3;
    }

    public boolean g(float f11, float f12) {
        List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
        if (pointList == null || pointList.size() < 2) {
            return false;
        }
        float[] j11 = j(pointList.get(0));
        float[] j12 = j(pointList.get(1));
        float[] F = F(j11, j12);
        if (MathUtils.dist(j11[0], j11[1], F[0], F[1]) <= MathUtils.dist(j12[0], j12[1], F[0], F[1])) {
            j11 = j12;
        }
        if (!e(j11, F, f11, f12) || b(j11, F, f11, f12) > ((float) a.f68309g)) {
            return false;
        }
        return true;
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
            if (size > 1) {
                float[] j12 = j(this.f68310a.getPointList().get(1));
                if (t()) {
                    m(canvas, j12[0], j12[1], paint);
                }
                float[] F = F(j11, j12);
                Path path = new Path();
                path.moveTo(j11[0], j11[1]);
                path.lineTo(j12[0], j12[1]);
                path.lineTo(F[0], F[1]);
                p(canvas, path, paint);
            }
        }
    }
}

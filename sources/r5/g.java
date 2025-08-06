package r5;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.component.kline.draw.bean.KlineDrawPointBean;
import com.hbg.component.kline.render.CandleStickRender;
import i6.d;
import java.util.List;
import v5.m;

public class g extends a {
    public g(KlineDrawLineBean klineDrawLineBean, CandleStickRender candleStickRender, m mVar) {
        super(klineDrawLineBean, candleStickRender, mVar);
    }

    public boolean g(float f11, float f12) {
        List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
        if (pointList == null || pointList.size() < 2) {
            return false;
        }
        float[] j11 = j(pointList.get(0));
        float[] j12 = j(pointList.get(1));
        if (!e(j11, j12, f11, f12) || b(j11, j12, f11, f12) > ((float) a.f68309g)) {
            return false;
        }
        return true;
    }

    public void o(Canvas canvas, Paint paint) {
        int size = this.f68310a.getPointList().size();
        d.c(m.class.getSimpleName(), String.format("drawline drawSegment -----> x = %d;", new Object[]{Integer.valueOf(size)}));
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
                n(canvas, j11[0], j11[1], j12[0], j12[1], this.f68310a.getLineStyle(), paint);
            }
        }
    }
}

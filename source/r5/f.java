package r5;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.component.kline.draw.bean.KlineDrawPointBean;
import com.hbg.component.kline.render.CandleStickRender;
import java.util.List;
import v5.m;

public class f extends a {
    public f(KlineDrawLineBean klineDrawLineBean, CandleStickRender candleStickRender, m mVar) {
        super(klineDrawLineBean, candleStickRender, mVar);
    }

    public void E(Paint paint) {
        super.E(paint);
    }

    public boolean g(float f11, float f12) {
        List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
        if (pointList != null && pointList.size() >= 2) {
            float[] j11 = j(pointList.get(0));
            float[] j12 = j(pointList.get(1));
            float[] fArr = {j12[0], j11[1]};
            float[] fArr2 = {j11[0], j12[1]};
            if (!c(j11, fArr, f11, f12) && !c(j12, fArr2, f11, f12) && !d(j11, fArr2, f11, f12) && !d(j12, fArr, f11, f12)) {
                return false;
            }
            return true;
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
            if (size > 1) {
                float[] j12 = j(this.f68310a.getPointList().get(1));
                if (t()) {
                    m(canvas, j12[0], j12[1], paint);
                }
                Path path = new Path();
                path.moveTo(j11[0], j11[1]);
                path.lineTo(j12[0], j11[1]);
                path.lineTo(j12[0], j12[1]);
                path.lineTo(j11[0], j12[1]);
                path.lineTo(j11[0], j11[1]);
                p(canvas, path, paint);
            }
        }
    }
}

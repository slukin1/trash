package r5;

import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.component.kline.draw.bean.KlineDrawPointBean;
import com.hbg.component.kline.render.CandleStickRender;
import i6.d;
import java.util.List;
import v5.m;

public class b extends g {
    public b(KlineDrawLineBean klineDrawLineBean, CandleStickRender candleStickRender, m mVar) {
        super(klineDrawLineBean, candleStickRender, mVar);
    }

    public void A(KlineDrawPointBean klineDrawPointBean, float f11, float f12) {
        if (!this.f68310a.getLock() && klineDrawPointBean != null) {
            if (this.f68310a.getPointList().size() == 1) {
                super.A(klineDrawPointBean, f11, f12);
            } else {
                klineDrawPointBean.setX(w(h(f11)));
            }
        }
    }

    public boolean g(float f11, float f12) {
        List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
        if (pointList == null || pointList.size() < 2) {
            return false;
        }
        return c(j(pointList.get(0)), j(pointList.get(1)), f11, f12);
    }

    public KlineDrawPointBean l(float f11, float f12) {
        List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
        if (pointList.size() == 0) {
            return super.l(f11, f12);
        }
        if (pointList.size() != 1) {
            return null;
        }
        KlineDrawPointBean klineDrawPointBean = pointList.get(0);
        d.c(b.class.getSimpleName(), String.format("drawline drawSegment -----> x = %f;", new Object[]{Float.valueOf(klineDrawPointBean.getY())}));
        KlineDrawPointBean klineDrawPointBean2 = new KlineDrawPointBean();
        klineDrawPointBean2.setX(w(f11));
        klineDrawPointBean2.setY(klineDrawPointBean.getY());
        this.f68310a.getPointList().add(klineDrawPointBean2);
        return klineDrawPointBean2;
    }
}

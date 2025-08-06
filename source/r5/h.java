package r5;

import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.component.kline.draw.bean.KlineDrawPointBean;
import com.hbg.component.kline.render.CandleStickRender;
import java.util.List;
import v5.m;

public class h extends g {
    public h(KlineDrawLineBean klineDrawLineBean, CandleStickRender candleStickRender, m mVar) {
        super(klineDrawLineBean, candleStickRender, mVar);
    }

    public void A(KlineDrawPointBean klineDrawPointBean, float f11, float f12) {
        if (!this.f68310a.getLock() && klineDrawPointBean != null) {
            if (this.f68310a.getPointList().size() == 1) {
                super.A(klineDrawPointBean, f11, f12);
            } else {
                klineDrawPointBean.setY(x(i(f12)));
            }
        }
    }

    public boolean g(float f11, float f12) {
        List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
        if (pointList == null || pointList.size() < 2) {
            return false;
        }
        return d(j(pointList.get(0)), j(pointList.get(1)), f11, f12);
    }

    public KlineDrawPointBean l(float f11, float f12) {
        List<KlineDrawPointBean> pointList = this.f68310a.getPointList();
        if (pointList.size() == 0) {
            return super.l(f11, f12);
        }
        if (pointList.size() != 1) {
            return null;
        }
        KlineDrawPointBean klineDrawPointBean = new KlineDrawPointBean();
        klineDrawPointBean.setX(pointList.get(0).getX());
        klineDrawPointBean.setY(x(f12));
        this.f68310a.getPointList().add(klineDrawPointBean);
        return klineDrawPointBean;
    }
}

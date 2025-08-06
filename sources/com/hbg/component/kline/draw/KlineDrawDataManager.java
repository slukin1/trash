package com.hbg.component.kline.draw;

import android.text.TextUtils;
import com.hbg.component.kline.db.KlineDbHelper;
import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.component.kline.render.CandleStickRender;
import java.util.ArrayList;
import java.util.List;
import q5.a;
import r5.b;
import r5.c;
import r5.d;
import r5.e;
import r5.f;
import r5.g;
import r5.h;
import v5.m;

public class KlineDrawDataManager {
    public static void a() {
        KlineDbHelper.b(a.g().i(), a.g().h());
    }

    public static r5.a b(CandleStickRender candleStickRender, m mVar) {
        KlineDrawLineBean klineDrawLineBean = new KlineDrawLineBean();
        klineDrawLineBean.setLineType(a.g().f());
        klineDrawLineBean.setSymbolId(a.g().i());
        klineDrawLineBean.setPeriod(a.g().h());
        g(klineDrawLineBean);
        return c(klineDrawLineBean, candleStickRender, mVar);
    }

    public static r5.a c(KlineDrawLineBean klineDrawLineBean, CandleStickRender candleStickRender, m mVar) {
        switch (klineDrawLineBean.getLineType()) {
            case 2:
                return new b(klineDrawLineBean, candleStickRender, mVar);
            case 3:
                return new h(klineDrawLineBean, candleStickRender, mVar);
            case 4:
                return new e(klineDrawLineBean, candleStickRender, mVar);
            case 5:
                return new c(klineDrawLineBean, candleStickRender, mVar);
            case 6:
                return new f(klineDrawLineBean, candleStickRender, mVar);
            case 7:
                return new d(klineDrawLineBean, candleStickRender, mVar);
            default:
                return new g(klineDrawLineBean, candleStickRender, mVar);
        }
    }

    public static void d(KlineDrawLineBean klineDrawLineBean) {
        KlineDbHelper.a(klineDrawLineBean);
    }

    public static List<r5.a> e(CandleStickRender candleStickRender, m mVar) {
        List<KlineDrawLineBean> e11;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(a.g().i()) && !TextUtils.isEmpty(a.g().h()) && (e11 = KlineDbHelper.e(a.g().i(), a.g().h(), 100)) != null) {
            for (KlineDrawLineBean c11 : e11) {
                arrayList.add(c(c11, candleStickRender, mVar));
            }
        }
        return arrayList;
    }

    public static void f(KlineDrawLineBean klineDrawLineBean) {
        KlineDbHelper.h(klineDrawLineBean);
    }

    public static void g(KlineDrawLineBean klineDrawLineBean) {
        if (klineDrawLineBean != null) {
            klineDrawLineBean.setLineStyle(a.g().e());
            klineDrawLineBean.setLineSize(a.g().c());
            klineDrawLineBean.setLineSizeIndex(a.g().d());
            klineDrawLineBean.setLineColor(a.g().a());
            klineDrawLineBean.setLineColorIndex(a.g().b());
            klineDrawLineBean.setUpdateTimestamp(System.currentTimeMillis());
        }
    }
}

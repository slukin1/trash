package vo;

import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.huobi.trade.handler.PlanOrderHandler;
import s9.a;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public AlgoOrderInfo f85000b;

    public b(AlgoOrderInfo algoOrderInfo) {
        this.f85000b = algoOrderInfo;
    }

    public Long a() {
        AlgoOrderInfo algoOrderInfo = this.f85000b;
        if (algoOrderInfo == null) {
            return 0L;
        }
        return Long.valueOf(algoOrderInfo.getId());
    }

    public AlgoOrderInfo c() {
        return this.f85000b;
    }

    public String d() {
        return this.f85000b.getSymbol();
    }

    public String getViewHandlerName() {
        return PlanOrderHandler.class.getName();
    }
}

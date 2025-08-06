package vk;

import com.hbg.lib.network.hbg.core.bean.UsdtExchangeHistoryDetailBean;
import com.huobi.finance.viewhandler.UsdtExchangeHistoryDetailViewHandler;
import s9.a;

public class w implements a {

    /* renamed from: b  reason: collision with root package name */
    public UsdtExchangeHistoryDetailBean f48016b;

    public w(UsdtExchangeHistoryDetailBean usdtExchangeHistoryDetailBean) {
        this.f48016b = usdtExchangeHistoryDetailBean;
    }

    public boolean a(Object obj) {
        return obj instanceof w;
    }

    public UsdtExchangeHistoryDetailBean c() {
        return this.f48016b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        if (!wVar.a(this)) {
            return false;
        }
        UsdtExchangeHistoryDetailBean c11 = c();
        UsdtExchangeHistoryDetailBean c12 = wVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return UsdtExchangeHistoryDetailViewHandler.class.getName();
    }

    public int hashCode() {
        UsdtExchangeHistoryDetailBean c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "UsdtExchangeHistoryDetailItem(data=" + c() + ")";
    }
}

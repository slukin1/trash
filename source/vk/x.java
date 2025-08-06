package vk;

import com.hbg.lib.network.hbg.core.bean.UsdtExchangeHistoryBean;
import com.huobi.finance.viewhandler.UsdtExchangeHistoryViewHandler;
import s9.a;

public class x implements a {

    /* renamed from: b  reason: collision with root package name */
    public UsdtExchangeHistoryBean f48017b;

    public x(UsdtExchangeHistoryBean usdtExchangeHistoryBean) {
        this.f48017b = usdtExchangeHistoryBean;
    }

    public boolean a(Object obj) {
        return obj instanceof x;
    }

    public UsdtExchangeHistoryBean c() {
        return this.f48017b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (!xVar.a(this)) {
            return false;
        }
        UsdtExchangeHistoryBean c11 = c();
        UsdtExchangeHistoryBean c12 = xVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return UsdtExchangeHistoryViewHandler.class.getName();
    }

    public int hashCode() {
        UsdtExchangeHistoryBean c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "UsdtExchangeHistoryItem(data=" + c() + ")";
    }
}

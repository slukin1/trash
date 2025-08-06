package vk;

import com.hbg.lib.network.hbg.core.bean.HtExchangeHistoryBean;
import com.huobi.finance.viewhandler.HtExchangeHistoryViewHandler;
import s9.a;

public class q implements a {

    /* renamed from: b  reason: collision with root package name */
    public HtExchangeHistoryBean f48003b;

    public q(HtExchangeHistoryBean htExchangeHistoryBean) {
        this.f48003b = htExchangeHistoryBean;
    }

    public boolean a(Object obj) {
        return obj instanceof q;
    }

    public HtExchangeHistoryBean c() {
        return this.f48003b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (!qVar.a(this)) {
            return false;
        }
        HtExchangeHistoryBean c11 = c();
        HtExchangeHistoryBean c12 = qVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return HtExchangeHistoryViewHandler.class.getName();
    }

    public int hashCode() {
        HtExchangeHistoryBean c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "HtExchangeHistoryItem(data=" + c() + ")";
    }
}

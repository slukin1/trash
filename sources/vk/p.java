package vk;

import com.hbg.lib.network.hbg.core.bean.HtExchangeHistoryDetailBean;
import com.huobi.finance.viewhandler.HtExchangeHistoryDetailViewHandler;
import s9.a;

public class p implements a {

    /* renamed from: b  reason: collision with root package name */
    public HtExchangeHistoryDetailBean f48002b;

    public p(HtExchangeHistoryDetailBean htExchangeHistoryDetailBean) {
        this.f48002b = htExchangeHistoryDetailBean;
    }

    public boolean a(Object obj) {
        return obj instanceof p;
    }

    public HtExchangeHistoryDetailBean c() {
        return this.f48002b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (!pVar.a(this)) {
            return false;
        }
        HtExchangeHistoryDetailBean c11 = c();
        HtExchangeHistoryDetailBean c12 = pVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return HtExchangeHistoryDetailViewHandler.class.getName();
    }

    public int hashCode() {
        HtExchangeHistoryDetailBean c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "HtExchangeHistoryDetailItem(data=" + c() + ")";
    }
}

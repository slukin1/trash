package vk;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapFinancialRecord;
import com.huobi.finance.viewhandler.LinearSwapTransferOrderViewHandler;
import s9.a;

public class t implements a {

    /* renamed from: b  reason: collision with root package name */
    public LinearSwapFinancialRecord.FinancialRecord f48012b;

    public t(LinearSwapFinancialRecord.FinancialRecord financialRecord) {
        this.f48012b = financialRecord;
    }

    public boolean a(Object obj) {
        return obj instanceof t;
    }

    public LinearSwapFinancialRecord.FinancialRecord c() {
        return this.f48012b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (!tVar.a(this)) {
            return false;
        }
        LinearSwapFinancialRecord.FinancialRecord c11 = c();
        LinearSwapFinancialRecord.FinancialRecord c12 = tVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return LinearSwapTransferOrderViewHandler.class.getName();
    }

    public int hashCode() {
        LinearSwapFinancialRecord.FinancialRecord c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "LinearSwapInnerTransferHistory(data=" + c() + ")";
    }
}

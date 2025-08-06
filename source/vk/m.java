package vk;

import com.hbg.lib.network.hbg.core.bean.CopyTradingAccountTransferRecord;
import com.huobi.finance.viewhandler.CopyTradingTransferOrderViewHandler;
import s9.a;

public class m implements a {

    /* renamed from: b  reason: collision with root package name */
    public CopyTradingAccountTransferRecord.FinancialRecord f47998b;

    public m(CopyTradingAccountTransferRecord.FinancialRecord financialRecord) {
        this.f47998b = financialRecord;
    }

    public boolean a(Object obj) {
        return obj instanceof m;
    }

    public CopyTradingAccountTransferRecord.FinancialRecord c() {
        return this.f47998b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (!mVar.a(this)) {
            return false;
        }
        CopyTradingAccountTransferRecord.FinancialRecord c11 = c();
        CopyTradingAccountTransferRecord.FinancialRecord c12 = mVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return CopyTradingTransferOrderViewHandler.class.getName();
    }

    public int hashCode() {
        CopyTradingAccountTransferRecord.FinancialRecord c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "CopyTradingTransferHistory(data=" + c() + ")";
    }
}

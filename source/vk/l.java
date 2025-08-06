package vk;

import com.huobi.contract.viewhandler.ContractRecordViewHandler;
import com.huobi.finance.bean.ContractRecordItem;
import s9.a;

public class l implements a {

    /* renamed from: b  reason: collision with root package name */
    public ContractRecordItem f47997b;

    public l(ContractRecordItem contractRecordItem) {
        this.f47997b = contractRecordItem;
    }

    public boolean a(Object obj) {
        return obj instanceof l;
    }

    public ContractRecordItem c() {
        return this.f47997b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (!lVar.a(this)) {
            return false;
        }
        ContractRecordItem c11 = c();
        ContractRecordItem c12 = lVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return ContractRecordViewHandler.class.getName();
    }

    public int hashCode() {
        ContractRecordItem c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "ContractRecordListItem(item=" + c() + ")";
    }
}

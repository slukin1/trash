package vk;

import com.hbg.lib.network.option.core.bean.OptionFinancialRecord;
import com.huobi.contract.viewhandler.OptionRecordViewHandler;
import s9.a;

public class u implements a {

    /* renamed from: b  reason: collision with root package name */
    public OptionFinancialRecord f48013b;

    public u(OptionFinancialRecord optionFinancialRecord) {
        this.f48013b = optionFinancialRecord;
    }

    public boolean a(Object obj) {
        return obj instanceof u;
    }

    public OptionFinancialRecord c() {
        return this.f48013b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (!uVar.a(this)) {
            return false;
        }
        OptionFinancialRecord c11 = c();
        OptionFinancialRecord c12 = uVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return OptionRecordViewHandler.class.getName();
    }

    public int hashCode() {
        OptionFinancialRecord c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "OptionRecordItem(record=" + c() + ")";
    }
}

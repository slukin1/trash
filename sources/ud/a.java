package ud;

import com.hbg.lib.network.hbg.core.bean.EtpRiskInfo;
import com.hbg.module.kline.handler.EtpChangeListItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public EtpRiskInfo f26258b;

    public a(EtpRiskInfo etpRiskInfo) {
        this.f26258b = etpRiskInfo;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public EtpRiskInfo c() {
        return this.f26258b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this)) {
            return false;
        }
        EtpRiskInfo c11 = c();
        EtpRiskInfo c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return EtpChangeListItemHandler.class.getName();
    }

    public int hashCode() {
        EtpRiskInfo c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "EtpChangeListItem(info=" + c() + ")";
    }
}

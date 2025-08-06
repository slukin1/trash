package ud;

import com.hbg.lib.network.hbg.core.bean.EtpRebalanceResult;
import com.hbg.module.kline.handler.EtpRebalanceListItemHandler;
import s9.a;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public EtpRebalanceResult f26259b;

    public b(EtpRebalanceResult etpRebalanceResult) {
        this.f26259b = etpRebalanceResult;
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public EtpRebalanceResult c() {
        return this.f26259b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!bVar.a(this)) {
            return false;
        }
        EtpRebalanceResult c11 = c();
        EtpRebalanceResult c12 = bVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return EtpRebalanceListItemHandler.class.getName();
    }

    public int hashCode() {
        EtpRebalanceResult c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "EtpRebalanceListItem(result=" + c() + ")";
    }
}

package oi;

import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.c2c.lend.viewhandler.C2CLendOrderItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public C2CLoanOrderBean f47686b;

    /* renamed from: c  reason: collision with root package name */
    public C0580a f47687c;

    /* renamed from: oi.a$a  reason: collision with other inner class name */
    public interface C0580a {
        void f(C2CLoanOrderBean c2CLoanOrderBean, CommonSwitchButton commonSwitchButton);

        void n(C2CLoanOrderBean c2CLoanOrderBean);
    }

    public a(C2CLoanOrderBean c2CLoanOrderBean, C0580a aVar) {
        this.f47686b = c2CLoanOrderBean;
        this.f47687c = aVar;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public C2CLoanOrderBean c() {
        return this.f47686b;
    }

    public C0580a d() {
        return this.f47687c;
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
        C2CLoanOrderBean c11 = c();
        C2CLoanOrderBean c12 = aVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        C0580a d11 = d();
        C0580a d12 = aVar.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public String getViewHandlerName() {
        return C2CLendOrderItemHandler.class.getName();
    }

    public int hashCode() {
        C2CLoanOrderBean c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        C0580a d11 = d();
        int i12 = (hashCode + 59) * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "C2CLendOrderItem(c2CLoanOrderBean=" + c() + ", callback=" + d() + ")";
    }
}

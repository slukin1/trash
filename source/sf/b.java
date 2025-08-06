package sf;

import com.hbg.lib.network.option.core.bean.OptionTriggerOrderInfo;
import com.hbg.module.option.viewhandler.OptionCurrentTriggerOrderItemHandler;

public class b implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public OptionTriggerOrderInfo f37239b;

    /* renamed from: c  reason: collision with root package name */
    public a f37240c;

    public interface a {
        void a(b bVar);
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public a c() {
        return this.f37240c;
    }

    public OptionTriggerOrderInfo d() {
        return this.f37239b;
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
        OptionTriggerOrderInfo d11 = d();
        OptionTriggerOrderInfo d12 = bVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = bVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return OptionCurrentTriggerOrderItemHandler.class.getName();
    }

    public int hashCode() {
        OptionTriggerOrderInfo d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        a c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "OptionCurrentTriggerOrderItem(orderInfo=" + d() + ", callback=" + c() + ")";
    }
}

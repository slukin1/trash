package sf;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.option.core.bean.OptionPositionInfo;
import com.hbg.module.option.viewhandler.OptionPositionOrderItemHandler;

public class c implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public OptionPositionInfo f37241b;

    /* renamed from: c  reason: collision with root package name */
    public FutureContractInfo f37242c;

    /* renamed from: d  reason: collision with root package name */
    public a f37243d;

    public interface a {
        void a(c cVar);

        void b(c cVar);

        void c(c cVar);

        void d(c cVar);

        void e(c cVar);
    }

    public boolean a(Object obj) {
        return obj instanceof c;
    }

    public a c() {
        return this.f37243d;
    }

    public FutureContractInfo d() {
        return this.f37242c;
    }

    public OptionPositionInfo e() {
        return this.f37241b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!cVar.a(this)) {
            return false;
        }
        OptionPositionInfo e11 = e();
        OptionPositionInfo e12 = cVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        FutureContractInfo d11 = d();
        FutureContractInfo d12 = cVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = cVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return OptionPositionOrderItemHandler.class.getName();
    }

    public int hashCode() {
        OptionPositionInfo e11 = e();
        int i11 = 43;
        int hashCode = e11 == null ? 43 : e11.hashCode();
        FutureContractInfo d11 = d();
        int hashCode2 = ((hashCode + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        a c11 = c();
        int i12 = hashCode2 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "OptionPositionOrderItem(info=" + e() + ", contractInfo=" + d() + ", callback=" + c() + ")";
    }
}

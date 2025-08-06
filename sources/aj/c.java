package aj;

import android.content.Context;
import com.huobi.contract.entity.ContractTriggerOrderRspInfo;
import com.huobi.contract.viewhandler.ContractStopOrderListItemHandler;

public class c implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public ContractTriggerOrderRspInfo f40708b;

    /* renamed from: c  reason: collision with root package name */
    public transient String f40709c;

    /* renamed from: d  reason: collision with root package name */
    public a f40710d;

    public interface a {
        void b(c cVar, Context context);

        void c(c cVar);
    }

    public c(ContractTriggerOrderRspInfo contractTriggerOrderRspInfo) {
        this.f40708b = contractTriggerOrderRspInfo;
    }

    public boolean a(Object obj) {
        return obj instanceof c;
    }

    public a c() {
        return this.f40710d;
    }

    public String d() {
        return this.f40709c;
    }

    public ContractTriggerOrderRspInfo e() {
        return this.f40708b;
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
        ContractTriggerOrderRspInfo e11 = e();
        ContractTriggerOrderRspInfo e12 = cVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = cVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public boolean f() {
        return "buy".equals(this.f40708b.getDirection());
    }

    public boolean g() {
        return "settlement".equals(this.f40708b.getOrderSource());
    }

    public String getViewHandlerName() {
        return ContractStopOrderListItemHandler.class.getName();
    }

    public boolean h() {
        return "risk".equals(this.f40708b.getOrderSource());
    }

    public int hashCode() {
        ContractTriggerOrderRspInfo e11 = e();
        int i11 = 43;
        int hashCode = e11 == null ? 43 : e11.hashCode();
        a c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public boolean i() {
        return "open".equals(this.f40708b.getOffset());
    }

    public void j(a aVar) {
        this.f40710d = aVar;
    }

    public void k(String str) {
        this.f40709c = str;
    }

    public String toString() {
        return "ContractStopOrderListItem(info=" + e() + ", contractFace=" + d() + ", callback=" + c() + ")";
    }
}

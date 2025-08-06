package wl;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.huobi.index.bean.RealTimePrice;
import com.huobi.index.viewhandler.MarketVerticalListItemHandler;
import s9.a;

public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public RealTimePrice f76658b;

    /* renamed from: c  reason: collision with root package name */
    public ContractCurrencyInfo f76659c;

    /* renamed from: d  reason: collision with root package name */
    public SwapCurrencyInfo f76660d;

    public c(RealTimePrice realTimePrice) {
        this.f76658b = realTimePrice;
    }

    public boolean a(Object obj) {
        return obj instanceof c;
    }

    public ContractCurrencyInfo c() {
        return this.f76659c;
    }

    public RealTimePrice d() {
        return this.f76658b;
    }

    public SwapCurrencyInfo e() {
        return this.f76660d;
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
        RealTimePrice d11 = d();
        RealTimePrice d12 = cVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        ContractCurrencyInfo c11 = c();
        ContractCurrencyInfo c12 = cVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        SwapCurrencyInfo e11 = e();
        SwapCurrencyInfo e12 = cVar.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public void f(ContractCurrencyInfo contractCurrencyInfo) {
        this.f76659c = contractCurrencyInfo;
    }

    public void g(SwapCurrencyInfo swapCurrencyInfo) {
        this.f76660d = swapCurrencyInfo;
    }

    public String getViewHandlerName() {
        return MarketVerticalListItemHandler.class.getName();
    }

    public int hashCode() {
        RealTimePrice d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        ContractCurrencyInfo c11 = c();
        int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
        SwapCurrencyInfo e11 = e();
        int i12 = hashCode2 * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "MarketVerticalListItem(realTimePrice=" + d() + ", contractCurrencyInfo=" + c() + ", swapCurrencyInfo=" + e() + ")";
    }
}

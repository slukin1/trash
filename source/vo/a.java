package vo;

import android.content.Context;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.huobi.trade.handler.CurrentPlanOrderHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public AlgoOrderInfo f84996b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f84997c;

    /* renamed from: d  reason: collision with root package name */
    public C0887a f84998d;

    /* renamed from: e  reason: collision with root package name */
    public TradeType f84999e;

    /* renamed from: vo.a$a  reason: collision with other inner class name */
    public interface C0887a {
        void a(a aVar, Context context);
    }

    public a(AlgoOrderInfo algoOrderInfo) {
        this.f84996b = algoOrderInfo;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public C0887a c() {
        return this.f84998d;
    }

    public Long d() {
        AlgoOrderInfo algoOrderInfo = this.f84996b;
        if (algoOrderInfo == null) {
            return 0L;
        }
        return Long.valueOf(algoOrderInfo.getId());
    }

    public AlgoOrderInfo e() {
        return this.f84996b;
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
        AlgoOrderInfo e11 = e();
        AlgoOrderInfo e12 = aVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        if (h() != aVar.h()) {
            return false;
        }
        C0887a c11 = c();
        C0887a c12 = aVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        TradeType g11 = g();
        TradeType g12 = aVar.g();
        return g11 != null ? g11.equals(g12) : g12 == null;
    }

    public String f() {
        return this.f84996b.getSymbol();
    }

    public TradeType g() {
        return this.f84999e;
    }

    public String getViewHandlerName() {
        return CurrentPlanOrderHandler.class.getName();
    }

    public boolean h() {
        return this.f84997c;
    }

    public int hashCode() {
        AlgoOrderInfo e11 = e();
        int i11 = 43;
        int hashCode = (((e11 == null ? 43 : e11.hashCode()) + 59) * 59) + (h() ? 79 : 97);
        C0887a c11 = c();
        int hashCode2 = (hashCode * 59) + (c11 == null ? 43 : c11.hashCode());
        TradeType g11 = g();
        int i12 = hashCode2 * 59;
        if (g11 != null) {
            i11 = g11.hashCode();
        }
        return i12 + i11;
    }

    public void i(C0887a aVar) {
        this.f84998d = aVar;
    }

    public void j(boolean z11) {
        this.f84997c = z11;
    }

    public void k(TradeType tradeType) {
        this.f84999e = tradeType;
    }

    public String toString() {
        return "CurrentPlanTradeInfo(orderInfo=" + e() + ", isTrade=" + h() + ", callback=" + c() + ", tradeType=" + g() + ")";
    }

    public a(AlgoOrderInfo algoOrderInfo, boolean z11) {
        this.f84996b = algoOrderInfo;
        this.f84997c = z11;
    }
}

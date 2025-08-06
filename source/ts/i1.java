package ts;

import androidx.recyclerview.widget.RecyclerView;
import bm.a;
import com.hbg.lib.network.swap.core.bean.PriceLimitInfo;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.TopScrollData;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.entity.FuturesActivityInfo;
import i6.r;
import java.util.List;
import qs.n1;
import u6.g;

public interface i1 extends g, g0 {
    void A0(int i11);

    int B0();

    RecyclerView C1();

    void C2(FuturesActivityInfo futuresActivityInfo, String str);

    void E1(int i11);

    void E5(SwapAccountInfo swapAccountInfo);

    void F1();

    void F3(PriceLimitInfo priceLimitInfo);

    void G1(int i11);

    void I1();

    void L(int i11, SwapCurrencyInfo swapCurrencyInfo);

    void N0();

    void O0(String str, int i11, int i12);

    void S0();

    int T0();

    void U0(String str);

    void V0(boolean z11);

    a4 Ye();

    r Z0();

    void Z5(SwapCurrencyInfo swapCurrencyInfo);

    a a1();

    void c(int i11);

    void d1(ContractOpenCountInfo contractOpenCountInfo);

    int e1();

    void f(int i11);

    void g(int i11);

    void g1(int i11);

    int getPositionType();

    void h(int i11);

    void i(int i11);

    void j1();

    void j2(int i11);

    void m(int i11, boolean z11);

    void m1();

    void n0();

    void p0(String str, String str2);

    void q0();

    void r0();

    void s0();

    void s1(String str);

    void s2(List<TopScrollData> list, boolean z11, boolean z12);

    void setContractTradeViewController(n1 n1Var);

    void setInputPriceUpdate(boolean z11);

    void setLeverList(List<String> list);

    void t3(String str);

    void v0();

    int v1();

    void x0(String str);

    void y0(boolean z11);

    void y1();
}

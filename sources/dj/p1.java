package dj;

import androidx.recyclerview.widget.RecyclerView;
import bj.q2;
import bm.a;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.bean.PriceLimitInfo;
import com.hbg.lib.widgets.TopScrollData;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.entity.FuturesActivityInfo;
import i6.r;
import java.util.List;
import u6.g;

public interface p1 extends g, n0 {
    void A0(int i11);

    void A2(List<TopScrollData> list, boolean z11, boolean z12);

    void Ag(ContractAccountInfo contractAccountInfo);

    int B0();

    RecyclerView C1();

    void C2(FuturesActivityInfo futuresActivityInfo, String str);

    void E1(int i11);

    void F1();

    void G1(int i11);

    void I1();

    void J1(long j11);

    void K5(PriceLimitInfo priceLimitInfo);

    void N0();

    void O0(String str, int i11, int i12);

    void Q1(int i11, ContractCurrencyInfo contractCurrencyInfo);

    void S0();

    void Sd(ContractCurrencyInfo contractCurrencyInfo);

    int T0();

    void U0(String str);

    void V0(boolean z11);

    j4 X2();

    r Z0();

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

    void setContractTradeViewController(q2 q2Var);

    void setInputPriceUpdate(boolean z11);

    void setLeverList(List<String> list);

    void t3(String str);

    void v0();

    int v1();

    void x0(String str);

    void y0(boolean z11);

    void y1();
}

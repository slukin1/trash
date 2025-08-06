package cn;

import androidx.recyclerview.widget.RecyclerView;
import bm.a;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.bean.FuturePriceLimitInfo;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.widgets.TopScrollData;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.coupon.bean.CouponReturn;
import i6.r;
import java.util.List;
import pk.o;

public interface k2 extends o {
    void A0(int i11);

    void A2(List<TopScrollData> list, boolean z11, boolean z12);

    int B0();

    RecyclerView C1();

    void E1(int i11);

    void Eg(String str, String str2);

    void F1();

    void G1(int i11);

    void I1();

    void Ib(boolean z11, String str);

    void J1(long j11);

    void La(boolean z11);

    void N5();

    void O0(String str, int i11, int i12);

    void P6(int i11);

    void Q5();

    void Q8(LinearSwapAccountInfo linearSwapAccountInfo);

    void S0();

    void Sa(boolean z11);

    int T0();

    void T8(List<CouponReturn> list);

    void U0(String str);

    void V0(boolean z11);

    r Z0();

    a a1();

    void bg(FutureContractInfo futureContractInfo);

    void c(int i11);

    void d1(ContractOpenCountInfo contractOpenCountInfo);

    void f(int i11);

    void g(int i11);

    void g1(int i11);

    void h(int i11);

    void hc(int i11);

    void i(int i11);

    void j1();

    void k2(String str);

    void m1();

    void n0();

    void n2(FuturePriceLimitInfo futurePriceLimitInfo);

    void p0(String str, String str2);

    void q0();

    void r0();

    void s0();

    void s1(String str);

    void s2(List<TopScrollData> list, boolean z11, boolean z12);

    void setInputPriceUpdate(boolean z11);

    void setLeverList(List<String> list);

    void u2(int i11);

    void v0();

    int v1();

    void v2(int i11, int i12);

    void v5(AccountBalanceInfoV5 accountBalanceInfoV5);

    void x0(String str);

    void y0(boolean z11);

    void y1();
}

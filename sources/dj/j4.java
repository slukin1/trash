package dj;

import bj.q2;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.huobi.contract.entity.ContractDepth;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import java.math.BigDecimal;
import java.util.List;

public interface j4 {
    void A0(int i11);

    void C0(List<MarketBuySellItem> list, boolean z11);

    void E0(List<MarketBuySellItem> list, boolean z11);

    void H0(MarketCurrentPriceItem marketCurrentPriceItem);

    void I0();

    void J0();

    void K0();

    void L0();

    void M0(int i11);

    void N0(ContractDepth contractDepth, int i11);

    void O0(int i11);

    void P0(String str, String str2);

    void Q0();

    void Q1(int i11, ContractCurrencyInfo contractCurrencyInfo);

    void R0(boolean z11);

    void S0(String str, String str2);

    void T0(int i11);

    void U0();

    void V0(List<ContractDepth> list, int i11);

    boolean W0();

    void X0(String str);

    void Y0(int i11);

    void a();

    boolean b();

    void c(int i11);

    void d(boolean z11);

    String getInputAmountText();

    String getInputPriceText();

    int getOrderType();

    int getPositionType();

    int getSeekBarProgress();

    boolean getTpSlDialogOpenTypeisOpenLong();

    boolean getTpSlSwitchCheck();

    int getTradeAmountType();

    int getTradePosition();

    int getTradePriceType();

    String getTriggerPriceText();

    void l(BigDecimal bigDecimal);

    void n0();

    void notifyDataSetChanged();

    void p0(String str, String str2);

    void q0();

    void r0();

    void s0();

    void setContractTradeViewController(q2 q2Var);

    void setInputPriceUpdate(boolean z11);

    void setLeverList(List<String> list);

    void setViewVisibility(int i11);

    void t0();

    void u0(boolean z11, boolean z12);

    void v0();

    void w0(boolean z11, boolean z12);

    void x0(String str);

    void z0(boolean z11);
}

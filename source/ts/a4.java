package ts;

import com.hbg.lib.network.swap.core.bean.PriceLimitInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.huobi.contract.entity.ContractDepth;
import com.huobi.feature.bean.FutureTpSlSettingParams;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import java.util.List;
import qs.n1;

public interface a4 {
    void A0(int i11);

    void C0(List<MarketBuySellItem> list, boolean z11);

    void E0(List<MarketBuySellItem> list, boolean z11);

    void F3(PriceLimitInfo priceLimitInfo);

    void H0(MarketCurrentPriceItem marketCurrentPriceItem);

    void I0();

    void J0();

    void K0();

    void L(int i11, SwapCurrencyInfo swapCurrencyInfo);

    void L0();

    void M0(int i11);

    void N0(ContractDepth contractDepth, int i11);

    void O0(int i11);

    void P0(String str, String str2);

    void Q0();

    void R0(boolean z11);

    void S0(String str, String str2);

    void T0(int i11);

    void U0();

    void V0(List<ContractDepth> list, int i11);

    boolean W0();

    void X0(String str);

    void Y0(int i11);

    void c(int i11);

    void d(boolean z11);

    String getInputAmountText();

    String getInputPriceText();

    int getOrderType();

    int getPositionType();

    int getSeekBarProgress();

    FutureTpSlSettingParams getSlCache();

    FutureTpSlSettingParams getTpCache();

    FutureTpSlSettingDialogFragment.OpenType getTpSlDialogOpenType();

    boolean getTpSlSwitchCheck();

    int getTradeAmountType();

    int getTradePosition();

    int getTradePriceType();

    String getTriggerPriceText();

    void n0();

    void notifyDataSetChanged();

    void p0(String str, String str2);

    void q0();

    void r0();

    void s0();

    void setContractTradeViewController(n1 n1Var);

    void setInputPriceUpdate(boolean z11);

    void setLeverList(List<String> list);

    void setViewVisibility(int i11);

    void t0();

    void u0(boolean z11, boolean z12);

    void v0();

    void w0(boolean z11, boolean z12);

    void x0(String str);

    void x2(String str);

    void y2();

    void z0(boolean z11);
}

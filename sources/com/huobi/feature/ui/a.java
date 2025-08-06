package com.huobi.feature.ui;

import android.view.View;
import com.hbg.lib.data.future.bean.FuturePriceLimitInfo;
import com.huobi.contract.entity.ContractDepth;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.feature.bean.FutureTpSlSettingParams;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import java.util.List;
import nk.e;

public interface a {
    void A0(int i11);

    void A2(List<CouponReturn> list, boolean z11);

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

    String getOrderPlaceInputAmount();

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

    void k2(String str);

    void n0();

    void n2(FuturePriceLimitInfo futurePriceLimitInfo);

    void notifyDataSetChanged();

    void p0(String str, String str2);

    void q0();

    void r0();

    void s0();

    void setContractTradeViewController(e eVar);

    void setInputPriceUpdate(boolean z11);

    void setLeverList(List<String> list);

    void setOnCouponClickListener(View.OnClickListener onClickListener);

    void setViewVisibility(int i11);

    void t0();

    void u0(boolean z11, boolean z12);

    void v0();

    void v2(int i11, int i12);

    void w0(boolean z11, boolean z12);

    boolean w2();

    void x0(String str);

    void x2(String str);

    void y2();

    void z0(boolean z11);

    void z2();
}

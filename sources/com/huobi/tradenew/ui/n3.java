package com.huobi.tradenew.ui;

import com.hbg.lib.network.hbg.core.bean.CurrencyAsset;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.view.TradeRangeBarView;
import java.math.BigDecimal;

public interface n3 extends z0 {
    void Hb(int i11);

    @Deprecated
    TradeRangeBarView T2();

    void c(int i11);

    void c4(BigDecimal bigDecimal);

    void f0(CurrencyAsset currencyAsset);

    String getInputAmountText();

    String getInputPriceText();

    void ha(boolean z11);

    void l(BigDecimal bigDecimal);

    void n(boolean z11, int i11, String str);

    void n0();

    void p(int i11, String str);

    void setInputAmountText(String str);

    void setProgressText(String str);

    void t(SymbolBean symbolBean);

    void z(boolean z11, int i11);
}

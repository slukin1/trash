package yl;

import a7.e;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.bean.HbgSymbolPrice;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.market.MarketModuleConfig;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.index.bean.RealTimePrice;
import d7.a1;
import ej.g;
import java.math.BigDecimal;
import java.util.List;
import us.j;

public final class p {
    public static RealTimePrice a(SymbolPrice symbolPrice, SymbolPrice symbolPrice2) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        if (symbolPrice2 == null) {
            symbolPrice2 = symbolPrice;
        }
        RealTimePrice realTimePrice = new RealTimePrice();
        realTimePrice.F(symbolPrice.getSymbol());
        if (symbolPrice2.getClose() == null) {
            realTimePrice.y(0.0d);
        } else {
            realTimePrice.y(symbolPrice2.getClose().doubleValue());
        }
        if (symbolPrice.getClose() == null) {
            realTimePrice.B(0.0d);
        } else {
            realTimePrice.B(symbolPrice.getClose().doubleValue());
        }
        if (symbolPrice.getOpen() == null) {
            realTimePrice.J(0.0d);
        } else {
            realTimePrice.J(symbolPrice.getOpen().doubleValue());
        }
        if (symbolPrice.getClose() == null) {
            bigDecimal = new BigDecimal("0");
        } else {
            bigDecimal = new BigDecimal(symbolPrice.getClose().doubleValue());
        }
        if (symbolPrice.getOpen() == null) {
            bigDecimal2 = new BigDecimal("0");
        } else {
            bigDecimal2 = new BigDecimal(symbolPrice.getOpen().doubleValue());
        }
        BigDecimal subtract = bigDecimal.subtract(bigDecimal2);
        if (BigDecimal.ZERO.compareTo(bigDecimal) == 0) {
            bigDecimal3 = subtract.setScale(32, 1);
        } else {
            bigDecimal3 = subtract.divide(bigDecimal2, 32, 1);
        }
        realTimePrice.A(String.valueOf(bigDecimal3));
        return realTimePrice;
    }

    public static String b(String str) {
        List<ContractCurrencyInfo> m11 = ContractCurrencyUtils.m();
        List<SwapCurrencyInfo> e11 = SwapCurrencyInfoController.k().e();
        List<FutureContractInfo> f11 = FutureContractInfoController.n().f();
        for (int i11 = 0; i11 < m11.size(); i11++) {
            ContractCurrencyInfo contractCurrencyInfo = m11.get(i11);
            if (contractCurrencyInfo != null && str.equalsIgnoreCase(contractCurrencyInfo.getContractShortType())) {
                return g.k(BaseApplication.b(), contractCurrencyInfo.getContractCode(), contractCurrencyInfo.getContractType());
            }
        }
        for (int i12 = 0; i12 < e11.size(); i12++) {
            SwapCurrencyInfo swapCurrencyInfo = e11.get(i12);
            if (swapCurrencyInfo != null && str.equalsIgnoreCase(swapCurrencyInfo.getContractShortType())) {
                return j.k(BaseApplication.b());
            }
        }
        for (int i13 = 0; i13 < f11.size(); i13++) {
            FutureContractInfo futureContractInfo = f11.get(i13);
            if (futureContractInfo != null && str.equalsIgnoreCase(futureContractInfo.getContractShortType())) {
                return e.r(BaseApplication.b(), futureContractInfo.getContractCode(), futureContractInfo.getContractType());
            }
        }
        return MarketModuleConfig.a().x().equals(MarketModuleConfig.a().e0(str)) ? g.c(str) : "";
    }

    public static RealTimePrice c(HbgSymbolPrice hbgSymbolPrice) {
        String str;
        String str2;
        String str3;
        String str4 = "0";
        SymbolBean J = a1.v().J(hbgSymbolPrice.getSymbol(), TradeType.PRO);
        RealTimePrice realTimePrice = null;
        if ((J != null && !J.isHadSt() && !J.isStTag() && !J.hasTag(SymbolBean.TAG_HIDDEN_UP) && !m.a(J.getSymbol())) || hbgSymbolPrice.getSymbolType() == 1) {
            SymbolPrice symbolPrice = new SymbolPrice();
            symbolPrice.setSymbol(hbgSymbolPrice.getSymbol());
            try {
                symbolPrice.setClose(Double.valueOf(Double.parseDouble(TextUtils.isEmpty(hbgSymbolPrice.getPrice()) ? str4 : hbgSymbolPrice.getPrice())));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            try {
                symbolPrice.setOpen(Double.valueOf(Double.parseDouble(TextUtils.isEmpty(hbgSymbolPrice.getOpen()) ? str4 : hbgSymbolPrice.getOpen())));
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            double d11 = 0.0d;
            try {
                if (!TextUtils.isEmpty(hbgSymbolPrice.getQuotePrice())) {
                    str4 = hbgSymbolPrice.getQuotePrice();
                }
                d11 = Double.parseDouble(str4);
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            realTimePrice = a(symbolPrice, (SymbolPrice) null);
            if (hbgSymbolPrice.getSymbolType() == 1) {
                str3 = hbgSymbolPrice.getBaseCurrency();
                str2 = hbgSymbolPrice.getQuoteCurrency();
                str = hbgSymbolPrice.getSymbol();
            } else {
                a1 v11 = a1.v();
                String symbol = hbgSymbolPrice.getSymbol();
                TradeType tradeType = TradeType.PRO;
                str3 = v11.o(symbol, tradeType);
                str2 = a1.v().E(hbgSymbolPrice.getSymbol(), tradeType);
                str = a1.v().p(hbgSymbolPrice.getSymbol());
            }
            realTimePrice.H("1");
            realTimePrice.t(str3);
            realTimePrice.C(str2);
            realTimePrice.E(J);
            realTimePrice.z(str);
            realTimePrice.u(hbgSymbolPrice.getBaseCurrencyPrice());
            realTimePrice.G(hbgSymbolPrice.getSymbolType());
            realTimePrice.x(hbgSymbolPrice.getLabel());
            realTimePrice.v(hbgSymbolPrice.getFlag());
            realTimePrice.w(hbgSymbolPrice.getFlagURL());
            realTimePrice.I(hbgSymbolPrice.getKlineList());
            realTimePrice.D(d11);
        }
        return realTimePrice;
    }
}

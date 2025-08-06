package com.huobi.trade.helper;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.ExchangeSettingsController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.pro.core.bean.ExchangeSettings;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.libkt.base.ext.b;
import d7.a1;
import gs.g;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import pro.huobi.R;

public class TradeLimitHelper {

    public interface a {
        void a(boolean z11);
    }

    public static HBDialogFragment e(FragmentActivity fragmentActivity, TradeType tradeType, String str, boolean z11, BigDecimal bigDecimal, String str2, String str3, a aVar) {
        String str4;
        String str5;
        BigDecimal a11 = m.a(str2);
        ExchangeSettings b11 = ExchangeSettingsController.d().b(str);
        if (b11 != null) {
            str4 = b11.getBuyMarketMustLessThan();
            str5 = b11.getSellMarketMustGreaterThan();
        } else {
            str4 = "1.1";
            str5 = "0.9";
        }
        if (!a1.v().S(str) && bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal a12 = m.a(str4);
            BigDecimal a13 = m.a(str5);
            if (z11) {
                if (a11.compareTo(bigDecimal.multiply(BigDecimal.ONE.add(a12))) > 0) {
                    return j(fragmentActivity, tradeType, true, a12, aVar);
                }
                if (!b.x(str3)) {
                    return k(fragmentActivity, true, str3, aVar);
                }
            } else if (a11.compareTo(bigDecimal.multiply(BigDecimal.ONE.subtract(a13))) < 0) {
                return j(fragmentActivity, tradeType, false, a13, aVar);
            } else {
                if (!b.x(str3)) {
                    return k(fragmentActivity, false, str3, aVar);
                }
            }
            aVar.a(true);
        }
        return null;
    }

    public static /* synthetic */ void f(a aVar, HBDialogFragment hBDialogFragment) {
        aVar.a(true);
        hBDialogFragment.dismiss();
    }

    public static /* synthetic */ void g(a aVar, HBDialogFragment hBDialogFragment) {
        aVar.a(false);
        hBDialogFragment.dismiss();
    }

    public static /* synthetic */ void h(a aVar, HBDialogFragment hBDialogFragment) {
        aVar.a(true);
        hBDialogFragment.dismiss();
    }

    public static /* synthetic */ void i(a aVar, HBDialogFragment hBDialogFragment) {
        aVar.a(false);
        hBDialogFragment.dismiss();
    }

    public static HBDialogFragment j(FragmentActivity fragmentActivity, TradeType tradeType, boolean z11, BigDecimal bigDecimal, a aVar) {
        String str;
        if (z11) {
            str = fragmentActivity.getResources().getString(R.string.n_trade_sell_price_limit_tips);
        } else {
            str = fragmentActivity.getResources().getString(R.string.n_trade_buy_price_limit_tips);
        }
        String format = String.format(str, new Object[]{m.O(bigDecimal, 0, 1)});
        HashMap hashMap = new HashMap();
        if (tradeType == TradeType.PRO) {
            hashMap.put("trade_mode", RankScreenBean.SCREEN_VALUE_SPOT);
        } else if (tradeType == TradeType.MARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
        } else if (tradeType == TradeType.SUPERMARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_CROSS);
        }
        if (z11) {
            hashMap.put("side", "buy");
        } else {
            hashMap.put("side", "sell");
        }
        g.i("app_trade_market_order_limit_view", hashMap);
        HBDialogFragment j02 = new DialogUtils.b.d(fragmentActivity).c1(fragmentActivity.getResources().getString(R.string.n_remind)).g1(1).C0(format).D0(Integer.valueOf(ContextCompat.getColor(fragmentActivity, R.color.baseColorPrimaryText))).i1(0).P0(fragmentActivity.getResources().getString(R.string.n_confirm)).Q0(new s(aVar)).N0(new r(aVar)).j0();
        j02.show(fragmentActivity.getSupportFragmentManager(), "");
        return j02;
    }

    public static HBDialogFragment k(FragmentActivity fragmentActivity, boolean z11, String str, a aVar) {
        String str2;
        if (z11) {
            str2 = fragmentActivity.getResources().getString(R.string.n_exchange_buy_off_plate_tips);
        } else {
            str2 = fragmentActivity.getResources().getString(R.string.n_exchange_sell_off_plate_tips);
        }
        HBDialogFragment j02 = new DialogUtils.b.d(fragmentActivity).c1(fragmentActivity.getResources().getString(R.string.n_remind)).C0(String.format(str2, new Object[]{str})).D0(Integer.valueOf(ContextCompat.getColor(fragmentActivity, R.color.baseColorPrimaryText))).i1(0).P0(fragmentActivity.getResources().getString(R.string.n_confirm)).s0(fragmentActivity.getResources().getString(R.string.n_cancel)).Q0(new q(aVar)).N0(new p(aVar)).j0();
        j02.show(fragmentActivity.getSupportFragmentManager(), "");
        return j02;
    }
}

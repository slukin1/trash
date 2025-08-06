package com.huobi.trade.handler;

import al.p;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bt.e2;
import com.hbg.lib.core.util.w;
import com.hbg.module.asset.AssetModuleConfig;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.trade.bean.TradeHoldBeanNew;
import dw.a;
import gs.g;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import s9.c;

public class TradeHoldNewViewHandler implements c {
    public static /* synthetic */ void d(TradeHoldBeanNew tradeHoldBeanNew, v9.c cVar, Void voidR) {
        BalanceDetailInfo currencyInfo = tradeHoldBeanNew.getCurrencyInfo();
        if (currencyInfo != null && !TextUtils.isEmpty(currencyInfo.getCurrency())) {
            AssetModuleConfig.a().s0(cVar.itemView.getContext(), currencyInfo);
            HashMap hashMap = new HashMap(1);
            hashMap.put("Current_id", currencyInfo.getCurrency());
            g.i("App_trade_info_balances_click", hashMap);
        }
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, TradeHoldBeanNew tradeHoldBeanNew, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        ViewGroup viewGroup2 = (ViewGroup) e11.b(R.id.rlyt_trade_hold_title);
        TextView textView = (TextView) e11.b(R.id.tv_trade_hold_title);
        int showTitle = tradeHoldBeanNew.getShowTitle();
        if (showTitle == 1) {
            viewGroup2.setVisibility(0);
            textView.setText(context.getString(R.string.n_spot_asset_current_pair));
        } else if (showTitle != 2) {
            viewGroup2.setVisibility(8);
        } else {
            viewGroup2.setVisibility(0);
            textView.setText(context.getString(R.string.n_spot_asset_other_pair));
        }
        TextView textView2 = (TextView) e11.b(R.id.tv_trade_hold_profit);
        TextView textView3 = (TextView) e11.b(R.id.tv_trade_hold_debt);
        TextView textView4 = (TextView) e11.b(R.id.tv_trade_hold_total);
        f6.c a11 = f6.c.a();
        TextView textView5 = (TextView) e11.b(R.id.tv_trade_hold_total_ratio);
        String k11 = p.k(tradeHoldBeanNew.getCurrencyInfo().getCurrency());
        TextView textView6 = (TextView) e11.b(R.id.tv_trade_hold_profit_ratio);
        a11.l(context, k11, (ImageView) e11.b(R.id.iv_trade_hold_symbol_icon), p.m());
        ((TextView) e11.b(R.id.tv_trade_hold_number_label)).setText(context.getString(R.string.n_trade_hold) + "/" + context.getString(R.string.n_balance_otc_avaiable));
        Locale locale = Locale.ENGLISH;
        String string = context.getString(R.string.n_spot_asset_hold_profit_ratio);
        String y11 = LegalCurrencyConfigUtil.y();
        Locale locale2 = Locale.US;
        ((TextView) e11.b(R.id.tv_trade_hold_profit_label)).setText(String.format(locale, string, new Object[]{y11.toUpperCase(locale2)}));
        ((TextView) e11.b(R.id.tv_trade_hold_total_label)).setText(String.format(locale, context.getString(R.string.n_spot_asset_hold_total), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(locale2)}));
        ((TextView) e11.b(R.id.tv_trade_hold_price_label)).setText(context.getResources().getString(R.string.n_spot_asset_price_cost) + "(" + LegalCurrencyConfigUtil.y().toUpperCase(locale2) + ")");
        ((TextView) e11.b(R.id.tv_trade_hold_name)).setText(tradeHoldBeanNew.getDisplayName());
        ((TextView) e11.b(R.id.tv_trade_hold_full_name)).setText(tradeHoldBeanNew.getFullDisplayName());
        ((TextView) e11.b(R.id.tv_trade_hold_number)).setText(tradeHoldBeanNew.getHold());
        ((TextView) e11.b(R.id.tv_trade_hold_avail)).setText(tradeHoldBeanNew.getSpotBalance());
        ((TextView) e11.b(R.id.tv_trade_hold_price)).setText(tradeHoldBeanNew.getPrice());
        ((TextView) e11.b(R.id.tv_trade_hold_cost)).setText(tradeHoldBeanNew.getCost());
        int color = context.getResources().getColor(w.h());
        int color2 = context.getResources().getColor(w.d());
        int color3 = context.getResources().getColor(R.color.baseColorPrimaryText);
        if (m.a0(tradeHoldBeanNew.getProfit())) {
            BigDecimal bigDecimal = new BigDecimal(tradeHoldBeanNew.getProfit());
            String plainString = bigDecimal.toPlainString();
            if (bigDecimal.compareTo(BigDecimal.valueOf(0)) > 0) {
                textView2.setTextColor(color);
                textView2.setText("+" + plainString);
            } else if (bigDecimal.compareTo(BigDecimal.valueOf(0)) < 0) {
                textView2.setTextColor(color2);
                textView2.setText(plainString);
            } else {
                textView2.setTextColor(color3);
                textView2.setText("+0.00");
            }
        } else {
            textView2.setTextColor(color3);
            textView2.setText("+0.00");
        }
        BigDecimal multiply = new BigDecimal(tradeHoldBeanNew.getProfitRatio()).multiply(BigDecimal.valueOf(100));
        String plainString2 = multiply.setScale(2, 5).toPlainString();
        if (multiply.compareTo(BigDecimal.valueOf(0)) > 0) {
            TextView textView7 = textView6;
            textView7.setTextColor(color);
            textView7.setText("+" + plainString2 + "%");
        } else {
            TextView textView8 = textView6;
            if (multiply.compareTo(BigDecimal.valueOf(0)) < 0) {
                textView8.setTextColor(color2);
                textView8.setText(plainString2 + "%");
            } else {
                textView8.setTextColor(color3);
                textView8.setText("+0.00%");
            }
        }
        textView3.setText(tradeHoldBeanNew.getDebts());
        textView4.setText(tradeHoldBeanNew.getEstimateTotal());
        textView5.setText(tradeHoldBeanNew.getPercent());
        v9.c cVar2 = cVar;
        View view = cVar2.itemView;
        if (view != null) {
            a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new e2(tradeHoldBeanNew, cVar2));
        }
    }

    public int getResId() {
        return R.layout.item_trade_hold_new;
    }
}

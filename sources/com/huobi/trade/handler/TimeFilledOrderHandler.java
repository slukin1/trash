package com.huobi.trade.handler;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.order.bean.TimeOrderBeanDetails;
import com.huobi.trade.bean.AlgoOrderMatchBean;
import d7.a1;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Iterator;
import pro.huobi.R;
import s9.c;

public class TimeFilledOrderHandler implements c {
    @SuppressLint({"SetTextI18n"})
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, TimeOrderBeanDetails timeOrderBeanDetails, ViewGroup viewGroup) {
        TextView textView;
        String str;
        String str2;
        TextView textView2;
        v9.c cVar2 = cVar;
        cVar2.itemView.getContext();
        r e11 = cVar.e();
        Resources resources = cVar2.itemView.getResources();
        TextView textView3 = (TextView) e11.b(R.id.id_time_buy_or_sell);
        TextView textView4 = (TextView) e11.b(R.id.tv_symbol);
        TextView textView5 = (TextView) e11.b(R.id.tv_deal_time_title);
        TextView textView6 = (TextView) e11.b(R.id.tv_entrust_price_title);
        TextView textView7 = (TextView) e11.b(R.id.tv_total_amount_title);
        TextView textView8 = (TextView) e11.b(R.id.tv_deal_time);
        TextView textView9 = (TextView) e11.b(R.id.tv_trade_volume_title);
        TextView textView10 = (TextView) e11.b(R.id.tv_avg_price_title);
        TextView textView11 = (TextView) e11.b(R.id.tv_deal_amount_title);
        TextView textView12 = (TextView) e11.b(R.id.tv_detail_fee_title);
        TextView textView13 = (TextView) e11.b(R.id.tv_deal_amount);
        TextView textView14 = (TextView) e11.b(R.id.tv_point_consume_title);
        TextView textView15 = (TextView) e11.b(R.id.tv_avg_price);
        TextView textView16 = (TextView) e11.b(R.id.tv_ht_deduction_title);
        TextView textView17 = (TextView) e11.b(R.id.tv_trade_volume);
        TextView textView18 = (TextView) e11.b(R.id.tv_detail_fee);
        TextView textView19 = (TextView) e11.b(R.id.tv_point_consume);
        AlgoOrderMatchBean orderInfo = timeOrderBeanDetails.getOrderInfo();
        TextView textView20 = (TextView) e11.b(R.id.tv_ht_deduction);
        TextView textView21 = (TextView) e11.b(R.id.tv_total_amount);
        TextView textView22 = (TextView) e11.b(R.id.tv_entrust_price);
        SymbolBean J = a1.v().J(timeOrderBeanDetails.getSymbol(), TradeType.PRO);
        if (J != null) {
            str = J.getBaseCurrencyDisplayName();
            str2 = J.getQuoteCurrencyDisplayName();
            textView = textView8;
        } else {
            Iterator<String> it2 = a1.v().j().iterator();
            String str3 = "";
            String str4 = str3;
            while (it2.hasNext()) {
                Iterator<String> it3 = it2;
                String next = it2.next();
                String str5 = str3;
                if (timeOrderBeanDetails.getSymbol().lastIndexOf(next) > 0) {
                    textView2 = textView8;
                    str4 = timeOrderBeanDetails.getSymbol().substring(0, timeOrderBeanDetails.getSymbol().lastIndexOf(next));
                    str3 = next;
                } else {
                    textView2 = textView8;
                    str3 = str5;
                }
                it2 = it3;
                textView8 = textView2;
            }
            textView = textView8;
            String str6 = str3;
            str = str4;
            str2 = str6;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        sb2.append(str2);
        TextView textView23 = textView4;
        sb2.append(")");
        String sb3 = sb2.toString();
        String str7 = str2;
        String str8 = "(" + str + ")";
        String str9 = str;
        textView6.setText(resources.getString(R.string.n_exchange_order_list_entrust_price) + sb3);
        textView9.setText(resources.getString(R.string.n_exchange_order_list_trade_volume) + sb3);
        textView10.setText(resources.getString(R.string.n_exchange_order_list_trade_avg_price) + sb3);
        textView7.setText(resources.getString(R.string.n_exchange_timing_order_total_amount) + str8);
        textView11.setText(resources.getString(R.string.n_exchange_timing_deal_amount) + str8);
        textView12.setText(resources.getString(R.string.n_exchange_order_detail_fee) + str8);
        textView14.setText(resources.getString(R.string.n_exchange_order_detail_point_consume) + ("(" + resources.getString(R.string.points_pts) + ")"));
        textView16.setText(resources.getString(R.string.n_exchange_order_detail_ht_deduction) + "(HT)");
        if ("buy".equals(orderInfo.getOrderSide())) {
            textView3.setText(resources.getString(R.string.trade_market_buy_label));
            if (w.l()) {
                textView3.setBackgroundResource(R.drawable.trade_item_time_order_sell_corner_bg);
            } else {
                textView3.setBackgroundResource(R.drawable.trade_item_time_order_buy_corner_bg);
            }
        } else {
            textView3.setText(resources.getString(R.string.trade_market_sell_label));
            if (w.l()) {
                textView3.setBackgroundResource(R.drawable.trade_item_time_order_buy_corner_bg);
            } else {
                textView3.setBackgroundResource(R.drawable.trade_item_time_order_sell_corner_bg);
            }
        }
        textView23.setText((str9 + "/" + str7).toUpperCase());
        textView.setText(DateTimeUtils.D(orderInfo.getPeriodTrade().getOrderTradeTime().longValue()));
        int A = PrecisionUtil.A(orderInfo.getSymbol());
        textView22.setText(m.m(orderInfo.getPeriodTrade().getOrderLimitPrice(), A));
        int z11 = PrecisionUtil.z(timeOrderBeanDetails.getSymbol());
        textView21.setText(m.m(orderInfo.getPeriodTrade().getOrderLimitSize(), z11));
        textView17.setText(m.m(orderInfo.getPeriodTrade().getOrderAmount(), PrecisionUtil.y(timeOrderBeanDetails.getSymbol())));
        textView15.setText(m.m(orderInfo.getPeriodTrade().getOrderPrice(), A));
        textView13.setText(m.m(orderInfo.getPeriodTrade().getOrderSize(), z11));
        int B = PrecisionUtil.B(timeOrderBeanDetails.getSymbol(), true);
        String m11 = m.m(orderInfo.getPeriodTrade().getOrderFee(), B);
        String m12 = m.m(orderInfo.getPeriodTrade().getOrderPoint(), B);
        String m13 = m.m(orderInfo.getPeriodTrade().getOrderHt(), B);
        BigDecimal a11 = m.a(m11);
        BigDecimal a12 = m.a(m12);
        BigDecimal a13 = m.a(m13);
        if (!TextUtils.isEmpty(m11)) {
            m11 = a11.multiply(m.a("-1")).toPlainString();
            if (m.a(m11).compareTo(BigDecimal.ZERO) == 1) {
                m11 = "+" + m11;
            }
        }
        if (!TextUtils.isEmpty(m12)) {
            m12 = a12.multiply(m.a("-1")).toPlainString();
            if (m.a(m12).compareTo(BigDecimal.ZERO) == 1) {
                m12 = "+" + m12;
            }
        }
        if (!TextUtils.isEmpty(m13)) {
            m13 = a13.multiply(m.a("-1")).toPlainString();
            if (m.a(m13).compareTo(BigDecimal.ZERO) == 1) {
                m13 = "+" + m13;
            }
        }
        textView18.setText(m11);
        textView19.setText(m12);
        textView20.setText(m13);
    }

    public int getResId() {
        return R.layout.item_time_filled_order;
    }
}

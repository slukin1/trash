package com.huobi.order.handler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.o;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.order.bean.OrderBeanDetails;
import com.huobi.trade.bean.TradeOrderType;
import com.huobi.utils.SymbolUtil;
import d7.a1;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Locale;
import ku.a;
import pro.huobi.R;
import s9.c;

public class TradeOrderHistoryDetailHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, OrderBeanDetails orderBeanDetails, ViewGroup viewGroup) {
        String str;
        String str2;
        TextView textView;
        boolean z11;
        TextView textView2;
        String str3;
        Object obj;
        Object obj2;
        Object obj3;
        Context context = cVar.itemView.getContext();
        r e11 = cVar.e();
        TextView textView3 = (TextView) e11.b(R.id.item_detail_order_time_tv);
        TextView textView4 = (TextView) e11.b(R.id.item_detail_order_price_tv);
        TextView textView5 = (TextView) e11.b(R.id.item_detail_order_fee_tv);
        TextView textView6 = (TextView) e11.b(R.id.item_detail_order_amount_tv);
        TextView textView7 = (TextView) e11.b(R.id.tv_order_deal_type);
        TextView textView8 = (TextView) e11.b(R.id.item_detail_order_card_consume_tv);
        TextView textView9 = (TextView) e11.b(R.id.item_detail_order_deduct_tv);
        TextView textView10 = (TextView) e11.b(R.id.item_detail_order_deduct_title_tv);
        View b11 = e11.b(R.id.item_detail_order_trigger_condition_layout);
        TextView textView11 = (TextView) e11.b(R.id.item_detail_order_trigger_condition_tv);
        TextView textView12 = (TextView) e11.b(R.id.item_order_type);
        SymbolBean J = a1.v().J(orderBeanDetails.getSymbol(), TradeType.PRO);
        if (J != null) {
            str = J.getBaseCurrencyDisplayName();
            str2 = J.getQuoteCurrencyDisplayName();
        } else {
            str2 = "";
            str = str2;
        }
        textView3.setText(DateTimeUtils.D(orderBeanDetails.getCreatedAt()));
        Object obj4 = "";
        TextView textView13 = textView7;
        textView4.setText(String.format(context.getString(R.string.detail_order_key_value), new Object[]{m.m(orderBeanDetails.getPrice(), PrecisionUtil.A(orderBeanDetails.getSymbol())), str2}));
        textView6.setText(String.format(context.getString(R.string.detail_order_key_value), new Object[]{m.m(orderBeanDetails.getFilledAmount(), PrecisionUtil.z(orderBeanDetails.getSymbol())), str}));
        String u11 = m.u(orderBeanDetails.getFilledFees(), PrecisionUtil.B(orderBeanDetails.getSymbol(), orderBeanDetails.isBuy()));
        if (!TextUtils.isEmpty(u11)) {
            u11 = m.a(u11).multiply(m.a("-1")).toPlainString();
            if (m.a(u11).compareTo(BigDecimal.ZERO) == 1) {
                u11 = "+" + u11;
            }
        }
        String m11 = m.m(orderBeanDetails.getFilledPoints(), PrecisionUtil.c(orderBeanDetails.getSymbol()));
        if (!TextUtils.isEmpty(m11)) {
            m11 = m.a(m11).multiply(m.a("-1")).toPlainString();
            if (m.a(m11).compareTo(BigDecimal.ZERO) == 1) {
                m11 = "+" + m11;
            }
        }
        textView10.setText(a.c(R.string.n_deduction_of_handling_fees));
        Object obj5 = "HTX";
        TextView textView14 = textView12;
        if (TextUtils.isEmpty(orderBeanDetails.getFeeDeductCurrency())) {
            textView = textView11;
            textView5.setText(String.format(Locale.US, context.getString(R.string.detail_order_key_value), new Object[]{u11, orderBeanDetails.getFeeCurrency()}));
            textView8.setText(String.format(context.getString(R.string.order_point_consumption_unit), new Object[]{m11}));
            if (orderBeanDetails.getFeeDeductCurrency().equalsIgnoreCase("ht")) {
                textView10.setText(a.c(R.string.n_exchange_order_detail_ht_deduction));
                obj3 = "HT";
            } else if (orderBeanDetails.getFeeDeductCurrency().equalsIgnoreCase("trx")) {
                textView10.setText(a.d(R.string.n_exchange_order_detail_deduction, "TRX"));
                obj3 = "TRX";
            } else if (orderBeanDetails.getFeeDeductCurrency().equalsIgnoreCase("htx")) {
                textView10.setText(a.c(R.string.n_exchange_order_detail_htx_deduction));
                obj3 = obj5;
            } else {
                obj3 = obj4;
            }
            textView9.setText(String.format(context.getString(R.string.detail_order_key_value), new Object[]{m.m("0", PrecisionUtil.c(orderBeanDetails.getSymbol())), obj3}));
            z11 = true;
        } else {
            textView = textView11;
            if ("hbpoint".equals(orderBeanDetails.getFeeDeductCurrency()) || "pts".equals(orderBeanDetails.getFeeDeductCurrency())) {
                textView5.setText(String.format(context.getString(R.string.detail_order_key_value), new Object[]{u11, SymbolUtil.c(orderBeanDetails.getSymbol(), orderBeanDetails.isBuy())}));
                textView8.setText(String.format(context.getString(R.string.order_point_consumption_unit), new Object[]{m11}));
                if (orderBeanDetails.getFeeDeductCurrency().equalsIgnoreCase("ht")) {
                    textView10.setText(a.c(R.string.n_exchange_order_detail_ht_deduction));
                    obj = "HT";
                } else if (orderBeanDetails.getFeeDeductCurrency().equalsIgnoreCase("trx")) {
                    textView10.setText(a.d(R.string.n_exchange_order_detail_deduction, "TRX"));
                    obj = "TRX";
                } else if (orderBeanDetails.getFeeDeductCurrency().equalsIgnoreCase("htx")) {
                    textView10.setText(a.c(R.string.n_exchange_order_detail_htx_deduction));
                    obj = obj5;
                } else {
                    obj = obj4;
                }
                z11 = true;
                textView9.setText(String.format(context.getString(R.string.detail_order_key_value), new Object[]{m.m("0", PrecisionUtil.c(orderBeanDetails.getSymbol())), obj}));
            } else {
                textView5.setText(String.format(context.getString(R.string.detail_order_key_value), new Object[]{u11, SymbolUtil.c(orderBeanDetails.getSymbol(), orderBeanDetails.isBuy())}));
                textView8.setText(String.format(context.getString(R.string.order_point_consumption_unit), new Object[]{m.m("0", PrecisionUtil.c(orderBeanDetails.getSymbol()))}));
                String m12 = m.m(m11, PrecisionUtil.c(orderBeanDetails.getSymbol()));
                if (m.a(m12).compareTo(BigDecimal.ZERO) == 1) {
                    m12 = "+" + m12;
                }
                if (orderBeanDetails.getFeeDeductCurrency().equalsIgnoreCase("ht")) {
                    textView10.setText(a.c(R.string.n_exchange_order_detail_ht_deduction));
                    obj2 = "HT";
                } else if (orderBeanDetails.getFeeDeductCurrency().equalsIgnoreCase("trx")) {
                    textView10.setText(a.d(R.string.n_exchange_order_detail_deduction, "TRX"));
                    obj2 = "TRX";
                } else if (orderBeanDetails.getFeeDeductCurrency().equalsIgnoreCase("htx")) {
                    textView10.setText(a.c(R.string.n_exchange_order_detail_htx_deduction));
                    obj2 = obj5;
                } else {
                    obj2 = obj4;
                }
                textView9.setText(String.format(context.getString(R.string.detail_order_key_value), new Object[]{m12, obj2}));
                z11 = true;
            }
        }
        if (!o.g() || !orderBeanDetails.isStopLimitType()) {
            ViewUtil.m(b11, false);
        } else {
            ViewUtil.m(b11, z11);
            if ("gte".equalsIgnoreCase(orderBeanDetails.getOperator())) {
                str3 = context.getString(R.string.string_flag_bigger_equals);
            } else {
                str3 = context.getString(R.string.string_flag_smaller_equals);
            }
            textView.setText(String.format(Locale.US, str3, new Object[]{m.m(orderBeanDetails.getStopPrice(), PrecisionUtil.A(orderBeanDetails.getSymbol()))}));
        }
        String type = orderBeanDetails.getType();
        String source = orderBeanDetails.getSource();
        if ("sell-market".equals(type) || "buy-market".equals(type)) {
            textView2 = textView14;
            textView2.setText(R.string.n_exchange_order_list_market);
        } else if (type.toLowerCase().endsWith("-maker")) {
            textView2 = textView14;
            textView2.setText(R.string.n_contract_trade_post_only);
        } else {
            textView2 = textView14;
            if (type.toLowerCase().endsWith("-ioc")) {
                textView2.setText(context.getResources().getString(R.string.n_exchange_order_list_limit) + "-IOC");
            } else if (type.toLowerCase().endsWith("-fok")) {
                textView2.setText(context.getResources().getString(R.string.n_exchange_order_list_limit) + "-FOK");
            } else {
                textView2.setText(context.getResources().getString(R.string.n_exchange_order_list_limit) + "-GTC");
            }
        }
        if (!TextUtils.isEmpty(source) && source.contains("stop")) {
            textView2.setText(String.format("%s-%s", new Object[]{context.getText(R.string.n_exchange_plan_entrusts), textView2.getText().toString()}));
        } else if (TradeOrderType.f(type)) {
            textView2.setText(R.string.trade_trend_stop);
        }
        if (orderBeanDetails.getPeriodOrderType() == 1) {
            textView2.setText(R.string.n_exchange_timing_deal);
        }
        textView13.setText(orderBeanDetails.getRole());
    }

    public int getResId() {
        return R.layout.item_history_detail;
    }
}

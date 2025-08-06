package com.huobi.trade.handler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import bt.a2;
import bt.b2;
import bt.c2;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.order.bean.TimeTradeInfo;
import com.huobi.order.ui.TimeTradeDetailOrderActivity;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import i6.r;
import java.util.Iterator;
import pro.huobi.R;
import s9.c;

public class TimeOrderHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void f(Context context, TimeTradeInfo timeTradeInfo, View view) {
        k0.O(context, timeTradeInfo.getSymbol(), timeTradeInfo.getOrderInfo().getOrderSide().equals("buy"));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void g(Context context, TimeTradeInfo timeTradeInfo, View view) {
        k0.O(context, timeTradeInfo.getSymbol(), timeTradeInfo.getOrderInfo().getOrderSide().equals("buy"));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void h(Context context, TimeTradeInfo timeTradeInfo, View view) {
        Intent intent = new Intent();
        intent.setClass(context, TimeTradeDetailOrderActivity.class);
        intent.putExtra("clientOrderId", timeTradeInfo.getOrderInfo().getClientOrderId());
        context.startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, TimeTradeInfo timeTradeInfo, ViewGroup viewGroup) {
        String str;
        String str2;
        v9.c cVar2 = cVar;
        TimeTradeInfo timeTradeInfo2 = timeTradeInfo;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        Resources resources = cVar2.itemView.getResources();
        ConstraintLayout constraintLayout = (ConstraintLayout) e11.b(R.id.item_time_order_root_layout);
        TextView textView = (TextView) e11.b(R.id.id_time_buy_or_sell);
        TextView textView2 = (TextView) e11.b(R.id.id_option_time_order_item_title2);
        TextView textView3 = (TextView) e11.b(R.id.item_order_status);
        ImageView imageView = (ImageView) e11.b(R.id.item_order_status_arrow);
        TextView textView4 = (TextView) e11.b(R.id.id_option_time_order_limit_title);
        TextView textView5 = (TextView) e11.b(R.id.id_option_time_order_limit);
        TextView textView6 = (TextView) e11.b(R.id.id_option_time_order_item_distance_title);
        TextView textView7 = (TextView) e11.b(R.id.id_option_time_order_item_time_interval_title);
        TextView textView8 = (TextView) e11.b(R.id.id_option_time_order_item_time_interval);
        TextView textView9 = (TextView) e11.b(R.id.id_option_time_order_item_unit_volume);
        TextView textView10 = (TextView) e11.b(R.id.id_option_time_order_item_filled_volume_title);
        TextView textView11 = (TextView) e11.b(R.id.id_option_time_order_item_unit_volume_title);
        TextView textView12 = (TextView) e11.b(R.id.id_option_time_order_item_filled_volume);
        TextView textView13 = (TextView) e11.b(R.id.id_option_time_order_item_volume_title);
        TextView textView14 = (TextView) e11.b(R.id.id_option_time_order_item_distance);
        TextView textView15 = (TextView) e11.b(R.id.id_option_time_order_item_volume);
        TextView textView16 = (TextView) e11.b(R.id.id_option_time_order_item_time);
        ((LinearLayout) e11.b(R.id.item_time_order_bottom_detail_layout)).setVisibility(8);
        timeTradeInfo.getCallback();
        textView2.setOnClickListener(new c2(context, timeTradeInfo2));
        textView.setOnClickListener(new a2(context, timeTradeInfo2));
        cVar2.itemView.setOnClickListener(new b2(context, timeTradeInfo2));
        AlgoOrderInfo orderInfo = timeTradeInfo.getOrderInfo();
        String symbol = orderInfo.getSymbol();
        SymbolBean J = a1.v().J(timeTradeInfo.getSymbol(), TradeType.PRO);
        if (J != null) {
            str = J.getBaseCurrencyDisplayName();
            str2 = J.getQuoteCurrencyDisplayName();
        } else {
            Iterator<String> it2 = a1.v().j().iterator();
            String str3 = "";
            String str4 = str3;
            while (it2.hasNext()) {
                String next = it2.next();
                Iterator<String> it3 = it2;
                if (timeTradeInfo.getSymbol().lastIndexOf(next) > 0) {
                    str4 = timeTradeInfo.getSymbol().substring(0, timeTradeInfo.getSymbol().lastIndexOf(next));
                    str3 = next;
                }
                it2 = it3;
            }
            str2 = str3;
            str = str4;
        }
        TextView textView17 = textView6;
        if ("buy".equals(orderInfo.getOrderSide())) {
            textView.setText(resources.getString(R.string.trade_market_buy_label));
            if (w.l()) {
                textView.setBackgroundResource(R.drawable.trade_item_time_order_sell_corner_bg);
            } else {
                textView.setBackgroundResource(R.drawable.trade_item_time_order_buy_corner_bg);
            }
        } else {
            textView.setText(resources.getString(R.string.trade_market_sell_label));
            if (w.l()) {
                textView.setBackgroundResource(R.drawable.trade_item_time_order_buy_corner_bg);
            } else {
                textView.setBackgroundResource(R.drawable.trade_item_time_order_sell_corner_bg);
            }
        }
        textView2.setText((str + "/" + str2).toUpperCase());
        textView3.setVisibility(0);
        if (orderInfo.getOrderStatus().equals("triggered")) {
            textView3.setText(resources.getString(R.string.n_exchange_order_finished));
        } else if (orderInfo.getOrderStatus().equals("stopped")) {
            textView3.setText(resources.getString(R.string.n_exchange_order_stopped));
        } else if (orderInfo.getOrderStatus().equals("canceled")) {
            textView3.setText(resources.getString(R.string.n_exchange_order_canceled));
        } else if (orderInfo.getOrderStatus().equals("rejected")) {
            textView3.setText(resources.getString(R.string.n_exchange_order_rejected));
        }
        imageView.setVisibility(0);
        String str5 = "(" + str2 + ")";
        String str6 = "(" + str + ")";
        textView4.setText(resources.getString(R.string.n_exchange_timing_taker_price_limit) + str5);
        textView7.setText(resources.getString(R.string.n_exchange_timing_interval) + "(S)");
        textView10.setText(resources.getString(R.string.n_exchange_timing_deal_amount) + str6);
        textView13.setText(resources.getString(R.string.n_exchange_timing_order_total_amount) + str6);
        int A = PrecisionUtil.A(symbol);
        textView5.setText(m.m(orderInfo.getOrderPrice(), A));
        if (orderInfo.getOrderPriceType() == 1) {
            textView17.setText(resources.getString(R.string.n_exchange_timing_taker_price_be_superior_to_handicap) + str5);
            textView14.setText(m.m(orderInfo.getOrderPriceGap(), A));
        } else {
            textView17.setText(resources.getString(R.string.n_exchange_timing_taker_price_be_superior_to_handicap) + "(%)");
            textView14.setText(m.Q(orderInfo.getOrderPriceRatio(), 2, 1));
        }
        int z11 = PrecisionUtil.z(timeTradeInfo.getSymbol());
        if (orderInfo.getSingleOrderType() == 1) {
            textView11.setText(resources.getString(R.string.n_exchange_timing_one_order_amount) + str6);
            textView9.setText(m.m(orderInfo.getSingleOrderSize(), z11));
        } else {
            textView11.setText(resources.getString(R.string.n_exchange_timing_one_order_amount) + "(%)");
            textView9.setText(m.Q(orderInfo.getSingleOrderRatio(), 2, 1));
        }
        textView12.setText(m.m(orderInfo.getOrderFinishSize(), z11));
        textView13.setText(String.format("%s%s", new Object[]{resources.getString(R.string.n_exchange_timing_order_total_amount), str6}));
        textView15.setText(m.m(orderInfo.getOrderSize(), z11));
        textView8.setText(String.valueOf(orderInfo.getInterval()));
        textView16.setText(DateTimeUtils.D(orderInfo.getOrderOrigTime()));
    }

    public int getResId() {
        return R.layout.item_time_current_order_list_item;
    }
}

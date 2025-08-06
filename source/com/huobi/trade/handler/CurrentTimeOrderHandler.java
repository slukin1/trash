package com.huobi.trade.handler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import bt.l;
import bt.m;
import bt.n;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.order.bean.CurrentTimeTradeInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.r;
import pro.huobi.R;
import s9.c;

public class CurrentTimeOrderHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void f(CurrentTimeTradeInfo.a aVar, CurrentTimeTradeInfo currentTimeTradeInfo, Context context, View view) {
        if (aVar != null) {
            aVar.b(currentTimeTradeInfo, context);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void g(CurrentTimeTradeInfo.a aVar, CurrentTimeTradeInfo currentTimeTradeInfo, Context context, View view) {
        if (aVar != null) {
            aVar.c(currentTimeTradeInfo, context);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void h(CurrentTimeTradeInfo.a aVar, CurrentTimeTradeInfo currentTimeTradeInfo, Context context, View view) {
        if (aVar != null) {
            aVar.a(currentTimeTradeInfo, context);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, CurrentTimeTradeInfo currentTimeTradeInfo, ViewGroup viewGroup) {
        String str;
        String str2;
        v9.c cVar2 = cVar;
        CurrentTimeTradeInfo currentTimeTradeInfo2 = currentTimeTradeInfo;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        Resources resources = cVar2.itemView.getResources();
        TextView textView = (TextView) e11.b(R.id.id_time_buy_or_sell);
        TextView textView2 = (TextView) e11.b(R.id.id_option_time_order_item_title2);
        TextView textView3 = (TextView) e11.b(R.id.id_option_time_order_limit_title);
        TextView textView4 = (TextView) e11.b(R.id.id_option_time_order_limit);
        TextView textView5 = (TextView) e11.b(R.id.id_option_time_order_item_time_interval_title);
        TextView textView6 = (TextView) e11.b(R.id.id_option_time_order_item_time_interval);
        TextView textView7 = (TextView) e11.b(R.id.id_option_time_order_item_unit_volume);
        TextView textView8 = (TextView) e11.b(R.id.id_option_time_order_item_filled_volume_title);
        TextView textView9 = (TextView) e11.b(R.id.id_option_time_order_item_unit_volume_title);
        TextView textView10 = (TextView) e11.b(R.id.id_option_time_order_item_filled_volume);
        TextView textView11 = (TextView) e11.b(R.id.id_option_time_order_item_volume_title);
        TextView textView12 = (TextView) e11.b(R.id.id_option_time_order_item_distance);
        TextView textView13 = (TextView) e11.b(R.id.id_option_time_order_item_volume);
        TextView textView14 = (TextView) e11.b(R.id.id_option_time_order_item_time);
        TextView textView15 = (TextView) e11.b(R.id.id_option_time_order_item_distance_title);
        ((LinearLayout) e11.b(R.id.item_time_order_bottom_detail_layout)).setVisibility(0);
        View b11 = e11.b(R.id.id_option_time_order_item_stop);
        View b12 = e11.b(R.id.id_option_time_order_item_detail);
        ((TextView) e11.b(R.id.item_order_status)).setVisibility(4);
        ((ImageView) e11.b(R.id.item_order_status_arrow)).setVisibility(4);
        CurrentTimeTradeInfo.a callback = currentTimeTradeInfo.getCallback();
        ((ConstraintLayout) e11.b(R.id.item_time_order_root_layout)).setOnClickListener(new l(callback, currentTimeTradeInfo2, context));
        b11.setOnClickListener(new m(callback, currentTimeTradeInfo2, context));
        b12.setOnClickListener(new n(callback, currentTimeTradeInfo2, context));
        AlgoOrderInfo orderInfo = currentTimeTradeInfo.getOrderInfo();
        String symbol = orderInfo.getSymbol();
        SymbolBean J = a1.v().J(currentTimeTradeInfo.getSymbol(), TradeType.PRO);
        if (J != null) {
            str = J.getBaseCurrencyDisplayName();
            str2 = J.getQuoteCurrencyDisplayName();
        } else {
            String str3 = "";
            String str4 = str3;
            for (String next : a1.v().j()) {
                if (currentTimeTradeInfo.getSymbol().lastIndexOf(next) > 0) {
                    str4 = currentTimeTradeInfo.getSymbol().substring(0, currentTimeTradeInfo.getSymbol().lastIndexOf(next));
                    str3 = next;
                }
            }
            str2 = str3;
            str = str4;
        }
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
        String str5 = "(" + str2 + ")";
        String str6 = "(" + str + ")";
        textView3.setText(resources.getString(R.string.n_exchange_timing_taker_price_limit) + str5);
        textView5.setText(resources.getString(R.string.n_exchange_timing_interval) + "(S)");
        textView8.setText(resources.getString(R.string.n_exchange_timing_deal_amount) + str6);
        textView11.setText(resources.getString(R.string.n_exchange_timing_order_total_amount) + str6);
        int A = PrecisionUtil.A(symbol);
        textView4.setText(i6.m.m(orderInfo.getOrderPrice(), A));
        if (orderInfo.getOrderPriceType() == 1) {
            textView15.setText(resources.getString(R.string.n_exchange_timing_taker_price_be_superior_to_handicap) + str5);
            textView12.setText(i6.m.m(orderInfo.getOrderPriceGap(), A));
        } else {
            textView15.setText(resources.getString(R.string.n_exchange_timing_taker_price_be_superior_to_handicap) + "(%)");
            textView12.setText(i6.m.Q(orderInfo.getOrderPriceRatio(), 2, 1));
        }
        int z11 = PrecisionUtil.z(currentTimeTradeInfo.getSymbol());
        if (orderInfo.getSingleOrderType() == 1) {
            textView9.setText(resources.getString(R.string.n_exchange_timing_one_order_amount) + str6);
            textView7.setText(i6.m.m(orderInfo.getSingleOrderSize(), z11));
        } else {
            textView9.setText(resources.getString(R.string.n_exchange_timing_one_order_amount) + "(%)");
            textView7.setText(i6.m.Q(orderInfo.getSingleOrderRatio(), 2, 1));
        }
        textView10.setText(i6.m.m(orderInfo.getOrderFinishSize(), z11));
        textView11.setText(String.format("%s%s", new Object[]{resources.getString(R.string.n_exchange_timing_order_total_amount), str6}));
        textView13.setText(i6.m.m(orderInfo.getOrderSize(), z11));
        textView6.setText(String.valueOf(orderInfo.getInterval()));
        textView14.setText(DateTimeUtils.D(orderInfo.getOrderOrigTime()));
    }

    public int getResId() {
        return R.layout.item_time_current_order_list_item;
    }
}

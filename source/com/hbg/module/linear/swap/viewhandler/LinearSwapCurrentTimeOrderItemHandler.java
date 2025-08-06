package com.hbg.module.linear.swap.viewhandler;

import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeOrderInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import s9.c;
import ye.b;
import ze.f;
import ze.g;

public class LinearSwapCurrentTimeOrderItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void e(b bVar, View view) {
        if (bVar.c() != null) {
            bVar.c().b(bVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(b bVar, Context context, View view) {
        if (bVar.c() != null) {
            bVar.c().a(context, bVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        boolean z11;
        v9.c cVar2 = cVar;
        b bVar2 = bVar;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        Resources resources = cVar2.itemView.getResources();
        TextView textView = (TextView) e11.b(R$id.id_option_time_order_item_title2);
        TextView textView2 = (TextView) e11.b(R$id.id_option_time_order_item_order_taker_distance_title);
        TextView textView3 = (TextView) e11.b(R$id.id_option_time_order_item_order_taker_distance);
        TextView textView4 = (TextView) e11.b(R$id.id_option_time_order_item_order_taker_limit_title);
        TextView textView5 = (TextView) e11.b(R$id.id_option_time_order_item_order_taker_limit);
        TextView textView6 = (TextView) e11.b(R$id.id_option_time_order_item_time_interval_title);
        TextView textView7 = (TextView) e11.b(R$id.id_option_time_order_item_time_interval);
        TextView textView8 = (TextView) e11.b(R$id.id_option_time_order_item_unit_volume_title);
        TextView textView9 = (TextView) e11.b(R$id.id_option_time_order_item_unit_volume);
        TextView textView10 = (TextView) e11.b(R$id.id_option_time_order_item_filled_volume_title);
        TextView textView11 = (TextView) e11.b(R$id.id_option_time_order_item_volume_title);
        TextView textView12 = (TextView) e11.b(R$id.id_option_time_order_item_volume);
        TextView textView13 = (TextView) e11.b(R$id.id_option_time_order_item_time);
        View b11 = e11.b(R$id.id_option_time_order_item_stop);
        View b12 = e11.b(R$id.id_option_time_order_item_detail);
        LinearSwapTimeOrderInfo g11 = bVar.g();
        String contractCode = g11.getContractCode();
        TextView textView14 = (TextView) e11.b(R$id.id_option_time_order_item_filled_volume);
        FutureContractInfo o11 = FutureContractInfoController.n().o(g11.getContractCode());
        String symbol = o11.getSymbol();
        String i12 = StringUtils.i(bVar.getQuoteCurrency());
        String d11 = bVar.d();
        String str = symbol;
        View view = b12;
        TextView textView15 = textView12;
        TextView textView16 = textView13;
        View view2 = b11;
        String str2 = contractCode;
        String str3 = d11;
        Context context2 = context;
        TextView textView17 = textView14;
        TextView textView18 = textView9;
        TextView textView19 = textView8;
        TextView textView20 = textView7;
        TextView textView21 = textView11;
        TextView textView22 = textView6;
        TextView textView23 = textView5;
        TextView textView24 = textView10;
        TextView textView25 = textView4;
        TextView textView26 = textView3;
        textView.setText(e.j(context, str, g11.getMarginMode().equals(FutureContractInfo.MARGIN_ISOLATED) ? 2 : 1, i12, g11.getOffset(), g11.isBuy(), !g11.getContractType().equals("swap"), g11.getLeverRate(), g11.getContractCode(), bVar.e()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        String str4 = str;
        sb2.append(str4);
        sb2.append(")");
        String sb3 = sb2.toString();
        if (g11.getPriceIntervalMode() == 0) {
            textView2.setText(resources.getString(R$string.n_exchange_timing_taker_open_distance) + "(USDT)");
        } else {
            textView2.setText(resources.getString(R$string.n_exchange_timing_taker_price_range_ratio));
        }
        textView25.setText(resources.getString(R$string.n_exchange_timing_taker_price_limit) + "(USDT)");
        textView22.setText(resources.getString(R$string.n_exchange_timing_interval) + ("(" + resources.getString(R$string.n_exchange_timing_second) + ")"));
        textView19.setText(resources.getString(R$string.n_exchange_timing_one_order_amount) + sb3);
        textView24.setText(resources.getString(R$string.n_exchange_timing_deal_amount) + sb3);
        textView21.setText(resources.getString(R$string.n_exchange_timing_order_total_amount) + sb3);
        String contractFace = o11.getContractFace();
        String price = g11.getPrice();
        int h11 = FuturePrecisionUtil.h(str4);
        if (g11.getPriceIntervalMode() == 1) {
            BigDecimal scale = m.a(g11.getPriceInterval()).multiply(m.a("100")).setScale(2, 1);
            textView26.setText(scale.toPlainString() + "%");
        } else {
            TextView textView27 = textView26;
            if (g11.getPriceIntervalMode() == 0) {
                z11 = true;
                textView27.setText(m.a(g11.getPriceInterval()).setScale(h11, 1).toPlainString());
                textView23.setText(m.a(g11.getPriceLimit()).setScale(h11, z11 ? 1 : 0).toPlainString());
                FuturePrecisionUtil.g(str4);
                String unitVolume = g11.getUnitVolume();
                TradeType tradeType = TradeType.LINEAR_SWAP;
                String str5 = str2;
                String str6 = str3;
                textView18.setText(m.m(FutureUnitUtil.c(unitVolume, price, contractFace, tradeType, z11), FuturePrecisionUtil.s(str5, str6, (String) null)));
                textView17.setText(m.m(FutureUnitUtil.c(g11.getFilledVolume(), price, contractFace, tradeType, z11), FuturePrecisionUtil.s(str5, str6, (String) null)));
                textView15.setText(m.m(FutureUnitUtil.c(g11.getVolume(), price, contractFace, tradeType, z11), FuturePrecisionUtil.s(str5, str6, (String) null)));
                textView20.setText(String.valueOf(g11.getTimeInterval()));
                textView16.setText(String.format("%s %s", new Object[]{resources.getString(R$string.otc_order_detail_payed_order_time), DateTimeUtils.C(g11.getCreatedAt())}));
                b bVar3 = bVar;
                view2.setOnClickListener(new f(bVar3));
                view.setOnClickListener(new g(bVar3, context2));
            }
        }
        z11 = true;
        textView23.setText(m.a(g11.getPriceLimit()).setScale(h11, z11 ? 1 : 0).toPlainString());
        FuturePrecisionUtil.g(str4);
        String unitVolume2 = g11.getUnitVolume();
        TradeType tradeType2 = TradeType.LINEAR_SWAP;
        String str52 = str2;
        String str62 = str3;
        textView18.setText(m.m(FutureUnitUtil.c(unitVolume2, price, contractFace, tradeType2, z11), FuturePrecisionUtil.s(str52, str62, (String) null)));
        textView17.setText(m.m(FutureUnitUtil.c(g11.getFilledVolume(), price, contractFace, tradeType2, z11), FuturePrecisionUtil.s(str52, str62, (String) null)));
        textView15.setText(m.m(FutureUnitUtil.c(g11.getVolume(), price, contractFace, tradeType2, z11), FuturePrecisionUtil.s(str52, str62, (String) null)));
        textView20.setText(String.valueOf(g11.getTimeInterval()));
        textView16.setText(String.format("%s %s", new Object[]{resources.getString(R$string.otc_order_detail_payed_order_time), DateTimeUtils.C(g11.getCreatedAt())}));
        b bVar32 = bVar;
        view2.setOnClickListener(new f(bVar32));
        view.setOnClickListener(new g(bVar32, context2));
    }

    public int getResId() {
        return R$layout.layout_linear_swap_current_time_order_list_item;
    }
}

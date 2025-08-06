package com.hbg.module.option.viewhandler;

import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.option.core.bean.OptionTriggerOrderInfo;
import com.hbg.module.option.R$color;
import com.hbg.module.option.R$id;
import com.hbg.module.option.R$layout;
import com.hbg.module.option.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.util.Locale;
import s9.c;
import sf.b;

public class OptionCurrentTriggerOrderItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(b bVar, View view) {
        if (bVar.c() != null) {
            bVar.c().a(bVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        String str;
        int i12;
        String str2;
        TextView textView;
        String str3;
        v9.c cVar2 = cVar;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        Resources resources = cVar2.itemView.getResources();
        TextView textView2 = (TextView) e11.b(R$id.id_option_current_order_item_title);
        TextView textView3 = (TextView) e11.b(R$id.id_option_current_order_item_title2);
        View b11 = e11.b(R$id.id_option_current_order_item_cancel);
        TextView textView4 = (TextView) e11.b(R$id.id_option_current_order_item_order_amount_title);
        TextView textView5 = (TextView) e11.b(R$id.id_option_current_order_item_order_amount);
        TextView textView6 = (TextView) e11.b(R$id.id_option_current_order_item_condition_title);
        TextView textView7 = (TextView) e11.b(R$id.id_option_current_order_item_condition);
        TextView textView8 = (TextView) e11.b(R$id.id_option_current_order_item_price_title);
        TextView textView9 = (TextView) e11.b(R$id.id_option_current_order_item_price);
        TextView textView10 = (TextView) e11.b(R$id.id_option_current_order_item_time);
        OptionTriggerOrderInfo d11 = bVar.d();
        String symbol = d11.getSymbol();
        TradeType tradeType = TradeType.OPTION;
        if (e.E(tradeType)) {
            str = d11.getSymbol();
        } else {
            str = resources.getString(R$string.contract_market_vol_sheet);
        }
        View view = b11;
        Locale locale = Locale.US;
        TextView textView11 = textView2;
        TextView textView12 = textView9;
        TextView textView13 = textView7;
        textView4.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_volume), new Object[]{str}));
        textView6.setText(resources.getString(R$string.n_exchange_order_list_trigger_condition) + "(" + "usdt".toUpperCase(locale) + ")");
        textView8.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_price), new Object[]{"usdt".toUpperCase(locale)}));
        textView3.setText(e.z(symbol, d11.getOptionCode(), context, resources.getColor(R$color.baseColorPrimaryText)));
        String string = resources.getString(R$string.otc_order_detail_payed_order_time);
        textView10.setText(string + " " + DateTimeUtils.C(d11.getCreatedAt()));
        boolean E = e.E(tradeType);
        String a11 = FutureUnitUtil.a(d11.getVolume(), d11.getOrderPrice(), d11.getContractFace(), tradeType);
        if (E) {
            i12 = FuturePrecisionUtil.s(d11.getContractCode(), (String) null, d11.getOptionCode());
        } else {
            i12 = FuturePrecisionUtil.B();
        }
        textView5.setText(m.m(a11, i12));
        if (d11.isGe()) {
            str2 = resources.getString(R$string.string_flag_bigger_equals);
        } else {
            str2 = resources.getString(R$string.string_flag_smaller_equals);
        }
        TextView textView14 = textView13;
        textView14.setText(String.format(locale, str2, new Object[]{m.n(d11.getTriggerPrice(), FuturePrecisionUtil.y(d11.getContractCode(), (String) null, d11.getOptionCode()), "--")}));
        textView12.setText(m.n(d11.getOrderPrice(), FuturePrecisionUtil.y(d11.getContractCode(), (String) null, d11.getOptionCode()), "--"));
        if (d11.isBuy()) {
            textView = textView11;
            textView.setTextColor(resources.getColor(w.h()));
        } else {
            textView = textView11;
            textView.setTextColor(resources.getColor(w.d()));
        }
        if (d11.isOpen()) {
            if (d11.isBuy()) {
                str3 = resources.getString(R$string.n_contract_trade_open_more);
            } else {
                str3 = resources.getString(R$string.n_contract_trade_open_low);
            }
        } else if (d11.isDelivery()) {
            str3 = resources.getString(R$string.currency_detail_contract_status_force_delivry);
        } else if (d11.isBuy()) {
            str3 = resources.getString(R$string.n_contract_trade_close_low);
        } else {
            str3 = resources.getString(R$string.n_contract_trade_close_more);
        }
        textView.setText(str3);
        view.setOnClickListener(new tf.b(bVar));
    }

    public int getResId() {
        return R$layout.layout_option_current_trigger_order_list_item;
    }
}

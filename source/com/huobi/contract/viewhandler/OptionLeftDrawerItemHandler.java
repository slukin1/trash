package com.huobi.contract.viewhandler;

import a7.e;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.contract.R$color;
import com.hbg.lib.contract.R$drawable;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.contract.entity.OptionCurrencyInfoDrawerItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fj.u;
import i6.m;
import i6.r;
import s9.c;

public class OptionLeftDrawerItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void h(OptionCurrencyInfoDrawerItem optionCurrencyInfoDrawerItem, View view) {
        if (optionCurrencyInfoDrawerItem.c() != null) {
            optionCurrencyInfoDrawerItem.c().e(optionCurrencyInfoDrawerItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final int c(OptionCurrencyInfoDrawerItem optionCurrencyInfoDrawerItem) {
        if (optionCurrencyInfoDrawerItem.e()) {
            return R$color.trade_dialog_divider_color_night;
        }
        return R$color.trade_dialog_divider_color_light;
    }

    public final int d(OptionCurrencyInfoDrawerItem optionCurrencyInfoDrawerItem) {
        if (optionCurrencyInfoDrawerItem.e()) {
            return R$color.global_module_focus_bg_night;
        }
        return R$color.global_module_focus_bg_light;
    }

    public final int e(OptionCurrencyInfoDrawerItem optionCurrencyInfoDrawerItem) {
        if (optionCurrencyInfoDrawerItem.e()) {
            return R$color.global_main_text_color_night;
        }
        return R$color.global_main_text_color_light;
    }

    public final int f(OptionCurrencyInfoDrawerItem optionCurrencyInfoDrawerItem) {
        if (optionCurrencyInfoDrawerItem.e()) {
            return R$drawable.selector_trade_coin_market_bg_night;
        }
        return R$drawable.selector_trade_coin_market_bg_light;
    }

    /* renamed from: g */
    public void handleView(v9.c cVar, int i11, OptionCurrencyInfoDrawerItem optionCurrencyInfoDrawerItem, ViewGroup viewGroup) {
        String str;
        Double close;
        Resources resources = cVar.itemView.getResources();
        r e11 = cVar.e();
        View b11 = e11.b(R$id.id_contract_left_drawer_item_symbol_layout);
        TextView textView = (TextView) e11.b(R$id.id_contract_left_drawer_item_symbol_name);
        TextView textView2 = (TextView) e11.b(R$id.id_contract_left_drawer_item_cycle);
        TextView textView3 = (TextView) e11.b(R$id.id_contract_left_drawer_item_symbol_price);
        TextView textView4 = (TextView) e11.b(R$id.id_contract_left_drawer_item_symbol_percent);
        View b12 = e11.b(R$id.v_bottom_line);
        if (optionCurrencyInfoDrawerItem.c() != null) {
            if (optionCurrencyInfoDrawerItem.c().a(optionCurrencyInfoDrawerItem)) {
                b11.setBackgroundResource(d(optionCurrencyInfoDrawerItem));
            } else {
                b11.setBackgroundResource(f(optionCurrencyInfoDrawerItem));
            }
        }
        FutureContractInfo d11 = optionCurrencyInfoDrawerItem.d();
        textView.setText(e.z(d11.getSymbol(), d11.getOptionCode(), cVar.itemView.getContext(), ContextCompat.getColor(cVar.itemView.getContext(), e(optionCurrencyInfoDrawerItem))));
        textView2.setTextColor(ContextCompat.getColor(cVar.itemView.getContext(), e(optionCurrencyInfoDrawerItem)));
        SymbolPrice symbolPrice = optionCurrencyInfoDrawerItem.getSymbolPrice();
        int i12 = R$color.global_secondary_text_color;
        if (symbolPrice == null || (close = symbolPrice.getClose()) == null) {
            str = "--";
        } else {
            str = m.m(String.valueOf(close), FuturePrecisionUtil.y(d11.getContractCode(), d11.getContractShortType(), d11.getOptionCode()));
            Double open = symbolPrice.getOpen();
            double doubleValue = open != null ? close.doubleValue() - open.doubleValue() : 0.0d;
            if (Double.compare(doubleValue, 0.0d) > 0) {
                i12 = w.h();
            } else if (Double.compare(doubleValue, 0.0d) < 0) {
                i12 = w.d();
            } else {
                i12 = R$color.color_flat;
            }
        }
        textView3.setText(str);
        textView3.setTextColor(resources.getColor(i12));
        textView4.setTextColor(resources.getColor(i12));
        textView4.setVisibility(8);
        cVar.itemView.setOnClickListener(new u(optionCurrencyInfoDrawerItem));
        b12.setBackgroundColor(ContextCompat.getColor(cVar.itemView.getContext(), c(optionCurrencyInfoDrawerItem)));
    }

    public int getResId() {
        return R$layout.layout_option_left_drawer_item;
    }
}

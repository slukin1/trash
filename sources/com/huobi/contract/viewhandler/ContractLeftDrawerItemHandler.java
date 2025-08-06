package com.huobi.contract.viewhandler;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.contract.R$color;
import com.hbg.lib.contract.R$drawable;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractCurrencyInfoDrawerItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ej.f;
import ej.g;
import fj.e;
import i6.m;
import i6.r;
import s9.c;

public class ContractLeftDrawerItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void g(ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem, View view) {
        if (contractCurrencyInfoDrawerItem.d().isNotSupportTrade()) {
            HuobiToastUtil.j(R$string.n_futures_not_support_click_hint);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (contractCurrencyInfoDrawerItem.c() != null) {
            contractCurrencyInfoDrawerItem.c().e(contractCurrencyInfoDrawerItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final int c(ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem) {
        if (contractCurrencyInfoDrawerItem.d().isNightMode()) {
            return R$color.global_module_focus_bg_night;
        }
        return R$color.global_module_focus_bg_light;
    }

    public final int d(ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem) {
        if (contractCurrencyInfoDrawerItem.d().isNotSupportTrade()) {
            if (contractCurrencyInfoDrawerItem.d().isNightMode()) {
                return R$color.color_not_support_trade_text_color_night;
            }
            return R$color.color_not_support_trade_text_color_light;
        } else if (contractCurrencyInfoDrawerItem.d().isNightMode()) {
            return R$color.global_main_text_color_night;
        } else {
            return R$color.global_main_text_color_light;
        }
    }

    public final int e(ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem) {
        if (contractCurrencyInfoDrawerItem.d().isNotSupportTrade()) {
            if (contractCurrencyInfoDrawerItem.d().isNightMode()) {
                return R$drawable.selector_trade_coin_market_not_trade_bg_night;
            }
            return R$drawable.selector_trade_coin_market_not_trade_bg_light;
        } else if (contractCurrencyInfoDrawerItem.d().isNightMode()) {
            return R$drawable.selector_trade_coin_market_bg_night;
        } else {
            return R$drawable.selector_trade_coin_market_bg_light;
        }
    }

    /* renamed from: f */
    public void handleView(v9.c cVar, int i11, ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem, ViewGroup viewGroup) {
        TextView textView;
        String str;
        Double close;
        TextView textView2;
        double d11;
        int i12;
        v9.c cVar2 = cVar;
        ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem2 = contractCurrencyInfoDrawerItem;
        Resources resources = cVar2.itemView.getResources();
        Context context = cVar2.itemView.getContext();
        r e11 = cVar.e();
        View b11 = e11.b(R$id.id_contract_left_drawer_item_symbol_layout);
        TextView textView3 = (TextView) e11.b(R$id.id_contract_left_drawer_item_symbol_price);
        TextView textView4 = (TextView) e11.b(R$id.id_contract_left_drawer_item_symbol_percent);
        TextView e12 = e11.e(R$id.item_symbol_name);
        TextView e13 = e11.e(R$id.item_contract_type);
        if (contractCurrencyInfoDrawerItem.c() != null) {
            if (contractCurrencyInfoDrawerItem.c().a(contractCurrencyInfoDrawerItem2)) {
                b11.setBackgroundResource(c(contractCurrencyInfoDrawerItem2));
            } else {
                b11.setBackgroundResource(e(contractCurrencyInfoDrawerItem2));
            }
        }
        String i13 = g.i(context, contractCurrencyInfoDrawerItem.d().getSymbol());
        e12.setText(i13);
        e13.setText(" " + g.k(context, contractCurrencyInfoDrawerItem.d().getContractCode(), contractCurrencyInfoDrawerItem.d().getContractType()));
        h(contractCurrencyInfoDrawerItem2, e13);
        e12.setTextColor(ContextCompat.getColor(cVar2.itemView.getContext(), d(contractCurrencyInfoDrawerItem2)));
        SymbolPrice symbolPrice = contractCurrencyInfoDrawerItem.d().getSymbolPrice();
        int i14 = R$color.global_secondary_text_color;
        String str2 = "--";
        if (symbolPrice == null || (close = symbolPrice.getClose()) == null) {
            textView = textView3;
            str = str2;
        } else {
            String valueOf = String.valueOf(close);
            String str3 = resources.getString(R$string.contract_symbol_price_dollar) + m.m(valueOf, f.p(contractCurrencyInfoDrawerItem.d().getContractCode()));
            Double open = symbolPrice.getOpen();
            if (open != null) {
                d11 = close.doubleValue() - open.doubleValue();
                textView2 = textView3;
            } else {
                textView2 = textView3;
                d11 = 0.0d;
            }
            if (Double.compare(close.doubleValue(), 0.0d) != 0) {
                boolean z11 = Double.compare(d11, 0.0d) > 0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(z11 ? "+" : "");
                sb2.append(m.i((d11 / open.doubleValue()) * 100.0d, PrecisionUtil.v(contractCurrencyInfoDrawerItem.d().getSymbol())));
                sb2.append("%");
                str2 = sb2.toString();
            }
            if (Double.compare(d11, 0.0d) > 0) {
                if (contractCurrencyInfoDrawerItem.d().isNotSupportTrade()) {
                    i12 = w.g();
                } else {
                    i12 = w.h();
                }
            } else if (Double.compare(d11, 0.0d) >= 0) {
                i12 = R$color.color_flat;
            } else if (contractCurrencyInfoDrawerItem.d().isNotSupportTrade()) {
                i12 = w.f();
            } else {
                i12 = w.d();
            }
            textView = textView2;
            String str4 = str3;
            i14 = i12;
            str = str2;
            str2 = str4;
        }
        textView.setText(str2);
        textView.setTextColor(ContextCompat.getColor(cVar2.itemView.getContext(), d(contractCurrencyInfoDrawerItem2)));
        textView4.setText(str);
        textView4.setTextColor(resources.getColor(i14));
        textView4.setVisibility(contractCurrencyInfoDrawerItem.d().isPercentVisible() ? 0 : 8);
        cVar2.itemView.setOnClickListener(new e(contractCurrencyInfoDrawerItem2));
    }

    public int getResId() {
        return R$layout.layout_contract_left_drawer_item;
    }

    public final void h(ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem, TextView textView) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        contractCurrencyInfoDrawerItem.e();
        gradientDrawable.setColor(251753445);
        gradientDrawable.setCornerRadius((float) PixelUtils.a(2.0f));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), contractCurrencyInfoDrawerItem.e() ? R$color.global_major_theme100_night : R$color.global_major_theme100_light));
    }
}

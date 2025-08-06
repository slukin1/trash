package com.huobi.swap.viewhandler;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.swap.bean.SwapCurrencyInfoDrawerItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import pro.huobi.R;
import s9.c;
import us.i;
import us.j;
import vs.a;

public class SwapLeftDrawerItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void g(SwapCurrencyInfo swapCurrencyInfo, SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem, View view) {
        if (swapCurrencyInfo.isNotSupportTrade()) {
            HuobiToastUtil.j(R.string.n_futures_not_support_click_hint);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (swapCurrencyInfoDrawerItem.c() != null) {
            swapCurrencyInfoDrawerItem.c().e(swapCurrencyInfoDrawerItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final int c(SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem) {
        return swapCurrencyInfoDrawerItem.e() ? R.color.global_module_focus_bg_night : R.color.global_module_focus_bg_light;
    }

    public final int d(SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem) {
        return swapCurrencyInfoDrawerItem.d().isNotSupportTrade() ? swapCurrencyInfoDrawerItem.e() ? R.color.color_not_support_trade_text_color_night : R.color.color_not_support_trade_text_color_light : swapCurrencyInfoDrawerItem.e() ? R.color.global_main_text_color_night : R.color.global_main_text_color_light;
    }

    public final int e(SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem) {
        return swapCurrencyInfoDrawerItem.d().isNotSupportTrade() ? swapCurrencyInfoDrawerItem.e() ? R.drawable.selector_trade_coin_market_not_trade_bg_night : R.drawable.selector_trade_coin_market_not_trade_bg_light : swapCurrencyInfoDrawerItem.e() ? R.drawable.selector_trade_coin_market_bg_night : R.drawable.selector_trade_coin_market_bg_light;
    }

    /* renamed from: f */
    public void handleView(v9.c cVar, int i11, SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem, ViewGroup viewGroup) {
        TextView textView;
        String str;
        Double close;
        TextView textView2;
        double d11;
        int i12;
        v9.c cVar2 = cVar;
        SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem2 = swapCurrencyInfoDrawerItem;
        SwapCurrencyInfo d12 = swapCurrencyInfoDrawerItem.d();
        Resources resources = cVar2.itemView.getResources();
        Context context = cVar2.itemView.getContext();
        r e11 = cVar.e();
        View b11 = e11.b(R.id.id_contract_left_drawer_item_symbol_layout);
        TextView textView3 = (TextView) e11.b(R.id.id_contract_left_drawer_item_symbol_price);
        TextView textView4 = (TextView) e11.b(R.id.id_contract_left_drawer_item_symbol_percent);
        TextView e12 = e11.e(R.id.item_symbol_name);
        TextView e13 = e11.e(R.id.item_contract_type);
        if (swapCurrencyInfoDrawerItem.c() != null) {
            if (swapCurrencyInfoDrawerItem.c().a(swapCurrencyInfoDrawerItem2)) {
                b11.setBackgroundResource(c(swapCurrencyInfoDrawerItem2));
            } else {
                b11.setBackgroundResource(e(swapCurrencyInfoDrawerItem2));
            }
        }
        e12.setText(j.i(d12.getSymbol()));
        e13.setText(" " + j.j(context));
        h(swapCurrencyInfoDrawerItem2, e13);
        e12.setTextColor(ContextCompat.getColor(cVar2.itemView.getContext(), d(swapCurrencyInfoDrawerItem2)));
        SymbolPrice symbolPrice = swapCurrencyInfoDrawerItem.getSymbolPrice();
        int i13 = R.color.global_secondary_text_color;
        String str2 = "--";
        if (symbolPrice == null || (close = symbolPrice.getClose()) == null) {
            textView = textView3;
            str = str2;
        } else {
            String valueOf = String.valueOf(close);
            String str3 = resources.getString(R.string.contract_symbol_price_dollar) + m.m(valueOf, i.o(d12.getSymbol()));
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
                sb2.append(m.i((d11 / open.doubleValue()) * 100.0d, PrecisionUtil.v(d12.getSymbol())));
                sb2.append("%");
                str2 = sb2.toString();
            }
            if (Double.compare(d11, 0.0d) > 0) {
                i12 = d12.isNotSupportTrade() ? w.g() : w.h();
            } else if (Double.compare(d11, 0.0d) < 0) {
                i12 = d12.isNotSupportTrade() ? w.f() : w.d();
            } else {
                i12 = R.color.color_flat;
            }
            textView = textView2;
            String str4 = str3;
            i13 = i12;
            str = str2;
            str2 = str4;
        }
        textView.setText(str2);
        textView.setTextColor(ContextCompat.getColor(cVar2.itemView.getContext(), d(swapCurrencyInfoDrawerItem2)));
        textView4.setText(str);
        textView4.setTextColor(resources.getColor(i13));
        textView4.setVisibility(swapCurrencyInfoDrawerItem.f() ? 0 : 8);
        cVar2.itemView.setOnClickListener(new a(d12, swapCurrencyInfoDrawerItem2));
    }

    public int getResId() {
        return R.layout.layout_contract_left_drawer_item;
    }

    public final void h(SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem, TextView textView) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        swapCurrencyInfoDrawerItem.e();
        gradientDrawable.setColor(251753445);
        gradientDrawable.setCornerRadius((float) PixelUtils.a(2.0f));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), swapCurrencyInfoDrawerItem.e() ? R.color.global_major_theme100_night : R.color.global_major_theme100_light));
    }
}

package com.huobi.linearswap.viewhandler;

import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import en.a;
import i6.r;
import pro.huobi.R;
import s9.c;

public class LinearSwapLeftDrawerItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void g(FutureContractInfo futureContractInfo, LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem, View view) {
        if (futureContractInfo.isNotSupportTrade()) {
            HuobiToastUtil.j(R.string.n_futures_not_support_click_hint);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (linearSwapCurrencyInfoDrawerItem.c() != null) {
            linearSwapCurrencyInfoDrawerItem.c().e(linearSwapCurrencyInfoDrawerItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final int c(LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem) {
        return linearSwapCurrencyInfoDrawerItem.h() ? R.color.global_module_focus_bg_night : R.color.global_module_focus_bg_light;
    }

    public final int d(LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem) {
        return linearSwapCurrencyInfoDrawerItem.e().isNotSupportTrade() ? linearSwapCurrencyInfoDrawerItem.h() ? R.color.color_not_support_trade_text_color_night : R.color.color_not_support_trade_text_color_light : linearSwapCurrencyInfoDrawerItem.h() ? R.color.global_main_text_color_night : R.color.global_main_text_color_light;
    }

    public final int e(LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem) {
        return linearSwapCurrencyInfoDrawerItem.e().isNotSupportTrade() ? linearSwapCurrencyInfoDrawerItem.h() ? R.drawable.selector_trade_coin_market_not_trade_bg_night : R.drawable.selector_trade_coin_market_not_trade_bg_light : linearSwapCurrencyInfoDrawerItem.h() ? R.drawable.selector_trade_coin_market_bg_night : R.drawable.selector_trade_coin_market_bg_light;
    }

    /* renamed from: f */
    public void handleView(v9.c cVar, int i11, LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem, ViewGroup viewGroup) {
        Double close;
        FutureContractInfo e11 = linearSwapCurrencyInfoDrawerItem.e();
        Resources resources = cVar.itemView.getResources();
        Context context = cVar.itemView.getContext();
        r e12 = cVar.e();
        View b11 = e12.b(R.id.id_contract_left_drawer_item_symbol_layout);
        TextView textView = (TextView) e12.b(R.id.id_contract_left_drawer_item_symbol_price);
        TextView textView2 = (TextView) e12.b(R.id.id_contract_left_drawer_item_symbol_percent);
        TextView e13 = e12.e(R.id.item_symbol_name);
        TextView e14 = e12.e(R.id.item_contract_type);
        if (linearSwapCurrencyInfoDrawerItem.c() != null) {
            if (linearSwapCurrencyInfoDrawerItem.c().a(linearSwapCurrencyInfoDrawerItem)) {
                b11.setBackgroundResource(c(linearSwapCurrencyInfoDrawerItem));
            } else {
                b11.setBackgroundResource(e(linearSwapCurrencyInfoDrawerItem));
            }
        }
        e13.setText(e.p(context, e11.getSymbol(), e11.getQuoteCurrency()));
        e14.setText(e.r(context, e11.getContractCode(), e11.getContractType()));
        h(linearSwapCurrencyInfoDrawerItem, e14);
        e13.setTextColor(ContextCompat.getColor(cVar.itemView.getContext(), d(linearSwapCurrencyInfoDrawerItem)));
        SymbolPrice symbolPrice = linearSwapCurrencyInfoDrawerItem.getSymbolPrice();
        int i12 = R.color.global_secondary_text_color;
        if (!(symbolPrice == null || (close = symbolPrice.getClose()) == null)) {
            Double open = symbolPrice.getOpen();
            double doubleValue = open != null ? close.doubleValue() - open.doubleValue() : 0.0d;
            i12 = Double.compare(doubleValue, 0.0d) > 0 ? e11.isNotSupportTrade() ? w.g() : w.h() : Double.compare(doubleValue, 0.0d) < 0 ? e11.isNotSupportTrade() ? w.f() : w.d() : R.color.color_flat;
        }
        textView.setText(linearSwapCurrencyInfoDrawerItem.f());
        textView.setTextColor(ContextCompat.getColor(cVar.itemView.getContext(), d(linearSwapCurrencyInfoDrawerItem)));
        textView2.setText(linearSwapCurrencyInfoDrawerItem.d());
        textView2.setTextColor(resources.getColor(i12));
        textView2.setVisibility(linearSwapCurrencyInfoDrawerItem.i() ? 0 : 8);
        cVar.itemView.setOnClickListener(new a(e11, linearSwapCurrencyInfoDrawerItem));
    }

    public int getResId() {
        return R.layout.layout_contract_left_drawer_item;
    }

    public final void h(LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem, TextView textView) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        linearSwapCurrencyInfoDrawerItem.h();
        gradientDrawable.setColor(251753445);
        gradientDrawable.setCornerRadius((float) PixelUtils.a(2.0f));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), linearSwapCurrencyInfoDrawerItem.h() ? R.color.global_major_theme100_night : R.color.global_major_theme100_light));
    }
}

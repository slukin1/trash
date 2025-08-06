package com.huobi.finance.viewhandler;

import al.p;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.LegalDetailInfo;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.r;
import java.util.Locale;
import s9.c;

public class LegalItemViewAdapter implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, LegalDetailInfo legalDetailInfo, ViewGroup viewGroup) {
        v9.c cVar2 = cVar;
        View view = cVar2.itemView;
        Context context = view.getContext();
        String currency = legalDetailInfo.getCurrency() == null ? "" : legalDetailInfo.getCurrency();
        MarketCoin.Coin h11 = OtcMarketPriceConfigUtil.h(legalDetailInfo.getCoinId());
        r e11 = cVar.e();
        TextView e12 = e11.e(R$id.item_balance_currency_name);
        TextView e13 = e11.e(R$id.item_balance_currency_available);
        TextView e14 = e11.e(R$id.item_balance_currency_onorders);
        TextView textView = (TextView) e11.b(R$id.item_balance_detail_convert);
        TextView textView2 = (TextView) e11.b(R$id.item_balance_detail_convert_value);
        ImageView imageView = (ImageView) e11.b(R$id.item_balance_limit_undone);
        ImageView c11 = e11.c(R$id.item_margin_balance_symbol_icon);
        TextView e15 = e11.e(R$id.item_balance_currency_name_all);
        CurrencyBean s11 = k.C().s(legalDetailInfo.getCurrency());
        if (s11 != null) {
            e15.setText(s11.getFullName());
        } else {
            e15.setText("");
        }
        f6.c.a().l(view.getContext(), p.k(legalDetailInfo.getCurrency()), c11, p.m());
        if (h11 != null) {
            e12.setText(h11.getShortName());
        } else {
            e12.setText(currency.toUpperCase(Locale.US));
        }
        imageView.setVisibility(8);
        int i12 = R$color.global_main_text_color;
        int color = ContextCompat.getColor(context, i12);
        int color2 = ContextCompat.getColor(context, i12);
        int color3 = ContextCompat.getColor(context, R$color.global_secondary_text_color);
        e12.setTextColor(color);
        e13.setTextColor(color2);
        e14.setTextColor(color2);
        textView2.setTextColor(color3);
        if (p.u()) {
            if (h11 != null) {
                h11.isFiatCoin();
            }
            e13.setText(p.j(legalDetailInfo.getAvaialAble(), legalDetailInfo.getCurrency()));
            e14.setText(p.j(legalDetailInfo.getOnOrders(), legalDetailInfo.getCurrency()));
            textView.setText(String.format(context.getString(R$string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
            textView2.setText(legalDetailInfo.getEstimateAmount());
        } else {
            String string = cVar2.itemView.getResources().getString(R$string.balance_hide_star);
            e13.setText(string);
            e14.setText(string);
            textView.setText(String.format(context.getString(R$string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
            textView2.setText(string);
        }
        view.setTag(R$id.item_data, legalDetailInfo);
        view.setOnClickListener(this);
    }

    public final void c(Context context, LegalDetailInfo legalDetailInfo) {
        if (legalDetailInfo != null && legalDetailInfo.getCurrency() != null && p.d(context)) {
            AssetModuleConfig.a().q0(context, legalDetailInfo);
        }
    }

    public int getResId() {
        return R$layout.item_legal_detail;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int i11 = R$id.item_data;
        if (!(view.getTag(i11) instanceof LegalDetailInfo)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        c(view.getContext(), (LegalDetailInfo) view.getTag(i11));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

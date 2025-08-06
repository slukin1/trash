package com.huobi.finance.viewhandler;

import al.p;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bc.a;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.r;
import java.util.Locale;
import s9.c;

public class BalanceViewAdapter implements c, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final a f67613b = AssetModuleConfig.a();

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, BalanceDetailInfo balanceDetailInfo, ViewGroup viewGroup) {
        int i12;
        v9.c cVar2 = cVar;
        View view = cVar2.itemView;
        Context context = view.getContext();
        balanceDetailInfo.getCurrency();
        int status = balanceDetailInfo.getStatus();
        r e11 = cVar.e();
        TextView e12 = e11.e(R$id.item_balance_currency_name);
        TextView e13 = e11.e(R$id.item_balance_currency_available);
        TextView e14 = e11.e(R$id.item_balance_currency_onorders);
        TextView textView = (TextView) e11.b(R$id.item_balance_detail_convert);
        TextView textView2 = (TextView) e11.b(R$id.item_balance_detail_convert_value);
        TextView textView3 = (TextView) e11.b(R$id.item_balance_currency_lock);
        ImageView imageView = (ImageView) e11.b(R$id.item_balance_limit_undone);
        TextView textView4 = (TextView) e11.b(R$id.item_balance_stable_collection);
        ImageView c11 = e11.c(R$id.item_margin_balance_symbol_icon);
        TextView e15 = e11.e(R$id.item_balance_currency_name_all);
        CurrencyBean s11 = k.C().s(balanceDetailInfo.getCurrency());
        if (s11 != null) {
            e15.setText(s11.getFullName());
        } else {
            e15.setText("");
        }
        f6.c.a().l(context, p.k(balanceDetailInfo.getCurrency()), c11, p.m());
        e12.setText(balanceDetailInfo.getDisplayName());
        boolean z11 = (status & 16) != 0;
        boolean z12 = (status & 1) != 0;
        boolean z13 = (status & 8) != 0;
        imageView.setVisibility(8);
        int i13 = R$color.global_main_text_color;
        int color = ContextCompat.getColor(context, i13);
        int color2 = ContextCompat.getColor(context, i13);
        int color3 = ContextCompat.getColor(context, R$color.global_secondary_text_color);
        if (z11 || (!z13 && !z12)) {
            i12 = color;
        } else {
            color2 = ContextCompat.getColor(context, R$color.global_default_text_color);
            i12 = color2;
            color3 = i12;
        }
        e12.setTextColor(i12);
        e13.setTextColor(color2);
        e14.setTextColor(color2);
        textView2.setTextColor(color3);
        textView3.setTextColor(color2);
        if (p.u()) {
            k.C().L(balanceDetailInfo.getCurrency());
            e13.setText(p.j(balanceDetailInfo.getAvaialAble(), balanceDetailInfo.getCurrency()));
            e14.setText(p.j(balanceDetailInfo.getOnOrders(), balanceDetailInfo.getCurrency()));
            if (!TextUtils.isEmpty(balanceDetailInfo.getLock())) {
                String j11 = p.j(balanceDetailInfo.getLock(), balanceDetailInfo.getCurrency());
                textView3.setVisibility(0);
                textView3.setText(String.format(context.getString(R$string.balance_detail_lock), new Object[]{j11}));
            } else {
                textView3.setVisibility(8);
            }
            if (z11) {
                textView.setText(String.format(context.getString(R$string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
                textView2.setText(balanceDetailInfo.getEstimateAmount());
            } else if (z13) {
                textView.setText(context.getString(R$string.balance_detail_status));
                textView2.setText(R$string.balance_detail_status_blacklist);
            } else if (z12) {
                textView.setText(context.getString(R$string.balance_detail_status));
                textView2.setText(R$string.balance_detail_status_close);
            } else {
                textView.setText(String.format(context.getString(R$string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
                textView2.setText(balanceDetailInfo.getEstimateAmount());
            }
        } else {
            String string = cVar2.itemView.getResources().getString(R$string.balance_hide_star);
            e13.setText(string);
            e14.setText(string);
            if (!TextUtils.isEmpty(balanceDetailInfo.getLock())) {
                textView3.setVisibility(0);
                textView3.setText(String.format(context.getString(R$string.balance_detail_lock), new Object[]{string}));
            } else {
                textView3.setVisibility(8);
            }
            if (z11) {
                textView.setText(String.format(context.getString(R$string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
                textView2.setText(string);
            } else if (z13) {
                textView.setText(context.getString(R$string.balance_detail_status));
                textView2.setText(R$string.balance_detail_status_blacklist);
            } else if (z12) {
                textView.setText(context.getString(R$string.balance_detail_status));
                textView2.setText(R$string.balance_detail_status_close);
            } else {
                textView.setText(String.format(context.getString(R$string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
                textView2.setText(string);
            }
        }
        view.setTag(R$id.item_data, balanceDetailInfo);
        view.setOnClickListener(this);
    }

    public final void c(Context context, BalanceDetailInfo balanceDetailInfo) {
        if (p.d(context)) {
            this.f67613b.T0(context, balanceDetailInfo);
        }
    }

    public int getResId() {
        return R$layout.item_balance_detail;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        c(view.getContext(), (BalanceDetailInfo) view.getTag(R$id.item_data));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

package com.huobi.finance.viewhandler;

import al.p;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bl.y2;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.OtcOptionsDetailInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.r;
import java.util.HashMap;
import java.util.Locale;
import s9.c;

public class OtcOptionsBalanceViewAdapter implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(OtcOptionsDetailInfo otcOptionsDetailInfo, Context context, View view) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("currency_name", otcOptionsDetailInfo.getCurrency());
        AssetModuleConfig.a().track("app_assets_warrant_currency_click", hashMap);
        if (!p.d(context)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        AssetModuleConfig.a().x(context, otcOptionsDetailInfo);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, OtcOptionsDetailInfo otcOptionsDetailInfo, ViewGroup viewGroup) {
        View view = cVar.itemView;
        Context context = view.getContext();
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.tv_available);
        TextView textView2 = (TextView) e11.b(R$id.tv_frozen_sum);
        TextView textView3 = (TextView) e11.b(R$id.tv_estimate_content);
        TextView textView4 = (TextView) e11.b(R$id.tv_estimate_label);
        ((TextView) e11.b(R$id.tv_title)).setText(k.C().z(otcOptionsDetailInfo.getCurrency()));
        ImageView c11 = e11.c(R$id.item_margin_balance_symbol_icon);
        TextView e12 = e11.e(R$id.item_balance_currency_name_all);
        CurrencyBean s11 = k.C().s(otcOptionsDetailInfo.getCurrency());
        if (s11 != null) {
            e12.setText(s11.getFullName());
        } else {
            e12.setText("");
        }
        f6.c.a().l(context, p.k(otcOptionsDetailInfo.getCurrency()), c11, p.m());
        if (p.u()) {
            textView.setText(p.j(otcOptionsDetailInfo.getAvaialAble(), otcOptionsDetailInfo.getCurrency()));
            textView2.setText(p.j(otcOptionsDetailInfo.getOnOrders(), otcOptionsDetailInfo.getCurrency()));
            String upperCase = LegalCurrencyConfigUtil.y().toUpperCase(Locale.US);
            textView4.setText(context.getString(R$string.n_balance_equivalent_ph, new Object[]{StringUtils.i(upperCase)}));
            textView3.setText(otcOptionsDetailInfo.getEstimateAmount());
        } else {
            String string = cVar.itemView.getResources().getString(R$string.balance_hide_star);
            textView.setText(string);
            textView2.setText(string);
            textView3.setText(string);
        }
        view.setTag(R$id.item_data, otcOptionsDetailInfo);
        view.setOnClickListener(new y2(otcOptionsDetailInfo, context));
    }

    public int getResId() {
        return R$layout.item_otc_options_balance_detail;
    }
}

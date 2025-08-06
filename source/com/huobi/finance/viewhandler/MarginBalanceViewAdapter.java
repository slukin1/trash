package com.huobi.finance.viewhandler;

import al.p;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.MarginBalanceDetailInfo;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.trade.helper.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.Locale;
import s9.c;

public class MarginBalanceViewAdapter implements c, View.OnClickListener {
    public final void b(MarginBalanceDetailInfo marginBalanceDetailInfo, Resources resources, r rVar) {
        String str;
        LinearLayout linearLayout = (LinearLayout) rVar.b(R$id.ll_risk_status);
        View b11 = rVar.b(R$id.tv_risk_icon);
        TextView textView = (TextView) rVar.b(R$id.tv_risk_status);
        View b12 = rVar.b(R$id.risk_space);
        MarginBalanceQueryData marginBalanceQueryData = marginBalanceDetailInfo.getMarginBalanceQueryData();
        if (marginBalanceQueryData != null) {
            str = a.a(marginBalanceQueryData.getRiskRate(), marginBalanceQueryData.getState());
        } else {
            str = "3";
        }
        linearLayout.setBackground((Drawable) null);
        b11.setVisibility(8);
        b12.setVisibility(8);
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c11 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c11 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c11 = 2;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1444:
                if (str.equals("-1")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                b11.setVisibility(0);
                linearLayout.setBackgroundResource(R$drawable.margin_risk_bg);
                b12.setVisibility(0);
                textView.setTextColor(resources.getColor(R$color.baseColorShadeButtonRedStart));
                textView.setText(resources.getString(R$string.risk_rate_liquidating));
                return;
            case 1:
                textView.setTextColor(resources.getColor(R$color.baseColorShadeButtonRedStart));
                textView.setText(resources.getString(R$string.margin_risk_rate_high_risk));
                return;
            case 2:
                textView.setTextColor(resources.getColor(R$color.otc_trade_desc_hint_color));
                textView.setText(resources.getString(R$string.margin_risk_rate_unsafe));
                return;
            case 3:
                textView.setTextColor(resources.getColor(R$color.color_rise));
                textView.setText(resources.getString(R$string.margin_risk_safe));
                return;
            case 4:
                b11.setVisibility(0);
                linearLayout.setBackgroundResource(R$drawable.margin_risk_bg);
                b12.setVisibility(0);
                textView.setTextColor(resources.getColor(R$color.baseColorShadeButtonRedStart));
                textView.setText(resources.getString(R$string.margin_risk_rate_negative));
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, MarginBalanceDetailInfo marginBalanceDetailInfo, ViewGroup viewGroup) {
        MarginBalanceDetailInfo marginBalanceDetailInfo2 = marginBalanceDetailInfo;
        View view = cVar.itemView;
        Resources resources = view.getResources();
        Context context = view.getContext();
        r e11 = cVar.e();
        TextView e12 = e11.e(R$id.item_margin_balance_symbol_name);
        TextView e13 = e11.e(R$id.item_margin_balance_basecurrency);
        TextView e14 = e11.e(R$id.item_margin_balance_quotecurrency);
        TextView e15 = e11.e(R$id.item_margin_balance_basecurrency_avaiable);
        TextView e16 = e11.e(R$id.item_margin_balance_quotecurrency_avaiable);
        TextView e17 = e11.e(R$id.item_margin_balance_basecurrency_loaned);
        TextView e18 = e11.e(R$id.item_margin_balance_quotecurrency_loaned);
        TextView e19 = e11.e(R$id.item_margin_balance_estimate);
        TextView e21 = e11.e(R$id.tv_frozen_amount_1);
        TextView e22 = e11.e(R$id.tv_frozen_amount_2);
        r rVar = e11;
        e12.setText(marginBalanceDetailInfo.getBaseCurrencyDisplayName() + "/" + marginBalanceDetailInfo.getQuoteCurrencyDisplayName());
        e13.setText(marginBalanceDetailInfo.getBaseCurrencyDisplayName());
        e14.setText(marginBalanceDetailInfo.getQuoteCurrencyDisplayName());
        if (p.u()) {
            String baseCurrency = marginBalanceDetailInfo.getBaseCurrency();
            String quoteCurrency = marginBalanceDetailInfo.getQuoteCurrency();
            e15.setText(p.j(marginBalanceDetailInfo.getBaseCurrencyAvaiable(), baseCurrency));
            e16.setText(p.j(marginBalanceDetailInfo.getQuoteCurrencyAvaiable(), quoteCurrency));
            e17.setText(p.j(marginBalanceDetailInfo.getBaseCurrencyLoaned(), baseCurrency));
            e18.setText(p.j(marginBalanceDetailInfo.getQuoteCurrencyLoaned(), quoteCurrency));
            e19.setText(context.getString(R$string.balance_margin_item_short_estimate, new Object[]{marginBalanceDetailInfo.getEstimateAmount(), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
            e21.setText(p.j(marginBalanceDetailInfo.getBaseCurrencyOnorders(), baseCurrency));
            e22.setText(p.j(marginBalanceDetailInfo.getQuoteCurrencyOnorders(), quoteCurrency));
        } else {
            String string = resources.getString(R$string.balance_hide_star);
            e15.setText(string);
            e16.setText(string);
            e17.setText(string);
            e18.setText(string);
            e19.setText(string);
            e21.setText(string);
            e22.setText(string);
        }
        view.setTag(R$id.item_data, marginBalanceDetailInfo2);
        view.setOnClickListener(this);
        b(marginBalanceDetailInfo2, resources, rVar);
    }

    public int getResId() {
        return R$layout.item_margin_balance_detail;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (!p.d(view.getContext())) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        MarginBalanceDetailInfo marginBalanceDetailInfo = (MarginBalanceDetailInfo) view.getTag(R$id.item_data);
        AssetModuleConfig.a().a0(view.getContext(), marginBalanceDetailInfo);
        AssetModuleConfig.a().l0("230", marginBalanceDetailInfo.getSymbol());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

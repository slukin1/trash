package com.huobi.finance.viewhandler;

import al.p;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bl.g2;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.C2CMarginBalanceDetailInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Locale;
import s9.c;

public class C2cMarginBalanceViewAdapter implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void e(Context context, C2CMarginBalanceDetailInfo c2CMarginBalanceDetailInfo, View view) {
        if (!p.d(view.getContext())) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        d.b("click c2c item.");
        AssetModuleConfig.a().S(context, c2CMarginBalanceDetailInfo);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String c(String str) {
        return m.u0(str, 12, 8);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, C2CMarginBalanceDetailInfo c2CMarginBalanceDetailInfo, ViewGroup viewGroup) {
        v9.c cVar2 = cVar;
        C2CMarginBalanceDetailInfo c2CMarginBalanceDetailInfo2 = c2CMarginBalanceDetailInfo;
        View view = cVar2.itemView;
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
        Locale locale = Locale.US;
        View view2 = view;
        e12.setText(String.format(locale, "%s/%s", new Object[]{c2CMarginBalanceDetailInfo.getBaseCurrencyDisplayName(), c2CMarginBalanceDetailInfo.getQuoteCurrencyDisplayName()}));
        e13.setText(c2CMarginBalanceDetailInfo.getBaseCurrencyDisplayName());
        e14.setText(c2CMarginBalanceDetailInfo.getQuoteCurrencyDisplayName());
        if (c2CMarginBalanceDetailInfo.isShow()) {
            e15.setText(m.u0(c2CMarginBalanceDetailInfo.getBaseCurrencyAvaiable(), 12, 8));
            e16.setText(m.u0(c2CMarginBalanceDetailInfo.getQuoteCurrencyAvaiable(), 12, 8));
            e17.setText(m.u0(c2CMarginBalanceDetailInfo.getBaseCurrencyLoaned(), 12, 8));
            e18.setText(m.u0(c2CMarginBalanceDetailInfo.getQuoteCurrencyLoaned(), 12, 8));
            String estimateAmount = c2CMarginBalanceDetailInfo.getEstimateAmount();
            if (m.a(estimateAmount).compareTo(BigDecimal.ZERO) == 0) {
                estimateAmount = "0.00";
            }
            e19.setText(context.getString(R$string.balance_margin_item_short_estimate, new Object[]{estimateAmount, LegalCurrencyConfigUtil.y().toUpperCase(locale)}));
            e21.setText(c(c2CMarginBalanceDetailInfo.getBaseCurrencyOnorders()));
            e22.setText(c(c2CMarginBalanceDetailInfo.getQuoteCurrencyOnorders()));
        } else {
            String string = cVar2.itemView.getResources().getString(R$string.balance_hide_star);
            e15.setText(string);
            e16.setText(string);
            e17.setText(string);
            e18.setText(string);
            e19.setText(string);
            e21.setText(string);
            e22.setText(string);
        }
        View view3 = view2;
        C2CMarginBalanceDetailInfo c2CMarginBalanceDetailInfo3 = c2CMarginBalanceDetailInfo;
        view3.setTag(R$id.item_data, c2CMarginBalanceDetailInfo3);
        view3.setOnClickListener(new g2(context, c2CMarginBalanceDetailInfo3));
    }

    public int getResId() {
        return R$layout.item_c2c_margin_balance_detail;
    }
}

package com.huobi.finance.viewhandler;

import al.p;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bl.a3;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.SavingsDetailInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.util.Locale;
import s9.c;

public class SavingsBalanceViewAdapter implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void f(Context context, SavingsDetailInfo savingsDetailInfo, View view) {
        if (!p.d(context)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        AssetModuleConfig.a().r(view.getContext(), savingsDetailInfo);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String c(String str) {
        return m.u0(str, 12, 8);
    }

    public final String d(SavingsDetailInfo savingsDetailInfo) {
        return savingsDetailInfo.getEstimateAmount();
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, SavingsDetailInfo savingsDetailInfo, ViewGroup viewGroup) {
        View view = cVar.itemView;
        Context context = view.getContext();
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.tv_available);
        TextView textView2 = (TextView) e11.b(R$id.tv_frozen_sum);
        TextView textView3 = (TextView) e11.b(R$id.tv_estimate_content);
        TextView textView4 = (TextView) e11.b(R$id.tv_estimate_label);
        ((TextView) e11.b(R$id.tv_title)).setText(StringUtils.i(savingsDetailInfo.getCurrency()));
        if (savingsDetailInfo.isShow()) {
            textView.setText(c(savingsDetailInfo.getAvaialAble()));
            textView2.setText(c(m.a(savingsDetailInfo.getLending()).toPlainString()));
            String upperCase = LegalCurrencyConfigUtil.y().toUpperCase(Locale.US);
            textView4.setText(context.getString(R$string.n_balance_equivalent_ph, new Object[]{StringUtils.i(upperCase)}));
            textView3.setText(d(savingsDetailInfo));
        } else {
            String string = cVar.itemView.getResources().getString(R$string.balance_hide_star);
            textView.setText(string);
            textView2.setText(string);
            textView3.setText(string);
        }
        view.setTag(R$id.item_data, savingsDetailInfo);
        view.setOnClickListener(new a3(context, savingsDetailInfo));
    }

    public int getResId() {
        return R$layout.item_savings_balance_detail;
    }
}

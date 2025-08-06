package com.huobi.supermargin.viewhandler;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.supermargin.bean.MarginCurrency;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import ns.b;
import s9.c;

public class MarginCurrencyViewHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(MarginCurrency marginCurrency, View view) {
        if (view.getContext() instanceof Activity) {
            Activity activity = (Activity) view.getContext();
            Intent intent = new Intent();
            intent.putExtra("coin", marginCurrency);
            intent.putExtra(Constants.FLAG_ACCOUNT, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
            activity.setResult(-1, intent);
            activity.finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, MarginCurrency marginCurrency, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R$id.symbol_name);
        textView.setText(StringUtils.i(marginCurrency.getCurrency()));
        textView.setOnClickListener(new b(marginCurrency));
    }

    public int getResId() {
        return R$layout.item_symbol_choose;
    }
}

package com.huobi.supermargin.viewhandler;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huobi.supermargin.bean.LoanCurrency;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import pro.huobi.R;
import s9.c;

public class LoanCurrencyViewHandler implements c {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LoanCurrency f81495b;

        public a(LoanCurrency loanCurrency) {
            this.f81495b = loanCurrency;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (view.getContext() instanceof Activity) {
                Activity activity = (Activity) view.getContext();
                Intent intent = new Intent();
                intent.putExtra(FirebaseAnalytics.Param.CURRENCY, this.f81495b.getCurrency());
                activity.setResult(-1, intent);
                activity.finish();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, LoanCurrency loanCurrency, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R.id.tv_currency);
        textView.setText(k.C().z(loanCurrency.getCurrency()));
        textView.setOnClickListener(new a(loanCurrency));
    }

    public int getResId() {
        return R.layout.item_coin_choose;
    }
}

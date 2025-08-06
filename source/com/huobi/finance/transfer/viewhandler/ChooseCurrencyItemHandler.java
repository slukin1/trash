package com.huobi.finance.transfer.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huobi.finance.transfer.bean.ChooseCurrencyItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import s9.c;
import zk.a;

public class ChooseCurrencyItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(ChooseCurrencyItem chooseCurrencyItem, View view) {
        chooseCurrencyItem.notifyCallback();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, ChooseCurrencyItem chooseCurrencyItem, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.itemView;
        textView.setText(chooseCurrencyItem.getName());
        textView.setOnClickListener(new a(chooseCurrencyItem));
    }

    public int getResId() {
        return R.layout.list_item_choose_currency;
    }
}

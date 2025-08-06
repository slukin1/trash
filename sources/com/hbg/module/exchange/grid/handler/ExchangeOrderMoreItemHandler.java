package com.hbg.module.exchange.grid.handler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.c;
import vc.b;
import xc.a;

public class ExchangeOrderMoreItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R$id.order_more_tv);
        textView.setTag(aVar);
        textView.setOnClickListener(this);
    }

    public int getResId() {
        return R$layout.layout_item_exchange_order_more;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = (a) view.getTag();
        b.a().e(view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

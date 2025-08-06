package com.huobi.tradenew.handler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huobi.order.ui.TradeOrderActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import s9.c;
import ws.f;

public class TradeOrderMoreItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, f fVar, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R.id.order_more_tv);
        textView.setTag(fVar);
        textView.setOnClickListener(this);
    }

    public int getResId() {
        return R.layout.item_order_more;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        f fVar = (f) view.getTag();
        if (fVar != null) {
            int i11 = 0;
            int i12 = fVar.d() == 2 ? 1 : 0;
            if (fVar.c() == 2) {
                i11 = 2;
            } else if (fVar.c() == 1) {
                i11 = 1;
            }
            TradeOrderActivity.Hi(view.getContext(), fVar.f(), (String) null, i11, i12);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

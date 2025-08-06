package com.hbg.lite.account.viewhanlder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import s9.c;
import ta.a;

public class LitePricingMethodItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        if (cVar != null && aVar != null) {
            r e11 = cVar.e();
            TextView textView = (TextView) e11.b(R$id.id_pricing_method_item_title);
            View b11 = e11.b(R$id.id_pricing_method_item_icon);
            cVar.itemView.setTag(aVar);
            cVar.itemView.setOnClickListener(this);
            if (aVar.c() != null) {
                textView.setText(aVar.c().a(aVar.d()));
                b11.setVisibility((aVar.c() == null || !aVar.c().s(aVar.d())) ? 8 : 0);
            }
        }
    }

    public int getResId() {
        return R$layout.layout_lite_pricing_method_item;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = (a) view.getTag();
        if (!(aVar == null || aVar.c() == null)) {
            aVar.c().onItemClick(aVar.d());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

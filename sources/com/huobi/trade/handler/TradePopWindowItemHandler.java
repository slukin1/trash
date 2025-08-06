package com.huobi.trade.handler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;
import ws.g;

public class TradePopWindowItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, g gVar, ViewGroup viewGroup) {
        cVar.itemView.setTag(gVar);
        cVar.itemView.setOnClickListener(this);
        r e11 = cVar.e();
        ((ImageView) e11.b(R.id.id_contract_trade_popwindow_item_img)).setImageResource(gVar.d());
        ((TextView) e11.b(R.id.id_contract_trade_popwindow_item_name)).setText(gVar.f());
    }

    public int getResId() {
        return R.layout.list_item_trade_popwindow;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        g gVar = (g) view.getTag();
        if (!(gVar == null || gVar.c() == null)) {
            gVar.c().a(gVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

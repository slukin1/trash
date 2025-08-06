package com.huobi.main.trade.viewhandler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bo.a;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;

public class OtcPriceItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        Context context = cVar.itemView.getContext();
        cVar.itemView.setTag(aVar);
        cVar.itemView.setOnClickListener(this);
        if (aVar.c().b(aVar)) {
            cVar.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.global_module_focus_bg));
        } else {
            cVar.itemView.setBackgroundResource(0);
        }
        r e11 = cVar.e();
        ((TextView) e11.b(R.id.id_trade_otc_price_title)).setText(OtcMarketPriceConfigUtil.c(aVar.e().getCoinId()));
        ((TextView) e11.b(R.id.id_trade_otc_price_money)).setText(aVar.d() + " " + aVar.e().getPrice());
    }

    public int getResId() {
        return R.layout.list_item_trade_otc_price;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = (a) view.getTag();
        if (!(aVar == null || aVar.c() == null)) {
            aVar.c().d(aVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

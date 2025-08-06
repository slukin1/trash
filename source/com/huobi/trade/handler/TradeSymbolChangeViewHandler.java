package com.huobi.trade.handler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bt.p2;
import com.huobi.trade.bean.TradeSymbolChangeItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;

public class TradeSymbolChangeViewHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(TradeSymbolChangeItem tradeSymbolChangeItem, View view) {
        if (tradeSymbolChangeItem.c() != null) {
            tradeSymbolChangeItem.c().onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, TradeSymbolChangeItem tradeSymbolChangeItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        TextView textView = (TextView) e11.b(R.id.trade_symbol_name_tv);
        textView.setText(tradeSymbolChangeItem.e());
        if (tradeSymbolChangeItem.f()) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.baseColorMajorTheme100));
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R.color.baseColorPrimaryText));
        }
        cVar.itemView.setTag(R.id.item_data1, tradeSymbolChangeItem);
        cVar.itemView.setOnClickListener(new p2(tradeSymbolChangeItem));
    }

    public int getResId() {
        return R.layout.layout_trade_symbol_change;
    }
}

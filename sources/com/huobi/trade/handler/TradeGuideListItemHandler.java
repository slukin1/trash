package com.huobi.trade.handler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bt.d2;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;
import ws.e;

public class TradeGuideListItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(e eVar, int i11, View view) {
        if (!(eVar == null || eVar.c() == null)) {
            eVar.c().N3(eVar, i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, e eVar, ViewGroup viewGroup) {
        cVar.itemView.setTag(eVar);
        cVar.itemView.setOnClickListener(new d2(eVar, i11));
        r e11 = cVar.e();
        ImageView imageView = (ImageView) e11.b(R.id.id_trade_guide_dialog_index);
        TextView textView = (TextView) e11.b(R.id.id_trade_guide_dialog_title);
        TextView textView2 = (TextView) e11.b(R.id.id_trade_guide_dialog_desc);
        ImageView imageView2 = (ImageView) e11.b(R.id.id_trade_guide_dialog_image);
        View b11 = e11.b(R.id.id_trade_guide_dialog_line_start);
        View b12 = e11.b(R.id.id_trade_guide_dialog_line_end);
        int i12 = 0;
        int N6 = eVar.c() != null ? eVar.c().N6() : 0;
        imageView.setImageResource(i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? 0 : R.drawable.selector_trade_guide_dialog_list_item_index4 : R.drawable.selector_trade_guide_dialog_list_item_index3 : R.drawable.selector_trade_guide_dialog_list_item_index2 : R.drawable.selector_trade_guide_dialog_list_item_index1);
        imageView.setSelected(i11 == N6);
        textView.setText(eVar.e());
        textView2.setText(eVar.d());
        int itemCount = eVar.c() != null ? eVar.c().getItemCount() : 0;
        b11.setVisibility(i11 == 0 ? 4 : 0);
        if (i11 == itemCount - 1) {
            i12 = 4;
        }
        b12.setVisibility(i12);
        imageView2.setImageResource(i11 < N6 ? R.drawable.trading_complete : i11 == N6 ? R.drawable.trading_tocomplete : R.drawable.trading_waiting);
    }

    public int getResId() {
        return R.layout.list_item_trade_guide_dialog;
    }
}

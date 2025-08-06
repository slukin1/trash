package com.huobi.trade.handler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bt.g0;
import com.huobi.trade.bean.DepthItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;

public class DepthViewHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(DepthItem depthItem, int i11, View view) {
        depthItem.c().a(depthItem.g(), depthItem.e(), i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, DepthItem depthItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        TextView textView = (TextView) e11.b(R.id.item_depth_tv);
        textView.setText(depthItem.e());
        if (depthItem.h()) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.global_huobi_color));
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R.color.global_main_text_color));
        }
        if (depthItem.c() != null) {
            cVar.itemView.setOnClickListener(new g0(depthItem, i11));
        }
    }

    public int getResId() {
        return R.layout.item_depth;
    }
}

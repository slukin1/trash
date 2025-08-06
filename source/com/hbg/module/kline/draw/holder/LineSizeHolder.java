package com.hbg.module.kline.draw.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.c;
import yd.a;

public class LineSizeHolder implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(a aVar, View view) {
        if (aVar.c() != null) {
            aVar.c().onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) cVar.itemView.findViewById(R$id.drawLineSizeIcon);
        imageView.setSelected(aVar.e());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.height = aVar.d().getSize();
        imageView.setLayoutParams(layoutParams);
        cVar.itemView.setTag(aVar);
        cVar.itemView.setOnClickListener(new zd.a(aVar));
    }

    public int getResId() {
        return R$layout.kline_draw_line_size_item_layout;
    }
}

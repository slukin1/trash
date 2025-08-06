package com.hbg.module.kline.draw.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.draw.LineStyleEnum;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.c;
import yd.b;

public class LineStyleHolder implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(b bVar, View view) {
        if (bVar.c() != null) {
            bVar.c().onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) cVar.itemView.findViewById(R$id.drawLineSizeIcon);
        imageView.setSelected(bVar.e());
        imageView.setImageResource(LineStyleEnum.getIconResourceId(cVar.itemView.getContext(), bVar.d()));
        cVar.itemView.setTag(bVar);
        cVar.itemView.setOnClickListener(new zd.b(bVar));
    }

    public int getResId() {
        return R$layout.kline_draw_line_style_item_layout;
    }
}

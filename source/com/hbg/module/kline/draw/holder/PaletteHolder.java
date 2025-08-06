package com.hbg.module.kline.draw.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.c;

public class PaletteHolder implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(yd.c cVar, View view) {
        if (cVar.d() != null) {
            cVar.d().onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, yd.c cVar2, ViewGroup viewGroup) {
        cVar.itemView.setSelected(cVar2.e());
        ((ImageView) cVar.itemView.findViewById(R$id.paletteColorImage)).setImageResource(cVar2.c().getDrawableId());
        cVar.itemView.setTag(cVar2);
        cVar.itemView.setOnClickListener(new zd.c(cVar2));
    }

    public int getResId() {
        return R$layout.kline_draw_line_edit_palette_item_layout;
    }
}

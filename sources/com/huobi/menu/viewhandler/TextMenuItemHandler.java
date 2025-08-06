package com.huobi.menu.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import io.d;
import pro.huobi.R;
import s9.c;

public class TextMenuItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, d dVar, ViewGroup viewGroup) {
        cVar.itemView.setTag(dVar);
        cVar.itemView.setOnClickListener(this);
        ((ImageView) cVar.e().b(R.id.id_menu_text_img)).setImageResource(dVar.g());
        ((TextView) cVar.e().b(R.id.id_menu_text_tv)).setText(dVar.i());
    }

    public int getResId() {
        return R.layout.list_item_menu_text;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        io.c cVar = (io.c) view.getTag();
        if (!(cVar == null || cVar.a() == null)) {
            cVar.a().o7(cVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

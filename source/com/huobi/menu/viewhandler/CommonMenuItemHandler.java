package com.huobi.menu.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import s9.c;

public class CommonMenuItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, io.c cVar2, ViewGroup viewGroup) {
        cVar.itemView.setTag(cVar2);
        cVar.itemView.setOnClickListener(this);
        ((ImageView) cVar.itemView).setImageResource(cVar2.g());
    }

    public int getResId() {
        return R.layout.list_item_menu_default;
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

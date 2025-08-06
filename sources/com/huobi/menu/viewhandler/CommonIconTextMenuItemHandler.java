package com.huobi.menu.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import io.b;
import pro.huobi.R;
import s9.c;

public class CommonIconTextMenuItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        cVar.itemView.setTag(bVar);
        cVar.itemView.setOnClickListener(this);
        TextView textView = (TextView) cVar.itemView;
        textView.setText(bVar.h());
        textView.setCompoundDrawablesWithIntrinsicBounds(bVar.g(), 0, 0, 0);
    }

    public int getResId() {
        return R.layout.list_item_icon_text_menu_layout;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        b bVar = (b) view.getTag();
        if (!(bVar == null || bVar.a() == null)) {
            bVar.a().o7(bVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
